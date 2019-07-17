package com.example.testapp.githubbrowsersampleclone.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.testapp.githubbrowsersampleclone.repository.RepoRepository
import com.example.testapp.githubbrowsersampleclone.util.AbsentLiveData
import com.example.testapp.githubbrowsersampleclone.vo.Repo
import com.example.testapp.githubbrowsersampleclone.vo.Resource
import com.example.testapp.githubbrowsersampleclone.vo.Status
import java.util.*
import javax.inject.Inject

class SearchViewModel @Inject constructor(repoRepository: RepoRepository): ViewModel() {

    private val _query = MutableLiveData<String>()
    private val nextPageHandler = NextPageHandler(repoRepository)

    val query: LiveData<String> = _query

    val results: LiveData<Resource<List<Repo>>> = Transformations.switchMap(_query) { search ->
        if (search.isNullOrBlank()) {
            AbsentLiveData.create()
        }
        else {
            repoRepository.search(search)
        }
    }

    val loadModeStatus: LiveData<LoadMoreState>
        get() = nextPageHandler.loadMoreState

    fun setQuery(originalInput: String) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == _query.value) {
            return
        }
        nextPageHandler.reset()
        _query.value = input
    }

    fun loadNextPage() {
        _query.value?.let {
            if (it.isNotBlank()) {
                nextPageHandler.queryNextPage(it)
            }
        }
    }

    fun reflesh() {
        _query.value?.let {
            _query.value = it
        }
    }

    class LoadMoreState(val isRunning: Boolean, val errorMessage: String?) {
        private var handleError = false

        val errorMessageifNotHandled: String?
            get() {
                if (handleError) {
                    return null
                }
                handleError = true
                return errorMessage
            }
    }

    class NextPageHandler(private val repository: RepoRepository): Observer<Resource<Boolean>> {
        private var nextPageLiveData: LiveData<Resource<Boolean>>? = null
        val loadMoreState = MutableLiveData<LoadMoreState>()
        private var query: String? = null
        private var _hasMore: Boolean = false
        val hasMore
            get() = _hasMore

        init {
            reset()
        }

        fun queryNextPage(query: String) {
            if (this.query == query) {
                return
            }
            unregister()
            this.query = query
            nextPageLiveData = repository.searchNextPage(query)
            loadMoreState.value = LoadMoreState(
                isRunning = true,
                errorMessage = null
            )
        }

        override fun onChanged(result: Resource<Boolean>?) {
            if (result == null) {
                reset()
            }
            else {
                when (result.status) {
                    Status.SUCCESS -> {
                        _hasMore = result.data == true
                        unregister()
                        loadMoreState.setValue(
                            LoadMoreState(
                                isRunning = false,
                                errorMessage = null
                            )
                        )
                    }
                    Status.ERROR -> {
                        _hasMore = true
                        unregister()
                        loadMoreState.setValue(
                            LoadMoreState(
                                isRunning = false,
                                errorMessage = result.message
                            )
                        )
                    }
                    Status.LOADING -> {
                        // ignore
                    }
                }
            }
        }

        private fun unregister () {
            nextPageLiveData?.removeObserver(this)
            nextPageLiveData = null
            if (_hasMore) {
                query = null
            }
        }

        fun reset() {
            unregister()
            _hasMore = true
            loadMoreState.value = LoadMoreState(
                isRunning = false,
                errorMessage = null
            )
        }
    }

}
package com.example.testapp.githubbrowsersampleclone.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.testapp.githubbrowsersampleclone.repository.RepoRepository
import com.example.testapp.githubbrowsersampleclone.repository.UserRepository
import com.example.testapp.githubbrowsersampleclone.util.AbsentLiveData
import com.example.testapp.githubbrowsersampleclone.vo.Repo
import com.example.testapp.githubbrowsersampleclone.vo.Resource
import com.example.testapp.githubbrowsersampleclone.vo.User
import javax.inject.Inject

class UserViewModel
@Inject constructor(userRepository: UserRepository, repoRepository: RepoRepository) : ViewModel() {
    private val _login = MutableLiveData<String>()
    val login: LiveData<String>
        get() = _login
    val repositories: LiveData<Resource<List<Repo>>> = Transformations
        .switchMap(_login) { login ->
            if (login == null) {
                AbsentLiveData.create()
            } else {
                repoRepository.loadRepos(login)
            }
        }
    val user: LiveData<Resource<User>> = Transformations
        .switchMap(_login) { login ->
            if (login == null) {
                AbsentLiveData.create()
            } else {
                userRepository.loadUser(login)
            }
        }

    fun setLogin(login: String?) {
        if (_login.value != login) {
            _login.value = login
        }
    }

    fun retry() {
        _login.value?.let {
            _login.value = it
        }
    }
}

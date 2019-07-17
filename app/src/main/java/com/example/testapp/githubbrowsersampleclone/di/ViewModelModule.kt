package com.example.testapp.githubbrowsersampleclone.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.githubbrowsersampleclone.ui.repo.RepoViewModel
import com.example.testapp.githubbrowsersampleclone.ui.search.SearchViewModel
import com.example.testapp.githubbrowsersampleclone.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    abstract fun bindRepoViewModel(repoViewModel: RepoViewModel): ViewModel

//    @Binds
//    abstract fun bindViewModelFactory(factory: GithubViewModelFactory): ViewModelProvider.Factory

}
package com.example.testapp.githubbrowsersampleclone.repository

import androidx.lifecycle.LiveData
import com.example.testapp.githubbrowsersampleclone.AppExecutors
import com.example.testapp.githubbrowsersampleclone.api.ApiResponse
import com.example.testapp.githubbrowsersampleclone.api.GithubService
import com.example.testapp.githubbrowsersampleclone.db.UserDao
import com.example.testapp.githubbrowsersampleclone.vo.Resource
import com.example.testapp.githubbrowsersampleclone.vo.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository that handles User objects.
 */
@Singleton
class UserRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val userDao: UserDao,
    private val githubService: GithubService
) {
    fun loadUser(login: String): LiveData<Resource<User>> {
        return object: NetworkBoundResource<User, User>(appExecutors) {
            override fun saveCallResult(item: User) {
                userDao.insert(item)
            }

            override fun shouldFetch(data: User?): Boolean = data == null

            override fun loadFromDb(): LiveData<User> = userDao.findByLogin(login)

            override fun createCall(): LiveData<ApiResponse<User>> = githubService.getUser(login)
        }.asLiveData()
    }
}
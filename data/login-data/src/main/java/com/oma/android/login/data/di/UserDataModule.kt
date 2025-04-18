package com.oma.android.login.data.di

import com.oma.android.login.data.repo.UserRepo
import com.oma.android.login.data.repo.UserRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserDataModule {
    @Binds
    @Singleton
    abstract fun bindsUserRepo(userRepoImpl: UserRepoImpl): UserRepo
}
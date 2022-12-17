package com.example.qumi.di

import com.example.qumi.data.repository.QumiRepositoryImpl
import com.example.qumi.domain.repository.QumiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// We will use dependency injection to provide the repository,database and datastore objects to other classes while still following
// the singleton principal

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQumiRepository() : QumiRepository {
        return QumiRepositoryImpl()
    }
}
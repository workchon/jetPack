package com.example.jetpack.di

import android.app.Application
import com.example.jetpack.data.manager.LocalUserManagerImpl
import com.example.jetpack.domain.manager.LocalUserManager
import com.example.jetpack.domain.usecase.AppEntryUseCase
import com.example.jetpack.domain.usecase.ReadAppEntry
import com.example.jetpack.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserManger: LocalUserManager
    ): AppEntryUseCase = AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}
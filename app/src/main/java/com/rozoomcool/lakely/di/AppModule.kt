package com.rozoomcool.lakely.di

import android.content.Context
import com.rozoomcool.lakely.data.repository.AppRepository
import com.rozoomcool.lakely.data.repository.AppRepositoryImpl
import com.rozoomcool.lakely.data.source.AppDataSource
import com.rozoomcool.lakely.domain.useCase.GetInstalledAppsUseCase
import com.rozoomcool.lakely.domain.useCase.LaunchAppUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDataSource(@ApplicationContext context: Context) = AppDataSource(context)

    @Provides
    @Singleton
    fun provideAppRepository(appDataSource: AppDataSource): AppRepository =
        AppRepositoryImpl(appDataSource)

    @Provides
    @Singleton
    fun provideGetInstalledAppsUseCase(appRepository: AppRepository) =
        GetInstalledAppsUseCase(appRepository)

    @Provides
    @Singleton
    fun provideLaunchAppUseCase(@ApplicationContext context: Context) =
        LaunchAppUseCase(context)
}
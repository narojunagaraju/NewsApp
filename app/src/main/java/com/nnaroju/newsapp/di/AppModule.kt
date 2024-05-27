package com.nnaroju.newsapp.di

import android.app.Application
import androidx.room.Room
import com.nnaroju.newsapp.data.local.NewsDao
import com.nnaroju.newsapp.data.local.NewsDatabase
import com.nnaroju.newsapp.data.local.NewsTypeConverter
import com.nnaroju.newsapp.data.manager.LocalUserManagerImpl
import com.nnaroju.newsapp.data.remote.NewsApi
import com.nnaroju.newsapp.data.repository.NewsRepositoryImpl
import com.nnaroju.newsapp.domain.manager.LocalUserManager
import com.nnaroju.newsapp.domain.respository.NewsRepository
import com.nnaroju.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.nnaroju.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.nnaroju.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.nnaroju.newsapp.domain.usecases.news.DeleteArticleUseCase
import com.nnaroju.newsapp.domain.usecases.news.GetNewsUseCase
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases
import com.nnaroju.newsapp.domain.usecases.news.SearchNewsUseCase
import com.nnaroju.newsapp.domain.usecases.news.SelectArticleUseCase
import com.nnaroju.newsapp.domain.usecases.news.SelectArticlesUseCase
import com.nnaroju.newsapp.domain.usecases.news.UpsertArticleUseCase
import com.nnaroju.newsapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository =
        NewsRepositoryImpl(newsApi = newsApi)

    @Provides
    @Singleton
    fun providesNewsUsesCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNewsUseCase(newsRepository),
            searchNews = SearchNewsUseCase(newsRepository),
            upsertArticleUseCase = UpsertArticleUseCase(newsDao),
            deleteArticleUseCase = DeleteArticleUseCase(newsDao),
            selectArticlesUseCase = SelectArticlesUseCase(newsDao),
            selectArticleUseCase = SelectArticleUseCase(newsDao)
        )
    }

    @Provides
    @Singleton
    fun providesNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = Constants.DATABASE_NAME
        )
            .addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesNewsDao(newsDatabase: NewsDatabase): NewsDao {
        return newsDatabase.newsDao
    }
}
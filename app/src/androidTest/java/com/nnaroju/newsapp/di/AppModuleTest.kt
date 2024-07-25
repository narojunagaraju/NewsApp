package com.nnaroju.newsapp.di

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nnaroju.newsapp.data.local.NewsDao
import com.nnaroju.newsapp.data.local.NewsDatabase
import com.nnaroju.newsapp.data.remote.NewsApi
import com.nnaroju.newsapp.domain.manager.LocalUserManager
import com.nnaroju.newsapp.domain.respository.NewsRepository
import com.nnaroju.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class AppModuleIntegrationTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var localUserManager: LocalUserManager

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    @Inject
    lateinit var newsApi: NewsApi

    @Inject
    lateinit var newsRepository: NewsRepository

    @Inject
    lateinit var newsUseCases: NewsUseCases

    @Inject
    lateinit var newsDatabase: NewsDatabase

    @Inject
    lateinit var newsDao: NewsDao

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testInjection() {
        assertNotNull(localUserManager)
        assertNotNull(appEntryUseCases)
        assertNotNull(newsApi)
        assertNotNull(newsRepository)
        assertNotNull(newsUseCases)
        assertNotNull(newsDatabase)
        assertNotNull(newsDao)
    }
}

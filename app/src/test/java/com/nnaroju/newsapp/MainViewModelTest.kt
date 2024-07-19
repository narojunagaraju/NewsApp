package com.nnaroju.newsapp

import com.nnaroju.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.nnaroju.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.nnaroju.newsapp.presentation.navgraph.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class MainViewModelTest {

    @Mock
    lateinit var appEntryUseCases: AppEntryUseCases

    private lateinit var mainViewModel: MainViewModel

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
    }

    @Test
    fun testMainViewModelLaunchWithReadAppEntryTrue() {
        val readAppEntry = Mockito.mock(ReadAppEntry::class.java)
        Mockito.`when`(appEntryUseCases.readAppEntry).thenReturn(readAppEntry)
        Mockito.`when`(readAppEntry.invoke()).thenReturn(flowOf(true))

        runTest {
            mainViewModel = MainViewModel(appEntryUseCases)
        }

        assertEquals(Route.NewsNavigation.route, mainViewModel.startDestination)
    }

    @Test
    fun testMainViewModelLaunchWithReadAppEntryFalse() {
        val readAppEntry = Mockito.mock(ReadAppEntry::class.java)
        Mockito.`when`(appEntryUseCases.readAppEntry).thenReturn(readAppEntry)
        Mockito.`when`(readAppEntry.invoke()).thenReturn(flowOf(false))

        runTest {
            mainViewModel = MainViewModel(appEntryUseCases)
        }

        assertEquals(Route.AppStartNavigation.route, mainViewModel.startDestination)
        assertEquals(false, mainViewModel.splashCondition)
    }

}
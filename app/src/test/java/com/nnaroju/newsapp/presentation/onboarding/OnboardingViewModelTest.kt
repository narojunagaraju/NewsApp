package com.nnaroju.newsapp.presentation.onboarding

import com.nnaroju.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.nnaroju.newsapp.domain.usecases.app_entry.SaveAppEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify


@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class OnboardingViewModelTest {

    @Mock
    lateinit var appEntryUseCases: AppEntryUseCases

    private lateinit var onboardingViewModel: OnboardingViewModel

    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockitoAnnotations.openMocks(this)
        onboardingViewModel = OnboardingViewModel(appEntryUseCases)
    }


    @After
    fun cleanUp() {
        Dispatchers.resetMain()
    }

    @Test
    fun testOnEventWithSaveAppEntry() {
        //Arrange
        val saveAppEntry = Mockito.mock(SaveAppEntry::class.java)
        Mockito.`when`(appEntryUseCases.saveAppEntry).thenReturn(saveAppEntry)

        //Act
        runTest {
            onboardingViewModel.onEvent(OnboardingEvent.SaveAppEntry)
        }

        //Assert
        verify(appEntryUseCases).saveAppEntry
    }
}
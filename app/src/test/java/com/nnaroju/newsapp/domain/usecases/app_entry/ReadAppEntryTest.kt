package com.nnaroju.newsapp.domain.usecases.app_entry

import com.nnaroju.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.flowOf
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.kotlin.verify

@RunWith(JUnit4::class)
class ReadAppEntryTest {


    @Test
    fun testInvoke() {
        val localUserManager = Mockito.mock(LocalUserManager::class.java)
        Mockito.`when`(localUserManager.readAppEntry()).thenReturn(flowOf(true))

        ReadAppEntry(localUserManager).invoke()

        verify(localUserManager).readAppEntry()
    }
}
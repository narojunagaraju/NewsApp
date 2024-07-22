package com.nnaroju.newsapp.domain.usecases.app_entry

import com.nnaroju.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.kotlin.verify

@RunWith(JUnit4::class)
class SaveAppEntryTest {

    @Test
    fun testInvoke() {
        val localUserManager = Mockito.mock(LocalUserManager::class.java)

        runTest {
            SaveAppEntry(localUserManager).invoke()
            verify(localUserManager).saveAppEntry()
        }

    }
}
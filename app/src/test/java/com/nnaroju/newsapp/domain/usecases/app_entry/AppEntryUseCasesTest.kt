package com.nnaroju.newsapp.domain.usecases.app_entry

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class AppEntryUseCasesTest {

    @Mock
    private lateinit var readAppEntry: ReadAppEntry

    @Mock
    private lateinit var saveAppEntry: SaveAppEntry

    private lateinit var appEntryUseCases: AppEntryUseCases

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        appEntryUseCases = AppEntryUseCases(readAppEntry, saveAppEntry)
    }

    @Test
    fun testReadAppEntry() {
        val readAppEntry = appEntryUseCases.readAppEntry
        assertNotNull(readAppEntry)
    }

    @Test
    fun testSaveAppEntry() {
        val saveAppEntry = appEntryUseCases.saveAppEntry
        assertNotNull(saveAppEntry)
    }

}
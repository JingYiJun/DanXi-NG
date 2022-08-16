package com.fduhole.danxinative.repository.fdu

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class LibraryRepositoryUnitTest {
    private val repo = LibraryRepository()

    @Test fun getHost() {
        assertEquals("http://10.55.101.62/book/show", repo.getHost())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test fun getLibraryAttendanceList() = runTest {
        val attendance = repo.getAttendanceList()
        assertEquals(6, attendance.size)
    }
}
package com.example.mygooglebook

import com.example.mygooglebook.Seach.SeachViewModel
import com.example.mygooglebook.remote.Repository
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class SeachViewModelTest {
    private val repository = mock(Repository::class.java)
    private val vm = SeachViewModel(repository)

    @Rule
    @JvmField
    val rule = InterruptedException()

    @Test
    fun seachViewModelTesting(){
        vm.seachBookStart("JAVA")
    }

}
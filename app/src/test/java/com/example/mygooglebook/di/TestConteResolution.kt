package com.example.mygooglebook.di

import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.koin.core.context.startKoin
import org.koin.test.KoinTest

@ExtendWith(InstantTaskExtension::class)
class TestConteResolution : KoinTest {

    @Test
    fun `dry run`(){
        startKoin{
            modules (listOf(
                remoteModule,
                apiModule,
                viewmodelModule
            ))
        }
    }

}
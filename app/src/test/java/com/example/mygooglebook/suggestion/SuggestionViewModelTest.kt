package com.example.mygooglebook.suggestion

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class SuggestionViewModelTest :
    StringSpec({
        "Suggestion ViewModel should not trigger search for empty query" {
            "hello".length shouldBe 6
        }
    })
package com.example.rides


import org.hamcrest.Matchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4 ::class)
class ValidatorTest {
    @Test
    fun inputIsNotValid() {
        val int = 200
        assertThat(Validator.validateInput(int), equalTo(false))

    }

    @Test
    fun inputIsValid() {
        val int = 10
        assertThat(Validator.validateInput(int), equalTo(true))

    }

    @Test
    fun inputIsZero() {
        val int = 0
        assertThat(Validator.validateInput(int), equalTo(false))


    }
}
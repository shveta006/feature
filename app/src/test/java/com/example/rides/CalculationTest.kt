package com.example.rides

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

class CalculationTest
{
    @RunWith(JUnit4 ::class)
    class ValidatorCal {


        @Test
        fun inputIsBelowRange() {
            val int = 4000
            val result=int*1
            MatcherAssert.assertThat(Calculation.calculations(result), Matchers.equalTo(true))


        }

        @Test
        fun inputIsZero() {
            val int = 0
            val result=int*1
            MatcherAssert.assertThat(Calculation.calculations(result), Matchers.equalTo(false))


        }

        @Test
        fun inputIsHigherRange() {
            val int = 7000
            val result=((int-5000)*1.5).toInt()+5000*1
            MatcherAssert.assertThat(Calculation.calculations(result), Matchers.equalTo(false))


        }
    }
}
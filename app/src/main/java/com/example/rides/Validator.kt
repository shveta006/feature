package com.example.rides

object Validator {

    fun validateInput(size: Int): Boolean {
        return (size in 1..100)

    }
}
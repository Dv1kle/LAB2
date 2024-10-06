package com.example.lab2

class CounterUtil {

    fun getWordCount(input: String): Int {
        return input.split("\\s+|\\.|,".toRegex()).filter { it.isNotBlank() }.size
    }

    fun getCharCount(input: String): Int {
        return input.length
    }
}

package edu.iesam.examaad1eval.features.ex2

sealed class ErrorApp{
    data class GenericError(val exception: Exception) : ErrorApp() {
        init {
            throw exception
        }
    }
}
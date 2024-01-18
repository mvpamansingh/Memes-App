package com.example.memesapp.FirstScreen.Presentation


sealed interface FirstScreenEvent {


    data class querychanged(val v :String):FirstScreenEvent

    object memeClicked:FirstScreenEvent
}
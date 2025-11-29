package com.fatherofapps.tinytracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
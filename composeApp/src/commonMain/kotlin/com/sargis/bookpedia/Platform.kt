package com.sargis.bookpedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
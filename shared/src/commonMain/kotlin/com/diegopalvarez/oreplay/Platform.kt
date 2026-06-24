package com.diegopalvarez.oreplay

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
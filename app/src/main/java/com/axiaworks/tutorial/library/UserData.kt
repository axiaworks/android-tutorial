package com.axiaworks.tutorial.library


data class UserData(
    val name : String,
    val gender: Int,
    val age: Int,
    val imageUrl: String,
    var effect: EffectType = EffectType.NORMAL
)

enum class EffectType {
    NORMAL,
    ROUNDED_CORNER,
    BLUR,
    TOON,
    CONTRAST,
}

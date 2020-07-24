package com.axiaworks.tutorial.library

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation

@BindingAdapter("userImage")
fun ImageView.userImage(userData: UserData) {
    when (userData.effect) {
        EffectType.ROUNDED_CORNER -> RequestOptions.bitmapTransform(RoundedCorners(30))
        EffectType.BLUR -> RequestOptions.bitmapTransform(BlurTransformation(25, 3))
        EffectType.TOON -> RequestOptions.bitmapTransform(ToonFilterTransformation(10.0f, 5.0f))
        EffectType.CONTRAST -> RequestOptions.bitmapTransform(ContrastFilterTransformation(1.8f))
        else -> null
    }?.let {
        Glide.with(this)
            .load(userData.imageUrl)
            .apply(it)
            .into(this)
    } ?: run {
        Glide.with(this)
            .load(userData.imageUrl)
            .centerCrop()
            .into(this)
    }
}

@BindingAdapter("setIconUrl")
fun ImageView.setIconUrl(url: String) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
        .into(this)
}

@BindingAdapter("gender")
fun TextView.gender(gender: Int) {
    text = if (gender == 0) "男性" else "女性"
}

@BindingAdapter("age")
fun TextView.age(age: Int) {
    text = age.toString()
}
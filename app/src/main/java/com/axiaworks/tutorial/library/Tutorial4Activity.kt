package com.axiaworks.tutorial.library

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.axiaworks.tutorial.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation

class Tutorial4Activity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, Tutorial4Activity::class.java)
        val userDataList = arrayListOf(
            UserData(
                "本田翼",
                1,
                28,
                "http://スマホ壁紙無料.com/wp-content/uploads/2019/09/hondatubasa-200-a.jpg"
            ),
            UserData(
                "新垣結衣",
                1,
                32,
                "http://スマホ壁紙無料.com/wp-content/uploads/2020/02/aragakiyui-248-a.jpg"
            ),
            UserData(
                "広瀬すず",
                1,
                22,
                "http://スマホ壁紙無料.com/wp-content/uploads/2020/06/hirosesuzu-227-a.jpg"
            ),
            UserData(
                "神谷えりな",
                +1,
                +28,
                "http://スマホ壁紙無料.com/wp-content/uploads/2015/02/kamiyaerina-09-a.jpg"
            )
        )
    }

    private var currentUserData: UserData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial4)

        findViewById<Button>(R.id.user1_button)?.setOnClickListener {
            setUserData(userDataList[0])
        }
        findViewById<Button>(R.id.user2_button)?.setOnClickListener {
            setUserData(userDataList[1])
        }
        findViewById<Button>(R.id.user3_button)?.setOnClickListener {
            setUserData(userDataList[2])
        }
        findViewById<Button>(R.id.user4_button)?.setOnClickListener {
            setUserData(userDataList[3])
        }

        findViewById<Button>(R.id.effect_normal_button)?.setOnClickListener {
            currentUserData?.let {
                it.effect = EffectType.NORMAL
                setUserData(it)
            }
        }
        findViewById<Button>(R.id.effect_corner_button)?.setOnClickListener {
            currentUserData?.let {
                it.effect = EffectType.ROUNDED_CORNER
                setUserData(it)
            }
        }
        findViewById<Button>(R.id.effect_blur_button)?.setOnClickListener {
            currentUserData?.let {
                it.effect = EffectType.BLUR
                setUserData(it)
            }
        }
        findViewById<Button>(R.id.effect_toon_button)?.setOnClickListener {
            currentUserData?.let {
                it.effect = EffectType.TOON
                setUserData(it)
            }
        }
        findViewById<Button>(R.id.effect_contrust_button)?.setOnClickListener {
            currentUserData?.let {
                it.effect = EffectType.CONTRAST
                setUserData(it)
            }
        }
    }

    private fun setUserData(userData: UserData) {
        currentUserData = userData
        findViewById<TextView>(R.id.name_text_view)?.text = userData.name
        findViewById<TextView>(R.id.age_text_view)?.text = userData.age.toString()
        findViewById<TextView>(R.id.gender_text_view)?.text = if (userData.gender == 0) "男性" else "女性"
        findViewById<ImageView>(R.id.image_view)?.apply {
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
            }?:run {
                Glide.with(this)
                    .load(userData.imageUrl)
                    .centerCrop()
                    .into(this)
            }
        }
    }

}
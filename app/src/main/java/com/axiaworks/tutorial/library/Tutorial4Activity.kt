package com.axiaworks.tutorial.library

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.ActivityTutorial4Binding

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
                1,
                28,
                "http://スマホ壁紙無料.com/wp-content/uploads/2015/02/kamiyaerina-09-a.jpg"
            )
        )
    }

    private lateinit var binding: ActivityTutorial4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityTutorial4Binding>(
            this,
            R.layout.activity_tutorial4
        ).apply {
            userData = userDataList[0]
            activity = this@Tutorial4Activity
        }
        supportActionBar?.apply {
            title = getString(R.string.main_study_library)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun onClickUser1() {
        binding.userData = userDataList[0]
    }

    fun onClickUser2() {
        binding.userData = userDataList[1]
    }

    fun onClickUser3() {
        binding.userData = userDataList[2]
    }

    fun onClickUser4() {
        binding.userData = userDataList[3]
    }

    fun onClickNormal() {
        binding.userData = binding.userData?.apply {
            effect = EffectType.NORMAL
        }
    }

    fun onClickCorner() {
        binding.userData = binding.userData?.apply {
            effect = EffectType.ROUNDED_CORNER
        }
    }

    fun onClickBlur() {
        binding.userData = binding.userData?.apply {
            effect = EffectType.BLUR
        }
    }

    fun onClickToon() {
        binding.userData = binding.userData?.apply {
            effect = EffectType.TOON
        }
    }

    fun onClickContrast() {
        binding.userData = binding.userData?.apply {
            effect = EffectType.CONTRAST
        }
    }

}
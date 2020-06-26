package com.axiaworks.tutorial.layout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.axiaworks.tutorial.Property
import com.axiaworks.tutorial.R

class Tutorial2Activity: AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, Tutorial2Activity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial2)

        findViewById<Button>(R.id.cancel_button)?.apply {
            setOnClickListener {
                finish()
            }
        }
        findViewById<Button>(R.id.register_button)?.apply {
            setOnClickListener {
                if (saveUserInfo()) {
                    finish()
                } else {
                    Toast.makeText(applicationContext, R.string.tutorial2_name_validation_error_black, Toast.LENGTH_SHORT).show()
                }
            }
        }
        findViewById<TextView>(R.id.title_text_view)?.apply {
            text = Property.name
        }
        findViewById<RadioGroup>(R.id.gender_group)?.apply {
            setOnCheckedChangeListener { _, checkedId ->
                val mainImageView = this@Tutorial2Activity.findViewById<ImageView>(R.id.main_image_view)?: return@setOnCheckedChangeListener
                when (checkedId) {
                    R.id.gender_boy_button -> mainImageView.setImageResource(R.drawable.character_boy_normal)
                    R.id.gender_girl_button -> mainImageView.setImageResource(R.drawable.character_girl_normal)
                    else -> mainImageView.setImageResource(R.drawable.character_boy_normal)
                }
            }
            when (Property.gender) {
                0 -> check(R.id.gender_boy_button)
                1 -> check(R.id.gender_girl_button)
                else -> check(R.id.gender_boy_button)
            }
        }
        findViewById<EditText>(R.id.name_edit_text)?.apply {
            if (Property.name != getString(R.string.tutorial2_name)) {
                setText(Property.name)
            }
        }


    }

    private fun saveUserInfo() :Boolean {
        val name = validateName() ?: return false
        val genderGroup = findViewById<RadioGroup>(R.id.gender_group)?: return false
        val gender: Int = when (genderGroup.checkedRadioButtonId) {
            R.id.gender_boy_button -> 0
            R.id.gender_girl_button -> 1
            else -> 0
        }

        Property.name = name
        Property.gender = gender
        return true
    }

    private fun validateName(): String? {
        val nameEditText = findViewById<EditText>(R.id.name_edit_text)?: return null
        val name : String = nameEditText.text.toString()

        if (name.trim().isBlank()) {
            return null
        }
        return name
    }

}
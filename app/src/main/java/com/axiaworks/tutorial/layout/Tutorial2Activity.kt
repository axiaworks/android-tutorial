package com.axiaworks.tutorial.layout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.axiaworks.tutorial.R

class Tutorial2Activity: AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, Tutorial2Activity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial2)


    }
}
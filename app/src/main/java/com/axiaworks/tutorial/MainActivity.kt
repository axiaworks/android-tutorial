package com.axiaworks.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.axiaworks.tutorial.layout.Tutorial2Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.tutorial2_button)?.apply {
            setOnClickListener {
                startActivity(Tutorial2Activity.callingIntent(applicationContext))
            }
        }
    }

}
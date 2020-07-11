package com.axiaworks.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.axiaworks.tutorial.adapter.Tutorial3Activity
import com.axiaworks.tutorial.fragment.Tutorial5Activity
import com.axiaworks.tutorial.layout.Tutorial2Activity
import com.axiaworks.tutorial.library.Tutorial4Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.tutorial2_button)?.apply {
            setOnClickListener {
                startActivity(Tutorial2Activity.callingIntent(applicationContext))
            }
        }
        findViewById<Button>(R.id.tutorial3_button)?.apply {
            setOnClickListener {
                startActivity(Tutorial3Activity.callingIntent(applicationContext))
            }
        }
        findViewById<Button>(R.id.tutorial4_button)?.apply {
            setOnClickListener {
                startActivity(Tutorial4Activity.callingIntent(applicationContext))
            }
        }
        findViewById<Button>(R.id.tutorial5_button)?.apply {
            setOnClickListener {
                startActivity(Tutorial5Activity.callingIntent(applicationContext))
            }
        }
    }

}
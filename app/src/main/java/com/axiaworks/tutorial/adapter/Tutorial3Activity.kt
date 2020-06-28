package com.axiaworks.tutorial.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.axiaworks.tutorial.R

class Tutorial3Activity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, Tutorial3Activity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial3)
        findViewById<Spinner>(R.id.food_type_spinner)?.apply {
            adapter = ArrayAdapter<String>(
                applicationContext,
                android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.tutorial3_food_type)
            )
        }
    }
}
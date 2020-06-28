package com.axiaworks.tutorial.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.tutorial.R

class Tutorial3Activity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, Tutorial3Activity::class.java)
    }

    private lateinit var imageRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial3)
        findViewById<Spinner>(R.id.food_type_spinner)?.apply {
            adapter = ArrayAdapter<String>(
                applicationContext,
                android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.tutorial3_food_type)
            )
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    imageRecyclerView.adapter = FoodImageAdapter(
                        when (position) {
                            0 -> getResIdList(R.array.tutorial3_image_id_list_all)
                            1 -> getResIdList(R.array.tutorial3_image_id_list_yasai)
                            2 -> getResIdList(R.array.tutorial3_image_id_list_fish)
                            3 -> getResIdList(R.array.tutorial3_image_id_list_niku)
                            else -> emptyList()
                        }
                    )
                }
            }
        }
        findViewById<RadioGroup>(R.id.layout_type_group)?.apply {
            setOnCheckedChangeListener { _, checkedId ->
                imageRecyclerView.layoutManager = when (checkedId) {
                    R.id.vertical_button -> LinearLayoutManager(
                        this@Tutorial3Activity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    R.id.horizontal_button -> LinearLayoutManager(
                        this@Tutorial3Activity,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    R.id.grid_button -> GridLayoutManager(
                        this@Tutorial3Activity,
                        2,
                        GridLayoutManager.VERTICAL,
                        false
                    )
                    else -> LinearLayoutManager(
                        this@Tutorial3Activity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                }
            }
        }
        findViewById<RecyclerView>(R.id.image_recycler_view)?.apply {
            layoutManager = LinearLayoutManager(
                this@Tutorial3Activity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = FoodImageAdapter(emptyList())
            imageRecyclerView = this
        }
    }

    private fun getResIdList(arrayId: Int): List<Int> {
        val ids = resources.obtainTypedArray(arrayId)
        val resIdList = mutableListOf<Int>()
        for (i in 0 until ids.length()) {
            resIdList.add(ids.getResourceId(i, -1))
        }
        ids.recycle()
        return resIdList
    }

}
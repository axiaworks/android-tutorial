package com.axiaworks.tutorial

import android.content.Context

object Property {
    lateinit var context: Context
    private const val FILE_NAME = "tutorial"

    private enum class Keys {
        NAME,
        GENDER
    }

    var name : String
        get() = getString(Keys.NAME, context.getString(R.string.tutorial2_name))
        set(value) {
            setString(Keys.NAME, value)
        }

    var gender: Int
        get() = getInt(Keys.GENDER, 0)
        set(value) {
            setInt(Keys.GENDER, value)
        }

    private fun getPref() = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    private fun getEditor() = getPref().edit()

    private fun getString(key: Keys, default: String) = getPref().getString(key.name, default) ?: default
    private fun setString(key: Keys, value: String) {
        getEditor().putString(key.name, value).commit()
    }

    private fun getInt(key: Keys, default: Int) = getPref().getInt(key.name, default)
    private fun setInt(key: Keys, value: Int) {
        getEditor().putInt(key.name, value).commit()
    }

}
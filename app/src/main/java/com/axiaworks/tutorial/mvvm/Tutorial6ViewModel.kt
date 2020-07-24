package com.axiaworks.tutorial.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axiaworks.tutorial.mvvm.repository.QiitaRepository
import com.axiaworks.tutorial.mvvm.response.QiitaItem
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class Tutorial6ViewModel : ViewModel(), KoinComponent {
    companion object {
        const val TAG = "Tutorial6ViewModel"
    }

    private val qiitaRepository: QiitaRepository by inject()

    val isProgress: LiveData<Boolean>
        get() = _isProgress
    private val _isProgress = MutableLiveData<Boolean>(false)
    val qiitaItems: LiveData<List<QiitaItem>>
        get() = _qiitaItems
    private val _qiitaItems = MutableLiveData<List<QiitaItem>>()

    fun fetchTagItems(tag: String) {
        _isProgress.value = true
        viewModelScope.launch {
            runCatching { qiitaRepository.fetchTagItems(tag) }
                .fold({
                    _qiitaItems.value = it
                    _isProgress.value = false
                }, {
                    Log.e(TAG, "error", it)
                    _isProgress.value = false
                })
        }
    }
}
package com.axiaworks.tutorial.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.ItemQiitaItemBinding
import com.axiaworks.tutorial.mvvm.response.QiitaItem

class QiitaItemAdapter(
    private var itemList: List<QiitaItem>
) : RecyclerView.Adapter<QiitaItemAdapter.ViewHolder>() {

    var onClickListener: ((QiitaItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_qiita_item, parent, false
            )
        )
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(itemList[position], onClickListener)
    }

    class ViewHolder(private val binding: ItemQiitaItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: QiitaItem, listener: ((QiitaItem)-> Unit)?) {
            binding.item = item
            binding.root.setOnClickListener {
                listener?.invoke(item)
            }
        }
    }

    fun setList(list: List<QiitaItem>) {
        itemList = list
        notifyDataSetChanged()
    }
}
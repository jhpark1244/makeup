package com.example.makeup01.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.makeup01.data.MakeUpTypeData
import com.example.makeup01.databinding.ItemMakeupTypeBinding
import java.lang.Exception

class MakeUpTypeAdapter : RecyclerView.Adapter<MakeUpTypeAdapter.ViewHolder>() {
    var selectedPosion = -1
    var itemClick:(Int, Int) -> Unit = {_,_ ->}
    val data:ArrayList<MakeUpTypeData> = arrayListOf()
    fun setData(arrayList: ArrayList<MakeUpTypeData>){
        data.clear()
        data.addAll(arrayList)
        notifyDataSetChanged()
    }
    fun reDrawItem(oldItem:Int, newItem:Int){
        try{notifyItemChanged(oldItem)} catch(_:Exception){}
        try{notifyItemChanged(newItem)} catch(_:Exception){}

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMakeupTypeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private val binding: ItemMakeupTypeBinding) : RecyclerView.ViewHolder(binding.root) {

        init{
            binding.root.setOnClickListener{
                itemClick(selectedPosion, adapterPosition)
            }

        }
        fun bind(data: MakeUpTypeData) {
            binding.ivImportant.isVisible = data.doImportant?:false
            binding.tvText.text =  data.text
            if(data.doSelected==true){
                binding.tvText.setTypeface(null, Typeface.BOLD)
                binding.llSelected.isVisible = true
            }else{
                binding.tvText.setTypeface(null, Typeface.NORMAL)
                binding.llSelected.isVisible=false
            }
        }


    }
}
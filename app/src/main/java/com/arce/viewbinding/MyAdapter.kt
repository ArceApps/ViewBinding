package com.arce.viewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arce.viewbinding.databinding.MyAdapterLanguageProgramBinding

/**
 * Created by ArceApps on 30/01/2022.
 * Project name: ViewBinding.
 */
class MyAdapter (private val list: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(layoutInflater.inflate(R.layout.my_adapter_language_program, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = MyAdapterLanguageProgramBinding.bind(view)
        fun bind(languageProgram: String){
            binding.tvLanguageProgram.text = languageProgram
        }
    }
}
package com.espanol.semifinalexam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.espanol.semifinalexam.databinding.ItemTweetBinding

class Adapter(private val context: Context) : RecyclerView.Adapter<Adapter.TweetViewHolder>() {
    private var dataList: List<Data> = emptyList()

    class TweetViewHolder(val binding: ItemTweetBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        return TweetViewHolder(ItemTweetBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        holder.binding.textName.text = dataList[position].name
        holder.binding.textDescription.text = dataList[position].description
        holder.binding.deleteImageButton.setOnClickListener {
            val intent = Intent(context, DeleteActivity::class.java)
            intent.putExtra("delete_id", dataList[position].id)
            context.startActivity(intent)
        }
        holder.binding.editImageButton.setOnClickListener {
            val intent = Intent(context, ModifyActivity::class.java)
            intent.putExtra("edit_id", dataList[position].id)
            intent.putExtra("edit_name", dataList[position].name)
            intent.putExtra("edit_description", dataList[position].description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun update(updatedList: List<Data>) {
        this.dataList = updatedList
        notifyDataSetChanged()
    }

}
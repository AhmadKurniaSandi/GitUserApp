package com.sandi.myapplication

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListGitAdapter(private val listGit: ArrayList<Git>) : RecyclerView.Adapter<ListGitAdapter.ListViewHolder>() {
    private lateinit var onItemClick: OnItemClick
    fun setOnItemClick(onItemClick: OnItemClick){
        this.onItemClick = onItemClick
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.imageView)
        var tvName: TextView = itemView.findViewById(R.id.textView)
        var tvUsername: TextView = itemView.findViewById(R.id.textView2)
        var tvCompany: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username, company, photo) = listGit[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .circleCrop()
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvUsername.text = username
        holder.tvCompany.text = company
        holder.itemView.setOnClickListener { onItemClick.onItemClicked((listGit[holder.adapterPosition]))}
    }

    override fun getItemCount(): Int {
        return listGit.size
    }
    interface OnItemClick {
        fun onItemClicked(data:Git)
    }
}
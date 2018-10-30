package com.weather.olenburg.weatherproject.ui.comment

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.olenburg.weatherproject.R
import com.weather.olenburg.weatherproject.model.Comment
import kotlinx.android.synthetic.main.cell_comment.view.*

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    private var data: ArrayList<Comment> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CommentAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_comment, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CommentAdapter.ViewHolder, position: Int) {
        val model: Comment = data[position]
        holder.itemView.name.text = model.name
        holder.itemView.email.text = model.email
        holder.itemView.body.text = model.body
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v)

    fun setCommentData(data: ArrayList<Comment>) {
        this.data = data
        notifyDataSetChanged()
    }
}
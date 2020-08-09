package com.example.krishna.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.krishna.R
import com.example.krishna.common.CircleTransform
import com.example.krishna.databinding.MovieitemviewBinding
import com.example.krishna.model.SearchItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception


class MoviesListAdapter(val mContext: Context, val moviesList: MutableList<SearchItem>, val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<MoviesListAdapter.ChildHolder>() {
    class ChildHolder(val view: MovieitemviewBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(user: SearchItem,clickListener: OnItemClickListener)
        {
            itemView.setOnClickListener {
                clickListener.onItemClicked(user)
            }
        }

        fun setData(movieObj: SearchItem) {
            view.movieItem=movieObj
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        val m :MovieitemviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.movieitemview,parent,false)
        return ChildHolder(m)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
        val movieObj = moviesList[position] as SearchItem
        holder.setData(movieObj)
        holder.bind(movieObj,itemClickListener)

}
    interface OnItemClickListener{
        fun onItemClicked(searchItem: SearchItem)
    }
}
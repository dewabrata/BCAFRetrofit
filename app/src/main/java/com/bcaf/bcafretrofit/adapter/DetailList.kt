package com.bcaf.bcafretrofit.adapter

import android.opengl.Visibility
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bcaf.bcafretrofit.R
import com.bcaf.bcafretrofit.model.OMDBDetailResponse
import com.bcaf.bcafretrofit.model.RatingsItem
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.*

class DetailList : RecyclerView.Adapter<DetailList.ViewHolder>() {

    var data: List<RatingsItem?> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RatingsItem?) = with(itemView) {

            itemView.txtJudulMovie.setText(item?.source)
            itemView.txtTahunMovie.setText(item?.value)
            posterMovie.visibility= View.INVISIBLE

        }
    }
}
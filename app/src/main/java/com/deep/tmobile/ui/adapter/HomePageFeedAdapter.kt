package com.deep.tmobile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deep.tmobile.R
import com.deep.tmobile.data.CardType

/**
 * Adapter class that will be used by recycler view
 */
class HomePageFeedAdapter : RecyclerView.Adapter<HomePageFeedViewHolder>() {

    /**
     * List of items for recyclerview
     */
    var items = ArrayList<CardType>()

    /**
     * Set items
     */
    fun setUpdatedData(items: ArrayList<CardType>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageFeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view_item, parent, false
        )
        return HomePageFeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomePageFeedViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
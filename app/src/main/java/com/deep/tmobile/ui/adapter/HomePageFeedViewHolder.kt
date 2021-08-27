package com.deep.tmobile.ui.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deep.tmobile.R
import com.deep.tmobile.data.CardType
import com.squareup.picasso.Picasso

/**
 * Class holds the feed view based on card type
 */
class HomePageFeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        /**
         * Types of cards view supports
         */
        const val TEXT = "text"
        const val TITLE_DESCRIPTION = "title_description"
        const val IMAGE_TITLE_DESCRIPTION = "image_title_description"
    }

    private val imageView = view.findViewById<ImageView>(R.id.imageView)
    private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    private val tvDesc = view.findViewById<TextView>(R.id.tvDesc)

    /**
     * Bind data to the view to be displayed in list
     */
    fun bind(data: CardType) {
        val cardType = data.card_type

        if (cardType == TEXT) {
            setTextViewText(
                tvTitle, data.card.value, data.card.attributes?.text_color,
                data.card.attributes?.font?.size
            )

        } else if (cardType == TITLE_DESCRIPTION) {

            setTextViewText(
                tvTitle, data.card.title?.value, data.card.title?.attributes?.text_color,
                data.card.title?.attributes?.font?.size
            )
            setTextViewText(
                tvDesc, data.card.description?.value, data.card.description?.attributes?.text_color,
                data.card.description?.attributes?.font?.size
            )

        } else if (cardType == IMAGE_TITLE_DESCRIPTION) {

            setTextViewText(
                tvTitle, data.card.title?.value, data.card.title?.attributes?.text_color,
                data.card.title?.attributes?.font?.size
            )
            setTextViewText(
                tvDesc, data.card.description?.value, data.card.description?.attributes?.text_color,
                data.card.description?.attributes?.font?.size
            )

            imageView.visibility = View.VISIBLE

            Picasso.get()
                .load(data.card.image?.url)
                .into(imageView)
        }
    }

    /**
     * Function to set data to text view
     */
    private fun setTextViewText(
        textView: TextView,
        title: String?,
        textColor: String?,
        textSize: Int?
    ) {
        textView.visibility = View.VISIBLE
        textView.text = title ?: ""
        textView.setTextColor(Color.parseColor(textColor))
        (textSize)?.let {
            textView.textSize = it.toFloat()
        }
    }
}
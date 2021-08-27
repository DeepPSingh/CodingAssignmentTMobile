package com.deep.tmobile.data

/**
 * Data classes used to de-serialize server response for the home page feed
 */
data class HomePageFeedDataClass(val page: Page)

data class Page(val cards: ArrayList<CardType>)

data class CardType(val card_type: String, val card: Card)

data class Card(
    val value: String?,
    val attributes: Attributes?,
    val title: Title?,
    val description: Description?,
    val image: Image?
)

data class Attributes(val text_color: String, val font: Font)

data class Font(val size: Int)

data class Title(val value: String, val attributes: Attributes)

data class Description(val value: String, val attributes: Attributes)

data class Image(val url: String, val size: Size)

data class Size(val width: Int, val height: Int)





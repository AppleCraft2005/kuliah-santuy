package com.android.modul4.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.android.modul4.data.sourceData
import com.android.modul4.models.CardProp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CardViewModel(private val dataSource: sourceData) : ViewModel() {
    private val _cardList = MutableStateFlow<List<CardProp>>(emptyList())
    val cardList: StateFlow<List<CardProp>> = _cardList

    private val _selectCard = MutableStateFlow<CardProp?>(null)
    val selectedCard: StateFlow<CardProp?> = _selectCard

    init { loadData() }

    private fun loadData() {
        val cards = dataSource.loadCardProps()
        _cardList.value = cards
        Log.d("CardViewMode","Card yang tampil ada ${cards.size} ")
    }
    fun getDetailByTitle(Title: String): CardProp? {
        return _cardList.value.find { it.title == Title }
    }
    fun selectCard(card: CardProp, name: String) {
        _selectCard.value = card
        Log.d("CardViewModel", "tombol ${name} ${card.title} ditekan")
    }
}

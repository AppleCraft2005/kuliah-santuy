package com.android.modul1

import kotlin.random.Random

fun randomDice(): Int {return Random.nextInt(1,7)}

fun diceImg(Dice1: Int, Dice2: Int): Pair<Int, Int> {
    var img1 = R.drawable.dice_0
    var img2 = R.drawable.dice_0

    when(Dice1) {
        1 -> img1 = R.drawable.dice_1
        2 -> img1 = R.drawable.dice_2
        3 -> img1 = R.drawable.dice_3
        4 -> img1 = R.drawable.dice_4
        5 -> img1 = R.drawable.dice_5
        6 -> img1 = R.drawable.dice_6
    }
    when(Dice2) {
        1 -> img2 = R.drawable.dice_1
        2 -> img2 = R.drawable.dice_2
        3 -> img2 = R.drawable.dice_3
        4 -> img2 = R.drawable.dice_4
        5 -> img2 = R.drawable.dice_5
        6 -> img2 = R.drawable.dice_6
    }
    return Pair(img1, img2)
}





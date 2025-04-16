package com.android.modul2

import android.widget.Switch
import kotlin.math.ceil
import kotlin.math.round


fun tipCalculator( nilai: Int,  opsi: String, switch: Boolean): Double{
    var hasil = 0.0;
    when(opsi){
        "Amazing" -> hasil =  nilai * 20.0/100.0
        "Good" -> hasil = nilai * 18.0/100.0
        "Okay" -> hasil = nilai * 16.0/100.0
    }
    if (switch) {hasil = ceil(hasil) }
    return hasil
}
fun main() {
    println(tipCalculator(52,"Good", true))
}
package com.example.casestudy.Class

import java.io.Serializable

data class DataClass(
    var id: Int = 0,
    var yemekFoto: String = "",
    var kisiFoto: String = "",
    var yemekAdi: String = "",
    var yemekSahibi: String = "",
    var yemekSuresi: Int = 0,
    var rating: Float = 0F,
    var sinif: String = ""
) : Serializable


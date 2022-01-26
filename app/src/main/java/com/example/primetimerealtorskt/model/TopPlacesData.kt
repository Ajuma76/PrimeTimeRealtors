package com.example.primetimerealtorskt.model

class TopPlacesData {
    var placeName: String = ""
    var countyName: String = ""
    var price: String = ""
    var imageUrl: String = ""

    constructor(placeName: String, countyName: String, price: String, imageUrl: String) {
        this.placeName = placeName
        this.countyName = countyName
        this.price = price
        this.imageUrl = imageUrl
    }
}

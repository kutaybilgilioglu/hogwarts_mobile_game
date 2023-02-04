package com.example.yazlab3

import android.widget.ImageView

class Card {
    var card_name:String = ""
    var points:String = ""
    //abstract var imgInterface:ImageView
    var house:String = ""
    var base64:String = ""
    constructor(card_name:String,points:String,house:String,base64:String){
        this.card_name = card_name
        this.points = points
        //this.imgInterface = imgInterface
        this.house = house
        this.base64 = base64
    }
}
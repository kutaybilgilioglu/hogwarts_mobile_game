package com.example.yazlab3

import android.graphics.Bitmap
import android.widget.ImageView

class Card_Game {
    var card_name:String = ""
        get() = field
        set(value){
            field = value
        }
    var points:Int? = null
        get() = field
        set(value){
            field = value
        }
    var imgInterface1: ImageView? = null
        get() = field
        set(value){
            field = value
        }
    var imgInterface2: ImageView? = null
        get() = field
        set(value){
            field = value
        }

    var house:String = ""
        get() = field
        set(value){
            field = value
        }
    var base64:String = ""
        get() = field
        set(value){
            field = value
        }
    var image:Bitmap? = null
        get() = field
        set(value){
            field = value
        }
    var clicked1:Boolean = false
    var clicked2:Boolean = false


}
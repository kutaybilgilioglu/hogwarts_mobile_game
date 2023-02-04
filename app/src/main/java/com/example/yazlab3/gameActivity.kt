package com.example.yazlab3

import android.content.Intent
import android.graphics .Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Base64
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

import kotlin.random.Random


class gameActivity : AppCompatActivity() {
    var score = 0
    var backImage:Bitmap? = null
    var clicked = 0
    var findedIndex:MutableList<Int> = mutableListOf()
    var countdown = 0
    var timeoutBool:Boolean = false
    var match_sound:MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        match_sound = MediaPlayer.create(this,R.raw.card_match)
        var database = FirebaseDatabase.getInstance().getReference("cards")
        var game_mode = intent.getIntExtra("game_mode",0)
        var cards = java.util.ArrayList<Card_Game>()
        var finish:Boolean = false
        //cards.add(Card_Game())
        var textCountdown = findViewById<TextView>(R.id.CoundowntextView)
        var picked_cards = java.util.ArrayList<Int>()
        var scoreBoard1 = findViewById<TextView>(R.id.scoretextView)
        var img1 = findViewById<ImageView>(R.id.imageView1)
        var img2 = findViewById<ImageView>(R.id.imageView2)
        var img3 = findViewById<ImageView>(R.id.imageView3)
        var img4 = findViewById<ImageView>(R.id.imageView4)
        var img5 = findViewById<ImageView>(R.id.imageView5)
        var img6 = findViewById<ImageView>(R.id.imageView6)
        var img7 = findViewById<ImageView>(R.id.imageView7)
        var img8 = findViewById<ImageView>(R.id.imageView8)
        var img9 = findViewById<ImageView>(R.id.imageView9)
        var img10 = findViewById<ImageView>(R.id.imageView10)
        var img11 = findViewById<ImageView>(R.id.imageView11)
        var img12 = findViewById<ImageView>(R.id.imageView12)
        var img13 = findViewById<ImageView>(R.id.imageView13)
        var img14 = findViewById<ImageView>(R.id.imageView14)
        var img15 = findViewById<ImageView>(R.id.imageView15)
        var img16 = findViewById<ImageView>(R.id.imageView16)
        var img17 = findViewById<ImageView>(R.id.imageView17)
        var img18 = findViewById<ImageView>(R.id.imageView18)
        var img19 = findViewById<ImageView>(R.id.imageView19)
        var img20 = findViewById<ImageView>(R.id.imageView20)
        var img21 = findViewById<ImageView>(R.id.imageView21)
        var img22 = findViewById<ImageView>(R.id.imageView22)
        var img23 = findViewById<ImageView>(R.id.imageView23)
        var img24 = findViewById<ImageView>(R.id.imageView24)
        var img25 = findViewById<ImageView>(R.id.imageView25)
        var img26 = findViewById<ImageView>(R.id.imageView26)
        var img27 = findViewById<ImageView>(R.id.imageView27)
        var img28 = findViewById<ImageView>(R.id.imageView28)
        var img29 = findViewById<ImageView>(R.id.imageView29)
        var img30 = findViewById<ImageView>(R.id.imageView30)
        var img31 = findViewById<ImageView>(R.id.imageView31)
        var img32 = findViewById<ImageView>(R.id.imageView32)
        var img33 = findViewById<ImageView>(R.id.imageView33)
        var img34 = findViewById<ImageView>(R.id.imageView34)
        var img35 = findViewById<ImageView>(R.id.imageView35)
        var img36 = findViewById<ImageView>(R.id.imageView36)

        img1.setVisibility(View.GONE)
        img2.setVisibility(View.GONE)
        img3.setVisibility(View.GONE)
        img4.setVisibility(View.GONE)
        img5.setVisibility(View.GONE)
        img6.setVisibility(View.GONE)
        img7.setVisibility(View.GONE)
        img8.setVisibility(View.GONE)
        img9.setVisibility(View.GONE)
        img10.setVisibility(View.GONE)
        img11.setVisibility(View.GONE)
        img12.setVisibility(View.GONE)
        img13.setVisibility(View.GONE)
        img14.setVisibility(View.GONE)
        img15.setVisibility(View.GONE)
        img16.setVisibility(View.GONE)
        img17.setVisibility(View.GONE)
        img18.setVisibility(View.GONE)
        img19.setVisibility(View.GONE)
        img20.setVisibility(View.GONE)
        img21.setVisibility(View.GONE)
        img22.setVisibility(View.GONE)
        img23.setVisibility(View.GONE)
        img24.setVisibility(View.GONE)
        img25.setVisibility(View.GONE)
        img26.setVisibility(View.GONE)
        img27.setVisibility(View.GONE)
        img28.setVisibility(View.GONE)
        img29.setVisibility(View.GONE)
        img30.setVisibility(View.GONE)
        img31.setVisibility(View.GONE)
        img32.setVisibility(View.GONE)
        img33.setVisibility(View.GONE)
        img34.setVisibility(View.GONE)
        img35.setVisibility(View.GONE)
        img36.setVisibility(View.GONE)

        var base64_back:String = ""

        if(game_mode==2){
            img1.setVisibility(View.VISIBLE)
            img2.setVisibility(View.VISIBLE)
            img3.setVisibility(View.VISIBLE)
            img4.setVisibility(View.VISIBLE)
        }
        else if(game_mode==4){
            img1.setVisibility(View.VISIBLE)
            img2.setVisibility(View.VISIBLE)
            img3.setVisibility(View.VISIBLE)
            img4.setVisibility(View.VISIBLE)

            img7.setVisibility(View.VISIBLE)
            img8.setVisibility(View.VISIBLE)
            img9.setVisibility(View.VISIBLE)
            img10.setVisibility(View.VISIBLE)

            img13.setVisibility(View.VISIBLE)
            img14.setVisibility(View.VISIBLE)
            img15.setVisibility(View.VISIBLE)
            img16.setVisibility(View.VISIBLE)

            img19.setVisibility(View.VISIBLE)
            img20.setVisibility(View.VISIBLE)
            img21.setVisibility(View.VISIBLE)
            img22.setVisibility(View.VISIBLE)
        }
        else{
            img1.setVisibility(View.VISIBLE)
            img2.setVisibility(View.VISIBLE)
            img3.setVisibility(View.VISIBLE)
            img4.setVisibility(View.VISIBLE)
            img5.setVisibility(View.VISIBLE)
            img6.setVisibility(View.VISIBLE)
            img7.setVisibility(View.VISIBLE)
            img8.setVisibility(View.VISIBLE)
            img9.setVisibility(View.VISIBLE)
            img10.setVisibility(View.VISIBLE)
            img11.setVisibility(View.VISIBLE)
            img12.setVisibility(View.VISIBLE)
            img13.setVisibility(View.VISIBLE)
            img14.setVisibility(View.VISIBLE)
            img15.setVisibility(View.VISIBLE)
            img16.setVisibility(View.VISIBLE)
            img17.setVisibility(View.VISIBLE)
            img18.setVisibility(View.VISIBLE)
            img19.setVisibility(View.VISIBLE)
            img20.setVisibility(View.VISIBLE)
            img21.setVisibility(View.VISIBLE)
            img22.setVisibility(View.VISIBLE)
            img23.setVisibility(View.VISIBLE)
            img24.setVisibility(View.VISIBLE)
            img25.setVisibility(View.VISIBLE)
            img26.setVisibility(View.VISIBLE)
            img27.setVisibility(View.VISIBLE)
            img28.setVisibility(View.VISIBLE)
            img29.setVisibility(View.VISIBLE)
            img30.setVisibility(View.VISIBLE)
            img31.setVisibility(View.VISIBLE)
            img32.setVisibility(View.VISIBLE)
            img33.setVisibility(View.VISIBLE)
            img34.setVisibility(View.VISIBLE)
            img35.setVisibility(View.VISIBLE)
            img36.setVisibility(View.VISIBLE)
        }

        database.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    base64_back = snapshot.child("back_base64").getValue().toString()
                    var imageBytes = Base64.decode(base64_back, Base64.DEFAULT)
                    backImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

                    for(i in snapshot.children){
                        if(i.childrenCount<2){
                            continue
                        }
                        var tmp = Card_Game()
                        var st_tmp:String
                        tmp.card_name = i.child("card_name").getValue().toString()
                        st_tmp = i.child("points").getValue().toString()
                        tmp.base64 = i.child("base64").getValue().toString()
                        var imageBytes = Base64.decode(tmp.base64,Base64.DEFAULT)
                        tmp.image = BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.size)
                        tmp.house = i.child("house").getValue().toString()
                        tmp.clicked1 = true
                        tmp.clicked2 = true
                        tmp.points = Integer.parseInt(st_tmp)
                        cards.add(tmp)
                    }
                    img1.setImageBitmap(backImage)
                    img2.setImageBitmap(backImage)
                    img3.setImageBitmap(backImage)
                    img4.setImageBitmap(backImage)
                    img5.setImageBitmap(backImage)
                    img6.setImageBitmap(backImage)
                    img7.setImageBitmap(backImage)
                    img8.setImageBitmap(backImage)
                    img9.setImageBitmap(backImage)
                    img10.setImageBitmap(backImage)
                    img11.setImageBitmap(backImage)
                    img12.setImageBitmap(backImage)
                    img13.setImageBitmap(backImage)
                    img14.setImageBitmap(backImage)
                    img15.setImageBitmap(backImage)
                    img16.setImageBitmap(backImage)
                    img17.setImageBitmap(backImage)
                    img18.setImageBitmap(backImage)
                    img19.setImageBitmap(backImage)
                    img20.setImageBitmap(backImage)
                    img21.setImageBitmap(backImage)
                    img22.setImageBitmap(backImage)
                    img23.setImageBitmap(backImage)
                    img24.setImageBitmap(backImage)
                    img25.setImageBitmap(backImage)
                    img26.setImageBitmap(backImage)
                    img27.setImageBitmap(backImage)
                    img28.setImageBitmap(backImage)
                    img29.setImageBitmap(backImage)
                    img30.setImageBitmap(backImage)
                    img31.setImageBitmap(backImage)
                    img32.setImageBitmap(backImage)
                    img33.setImageBitmap(backImage)
                    img34.setImageBitmap(backImage)
                    img35.setImageBitmap(backImage)
                    img36.setImageBitmap(backImage)
                    var random_index = 0
                    var random_index1 = 0
                    var random_index2 = 0
                    var tmp_x:Float? = 0f
                    var tmp_y:Float? = 0f
                    var grf_count = 0
                    var slt_count = 0
                    var rav_count = 0
                    var huff_count = 0
                    var tmp_count = 0
                    var delay:Long = 200

                    while(true){
                        if(game_mode==2){
                            if(grf_count == 1 && slt_count == 1){
                                break
                            }
                            random_index = Random.nextInt(cards.size)
                            if(picked_cards.contains(random_index)){
                                continue
                            }
                            if(cards[random_index].house == "GRYFFINDOR" && grf_count<1){
                                grf_count+=1
                                picked_cards.add(random_index)
                            }
                            else if(cards[random_index].house=="SLYTHERIN" && slt_count<1){
                                slt_count+=1
                                picked_cards.add(random_index)
                            }
                            else{
                                continue
                            }
                        }
                        else if(game_mode==4){
                            if(grf_count == 2 && slt_count == 2 && rav_count==2 && huff_count ==2){
                                break
                            }
                            random_index = Random.nextInt(cards.size)
                            if(picked_cards.contains(random_index)){
                                continue
                            }
                            if(cards[random_index].house == "GRYFFINDOR" && grf_count<2){
                                grf_count+=1
                                picked_cards.add(random_index)
                            }
                            else if(cards[random_index].house=="SLYTHERIN" && slt_count<2){
                                slt_count+=1
                                picked_cards.add(random_index)
                            }
                            else if(cards[random_index].house=="HUFFLEPUFF" && huff_count<2){
                                huff_count+=1
                                picked_cards.add(random_index)
                            }
                            else if(cards[random_index].house=="RAVENCLAW" && rav_count<2){
                                rav_count+=1
                                picked_cards.add(random_index)
                            }
                            else{
                                continue
                            }

                        }
                        else{
                            if(grf_count == 5 && slt_count == 5 && rav_count==4 && huff_count ==4){
                                break
                            }
                            random_index = Random.nextInt(cards.size)
                            if(picked_cards.contains(random_index)){
                                continue
                            }
                            if(cards[random_index].house == "GRYFFINDOR" && grf_count<5){
                                grf_count+=1
                                picked_cards.add(random_index)
                            }
                            else if(cards[random_index].house=="SLYTHERIN" && slt_count<5){
                                slt_count+=1
                                picked_cards.add(random_index)
                            }
                            else if(cards[random_index].house=="HUFFLEPUFF" && huff_count<4){
                                huff_count+=1
                                picked_cards.add(random_index)
                            }
                            else if(cards[random_index].house=="RAVENCLAW" && rav_count<4){
                                rav_count+=1
                                picked_cards.add(random_index)
                            }
                            else{
                                continue
                            }
                        }
                    }
                    println(picked_cards)
                    if(game_mode==2){
                        cards[picked_cards[0]].imgInterface1 = img1
                        cards[picked_cards[0]].imgInterface2 = img2
                        cards[picked_cards[1]].imgInterface1 = img3
                        cards[picked_cards[1]].imgInterface2 = img4
                    }
                    else if(game_mode==4){
                        cards[picked_cards[0]].imgInterface1 = img1
                        cards[picked_cards[0]].imgInterface2 = img2
                        cards[picked_cards[1]].imgInterface1 = img3
                        cards[picked_cards[1]].imgInterface2 = img4
                        cards[picked_cards[2]].imgInterface1 = img7
                        cards[picked_cards[2]].imgInterface2 = img8
                        cards[picked_cards[3]].imgInterface1 = img9
                        cards[picked_cards[3]].imgInterface2 = img10
                        cards[picked_cards[4]].imgInterface1 = img13
                        cards[picked_cards[4]].imgInterface2 = img14
                        cards[picked_cards[5]].imgInterface1 = img15
                        cards[picked_cards[5]].imgInterface2 = img16
                        cards[picked_cards[6]].imgInterface1 = img19
                        cards[picked_cards[6]].imgInterface2 = img20
                        cards[picked_cards[7]].imgInterface1 = img21
                        cards[picked_cards[7]].imgInterface2 = img22
                    }
                    else{
                        cards[picked_cards[0]].imgInterface1 = img1
                        cards[picked_cards[0]].imgInterface2 = img2
                        cards[picked_cards[1]].imgInterface1 = img3
                        cards[picked_cards[1]].imgInterface2 = img4
                        cards[picked_cards[2]].imgInterface1 = img5
                        cards[picked_cards[2]].imgInterface2 = img6
                        cards[picked_cards[3]].imgInterface1 = img7
                        cards[picked_cards[3]].imgInterface2 = img8
                        cards[picked_cards[4]].imgInterface1 = img9
                        cards[picked_cards[4]].imgInterface2 = img10
                        cards[picked_cards[5]].imgInterface1 = img11
                        cards[picked_cards[5]].imgInterface2 = img12
                        cards[picked_cards[6]].imgInterface1 = img13
                        cards[picked_cards[6]].imgInterface2 = img14
                        cards[picked_cards[7]].imgInterface1 = img15
                        cards[picked_cards[7]].imgInterface2 = img16
                        cards[picked_cards[8]].imgInterface1 = img17
                        cards[picked_cards[8]].imgInterface2 = img18
                        cards[picked_cards[9]].imgInterface1 = img19
                        cards[picked_cards[9]].imgInterface2 = img20
                        cards[picked_cards[10]].imgInterface1 = img21
                        cards[picked_cards[10]].imgInterface2 = img22
                        cards[picked_cards[11]].imgInterface1 = img23
                        cards[picked_cards[11]].imgInterface2 = img24
                        cards[picked_cards[12]].imgInterface1 = img25
                        cards[picked_cards[12]].imgInterface2 = img26
                        cards[picked_cards[13]].imgInterface1 = img27
                        cards[picked_cards[13]].imgInterface2 = img28
                        cards[picked_cards[14]].imgInterface1 = img29
                        cards[picked_cards[14]].imgInterface2 = img30
                        cards[picked_cards[15]].imgInterface1 = img31
                        cards[picked_cards[15]].imgInterface2 = img32
                        cards[picked_cards[16]].imgInterface1 = img33
                        cards[picked_cards[16]].imgInterface2 = img34
                        cards[picked_cards[17]].imgInterface1 = img35
                        cards[picked_cards[17]].imgInterface2 = img36
                    }


                    for(i in 0..25){
                        random_index = Random.nextInt(3-0)
                        random_index1 = Random.nextInt(picked_cards.size)
                        random_index2 = Random.nextInt(picked_cards.size)
                        if(random_index == 0){
                            tmp_x = cards[picked_cards[random_index1]].imgInterface1?.x
                            tmp_y = cards[picked_cards[random_index1]].imgInterface1?.y
                            cards[picked_cards[random_index1]].imgInterface1?.x = cards[picked_cards[random_index1]].imgInterface2!!.x
                            cards[picked_cards[random_index1]].imgInterface1?.y = cards[picked_cards[random_index1]].imgInterface2!!.y
                            cards[picked_cards[random_index1]].imgInterface2?.x = tmp_x!!
                            cards[picked_cards[random_index1]].imgInterface2?.y = tmp_y!!
                        }
                        else if(random_index == 1){
                            tmp_x = cards[picked_cards[random_index1]].imgInterface1?.x
                            tmp_y = cards[picked_cards[random_index1]].imgInterface1?.y
                            cards[picked_cards[random_index1]].imgInterface1?.x = cards[picked_cards[random_index2]].imgInterface1!!.x
                            cards[picked_cards[random_index1]].imgInterface1?.y = cards[picked_cards[random_index2]].imgInterface1!!.y
                            cards[picked_cards[random_index2]].imgInterface1?.x = tmp_x!!
                            cards[picked_cards[random_index2]].imgInterface1?.y = tmp_y!!
                        }
                        else{
                            tmp_x = cards[picked_cards[random_index1]].imgInterface1?.x
                            tmp_y = cards[picked_cards[random_index1]].imgInterface1?.y
                            cards[picked_cards[random_index1]].imgInterface1?.x = cards[picked_cards[random_index2]].imgInterface2!!.x
                            cards[picked_cards[random_index1]].imgInterface1?.y = cards[picked_cards[random_index2]].imgInterface2!!.y
                            cards[picked_cards[random_index2]].imgInterface2?.x = tmp_x!!
                            cards[picked_cards[random_index2]].imgInterface2?.y = tmp_y!!
                        }

                    }
                    val timer = object:CountDownTimer(45000,1000){
                        override fun onTick(p0: Long) {
                            textCountdown.text = (p0/1000).toInt().toString()
                            countdown = (p0.toInt())/1000

                        }

                        override fun onFinish() {
                            timeoutBool = true
                            end_game(findedIndex, game_mode)
                        }

                    }
                    timer.start()


                    cards[picked_cards[0]].imgInterface1?.setOnClickListener {

                        if(cards[picked_cards[0]].clicked1){
                            Toast.makeText(applicationContext,cards[picked_cards[0]].card_name,Toast.LENGTH_SHORT).show()
                            cards[picked_cards[0]].imgInterface1?.setImageBitmap(cards[picked_cards[0]].image)
                            cards[picked_cards[0]].clicked1 = false
                            clicked+=1
                            if(clicked == 2){
                                Handler().postDelayed({
                                    evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                }, delay)
                            }
                        }
                        else{
                            cards[picked_cards[0]].imgInterface1?.setImageBitmap(backImage)
                            cards[picked_cards[0]].clicked1 = true
                            clicked-=1
                        }
                    }
                    cards[picked_cards[0]].imgInterface2?.setOnClickListener {
                        println(clicked)
                        if(cards[picked_cards[0]].clicked2){
                            Toast.makeText(applicationContext,cards[picked_cards[0]].card_name,Toast.LENGTH_SHORT).show()
                            cards[picked_cards[0]].imgInterface2?.setImageBitmap(cards[picked_cards[0]].image)
                            cards[picked_cards[0]].clicked2 = false
                            clicked+=1
                            if(clicked == 2){
                                Handler().postDelayed({
                                    evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                }, delay)

                            }
                        }
                        else{
                            cards[picked_cards[0]].imgInterface2?.setImageBitmap(backImage)
                            cards[picked_cards[0]].clicked2 = true
                            clicked-=1
                        }
                    }
                    cards[picked_cards[1]].imgInterface1?.setOnClickListener {
                        println(cards[picked_cards[1]].card_name)
                        if(cards[picked_cards[1]].clicked1){
                            Toast.makeText(applicationContext,cards[picked_cards[1]].card_name,Toast.LENGTH_SHORT).show()
                            cards[picked_cards[1]].imgInterface1?.setImageBitmap(cards[picked_cards[1]].image)
                            cards[picked_cards[1]].clicked1 = false
                            clicked+=1
                            if(clicked == 2){
                                Handler().postDelayed({
                                    evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                }, delay)
                            }
                        }
                        else{
                            cards[picked_cards[1]].imgInterface1?.setImageBitmap(backImage)
                            cards[picked_cards[1]].clicked1 = true
                            clicked-=1
                        }
                    }
                    cards[picked_cards[1]].imgInterface2?.setOnClickListener {
                        println(clicked)
                        if(cards[picked_cards[1]].clicked2){
                            Toast.makeText(applicationContext,cards[picked_cards[1]].card_name,Toast.LENGTH_SHORT).show()
                            cards[picked_cards[1]].imgInterface2?.setImageBitmap(cards[picked_cards[1]].image)
                            cards[picked_cards[1]].clicked2 = false
                            clicked+=1
                            if(clicked == 2){
                                println("test")
                                Handler().postDelayed({
                                    evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                }, delay)
                            }
                        }
                        else{
                            cards[picked_cards[1]].imgInterface2?.setImageBitmap(backImage)
                            cards[picked_cards[1]].clicked2 = true
                            clicked-=1
                        }
                    }
                    if(game_mode==4||game_mode==6){
                        cards[picked_cards[2]].imgInterface1?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[2]].clicked1){
                                Toast.makeText(applicationContext,cards[picked_cards[2]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[2]].imgInterface1?.setImageBitmap(cards[picked_cards[2]].image)
                                cards[picked_cards[2]].clicked1 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[2]].imgInterface1?.setImageBitmap(backImage)
                                cards[picked_cards[2]].clicked1 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[2]].imgInterface2?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[2]].clicked2){
                                Toast.makeText(applicationContext,cards[picked_cards[2]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[2]].imgInterface2?.setImageBitmap(cards[picked_cards[2]].image)
                                cards[picked_cards[2]].clicked2 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)

                                }
                            }
                            else{
                                cards[picked_cards[2]].imgInterface2?.setImageBitmap(backImage)
                                cards[picked_cards[2]].clicked2 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[3]].imgInterface1?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[3]].clicked1){
                                Toast.makeText(applicationContext,cards[picked_cards[3]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[3]].imgInterface1?.setImageBitmap(cards[picked_cards[3]].image)
                                cards[picked_cards[3]].clicked1 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[3]].imgInterface1?.setImageBitmap(backImage)
                                cards[picked_cards[3]].clicked1 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[3]].imgInterface2?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[3]].clicked2){
                                Toast.makeText(applicationContext,cards[picked_cards[3]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[3]].imgInterface2?.setImageBitmap(cards[picked_cards[3]].image)
                                cards[picked_cards[3]].clicked2 = false
                                clicked+=1
                                if(clicked == 2){
                                    println("test")
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[3]].imgInterface2?.setImageBitmap(backImage)
                                cards[picked_cards[3]].clicked2 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[4]].imgInterface1?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[4]].clicked1){
                                Toast.makeText(applicationContext,cards[picked_cards[4]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[4]].imgInterface1?.setImageBitmap(cards[picked_cards[4]].image)
                                cards[picked_cards[4]].clicked1 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[4]].imgInterface1?.setImageBitmap(backImage)
                                cards[picked_cards[4]].clicked1 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[4]].imgInterface2?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[4]].clicked2){
                                Toast.makeText(applicationContext,cards[picked_cards[4]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[4]].imgInterface2?.setImageBitmap(cards[picked_cards[4]].image)
                                cards[picked_cards[4]].clicked2 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)

                                }
                            }
                            else{
                                cards[picked_cards[4]].imgInterface2?.setImageBitmap(backImage)
                                cards[picked_cards[4]].clicked2 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[5]].imgInterface1?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[5]].clicked1){
                                Toast.makeText(applicationContext,cards[picked_cards[5]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[5]].imgInterface1?.setImageBitmap(cards[picked_cards[5]].image)
                                cards[picked_cards[5]].clicked1 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[5]].imgInterface1?.setImageBitmap(backImage)
                                cards[picked_cards[5]].clicked1 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[5]].imgInterface2?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[5]].clicked2){
                                Toast.makeText(applicationContext,cards[picked_cards[5]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[5]].imgInterface2?.setImageBitmap(cards[picked_cards[5]].image)
                                cards[picked_cards[5]].clicked2 = false
                                clicked+=1
                                if(clicked == 2){
                                    println("test")
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[5]].imgInterface2?.setImageBitmap(backImage)
                                cards[picked_cards[5]].clicked2 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[6]].imgInterface1?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[6]].clicked1){
                                Toast.makeText(applicationContext,cards[picked_cards[6]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[6]].imgInterface1?.setImageBitmap(cards[picked_cards[6]].image)
                                cards[picked_cards[6]].clicked1 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[6]].imgInterface1?.setImageBitmap(backImage)
                                cards[picked_cards[6]].clicked1 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[6]].imgInterface2?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[6]].clicked2){
                                Toast.makeText(applicationContext,cards[picked_cards[6]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[6]].imgInterface2?.setImageBitmap(cards[picked_cards[6]].image)
                                cards[picked_cards[6]].clicked2 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)

                                }
                            }
                            else{
                                cards[picked_cards[6]].imgInterface2?.setImageBitmap(backImage)
                                cards[picked_cards[6]].clicked2 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[7]].imgInterface1?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[7]].clicked1){
                                Toast.makeText(applicationContext,cards[picked_cards[7]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[7]].imgInterface1?.setImageBitmap(cards[picked_cards[7]].image)
                                cards[picked_cards[7]].clicked1 = false
                                clicked+=1
                                if(clicked == 2){
                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[7]].imgInterface1?.setImageBitmap(backImage)
                                cards[picked_cards[7]].clicked1 = true
                                clicked-=1
                            }
                        }
                        cards[picked_cards[7]].imgInterface2?.setOnClickListener {
                            println(clicked)
                            if(cards[picked_cards[7]].clicked2){
                                Toast.makeText(applicationContext,cards[picked_cards[7]].card_name,Toast.LENGTH_SHORT).show()
                                cards[picked_cards[7]].imgInterface2?.setImageBitmap(cards[picked_cards[7]].image)
                                cards[picked_cards[7]].clicked2 = false
                                clicked+=1
                                if(clicked == 2){

                                    Handler().postDelayed({
                                        evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                    }, delay)
                                }
                            }
                            else{
                                cards[picked_cards[7]].imgInterface2?.setImageBitmap(backImage)
                                cards[picked_cards[7]].clicked2 = true
                                clicked-=1
                            }
                        }
                        if(game_mode==6){
                            cards[picked_cards[8]].imgInterface1?.setOnClickListener {

                                if(cards[picked_cards[8]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[8]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[8]].imgInterface1?.setImageBitmap(cards[picked_cards[8]].image)
                                    cards[picked_cards[8]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[8]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[8]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[8]].imgInterface2?.setOnClickListener {

                                if(cards[picked_cards[8]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[8]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[8]].imgInterface2?.setImageBitmap(cards[picked_cards[8]].image)
                                    cards[picked_cards[8]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)

                                    }
                                }
                                else{
                                    cards[picked_cards[8]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[8]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[9]].imgInterface1?.setOnClickListener {

                                if(cards[picked_cards[9]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[9]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[9]].imgInterface1?.setImageBitmap(cards[picked_cards[9]].image)
                                    cards[picked_cards[9]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[9]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[9]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[9]].imgInterface2?.setOnClickListener {

                                if(cards[picked_cards[9]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[9]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[9]].imgInterface2?.setImageBitmap(cards[picked_cards[9]].image)
                                    cards[picked_cards[9]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        println("test")
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[9]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[9]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[10]].imgInterface1?.setOnClickListener {

                                if(cards[picked_cards[10]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[10]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[10]].imgInterface1?.setImageBitmap(cards[picked_cards[10]].image)
                                    cards[picked_cards[10]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[10]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[10]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[10]].imgInterface2?.setOnClickListener {

                                if(cards[picked_cards[10]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[10]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[10]].imgInterface2?.setImageBitmap(cards[picked_cards[10]].image)
                                    cards[picked_cards[10]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)

                                    }
                                }
                                else{
                                    cards[picked_cards[10]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[10]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[11]].imgInterface1?.setOnClickListener {

                                if(cards[picked_cards[11]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[11]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[11]].imgInterface1?.setImageBitmap(cards[picked_cards[11]].image)
                                    cards[picked_cards[11]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[11]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[11]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[11]].imgInterface2?.setOnClickListener {

                                if(cards[picked_cards[11]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[11]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[11]].imgInterface2?.setImageBitmap(cards[picked_cards[11]].image)
                                    cards[picked_cards[11]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        println("test")
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[11]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[11]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[12]].imgInterface1?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[12]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[12]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[12]].imgInterface1?.setImageBitmap(cards[picked_cards[12]].image)
                                    cards[picked_cards[12]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[12]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[12]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[12]].imgInterface2?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[12]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[12]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[12]].imgInterface2?.setImageBitmap(cards[picked_cards[12]].image)
                                    cards[picked_cards[12]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)

                                    }
                                }
                                else{
                                    cards[picked_cards[12]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[12]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[13]].imgInterface1?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[13]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[13]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[13]].imgInterface1?.setImageBitmap(cards[picked_cards[13]].image)
                                    cards[picked_cards[13]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[13]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[13]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[13]].imgInterface2?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[13]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[13]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[13]].imgInterface2?.setImageBitmap(cards[picked_cards[13]].image)
                                    cards[picked_cards[13]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        println("test")
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[13]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[13]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[14]].imgInterface1?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[14]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[14]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[14]].imgInterface1?.setImageBitmap(cards[picked_cards[14]].image)
                                    cards[picked_cards[14]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[14]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[14]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[14]].imgInterface2?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[14]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[14]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[14]].imgInterface2?.setImageBitmap(cards[picked_cards[14]].image)
                                    cards[picked_cards[14]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        println("test")
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[14]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[14]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[15]].imgInterface1?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[15]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[15]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[15]].imgInterface1?.setImageBitmap(cards[picked_cards[15]].image)
                                    cards[picked_cards[15]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[15]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[15]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[15]].imgInterface2?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[15]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[15]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[15]].imgInterface2?.setImageBitmap(cards[picked_cards[15]].image)
                                    cards[picked_cards[15]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        println("test")
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[15]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[15]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[16]].imgInterface1?.setOnClickListener {
                                println(clicked)
                                if(cards[picked_cards[16]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[16]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[16]].imgInterface1?.setImageBitmap(cards[picked_cards[16]].image)
                                    cards[picked_cards[16]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[16]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[16]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[16]].imgInterface2?.setOnClickListener {

                                if(cards[picked_cards[16]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[16]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[16]].imgInterface2?.setImageBitmap(cards[picked_cards[16]].image)
                                    cards[picked_cards[16]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        println("test")
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[16]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[16]].clicked2 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[17]].imgInterface1?.setOnClickListener {

                                if(cards[picked_cards[17]].clicked1){
                                    Toast.makeText(applicationContext,cards[picked_cards[17]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[17]].imgInterface1?.setImageBitmap(cards[picked_cards[17]].image)
                                    cards[picked_cards[17]].clicked1 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[17]].imgInterface1?.setImageBitmap(backImage)
                                    cards[picked_cards[17]].clicked1 = true
                                    clicked-=1
                                }
                            }
                            cards[picked_cards[17]].imgInterface2?.setOnClickListener {

                                if(cards[picked_cards[17]].clicked2){
                                    Toast.makeText(applicationContext,cards[picked_cards[17]].card_name,Toast.LENGTH_SHORT).show()
                                    cards[picked_cards[17]].imgInterface2?.setImageBitmap(cards[picked_cards[17]].image)
                                    cards[picked_cards[17]].clicked2 = false
                                    clicked+=1
                                    if(clicked == 2){
                                        println("test")
                                        Handler().postDelayed({
                                            evaluate(cards,picked_cards,scoreBoard1,game_mode)
                                        }, delay)
                                    }
                                }
                                else{
                                    cards[picked_cards[17]].imgInterface2?.setImageBitmap(backImage)
                                    cards[picked_cards[17]].clicked2 = true
                                    clicked-=1
                                }
                            }


                        }
                    }





                    println("finisheddd")
                    finish = true

                }
                else{
                    println("no value")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })







    }
    public fun evaluate(cards:java.util.ArrayList<Card_Game>,picked_cards:java.util.ArrayList<Int>,scoreBoard:TextView,game_mode:Int){
        var katsayi = 0
        var katsayi1 = 0
        for(i in picked_cards){
            if(findedIndex.contains(i)){
                continue
            }
            if(cards[i].clicked1==false && cards[i].clicked2==false){
                //won situation
                match_sound?.start()
                if(cards[i].house == "GRYFFINDOR" || cards[i].house=="SLYTHERIN"){
                    katsayi = 2
                }
                else{
                    katsayi = 1
                }
                findedIndex.add(i)
                score+=2* cards[i].points!! *katsayi
                scoreBoard.setText(score.toString())
                cards[i].imgInterface1?.setVisibility(View.INVISIBLE)
                cards[i].imgInterface2?.setVisibility(View.INVISIBLE)
                clicked = 0
                end_game(findedIndex, game_mode)
                break

            }
            else if((cards[i].clicked1==false && cards[i].clicked2==true)||(cards[i].clicked1==true && cards[i].clicked2==false)){
                for(j in picked_cards){
                    if(j==i){
                        continue
                    }
                    else{
                        if(cards[j].clicked1==false || cards[j].clicked2==false){
                            if(cards[j].house==cards[i].house){
                                if(cards[i].house=="GRYFFINDOR"||cards[i].house=="SLYTHERIN"){
                                    katsayi = 2
                                }
                                else{
                                    katsayi = 1
                                }
                                score-=((cards[j].points!! + cards[i].points!!)/katsayi)*((45-countdown)/10)
                                cards[i].clicked1 = true
                                cards[i].clicked2 = true
                                cards[j].clicked1 = true
                                cards[j].clicked2 = true
                                scoreBoard.setText(score.toString())

                            }
                            else{
                                if(cards[i].house=="GRYFFINDOR"||cards[i].house=="SLYTHERIN"){
                                    katsayi = 2
                                }
                                else{
                                    katsayi = 1
                                }
                                if(cards[i].house=="GRYFFINDOR"||cards[i].house=="SLYTHERIN"){
                                    katsayi1 = 2
                                }
                                else{
                                    katsayi1 = 1
                                }
                                score-=(((cards[i].points!! + cards[j].points!!)/2)*katsayi*katsayi1)*((45-countdown)/10)
                                cards[i].clicked1 = true
                                cards[i].clicked2 = true
                                cards[j].clicked1 = true
                                cards[j].clicked2 = true
                                scoreBoard.setText(score.toString())
                            }
                        }
                    }
                }

                turn_all_card(cards,picked_cards)

                clicked = 0
                break
            }

        }

    }
    public fun turn_all_card(cards:java.util.ArrayList<Card_Game>,picked_cards: ArrayList<Int>){
        for(i in picked_cards){
            cards[i].imgInterface1?.setImageBitmap(backImage)
            cards[i].imgInterface2?.setImageBitmap(backImage)
        }
    }
    public fun end_game(findedIndex:MutableList<Int>,game_mode:Int){
        if(timeoutBool){
            val intent = Intent(this,endGame::class.java)
            intent.putExtra("timeout",timeoutBool)
            startActivity(intent)
        }
        else {
            if (game_mode == 2) {
                if (findedIndex.size == 2) {
                    val intent = Intent(this, endGame::class.java)
                    intent.putExtra("timeout",timeoutBool)
                    startActivity(intent)
                }
            } else if (game_mode == 4) {
                if (findedIndex.size == 8) {
                    val intent = Intent(this, endGame::class.java)
                    intent.putExtra("timeout",timeoutBool)
                    startActivity(intent)
                }
            } else {
                if (findedIndex.size == 18) {
                    val intent = Intent(this, endGame::class.java)
                    intent.putExtra("timeout",timeoutBool)
                    startActivity(intent)
                }
            }
        }
    }

}
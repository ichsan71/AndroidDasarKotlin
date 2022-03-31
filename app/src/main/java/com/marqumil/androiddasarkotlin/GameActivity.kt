package com.marqumil.androiddasarkotlin

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Layout
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed

class GameActivity: AppCompatActivity() {

    private lateinit var btnRock: ImageButton
    private lateinit var btnPaper: ImageButton
    private lateinit var btnScissors: ImageButton
    private lateinit var imgResult: ImageView
    private lateinit var imgComp: ImageView

    private fun initComponents(){
        btnRock = findViewById(R.id.btnRock)
        btnPaper = findViewById(R.id.btnPaper)
        btnScissors = findViewById(R.id.btnScissors)
        imgResult = findViewById(R.id.imgResult)
        imgComp = findViewById(R.id.imgComp)
    }

    private fun logicResult(pilPlayer: String, pilComp: String){
        if (Game.isDraw(pilPlayer, pilComp)){
            Log.e("MQL", "masuk kalo seri")
            imgResult.setImageResource(R.drawable.draw)
        } else {
            if (Game.iswin(pilPlayer, pilComp)){
                Log.e("MQL", "masuk kalo menang")
                imgResult.setImageResource(R.drawable.winn)
            } else{
                Log.e("MQL", "masuk kalo kalah")
                imgResult.setImageResource(R.drawable.lose)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.game)

        initComponents()
        var pilPlayer: String = ""
        var pilComp: String = ""


        btnRock.setOnClickListener {
            pilPlayer = "ROCK"
            pilComp = Game.pickRandom()

            imgComp.setImageResource(Game.pickDrawable(pilComp))

            logicResult(pilPlayer, pilComp)
        }

        btnPaper.setOnClickListener {
            pilPlayer = "PAPER"
            pilComp = Game.pickRandom()

            imgComp.setImageResource(Game.pickDrawable(pilComp))

            logicResult(pilPlayer, pilComp)
        }

        btnScissors.setOnClickListener {
            pilPlayer = "SCISSORS"
            pilComp = Game.pickRandom()

            imgComp.setImageResource(Game.pickDrawable(pilComp))

            logicResult(pilPlayer, pilComp)
        }

    }
}
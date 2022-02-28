package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btRoll)

        rollButton.setOnClickListener(){
            rollDice()
        }

        val rollButtonLucky: Button = findViewById(R.id.btRollLucky)

        rollButtonLucky.setOnClickListener(){
            rollLuckyDice()
        }
    }

    //Hace una tirada de dado y muestra el resultado
    private fun rollDice() {
        //Crea un nuevo objeto de tipo Dice con 6 caras
        val firstDice = Dice(6)
        val diceRoll = firstDice.roll()

        //Actualiza la pantalla con la tirada del dado
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }

    //Hace una tirada de dado y si sale el numero de la suerte ganas, en caso contrario pierdes.
    private fun rollLuckyDice() {
        //Crea un nuevo objeto de tipo Dice con 6 caras
        val firstDice = Dice(6)
        val diceRoll = firstDice.roll()

        //Actualiza la pantalla con la tirada del dado
        val resultTextView: TextView = findViewById(R.id.textView)

        val luckyNumber = 4

        when (diceRoll) {
            luckyNumber -> resultTextView.text = "You won!"
            1 -> resultTextView.text = "So sorry! You rolled a 1. Try again!"
            2 -> resultTextView.text = "Sadly, you rolled a 2. Try again!"
            3 -> resultTextView.text = "Unfortunately, you rolled a 3. Try again!"
            5 -> resultTextView.text = "Don't cry! You rolled a 5. Try again!"
            6 -> resultTextView.text = "Apologies! You rolled a 6. Try again!"
        }
    }
}

class Dice(val numSides:Int){
    fun roll() :Int{
        val randomNumber = (1..numSides).random()
        return randomNumber
    }
}
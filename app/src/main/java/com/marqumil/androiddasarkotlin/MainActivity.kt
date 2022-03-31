package com.marqumil.androiddasarkotlin

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditTxt: EditText
    private lateinit var sayHelloBtn: Button
    private lateinit var nameTxt: TextView

    private fun initComponents(){
        nameEditTxt = findViewById(R.id.nameEditTxt)
        sayHelloBtn = findViewById(R.id.sayHelloBtn)
        nameTxt = findViewById(R.id.nameTxt)
    }

    private fun cekFinger(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURES", "ada")
        } else {
            Log.w("FEATURES", "ga ada")
        }
    }

    private fun platformVers(){
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S){
            Log.i("SDK", "Disable Features, u so low")
        } else {
            Log.i("SDK", "Yes U can")
        }
    }

    private fun printHello(name: String){
        Log.i("Debug", name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponents()
        cekFinger()
        platformVers()

        nameTxt.text = resources.getText(R.string.app_nun)

        sayHelloBtn.setOnClickListener {
            val num = "kepencet"
            printHello(num)

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }

            Log.i("Raw", sample)

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }

            Log.i("Assets", json)
            Log.d("MQL", "debug log")
            Log.i("MQL", "info log")
            Log.w("MQL", "warn log")
            Log.e("MQL", "error log")

            val name = nameEditTxt.text.toString()
            nameTxt.text = resources.getString(R.string.sayHelloText, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("MQL", it)
            }

            Log.i("MQL", resources.getBoolean(R.bool.isMode).toString())
            Log.i("MQL", resources.getInteger(R.integer.maxPage).toString())
            Log.i("MQL", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("MQL", resources.getColor(R.color.bg, theme).toString())

            sayHelloBtn.setBackgroundColor(resources.getColor(R.color.bg, theme))
        }


    }

}
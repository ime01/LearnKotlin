package com.flowz.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        article.setOnClickListener {
           openArticle()
        }

        openNext.setOnClickListener {
            val open = Intent(this, Main2Activity::class.java )
            startActivity(open)
        }

        openWeb.setOnClickListener {
            val openWeb = Intent(this, WebViewActivity::class.java )
            startActivity(openWeb)
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.article_menu, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item!!.itemId) {
//            R.id.article->openArticle()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
    private fun openArticle() {
        val openTheArticle =  Intent(this, ArticleActivity::class.java )
        startActivity(openTheArticle)
    }

    fun Calc(v: View){
        val n1 = findViewById<EditText>(R.id.numberOne)
        val n2 = findViewById<EditText>(R.id.numberTwo)
        val showResult = findViewById<TextView>(R.id.answer)

        val number1: Float
        val number2 : Float
        val result : Float

        if (TextUtils.isEmpty(n1.text.toString())){
            n1.error = "Enter Some Number..."
            return
        }else{
            number1 = n1.text.toString().toFloat()
        }
        if (TextUtils.isEmpty(n2.text.toString())){
            n2.error = "Enter Some Number..."
            return
        }else{
            number2 = n2.text.toString().toFloat()
        }

        when (v.id){
            R.id.add->{
                result = number1 + number2
                showResult.text = result.toString()
            }
            R.id.substraction->{
                result = number1 - number2
                showResult.text = result.toString()
            }
            R.id.mydivide->{
                result = number1 / number2
                showResult.text = result.toString()
            }
            R.id.mymultiply->{
                result = number1 * number2
                showResult.text = result.toString()
            }
        }
    }


}

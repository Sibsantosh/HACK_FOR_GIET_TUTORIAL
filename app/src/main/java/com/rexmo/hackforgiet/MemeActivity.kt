package com.rexmo.hackforgiet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.bumptech.glide.Glide
import com.rexmo.hackforgiet.`interface`.MemeAPI
import com.rexmo.hackforgiet.data.memeData
import com.rexmo.hackforgiet.network.Retrofit
import retrofit2.Response

class MemeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meme)
        val titleText = findViewById<TextView>(R.id.titleText)
        val memeImage = findViewById<ImageView>(R.id.memeImage)
        val reloadButton = findViewById<Button>(R.id.reloadBtn)
        val retService = Retrofit.getRetrofitInstance().create(MemeAPI::class.java)
        val response : LiveData<Response<memeData>> = liveData {
            val responseData = retService.getMeme()
            emit(responseData)
        }

        response.observe(this, Observer {

            val data = it.body()
            titleText.text = data?.title
            Glide.with(this).load(data?.url).into(memeImage)
            reloadButton.setOnClickListener {
                recreate()

            }

        })



    }
}
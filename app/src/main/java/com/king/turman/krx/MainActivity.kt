package com.king.turman.krx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "buobao's demo"
        var tv1:TextView = findViewById(R.id.tv1) as TextView
        tv1.text = "找到你不容易啊！"

        var button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            Toast.makeText(this, "点击了按钮", Toast.LENGTH_SHORT).show()
        }

        Observable.timer(1200,TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Toast.makeText(this, "1200", Toast.LENGTH_SHORT).show()
                }
    }
}

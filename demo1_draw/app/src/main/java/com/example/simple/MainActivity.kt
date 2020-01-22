package com.example.simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.simple.custom_view.PopCacheTextView

class MainActivity : AppCompatActivity() {

    lateinit var view: View
    lateinit var popCacheTextView: PopCacheTextView
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initPopCacheTextView()
    }


    private fun initPopCacheTextView() {

        //设置1s freeTime
        popCacheTextView.setOverTime(1000L)

        //设置控件消失时的回调
        popCacheTextView.setGoneListener(object : PopCacheTextView.GoneListener {
            override fun viewGone(view: PopCacheTextView) {
                Toast.makeText(this@MainActivity, view.text, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun initView() {
        view = findViewById(R.id.hello_world)
        popCacheTextView = findViewById(R.id.popCacheTextView)


        view.setOnClickListener {


        }

        view.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View?) {
                //todo
            }
        })
    }
}


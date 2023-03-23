package com.example.helloactivity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_second)
		val intent = intent
		val message = intent.getStringExtra(MainActivity.CURRENT_COUNT)
		val textView = findViewById<TextView>(R.id.count_second_activity)
		textView.text = message
	}
}
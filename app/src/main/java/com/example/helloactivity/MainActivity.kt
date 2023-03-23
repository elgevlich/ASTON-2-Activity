package com.example.helloactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

	private var count = 0
	private lateinit var countView: TextView

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		countView = findViewById(R.id.show_count)

		if (savedInstanceState != null) {
			countView.text = savedInstanceState.getString("current_count")
		}
	}

	override fun onSaveInstanceState(savedInstanceState: Bundle) {
		super.onSaveInstanceState(savedInstanceState)
		savedInstanceState.putString("current_count", countView.text.toString())
	}


	fun countUp(view: View) {
		count++
		countView.text = count.toString()
	}
}
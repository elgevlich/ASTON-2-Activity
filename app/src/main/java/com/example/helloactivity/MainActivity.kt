package com.example.helloactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

	private var count = 0
	private lateinit var countView: TextView

	companion object {

		const val CURRENT_COUNT = "current_count"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		countView = findViewById(R.id.show_count)
	}

	override fun onSaveInstanceState(savedInstanceState: Bundle) {
		super.onSaveInstanceState(savedInstanceState)
		savedInstanceState.putString("current_count", countView.text.toString())
	}

	override fun onRestoreInstanceState(savedInstanceState: Bundle) {
		super.onRestoreInstanceState(savedInstanceState)
		countView.text = savedInstanceState.getString("current_count")
	}


	fun countUp(view: View) {
		count++
		countView.text = count.toString()
	}

	fun launchSecondActivity(view: View) {
		val intent = Intent(this, SecondActivity::class.java)
		intent.putExtra(CURRENT_COUNT, count.toString())
		startActivity(intent)
	}

}
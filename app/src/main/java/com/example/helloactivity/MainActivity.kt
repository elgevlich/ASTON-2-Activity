package com.example.helloactivity


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat


class MainActivity : AppCompatActivity() {

	private lateinit var websiteEditText: EditText
	private lateinit var locationEditText: EditText
	private lateinit var shareTextEditText: EditText
	private lateinit var photoButton: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		websiteEditText = findViewById(R.id.website_edittext)
		locationEditText = findViewById(R.id.location_edittext)
		shareTextEditText = findViewById(R.id.share_edittext)
		photoButton = findViewById(R.id.take_picture_button)

	}

	fun openWebsite(view: View) {
		val url = websiteEditText.text.toString()
		val webpage = Uri.parse(url)
		val intent = Intent(Intent.ACTION_VIEW, webpage)
		if (intent.resolveActivity(packageManager) != null) {
			startActivity(intent)
		} else {
			Log.d("ImplicitIntents", "Can't handle this!")
		}
	}

	fun openLocation(view: View) {
		val loc = locationEditText.text.toString()
		val addressUri = Uri.parse("geo:0,0?q=$loc")
		val intent = Intent(Intent.ACTION_VIEW, addressUri)
		if (intent.resolveActivity(packageManager) != null) {
			startActivity(intent)
		} else {
			Log.d("ImplicitIntents", "Can't handle this intent!")
		}
	}

	fun shareText(view: View) {
		val txt = shareTextEditText.text.toString()
		val mimeType = "text/plain"
		ShareCompat.IntentBuilder(this)
			.setType(mimeType)
			.setChooserTitle("Share this text with: ")
			.setText(txt)
			.startChooser()
	}

	fun takePicture(view: View) {
		val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
		if (intent.resolveActivity(packageManager) != null) {
			startActivity(intent)
		} else {
			Log.d("ImplicitIntents", "Can't handle this intent!")
		}
	}
}
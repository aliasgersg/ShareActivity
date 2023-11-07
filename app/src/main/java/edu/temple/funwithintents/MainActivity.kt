package edu.temple.funwithintents

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This view contains the text to share
        val editText = findViewById<EditText>(R.id.editTextText)

        // When the user clicks this button, share the text
        findViewById<ImageButton>(R.id.shareImageButton).setOnClickListener {
            val textToShare = editText.text.toString()

            // Create an intent to send text
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, textToShare)
            sendIntent.type = "text/plain"

            // Start an activity to share the text
            startActivity(Intent.createChooser(sendIntent, null))

        }
    }
}
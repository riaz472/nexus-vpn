package org.torproject.android.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import org.torproject.android.R

class FeedbackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        supportActionBar?.apply {
            title = getString(R.string.feedback_title)
            setDisplayHomeAsUpEnabled(true)
        }

        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etMessage = findViewById<TextInputEditText>(R.id.etMessage)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            val name = etName.text?.toString()?.trim() ?: ""
            val email = etEmail.text?.toString()?.trim() ?: ""
            val message = etMessage.text?.toString()?.trim() ?: ""

            if (message.isEmpty()) {
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val subject = "NEXUS VPN Feedback from $name"
            val body = "Name: $name\nEmail: $email\n\nMessage:\n$message"

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${getString(R.string.developer_email)}")
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, body)
            }
            startActivity(Intent.createChooser(intent, "Send Feedback"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}

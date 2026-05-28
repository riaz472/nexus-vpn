package org.torproject.android.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.torproject.android.R

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        supportActionBar?.apply {
            title = getString(R.string.contact_title)
            setDisplayHomeAsUpEnabled(true)
        }

        findViewById<Button>(R.id.btnEmail).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${getString(R.string.developer_email)}")
                putExtra(Intent.EXTRA_SUBJECT, "NEXUS VPN Support")
            }
            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        findViewById<Button>(R.id.btnWhatsApp).setOnClickListener {
            val phone = getString(R.string.developer_whatsapp).replace("+", "").replace(" ", "")
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/$phone")
            }
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}

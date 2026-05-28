package org.torproject.android.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.torproject.android.R

class SupportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        supportActionBar?.apply {
            title = getString(R.string.support_title)
            setDisplayHomeAsUpEnabled(true)
        }

        findViewById<Button>(R.id.btnContactEmail).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${getString(R.string.developer_email)}")
                putExtra(Intent.EXTRA_SUBJECT, "NEXUS VPN Support Request")
            }
            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        findViewById<Button>(R.id.btnContactWhatsApp).setOnClickListener {
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

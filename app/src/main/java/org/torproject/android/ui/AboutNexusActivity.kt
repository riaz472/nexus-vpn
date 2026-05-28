package org.torproject.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.torproject.android.R

class AboutNexusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_nexus)

        supportActionBar?.apply {
            title = getString(R.string.about_nexus_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}

package org.torproject.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.torproject.android.R

class TermsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)

        supportActionBar?.apply {
            title = getString(R.string.terms_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}

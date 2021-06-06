package com.prisma.benefitclub

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BenefitClubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dependenciesProvider = DependenciesProvider(this)

        val buttonOne: Button = findViewById<View>(R.id.button2) as Button
        buttonOne.setOnClickListener {
            dependenciesProvider.accountViewModel.getUser(this)
        }
    }
}
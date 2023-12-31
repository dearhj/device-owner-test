package com.fqnpzs.mobileark5g

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.systemloglib.registerListenInterface
import com.android.systemloglib.setAdminPolicy
import com.android.systemloglib.setDeviceOwner
import com.android.systemloglib.setProfileOwner

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.bind).setOnClickListener {
            try {
                registerListenInterface(this)
            } catch (_: Exception) {
            }
        }
        findViewById<Button>(R.id.setAdmin).setOnClickListener { setAdminPolicy() }
        findViewById<Button>(R.id.setDevice).setOnClickListener { setProfileOwner() }
        findViewById<Button>(R.id.setDevice1).setOnClickListener { setDeviceOwner() }
    }
}
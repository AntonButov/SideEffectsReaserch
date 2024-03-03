package com.butovanton.sideeffectsreaserch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.butovanton.sideeffectsreaserch.ui.theme.SideEffectsReaserchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideEffectsReaserchTheme {
                val intentLaunchRemember = Intent(this, LaunchRememberScopeActivity::class.java)
                val intentSideEffect = Intent(this, SideEffectActivity::class.java)
                Column {
                    Button(onClick = {
                        startActivity(intentLaunchRemember)
                    }) {
                        Text(text = "Launch-RememberScope")
                    }
                    Button(onClick = {
                            startActivity(intentSideEffect)
                    }) {
                        Text(text = "SideEffect")
                    }
                }
            }
        }
    }
}
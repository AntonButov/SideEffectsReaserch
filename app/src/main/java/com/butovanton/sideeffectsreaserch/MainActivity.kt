package com.butovanton.sideeffectsreaserch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.butovanton.sideeffectsreaserch.ui.theme.SideEffectsReaserchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideEffectsReaserchTheme {
                // A surface container using the 'background' color from the theme
                    Button(onClick = {
                        Intent(this, LaunchRememberScopeActivity::class.java).also {
                            startActivity(it)
                        }
                    }) {
                        Text(text = "Launch-RememberScope")
                    }
            }
        }
    }
}
package com.butovanton.sideeffectsreaserch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.butovanton.sideeffectsreaserch.ui.theme.SideEffectsReaserchTheme
import androidx.compose.runtime.currentComposer as currentComposer1

class SideEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideEffectsReaserchTheme {
                Counter()
            }
        }
    }
}

@OptIn(InternalComposeApi::class)
@Composable
fun Counter() {

    var count by remember { mutableStateOf(0) }

    SideEffect {
        println("Outer Count is ${count}")
    }

   // если не подклюясь outer scope не работает
   // Text("Current Count ${count}")

    Button(onClick = { count++ }) {

        SideEffect {
            println("Inner Count is ${count}")
        }
        Text("Increase Count ${count}")
    }
}
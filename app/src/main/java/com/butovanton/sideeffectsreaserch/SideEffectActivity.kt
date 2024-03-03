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
    // Define a state variable for the count
    val count = remember { mutableStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        println("Outer Count is ${count.value}")
    }
    println("CurrentScope =  ${currentComposer1.recomposeScope}")

    Button(onClick = { count.value++ }) {
        // Use SideEffect to log the current value of count
        SideEffect {
            // Called on every recomposition
            println("Inner Count is ${count.value}")
        }

        println("CurrentScope =  ${currentComposer1.recomposeScope}")
        // This recomposition doesn't trigger the outer side effect
        // every time button has been tapped
        Text("Increase Count $count")
    }
}


@OptIn(InternalComposeApi::class)
@Composable
fun CounterDeeper() {

    var count by remember { mutableStateOf(0) }

    SideEffect {
        println("Count ")
    }

    println("CurrentScope =  ${currentComposer1.recomposeScope}")

    Button(count = { count }, onClick = {
        count++
    }
    )
}

@OptIn(InternalComposeApi::class)
@Composable
fun Button(count: () -> Int, onClick: () -> Unit) {

    SideEffect {
        println("Inner recompose ")
    }

    println("CurrentScope =  ${currentComposer1.recomposeScope}")
    Button(onClick = onClick) {
        println("CurrentScope =  ${currentComposer1.recomposeScope}")
        Text("Increase Count ${count()}")
    }

}
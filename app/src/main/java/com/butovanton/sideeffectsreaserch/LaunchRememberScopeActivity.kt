package com.butovanton.sideeffectsreaserch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.butovanton.sideeffectsreaserch.ui.theme.SideEffectsReaserchTheme
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LaunchRememberScopeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideEffectsReaserchTheme {

                var counterLaunch by remember {
                    mutableIntStateOf(0)
                }
                LaunchedEffect(counterLaunch) {
                        Toast.makeText(this@LaunchRememberScopeActivity, "Launched", Toast.LENGTH_LONG).show()
                        var counter = 0
                        while (counterLaunch > 0) {
                            delay(1000)
                            println("Launched $counterLaunch ${counter}")
                            counter++
                        }
                }

                val scope = rememberCoroutineScope()

                Column {
                    Button(onClick = {
                       counterLaunch++
                    }) {
                        Text(text = "LunchView click me")
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(onClick = {
                        scope.launch {
                            Toast.makeText(this@LaunchRememberScopeActivity, "RememberScope", Toast.LENGTH_LONG).show()
                            var counter = 0
                            while (true) {
                                delay(1000)
                                println("RememberScope $counter")
                                counter++
                            }

                        }
                    }) {
                        Text(text = "RememberScope click me")
                    }
                    Button(onClick = {
                        scope.cancel()
                    }) {
                        Text(text = "Cancel scope")
                    }
                }
            }
        }
    }
}

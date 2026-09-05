package com.example.remotecodeaustralia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.remotecodeaustralia.ui.screens.remoteCodeCamp.DemoKing
import com.example.remotecodeaustralia.ui.theme.RemoteCodeAustraliaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            RemoteCodeAustraliaTheme {

//    // Material Icons (extended set with 2000+ icons)
//    implementation("androidx.compose.material:material-icons-extended:<compose_version>")

                DemoKing()


            }
        }
    }
}


package com.example.files

import android.app.Activity.MODE_APPEND
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.files.ui.theme.FilesTheme
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent: Intent = Intent(this, MediaService::class.java)
        startService(intent)

        setContent {
            FilesTheme {
                MediaController(LocalContext.current)
            }
        }
    }
}


@Composable
fun MediaController(context: Context) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Управление проигрывателем"
        )
        Row(){
            Button(
                onClick = { context.startService( Intent(context, MediaService::class.java) ) }
            ){
                Text("Старт")
            }
            Button(
                onClick = { context.stopService( Intent(context, MediaService::class.java) ) }
            ){
                Text("Стоп")
            }
        }
    }


}

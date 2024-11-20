package com.rozoomcool.lakely.ui.presentation.screen

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun WorkPage() {
    @Composable
    fun PageUi() {
        val context = LocalContext.current
        val talk by remember { mutableStateOf("Speech text should come here") }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = talk,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .fillMaxSize(0.85f)
                    .padding(16.dp)
                    .background(Color.LightGray)
            )
            ElevatedButton (onClick = { askSpeechInput(context) }) {
                Text(
                    text = "Talk", style = MaterialTheme.typography.displayLarge
                )
            }
        }
    }
    PageUi()
}

fun askSpeechInput(context: Context) {
    if (!SpeechRecognizer.isRecognitionAvailable(context)) {
        Toast.makeText(context, "Speech not available", Toast.LENGTH_SHORT).show()
    } else {
        val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Talk")

        //startActivityForResult(MainActivity(),i,102)
    }
}
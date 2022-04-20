package com.example.app_jpc_sem2_ses2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_jpc_sem2_ses2.ui.theme.App_jpc_sem2_ses2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewPersonalData()
        }
    }
}

@Composable
private fun PersonalData(name: String) {
    MaterialTheme() {
        Column() {
            Text(text = "Saludos desde ${name}", style = MaterialTheme.typography.h6, color = Color.Red)
            Text(text = "Semana 2")
            Text(text = "Jueves 31")
        }
    }
}

@Preview
@Composable
fun PreviewPersonalData() {
    PersonalData(name = "La mejor \nuniversidad, UPC")
}
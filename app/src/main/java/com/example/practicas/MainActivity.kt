package com.example.practicas

import android.R
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicas.ui.theme.PRACTICASTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PRACTICASTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                    )
                }

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Greeting() {
    val context= LocalContext.current
    var valorA by remember { mutableStateOf("") }
    var valorB by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(){
            OutlinedTextField(
                value=valorA,
                label={Text("Valor A")},
                onValueChange ={valorA=it}
            )
        }
        Row(Modifier.padding(16.dp)){
            OutlinedTextField(
                value=valorB,
                label={Text("Valor B")},
                onValueChange ={valorB=it}
            )
        }

        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ){
            OutlinedButton(onClick = { /*TODO*/
                val a = valorA.toInt()
                val b = valorB.toInt()
                val c = a+b
                resultado = c.toString()

            }) {
                Text(text = "Enviar")
            }
        }
        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ){
            OutlinedTextField(
                value=resultado,
                label={Text("Resultado")},
                onValueChange ={resultado=it}
            )
        }



    }
}

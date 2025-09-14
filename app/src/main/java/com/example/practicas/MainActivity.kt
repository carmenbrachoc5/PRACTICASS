package com.example.practicas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas.ui.theme.PRACTICASTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PRACTICASTheme  {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF1E1E1E)
                ) {
                    Calculadora()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Calculadora() {
    var expresion by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = expresion,
                fontSize = 36.sp,
                color = Color(0xFFB71C1C),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Text(
                text = resultado,
                fontSize = 26.sp,
                color = Color(0xFFD32F2F),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            val buttons = listOf(
                listOf("7", "8", "9", "÷"),
                listOf("4", "5", "6", "×"),
                listOf("1", "2", "3", "-"),
                listOf("0", "C", "=", "+")
            )

            buttons.forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    row.forEach { symbol ->
                        Button(
                            onClick = {
                                when (symbol) {
                                    "C" -> {
                                        if (expresion.isNotEmpty()) {
                                            expresion = expresion.dropLast(1)
                                        }
                                    }
                                    "=" -> {
                                        try {
                                            val sanitized = expresion
                                                .replace("÷", "/")
                                                .replace("×", "*")
                                            val evalResult = evaluarExpresion(sanitized)
                                            resultado = evalResult.toString()
                                        } catch (e: Exception) {
                                            resultado = "Error"
                                        }
                                    }
                                    else -> expresion += symbol
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(70.dp),
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = when (symbol) {
                                    "+", "-", "×", "÷" -> Color(0xFF880E4F)
                                    "=" -> Color(0xFFD32F2F)
                                    "C" -> Color(0xFF6A1B9A)
                                    else -> Color(0xFF424242)
                                },
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = symbol,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

fun evaluarExpresion(expr: String): Double {
    return try {
        val e = expr.replace("÷", "/").replace("×", "*")

        if (e.contains("+")) {
            val parts = e.split("+")
            parts[0].toDouble() + parts[1].toDouble()
        }
        else if (e.contains("-")) {
            val parts = e.split("-")
            parts[0].toDouble() - parts[1].toDouble()
        }
        else if (e.contains("*")) {
            val parts = e.split("*")
            parts[0].toDouble() * parts[1].toDouble()
        }
        else if (e.contains("/")) {
            val parts = e.split("/")
            val b = parts[1].toDouble()
            if (b != 0.0) parts[0].toDouble() / b else Double.NaN
        }
        else {
            e.toDouble()
        }
    } catch (e: Exception) {
        Double.NaN
    }
}
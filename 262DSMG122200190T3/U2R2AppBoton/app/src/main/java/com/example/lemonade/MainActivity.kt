package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.U2R1AppBotonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            U2R1AppBotonTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {

    // Guarda el paso actual de la aplicación.
    var currentStep by remember {
        mutableStateOf(1)
    }

    // Guarda la cantidad de veces que se ha exprimido el limón.
    var squeezeCount by remember {
        mutableStateOf(0)
    }

    // Guarda cuántas veces se debe exprimir el limón.
    var squeezeNeeded by remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        when (currentStep) {

            // Paso 1: seleccionar un limón.
            1 -> {
                LemonTextAndImage(
                    text = stringResource(R.string.lemon_select),
                    imageResource = R.drawable.lemon_tree,
                    contentDescription = stringResource(
                        R.string.lemon_tree_content_description
                    ),
                    onImageClick = {

                        // Genera un número aleatorio entre 2 y 4.
                        squeezeNeeded = (2..4).random()

                        // Reinicia el contador.
                        squeezeCount = 0

                        // Pasa al paso 2.
                        currentStep = 2
                    }
                )
            }

            // Paso 2: exprimir el limón.
            2 -> {
                LemonTextAndImage(
                    text = stringResource(R.string.lemon_squeeze),
                    imageResource = R.drawable.lemon_squeeze,
                    contentDescription = stringResource(
                        R.string.lemon_content_description
                    ),
                    onImageClick = {

                        // Aumenta el número de veces que se ha exprimido.
                        squeezeCount++

                        // Si alcanza la cantidad necesaria,
                        // pasa al paso 3.
                        if (squeezeCount >= squeezeNeeded) {
                            currentStep = 3
                        }
                    }
                )
            }

            // Paso 3: beber la limonada.
            3 -> {
                LemonTextAndImage(
                    text = stringResource(R.string.lemon_drink),
                    imageResource = R.drawable.lemon_drink,
                    contentDescription = stringResource(
                        R.string.lemonade_content_description
                    ),
                    onImageClick = {

                        // Pasa al paso 4.
                        currentStep = 4
                    }
                )
            }

            // Paso 4: comenzar nuevamente.
            4 -> {
                LemonTextAndImage(
                    text = stringResource(R.string.lemon_restart),
                    imageResource = R.drawable.lemon_restart,
                    contentDescription = stringResource(
                        R.string.empty_glass_content_description
                    ),
                    onImageClick = {

                        // Regresa al paso 1.
                        currentStep = 1
                    }
                )
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    text: String,
    imageResource: Int,
    contentDescription: String,
    onImageClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = text,
            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentDescription,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color(105, 205, 216),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable {
                    onImageClick()
                }
        )
    }
}
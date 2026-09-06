package com.example.u2r3interfazyestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.u2r3interfazyestado.ui.theme.U2R3InterfazYEstadoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            U2R3InterfazYEstadoTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    // Guarda el número de la obra que se está mostrando.
    var currentArtwork by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Imagen correspondiente a la obra actual.
        Image(
            painter = painterResource(
                when (currentArtwork) {
                    1 -> R.drawable.artwork_1
                    2 -> R.drawable.artwork_2
                    else -> R.drawable.artwork_3
                }
            ),
            contentDescription = stringResource(
                when (currentArtwork) {
                    1 -> R.string.artwork_1_description
                    2 -> R.string.artwork_2_description
                    else -> R.string.artwork_3_description
                }
            ),
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Título de la obra actual.
        Text(
            text = stringResource(
                when (currentArtwork) {
                    1 -> R.string.artwork_1_title
                    2 -> R.string.artwork_2_title
                    else -> R.string.artwork_3_title
                }
            ),
            fontSize = 24.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        // Artista y año de la obra actual.
        Text(
            text = when (currentArtwork) {
                1 -> "${stringResource(R.string.artwork_1_artist)}, " +
                        stringResource(R.string.artwork_1_year)

                2 -> "${stringResource(R.string.artwork_2_artist)}, " +
                        stringResource(R.string.artwork_2_year)

                else -> "${stringResource(R.string.artwork_3_artist)}, " +
                        stringResource(R.string.artwork_3_year)
            },
            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Botones para cambiar de obra.
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            // Botón Previous.
            Button(
                onClick = {
                    currentArtwork = when (currentArtwork) {
                        1 -> 3
                        2 -> 1
                        else -> 2
                    }
                }
            ) {
                Text("Previous")
            }

            // Botón Next.
            Button(
                onClick = {
                    currentArtwork = when (currentArtwork) {
                        1 -> 2
                        2 -> 3
                        else -> 1
                    }
                }
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    U2R3InterfazYEstadoTheme {
        ArtSpaceApp()
    }
}
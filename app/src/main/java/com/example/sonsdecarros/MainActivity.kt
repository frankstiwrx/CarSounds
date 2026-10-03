package com.example.sonsdecarros

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sonsdecarros.ui.theme.SonsdecarrosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SonsdecarrosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Image with a single play button
        ImageWithPlayButton(
            imageResId = R.drawable.image1,
            audioResId = R.raw.audio0
        )



        Spacer(modifier = Modifier.height(16.dp))

        // Image with multiple play buttons
        ImageWithMultiplePlayButtons(
            imageResId = R.drawable.image2,
            audio1ResId = R.raw.audio1,
            audio2ResId = R.raw.audio2,
            audio3ResId = R.raw.m1,
            audio4ResId = R.raw.m3,
            audio5ResId = R.raw.m2,
            imageResId2 = R.drawable.image3
        )
    }
}



//============================================================================

@Composable
fun ImageWithPlayButton(imageResId: Int, audioResId: Int) {
    var isPlaying by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val mediaPlayer = remember(context) { MediaPlayer.create(context, audioResId) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    if (isPlaying) {
                        mediaPlayer.pause()
                        isPlaying = false
                    } else {
                        mediaPlayer.start()
                        isPlaying = true
                    }
                }
        )

        Button(
            onClick = {
                if (isPlaying) {
                    mediaPlayer.pause()
                    isPlaying = false
                } else {
                    mediaPlayer.start()
                    isPlaying = true
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd) // Align button at the bottom end of the Box
                .padding(8.dp)
        ) {
            Text(text = if (isPlaying) "Parar" else "Som 1")
        }
    }

    DisposableEffect(Unit) {
        onDispose { mediaPlayer.release() }
    }
}

@Composable
fun ImageWithMultiplePlayButtons(
    imageResId: Int,
    audio1ResId: Int,
    audio2ResId: Int,
    audio3ResId: Int,
    audio4ResId: Int,
    audio5ResId: Int,
    imageResId2: Int
) {
    var isPlayingAudio1 by remember { mutableStateOf(false) }
    var isPlayingAudio2 by remember { mutableStateOf(false) }
    var isPlayingAudio3 by remember { mutableStateOf(false) }
    var isPlayingAudio4 by remember { mutableStateOf(false) }
    var isPlayingAudio5 by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val mediaPlayerAudio1 = remember(context) { MediaPlayer.create(context, audio1ResId) }
    val mediaPlayerAudio2 = remember(context) { MediaPlayer.create(context, audio2ResId) }
    val mediaPlayerAudio3 = remember(context) { MediaPlayer.create(context, audio3ResId) }
    val mediaPlayerAudio4 = remember(context) { MediaPlayer.create(context, audio4ResId) }
    val mediaPlayerAudio5 = remember(context) { MediaPlayer.create(context, audio5ResId) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp) // Ensure space for the buttons
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .offset(y = 180.dp) // Move the column of buttons down
        ) {
            // Existing buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Button(
                    onClick = {
                        if (isPlayingAudio1) {
                            mediaPlayerAudio1.pause()
                            isPlayingAudio1 = false
                        } else {
                            mediaPlayerAudio1.start()
                            isPlayingAudio1 = true
                        }
                    },
                    modifier = Modifier
                        .weight(1f) // Ensure buttons take equal space
                ) {
                    Text(text = if (isPlayingAudio1) "Parar" else "Som 1")
                }

                Spacer(modifier = Modifier.width(120.dp))

                Button(
                    onClick = {
                        if (isPlayingAudio2) {
                            mediaPlayerAudio2.pause()
                            isPlayingAudio2 = false
                        } else {
                            mediaPlayerAudio2.start()
                            isPlayingAudio2 = true
                        }
                    },
                    modifier = Modifier
                        .weight(1f) // Ensure buttons take equal space
                ) {
                    Text(text = if (isPlayingAudio2) "Parar" else "Som 2")
                }
            }

            Spacer(modifier = Modifier.height(24.dp)) // Space between the existing buttons and new buttons

            // New buttons
            Column {
//--------------------------------------------------------------------

                Image(
                    painter = painterResource(id = imageResId2),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 60.dp) // Ensure space for the buttons
                )
                //Spacer(modifier = Modifier.height(200.dp))

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Button(
                        onClick = {
                            if (isPlayingAudio3) {
                                mediaPlayerAudio3.pause()
                                isPlayingAudio3 = false
                            } else {
                                mediaPlayerAudio3.start()
                                isPlayingAudio3 = true
                            }
                        },
                        modifier = Modifier
                            .weight(1f) // Ensure buttons take equal space
                    ) {
                        Text(text = if (isPlayingAudio3) "Parar" else "Som 1")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            if (isPlayingAudio4) {
                                mediaPlayerAudio4.pause()
                                isPlayingAudio4 = false
                            } else {
                                mediaPlayerAudio4.start()
                                isPlayingAudio4 = true
                            }
                        },
                        modifier = Modifier
                            .weight(1f) // Ensure buttons take equal space
                    ) {
                        Text(text = if (isPlayingAudio4) "Parar" else "Som 2")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            if (isPlayingAudio5) {
                                mediaPlayerAudio5.pause()
                                isPlayingAudio5 = false
                            } else {
                                mediaPlayerAudio5.start()
                                isPlayingAudio5 = true
                            }
                        },
                        modifier = Modifier
                            .weight(1f) // Ensure buttons take equal space
                    ) {
                        Text(text = if (isPlayingAudio5) "Parar" else "Som 3")
                    }
                }


            }


        }
    }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayerAudio1.release()
            mediaPlayerAudio2.release()
            mediaPlayerAudio3.release()
            mediaPlayerAudio4.release()
            mediaPlayerAudio5.release()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    SonsdecarrosTheme {
        Content()
    }
}
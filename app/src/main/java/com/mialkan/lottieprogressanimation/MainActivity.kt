package com.mialkan.lottieprogressanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mialkan.lottieprogressanimation.ui.theme.LottieProgressAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottieProgressAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Row(modifier = Modifier.padding(25.dp)) {
                        val composition by rememberLottieComposition(LottieCompositionSpec.Url("https://sdui.s3.eu-west-1.amazonaws.com/anim_pb_v1.json"))
                        val progress by animateLottieCompositionAsState(composition = composition, iterations = Int.MAX_VALUE)

                        LottieAnimation(
                            modifier = Modifier.weight(1f).height(11.dp),
                            composition = composition,
                            contentScale = ContentScale.FillBounds,
                            progress = { progress }
                        )
                    }
                }
            }
        }
    }
}

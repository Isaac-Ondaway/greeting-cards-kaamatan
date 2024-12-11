package com.example.greetingcard_kaamatanfestival

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard_kaamatanfestival.ui.theme.GreetingCardKaamatanFestivalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardKaamatanFestivalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFAEDCB)
                ) {
                    GreetingCardLayout()
                }
            }
        }
    }
}

@SuppressLint("AutoboxingStateCreation")
@Composable
fun GreetingCardLayout() {
    val p1 = painterResource(R.drawable.pic_one)
    val p2 = painterResource(R.drawable.pic_two)
    val p3 = painterResource(R.drawable.pic_three)
    val p4 = painterResource(R.drawable.pic_four)

    var currentPic by remember {
        mutableStateOf(p1)
    }

    var currentText by remember {
        mutableStateOf(R.string.Greetings_one)
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .padding(top = 100.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = currentPic,
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .background(color = Color(0xFFDFEBEB))
                .padding(16.dp),
            text = stringResource(currentText), // Accessing string resource here
            textAlign = TextAlign.Center
        )


    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 100.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        // previous button
        Button(
            onClick = {
                when (currentPic) {
                    p1 -> {
                        currentPic = p4
                        currentText = R.string.Greetings_four
                    }
                    p2 -> {
                        currentPic = p1
                        currentText = R.string.Greetings_one
                    }
                    p3 -> {
                        currentPic = p2
                        currentText = R.string.Greetings_two
                    }
                    else -> {
                        currentPic = p3
                        currentText = R.string.Greetings_three
                    }
                }
            },
            modifier = Modifier.width(110.dp)
        ) {
            Text(text = "Previous")
        }

        // next button
        Button(
            onClick = {
                when (currentPic) {
                    p1 -> {
                        currentPic = p2
                        currentText = R.string.Greetings_two
                    }
                    p2 -> {
                        currentPic = p3
                        currentText = R.string.Greetings_three
                    }
                    p3 -> {
                        currentPic = p4
                        currentText = R.string.Greetings_four
                    }
                    else -> {
                        currentPic = p1
                        currentText = R.string.Greetings_one
                    }
                }
            },
            modifier = Modifier.width(110.dp)
        ) {
            Text(text = "Next")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingCardPreview() {
    GreetingCardKaamatanFestivalTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GreetingCardLayout()
        }
    }
}
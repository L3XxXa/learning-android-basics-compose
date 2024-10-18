package com.example.test_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_compose.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayCard(
                        to = "Android",
                        from = "Alexey",
                        modifier = Modifier.padding(all = 8.dp)

                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayCard(to: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        BirthdayImage()
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.happy_birthday, to),
                fontSize = 90.sp,
                lineHeight = 120.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.from, from),
                fontSize = 30.sp,
                modifier = modifier
                    .padding(20.dp)
            )
        }
    }
}

@Composable
fun BirthdayImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Image(
        painter = image,
        modifier = modifier,
        contentDescription = stringResource(R.string.birthday_card_image_desc),
        contentScale = ContentScale.Crop,
        alpha = 0.5F
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BirthdayCard(
                to = "Android",
                from = "Alexey"
            )
        }
    }

}

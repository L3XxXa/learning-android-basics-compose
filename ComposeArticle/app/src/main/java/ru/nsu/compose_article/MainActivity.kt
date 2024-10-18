package ru.nsu.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.compose_article.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface {
                    ComposableArticle()
                }
            }
        }
    }
}

@Composable
fun ComposableArticle(modifier: Modifier = Modifier) {
    Column {
        ComposableArticleImage()
        Text(
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp,
            text = stringResource(R.string.jetpack_compose_tutorial_title)
        )
        Text(
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
            text = stringResource(R.string.jetpack_compose_tutorial_short_desc)
        )
        Text(
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
            text = stringResource(R.string.jetpack_compose_tutorial_body)
        )
    }
}

@Composable
fun ComposableArticleImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        modifier = modifier,
        contentDescription = stringResource(R.string.composable_article_title)
    )
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposableArticle()
    }
}
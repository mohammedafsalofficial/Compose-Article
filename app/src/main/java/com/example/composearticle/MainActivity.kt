package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(
                        header = stringResource(id = R.string.header_text),
                        firstParagraph = stringResource(R.string.first_paragraph_text),
                        secondParagraph = stringResource(id = R.string.second_paragraph_text)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleImage(
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.bg_compose_background)

    Image(
        painter = image,
        contentDescription = null,
    )
}

@Composable
fun ArticleText(
    header: String,
    firstParagraph: String,
    secondParagraph: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = header,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = firstParagraph,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
    Text(
        text = secondParagraph,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Justify
    )
}

@Composable
fun Article(
    header: String,
    firstParagraph: String,
    secondParagraph: String,
    modifier: Modifier = Modifier
) {
    Column {
        ArticleImage()
        ArticleText(
            header = header,
            firstParagraph = firstParagraph,
            secondParagraph = secondParagraph
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewArticle() {
    ComposeArticleTheme {
        Article(
            header = stringResource(id = R.string.header_text),
            firstParagraph = stringResource(R.string.first_paragraph_text),
            secondParagraph = stringResource(id = R.string.second_paragraph_text)
        )
    }
}

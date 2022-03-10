package com.example.jettrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jettrivia.screens.questions.QuestionHome
import com.example.jettrivia.ui.theme.JetTriviaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                QuestionHome()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetTriviaTheme {
        content()
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetTriviaTheme {
    }
}
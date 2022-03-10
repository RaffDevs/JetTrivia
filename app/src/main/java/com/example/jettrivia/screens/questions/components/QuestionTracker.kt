package com.example.jettrivia.screens.questions.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.jettrivia.utils.AppColors

@Composable
fun QuestionTracker(counter: Int = 10, outOff: Int = 100) {
    Text(text = buildAnnotatedString {
        withStyle(
            style = ParagraphStyle(textIndent = TextIndent.None)
        ) {
            withStyle(
                style = SpanStyle(
                    color = AppColors.mLightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )
            ) {
                append("Question $counter/")
            }
        }
    })
}
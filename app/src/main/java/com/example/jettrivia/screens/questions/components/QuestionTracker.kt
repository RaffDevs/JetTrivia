package com.example.jettrivia.screens.questions.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.utils.AppColors

@Composable
fun QuestionTracker(counter: Int = 10, outOf: Int = 100) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
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

                    withStyle(
                        style = SpanStyle(
                            color = AppColors.mLightGray,
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp

                        )
                    ) {
                        append("$outOf")
                    }
                }
            }
        })
    }

    DrawDottedLine()
}

@Composable
fun DrawDottedLine() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), phase = 0f)

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp),
        onDraw = {
            drawLine(
                color = AppColors.mLightGray,
                start = Offset(0f, 0f),
                end = Offset(size.width, y = 0f),
                pathEffect = pathEffect
            )
        }
    )
}
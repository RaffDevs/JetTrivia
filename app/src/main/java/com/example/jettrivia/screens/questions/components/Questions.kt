package com.example.jettrivia.screens.questions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.utils.AppColors

@Composable
fun Questions(
    question: QuestionItem,
    questionIndex: Int,
    questionsSize: Int,
    onNextQuestion: () -> Unit
) {
    val questionText = question.question
    val questionChoices = question.choices
    val correntAnswer = question.choices.indexOf(question.answer)
    val selectedAnswer = remember {
        mutableStateOf<Int?>(null)
    }

    Column {
        QuestionTracker(counter = questionIndex, outOf = questionsSize)
        QuestionText(questionText)
        QuestionChoices(questionChoices, correntAnswer ) { choice ->
            selectedAnswer.value = choice
        }
        NextQuestionButton {
            onNextQuestion.invoke()
        }
    }
}

@Composable
fun QuestionText(text: String) {
    Column {
        Text(
            modifier = Modifier
                .padding(6.dp)
                .align(alignment = Alignment.Start)
                .fillMaxHeight(0.3f),
            text = text,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 22.sp,
            color = AppColors.mOffWhite

        )
    }
}

@Composable
fun QuestionChoices(
    choices: List<String>,
    correntAnswer: Int?,
    onChoiceAnswer: (Int?) -> Unit
) {
    val answerState = remember {
        mutableStateOf<Int?>(null)
    }
    choices.forEachIndexed { index, answerText ->
        Row(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .height(45.dp)
                .border(
                    width = 4.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            AppColors.mOffDarkPurple,
                            AppColors.mOffDarkPurple
                        )
                    ),
                    shape = RoundedCornerShape(15.dp)
                )
                .clip(
                    RoundedCornerShape(
                        topStartPercent = 50,
                        topEndPercent = 50,
                        bottomEndPercent = 50,
                        bottomStartPercent = 50
                    )
                )
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected =  answerState.value == index,
                onClick = {
                    answerState.value = index
                    onChoiceAnswer(index)
                },
                modifier = Modifier
                    .padding(start = 16.dp),
                colors = RadioButtonDefaults.colors(
                    selectedColor =
                        if (correntAnswer == answerState.value) {
                            Color.Green.copy(alpha = 0.2f)
                        } else {
                            Color.Red.copy(alpha = 0.2f)
                        }
                ),
            )
            
            Text(
                text = answerText,
                style = TextStyle(
                    color = if (
                        correntAnswer == answerState.value &&
                            answerState.value == index
                    ) {
                        Color.Green.copy(alpha = 0.2f)
                    } else if (
                        correntAnswer != answerState.value &&
                        answerState.value == index
                    ) {
                        Color.Red.copy(alpha = 0.2f)
                    } else {
                        Color.White
                    }
                ),
                modifier = Modifier
                    .padding(12.dp)
            )
        }
    }
}

@Composable
fun NextQuestionButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier
                .padding(3.dp),
            shape = RoundedCornerShape(34.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppColors.mLightBlue
            ),
            onClick = {
                onClick.invoke()
            }
        ) {
            Text(
                text = "Next",
                modifier = Modifier.padding(4.dp),
                color = AppColors.mOffWhite,
                fontSize = 17.sp
            )
        }
    }
}
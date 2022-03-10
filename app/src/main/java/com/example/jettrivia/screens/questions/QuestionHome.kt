package com.example.jettrivia.screens.questions

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettrivia.screens.questions.components.Questions
import com.example.jettrivia.utils.AppColors

@Composable
fun QuestionHome(
    viewModel: QuestionViewModel = hiltViewModel(),
    ) {

    val questions = viewModel.data.value.data?.toMutableList()
    val questionIndex = remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = AppColors.mDarkPurple
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            if (viewModel.data.value.loading == true) {
                CircularProgressIndicator(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
            } else {
                viewModel.data.value.loading = false

                if (questions != null && questions.size > 0) {
                    Questions(
                        questions[questionIndex.value],
                        questionIndex.value,
                        questions.size
                    ) {
                        if (questionIndex.value < questions.size ) {
                            questionIndex.value += 1
                        }
                    }
                }

            }
            
        }
    }

}

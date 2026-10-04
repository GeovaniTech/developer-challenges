package br.com.govanidebastiani.dynamoxquiz.quiz.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import br.com.govanidebastiani.dynamoxquiz.app.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val playerNickname = savedStateHandle.toRoute<Route.QuizScreen>().playerNickname
    val ignoreIds = savedStateHandle.toRoute<Route.QuizScreen>().ignoreIds.toMutableList()

    private val _state = MutableStateFlow(QuizUIState())
    val state get() = _state.asStateFlow()

    fun checkSelectedOption(selectedOption: String) {

    }
}
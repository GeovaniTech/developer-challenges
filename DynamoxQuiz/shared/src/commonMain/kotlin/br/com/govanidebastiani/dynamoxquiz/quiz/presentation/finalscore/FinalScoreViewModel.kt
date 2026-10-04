package br.com.govanidebastiani.dynamoxquiz.quiz.presentation.finalscore

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import br.com.govanidebastiani.dynamoxquiz.app.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FinalScoreViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val quizId = savedStateHandle.toRoute<Route.FinalScore>().quizId
    val ignoreIds = savedStateHandle.toRoute<Route.FinalScore>().ignoreIds

    private val _state = MutableStateFlow(FinalScoreUIState())
    val state get() = _state.asStateFlow()
}
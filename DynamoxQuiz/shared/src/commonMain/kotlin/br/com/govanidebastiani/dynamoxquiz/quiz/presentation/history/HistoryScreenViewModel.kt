package br.com.govanidebastiani.dynamoxquiz.quiz.presentation.history

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HistoryScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(HistoryScreenUIState())
    val state get() = _state.asStateFlow()
}
package br.com.govanidebastiani.dynamoxquiz.player.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlayerViewModel: ViewModel() {
    private val _state = MutableStateFlow(PlayerUIState())
    val state get() = _state.asStateFlow()

    fun onNicknameChanged(nickname: String) {
        _state.update {
            it.copy(playerNickname = nickname)
        }
    }

    fun onStartQuizClick() {

    }

    fun onNavigationToQuizFinished() {
        _state.update { it.copy(isStartQuiz = false) }
    }
}
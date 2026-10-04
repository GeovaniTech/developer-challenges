package br.com.govanidebastiani.dynamoxquiz.player.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.govanidebastiani.dynamoxquiz.core.domain.DataError
import br.com.govanidebastiani.dynamoxquiz.core.domain.toStringResource
import br.com.govanidebastiani.dynamoxquiz.player.domain.usecase.CreatePlayerUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayerViewModel(
    private val createPlayerUseCase: CreatePlayerUseCase
): ViewModel() {
    private val _state = MutableStateFlow(PlayerUIState())
    val state get() = _state.asStateFlow()

    fun onNicknameChanged(nickname: String) {
        _state.update {
            it.copy(playerNickname = nickname)
        }
    }

    fun onStartQuizClick() = viewModelScope.launch {
        val result = createPlayerUseCase.invoke(_state.value.playerNickname)

        if (result.isSuccess) {
            _state.update {
                it.copy(isStartQuiz = true)
            }
        } else {
            _state.update {
                it.copy(isStartQuiz = false, errorMessage = DataError.Local.UNKNOWN.toStringResource())
            }
        }
    }

    fun onNavigationToQuizFinished() {
        _state.update { it.copy(isStartQuiz = false) }
    }
}
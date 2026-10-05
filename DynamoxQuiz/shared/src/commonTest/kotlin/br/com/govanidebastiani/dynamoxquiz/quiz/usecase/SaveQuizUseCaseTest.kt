package br.com.govanidebastiani.dynamoxquiz.quiz.usecase

import br.com.govanidebastiani.dynamoxquiz.quiz.data.FakeQuizRepositoryImpl
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.Quiz
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.usecase.SaveQuizUseCase
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Clock

class SaveQuizUseCaseTest {
    private lateinit var fakeQuizRepositoryImpl: FakeQuizRepositoryImpl
    private lateinit var saveQuizUseCase: SaveQuizUseCase

    @BeforeTest
    fun setup() {
        fakeQuizRepositoryImpl = FakeQuizRepositoryImpl()
        saveQuizUseCase = SaveQuizUseCase(fakeQuizRepositoryImpl)
    }

    @Test
    fun  `deve retornar o id do quiz apos salvar`() = runTest {
        val quizId = fakeQuizRepositoryImpl.createQuiz(
            quiz = Quiz(
                id = 1,
                playerNickname = "Geovani",
                amountCorrectAnswers = 10,
                amountQuestions = 10,
                createdAt = Clock.System.now().toEpochMilliseconds()
            )
        )

        assertEquals(1, quizId)

        val secondQuiz = fakeQuizRepositoryImpl.createQuiz(
            quiz = Quiz(
                id = 2,
                playerNickname = "Pedro",
                amountCorrectAnswers = 10,
                amountQuestions = 10,
                createdAt = Clock.System.now().toEpochMilliseconds()
            )
        )
        assertEquals(2, secondQuiz)
    }
 }
package br.com.govanidebastiani.dynamoxquiz.quiz.data.local

import br.com.geovanidebastiani.dynamoxquiz.db.QuizQueries
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.Quiz
import kotlinx.coroutines.flow.Flow

class QuizLocalDataSource(
    private val quizQueries: QuizQueries
) {
    fun createQuiz(quiz: Quiz): Long {
        quizQueries.insertQuiz(
            amountQuestions = quiz.amountQuestions,
            amountCorrectAnswers = quiz.amountCorrectAnswers,
            createdAt = quiz.createdAt,
            playerNickname = quiz.playerNickname
        )

        return quizQueries.lastInsertRowId().executeAsOne()
    }

    fun fetchQuiz(quizId: Long): Quiz {
        return quizQueries.fetchQuizById(quizId) { id, playerNickname, amountQuestions, amountCorrectAnswers, createdAt ->
            Quiz(
                id = id,
                playerNickname = playerNickname,
                amountQuestions = amountQuestions,
                amountCorrectAnswers = amountCorrectAnswers,
                createdAt = createdAt
            )
        }.executeAsOne()
    }

    fun fetchAllQuizzes(): List<Quiz> {
        return quizQueries.queryAllQuiz() { id, playerNickname, amountQuestions, amountCorrectAnswers, createdAt ->
            Quiz(
                id = id,
                playerNickname = playerNickname,
                amountQuestions = amountQuestions,
                amountCorrectAnswers = amountCorrectAnswers,
                createdAt = createdAt
            )
        }.executeAsList()
    }
}
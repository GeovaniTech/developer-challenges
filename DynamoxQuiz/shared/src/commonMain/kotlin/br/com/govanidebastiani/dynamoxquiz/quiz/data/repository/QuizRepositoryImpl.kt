package br.com.govanidebastiani.dynamoxquiz.quiz.data.repository

import br.com.govanidebastiani.dynamoxquiz.core.domain.DataError
import br.com.govanidebastiani.dynamoxquiz.core.domain.Result
import br.com.govanidebastiani.dynamoxquiz.core.domain.map
import br.com.govanidebastiani.dynamoxquiz.quiz.data.dto.QuestionAnswerRequestDto
import br.com.govanidebastiani.dynamoxquiz.quiz.data.dto.QuestionAnswerResponseDto
import br.com.govanidebastiani.dynamoxquiz.quiz.data.local.QuizLocalDataSource
import br.com.govanidebastiani.dynamoxquiz.quiz.data.mappers.toQuestion
import br.com.govanidebastiani.dynamoxquiz.quiz.data.remote.QuizRemoteDataSource
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.Question
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.Quiz
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.repository.QuizRepository

class QuizRepositoryImpl(
    private val quizLocalDataSource: QuizLocalDataSource,
    private val quizRemoteDataSource: QuizRemoteDataSource
): QuizRepository {
    override suspend fun fetchQuestion(): Result<Question, DataError.Remote> {
        return quizRemoteDataSource.fetchQuestion().map {
            it.toQuestion()
        }
    }

    override suspend fun submitAnswer(
        questionId: String,
        answer: String
    ): Result<QuestionAnswerResponseDto, DataError.Remote> {
        return quizRemoteDataSource.submitAnswer(questionId, QuestionAnswerRequestDto(answer))
    }

    override suspend fun createQuiz(quiz: Quiz): Long {
        return quizLocalDataSource.createQuiz(quiz)
    }

    override suspend fun fetchQuizById(quizId: Long): Quiz {
        return quizLocalDataSource.fetchQuiz(quizId)
    }
}
package br.com.govanidebastiani.dynamoxquiz.quiz.domain.repository

import br.com.govanidebastiani.dynamoxquiz.core.domain.DataError
import br.com.govanidebastiani.dynamoxquiz.core.domain.Result
import br.com.govanidebastiani.dynamoxquiz.quiz.data.dto.QuestionAnswerResponseDto
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.Question
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.Quiz

interface QuizRepository {
    suspend fun fetchQuestion(): Result<Question, DataError.Remote>
    suspend fun submitAnswer(questionId: String, answer: String): Result<QuestionAnswerResponseDto, DataError.Remote>
    suspend fun createQuiz(quiz: Quiz): Long
}
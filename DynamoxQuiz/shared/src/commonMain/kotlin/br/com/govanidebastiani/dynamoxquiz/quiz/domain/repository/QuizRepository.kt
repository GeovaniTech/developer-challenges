package br.com.govanidebastiani.dynamoxquiz.quiz.domain.repository

import br.com.govanidebastiani.dynamoxquiz.core.domain.DataError
import br.com.govanidebastiani.dynamoxquiz.core.domain.Result
import br.com.govanidebastiani.dynamoxquiz.quiz.domain.Question

interface QuizRepository {
    suspend fun fetchQuestion(): Result<Question, DataError.Remote>
}
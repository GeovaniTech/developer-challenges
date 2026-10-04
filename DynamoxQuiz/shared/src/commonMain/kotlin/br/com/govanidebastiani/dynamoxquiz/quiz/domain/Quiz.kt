package br.com.govanidebastiani.dynamoxquiz.quiz.domain

data class Quiz(
    val id: Long = 0,
    val playerNickname: String,
    val createdAt: Long,
    val amountCorrectAnswers: Long,
    val amountQuestions: Long
)
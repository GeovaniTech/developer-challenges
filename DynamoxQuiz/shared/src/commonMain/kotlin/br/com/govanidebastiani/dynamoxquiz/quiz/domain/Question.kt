package br.com.govanidebastiani.dynamoxquiz.quiz.domain

data class Question(
    val id: String,
    val statement: String,
    val options: List<String>
)

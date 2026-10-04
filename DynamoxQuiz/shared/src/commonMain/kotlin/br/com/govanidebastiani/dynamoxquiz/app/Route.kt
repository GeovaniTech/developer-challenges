package br.com.govanidebastiani.dynamoxquiz.app

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object AppGraph: Route

    @Serializable
    data object PlayerScreen: Route
}
package br.com.govanidebastiani.dynamoxquiz.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import br.com.govanidebastiani.dynamoxquiz.Greeting
import br.com.govanidebastiani.dynamoxquiz.player.presentation.PlayerScreen
import br.com.govanidebastiani.dynamoxquiz.player.presentation.PlayerScreenRoot
import br.com.govanidebastiani.dynamoxquiz.player.presentation.PlayerViewModel
import org.jetbrains.compose.resources.painterResource

import dynamoxquiz.shared.generated.resources.Res
import dynamoxquiz.shared.generated.resources.compose_multiplatform
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Route.AppGraph
        ) {
            navigation<Route.AppGraph>(
                startDestination = Route.PlayerScreen
            ) {
                composable<Route.PlayerScreen>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    val viewModel = koinViewModel<PlayerViewModel>()
                    PlayerScreenRoot(
                        viewModel = viewModel,
                        onNavigateToQuiz = {

                        }
                    )
                }
            }
        }
    }
}
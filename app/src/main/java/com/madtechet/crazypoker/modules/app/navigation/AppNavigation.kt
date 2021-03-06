package com.madtechet.crazypoker.modules.app.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madtechet.crazypoker.modules.game.presentation.GameScreen
import com.madtechet.crazypoker.modules.game.viewmodel.GameStartViewModel
import com.madtechet.crazypoker.modules.game.viewmodel.GameViewModel
import com.madtechet.crazypoker.modules.game.viewmodel.PlayerViewModel
import com.madtechet.crazypoker.modules.home.viewmodel.HomeViewModel
import com.madtechet.crazypoker.modules.home.presentation.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(navController, homeViewModel)
//            val containerViewModel: ContainerViewModel = hiltViewModel()
//            ContainerScreen(containerViewModel)
        }
        composable("${Screen.Game.route}/{gameId}") {
            val gameViewModel: GameViewModel = hiltViewModel()
            val gameStartViewModel: GameStartViewModel = hiltViewModel()
            val playerViewModel: PlayerViewModel = hiltViewModel()
            GameScreen(navController, gameViewModel, gameStartViewModel, playerViewModel)
        }
    }
}
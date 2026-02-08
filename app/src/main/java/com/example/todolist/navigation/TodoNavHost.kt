package com.example.todolist.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.todolist.pages.HomePage
import com.example.todolist.pages.LoginPage
import com.example.todolist.pages.SignupPage
import com.example.todolist.ui.feature.addedit.AddEditScreen
import com.example.todolist.ui.feature.auth.AuthViewModel
import com.example.todolist.ui.feature.list.ListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListRoute

@Serializable
data class AddEditRoute(val id: Long? = null)

@Composable
fun TodoNavHost(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login"){
            LoginPage(modifier, navController, authViewModel)

        }
        composable("signup"){
            SignupPage(modifier, navController, authViewModel)
        }

        composable<ListRoute>{
            ListScreen(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                authViewModel = authViewModel
            )
        }

        composable<AddEditRoute>(){backStackEntry ->
            val addEditRoute = backStackEntry.toRoute<AddEditRoute>()
            AddEditScreen(
                id = addEditRoute.id,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    })
}
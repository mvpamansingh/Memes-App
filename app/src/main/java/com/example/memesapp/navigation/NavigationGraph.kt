package com.example.memesapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.memesapp.FirstScreen.Presentation.DetailsScreen
import com.example.memesapp.FirstScreen.Presentation.FirstScreen
import com.example.memesapp.FirstScreen.Presentation.FirstScreenViewModel


@Composable
fun AppNavigator()
{

    val navigationcontroller= rememberNavController()





    NavHost(navController = navigationcontroller, startDestination = NavigationRoutes.FirstScree.routes )
    {
        // add nav argument to pass id to Details screen

        composable(NavigationRoutes.FirstScree.routes)
        {
            val vm= hiltViewModel<FirstScreenViewModel>()

            val state by vm.state.collectAsState()

            FirstScreen(state =state , event =vm::event , viewModel = vm, navigationcontroller)
        }


        composable(route="details_screen?name={memeName}&url={url}",
            arguments= listOf(

            navArgument(name="memeName")
            {
                type= NavType.StringType
            },
            navArgument(name= "url")
            {
                type= NavType.StringType
            }

        )
        )
        {
            DetailsScreen(
                memename= it.arguments?.getString("memeName"),
                url= it.arguments?.getString("url")
            )
        }
    }











}
package github.com.GraziTDS.project_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import github.com.GraziTDS.project_navigation.screens.LoginScreen
import github.com.GraziTDS.project_navigation.screens.MenuScreen
import github.com.GraziTDS.project_navigation.screens.PedidosScreen
import github.com.GraziTDS.project_navigation.screens.PerfilScreen
import github.com.GraziTDS.project_navigation.ui.theme.ProjectnavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectnavigationTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(
                                modifier = Modifier.Companion.padding(innerPadding),
                                navController
                            )
                        }
                        composable(route = "menu") {
                            MenuScreen(
                                modifier = Modifier.Companion.padding(innerPadding),
                                navController
                            )
                        }
                        composable(route = "pedidos?cliente={cliente}", arguments = listOf(navArgument("client"){defaultValue = "Cliente Genérico"})) {
                            PedidosScreen(
                                modifier = Modifier.padding(innerPadding), navController, it.arguments?.getString("cliente")
                                navController
                            )
                        }
                        composable(route = "perfil/{nome}/{idade}", arguments = listOf(navArgument("nome") { type = NavType.StringType },
                            navArgument("idade") { type = NavType.IntType })) {
                            val nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
                            val idade: Int? = it.arguments?.getInt("idade", 0)
                            PerfilScreen(modifier = Modifier.padding(innerPadding), navController, nome!!, idade!!)
                        }
                    }
                }
            }
        }
    }
}
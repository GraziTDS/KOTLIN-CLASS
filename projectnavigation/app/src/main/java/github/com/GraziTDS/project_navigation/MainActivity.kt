package github.com.GraziTDS.project_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                        composable(route = "pedidos") {
                            PedidosScreen(
                                modifier = Modifier.Companion.padding(innerPadding),
                                navController
                            )
                        }
                        composable(route = "perfil") {
                            PerfilScreen(
                                modifier = Modifier.Companion.padding(innerPadding),
                                navController
                            )
                        }
                    }
                }
            }
        }
    }
}
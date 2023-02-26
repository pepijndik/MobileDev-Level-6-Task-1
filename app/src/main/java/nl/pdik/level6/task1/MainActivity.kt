package nl.pdik.level6.task1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nl.pdik.level6.task1.ui.theme.Task1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task1Theme {
                // A surface container using the 'background' color from the theme
                Level6Task1App()
            }
        }
    }
}
@Composable
fun Level6Task1App() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) }
            )
        }
    ) { innerPadding ->
        TestText(navController, modifier = Modifier.padding(innerPadding))
    }

}

/**
 * You can see this as a nav_graph.xml in compose
 */
@Composable
fun TestText(navController: NavHostController, modifier: Modifier = Modifier) {
    //TODO: we change this code later
    Text("It works! - remove this text later")
}
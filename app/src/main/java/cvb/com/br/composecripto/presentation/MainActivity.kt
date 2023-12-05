package cvb.com.br.composecripto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cvb.com.br.composecripto.presentation.common.component.NavigationComponent
import cvb.com.br.composecripto.presentation.ui.theme.ComposeCriptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCriptoTheme {
                NavigationComponent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCriptoTheme {
        NavigationComponent()
    }
}
package cvb.com.br.composecripto.presentation.common.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cvb.com.br.composecripto.R
import cvb.com.br.composecripto.presentation.ui.theme.ComposeCriptoTheme

@Composable
fun LoadingData() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IndeterminateCircularIndicator()

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            modifier = Modifier.padding(5.dp),
            text = stringResource(id = R.string.loading)
        )
    }

}

@Composable
@Preview
fun Test() {
    ComposeCriptoTheme {
        LoadingData()
    }
}
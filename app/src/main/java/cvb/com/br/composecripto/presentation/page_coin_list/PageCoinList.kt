package cvb.com.br.composecripto.presentation.page_coin_list

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import cvb.com.br.composecripto.R
import cvb.com.br.composecripto.presentation.common.component.LoadingData
import cvb.com.br.composecripto.presentation.common.component.RetryDialog
import cvb.com.br.composecripto.presentation.common.component.TopBar
import cvb.com.br.composecripto.presentation.page_coin_list.component.RowCoin
import cvb.com.br.composecripto.presentation.util.NavRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageCoinList(viewModel: PageCoinListViewModel = hiltViewModel(), navController: NavController) {

    Scaffold(
        topBar = {
            TopBar(R.string.app_name, Icons.Rounded.Home) { }
        },
    ) { innerPadding ->
        PageContent(viewModel, navController, innerPadding)
    }
}

@Composable
fun PageContent(
    viewModel: PageCoinListViewModel,
    navController: NavController,
    paddingValues: PaddingValues
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Log.i("Bonaldo", "Imprimindo dados")
            items(items = state.listCoin, key = { coin -> coin.id }) { coin ->
                RowCoin(coin = coin) { c ->
                    navController.navigate(route = NavRoute.RouteDetailCoin.route + "/${c.id}")
                }
            }
        }

        if (state.isLoading) {
            Log.i("Bonaldo", "Carregando dados")
            LoadingData()
        }

        state.stateError?.let { stateError ->
            if (state.showRetryDialog) {
                Log.i("Bonaldo", "Tratamento de Erro")

                val msgError =
                    stateError.msg ?: run { stringResource(id = stateError.idDefaultMsg) }

                RetryDialog(
                    onDismissRequest = { },
                    onRetry = {
                        viewModel.handelEvents(EventPageCoinList.EventRetryLoadData)
                    },
                    onCancel = {
                        viewModel.handelEvents(EventPageCoinList.EventDismissDialog)
                    },
                    dialogTitle = stringResource(id = R.string.error),
                    dialogText = msgError,
                    icon = Icons.Rounded.Warning
                )
            }
        }
    }
}

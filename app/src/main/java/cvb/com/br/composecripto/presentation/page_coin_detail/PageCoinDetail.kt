package cvb.com.br.composecripto.presentation.page_coin_detail

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import cvb.com.br.composecripto.R
import cvb.com.br.composecripto.presentation.common.component.LoadingData
import cvb.com.br.composecripto.presentation.common.component.RetryDialog
import cvb.com.br.composecripto.presentation.common.component.TopBar
import cvb.com.br.composecripto.presentation.page_coin_detail.component.CompCoinDetailHeader
import cvb.com.br.composecripto.presentation.page_coin_detail.component.CompCoinDetailTags
import cvb.com.br.composecripto.presentation.page_coin_detail.component.CompCoinDetailTeam

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageCoinDetail(
    viewModel: PageCoinDetailListViewModel = hiltViewModel(),
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopBar(R.string.detail, Icons.Rounded.ArrowBack) { navController.popBackStack() }
        },
    ) { innerPadding ->
        PageContent(viewModel, innerPadding)
    }
}

@Composable
fun PageContent(
    viewModel: PageCoinDetailListViewModel,
    paddingValues: PaddingValues
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        state.coinDetail?.let { coinDetail ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                item {
                    CompCoinDetailHeader(coinDetail)

                    if (coinDetail.tags.isNotEmpty()) {
                        CompCoinDetailTags(coinDetail)
                    }

                    if (coinDetail.team.isNotEmpty()) {
                        Text(
                            text = stringResource(id = R.string.members),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                itemsIndexed(coinDetail.team) { idx, team ->
                    CompCoinDetailTeam(team, idx < coinDetail.team.size - 1)
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
                        viewModel.handelEvents(EventPageDetailCoin.EventRetryLoadData)
                    },
                    onCancel = {
                        viewModel.handelEvents(EventPageDetailCoin.EventDismissDialog)
                    },
                    dialogTitle = stringResource(id = R.string.error),
                    dialogText = msgError,
                    icon = Icons.Rounded.Warning
                )
            }
        }
    }
}



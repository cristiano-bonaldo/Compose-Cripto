package cvb.com.br.composecripto.presentation.page_coin_list

import cvb.com.br.composecripto.domain.model.Coin
import cvb.com.br.composecripto.presentation.common.util.StateError

data class StatePageCoinList(
    val isLoading: Boolean = false,
    val listCoin: List<Coin> = emptyList(),
    val stateError: StateError? = null,
    val showRetryDialog: Boolean = false
)
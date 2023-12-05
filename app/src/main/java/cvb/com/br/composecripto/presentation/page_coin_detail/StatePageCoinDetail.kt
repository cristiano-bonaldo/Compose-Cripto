package cvb.com.br.composecripto.presentation.page_coin_detail

import cvb.com.br.composecripto.domain.model.CoinDetail
import cvb.com.br.composecripto.presentation.common.util.StateError

data class StatePageCoinDetail(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val stateError: StateError? = null,
    val showRetryDialog: Boolean = false
)
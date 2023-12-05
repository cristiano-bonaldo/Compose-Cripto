package cvb.com.br.composecripto.domain.use_case

import javax.inject.Inject

data class CoinUseCase @Inject constructor(
    val getListCoin: GetListCoin,
    val getCoinDetail: GetCoinDetail
)
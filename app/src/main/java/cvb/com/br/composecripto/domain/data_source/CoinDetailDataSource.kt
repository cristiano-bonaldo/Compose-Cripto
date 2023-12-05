package cvb.com.br.composecripto.domain.data_source

import cvb.com.br.composecripto.domain.model.CoinDetail

interface CoinDetailDataSource {

    suspend fun getCoinDetail(coinId: String): CoinDetail

}
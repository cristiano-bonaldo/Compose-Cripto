package cvb.com.br.composecripto.domain.repository

import cvb.com.br.composecripto.domain.model.CoinDetail

interface CoinDetailRepository {

    suspend fun getCoinDetail(coinId: String): CoinDetail

}
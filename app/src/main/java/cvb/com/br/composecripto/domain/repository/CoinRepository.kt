package cvb.com.br.composecripto.domain.repository

import cvb.com.br.composecripto.domain.model.Coin

interface CoinRepository {

    suspend fun getListCoin(): List<Coin>

}
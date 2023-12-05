package cvb.com.br.composecripto.domain.data_source

import cvb.com.br.composecripto.domain.model.Coin

interface CoinDataSource {

    suspend fun getListCoin(): List<Coin>

}
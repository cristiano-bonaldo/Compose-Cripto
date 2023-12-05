package cvb.com.br.composecripto.data.repository

import cvb.com.br.composecripto.domain.data_source.CoinDataSource
import cvb.com.br.composecripto.domain.model.Coin
import cvb.com.br.composecripto.domain.repository.CoinRepository

class CoinRepositoryImpl(private val coinDataSource: CoinDataSource) : CoinRepository {

    override suspend fun getListCoin(): List<Coin> =
        coinDataSource.getListCoin()

}
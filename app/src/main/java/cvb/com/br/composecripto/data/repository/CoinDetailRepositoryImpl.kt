package cvb.com.br.composecripto.data.repository

import cvb.com.br.composecripto.domain.data_source.CoinDetailDataSource
import cvb.com.br.composecripto.domain.model.CoinDetail
import cvb.com.br.composecripto.domain.repository.CoinDetailRepository

class CoinDetailRepositoryImpl(private val dataSource: CoinDetailDataSource) : CoinDetailRepository {

    override suspend fun getCoinDetail(coinId: String): CoinDetail = dataSource.getCoinDetail(coinId)

}
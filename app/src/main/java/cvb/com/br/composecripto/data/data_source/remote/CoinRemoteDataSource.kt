package cvb.com.br.composecripto.data.data_source.remote

import cvb.com.br.composecripto.data.api.service.ApiService
import cvb.com.br.composecripto.data.api.util.ApiHandleDataResult
import cvb.com.br.composecripto.data.api.util.toCoin
import cvb.com.br.composecripto.domain.data_source.CoinDataSource
import cvb.com.br.composecripto.domain.model.Coin
import javax.inject.Inject

class CoinRemoteDataSource(private val apiService: ApiService) : CoinDataSource {

    override suspend fun getListCoin(): List<Coin> {
        val listCoinDto = ApiHandleDataResult.handleData { apiService.getListCoin() }

        return listCoinDto.map { coinDto -> coinDto.toCoin() }
    }
}
package cvb.com.br.composecripto.data.data_source.remote

import cvb.com.br.composecripto.data.api.service.ApiService
import cvb.com.br.composecripto.data.api.util.ApiHandleDataResult
import cvb.com.br.composecripto.data.api.util.toCoinDetail
import cvb.com.br.composecripto.domain.data_source.CoinDetailDataSource
import cvb.com.br.composecripto.domain.model.CoinDetail

class CoinDetailRemoteDataSource(private val apiService: ApiService) : CoinDetailDataSource {

    override suspend fun getCoinDetail(coinId: String): CoinDetail {
        val coinDetailDto = ApiHandleDataResult.handleData { apiService.getCoinDetail(coinId) }

        return coinDetailDto.toCoinDetail()
    }
}
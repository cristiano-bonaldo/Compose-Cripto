package cvb.com.br.composecripto.data.api.service

import cvb.com.br.composecripto.data.api.dto.CoinDetailDto
import cvb.com.br.composecripto.data.api.dto.CoinDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {

    //https://api.coinpaprika.com/v1/
    @GET("coins/")
    suspend fun getListCoin(): Response<List<CoinDto>>

    //https://api.coinpaprika.com/v1/coins/{coin_id} -> Ex.: coin_id = btc-bitcoin
    @GET("coins/{coin_id}")
    suspend fun getCoinDetail(@Path("coin_id") coinId: String): Response<CoinDetailDto>

}
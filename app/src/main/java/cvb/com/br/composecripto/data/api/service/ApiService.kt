package cvb.com.br.composecripto.data.api.service

interface ApiService : CoinService {

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com/v1/"
    }

}

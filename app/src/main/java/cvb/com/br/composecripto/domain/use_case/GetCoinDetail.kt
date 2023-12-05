package cvb.com.br.composecripto.domain.use_case

import cvb.com.br.composecripto.domain.model.CoinDetail
import cvb.com.br.composecripto.domain.repository.CoinDetailRepository
import cvb.com.br.composecripto.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetail @Inject constructor(private val repository: CoinDetailRepository) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = repository.getCoinDetail(coinId)
            emit(Resource.Success(coinDetail))
        }
        catch (e: HttpException) {
            emit(Resource.Error(message = "HttpException: ${e.message ?: "Unexpected"}"))
        }
        catch (e: IOException) {
            emit(Resource.Error(message = "IOException: ${e.message ?: "Unexpected"}"))
        }
        catch (e: Exception) {
            emit(Resource.Error(message = "Exception: ${e.message ?: "Unexpected"}"))
        }
    }
}
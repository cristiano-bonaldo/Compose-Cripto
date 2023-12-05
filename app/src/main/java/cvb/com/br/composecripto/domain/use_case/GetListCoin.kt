package cvb.com.br.composecripto.domain.use_case

import cvb.com.br.composecripto.domain.model.Coin
import cvb.com.br.composecripto.domain.repository.CoinRepository
import cvb.com.br.composecripto.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetListCoin @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val list = repository.getListCoin()
            emit(Resource.Success(list))
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
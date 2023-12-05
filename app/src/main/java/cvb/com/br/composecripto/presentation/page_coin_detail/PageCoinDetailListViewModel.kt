package cvb.com.br.composecripto.presentation.page_coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cvb.com.br.composecripto.domain.use_case.CoinUseCase
import cvb.com.br.composecripto.domain.util.Resource
import cvb.com.br.composecripto.presentation.common.util.StateError
import cvb.com.br.composecripto.presentation.page_coin_list.EventPageCoinList
import cvb.com.br.composecripto.presentation.util.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PageCoinDetailListViewModel @Inject constructor(
    private val coinUseCase: CoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val mState = mutableStateOf(StatePageCoinDetail())
    val state: State<StatePageCoinDetail> = mState

    private var coinId: String? = null

    init {
        coinId = savedStateHandle.get<String>(Constant.NAV_PARAM_COIN_ID)
        getCoinDetail()
    }

    private fun getCoinDetail() {
        coinId?.let { id ->
            coinUseCase.getCoinDetail.invoke(id).onEach { resource ->

                when (resource) {
                    is Resource.Loading -> {
                        mState.value = StatePageCoinDetail(isLoading = true)
                    }

                    is Resource.Success -> {
                        mState.value = StatePageCoinDetail(coinDetail = resource.data)
                    }

                    is Resource.Error -> {
                        mState.value = StatePageCoinDetail(
                            stateError = StateError(resource.message),
                            showRetryDialog = true
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun dismissRetryDialog() {
        mState.value = mState.value.copy(stateError = null, showRetryDialog = false)
    }

    fun handelEvents(event: EventPageDetailCoin) {
        if (event is EventPageDetailCoin.EventRetryLoadData) {
            getCoinDetail()
        } else if (event is EventPageDetailCoin.EventDismissDialog) {
            dismissRetryDialog()
        }
    }

}
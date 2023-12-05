package cvb.com.br.composecripto.presentation.page_coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cvb.com.br.composecripto.domain.use_case.CoinUseCase
import cvb.com.br.composecripto.domain.util.Resource
import cvb.com.br.composecripto.presentation.common.util.StateError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PageCoinListViewModel @Inject constructor(
    private val coinUseCase: CoinUseCase
): ViewModel() {

    private val mState = mutableStateOf(StatePageCoinList())
    val state: State<StatePageCoinList>
        get() = mState

    init {
        getListCoin()
    }

    private fun getListCoin() {
        coinUseCase.getListCoin.invoke().onEach { resource ->

            when (resource) {
                is Resource.Loading -> {
                    mState.value = StatePageCoinList(isLoading = true)
                }
                is Resource.Success -> {
                    mState.value = StatePageCoinList(listCoin = resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    mState.value = StatePageCoinList(stateError = StateError(resource.message), showRetryDialog = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun dismissRetryDialog() {
        mState.value = mState.value.copy(stateError = null, showRetryDialog = false)
    }

    fun handelEvents(event: EventPageCoinList) {
        if (event is EventPageCoinList.EventRetryLoadData) {
            getListCoin()
        } else if (event is EventPageCoinList.EventDismissDialog) {
            dismissRetryDialog()
        }
    }
}
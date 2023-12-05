package cvb.com.br.composecripto.presentation.page_coin_detail

sealed class EventPageDetailCoin() {

    data object EventRetryLoadData : EventPageDetailCoin()

    data object EventDismissDialog : EventPageDetailCoin()

}
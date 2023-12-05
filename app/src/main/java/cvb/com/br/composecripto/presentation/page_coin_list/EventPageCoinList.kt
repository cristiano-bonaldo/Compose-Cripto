package cvb.com.br.composecripto.presentation.page_coin_list

sealed class EventPageCoinList() {

    data object EventRetryLoadData : EventPageCoinList()

    data object EventDismissDialog : EventPageCoinList()

}
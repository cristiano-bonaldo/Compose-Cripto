package cvb.com.br.composecripto.presentation.util

sealed class NavRoute(val route: String) {

    data object RouteCoinList: NavRoute("page_coin_list")

    data object RouteDetailCoin: NavRoute("page_coin_detail")

}

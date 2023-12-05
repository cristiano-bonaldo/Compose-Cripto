package cvb.com.br.composecripto.presentation.common.component

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cvb.com.br.composecripto.presentation.page_coin_detail.PageCoinDetail
import cvb.com.br.composecripto.presentation.page_coin_list.PageCoinList
import cvb.com.br.composecripto.presentation.util.Constant
import cvb.com.br.composecripto.presentation.util.NavRoute

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.RouteCoinList.route) {

        composable(route = NavRoute.RouteCoinList.route) {
            PageCoinList(navController = navController)
        }

        composable(route = NavRoute.RouteDetailCoin.route + "/{${Constant.NAV_PARAM_COIN_ID}}") {
            PageCoinDetail(navController = navController)
        }
    }
}
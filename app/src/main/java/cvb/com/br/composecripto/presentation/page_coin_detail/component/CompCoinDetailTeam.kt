package cvb.com.br.composecripto.presentation.page_coin_detail.component

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cvb.com.br.composecripto.domain.model.Team

@Composable
fun CompCoinDetailTeam(team: Team, isPrintDivisor: Boolean) {
    Text(
        text = team.name,
        fontSize = 18.sp,
    )

    Text(
        text = team.position,
        fontSize = 16.sp,
    )

    if (isPrintDivisor) {
        Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.primary)
    }
}

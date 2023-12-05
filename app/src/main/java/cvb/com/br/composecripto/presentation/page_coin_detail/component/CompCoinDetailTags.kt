package cvb.com.br.composecripto.presentation.page_coin_detail.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cvb.com.br.composecripto.R
import cvb.com.br.composecripto.domain.model.CoinDetail

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CompCoinDetailTags(coinDetail: CoinDetail) {
    Text(
        text = stringResource(id = R.string.tags),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(4.dp))

    FlowRow(horizontalArrangement = Arrangement.Start) {
        coinDetail.tags.forEach { tag ->
            Text(
                modifier = Modifier
                    .padding(5.dp)
                    .border(
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(100.dp)
                    )
                    .padding(5.dp),
                fontSize = 20.sp,
                text = tag,
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
}

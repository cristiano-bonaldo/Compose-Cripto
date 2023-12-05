package cvb.com.br.composecripto.domain.model

data class CoinDetail(
    val id: String,
    val isActive: Boolean,
    val logo: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<Team>,
    val type: String,
    val description: String
)
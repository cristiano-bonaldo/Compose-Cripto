package cvb.com.br.composecripto.data.api.dto

import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hashAlgorithm")
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: LinksDto,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtendedDto>,
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<TagDto>,
    val team: List<TeamDto>,
    val type: String,
    @SerializedName("whitepaper")
    val whitePaper: WhitePaper
)
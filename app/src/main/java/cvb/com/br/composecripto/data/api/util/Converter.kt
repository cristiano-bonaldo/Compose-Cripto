package cvb.com.br.composecripto.data.api.util

import cvb.com.br.composecripto.data.api.dto.CoinDetailDto
import cvb.com.br.composecripto.data.api.dto.CoinDto
import cvb.com.br.composecripto.data.api.dto.TeamDto
import cvb.com.br.composecripto.domain.model.Coin
import cvb.com.br.composecripto.domain.model.CoinDetail
import cvb.com.br.composecripto.domain.model.Team

fun CoinDto.toCoin() =
    Coin(
        id = this.id,
        isActive = this.isActive,
        isNew = this.isNew,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol,
        type = this.type
    )

fun CoinDetailDto.toCoinDetail() =
    CoinDetail(
        id = this.id,
        isActive = this.isActive,
        logo = this.logo,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol,
        tags = this.tags.map { tagDto -> tagDto.name },
        team = this.team.map { teamDto -> teamDto.toTeam() },
        type = this.type,
        description = this.description
    )

fun TeamDto.toTeam() = 
    Team(
        name = this.name,
        position = this.position   
    )
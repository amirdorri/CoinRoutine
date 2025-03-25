package dev.coinroutine.app.coins.domain

import dev.coinroutine.app.coins.data.mapper.toCoinModel
import dev.coinroutine.app.coins.domain.api.CoinRemoteDataSource
import dev.coinroutine.app.coins.domain.model.CoinModel
import dev.coinroutine.app.core.domain.DataError
import dev.coinroutine.app.core.domain.Result
import dev.coinroutine.app.core.domain.map


class GetCoinDetailsUseCase(private val client: CoinRemoteDataSource, ) {

    suspend fun execute(coinId: String): Result<CoinModel, DataError.Remote> {
        return client.getCoinById(coinId).map { dto ->
            dto.data.coin.toCoinModel()
        }
    }
}
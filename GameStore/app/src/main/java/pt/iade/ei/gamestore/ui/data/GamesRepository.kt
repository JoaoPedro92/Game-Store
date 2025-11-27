package pt.iade.ei.gamestore.data

import pt.iade.ei.gamestore.ui.classes.GameData
import pt.iade.ei.gamestore.ui.controllers.GetShopDLCs
import pt.iade.ei.gamestore.ui.controllers.GetShopGames
import kotlin.collections.List

object GamesRepository {
    private var cache: List<GameData>? = null

    fun getCached(): List<GameData> {
        return cache ?: emptyList()
    }

    fun setCache(list: List<GameData>) {
        cache = list
    }

    fun clearCache() {
        cache = null
    }

    fun updateGamesList(onComplete: (List<GameData>) -> Unit) {
        GetShopGames { shopGames ->
            try {
                setCache(shopGames)
                onComplete(shopGames)
            } catch (e: Exception) {
                onComplete(emptyList())
            }
        }
    }

    fun getGameById(id: Int): GameData? {
        val list: List<GameData> = getCached() ?: emptyList()

        return list.find { game -> game.id == id }
    }

    fun hasCache(): Boolean {
        return cache != null
    }
}

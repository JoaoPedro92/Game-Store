package pt.iade.ei.gamestore.data

import pt.iade.ei.gamestore.ui.classes.DLCData
import pt.iade.ei.gamestore.ui.classes.GameData
import pt.iade.ei.gamestore.ui.controllers.GetShopDLCs
import pt.iade.ei.gamestore.ui.controllers.GetShopGames
import kotlin.collections.List

object DLCsRepository {
    private var cache: List<DLCData>? = null

    fun getCached(): List<DLCData> {
        return cache ?: emptyList()
    }

    fun setCache(list: List<DLCData>) {
        cache = list
    }

    fun clearCache() {
        cache = null
    }

    fun updateDLCList(onComplete: (List<DLCData>) -> Unit) {
        GetShopDLCs { shopDLC ->
            try {
                setCache(shopDLC)
                onComplete(shopDLC)
            } catch (e: Exception) {
                onComplete(emptyList())
            }
        }
    }

    fun getDLCById(id: Int): DLCData? {
        val list: List<DLCData> = getCached() ?: emptyList()

        return list.find { dlc -> dlc.id == id }
    }

    fun hasCache(): Boolean {
        return cache != null
    }
}

package pt.iade.ei.gamestore.ui.controllers


import androidx.compose.runtime.Composable
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.data.GamesRepository
import pt.iade.ei.gamestore.ui.classes.DLCData
import pt.iade.ei.gamestore.ui.classes.GameData

val shopGames = listOf(
    GameData(1, "GTA V", "A very good game!", R.drawable.gtav),
    GameData(2, "FIFA 26", "Classic game to break controllers!", R.drawable.fifa25),
    GameData(3, "Minecraft", "Well, here we go again!", R.drawable.minecraft)
)

fun GetShopGames(callback: (List<GameData>) -> Unit) {
    callback(shopGames)
}
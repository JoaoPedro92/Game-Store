package pt.iade.ei.gamestore.ui.controllers


import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.ui.models.GameData

val shopGames = listOf(
    GameData(1, "GTA V", "A glorious mess in Los Santos: epic heists, crazy characters, and total freedom to do.", R.drawable.gtav),
    GameData(2, "FIFA 26", "The classic game that makes you swear you'll never play again… great to break controllers on each kickoff.", R.drawable.fifa25),
    GameData(3, "Minecraft", "A world ruled by imagination: build massive castles and run from Creepers!", R.drawable.minecraft)
)

fun GetShopGames(callback: (List<GameData>) -> Unit) {
    callback(shopGames)
}
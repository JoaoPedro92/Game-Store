package pt.iade.ei.gamestore.ui.classes

data class DLCData(
    val id: Int,
    val gameId: Int,
    val DLCName : String,
    val DLCDescription: String,
    val DLCPrice: Double,
    val imageRes: Int,
)
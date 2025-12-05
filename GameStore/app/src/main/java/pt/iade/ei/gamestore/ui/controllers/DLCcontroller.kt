package pt.iade.ei.gamestore.ui.controllers

import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.ui.models.DLCData

val shopGamesDLCs = listOf(
    DLCData(1, 1, "Shark Card 500", "Buy now coins for your game, higher prices, higher rewards, this pack includes 500 coins", 9.99, R.drawable.sharkcards),
    DLCData(2, 1, "Shark Card 1000", "Boost your GTA V experience with 1000 bonus credits. Perfect for quick upgrades, new gear, or just living large in Los Santos!", 14.99, R.drawable.sharkcards),
    DLCData(3, 1, "Shark Card 1500", "Go big with 1500 credits—ideal for major purchases, powerful vehicles, and high-end upgrades.", 19.99, R.drawable.sharkcards),

    DLCData(4, 2, "FIFA Coins 500", "EA FC 26 Coins are the main currency in EA Sports FIFA 26. This pack includes: 500 coins.", 4.99, R.drawable.fifacoins),
    DLCData(5, 2, "FIFA Coins 1000", "EA FC 26 Coins are the main currency in EA Sports FIFA 26. This pack includes: 1000 coins.", 9.99, R.drawable.fifacoins),
    DLCData(6, 2, "FIFA Coins 1500", "EA FC 26 Coins are the main currency in EA Sports FIFA 26. This pack includes: 1500 coins.", 14.99, R.drawable.fifacoins),

    DLCData(7, 3, "Rise of Horror", "Rise of Horror plunges you into a terrifying world where survival depends on your strength and strategy.", 4.99, R.drawable.fishing_minecraft),
    DLCData(8, 3, "Mine Mail", "Send items across the world like never before! This utility addon introduces a mailbox system that lets players deliver items to each other—perfect for multiplayer and Realms. Includes up to 612 unique mailbox designs with 36 variants and full color customization!", 9.99, R.drawable.minemail_minecraft),
    DLCData(9, 3, "Fishing++", "New fishing mechanics, advanced fish AI behaviors, complex aquarium systems, and many more inside this FISHING Add-On!", 6.99, R.drawable.fishing_minecraft)
)

fun GetShopDLCs(callback: (List<DLCData>) -> Unit) {
    callback(shopGamesDLCs)
}
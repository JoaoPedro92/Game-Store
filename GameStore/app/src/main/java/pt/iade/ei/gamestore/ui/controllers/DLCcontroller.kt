package pt.iade.ei.gamestore.ui.controllers

import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.ui.models.DLCData

val shopGamesDLCs = listOf(
    DLCData(1, 1, "Shark Card 500", "Buy now coins for your game, higher prices, higher rewards, this pack includes 500 coins", 9.99, R.drawable.sharkcards),
    DLCData(2, 1, "Luxury Garage Expansion", "Unlock 10 extra garage slots, exclusive neon lighting, and premium security features to protect your most valuable rides.", 14.99, R.drawable.gtav_garage_dlc),
    DLCData(3, 1, "Executive Office Upgrade", "Modernize your CEO office with luxury furniture, interactive screens, and a personal assistant AI for missions.", 19.99, R.drawable.gtav_offices_dlc),

    DLCData(4, 2, "FIFA Coins 500", "EA FC 26 Coins are the main currency in EA Sports FIFA 26. This pack includes: 500 coins.", 4.99, R.drawable.fifacoins),
    DLCData(5, 2, "FIFA Coins 1000", "EA FC 26 Coins are the main currency in EA Sports FIFA 26. This pack includes: 1000 coins.", 9.99, R.drawable.fifacoins),
    DLCData(6, 2, "Stadium Pack", "Unlock banners, fireworks, custom chants, and dynamic lighting for your stadium.", 14.99, R.drawable.fifa_stadium_dlc),

    DLCData(7, 3, "Rise of Horror", "Rise of Horror plunges you into a terrifying world where survival depends on your strength and strategy.", 4.99, R.drawable.riseofhorror_minecraft),
    DLCData(8, 3, "Mine Mail", "Send items across the world like never before! This utility addon introduces a mailbox system that lets players deliver items to each other—perfect for multiplayer and Realms. Includes up to 612 unique mailbox designs with 36 variants and full color customization!", 9.99, R.drawable.minemail_minecraft),
    DLCData(9, 3, "Fishing++", "New fishing mechanics, advanced fish AI behaviors, complex aquarium systems, and many more inside this FISHING Add-On!", 6.99, R.drawable.fishing_minecraft)
)

fun GetShopDLCs(callback: (List<DLCData>) -> Unit) {
    callback(shopGamesDLCs)
}
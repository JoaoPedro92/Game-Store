package pt.iade.ei.gamestore

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.ui.classes.DLCData
import pt.iade.ei.gamestore.ui.classes.GameData
import pt.iade.ei.gamestore.ui.components.BigGameCard
import pt.iade.ei.gamestore.ui.components.NavigationBar
import pt.iade.ei.gamestore.ui.theme.GameStoreTheme

val shopGames = listOf(
    GameData(1, "GTA V", "A very good game!", R.drawable.gtav),
    GameData(2, "Fifa 25", "Classic game to break controllers!", R.drawable.fifa25),
    GameData(3, "Minecraft", "Well, here we go again!", R.drawable.minecraft)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameStoreTheme {
                Scaffold(
                    bottomBar = {
                        NavigationBar(
                            context = this,
                            selectedIndex = 0
                        )
                    }
                ) { padding ->
                    GeneralPage()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GeneralPage() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "return",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))

            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "return",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = stringResource(R.string.company_name),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 24.dp),
        )

        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(560.dp)
        ) {
            items(shopGames) { gameData ->
                BigGameCard(gameData, context)
            }
        }
    }
}

@Composable
fun GetGameById(gameId: Int): GameData? {
    shopGames.forEach { gameData ->
        if (gameData.id == gameId) {
            return gameData
        }
    }

    return null;
}
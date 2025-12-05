package pt.iade.ei.gamestore

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import pt.iade.ei.gamestore.data.DLCsRepository
import pt.iade.ei.gamestore.data.GamesRepository
import pt.iade.ei.gamestore.ui.classes.DLCData
import pt.iade.ei.gamestore.ui.classes.GameData
import pt.iade.ei.gamestore.ui.components.GameDlcCardPurchase
import pt.iade.ei.gamestore.ui.components.GenerateGameDlcCards
import pt.iade.ei.gamestore.ui.theme.GameStoreTheme

class GameDetailActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var gameId = intent.getSerializableExtra("gameId") as Int

        setContent {
            GameStoreTheme {
                GameDetail(gameId)
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun GameDetail(gameId: Int) {
    val context = LocalContext.current
    var gameData = GamesRepository.getGameById(gameId)

    Column(
        modifier = Modifier
            .padding(all = 14.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "return",
                tint = Color.Black,
                modifier = Modifier
                    .clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    }
            )

            Text(
                text = gameData?.name ?: stringResource(R.string.not_found),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 24.dp),
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "return",
                tint = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Column {
                Image(
                    painter = painterResource(
                        id = gameData?.imageRes ?: R.drawable.defaultimage
                    ),
                    contentDescription = "Imagem",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(130.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
            }
            Column {
                Text(
                    text = gameData?.description ?: stringResource(R.string.not_found),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .padding(all = 13.dp)
                )
            }
        }

        Text(
            text = stringResource(R.string.purchasable_items),
            color = Color.Black,
            fontSize = 22.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 20.dp),
        )

        var dlcList by remember { mutableStateOf<List<DLCData>>(emptyList()) }

        LaunchedEffect(Unit) {
            if (DLCsRepository.hasCache()) {
                dlcList = DLCsRepository.getCached()
            } else {
                DLCsRepository.updateDLCList { dlcData ->
                    dlcList = dlcData
                }
            }
        }

        GenerateGameDlcCards(dlcList, gameData?.id)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CheckForDLCDetails(dlcData: DLCData?, onClose: () -> Unit, onPurchase: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) { sheetState.expand() }

    ModalBottomSheet(
        onDismissRequest = {
            scope.launch {
                sheetState.hide()
                onClose()
            }
        },
        sheetState = sheetState
    ) {
        DLCDataContent(
            dlcData = dlcData,
            onPurchase = {
                scope.launch {
                    sheetState.hide()
                    onClose()
                    onPurchase()
                }
            }
        )
    }
}

@Composable
fun DLCDataContent(dlcData: DLCData?, onPurchase: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        GameDlcCardPurchase(dlcData, onPurchase)
    }
}



///////////////

@Preview(showBackground = true)
@Composable
fun GameDetailPreview() {
    val context = LocalContext.current
    var gameData = GameData(3, "Minecraft", "Well, here we go again!", R.drawable.minecraft)

    Column(
        modifier = Modifier
            .padding(all = 14.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "return",
                tint = Color.Black,
                modifier = Modifier
                    .clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    }
            )

            Text(
                text = gameData?.name ?: stringResource(R.string.not_found),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 24.dp),
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "return",
                tint = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Column {
                Image(
                    painter = painterResource(
                        id = gameData?.imageRes ?: R.drawable.defaultimage
                    ),
                    contentDescription = "Imagem",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(130.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
            }
            Column {
                Text(
                    text = gameData?.description ?: stringResource(R.string.not_found),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .padding(all = 13.dp)
                )
            }
        }

        Text(
            text = stringResource(R.string.purchasable_items),
            color = Color.Black,
            fontSize = 22.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 20.dp),
        )

        var dlcList by remember { mutableStateOf<List<DLCData>>(emptyList()) }

        LaunchedEffect(Unit) {
            if (DLCsRepository.hasCache()) {
                dlcList = DLCsRepository.getCached()
            } else {
                DLCsRepository.updateDLCList { dlcData ->
                    dlcList = dlcData
                }
            }
        }

        GenerateGameDlcCards(dlcList, gameData?.id)
    }
}
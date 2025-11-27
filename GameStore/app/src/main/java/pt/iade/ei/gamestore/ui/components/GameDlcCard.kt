package pt.iade.ei.gamestore.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.CheckForDLCDetails
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.ui.classes.DLCData

//@Preview(showBackground = true)
@Composable
fun GenerateGameDlcCards(dlcData: List<DLCData>, gameId: Int?) {
    var selectedDLC by remember { mutableStateOf<DLCData?>(null) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(560.dp)
    ) {
        items(dlcData) { DLC ->
            if (gameId != null && DLC.gameId == gameId) {
                Row(
                    modifier = Modifier
                        .height(120.dp)
                        .padding(bottom = 10.dp)
                        .clickable {
                            selectedDLC = DLC
                        }
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Column {
                        Image(
                            painter = painterResource(
                                id = DLC.imageRes
                            ),
                            contentDescription = "Imagem",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(120.dp)
                                .clip(RoundedCornerShape(30.dp))
                        )
                    }
                    Column {
                        Spacer(modifier = Modifier.height(13.dp))

                        Text(
                            text = DLC.DLCName,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 20.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(horizontal = 13.dp)
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = DLC.DLCDescription,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            color = Color.DarkGray,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(horizontal = 13.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "$${DLC.DLCPrice}",
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(horizontal = 13.dp)
                        )
                    }
                }
            }
        }
    }

    if (selectedDLC != null) {
        CheckForDLCDetails(
            selectedDLC,
            onClose = {
                selectedDLC = null
            },
            onPurchase = {
                selectedDLC = null
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenerateGameDlcCardsPreview() {
    var dlcData = listOf(
        DLCData(1, 1, "Shark Card 500", "Buy now coins for your game, higher prices, higher rewards :P", 9.99, R.drawable.sharkcards),
        DLCData(2, 1, "Shark Card 1000", "Buy now coins for your game, higher prices, higher rewards :P", 14.99, R.drawable.sharkcards),
        DLCData(3, 1, "Shark Card 1500", "Buy now coins for your game, higher prices, higher rewards :P", 19.99, R.drawable.sharkcards),
    )

    var selectedDLC by remember { mutableStateOf<DLCData?>(null) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(560.dp)
    ) {
        items(dlcData) { DLC ->
            if (1 != null && DLC.gameId == 1) {
                Row(
                    modifier = Modifier
                        .height(120.dp)
                        .padding(bottom = 10.dp)
                        .clickable {
                            selectedDLC = DLC
                        }
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Column {
                        Image(
                            painter = painterResource(
                                id = DLC.imageRes
                            ),
                            contentDescription = "Imagem",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(120.dp)
                                .clip(RoundedCornerShape(30.dp))
                        )
                    }
                    Column {
                        Spacer(modifier = Modifier.height(13.dp))

                        Text(
                            text = DLC.DLCName,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 20.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(horizontal = 13.dp)
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = DLC.DLCDescription,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            color = Color.DarkGray,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(horizontal = 13.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "$${DLC.DLCPrice}",
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(horizontal = 13.dp)
                        )
                    }
                }
            }
        }
    }

    if (selectedDLC != null) {
        CheckForDLCDetails(
            selectedDLC,
            onClose = {
                selectedDLC = null
            },
            onPurchase = {
                selectedDLC = null
            }
        )
    }
}
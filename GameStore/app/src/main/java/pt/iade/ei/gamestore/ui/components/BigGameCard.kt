package pt.iade.ei.gamestore.ui.components


import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.GameDetailActivity
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.ui.models.GameData

//@Preview(showBackground = true)
@Composable
fun BigGameCard(gameData: GameData, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 3.dp)
            .clickable {
                val intent = Intent(context, GameDetailActivity::class.java)
                intent.putExtra("gameId", gameData.id)
                context.startActivity(intent)
            }
    ) {
        Box(
            modifier = Modifier
                .height(170.dp)
        ) {
            Image(
                painter = painterResource(
                    id = gameData.imageRes
                ),
                contentDescription = "Imagem",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.8f)
            )

            Text(
                text = gameData.name,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(13.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BigGameCardPreview() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 3.dp)
            .clickable { }
    ) {
        Box(
            modifier = Modifier
                .height(170.dp)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.defaultimage
                ),
                contentDescription = "Imagem",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.8f)
            )

            Text(
                text = stringResource(R.string.game_name),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(13.dp)
            )
        }
    }
}
package pt.iade.ei.gamestore.ui.components


import android.R.attr.onClick
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.ui.classes.DLCData

//@Preview(showBackground = true)
@Composable
fun GameDlcCardPurchase(dlcData: DLCData?) {
    Text(
        text = dlcData?.DLCName ?: stringResource(R.string.not_found),
        fontSize = 19.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(horizontal = 5.dp)
    )

    Spacer(modifier = Modifier.height(13.dp))

    Row(
        modifier = Modifier
            .height(140.dp)
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
    ) {
        Column {
            Image(
                painter = painterResource(
                    id = dlcData?.imageRes ?: R.drawable.defaultimage
                ),
                contentDescription = "Imagem",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(140.dp)
                    .clip(RoundedCornerShape(30.dp))
            )
        }
        Column {
            Spacer(modifier = Modifier.height(13.dp))

            Text(
                text = dlcData?.DLCName ?: stringResource(R.string.not_found),
                fontSize = 19.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 13.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = dlcData?.DLCDescription ?: stringResource(R.string.not_found),
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(horizontal = 13.dp)
            )
        }
    }

    val context = LocalContext.current
    val boughtTxt = stringResource(R.string.item_bought, dlcData?.DLCName ?: stringResource(R.string.not_found), "$${dlcData?.DLCPrice ?: 0.0}")

    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        )
        {
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "$${dlcData?.DLCPrice ?: 0.0}",
                fontSize = 19.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(horizontal = 13.dp)
            )
        }
        Column {
            Button(
                onClick = {
                    val toast = Toast.makeText(context, boughtTxt, Toast.LENGTH_LONG)
                    toast.show()
                },
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            ) {
                Text(
                    stringResource(R.string.buy_dlc)
                )
            }
        }
    }
}
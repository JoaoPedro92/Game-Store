package pt.iade.ei.gamestore.ui.components


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.CheckForDLCDetails
import pt.iade.ei.gamestore.shopGames
import pt.iade.ei.gamestore.ui.classes.DLCData

//@Preview(showBackground = true)
@Composable
fun NavigationBar(context: Context, selectedIndex: Int) {
    NavigationBar() {
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Featured")
                   },
            label = {
                Text("Featured")
            }
        )

        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.ExitToApp,
                    contentDescription = "History")
                   },
            label = {
                Text("History")
            }
        )

        NavigationBarItem(
            selected = selectedIndex == 2,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profile"
                ) },
            label = {
                Text("Profile")
            }
        )
    }
}
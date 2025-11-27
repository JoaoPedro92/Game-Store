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
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.CheckForDLCDetails
import pt.iade.ei.gamestore.ui.classes.DLCData

//@Preview(showBackground = true)
@Composable
fun NavigationBar(context: Context) {
    var selectedIndex by remember { mutableStateOf(0) }

    NavigationBar() {
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = { selectedIndex = 0 },
            icon = {
                Icon(
                    Icons.Outlined.Star,
                    contentDescription = "Featured")
                   },
            label = {
                Text("Featured")
            }
        )

        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { selectedIndex = 1 },
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
            onClick = { selectedIndex = 2 },
            icon = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "Profile"
                ) },
            label = {
                Text("Profile")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationBarPreview() {
    var selectedIndex by remember { mutableStateOf(0) }

    NavigationBar() {
        NavigationBarItem(
            selected = true,
            onClick = { selectedIndex = 0 },
            icon = {
                Icon(
                    Icons.Outlined.Star,
                    contentDescription = "Featured")
            },
            label = {
                Text("Featured")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { selectedIndex = 1 },
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
            selected = false,
            onClick = { selectedIndex = 2 },
            icon = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "Profile"
                ) },
            label = {
                Text("Profile")
            }
        )
    }
}
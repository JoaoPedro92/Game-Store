package pt.iade.ei.gamestore.ui.components


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore.R

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
                Text(stringResource(R.string.featured))
            }
        )

        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { selectedIndex = 1 },
            icon = {
                Image(
                    painter = painterResource(
                        id = R.drawable.archive
                    ),
                    contentDescription = "Imagem",
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(
                        color = Color.Black,
                    ),
                )
            },
            label = {
                Text(stringResource(R.string.history))
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
                Text(stringResource(R.string.profile))
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
                Text(stringResource(R.string.featured))
            }
        )

        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { selectedIndex = 1 },
            icon = {
                Image(
                    painter = painterResource(
                        id = R.drawable.archive
                    ),
                    contentDescription = "Imagem",
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(
                        color = Color.Black,
                    ),
                )
            },
            label = {
                Text(stringResource(R.string.history))
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
                Text(stringResource(R.string.profile))
            }
        )
    }
}
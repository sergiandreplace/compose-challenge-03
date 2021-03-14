package com.example.androiddevchallenge.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.*
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.*

@Composable
fun HomePage() {
    Scaffold(
        bottomBar = { HomeBottomBar() },
        floatingActionButton = { HomeFab() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        HomeBody(it)
    }
}

@Composable
private fun HomeBottomBar() {
    BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ },
            icon = {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    stringResource(R.string.navigation_home).toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.caption
                )
            }
        )
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ },
            icon = {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    stringResource(R.string.navigation_profile).toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.caption
                )
            }
        )
    }

}

@Composable
private fun HomeFab() {
    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.primary,
        onClick = { }
    ) {
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = stringResource(R.string.home_fab_description)
        )
    }
}

@Composable
private fun HomeBody(paddingValues: PaddingValues) {
    val (searchText, setSearchText) = remember { mutableStateOf("") }
    Column {
        Column(Modifier
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)) {
            Spacer(Modifier.height(56.dp))
            TextField(
                value = searchText,
                onValueChange = setSearchText,
                label = { Text(stringResource(R.string.login_email_label)) },
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
            )
            FavoriteCollections(
                title = stringResource(R.string.home_favorite_collections),
                favoriteCollections = favoriteCollections
            )
            Alignments(
                title = stringResource(R.string.home_align_your_body),
                topics = bodyAlignments
            )
            Alignments(
                title = stringResource(R.string.home_align_your_mind),
                topics = mindAlignments
            )
        }
    }


}

@Composable
private fun FavoriteCollections(title: String, favoriteCollections: List<FavoriteCollection>) {
    HomeSection(title) {
        HomeSectionLazyRow {
            items(com.example.androiddevchallenge.data.favoriteCollections.size / 2) { index ->
                Column {
                    Collection(favoriteCollections[index])
                    Spacer(Modifier.height(8.dp))
                    Collection(favoriteCollections[index + favoriteCollections.size / 2])
                }
            }
        }
    }
}

@Composable
private fun Collection(collection: FavoriteCollection) {
    Surface(Modifier
        .width(192.dp)
        .height(56.dp)
        .clip(MaterialTheme.shapes.small)
        .clickable { }
    ) {
        Row {
            Image(
                painterResource(collection.image),
                contentDescription = collection.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(collection.title,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp, end = 8.dp)
                    .width((192 - 56).dp))
        }
    }
}

@Composable
private fun Alignments(title: String, topics: List<AlignTopic>) {
    HomeSection(title) {
        HomeSectionLazyRow {
            items(topics) { topic ->
                AlignTopic(topic)
            }
        }
    }
}

@Composable
private fun AlignTopic(topic: AlignTopic) {
    Column {
        Image(
            painter = painterResource(topic.image),
            contentDescription = topic.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .size(88.dp),
        )
        Text(
            topic.title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
private fun HomeSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column {
        SectionTitle(title)
        content()
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(title.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h2,
        modifier = Modifier
            .paddingFromBaseline(top = 40.dp)
            .padding(start = 16.dp))
}

@Composable
private fun HomeSectionLazyRow(content: LazyListScope.() -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        content()
    }
}


@Preview("Home", heightDp = 640, widthDp = 320)
@Composable
fun HomePreview() {
    MyTheme(darkTheme = false) {
        HomePage()
    }
}

@Preview("Home dark", heightDp = 640, widthDp = 320)
@Composable
fun HomePreviewDark() {
    MyTheme(darkTheme = true) {
        HomePage()
    }
}
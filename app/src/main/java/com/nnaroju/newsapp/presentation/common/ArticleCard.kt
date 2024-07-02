package com.nnaroju.newsapp.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import com.nnaroju.newsapp.ui.theme.NewsAppTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ArticleCard(
    article: Article,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Card(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = modifier.clickable { onClick() }) {
            AsyncImage(
                modifier = Modifier
                    .size(96.dp),
                model = ImageRequest.Builder(context)
                    .data(article.urlToImage)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(96.dp)
            ) {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = article.source.name,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        modifier = Modifier.size(12.dp),
                        imageVector = Icons.Filled.Timer,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = formatDate(article.publishedAt),
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

private fun formatDate(publishedDate: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
    inputFormat.timeZone = java.util.TimeZone.getTimeZone("UTC")
    val date: Date? = inputFormat.parse(publishedDate)

    // Create a suffix function
    fun getDayWithSuffix(day: Int): String {
        return when (day % 10) {
            1 -> if (day == 11) "${day}th" else "${day}st"
            2 -> if (day == 12) "${day}th" else "${day}nd"
            3 -> if (day == 13) "${day}th" else "${day}rd"
            else -> "${day}th"
        }
    }

    // Format the date to "24th May 2024"
    val dayFormat = SimpleDateFormat("d", Locale.ENGLISH)
    val day = dayFormat.format(date).toInt()
    val dayWithSuffix = getDayWithSuffix(day)

    val monthYearFormat = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    val monthYear = monthYearFormat.format(date)

    // Combine day with suffix and month year
    val formattedDate = "$dayWithSuffix $monthYear"

    return formattedDate
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ArticleCardPreview() {
    NewsAppTheme {
        ArticleCard(
            article = Article(
                "Author",
                "content",
                "description",
                "2024-07-01T15:17:57Z",
                Source(id = "1", "name"),
                "title", "url", "imageurl"
            ),
            onClick = { /*TODO*/ }
        )
    }
}
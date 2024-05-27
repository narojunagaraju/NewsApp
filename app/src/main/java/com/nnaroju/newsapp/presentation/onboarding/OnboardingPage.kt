package com.nnaroju.newsapp.presentation.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nnaroju.newsapp.model.Page
import com.nnaroju.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnboardingPage(
    page: Page,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
                imageVector = page.imageVector,
                contentDescription = page.title,
                modifier = Modifier.size(80.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = 30.dp),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontStyle = FontStyle.Italic,
            maxLines = 7,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun OnboardingPagePreview() {
    NewsAppTheme {
        OnboardingPage(
            page = Page(
                "Hello",
                "Welcome to News app",
                imageVector = Icons.Filled.Star
            )
        )
    }
}
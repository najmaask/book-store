package com.najma.bookstore.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.najma.bookstore.R
import com.najma.bookstore.ui.theme.BookStoreTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painterResource(id = R.drawable.najma),
            contentDescription = "Photo Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Najma Assyifa Khairunnisa",
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            modifier = Modifier
                .padding(4.dp)
        )
        Text(
            text = "najmaassyifa574@gmail.com",
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Light,
                fontSize = 18.sp
            ),
            modifier = Modifier
                .padding(4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    BookStoreTheme {
        ProfileScreen()
    }
}
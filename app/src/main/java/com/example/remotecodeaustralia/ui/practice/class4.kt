package com.example.remotecodeaustralia.ui.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, widthDp = 300, heightDp = 300)
@Composable
fun Hello() {
    Box(contentAlignment = Alignment.Center) {
        // Text Property
        Text(text = "Jetpack Compose",
            fontWeight = FontWeight.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
            color = Color.Red,
            modifier= Modifier.fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.Center)
                .background(color = Color.Yellow, shape = RoundedCornerShape(10.dp))
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(10.dp),
            softWrap = true,
            maxLines = 1,
            minLines = 1,
            letterSpacing = 4.sp,
            textDecoration = TextDecoration.Underline,
            lineHeight = 40.sp,
        )
    }
}
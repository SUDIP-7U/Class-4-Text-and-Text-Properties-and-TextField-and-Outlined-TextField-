package com.example.remotecodeaustralia.ui.screens.remoteCodeCamp


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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

@Preview(showBackground = true)
@Composable
fun TextPropertyDemo() {
    Column(modifier = Modifier.height(300.dp).width(300.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Colored, sized, bold & italic",
            color = Color(0xFF6750A4),
            fontSize = 22.sp,
            minLines = 3,
            lineHeight = 28.sp,
            textAlign = TextAlign.Center,
            letterSpacing = 4.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
    }
}
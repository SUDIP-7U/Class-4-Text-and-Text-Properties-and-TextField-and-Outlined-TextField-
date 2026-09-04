package com.example.remotecodeaustralia.ui.screens.remoteCodeCamp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6750A4)
    )
}
@Composable
fun OutlinedBox(
    modifier: Modifier = Modifier,
    borderColor: Color = Color(0xFF79747E),
    borderWidth: Dp = 1.dp,
    cornerRadius: Dp = 12.dp,
    backgroundColor: Color = Color.Transparent,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .background(backgroundColor, RoundedCornerShape(cornerRadius))
            .border(BorderStroke(borderWidth, borderColor), RoundedCornerShape(cornerRadius)),
        content = content
    )
}

@Preview(showBackground = true,widthDp = 300, heightDp = 600)
@Composable
fun DemoKing(){

    // ---------- State for the input fields ----------
    var textFieldValue by remember { mutableStateOf("") }
    var outlinedFieldValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailValue by remember { mutableStateOf("") }
    var isEmailError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // style = a full TextStyle object (overrides individual params)
        Text(
            text = "Text driven entirely by a TextStyle object",
            style = TextStyle(
                color = Color(0xFF1B6B4A),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                letterSpacing = 1.sp,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                lineHeight = 26.sp
            )
        )

        HorizontalDivider()
        SectionTitle("OutlinedTextField")
        SectionTitle("TextField")
        SectionTitle("Text")
        SectionTitle("Outlined Box")
        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Name") },
            placeholder = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider()

        OutlinedTextField(
            value = outlinedFieldValue,
            onValueChange = { outlinedFieldValue = it },
            label = { Text("Bio") },
            placeholder = { Text("Tell us about yourself") },
            supportingText = { Text("${outlinedFieldValue.length}/150") },
            maxLines = 4,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider()

        OutlinedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color(0xFF79747E))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("OutlinedCard", fontWeight = FontWeight.Bold)
                Text(
                    "Material3's built-in outlined container.",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

        HorizontalDivider()

        OutlinedBox(
            borderColor = Color(0xFF6750A4),
            borderWidth = 2.dp,
            cornerRadius = 16.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Custom OutlinedBox", fontWeight = FontWeight.Bold)
                Text(
                    "A hand-rolled Box + border() for full control over " +
                            "color, width, corner radius and background.",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }


        OutlinedTextField(
            value = outlinedFieldValue,
            onValueChange = { outlinedFieldValue = it },
            label = { Text("Bio") },
            placeholder = { Text("Tell us about yourself") },
            supportingText = { Text("${outlinedFieldValue.length}/150") },
            maxLines = 4,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = emailValue,
            onValueChange = {
                emailValue = it
                isEmailError = it.isNotEmpty() && !it.contains("@")
            },
            label = { Text("Email") },
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null) },
            isError = isEmailError,
            supportingText = { if (isEmailError) Text("Enter a valid email address") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = passwordValue,
            onValueChange = { passwordValue = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (passwordVisible)
                VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.VisibilityOff
                        else Icons.Filled.Visibility,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

    }
}
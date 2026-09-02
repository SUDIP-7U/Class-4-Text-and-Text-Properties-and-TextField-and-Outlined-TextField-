package com.example.remotecodeaustralia.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetpackComponentsDemo() {
    // ---------- State for the input fields ----------
    var textFieldValue by remember { mutableStateOf("") }
    var outlinedFieldValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailValue by remember { mutableStateOf("") }
    var isEmailError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        // =========================================================
        // 1. TEXT — showcasing (almost) every property it exposes
        // =========================================================
        SectionTitle("Text")

        // Basic text
        Text(text = "Plain text — just the default style")

        // color, fontSize, fontWeight, fontStyle
        Text(
            text = "Colored, sized, bold & italic",
            color = Color(0xFF6750A4),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )

        // fontFamily
        Text(
            text = "Serif font family",
            fontFamily = FontFamily.Serif,
            fontSize = 18.sp
        )

        // letterSpacing
        Text(
            text = "W I D E   L E T T E R   S P A C I N G",
            letterSpacing = 4.sp
        )

        // textDecoration (underline / line-through / combined)
        Text(text = "Underlined text", textDecoration = TextDecoration.Underline)
        Text(text = "Strikethrough text", textDecoration = TextDecoration.LineThrough)
        Text(
            text = "Underline + strikethrough combined",
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.Underline, TextDecoration.LineThrough)
            )
        )

        // textAlign (needs a width to be visible)
        Text(
            text = "Centered text inside a full-width box",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        // lineHeight
        Text(
            text = "This text has extra line height so you can see the " +
                "spacing between each wrapped line clearly.",
            lineHeight = 28.sp,
            modifier = Modifier.fillMaxWidth()
        )

        // maxLines + overflow (Ellipsis)
        Text(
            text = "This is a very long sentence that will be cut off " +
                "after two lines because maxLines is set to 2 and the " +
                "overflow strategy is Ellipsis, so you'll see three dots " +
                "at the end instead of the full sentence.",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )

        // minLines
        Text(
            text = "Short text but reserves space for 3 lines (minLines)",
            minLines = 3,
            modifier = Modifier.fillMaxWidth()
        )

        // softWrap = false (forces a single line, can overflow/clip)
        Text(
            text = "softWrap = false → this line will not wrap and may clip",
            softWrap = false,
            maxLines = 1,
            overflow = TextOverflow.Clip
        )

        // onTextLayout callback
        var lineCount by remember { mutableIntStateOf(0) }
        Text(
            text = "onTextLayout reports how many lines this wraps into. " +
                "Try resizing the container to see the count change.",
            modifier = Modifier.fillMaxWidth(),
            onTextLayout = { result -> lineCount = result.lineCount }
        )
        Text(text = "↳ measured line count: $lineCount", fontSize = 12.sp, color = Color.Gray)

        // style = a full TextStyle object (overrides individual params)
        Text(
            text = "Text driven entirely by a TextStyle object",
            style = TextStyle(
                color = Color(0xFF1B6B4A),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                letterSpacing = 1.sp,
                textAlign = TextAlign.Start,
                textDecoration = TextDecoration.Underline,
                lineHeight = 26.sp
            )
        )

        HorizontalDivider()

        // =========================================================
        // 2. TEXTFIELD (filled / Material default)
        // =========================================================
        SectionTitle("TextField")

        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Name") },
            placeholder = { Text("Enter your name") },
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

        HorizontalDivider()

        // =========================================================
        // 3. OUTLINEDTEXTFIELD
        // =========================================================
        SectionTitle("OutlinedTextField")

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

        HorizontalDivider()

        // =========================================================
        // 4. "OUTLINED BOX"
        //    Compose has no composable literally named `OutlinedBox`,
        //    so this shows two ways to get that look:
        //      a) Material3's OutlinedCard  (the built-in equivalent)
        //      b) A custom reusable OutlinedBox(...) helper (below)
        // =========================================================
        SectionTitle("Outlined Box")

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
    }
}

/**
 * A small reusable "outlined box" — a Box wrapped in a border and
 * optional background, since Compose has no built-in composable
 * with this exact name.
 */
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

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6750A4)
    )
}

@Preview(showBackground = true)
@Composable
fun JetpackComponentsDemoPreview() {
    MaterialTheme {
        JetpackComponentsDemo()
    }
}

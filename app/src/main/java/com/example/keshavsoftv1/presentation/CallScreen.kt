package com.example.keshavsoftv1.presentation   // adjust if needed

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Text

@Composable
fun CallScreen(onClose: () -> Unit) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        // ---- Call button block, slightly ABOVE center ----
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-12).dp),      // move UP a bit
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    val intent = Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:9848163021")
                    )
                    context.startActivity(intent)
                },
                modifier = Modifier.size(92.dp),
                shape = CircleShape,
                colors = ButtonDefaults.primaryButtonColors()
            ) {
                Text(
                    text = "📞",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Call 9848163021",
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )
        }

        // ---- Bottom Close button, narrower width ----
        Chip(
            onClick = onClose,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(140.dp)            // not full width
                .padding(bottom = 12.dp),
            label = { Text("Close", fontSize = 13.sp) },
            icon = { Text("❌") },
            colors = ChipDefaults.secondaryChipColors()
        )
    }
}

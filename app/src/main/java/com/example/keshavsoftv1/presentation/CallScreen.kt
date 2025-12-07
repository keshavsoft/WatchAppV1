package com.example.keshavsoftv1.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText

@Composable
fun CallScreen(onClose: () -> Unit) {
    val context = LocalContext.current

    Scaffold(
        timeText = { TimeText() }   // small clock at top – standard Wear UI
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(6.dp))

            // Center – BIG circle Call button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:9848163021")
                        context.startActivity(intent)
                    },
                    modifier = Modifier.size(96.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.primaryButtonColors()
                ) {
                    Text(
                        text = "📞",
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Call 9848163021",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }

            // Bottom – Close chip
            Chip(
                onClick = onClose,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                label = {
                    Text(
                        text = "Close",
                        fontSize = 13.sp
                    )
                },
                icon = { Text("❌") },
                colors = ChipDefaults.secondaryChipColors()
            )
        }
    }
}

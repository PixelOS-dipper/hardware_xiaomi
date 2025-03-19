/*
 * Copyright (C) 2024 Paranoid Android
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package co.aospa.dolby.xiaomi.geq.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun TooltipIconButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    var showTooltip by remember { mutableStateOf(false) }

    Box {
        IconButton(
            onClick = {
                onClick()
                showTooltip = true
            }
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size(24.dp)
            )
        }

        if (showTooltip) {
            Popup(
                onDismissRequest = { showTooltip = false },
                properties = PopupProperties(focusable = false)
            ) {
                Box(modifier = Modifier.padding(8.dp)) {
                    Surface(
                        color = Color.Black,
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}


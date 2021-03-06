package com.madtechet.crazypoker.modules.home.presentation.components.create

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.madtechet.crazypoker.modules.home.presentation.components.ActionButton

@Composable
fun CreateGame(onCreateGame: (String) -> Unit) {
    var showUsernameDialog by remember { mutableStateOf(false) }

    ActionButton(onClick = { showUsernameDialog = true }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Create")
            Text(text = "Game")
        }
    }

    if (showUsernameDialog) {
        CreateGameDialog(
            onConfirm = {
                onCreateGame(it)
                showUsernameDialog = false
            },
            onDismiss = { showUsernameDialog = false },
        )
    }
}
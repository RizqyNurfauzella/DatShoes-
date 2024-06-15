package org.d3if3074.datshoes.ui.screen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.d3if3074.datshoes.R
import org.d3if3074.datshoes.model.Sepatu

@Composable
fun DeleteDialog(sepatu: Sepatu, onDismissRequest: () -> Unit, onConfirmation: (String) -> Unit, id: String) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = {
            Text(text = "Want to delete this ${sepatu.merk} item ?")
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmation(id)
            }) {
                Text(text = stringResource(id = R.string.hapus))
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text(text = stringResource(id = R.string.batal))
            }
        }
    )
}
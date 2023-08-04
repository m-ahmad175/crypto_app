package com.azcryptoapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    query: String,
    modifier: Modifier,
    onQueryChange: (String) -> Unit,
    onSearchAction: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    ) {
        TextField(

            value = query,

            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colors.background),
            onValueChange = {
                onQueryChange(it)
            },
            label = {
                Text(text = "Search")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "")
            },
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchAction()
                    keyboardController?.hide()
                }
            ),
            textStyle = TextStyle(
                color = MaterialTheme.colors.onSurface,
            )
        )
    }
}
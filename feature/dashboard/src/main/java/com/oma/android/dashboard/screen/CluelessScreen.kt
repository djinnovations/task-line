package com.oma.android.dashboard.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Themer
import com.oma.android.dashboard.R

@Composable
fun CluelessScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.TopCenter),
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(color = Themer.colors.ChateauGreen),
        )
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(30.dp),
            painter = painterResource(id = R.drawable.ic_clueless),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}
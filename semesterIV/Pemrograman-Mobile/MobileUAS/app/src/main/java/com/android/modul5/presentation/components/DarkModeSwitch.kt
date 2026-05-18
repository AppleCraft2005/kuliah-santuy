package com.android.modul5.presentation.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.modul5.R

@Composable
fun DarkModeSwitch(isDarkMode: Boolean, onToggle: (Boolean)->Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ) {
        Icon(
            painter = painterResource(id = R.drawable.sun_solid),
            contentDescription = "Icon Sun" ,
            modifier = Modifier.size(20.dp)

        )
        Spacer(modifier = Modifier.width(5.dp))
        Switch(
            checked = isDarkMode,
            onCheckedChange = onToggle
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            painter = painterResource(id = R.drawable.moon_solid),
            contentDescription = "Icon moon",
            modifier = Modifier.size(20.dp)
        )
    }

}
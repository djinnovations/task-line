package com.oma.android.login.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.backarrow.CircularBackButton
import com.oma.android.composeui.textinputfield.RoundedInputField
import com.oma.android.composeui.theme.Primary
import com.oma.android.composeui.theme.Themer

@Composable
fun RegisterScreen(onBack: () -> Unit, onRegister:(String, String, String) -> Unit) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val fullName = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = dimensionResource(com.intuit.sdp.R.dimen._16sdp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(com.intuit.sdp.R.dimen._40sdp)))

        // Back Arrow Icon
        CircularBackButton(onBack = onBack)

        Spacer(modifier = Modifier.height(dimensionResource(com.intuit.sdp.R.dimen._30sdp)))

        // Title
        Text(
            text = "Register",
            style = MaterialTheme.typography.titleLarge.copy(color = Themer.colors.ChateauGreen),
        )

        Spacer(modifier = Modifier.height(dimensionResource(com.intuit.sdp.R.dimen._4sdp)))

        Text(
            text = "Create your new account",
            style = MaterialTheme.typography.bodyMedium.copy(color = Themer.colors.SilverChalice)
        )

        Spacer(modifier = Modifier.height(dimensionResource(com.intuit.sdp.R.dimen._34sdp)))

        // Full Name
        RoundedInputField(
            value = fullName.value,
            onValueChange = { fullName.value = it },
            placeholder = "Full Name",
            icon = Icons.Default.Person,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(dimensionResource(com.intuit.sdp.R.dimen._12sdp)))

        // Email
        RoundedInputField(
            value = email.value,
            onValueChange = { email.value = it },
            placeholder = "user@mail.com",
            icon = Icons.Default.Email,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(dimensionResource(com.intuit.sdp.R.dimen._12sdp)))

        // Password
        var passwordVisible by remember { mutableStateOf(false) }
        RoundedInputField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = "••••••••",
            icon = Icons.Default.Lock,
            isPassword = !passwordVisible,
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.VisibilityOff
                        else Icons.Default.Visibility,
                        contentDescription = "Toggle Password"
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(dimensionResource(com.intuit.sdp.R.dimen._24sdp)))

        // Register Button
        Button(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            onClick = {
                onRegister.invoke(fullName.value, email.value, password.value)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Primary),
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.bodySmall,
            )
        }

        Spacer(modifier = Modifier.height(dimensionResource(com.intuit.sdp.R.dimen._20sdp)))
    }
}
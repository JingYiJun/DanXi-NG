package com.fduhole.danxinative.ui.component.settings

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fduhole.danxinative.ui.FDUUISViewState
import com.fduhole.danxinative.util.LoginState

@Composable
fun FDUUISLoginItem(
    fduState: LoginState<out FDUUISViewState>,
    showFDUUISLoginDialog: () -> Unit,
) {
    ListItem(
        headlineContent = {
            Text("复旦 UIS 账号")
        },
        supportingContent = {
            when (fduState) {
                is LoginState.Error -> {
                    Text("登录失败")
                }

                LoginState.Loading -> {
                    Text("登录中")
                }

                LoginState.NotLogin -> {
                    Text("未登录")
                }

                is LoginState.Success -> {
                    val name = fduState.data.name
                    val id = fduState.data.id
                    Text("已登录 - $name($id)")
                }
            }
        },
        leadingContent = {
            Icon(Icons.Filled.AccountCircle, contentDescription = "复旦 UIS 账号")
        },
        trailingContent = {
            when (fduState) {
                is LoginState.Error -> {
                    Icon(Icons.Filled.Error, contentDescription = "复旦 UIS 账号 - 登录失败")
                }

                LoginState.Loading -> {
                    CircularProgressIndicator()
                }

                LoginState.NotLogin -> {
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "复旦 UIS 账号 - 登录")
                }

                is LoginState.Success -> {
                    Icon(Icons.Filled.Check, contentDescription = "复旦 UIS 账号 - 登录成功")
                }
            }
        },
        modifier = Modifier.clickable {
            showFDUUISLoginDialog()
        },
    )
}
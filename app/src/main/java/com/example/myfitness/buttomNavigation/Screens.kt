package com.example.myfitness.buttomNavigation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myfitness.MainViewModel
import com.example.myfitness.data.Users

@Composable
fun LoginScreen(
    mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory),
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "FitPro",
            fontSize = 48.sp,
        )
        Text(
            modifier = Modifier
                .padding(50.dp),
            text = "Вход",
            fontSize = 24.sp
        )
        OutlinedTextField(value = mainViewModel.loginUser.value,
            onValueChange = {
                            mainViewModel.loginUser.value = it
            },
            label = { Text("Логин") }
        )
        OutlinedTextField(modifier = Modifier
            .padding(20.dp),
            value = mainViewModel.passwordUser.value,
            onValueChange = {
                            mainViewModel.passwordUser.value = it
            },
            label = { Text("Пароль") }
        )
        Button(
            modifier = Modifier.padding(50.dp),
            onClick = {
                val enteredLogin = mainViewModel.loginUser.value
                val enteredPassword = mainViewModel.passwordUser.value

                mainViewModel.checkLoginAndPassword(enteredLogin, enteredPassword, navController)
            }
        ) {
            Text("Войти")
        }
    }
}


@Composable
fun RegistrationScreen(
    mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory)
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "FitPro",
            fontSize = 48.sp,
        )
        Text(
            modifier = Modifier
                .padding(50.dp),
            text = "Регистрация",
            fontSize = 24.sp
        )
        OutlinedTextField(value = mainViewModel.nameUser.value,
            onValueChange = {
                mainViewModel.nameUser.value = it
            },
            label = { Text("Имя") }
        )
        OutlinedTextField(modifier = Modifier
            .padding(20.dp),
            value = mainViewModel.loginUser.value,
            onValueChange = {
                mainViewModel.loginUser.value = it
            },
            label = { Text("Логин") }
        )

        OutlinedTextField(modifier = Modifier
            .padding(20.dp),
            value = mainViewModel.passwordUser.value,
            onValueChange = {
                mainViewModel.passwordUser.value = it
            },
            label = { Text("Пароль") }
        )
        Button(
            modifier = Modifier
                .padding(50.dp),
            onClick = { mainViewModel.insertNewUser() },
        ) {
            Text("Зарегистрироваться")
        }
    }
}
@Composable
fun TrainScreen(){
Text(text = "fdgksjdk")
}

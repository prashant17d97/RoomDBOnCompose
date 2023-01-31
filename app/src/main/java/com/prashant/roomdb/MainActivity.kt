package com.prashant.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.prashant.roomdb.ui.HomeViewModel
import com.prashant.roomdb.ui.theme.RoomDBTheme
import com.prashant.roomdb.model.User

class MainActivity : ComponentActivity() {
    lateinit var user: User
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }


    @Composable
    fun Greeting(viewModel: HomeViewModel = hiltViewModel()) {


        var userID by remember {
            mutableStateOf("")
        }
        var userIDR by remember {
            mutableStateOf("")
        }
        var userName by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = userID,
                onValueChange = { userID = it },
                placeholder = { Text(text = "Enter User ID") })
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                placeholder = { Text(text = "Enter User Name") })
            Button(onClick = {
                if (userID.isNotEmpty() && userName.isNotEmpty()) {
                    viewModel.addEmployee(User(0, userID, userName))
                    userID = ""
                    userName = ""
                }
            }) {
                Text(text = "Save")
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = userIDR,
                onValueChange = { userIDR = it },
                placeholder = { Text(text = "Enter User ID") })
            Button(onClick = {
                if (userIDR.isNotEmpty()) {
                    viewModel.foundEmployee(userIDR).value.let {
                        if (it != null) {
                            user = it
                        }
                    }
                    userIDR = ""
                }
            }) {
                Text(text = "Retrieve")
            }
            if (::user.isInitialized) {
                Text(text = user.id.toString())
                Text(text = user.userId)
                Text(text = user.userName)
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        RoomDBTheme {
            Greeting()
        }
    }
}



package com.example.todolist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.navigation.TodoNavHost
import com.example.todolist.ui.feature.auth.AuthViewModel
import com.example.todolist.ui.theme.TodoListTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

private const val TAG = "MainActivity"


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val auth = Firebase.auth
//        Log.i(TAG, "onCreate usuario atual: ${auth.currentUser}")

//        auth.createUserWithEmailAndPassword(
//            "luiz@gmail.com",
//            "luiz123"
//        ).addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                Log.i(TAG, "create user: sucesso")
//            }else{
//                Log.i(TAG, "create user: falha -> ${task.exception}")
//            }
//        }

//        auth.signInWithEmailAndPassword(
//            "luiz@gmail.com",
//            "luiz123"
//        )

        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        setContent {
            Box(
                modifier = Modifier
                    .safeDrawingPadding()
            ){
                TodoListTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()){innerPadding ->
                        TodoNavHost(modifier = Modifier.padding(innerPadding), authViewModel)

                    }
                }
            }
        }
    }
}

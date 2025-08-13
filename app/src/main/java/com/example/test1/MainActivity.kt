package com.example.test1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
//import androidx.compose.material3.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test1.ui.theme.Test1Theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
//import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 主循环还是在MainActivity.kt中，这里是 activity
// 主循环，基于事件，基本是通用的开发模式

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Taxy",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                MyComponent()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
//        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello, fuck you!"
        )
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button(
            onClick = {Log.i("TAG","a button has been clicked")
        }) {
            Text(
                text = "Click Me"
            )
        }
    }

}

//父容器和子元素的关系，界面行列布局、流式布局

@Composable
fun MyComponent() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(400.dp),
        contentAlignment = Alignment.BottomCenter

    ) {
//        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Blue)
        ) {
            Column {
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "This is a button test"
                    )
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    item {
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = "This is a button test"
                            )
                        }
                    }


                    items(100) {
                        Text(
                            text = "Item $it",
                            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Test1Theme {
        Greeting("Android")
    }
    MyComponent()
}

fun sayHello() {
    println("Hello")
}

val greet: (String) -> Unit = { name ->
    println("Hello, $name")
}

fun doSomething(callback: (String) -> Unit) {
    callback("World")  // 调用回调
}

fun test_doSomething() {
    doSomething { name ->
        println("Hello, $name")
    }
}


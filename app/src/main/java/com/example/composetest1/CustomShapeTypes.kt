package com.example.composetest1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Boxes stack their content on top of each other inside itself
@Composable
fun BoxType1(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center

    ){
        Box(
            modifier = Modifier
                .height(250.dp)
                .width(100.dp)
                .background(Color.Blue),
            //.verticalScroll(rememberScrollState()),
        ){
            Text(text = "Hello World!", fontSize = 50.sp, color = Color.Red)
        }

    }
}

// Basic Surface for Rows
@Composable
fun RowScope.CustomItem(weight:Float, color: Color = MaterialTheme.colors.primary){
    Surface(
        modifier = Modifier
            .height(50.dp)
            .weight(weight),
        //.height(50.dp),
        color = color
    ) {}
}

// Composing columns in a Row using basic Row Surface
@Composable
fun RowType1(){
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
        //horizontalAlignment = Alignment.CenterHorizontally
        //verticalArrangement = Arrangement.Center
    ) {
        CustomItem(weight = 1f)
        CustomItem(weight = 3f, MaterialTheme.colors.secondary)
    }
}

// Basic Surface for Columns
@Composable
fun ColumnScope.CustomItem(weight:Float, color: Color = MaterialTheme.colors.primary){
    Surface(
        modifier = Modifier
            .width(50.dp)
            .weight(weight),
        //.height(50.dp),
        color = color
    ) {}
}

// Composing rows in a Column using basic Column Surface
@Composable
fun ColumnType1(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomItem(weight = 1f)
        CustomItem(weight = 3f, MaterialTheme.colors.secondary)
    }
}


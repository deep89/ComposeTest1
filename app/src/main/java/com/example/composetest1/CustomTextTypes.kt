package com.example.composetest1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextType1() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
            .width(200.dp),
        color = MaterialTheme.colors.background,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )
}

/*
@Composable
fun TextType2(){
    Text(
        buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(
                    textAlign = TextAlign.Center
                )
            ){
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                ){
                    append("A")
                }
                append("B")
                append("C")
                append("D")
            }
        }, modifier = Modifier.width(200.dp)
    )
}
*/



// Repeating Text
@Composable
fun TextType3(){

    Text(
        text = "Hello World! ".repeat(20),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}


// Enable/Disable selection of text
@Composable
fun TextType4(){

    SelectionContainer() {
        Column() {
            Text(text = "Hello Sun!")
            DisableSelection {
                Text(text = "Hello Sun!")
            }
            Text(text = "Hello Sun!")
        }
    }
}

// Subscript and Superscript Text Styles using variable attributes
@Composable
fun TextType5(
    subScript:String,
    subFontSize: TextUnit = MaterialTheme.typography.overline.fontSize,
    normalScript : String,
    normalFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    superScript: String,
    superFontSize: TextUnit = MaterialTheme.typography.overline.fontSize,
    fontWeight: FontWeight = FontWeight.Normal
){
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = subFontSize,
                    fontWeight = fontWeight,
                    baselineShift = BaselineShift.Subscript
                )
            ){
                append(subScript)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = normalFontSize
                )
            ){
                append(normalScript)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = superFontSize,
                    fontWeight = fontWeight,
                    baselineShift = BaselineShift.Superscript
                )
            ){
                append(superScript)
            }
        }
    )
}
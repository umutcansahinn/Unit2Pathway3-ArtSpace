package com.umutcansahin.unit2pathway3artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.umutcansahin.unit2pathway3artspace.ui.theme.Unit2Pathway3ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit2Pathway3ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   ArtSpaceApp()
                }
            }
        }
    }
}
@Composable
fun ArtSpaceApp(){

    var drawableNumber by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when(drawableNumber) {

            1 -> {
                ArtSpace(
                    artWorkTitle = R.string.Dice1,
                    artWorkYear = R.string.Dice1_Year,
                    artDrawable = R.drawable.dice_1
                )
            }
            2 -> {
                ArtSpace(
                    artWorkTitle = R.string.Dice2,
                    artWorkYear = R.string.Dice2_Year,
                    artDrawable = R.drawable.dice_2
                )
            }
            3 -> {
                ArtSpace(
                    artWorkTitle = R.string.Dice3,
                    artWorkYear = R.string.Dice3_Year,
                    artDrawable = R.drawable.dice_3
                )
            }
            4 -> {
                ArtSpace(
                    artWorkTitle = R.string.Dice4,
                    artWorkYear = R.string.Dice4_Year,
                    artDrawable = R.drawable.dice_4
                )
            }
            5 -> {
                ArtSpace(
                    artWorkTitle = R.string.Dice5,
                    artWorkYear = R.string.Dice5_Year,
                    artDrawable = R.drawable.dice_5
                )
            }
            6 -> {
                ArtSpace(
                    artWorkTitle = R.string.Dice6,
                    artWorkYear = R.string.Dice6,
                    artDrawable = R.drawable.dice_6
                )
            }
            else -> {
                if (drawableNumber > 6){
                    drawableNumber %= 6
                }

                if (drawableNumber < 1){
                    drawableNumber =+ 6
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
                .border(
                    BorderStroke(2.dp, Color(94, 53, 177, 255)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                          drawableNumber--
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(id = R.string.Button_Previous))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                          drawableNumber++
                },
                modifier = Modifier.weight(1f)

            ) {
                Text(text = stringResource(id = R.string.Button_Next))

            }
        }
    }
}

@Composable
fun ArtSpace(
    artWorkTitle: Int,
    artWorkYear: Int,
    artDrawable: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = artDrawable),
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize()
                .border(
                    BorderStroke(2.dp, Color(252, 112, 163, 255)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
                .border(
                    BorderStroke(2.dp, Color(0, 8, 9, 255)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = artWorkTitle),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = artWorkYear),
                fontSize = 22.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Unit2Pathway3ArtSpaceTheme {
        ArtSpaceApp()
    }
}
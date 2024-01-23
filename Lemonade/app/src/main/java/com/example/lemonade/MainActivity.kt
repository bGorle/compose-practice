package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lemonade()
                }
            }
        }
    }

    @Preview
    @Composable
    fun Lemonade() {
        LemonadeWithButtonAndImage(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }

    @Composable
    fun LemonadeWithButtonAndImage(
        modifier: Modifier = Modifier
    ) {
        val stateList = listOf(
            Triple(R.drawable.lemon_tree, R.string.lemon, R.string.tap_lemon),
            Triple(R.drawable.lemon_squeeze, R.string.lemon, R.string.tap_squeeze_lemon),
            Triple(R.drawable.lemon_drink, R.string.lemon, R.string.tap_lemonade_drink),
            Triple(R.drawable.lemon_restart, R.string.lemon, R.string.tap_empty_glass)
        )

        var result: Int by remember { mutableIntStateOf(1) }
        val resource: Triple<Int, Int, Int> = when (result) {
            1 -> stateList[0]
            2 -> stateList[1]
            3 -> stateList[2]
            else -> stateList[3]
        }
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = resource.first),
                contentDescription = stringResource(id = resource.second),
                modifier = Modifier
                    .size(width = 250.dp, height = 300.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF123434))
                    .clickable {
                        if (result >= 4) {
                            result /= result
                        }
                        result += 1
                    },
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = resource.third),
                fontSize = 18.sp
            )
        }
    }

    @Preview
    @Composable
    fun Dsdsd() {
        LemonadeTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Lemonade()
            }
        }
    }
}

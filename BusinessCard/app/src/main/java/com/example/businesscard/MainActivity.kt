package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF3ddc84)
                ) {
                    BusinessCardTheme {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Spacer(modifier = Modifier.fillMaxHeight(0.3f))
                            LogoCard("Jennifer Doe", "Android Developer Extraordinaire")
                            Spacer(modifier = Modifier.fillMaxHeight(0.7f))
                            UserDetails()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LogoCard(name: String, title: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val logoRes = painterResource(id = R.drawable.android_logo)
        Image(
            painter = logoRes,
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        )
        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = title, color = Color(0xFF3ddc84))
    }
}

@Composable
fun InfoItem(icon: ImageVector, text: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            icon, contentDescription = null,
            modifier = Modifier.padding(end = 16.dp),
        )
        Text(text = text)
    }
}

@Composable
fun UserDetails() {
    Column(Modifier.padding(bottom = 32.dp)) {
        InfoItem(Icons.Rounded.Call, stringResource(R.string.phone_number))
        InfoItem(Icons.Rounded.Share, stringResource(R.string.share_info))
        InfoItem(Icons.Rounded.Email, stringResource(R.string.user_email_id))
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme(dynamicColor = true) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.fillMaxHeight(0.3f))
            LogoCard("Jennifer Doe", "Android Developer Extraordinaire")
            Spacer(modifier = Modifier.fillMaxHeight(0.7f))
            UserDetails()
        }
    }
}
package com.example.greenharbor

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.greenharbor.ui.theme.GreenHarborTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenHarborTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TopAppBar(
                            title = {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_greenharbor),
                                    contentDescription = "Green Harbor Logo",
                                    modifier = Modifier
                                        .padding(start = 16.dp)
                                        .size(160.dp)
                                )
                            },
                            actions = {
                                Row(
                                    modifier = Modifier.padding(end = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_profile),
                                        contentDescription = "Profile Icon",
                                        modifier = Modifier
                                            .padding(end = 16.dp)
                                            .size(24.dp)
                                    )
                                }
                            }
                        )
                        Row(
                            modifier = Modifier.padding(start = 32.dp, top = 28.dp, end = 32.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Hey there, ",
                                style = MaterialTheme.typography.titleLarge,
                                onTextLayout = null
                            )
                            Text(
                                text = "Syafiq!",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                onTextLayout = null
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 32.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = "Seems like there are 3 containers that need to be transported.",
                                style = MaterialTheme.typography.bodyLarge,
                                onTextLayout = null
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(152.dp)
                                .padding(horizontal = 32.dp)
                                .background(
                                    color = Color(32, 150, 93),
                                    shape = RoundedCornerShape(20.dp)
                                )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp
                        ) // Horizontal gray line behind the green rectangle
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(modifier = Modifier.padding(horizontal = 32.dp)) {
                            Text(
                                text = "What do you want to do?",
                                style = MaterialTheme.typography.bodyMedium,
                                onTextLayout = null
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .padding(horizontal = 32.dp)
                                .clickable {
                                    val intent =
                                        Intent(this@MainActivity, AssetTrackingActivity::class.java)
                                    startActivity(intent)
                                }
                                .background(
                                    Color(186, 212, 199),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Asset Tracking",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    onTextLayout = null
                                )
                                Text(
                                    text = ">",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    onTextLayout = null
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .padding(horizontal = 32.dp)
                                .clickable {
                                    val intent = Intent(
                                        this@MainActivity,
                                        CaptureComplainActivity::class.java
                                    )
                                    startActivity(intent)
                                }
                                .background(
                                    Color(186, 212, 199),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Activity History",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    onTextLayout = null
                                )
                                Text(
                                    text = ">",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    onTextLayout = null
                                )
                            }
                        }
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            BottomAppBar(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .height(88.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentAlignment = Alignment.TopCenter
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .background(
                                                color = Color(32, 150, 93),
                                                shape = RoundedCornerShape(32.dp)
                                            )
                                            .padding(20.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.ic_location),
                                            contentDescription = "Location Icon",
                                            modifier = Modifier
                                                .size(24.dp)
                                                .align(Alignment.TopCenter)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

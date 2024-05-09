package com.example.greenharbor

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.greenharbor.ui.theme.GreenHarborTheme

class AssetTrackingActivity : ComponentActivity() {
    private var isSomething: Boolean by mutableStateOf(false)

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GreenHarborTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(32, 150, 93))
                                .height(32.dp)
                        )
                        TopAppBar(
                            navigationIcon = {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_back),
                                    contentDescription = "Back",
                                    modifier = Modifier
                                        .padding(horizontal = 24.dp)
                                        .clickable {
                                            val intent =
                                                Intent(
                                                    this@AssetTrackingActivity,
                                                    MainActivity::class.java
                                                )
                                            startActivity(intent)
                                        }
                                        .size(12.dp)
                                )
                            },
                            title = {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Asset Tracking",
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White,
                                        modifier = Modifier.padding(end = 60.dp)
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(Color(32, 150, 93)),
                            modifier = Modifier
                                .background(
                                    color = Color(32, 150, 93),
                                    shape = RoundedCornerShape(32.dp)
                                )
                                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                        )
                        BottomSheetScaffold(
                            scaffoldState = rememberBottomSheetScaffoldState(
                                SheetState(
                                    initialValue = SheetValue.Expanded,
                                    skipPartiallyExpanded = false,
                                    skipHiddenState = true
                                )
                            ),
                            content = {},
                            sheetContent = {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(
                                            start = 16.dp,
                                            end = 16.dp,
                                            top = 8.dp,
                                            bottom = 20.dp
                                        ),
                                ) {
                                    Column(
                                        modifier = Modifier.padding(horizontal = 20.dp)
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(top = 4.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_pinpoint),
                                                contentDescription = "Pinpoint Icon",
                                                modifier = Modifier
                                                    .padding(end = 8.dp)
                                                    .size(16.dp)
                                            )
                                            Text(
                                                text = "Jalan Bangbayang 20, Dago, Coblong",
                                                style = MaterialTheme.typography.bodySmall,
                                                modifier = Modifier.padding()
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Divider(
                                            color = Color(227, 227, 227),
                                            thickness = 2.dp
                                        )
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Text(
                                            text = "Description",
                                            style = MaterialTheme.typography.bodySmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "There are a lot of trash in front of my house, please carry all this rubbish because at my house there will be a wedding party",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clickable {
                                                    val intent =
                                                        Intent(
                                                            this@AssetTrackingActivity,
                                                            MainActivity::class.java
                                                        )
                                                    startActivity(intent)
                                                }
                                                .background(
                                                    Color(32, 150, 93),
                                                    shape = RoundedCornerShape(20.dp)
                                                )
                                                .padding(vertical = 8.dp)
                                        ) {
                                            Text(
                                                text = "Done",
                                                style = MaterialTheme.typography.bodySmall,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White,
                                                modifier = Modifier.align(Alignment.Center)
                                            )
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
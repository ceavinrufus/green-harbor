package com.example.greenharbor

import CameraPreview
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.greenharbor.ui.theme.GreenHarborTheme

class CaptureComplainActivity : ComponentActivity() {

    private lateinit var cameraPreview: CameraPreview
    private var capturedImage: ImageBitmap? by mutableStateOf(null)
    private var isCameraFrozen: Boolean = false

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cameraPreview = CameraPreview(this)
        cameraPreview.startBackgroundThread()
        setContent {
            GreenHarborTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
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
                                                    this@CaptureComplainActivity,
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
                                        text = "Capture & Complain",
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White,
                                        modifier = Modifier.padding(end = 60.dp),
                                        onTextLayout = null
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(Color(32, 150, 93)),
                            modifier = Modifier
                                .background(
                                    color = Color(32, 150, 93),
                                )
                                .padding(top = 36.dp)
                        )
                        Box(modifier = Modifier.weight(1f)) {
                            if (!isCameraFrozen) {
                                AndroidView(factory = {
                                    cameraPreview.apply {
                                        layoutParams = ViewGroup.LayoutParams(
                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                            ViewGroup.LayoutParams.MATCH_PARENT
                                        )
                                    }
                                })
                            } else {
                                Image(
                                    bitmap = capturedImage!!,
                                    contentDescription = "Captured Image",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color(32, 150, 93),
                                        shape = RoundedCornerShape(32.dp)
                                    )
                                    .padding(20.dp)
                                    .clickable {
                                        toggleCameraFreeze()
                                    }
                                    .align(Alignment.BottomCenter)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_camera),
                                    contentDescription = "Camera Icon",
                                    modifier = Modifier
                                        .size(24.dp)
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraPreview.stopBackgroundThread()
    }

    private fun toggleCameraFreeze() {
        isCameraFrozen = !isCameraFrozen // Toggle freeze flag

        if (isCameraFrozen) {
            cameraPreview.stopBackgroundThread()
            // Camera is frozen, capture the latest frame
            capturedImage = cameraPreview.captureImage()
        } else {
            cameraPreview.startBackgroundThread()
        }
    }
}
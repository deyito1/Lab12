package com.tecsup.lab12

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.android.gms.maps.model.LatLng

@Composable
fun MapScreen() {
    val ArequipaLocation = LatLng(-16.4040102, -71.559611)
    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(ArequipaLocation, 12f)

    }

    // Obtener y redimensionar la imagen del marcador
    val context = LocalContext.current
    val originalBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.parque)
    val resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, 64, 64, false) // Ajusta el tamaño según lo necesario

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = rememberMarkerState(position = ArequipaLocation),
                icon = BitmapDescriptorFactory.fromBitmap(resizedBitmap), // Imagen redimensionada
                title = "Arequipa, Perú"
            )
        }
    }
}

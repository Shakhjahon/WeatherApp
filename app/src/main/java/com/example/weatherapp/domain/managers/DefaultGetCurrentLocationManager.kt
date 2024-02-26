package com.example.weatherapp.domain.managers

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume

class DefaultGetCurrentLocationManager(
    private val locationProviderClient: FusedLocationProviderClient,
    private val application: Application
) : GetCurrentLocationManager {
    override suspend fun getCurrentLocation(): Location? {
        val isPermissionFineLocationGranted = ContextCompat.checkSelfPermission(
            application.applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val isPermissionCoarseLocationGranted = ContextCompat.checkSelfPermission(
            application.applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!isPermissionFineLocationGranted || !isPermissionCoarseLocationGranted) {
            showToast("У вас нет разрешение к локации")
            return null
        }
        val cancellationTokenSource = CancellationTokenSource()
        val currentLocationTask: Task<Location> = locationProviderClient.getCurrentLocation(
            PRIORITY_HIGH_ACCURACY,
            cancellationTokenSource.token,
        )
        return suspendCancellableCoroutine { cancellableContinuation ->
            currentLocationTask.addOnCompleteListener { taskLocation ->
                if (taskLocation.isSuccessful) {
                    val result = taskLocation.result
                    cancellableContinuation.resume(result)
                } else cancellableContinuation.resume(null)
            }
        }
    }

    private suspend fun showToast(
        massage: String,
    ) {
        withContext(Dispatchers.Main) {
            Toast.makeText(
                application, massage,
                Toast.LENGTH_SHORT,
            ).show()
        }
    }
}
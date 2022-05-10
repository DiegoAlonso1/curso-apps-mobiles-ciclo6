package com.example.app_sem4_ses2_camera

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btRequest = findViewById<Button>(R.id.btRequest)

        btRequest.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            //permiso rechazado
            requestCameraPermission()
        }
        else
        {
            Toast.makeText(this, "Ya se cuenta con permiso a la cámara", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA))
        {
            //el usuario ya rechazó el permiso. Ir a ajustes
            Toast.makeText(this, "Rechazó el permiso. Ir a ajustes", Toast.LENGTH_SHORT).show()
        }
        else
        {
            //el usuario ya nunca aceptó ni rechazó el permiso. Solicitamos el permiso
            Toast.makeText(this, "Debe aceptar el permiso", Toast.LENGTH_SHORT).show()
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //permiso aceptado
                    Toast.makeText(this, "Permiso aceptado", Toast.LENGTH_SHORT).show()
                    //Aqui llama a la funcionalidad
                }
                else
                {
                    //permiso denegado
                    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
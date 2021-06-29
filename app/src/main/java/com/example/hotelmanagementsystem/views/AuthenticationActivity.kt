package com.example.hotelmanagementsystem.views

import android.app.KeyguardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.hardware.fingerprint.FingerprintManagerCompat.from
import com.example.hotelmanagementsystem.R



class AuthenticationActivity : AppCompatActivity() {
    private var cancellationSignal: CancellationSignal? = null
    private val authenticationCallback: BiometricPrompt.AuthenticationCallback
        get() =
            @RequiresApi(Build.VERSION_CODES.P)
            object: BiometricPrompt.AuthenticationCallback(){
                override fun onAuthenticationError(errorCode: Int, errString:CharSequence){
                    super.onAuthenticationError(errorCode, errString)
                    notifyUser("Authentication error: $errString")
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                    super.onAuthenticationSucceeded(result)
                    notifyUser("Authentication success!")
                    startActivity(Intent(this@AuthenticationActivity, ReservationActivity::class.java ))
                }
            }


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authentication_main)
        checkBiometricSupport()

        val btnAuth = findViewById<Button>(R.id.btn_authenticate)
        btnAuth.setOnClickListener{
            if(BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE == 1){
                startActivity(Intent(this@AuthenticationActivity, ReservationActivity::class.java ))
            } else {
                val biometricPrompt = BiometricPrompt.Builder(this)
                    .setTitle("Title of the prompt")
                    .setSubtitle("Authentication is required")
                    .setDescription("This app uses fingerprint protection to keep your data secure")
                    .setNegativeButton("Cancel", this.mainExecutor, DialogInterface.OnClickListener{ dialog, which ->
                        notifyUser("Authentication cancelled")
                    }).build()

                biometricPrompt.authenticate(getCancellationSignal(), mainExecutor, authenticationCallback)
            }

        }
    }
    private fun checkBiometricSupport():Boolean{
        val keyguardManager:KeyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        if(!keyguardManager.isKeyguardSecure){
            notifyUser("Fingerprint authentication has not been enbaled in setting")
            return false
        }
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.USE_BIOMETRIC) != PackageManager.PERMISSION_GRANTED){
            notifyUser("Fingerprint authentication permission is not enabled")
            return false
        }
        return if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            true
        } else true
    }

    private fun getCancellationSignal(): CancellationSignal {
        cancellationSignal = CancellationSignal()
        cancellationSignal?.setOnCancelListener {
            notifyUser("Authentication was cancelled by the user")
        }
        return cancellationSignal as CancellationSignal
    }
    private fun notifyUser(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
package com.lunlun.fenhow1219;

import android.Manifest;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

//@RequiresApi(api = )
 class TouchID extends AppCompatActivity  {

    private CancellationSignal cancellationSignal;
    private KeyguardManager mKeyguardManager;
    private FingerprintManager mFingerprintManager;

//    @Override
//    protected void onStart() {
    public TouchID () {
//        super.onStart();
        Log.d("TOU","onstart~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        mKeyguardManager = (KeyguardManager) getSystemService(Activity.KEYGUARD_SERVICE);
        mFingerprintManager = (FingerprintManager) getSystemService(Activity.FINGERPRINT_SERVICE);
        if (!mKeyguardManager.isKeyguardSecure()) {
            return;
        }
        if (checkSelfPermission(Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED) {
            if (!mFingerprintManager.isHardwareDetected()) {
                return;
            }
            if (!mFingerprintManager.hasEnrolledFingerprints()) {
                return;
            }
        }
//        startFingerprintListening();
    }

    public void startFingerprintListening() {
        cancellationSignal = new CancellationSignal();
        if (checkSelfPermission(Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED) {
            mFingerprintManager.authenticate(null, cancellationSignal, 0, mAuthenticationCallback, null);
        }
    }

    FingerprintManager.AuthenticationCallback mAuthenticationCallback = new FingerprintManager.AuthenticationCallback() {

        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString) {
//            super.onAuthenticationError(errorCode, errString);
            Log.e("", "error 辨識錯誤" + errorCode + " " + errString);
            return;
//            new AlertDialog.Builder(TouchID.this)
//                    .setTitle("指紋辨識結果")
//                    .setMessage("辨識錯誤")
//                    .setPositiveButton("OK", null)
//                    .show();
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
//            super.onAuthenticationSucceeded(result);
//            new AlertDialog.Builder(TouchID.this)
//                    .setTitle("指紋辨識結果")
//                    .setMessage("辨識OK")
//                    .setPositiveButton("OK", null)
//                    .show();
//            finish();
            Log.i("", "onAuthenticationSucceeded");

        }

        @Override
        public void onAuthenticationFailed() {
//            super.onAuthenticationFailed();
            Log.e("", "onAuthenticationFailed");
        }
    };

    public TouchID(CancellationSignal cancellationSignal, KeyguardManager mKeyguardManager, FingerprintManager mFingerprintManager, FingerprintManager.AuthenticationCallback mAuthenticationCallback) {
        this.cancellationSignal = cancellationSignal;
        this.mKeyguardManager = mKeyguardManager;
        this.mFingerprintManager = mFingerprintManager;
        this.mAuthenticationCallback = mAuthenticationCallback;
    }

    public CancellationSignal getCancellationSignal() {
        return cancellationSignal;
    }

    public void setCancellationSignal(CancellationSignal cancellationSignal) {
        this.cancellationSignal = cancellationSignal;
    }

    public KeyguardManager getmKeyguardManager() {
        return mKeyguardManager;
    }

    public void setmKeyguardManager(KeyguardManager mKeyguardManager) {
        this.mKeyguardManager = mKeyguardManager;
    }

    public FingerprintManager getmFingerprintManager() {
        return mFingerprintManager;
    }

    public void setmFingerprintManager(FingerprintManager mFingerprintManager) {
        this.mFingerprintManager = mFingerprintManager;
    }

    public FingerprintManager.AuthenticationCallback getmAuthenticationCallback() {
        return mAuthenticationCallback;
    }

    public void setmAuthenticationCallback(FingerprintManager.AuthenticationCallback mAuthenticationCallback) {
        this.mAuthenticationCallback = mAuthenticationCallback;
    }
}


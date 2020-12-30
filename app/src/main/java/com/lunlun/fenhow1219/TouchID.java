package com.lunlun.fenhow1219;

import android.Manifest;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


//@RequiresApi(api = )
public class TouchID extends AppCompatActivity {

    private CancellationSignal cancellationSignal;
    private KeyguardManager mKeyguardManager;
    private FingerprintManager mFingerprintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mKeyguardManager = (KeyguardManager) getSystemService(Activity.KEYGUARD_SERVICE);
        mFingerprintManager = (FingerprintManager) getSystemService(Activity.FINGERPRINT_SERVICE);

        super.onCreate(savedInstanceState);
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
        startFingerprintListening();
    }

    private void startFingerprintListening() {
        cancellationSignal = new CancellationSignal();
        if (checkSelfPermission(Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED) {
            mFingerprintManager.authenticate(null, cancellationSignal, 0, mAuthenticationCallback, null);
        }
    }

    FingerprintManager.AuthenticationCallback mAuthenticationCallback = new FingerprintManager.AuthenticationCallback() {

        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString) {
            super.onAuthenticationError(errorCode, errString);
            Log.e("", "error 辨識錯誤" + errorCode + " " + errString);

//            new AlertDialog.Builder(TouchID.this)
//                    .setTitle("指紋辨識結果")
//                    .setMessage("辨識錯誤")
//                    .setPositiveButton("OK", null)
//                    .show();
        }

//        @Override
//        public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
//            super.onAuthenticationHelp(helpCode, helpString);
//        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
            super.onAuthenticationSucceeded(result);
            new AlertDialog.Builder(TouchID.this)
                    .setTitle("指紋辨識結果")
                    .setMessage("辨識OK")
                    .setPositiveButton("OK", null)
                    .show();
            finish();
        }

        @Override
        public void onAuthenticationFailed() {
            super.onAuthenticationFailed();
        }
    };
}

//
//
//
//    public TouchID(FingerprintManager mKeyguardManager) {
//        this.mKeyguardManager = mKeyguardManager;
//
//
//    }
//
//    public TouchID(int contentLayoutId, FingerprintManager mKeyguardManager) {
//        super(contentLayoutId);
//        this.mKeyguardManager = mKeyguardManager;
//    }
//
//    public FingerprintManager getmKeyguardManager() {
//        return mKeyguardManager;
//    }
//
//    public void setmKeyguardManager(FingerprintManager mKeyguardManager) {
//        this.mKeyguardManager = mKeyguardManager;
//    }

package com.lunlun.fenhow1219;

import android.Manifest;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;


public class TouchID extends Login {

    private CancellationSignal cancellationSignal;
    private KeyguardManager mKeyguardManager;
    private FingerprintManager mFingerprintManager;
    private String TouchIDResult;

    public TouchID() {
        mFingerprintManager =(FingerprintManager)getSystemService(Activity.FINGERPRINT_SERVICE);
        if(!mKeyguardManager.isKeyguardSecure()) {
            return;
        }
        if(checkSelfPermission(Manifest.permission.USE_FINGERPRINT) ==PackageManager.PERMISSION_GRANTED) {
            if (!mFingerprintManager.isHardwareDetected()) {
                return;
            }
            if (!mFingerprintManager.hasEnrolledFingerprints()) {
                return;
            }
        }
        startFingerprintListening();
    }

    public TouchID(String touchIDResult) {


        TouchIDResult = touchIDResult;
    }

    public String getTouchIDResult() {
        return TouchIDResult;
    }

    public void setTouchIDResult(String touchIDResult) {

        TouchIDResult = touchIDResult;
    }

    public void startFingerprintListening() {
        cancellationSignal = new CancellationSignal();
        if (checkSelfPermission(Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED) {
            mFingerprintManager.authenticate(null, cancellationSignal, 0, mAuthenticationCallback,null);
        }
    }

    FingerprintManager.AuthenticationCallback mAuthenticationCallback = new FingerprintManager.AuthenticationCallback() {

        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString) {
//            super.onAuthenticationError(errorCode, errString);
            setTouchIDResult("辨識錯誤");
            Log.e("", "error 辨識錯誤" + errorCode + " " + errString);
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
//            super.onAuthenticationSucceeded(result);
            Log.i("", "onAuthenticationSucceeded");
            setTouchIDResult("辨識成功");

        }

        @Override
        public void onAuthenticationFailed() {
//            super.onAuthenticationFailed();
            Log.e("", "onAuthenticationFailed");
            setTouchIDResult("辨識失敗");
        }
    };

}


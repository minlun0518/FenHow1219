package com.lunlun.fenhow1219;

import android.Manifest;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class TouchID  extends AppCompatActivity {
    private KeyguardManager mKeyguardManager;
    private FingerprintManager mFingerprintManager;
    private CancellationSignal cancellationSignal;


    public void startFingerprintListening() {
        cancellationSignal = new CancellationSignal();
        if (checkSelfPermission(Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED) //In SDK 23, we need to check the permission before we call FingerprintManager API functionality.
        {
            mFingerprintManager.authenticate(
                    null, //crypto objects 的 wrapper class，可以透過它讓 authenticate 過程更為安全，但也可以不使用。
                    cancellationSignal, //用來取消 authenticate 的 object
                    0, //optional flags; should be 0
                    mAuthenticationCallback, //callback 用來接收 authenticate 成功與否，有三個 callback method
                    null); //optional 的參數，如果有使用，FingerprintManager 會透過它來傳遞訊息
        }
    }

    FingerprintManager.AuthenticationCallback mAuthenticationCallback = new FingerprintManager.AuthenticationCallback(){
        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString) {
            Log.e("", "error 辨識錯誤" + errorCode + " " + errString);
            new AlertDialog.Builder(getApplicationContext())
                    .setTitle("指紋辨識結果")
                    .setMessage("辨識錯誤")
                    .setPositiveButton("OK", null)
                    .show();
        }
        @Override
        public void onAuthenticationFailed() {
            Log.e("", "辨識失敗 onAuthenticationFailed");
            new AlertDialog.Builder(getApplicationContext())
                    .setTitle("指紋辨識結果")
                    .setMessage("辨識失敗")
                    .setPositiveButton("OK", null)
                    .show();
        }
        @Override
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
            Log.i("", "辨識成功 onAuthenticationSucceeded");
            new AlertDialog.Builder(getApplicationContext())
                    .setTitle("指紋辨識結果")
                    .setMessage("辨識成功")
                    .setPositiveButton("OK",null )
                    .show();
//            return;
        }
    };

}

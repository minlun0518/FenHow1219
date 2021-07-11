package com.lunlun.fenhow1219;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    boolean _running = false;
    private Button mButtonCancel;
    private Button mButtonClose;
    private Button mButtonConfirm;
    private EditText mEditTextPwdConfirm;
    private EditText mEditTextPwdNew;
    /* access modifiers changed from: private */
    public TextView mTextViewChangePwdError;
    /* access modifiers changed from: private */
    public SharedPreferences spref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.settings, new SettingsFragment())
//                    .commit();
//        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initView();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }

    private void initView() {
        setContentView((int) R.layout.activity_change_pwd);
//        this.spref = MySingleton.getInstance(getApplication()).getSharedPreferences();
        this.mButtonConfirm = (Button) findViewById(R.id.buttonConfirm);
        this.mButtonCancel = (Button) findViewById(R.id.buttonCancel);
        this.mButtonClose = (Button) findViewById(R.id.buttonClose);
        this.mEditTextPwdNew = (EditText) findViewById(R.id.editTextPwdNew);
        this.mEditTextPwdConfirm = (EditText) findViewById(R.id.editTextPwdConfirm);
        this.mTextViewChangePwdError = (TextView) findViewById(R.id.textViewChangePwdError);
        this.mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!SettingsActivity.this._running) {
                    SettingsActivity.this.doChange();
                }
            }
        });
        this.mButtonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SettingsActivity.this.finish();
            }
        });
        this.mButtonClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SettingsActivity.this.finish();
            }
        });
    }

    public void doChange() {
        this.mEditTextPwdNew.setError((CharSequence) null);
        this.mEditTextPwdConfirm.setError((CharSequence) null);
        boolean cancel = false;
        View focusView = null;
        String _pwdNew = this.mEditTextPwdNew.getText().toString().trim();
        String _pwdConfirm = this.mEditTextPwdConfirm.getText().toString().trim();
        if (_pwdNew.equals("")) {
            this.mEditTextPwdNew.setError("新密碼不可以空白!!!");
            focusView = this.mEditTextPwdNew;
            cancel = true;
        } else if (_pwdNew.length() < 6) {
            this.mEditTextPwdNew.setError("新密碼不可以少於6碼!!!");
            focusView = this.mEditTextPwdNew;
            cancel = true;
        } else if (!_pwdNew.matches(".*\\d+.*") || !_pwdNew.matches(".*[a-zA-Z]+.*") || !_pwdNew.matches(".*\\W+.*")) {
            this.mEditTextPwdNew.setError("新密碼不符合上述的條件!!!");
            focusView = this.mEditTextPwdNew;
            cancel = true;
        }
        if (_pwdConfirm.equals("")) {
            this.mEditTextPwdConfirm.setError("確認密碼不可以空白!!!");
            focusView = this.mEditTextPwdConfirm;
            cancel = true;
        } else if (_pwdConfirm.length() < 6) {
            this.mEditTextPwdConfirm.setError("確認密碼不可以少於6碼!!!");
            focusView = this.mEditTextPwdConfirm;
            cancel = true;
        } else if (!_pwdConfirm.matches(".*\\d+.*") || !_pwdConfirm.matches(".*[a-zA-Z]+.*") || !_pwdConfirm.matches(".*\\W+.*")) {
            this.mEditTextPwdConfirm.setError("確認密碼不符合上述的條件!!!");
            focusView = this.mEditTextPwdConfirm;
            cancel = true;
        }
        if (!cancel && !_pwdNew.equals(_pwdConfirm)) {
            this.mEditTextPwdConfirm.setError("新密碼和確認密碼不同!!!");
            focusView = this.mEditTextPwdConfirm;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
            return;
        }
//        new AsyncTaskChangePwd().execute(new String[]{_pwdNew, _pwdConfirm});
    }
}
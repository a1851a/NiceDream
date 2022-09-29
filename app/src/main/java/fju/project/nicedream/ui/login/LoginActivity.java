package fju.project.nicedream.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.MainActivity;
import fju.project.nicedream.R;
import fju.project.nicedream.data.util.DeviceChecker;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;

    @BindView(R.id.login_logo)
    ImageView loginlogo;
    @BindView(R.id.login_title)
    ImageView logintitle;
    @BindView(R.id.login_google)
    ImageView logingoogle;
    @BindView(R.id.login_fb)
    ImageView loginfb;
    @BindView(R.id.login_line)
    ImageView loginline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            updateUI(currentUser);
        }
    }

    @OnClick({R.id.login_google,R.id.login_fb,R.id.login_line})
    public void onViewClicked(View view){
        switch (view.getId()) {
            case R.id.login_google:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                            .requestIdToken("668502734211-1p8g8a7cirgq5v7ilebhiicbo9mrc4ne.apps.googleusercontent.com")
                            .requestEmail()
                            .build();
                    mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
                    startActivityForResult(mGoogleSignInClient.getSignInIntent(),1);
                }
                break;
            case R.id.login_fb:
                if (!DeviceChecker.CheckInternet(this)) {
                    return;
                }
                else {

                }
                break;
            case R.id.login_line:
                if (!DeviceChecker.CheckInternet(this)) {
                    return;
                }
                else {

                }
                break;
        }
    }

    private void handleGoogleAccessToken(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            //String result = "登入成功\nEmail："+account.getEmail()+"\nGoogle名稱："+account.getDisplayName();
            FirebaseGoogleAuth(account);
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            LoginActivity.this.finish();
        } catch (ApiException e) {
            //Toast.makeText(this,"登入失敗",Toast.LENGTH_SHORT).show();
            Log.w(TAG, "Google sign in failed", e);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount account) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }
                else {
                    updateUI(null);
                }
            }
        });
    }

    private void updateUI(FirebaseUser user) {
        if (user != null){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            LoginActivity.this.finish();
        }
        else {
            Toast.makeText(this,"Please sign in to continues",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //google帳號
        if (!Objects.equals(mGoogleSignInClient,null)){
            super.onActivityResult(requestCode, resultCode, data);
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleAccessToken(task);
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            LoginActivity.this.finish();
        }
    }

    //禁止使用返回鍵
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            event.startTracking();
        }
        return false;
    }
}
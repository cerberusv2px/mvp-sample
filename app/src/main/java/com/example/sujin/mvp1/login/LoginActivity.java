package com.example.sujin.mvp1.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.sujin.mvp1.R;
import com.example.sujin.mvp1.login.LoginContract.Presenter;
import com.example.sujin.mvp1.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

  public static final String TAG = LoginActivity.class.getSimpleName();

  EditText etUsername, etPassword;
  TextView userError, passwordError;
  ProgressBar progressBar;
  Button btnLogin;

  LoginContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    presenter = new LoginPresenter(this);
    initViews();
    btnLogin.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.validateCredential(
            etUsername.getText().toString(),
            etPassword.getText().toString()
        );
      }
    });
  }
  private void initViews() {
    etUsername = findViewById(R.id.etUsername);
    etPassword = findViewById(R.id.etPassword);
    userError = findViewById(R.id.usernameError);
    passwordError = findViewById(R.id.passwordError);
    progressBar = findViewById(R.id.progressBar);
    btnLogin = findViewById(R.id.btnLogin);
  }

  @Override
  protected void onStart() {
    super.onStart();
    presenter.start();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void showProgress() {
    Log.e(TAG, "Show Progress");
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideProgress() {
    Log.e(TAG, "Hide Progress");
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override
  public void showUsernameError() {
    Log.e(TAG, "Invalid username");
    userError.setVisibility(View.VISIBLE);
  }

  @Override
  public void showPasswordError() {
    Log.e(TAG, "Invalid password");
    passwordError.setVisibility(View.VISIBLE);
  }

  @Override
  public void navigateToMain() {
    Log.e(TAG, "start main activity");
    startActivity(new Intent(LoginActivity.this, MainActivity.class));
  }
}

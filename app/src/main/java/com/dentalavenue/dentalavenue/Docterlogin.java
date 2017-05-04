package com.dentalavenue.dentalavenue;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.dentalavenue.dentalavenue.loginPOJO.loginBean;
import com.dentalavenue.dentalavenue.registerDoctorPOJO.registerDoctorBean;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Docterlogin extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    TextView create,forgot;
    EditText email,password;
    Button sign , google;
    Button facebook;
    Toolbar toolbar;
    ProgressBar progress;
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    CallbackManager mCallbackManager;
    GoogleApiClient mGoogleApiClient;

    int RC_SIGN_IN = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);

        mCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        AccessToken accessToken = loginResult.getAccessToken();
                        Profile profile = Profile.getCurrentProfile();

                        final String user = profile.getId();
                        final String pass = profile.getId();
                        final String name = profile.getName();

                        //progress.setVisibility(View.VISIBLE);

                        //Toast.makeText(Docterlogin.this, profile.getName(), Toast.LENGTH_SHORT).show();

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://nationproducts.in/")
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        AllAPIs cr = retrofit.create(AllAPIs.class);

                        Call<loginBean> call = cr.login(user , pass , "doctor");

                        call.enqueue(new Callback<loginBean>() {
                            @Override
                            public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                                Log.d("asdasdasd" , "1");
                                //Log.d("adsadsa" , response.body().getLogin().get(0).getMessage());

                                if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                                {

                                    Log.d("asdasdasd" , "2");

                                    Dialog dialog = new Dialog(Docterlogin.this);
                                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                    dialog.setCancelable(false);
                                    dialog.setContentView(R.layout.social_dialog);
                                    dialog.show();


                                    final EditText reg = (EditText)dialog.findViewById(R.id.reg);
                                    final EditText pho = (EditText)dialog.findViewById(R.id.phone);
                                    TextView subm = (TextView)dialog.findViewById(R.id.submit);




                                    subm.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            final String re = reg.getText().toString();
                                            final String ph = pho.getText().toString();

                                            if (re.length()>0)
                                            {
                                                if (ph.length()>0)
                                                {


                                                    progress.setVisibility(View.VISIBLE);

                                                    Retrofit retrofit = new Retrofit.Builder()
                                                            .baseUrl("http://nationproducts.in/")
                                                            .addConverterFactory(ScalarsConverterFactory.create())
                                                            .addConverterFactory(GsonConverterFactory.create())
                                                            .build();

                                                    AllAPIs cr = retrofit.create(AllAPIs.class);

                                                    Call<registerDoctorBean> call = cr.registerDoctor(name , "" , user , ph , pass , "doctor" , re);

                                                    call.enqueue(new Callback<registerDoctorBean>() {
                                                        @Override
                                                        public void onResponse(Call<registerDoctorBean> call, Response<registerDoctorBean> response) {

                                                            progress.setVisibility(View.GONE);

                                                            if (Objects.equals(response.body().getRegisterDoctor().get(0).getMessage(), "Registration Successfull."))
                                                            {

                                                                progress.setVisibility(View.VISIBLE);

                                                                Retrofit retrofit = new Retrofit.Builder()
                                                                        .baseUrl("http://nationproducts.in/")
                                                                        .addConverterFactory(ScalarsConverterFactory.create())
                                                                        .addConverterFactory(GsonConverterFactory.create())
                                                                        .build();

                                                                AllAPIs cr = retrofit.create(AllAPIs.class);

                                                                Call<loginBean> call2 = cr.login(user , pass , "doctor");

                                                                call2.enqueue(new Callback<loginBean>() {
                                                                    @Override
                                                                    public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                                                                        Log.d("adsadsa" , response.body().getLogin().get(0).getMessage());

                                                                        if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                                                                        {
                                                                            Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                                                                            progress.setVisibility(View.GONE);
                                                                        }
                                                                        else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                                                                        {
                                                                            progress.setVisibility(View.GONE);

                                                                            edit.putString("type" , "doctor");
                                                                            edit.putString("user" , user);
                                                                            edit.putString("pass" , pass);
                                                                            edit.apply();

                                                                            bean b = (bean)getApplicationContext();

                                                                            b.name = response.body().getLogin().get(0).getFirstName();
                                                                            b.userId = response.body().getLogin().get(0).getUserId();
                                                                            b.email = response.body().getLogin().get(0).getUserEmail();


                                                                            Intent intent = new Intent(Docterlogin.this , Homepage.class);
                                                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                            startActivity(intent);
                                                                            finish();
                                                                        }

                                                                    }

                                                                    @Override
                                                                    public void onFailure(Call<loginBean> call, Throwable throwable) {

                                                                        progress.setVisibility(View.GONE);

                                                                    }
                                                                });


                                                            }
                                                            else if (Objects.equals(response.body().getRegisterDoctor().get(0).getMessage(), "User Already Exists."))
                                                            {
                                                                Toast.makeText(Docterlogin.this , "User Already Exists" , Toast.LENGTH_SHORT).show();
                                                            }

                                                        }

                                                        @Override
                                                        public void onFailure(Call<registerDoctorBean> call, Throwable throwable) {
                                                            progress.setVisibility(View.GONE);
                                                        }
                                                    });


                                                }
                                                else
                                                {
                                                    pho.setError("Invalid Phone Number");
                                                }
                                            }
                                            else
                                            {
                                                //Toast.makeText(Docterlogin.this , "Invalid Registration Number" , Toast.LENGTH_SHORT).show();
                                                reg.setError("Invalid Registration Number");
                                            }

                                        }
                                    });




                                }
                                else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                                {
                                    progress.setVisibility(View.GONE);

                                    //edit.putString("type" , "doctor");
                                    //edit.putString("user" , user);
                                    //edit.putString("pass" , pass);
                                    //edit.apply();

                                    bean b = (bean)getApplicationContext();

                                    b.name = response.body().getLogin().get(0).getFirstName();
                                    b.userId = response.body().getLogin().get(0).getUserId();
                                    b.email = response.body().getLogin().get(0).getUserEmail();


                                    Intent intent = new Intent(Docterlogin.this , Homepage.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    finish();
                                }

                            }

                            @Override
                            public void onFailure(Call<loginBean> call, Throwable throwable) {

                                progress.setVisibility(View.GONE);

                            }
                        });



                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(Docterlogin.this, "Login Cancel", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(Docterlogin.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        setContentView(R.layout.activity_docterlogin);



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();





        pref = getSharedPreferences("mypref" , MODE_PRIVATE);
        edit = pref.edit();

        facebook = (Button) findViewById(R.id.facebook);
        google = (Button) findViewById(R.id.google);
        create = (TextView) findViewById(R.id.create);
        forgot = (TextView) findViewById(R.id.forgot);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        sign = (Button) findViewById(R.id.sign);
        progress = (ProgressBar)findViewById(R.id.progress);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();

            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setTitle("Sign in as a Doctor");
        toolbar.setTitleTextColor(Color.WHITE);

        toolbar.setNavigationIcon(R.drawable.back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Docterlogin.this, Registerdoctor.class);
                startActivity(intent);
            }
        });


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(Docterlogin.this , Arrays.asList("public_profile"));
            }
        });







        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String user = email.getText().toString();
                final String pass = password.getText().toString();

                if (user.length()>0)
                {

                    if (pass.length()>0)
                    {

                        progress.setVisibility(View.VISIBLE);

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://nationproducts.in/")
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        AllAPIs cr = retrofit.create(AllAPIs.class);

                        Call<loginBean> call = cr.login(user , pass , "doctor");

                        call.enqueue(new Callback<loginBean>() {
                            @Override
                            public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                                Log.d("adsadsa" , response.body().getLogin().get(0).getMessage());

                                if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                                {
                                    Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                                    progress.setVisibility(View.GONE);
                                }
                                else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                                {
                                    progress.setVisibility(View.GONE);

                                    edit.putString("type" , "doctor");
                                    edit.putString("user" , user);
                                    edit.putString("pass" , pass);
                                    edit.apply();

                                    bean b = (bean)getApplicationContext();

                                    b.name = response.body().getLogin().get(0).getFirstName();
                                    b.userId = response.body().getLogin().get(0).getUserId();
                                    b.email = response.body().getLogin().get(0).getUserEmail();


                                    Intent intent = new Intent(Docterlogin.this , Homepage.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    finish();
                                }

                            }

                            @Override
                            public void onFailure(Call<loginBean> call, Throwable throwable) {

                                progress.setVisibility(View.GONE);

                            }
                        });

                    }
                    else
                    {
                        //Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                        password.setError("Invalid details");
                    }

                }
                else
                {
                    //Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                    email.setError("Invalid details");
                }



            }
});

    }



    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }

    }
    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();


            final String user = acct.getId();
            final String pass = acct.getId();
            final String name = acct.getDisplayName();

            //progress.setVisibility(View.VISIBLE);

            //Toast.makeText(Docterlogin.this, profile.getName(), Toast.LENGTH_SHORT).show();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            AllAPIs cr = retrofit.create(AllAPIs.class);

            Call<loginBean> call = cr.login(user , pass , "doctor");

            call.enqueue(new Callback<loginBean>() {
                @Override
                public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                    Log.d("asdasdasd" , "1");
                    //Log.d("adsadsa" , response.body().getLogin().get(0).getMessage());

                    if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                    {

                        Log.d("asdasdasd" , "2");

                        Dialog dialog = new Dialog(Docterlogin.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setCancelable(false);
                        dialog.setContentView(R.layout.social_dialog);
                        dialog.show();


                        final EditText reg = (EditText)dialog.findViewById(R.id.reg);
                        final EditText pho = (EditText)dialog.findViewById(R.id.phone);
                        TextView subm = (TextView)dialog.findViewById(R.id.submit);




                        subm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                final String re = reg.getText().toString();
                                final String ph = pho.getText().toString();

                                if (re.length()>0)
                                {
                                    if (ph.length()>0)
                                    {


                                        progress.setVisibility(View.VISIBLE);

                                        Retrofit retrofit = new Retrofit.Builder()
                                                .baseUrl("http://nationproducts.in/")
                                                .addConverterFactory(ScalarsConverterFactory.create())
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .build();

                                        AllAPIs cr = retrofit.create(AllAPIs.class);

                                        Call<registerDoctorBean> call = cr.registerDoctor(name , "" , user , ph , pass , "doctor" , re);

                                        call.enqueue(new Callback<registerDoctorBean>() {
                                            @Override
                                            public void onResponse(Call<registerDoctorBean> call, Response<registerDoctorBean> response) {

                                                progress.setVisibility(View.GONE);

                                                if (Objects.equals(response.body().getRegisterDoctor().get(0).getMessage(), "Registration Successfull."))
                                                {

                                                    progress.setVisibility(View.VISIBLE);

                                                    Retrofit retrofit = new Retrofit.Builder()
                                                            .baseUrl("http://nationproducts.in/")
                                                            .addConverterFactory(ScalarsConverterFactory.create())
                                                            .addConverterFactory(GsonConverterFactory.create())
                                                            .build();

                                                    AllAPIs cr = retrofit.create(AllAPIs.class);

                                                    Call<loginBean> call2 = cr.login(user , pass , "doctor");

                                                    call2.enqueue(new Callback<loginBean>() {
                                                        @Override
                                                        public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                                                            Log.d("adsadsa" , response.body().getLogin().get(0).getMessage());

                                                            if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                                                            {
                                                                Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                                                                progress.setVisibility(View.GONE);
                                                            }
                                                            else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                                                            {
                                                                progress.setVisibility(View.GONE);

                                                                edit.putString("type" , "doctor");
                                                                edit.putString("user" , user);
                                                                edit.putString("pass" , pass);
                                                                edit.apply();

                                                                bean b = (bean)getApplicationContext();

                                                                b.name = response.body().getLogin().get(0).getFirstName();
                                                                b.userId = response.body().getLogin().get(0).getUserId();
                                                                b.email = response.body().getLogin().get(0).getUserEmail();


                                                                Intent intent = new Intent(Docterlogin.this , Homepage.class);
                                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                startActivity(intent);
                                                                finish();
                                                            }

                                                        }

                                                        @Override
                                                        public void onFailure(Call<loginBean> call, Throwable throwable) {

                                                            progress.setVisibility(View.GONE);

                                                        }
                                                    });


                                                }
                                                else if (Objects.equals(response.body().getRegisterDoctor().get(0).getMessage(), "User Already Exists."))
                                                {
                                                    Toast.makeText(Docterlogin.this , "User Already Exists" , Toast.LENGTH_SHORT).show();
                                                }

                                            }

                                            @Override
                                            public void onFailure(Call<registerDoctorBean> call, Throwable throwable) {
                                                progress.setVisibility(View.GONE);
                                            }
                                        });


                                    }
                                    else
                                    {
                                        pho.setError("Invalid Phone Number");
                                    }
                                }
                                else
                                {
                                    //Toast.makeText(Docterlogin.this , "Invalid Registration Number" , Toast.LENGTH_SHORT).show();
                                    reg.setError("Invalid Registration Number");
                                }

                            }
                        });




                    }
                    else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                    {
                        progress.setVisibility(View.GONE);

                        //edit.putString("type" , "doctor");
                        //edit.putString("user" , user);
                        //edit.putString("pass" , pass);
                        //edit.apply();

                        bean b = (bean)getApplicationContext();

                        b.name = response.body().getLogin().get(0).getFirstName();
                        b.userId = response.body().getLogin().get(0).getUserId();
                        b.email = response.body().getLogin().get(0).getUserEmail();


                        Intent intent = new Intent(Docterlogin.this , Homepage.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onFailure(Call<loginBean> call, Throwable throwable) {

                    progress.setVisibility(View.GONE);

                }
            });


        } else {
            // Signed out, show unauthenticated UI.

        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}



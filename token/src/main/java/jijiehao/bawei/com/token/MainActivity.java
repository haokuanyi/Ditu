package jijiehao.bawei.com.token;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;


public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.main_name)
    EditText mMainName;
    @InjectView(R.id.main_pass)
    EditText mMainPass;
    @InjectView(R.id.main_login)
    Button mMainLogin;
    @InjectView(R.id.main_register)
    Button mMainRegister;
    private String mName;
    private String mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


    }


    @OnClick({R.id.main_login, R.id.main_register})
    public void onClick1(View view) {
        switch (view.getId()) {
            case R.id.main_login:
                Toast.makeText(MainActivity.this, "你点击了登录", Toast.LENGTH_SHORT).show();

                mName = mMainName.getText().toString();
                mPass = mMainPass.getText().toString();
                getjson();
                break;
            case R.id.main_register:
                Toast.makeText(MainActivity.this, "你点击了注册", Toast.LENGTH_SHORT).show();


                break;
        }
    }

    private void getjson() {
        //            client_id=e71ae1174f2840f197eb15e6aedbcfc2Zb5Qp6xE&client_secret=xuaoMCmrK5EMdTKiHNgr1miMQTSOYGqOIZrujmwy&grant_type=password&scope=read&username={username}&password={password}
        OkHttpUtils.post().url("https://kso.idsmanager.com:8443/kso/oauth/token?")
                .addParams("client_id", "404cf54aa82447df9b43087261464b9fCt1pLPgy")
                .addParams("client_secret", "C6gbl9HpGPlyVMnUYw5tTkL22CEafW2umfM3jTJZ")
                .addParams("grant_type", "password")
                .addParams("scope", "read")
                .addParams("username", mName)
                .addParams("password", mPass)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(Call call, String s) {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                        Log.e("11111111111111", s);
                    }
                });

    }



}

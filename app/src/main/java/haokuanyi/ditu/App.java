package haokuanyi.ditu;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by haokuanyi on 2016/11/20.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}

package jijiehao.bawei.com.paixu;

import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    int arr[] = {1, 5, 7, 9, 10, 13, 8, 16, 4};
    int temp;
    MyHandler mMyHandler=   new MyHandler(this);

private static class MyHandler extends Handler {
        private WeakReference<MainActivity> activityWeakReference;

        public MyHandler(MainActivity activity) {
            activityWeakReference = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = activityWeakReference.get();
            if (activity != null) {

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMyHandler.removeMessages(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //冒泡排序
        mao(arr);
        //
    }

    private void mao(int[] arr) {
        if (arr == null || 0 == arr.length)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + "");
            Toast.makeText(this, i + "", Toast.LENGTH_LONG).show();

        }

    }


}

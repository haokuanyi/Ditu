package jijiehao.bawei.com.qqbiaoqing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    //语音动画控制器
//    Timer mTimer=null;
//    //语音动画控制任务
//    TimerTask mTimerTask=null;
//    //记录语音动画图片
//    int index=1;
//    AudioAnimationHandler audioAnimationHandler=null;
    @InjectView(R.id.edittext)
    EditText mEdittext;
    @InjectView(R.id.onClick_RandomFace)
    Button mOnClickRandomFace;
    @InjectView(R.id.send)
    Button mSend;
    @InjectView(R.id.listView)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        //控件初始化
        initView();

    }

    private void initView() {
//        mListView.setAdapter();


    }


    @OnClick({R.id.onClick_RandomFace, R.id.send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.onClick_RandomFace:
                dian();

                break;
            case R.id.send:
                break;
        }
    }

    private void dian() {
        int randomId = 1 + new Random().nextInt(9);
        //  根据随机产生的1至9的整数从R.drawable类中获得相应资源ID（静态变量）的Field对象
        try {
            Field field = R.mipmap.class.getDeclaredField("f00" + randomId);
            //  获得资源ID的值，也就是静态变量的值
            int resourceId = Integer.parseInt(field.get(null).toString());
            //  根据资源ID获得资源图像的Bitmap对象
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
            //  根据Bitmap对象创建ImageSpan对象
            ImageSpan imageSpan = new ImageSpan(this, bitmap);
            //  创建一个SpannableString对象，以便插入用ImageSpan对象封装的图像
            SpannableString spannableString = new SpannableString("f00");
            //  用ImageSpan对象替换face
            spannableString.setSpan(imageSpan, 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //  将随机获得的图像追加到EditText控件的最后
            mEdittext.append(spannableString);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

//    /**
//     * 播放语音图标动画
//     */
//    private void playAudioAnimation(final ImageView imageView) {
//        //定时器检查播放状态
//        stopTimer();
//        mTimer=new Timer();
//        //将要关闭的语音图片归位
//        if(audioAnimationHandler!=null)
//        {
//            Message msg=new Message();
//            msg.what=3;
//            audioAnimationHandler.sendMessage(msg);
//        }
//
//        audioAnimationHandler=new AudioAnimationHandler(imageView);
//        mTimerTask = new TimerTask() {
//            public boolean hasPlayed=false;
//            @Override
//            public void run() {
//                if(mMediaPlayer.isPlaying()) {
//                    hasPlayed=true;
//                    index=(index+1)%3;
//                    Message msg=new Message();
//                    msg.what=index;
//                    audioAnimationHandler.sendMessage(msg);
//                }else
//                {
//                    //当播放完时
//                    Message msg=new Message();
//                    msg.what=3;
//                    audioAnimationHandler.sendMessage(msg);
//                    //播放完毕时需要关闭Timer等
//                    if(hasPlayed)
//                    {
//                        stopTimer();
//                    }
//                }
//            }
//        };
//        //调用频率为500毫秒一次
//        mTimer.schedule(mTimerTask, 0, 500);
//    }
//    class AudioAnimationHandler extends Handler
//    {
//        ImageView imageView;
//        //判断是左对话框还是右对话框
//        boolean isleft;
//        public AudioAnimationHandler(ImageView imageView)
//        {
//            this.imageView=imageView;
//            //判断是左对话框还是右对话框 我这里是在前面设置ScaleType来表示的
//            isleft=imageView.getScaleType()==ScaleType.FIT_START?true:false;
//        }
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            //根据msg.what来替换图片，达到动画效果
//            switch (msg.what) {
//                case 0 :
//                    imageView.setImageResource(isleft?R.drawable.chatfrom_voice_playing_f1:R.drawable.chatto_voice_playing_f1);
//                    break;
//                case 1 :
//                    imageView.setImageResource(isleft?R.drawable.chatfrom_voice_playing_f2:R.drawable.chatto_voice_playing_f2);
//                    break;
//                case 2 :
//                    imageView.setImageResource(isleft?R.drawable.chatfrom_voice_playing_f3:R.drawable.chatto_voice_playing_f3);
//                    break;
//                default :
//                    imageView.setImageResource(isleft?R.drawable.chatfrom_voice_playing_f3:R.drawable.chatto_voice_playing_f3);
//                    break;
//            }
//        }
//
//    }
//    /**
//     * 停止
//     */
//    private void stopTimer(){
//        if (mTimer != null) {
//            mTimer.cancel();
//            mTimer = null;
//        }
//
//        if (mTimerTask != null) {
//            mTimerTask.cancel();
//            mTimerTask = null;
//        }
//
//    }
}

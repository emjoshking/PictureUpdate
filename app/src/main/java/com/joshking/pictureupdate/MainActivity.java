package com.joshking.pictureupdate;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Switch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
//    private int index;
    private static final int change_img = 1;


    int []img = {R.drawable.img1,R.drawable.img2,
                          R.drawable.img3,R.drawable.img4,
                          R.drawable.img5,R.drawable.img6,R.drawable.img7};

    private String getWeek(String ptime){
        String week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(format.parse(ptime));
        } catch (ParseException e){
            e.printStackTrace();
        }

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            week +="星期天";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
            week +="星期一 ";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
            week +="星期二";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
            week +="星期三";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
            week +="星期四";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
            week +="星期五";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            week +="星期六";
        }
        return week;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String week = getWeek(" ");

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what ==  change_img){
                    ImageView imageView = (ImageView)findViewById(R.id.show_image);
                    switch (week){
                        case "星期天":
//                            imageView.setImageResource(img[msg.getData().getInt("index")]);
                            imageView.setImageResource(img[0]);
                            break;
                        case "星期一":
//                            imageView.setImageResource(img[msg.getData().getInt("index")]);
                            imageView.setImageResource(img[1]);
                            break;
                        case"星期二":
//                            imageView.setImageResource(img[msg.getData().getInt("index")]);
                            imageView.setImageResource(img[2]);
                            break;
                        case"星期三":
//                            imageView.setImageResource(img[msg.getData().getInt("index")]);
                            imageView.setImageResource(img[3]);
                            break;
                        case"星期四":
//                            imageView.setImageResource(img[msg.getData().getInt("index")]);
                            imageView.setImageResource(img[4]);
                            break;
                        case"星期五":
//                            imageView.setImageResource(img[msg.getData().getInt("index")]);
                            imageView.setImageResource(img[5]);
                            break;
                        case"星期六":
//                            imageView.setImageResource(img[msg.getData().getInt("index")]);
                            imageView.setImageResource(img[6]);
                            break;
                    }
                }
            }
        };
        autoShowImg();
        Log.d("MainActivity",week);
    }

    public void autoShowImg(){
        new Thread(new Runnable() {
            @Override
            public void run() {
//                for (index = 0;index<=img.length;index++){
                    Message msg = new Message();
                    msg.what = change_img;
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("index",index);
//                    msg.setData(bundle);
                    handler.sendMessage(msg);
//                    if (index >=6) {
//                        index = -1;
//                    }
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
            }
        }).start();
    }

}

package com.example.asus.myapplication;

/**
 * Created by asus on 2018/5/5.
 */
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class  tactivity extends AppCompatActivity
{private int imageIds[] = {R.mipmap.pp1, R.mipmap.pp2, R.mipmap.pp3, R.mipmap.pp4, R.mipmap.pp5};
    private ArrayList<ImageView> images = new ArrayList<>();
    private ViewPager vp;
    private int oldPosition = 0;//记录上一次点的位置
    private int currentItem; //当前页面
    private ScheduledExecutorService scheduledExecutorService;
    //图片标题
    private String titles[] = new String[]{"图片1", "图片2", "图片3", "图片4", "图片5"};
    private ArrayList<View> dots = new ArrayList<View>();;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tactivity);
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageIds[i]);

            images.add(imageView);
        }


        //显示的点 加入集合
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));
        dots.add(findViewById(R.id.dot_4));

        //获取图片标题的id
        title = (TextView) findViewById(R.id.tv_test_title);

        //获取ViewPager 的id
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new ViewPagerAdapter());

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //设置页面刷新后的图片标题
                title.setText(titles[position]);
                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class ViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //将试图移除试图组
            View v =images.get(position);
            container.removeView(v);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //将试图添加进试图组
            View v =images.get(position);
            container.addView(v);
            return v;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //每隔两秒换一张图片
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(),2,2, TimeUnit.SECONDS);

    }
    //实现一个碎片的接口
    class ViewPagerTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem+1)%imageIds.length;
            //更新界面
            handler.obtainMessage().sendToTarget();
        }
    }
    //在handler进行碎片跳转
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            vp.setCurrentItem(currentItem);
        }
    };
}


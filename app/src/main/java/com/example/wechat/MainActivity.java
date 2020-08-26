package com.example.wechat;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private List<Fragment> viewList=new ArrayList<>();
    private FragmentPagerAdapter  fpagerAdapter;
    private RadioGroup radioGroup;
    private RadioButton radioHome,radioSearch,radioMore,radioPersonal;
    private int[] all={0,1,2,3};
    private List<RadioButton> radioButtons= new ArrayList<>();
    protected boolean useThemestatusBarColor = false;
    protected boolean useStatusBarColor = true;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        Fragment message_activity=new Message();
        Fragment content_activity=new Content();
        Fragment finding_activity=new Finding();
        Fragment me_activity=new Me();
        viewList.add(message_activity);
        viewList.add(content_activity);
        viewList.add(finding_activity);
        viewList.add(me_activity);
        mPagerAdapter fpagerAdapter = new mPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fpagerAdapter);

        RadioButton radioHome = (RadioButton) findViewById(R.id.radioHome);
        RadioButton radioSearch = (RadioButton) findViewById(R.id.radioSearch);
        RadioButton radioMore = (RadioButton) findViewById(R.id.radioMore);
        RadioButton radioPersonal = (RadioButton) findViewById(R.id.radioPersonal);
        radioButtons.add(radioHome);
        radioButtons.add(radioSearch);
        radioButtons.add(radioMore);
        radioButtons.add(radioPersonal);

        Drawable drawable1 = getResources().getDrawable(R.drawable.weixin);//找到图片
        drawable1.setBounds(0, 0, 60, 60);//最关键的一步，给图片设置大小,4个参数分别是左上右下，我看好多人对这个左上右下不理解，看下源码
        radioHome.setCompoundDrawables(null, drawable1, null, null);

        Drawable drawable2 = getResources().getDrawable(R.drawable.lianxiren);//找到图片
        drawable2.setBounds(0, 0, 60, 60);//最关键的一步，给图片设置大小,4个参数分别是左上右下，我看好多人对这个左上右下不理解，看下源码
        radioSearch.setCompoundDrawables(null, drawable2, null, null);

        Drawable drawable3 = getResources().getDrawable(R.drawable.faxian);//找到图片
        drawable3.setBounds(0, 0, 60, 60);//最关键的一步，给图片设置大小,4个参数分别是左上右下，我看好多人对这个左上右下不理解，看下源码
        radioMore.setCompoundDrawables(null, drawable3, null, null);

        Drawable drawable4 = getResources().getDrawable(R.drawable.wo);//找到图片
        drawable4.setBounds(0, 0, 60, 60);//最关键的一步，给图片设置大小,4个参数分别是左上右下，我看好多人对这个左上右下不理解，看下源码
        radioPersonal.setCompoundDrawables(null, drawable4, null, null);


        viewPager.setOnPageChangeListener(new pageChangeListener());
        radioGroup= (RadioGroup) findViewById(R.id.titleGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int i=0;
                for(RadioButton button:radioButtons){
                    if(button.getId()==checkedId){
                        viewPager.setCurrentItem(i);
                        break;
                    }
                    i++;
                }
            }
        });

    }



    class mPagerAdapter extends FragmentPagerAdapter{

        public mPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return viewList.get(i);
        }

        @Override
        public int getCount() {
            return viewList.size();
        }
    }

    class pageChangeListener  implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for(int i:all){
                if(i==position){
                    radioButtons.get(i).setChecked(true);
                }else{
                    radioButtons.get(i).setChecked(false);
                }
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}


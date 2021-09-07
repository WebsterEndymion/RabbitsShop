package com.shop.rabitshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.shop.rabitshop.fragment.FindFragment;
import com.shop.rabitshop.fragment.MainFragment;
import com.shop.rabitshop.fragment.MyFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected LinearLayout mMenuMain;
    protected LinearLayout mMenuFind;
    protected LinearLayout mMenuMy;
    protected MainFragment mMainFragment=new MainFragment();//首页
    protected FindFragment mFindFragmenr=new FindFragment();//发现
    protected MyFragment mMyFragment=new MyFragment();//我的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        this.getSupportFragmentManager().beginTransaction()
            .add(R.id.container_content,mMainFragment)
                .add(R.id.container_content,mFindFragmenr)
                .hide(mFindFragmenr)
                .add(R.id.container_content,mMyFragment)
                .hide(mMyFragment)
        .commit();
    }
    public void initView(){
        mMenuMain= (LinearLayout) this.findViewById(R.id.menu_main);
        mMenuFind= (LinearLayout) this.findViewById(R.id.menu_find);
        mMenuMy= (LinearLayout) this.findViewById(R.id.menu_my);

        mMenuMain.setOnClickListener(this);
        mMenuFind.setOnClickListener(this);
        mMenuMy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.menu_find:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .show(mFindFragmenr)
                        .hide(mMyFragment)
                        .commit();
                break;
            case R.id.menu_main:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mMainFragment)
                        .hide(mFindFragmenr)
                        .hide(mMyFragment)
                        .commit();
                break;
            case R.id.menu_my:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .hide(mFindFragmenr)
                        .show(mMyFragment)
                        .commit();
                break;
        }
    }
}
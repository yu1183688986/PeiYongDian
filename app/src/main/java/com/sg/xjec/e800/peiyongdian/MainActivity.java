package com.sg.xjec.e800.peiyongdian;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.sg.xjec.e800.peiyongdian.R;
import com.sg.xjec.e800.peiyongdian.adapter.FragmentAdapter;
import com.sg.xjec.e800.peiyongdian.fragments.ChartFragment;
import com.sg.xjec.e800.peiyongdian.fragments.HomeFragment;
import com.sg.xjec.e800.peiyongdian.fragments.MonitorFragment;
import com.sg.xjec.e800.peiyongdian.fragments.ProjectFragment;
import com.sg.xjec.e800.peiyongdian.utils.NoScrollViewPager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout mDrawerlayout;
    private BottomNavigationViewEx bnve;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private NoScrollViewPager viewpager;
    //数据源的集合
    private List<Fragment> list = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * viewpager操作
         */
        viewpager = findViewById(R.id.viewpager);
        bnve = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation);
        bottomNavigationViewEx_init();
        initData();
        initEvent();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        //设置toolBar的menu图标
        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.menu_add));
        setSupportActionBar(toolbar);
        mDrawerlayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        navigationView.setCheckedItem(R.id.nav_friends);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_call:
                        Toast.makeText(MainActivity.this,"call",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_friends:
                        Toast.makeText(MainActivity.this,"friends",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_location:
                        Toast.makeText(MainActivity.this,"location",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_mail:
                        Toast.makeText(MainActivity.this,"mail",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_task:
                        Toast.makeText(MainActivity.this,"task",Toast.LENGTH_SHORT).show();
                        break;
                }
                mDrawerlayout.closeDrawers();
                return true;
            }
        });
        /*FloatingActionButton fab = findViewById(R.id.floatactionbutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"FloatingActionButton",Toast.LENGTH_SHORT).show();
                Snackbar.make(view,"Data deleted",Snackbar.LENGTH_SHORT).setAction(
                        "Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"Data restored",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ).show();
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        //让图标显示
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {

                }
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backup:
                Toast.makeText(this,"Backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                //如果是在首页界面打开导航窗口,否则返回首页界面
                if (0 == viewpager.getCurrentItem()){
                    mDrawerlayout.openDrawer(GravityCompat.START);
                }else {
                    viewpager.setCurrentItem(0);
                }
                break;
                default:
        }
        return true;
    }
    private void bottomNavigationViewEx_init(){
        if (null != bnve){
            bnve.enableAnimation(true);
            bnve.enableShiftingMode(false);
            bnve.enableItemShiftingMode(false);
            //bnve.setTextSize(16);
        }
    }

    private void initData() {
        //给ViewPager设置数据
        list.add(new HomeFragment());
        list.add(new MonitorFragment());
        list.add(new ChartFragment());
        list.add(new ProjectFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(adapter);
        //设置选中第一个添加的按钮
        bnve.setCurrentItem(0);
        //显示ViewPager中添加的第一个页面
        viewpager.setCurrentItem(0);
        viewpager.setNoScroll(true);
       // bnve.setupWithViewPager(viewpager,true);
    }

    //联动显示
    private void initEvent() {
        //监听ViewPager的滑动
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
            }

            @Override
            public void onPageSelected(int i) {
                //页面滑动后，按钮改变
                bnve.setCurrentItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getTitle().toString()){
                    case "首页":
                        viewpager.setCurrentItem(0);
                        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
                        toolbar.setBackgroundResource(R.color.colorPrimary);
                        toolbar.setTitle("首页");
                        break;
                    case "监控":
                        viewpager.setCurrentItem(1);
                        toolbar.setTitle("监控");
                        toolbar.setBackgroundResource(R.color.jiankong_bar);
                        actionBar.setHomeAsUpIndicator(0);
                        break;
                    case "图表":
                        viewpager.setCurrentItem(2);
                        toolbar.setTitle("设备状态监视");
                        toolbar.setBackgroundResource(R.color.light_red);
                        actionBar.setHomeAsUpIndicator(0);
                        break;
                    case "项目":
                        viewpager.setCurrentItem(3);
                        toolbar.setTitle("项目");
                        toolbar.setBackgroundResource(R.color.Green);
                        actionBar.setHomeAsUpIndicator(0);
                        break;
                        default:
                            break;
                }

                return true;
            }
        });

    }
}

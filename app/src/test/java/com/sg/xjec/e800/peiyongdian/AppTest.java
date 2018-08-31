/*
package com.sg.xjec.e800.peiyongdian;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;
import org.robolectric.util.FragmentTestUtil;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class AppTest {
    */
/**
     * 验证点击事件是否触发了页面跳转，验证目标页面是否预期页面
     *
     * @throws Exception
     *//*

    @Test
    public void testJump() throws Exception {
        // 默认会调用Activity的生命周期: onCreate->onStart->onResume
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        // 触发按钮点击
        activity.findViewById(R.id.activity_main_jump).performClick();

        // 获取对应的Shadow类
        ShadowActivity shadowActivity = shadowOf(activity);
        // 借助Shadow类获取启动下一Activity的Intent
        Intent nextIntent = shadowActivity.getNextStartedActivity();
        // 校验Intent的正确性
        assertEquals(nextIntent.getComponent().getClassName(), SecondActivity.class.getName());
    }

    @Test
    public void testLifecycle() throws Exception {
        // 创建Activity控制器
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        MainActivity activity = controller.get();
        assertNull(activity.getLifecycleState());

        // 调用Activity的performCreate方法
        controller.create();
        assertEquals("onCreate", activity.getLifecycleState());

        // 调用Activity的performStart方法
        controller.start();
        assertEquals("onStart", activity.getLifecycleState());

        // 调用Activity的performResume方法
        controller.resume();
        assertEquals("onResume", activity.getLifecycleState());

        // 调用Activity的performPause方法
        controller.pause();
        assertEquals("onPause", activity.getLifecycleState());

        // 调用Activity的performStop方法
        controller.stop();
        assertEquals("onStop", activity.getLifecycleState());

        // 调用Activity的performRestart方法
        controller.restart();
        // 注意此处应该是onStart，因为performRestart不仅会调用restart，还会调用onStart
        assertEquals("onStart", activity.getLifecycleState());

        // 调用Activity的performDestroy方法
        controller.destroy();
        assertEquals("onDestroy", activity.getLifecycleState());
    }

    */
/**
     * 启动Activity的时候传递Intent
     *
     * @throws Exception
     *//*

    @Test
    public void testStartActivityWithIntent() throws Exception {
        Intent intent = new Intent();
        intent.putExtra("test", "HelloWorld");
        Activity activity = Robolectric.buildActivity(MainActivity.class).withIntent(intent).create().get();
        assertEquals("HelloWorld", activity.getIntent().getExtras().getString("test"));
    }

    */
/**
     * savedInstanceState会在onRestoreInstanceState回调中传递给Activity
     *
     * @throws Exception
     *//*

    @Test
    public void testSavedInstanceState() throws Exception {
        Bundle savedInstanceState = new Bundle();
        Robolectric.buildActivity(MainActivity.class).create().restoreInstanceState(savedInstanceState).get();
        // verify something
    }

    @Test
    public void testVisible() throws Exception {
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        MainActivity activity = controller.get();

        // 调用Activity的performCreate并且设置视图visible
        controller.create().visible();
        // 触发点击
        activity.findViewById(R.id.activity_main_button1).performClick();

        // 验证
        assertEquals(shadowOf(activity).getNextStartedActivity().getComponent().getClassName(), SecondActivity.class.getName());
    }

    */
/**
     * 验证UI组件状态
     *
     * @throws Exception
     *//*

    @Test
    public void testCheckBoxState() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        CheckBox checkBox = (CheckBox) activity.findViewById(R.id.activity_main_check_box);
        // 验证CheckBox初始状态
        assertFalse(checkBox.isChecked());

        // 点击按钮反转CheckBox状态
        activity.findViewById(R.id.activity_main_switch_check_box).performClick();
        // 验证状态是否正确
        assertTrue(checkBox.isChecked());

        // 点击按钮反转CheckBox状态
        activity.findViewById(R.id.activity_main_switch_check_box).performClick();
        // 验证状态是否正确
        assertFalse(checkBox.isChecked());
    }

    */
/**
     * 验证Dialog是否正确弹出
     *
     * @throws Exception
     *//*

    @Test
    public void testDialog() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        AlertDialog dialog = ShadowAlertDialog.getLatestAlertDialog();
        // 判断Dialog尚未弹出
        assertNull(dialog);

        activity.findViewById(R.id.activity_main_show_dialog).performClick();
        dialog = ShadowAlertDialog.getLatestAlertDialog();
        // 判断Dialog已经弹出
        assertNotNull(dialog);
        // 获取Shadow类进行验证
        ShadowAlertDialog shadowDialog = shadowOf(dialog);
        assertEquals("AlertDialog", shadowDialog.getTitle());
        assertEquals("Oops, now you see me ~", shadowDialog.getMessage());
    }

    */
/**
     * 验证Toast是否正确弹出
     *
     * @throws Exception
     *//*

    @Test
    public void testToast() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Toast toast = ShadowToast.getLatestToast();
        // 判断Toast尚未弹出
        assertNull(toast);

        activity.findViewById(R.id.activity_main_show_toast).performClick();
        toast = ShadowToast.getLatestToast();
        // 判断Toast已经弹出
        assertNotNull(toast);
        // 获取Shadow类进行验证
        ShadowToast shadowToast = shadowOf(toast);
        assertEquals(Toast.LENGTH_SHORT, shadowToast.getDuration());
        assertEquals("oops", ShadowToast.getTextOfLatestToast());
    }

    @RunWith(RobolectricTestRunner.class)
    @Config(constants = BuildConfig.class, application = CustomApplication.class)
    public class MyFragmentTest {

        private MyFragment myFragment;

        @Before
        public void setUp() throws Exception {
            myFragment = new MyFragment();
            // 把Fragment添加到Activity中
            FragmentTestUtil.startFragment(myFragment);
        }

        @Test
        public void testFragment() throws Exception {
            assertNotNull(myFragment.getView());
        }
    }


}
*/

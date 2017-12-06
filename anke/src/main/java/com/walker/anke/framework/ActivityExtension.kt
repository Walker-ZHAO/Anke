package com.walker.anke.framework

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager

/**
 * Activity 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/12/6
 */

/**
 * 设置状态栏字体及图标为深色（MIUIV6+）
 *
 * @param dark: 是否把状态栏字体及图标设置为深色
 */
fun Activity.MIUIStatusBarLightMode(dark: Boolean) {
    val windowClass = Window::class.java
    try {
        val layoutParams = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
        val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
        val darkModeFlag = field.getInt(layoutParams)
        val extraFlagField = windowClass.getMethod("setExtraFlags", Int::class.javaPrimitiveType, Int::class.javaPrimitiveType)
        if (dark) {
            extraFlagField.invoke(window, darkModeFlag, darkModeFlag)   // 状态栏透明&黑色字体
        } else {
            extraFlagField.invoke(window, 0, darkModeFlag)          // 清除黑色字体
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * 设置状态栏字体及图标为深色（Flyme4.0+）
 *
 * @param dark: 是否把状态栏字体及图标设置为深色
 */
fun Activity.FlymeStatusBarLightMode(dark: Boolean) {
    try {
        val lp = window.attributes
        val darkFlag = WindowManager.LayoutParams::class.java.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
        val flymeFlag = WindowManager.LayoutParams::class.java.getDeclaredField("meizuFlags")
        darkFlag.isAccessible = true
        flymeFlag.isAccessible = true
        val bit = darkFlag.getInt(null)
        val value = when(dark) {
            true -> flymeFlag.getInt(lp) or bit
            false -> flymeFlag.getInt(lp) and bit.inv()
        }
        flymeFlag.setInt(lp, value)
        window.attributes = lp
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * 设置状态栏为Light模式
 */
fun Activity.statusBarLightMode() {
    MIUIStatusBarLightMode(true)
    FlymeStatusBarLightMode(true)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}
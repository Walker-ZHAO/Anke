package com.walker.anke.framework

import android.content.Context
import android.os.Process
import org.jetbrains.anko.activityManager

/**
 * Context 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/10/13
 */

/**
 * 当前进程名
 */
val Context.processName: String?
    get() = activityManager.runningAppProcesses
                .filter { it.pid ==  Process.myPid() }
                .map { it.processName }
                .firstOrNull()

/**
 * 禁用导航栏
 *
 * Note: 需要使用系统签名
 */
fun Context.disableNatigation() {
    try {
        val service = getSystemService("statusbar")
        val statusbarManager = Class.forName("android.app.StatusBarManager")
        val method = statusbarManager.getMethod("disable", Int::class.javaPrimitiveType)
        method.invoke(service, DISABLE_NAVIGATION)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * 禁用下拉通知栏
 *
 * Note: 需要使用系统签名
 */
fun Context.disableNotificationBar() {
    try {
        val service = getSystemService("statusbar")
        val statusbarManager = Class.forName("android.app.StatusBarManager")
        val method = statusbarManager.getMethod("disable", Int::class.javaPrimitiveType)
        method.invoke(service, DISABLE_EXPAND)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

val DISABLE_EXPAND = 0x00010000
val DISABLE_NOTIFICATION_ICONS = 0x00020000
val DISABLE_NOTIFICATION_ALERTS = 0x00040000
val DISABLE_NOTIFICATION_TICKER = 0x00080000
val DISABLE_SYSTEM_INFO = 0x00100000
val DISABLE_HOME = 0x00200000
val DISABLE_RECENT = 0x01000000
val DISABLE_BACK = 0x00400000
val DISABLE_CLOCK = 0x00800000
val DISABLE_SEARCH = 0x02000000
val DISABLE_NONE = 0x00000000

val DISABLE_NAVIGATION = DISABLE_HOME or DISABLE_RECENT
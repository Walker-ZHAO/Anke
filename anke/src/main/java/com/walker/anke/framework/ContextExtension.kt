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
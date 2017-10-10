@file:JvmName("ViewUtils")
package com.walker.anke.framework

import android.support.design.widget.Snackbar
import android.view.View

/**
 * View 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/9/22
 */

/**
 * 设置View可见
 */
fun View.visiable() {
    visibility = View.VISIBLE
}

/**
 * 设置View不可见
 */
fun View.gone() {
    visibility = View.GONE
}

/**
 * 显示一个Snackbar
 *
 * @param message   要显示的消息
 * @param duration  持续时间
 * @param block     要对显示的Snackbar进行的操作，可为null
 *
 */
fun View.snack(message: String, duration: Int = Snackbar.LENGTH_SHORT, block: (Snackbar.() -> Unit)? = null) {
    val snack = Snackbar.make(this, message, duration)
    block?.let {
        snack.block()
    }
    snack.show()
}
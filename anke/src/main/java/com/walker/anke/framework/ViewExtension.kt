@file:JvmName("ViewUtils")
package com.walker.anke.framework

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
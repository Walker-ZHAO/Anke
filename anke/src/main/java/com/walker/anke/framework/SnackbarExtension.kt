package com.walker.anke.framework

import android.support.design.widget.Snackbar
import android.view.View

/**
 * Snackbar 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/10/10
 */

/**
 * 设置Snackbar的Action
 *
 * @param
 */
fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let {
        setActionTextColor(it)
    }
}

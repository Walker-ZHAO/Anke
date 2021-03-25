package com.walker.anke.framework

import android.app.ProgressDialog
import android.content.Context

/**
 * 对话框
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2021/3/25
 */

@Deprecated(message = "Android progress dialogs are deprecated")
fun Context.indeterminateProgressDialog(
        message: Int? = null,
        title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(true, message?.let { getString(it) }, title?.let { getString(it) }, init)

@Deprecated(message = "Android progress dialogs are deprecated")
fun Context.indeterminateProgressDialog(
        message: CharSequence? = null,
        title: CharSequence? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(true, message, title, init)


@Deprecated(message = "Android progress dialogs are deprecated")
private fun Context.progressDialog(
        indeterminate: Boolean,
        message: CharSequence? = null,
        title: CharSequence? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = ProgressDialog(this).apply {
    isIndeterminate = indeterminate
    if (!indeterminate) setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
    if (message != null) setMessage(message)
    if (title != null) setTitle(title)
    if (init != null) init()
    show()
}

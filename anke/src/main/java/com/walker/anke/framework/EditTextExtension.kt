package com.walker.anke.framework

import android.text.Selection
import android.text.Spannable
import android.widget.EditText

/**
 * EditText 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/12/6
 */

/**
 * 更新输入框光标位置
 *
 * @param index: 光标位置，默认为最末尾
 */
fun EditText.updateCursorLocation(index: Int = text.length) {
    Selection.setSelection(text, index)
}
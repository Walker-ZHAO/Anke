package com.walker.anke.framework

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment

/**
 * Fragment扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2021/3/25
 */

inline val Fragment.act: Activity?
    get() = activity

inline val Fragment.ctx: Context?
    get() = activity

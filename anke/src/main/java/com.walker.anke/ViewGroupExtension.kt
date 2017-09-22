package com.walker.anke

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.layoutInflater

/**
 * ViewGroup 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/9/22
 */

/**
 * 填充子View
 *
 * @param layoutRes 子View的layout资源ID
 *
 * @return 填充后的View
 *
 */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

// 所有子View集合
val ViewGroup.children: List<View>
    get() = (0 until childCount).map { getChildAt(it) }
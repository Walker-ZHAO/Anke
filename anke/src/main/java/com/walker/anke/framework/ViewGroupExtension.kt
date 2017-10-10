@file:JvmName("ViewGroupUtils")
package com.walker.anke.framework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
 * @param attachToRoot 是否附上根View参数
 *
 * @return 填充后的View
 *
 */
@JvmOverloads
fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

// 所有子View集合
val ViewGroup.children: List<View>
    get() = (0 until childCount).map { getChildAt(it) }

val ViewGroup.views: List<View>
    get() = (0 until  childCount).flatMap {
        with(getChildAt(it)) {
            when (this) {
                is ViewGroup    ->  this.views
                else    ->  listOf(this)
            }
        }
    }
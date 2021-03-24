package com.walker.anke.framework

import androidx.drawerlayout.widget.DrawerLayout

/**
 * DrawerLayout 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/10/10
 */

/**
 * 指定消费了一个事件，并执行指定操作,然后关闭抽屉
 *
 * @param block 需要执行的操作
 *
 */
inline fun DrawerLayout.consum(block: () -> Unit): Boolean {
    block()
    closeDrawers()
    return true
}
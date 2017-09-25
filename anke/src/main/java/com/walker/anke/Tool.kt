package com.walker.anke

/**
 * 实用方法
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/9/25
 */

/**
 * 指定消费了一个事件，并执行指定操作
 *
 * @param block 需要执行的操作
 *
 */
inline fun consum(block: () -> Unit): Boolean {
    block()
    return true
}
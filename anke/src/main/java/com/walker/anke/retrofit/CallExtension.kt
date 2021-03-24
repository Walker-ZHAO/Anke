@file:JvmName("CallUtils")
package com.walker.anke.retrofit

import retrofit2.Call


/**
 * Call 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/9/27
 */

/**
 * 调用包装器
 * @param f 数据的处理函数
 */
inline fun <T, R> Call<T>.unwrapCall(f: T.() -> R): R? = execute().body()?.f()
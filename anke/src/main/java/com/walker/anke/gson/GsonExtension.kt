@file:JvmName("GsonUtils")
package com.walker.anke.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Gson 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/9/25
 */

/**
 * 将Json字符串映射成对象
 *
 * @param json  Json字符串
 *
 * @return 映射后的对象实体
 */
inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)
package com.walker.anke.foundation

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * 字符串扩展集
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2019-05-31
 */

fun String.md5(): String {
    try {
        val instance: MessageDigest = MessageDigest.getInstance("MD5")//获取md5加密对象
        val digest:ByteArray = instance.digest(toByteArray())//对字符串加密，返回字节数组
        val sb = StringBuffer()
        digest.forEach {
            val i = it.toInt() and 0xFF //获取低八位有效值
            var hexString = Integer.toHexString(i)//将整数转化为16进制
            if (hexString.length < 2)
                hexString = "0$hexString"   //如果是一位的话，补0
            sb.append(hexString)
        }
        return sb.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }

    return ""
}
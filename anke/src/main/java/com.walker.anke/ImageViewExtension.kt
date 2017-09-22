package com.walker.anke

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.widget.ImageView
import java.io.FileOutputStream

/**
 * ImageView 扩展
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/9/22
 */

/**
 * 设置Base64编码的图片
 *
 * @param base64    Base64编码
 * @param flag      Base64编码输出格式
 *
 * @see [Base64]
 */
fun ImageView.setBase64(base64: String, flag: Int) {
    if (base64.isNotEmpty()) {
        var thumb: Bitmap? = null
        val bytes = Base64.decode(base64, flag)
        val file = createTempFile(suffix = ".png")
        var out: FileOutputStream? = null
        try {
            out = FileOutputStream(file)
            out.write(bytes)
            out.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            out?.close()
        }
        thumb = BitmapFactory.decodeFile(file.absolutePath)
        file.delete()
        setImageBitmap(thumb)
    }
}
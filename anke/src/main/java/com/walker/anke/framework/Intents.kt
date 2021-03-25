package com.walker.anke.framework

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.fragment.app.Fragment

/**
 * Intent相关
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2021/3/25
 */

inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
        AnkeInternals.internalStartActivity(this, T::class.java, params)

inline fun <reified T: Activity> Fragment.startActivity(vararg params: Pair<String, Any?>) =
        AnkeInternals.internalStartActivity(activity, T::class.java, params)

inline fun <reified T: Activity> Activity.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any?>) =
        AnkeInternals.internalStartActivityForResult(this, T::class.java, requestCode, params)

inline fun <reified T: Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any?>) =
        startActivityForResult(AnkeInternals.createIntent(act, T::class.java, params), requestCode)

inline fun <reified T: Service> Context.startService(vararg params: Pair<String, Any?>) =
        AnkeInternals.internalStartService(this, T::class.java, params)

inline fun <reified T: Service> Fragment.startService(vararg params: Pair<String, Any?>) =
        AnkeInternals.internalStartService(activity, T::class.java, params)

inline fun <reified T : Service> Context.stopService(vararg params: Pair<String, Any?>) =
        AnkeInternals.internalStopService(this, T::class.java, params)

inline fun <reified T : Service> Fragment.stopService(vararg params: Pair<String, Any?>) =
        AnkeInternals.internalStopService(activity, T::class.java, params)

inline fun <reified T: Any> Context.intentFor(vararg params: Pair<String, Any?>): Intent =
        AnkeInternals.createIntent(this, T::class.java, params)

inline fun <reified T: Any> Fragment.intentFor(vararg params: Pair<String, Any?>): Intent =
        AnkeInternals.createIntent(activity, T::class.java, params)

/**
 * Add the [Intent.FLAG_ACTIVITY_CLEAR_TASK] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.clearTask(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) }

/**
 * Add the [Intent.FLAG_ACTIVITY_CLEAR_TOP] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.clearTop(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) }

/**
 * Add the [Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
@Deprecated(message = "Deprecated in Android", replaceWith = ReplaceWith("org.jetbrains.Anke.newDocument"))
inline fun Intent.clearWhenTaskReset(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET) }

/**
 * Add the [Intent.FLAG_ACTIVITY_NEW_DOCUMENT] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.newDocument(): Intent = apply {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
    } else {
        @Suppress("DEPRECATION")
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
    }
}

/**
 * Add the [Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.excludeFromRecents(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS) }

/**
 * Add the [Intent.FLAG_ACTIVITY_MULTIPLE_TASK] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.multipleTask(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK) }

/**
 * Add the [Intent.FLAG_ACTIVITY_NEW_TASK] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.newTask(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }

/**
 * Add the [Intent.FLAG_ACTIVITY_NO_ANIMATION] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.noAnimation(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION) }

/**
 * Add the [Intent.FLAG_ACTIVITY_NO_HISTORY] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.noHistory(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY) }

/**
 * Add the [Intent.FLAG_ACTIVITY_SINGLE_TOP] flag to the [Intent].
 *
 * @return the same intent with the flag applied.
 */
inline fun Intent.singleTop(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP) }

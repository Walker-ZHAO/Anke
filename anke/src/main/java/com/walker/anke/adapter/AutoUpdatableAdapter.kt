package com.walker.anke.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * 自动更新适配器
 *
 * Author: Walker
 * Email: zhaocework@gmail.com
 * Date: 2017/10/10
 */
interface AutoUpdatableAdapter {

    /**
     * 使用DiffUtil工具进行Adapter自动更新
     *
     * @param oldList   老数据
     * @param newList   新数据
     * @param compare   单一项目是否相同的比较
     *
     */
    fun <T> RecyclerView.Adapter<*>.autoUpdate(oldList: List<T>, newList: List<T>, compare: (T, T) -> Boolean) {
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return compare(oldList[oldItemPosition], newList[newItemPosition])
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
            }

            override fun getOldListSize() = oldList.size

            override fun getNewListSize() = newList.size
        })

        diff.dispatchUpdatesTo(this)
    }
}
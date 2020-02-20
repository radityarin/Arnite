package com.go.arnite.data.source

interface DataSource<T> {
    interface LoadItemsCallback<T> {

        fun  onItemsLoaded(items: ArrayList<T>)

        fun onDataNotAvailable()
    }

    interface GetItemCallback<T> {

        fun  onItemLoaded(item: T)

        fun onDataNotAvailable()
    }

    fun  getItems(callback: LoadItemsCallback<T>)

    fun  getItem(itemId: String, callback: GetItemCallback<T>)

    fun saveItem(item: Object)

    fun updateItem(itemId: String, item: Object)

    fun deleteAllItems()

    fun deleteItem(itemId: String)
}
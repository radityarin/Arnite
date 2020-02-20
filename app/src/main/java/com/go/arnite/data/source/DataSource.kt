package com.go.arnite.data.source

interface DataSource<T> {
    interface LoadItemsCallback<X> {

        fun onItemsLoaded(items: List<X>)

        fun onDataNotAvailable()
    }

    interface GetItemCallback<X> {

        fun onItemLoaded(item: X)

        fun onDataNotAvailable()
    }

    fun getItems(callback: LoadItemsCallback<T>)

    fun getItem(itemId: String, callback: GetItemCallback<T>)

    fun saveItem(item: T)

    fun updateItem(itemId: String, item: T)

    fun deleteAllItems()

    fun deleteItem(itemId: String)
}
package com.go.arnite.data.source.remote

import com.go.arnite.data.source.DataSource

class FirebaseDataSource<T>: DataSource<T> {

    override fun getItem(itemId: String, callback: DataSource.GetItemCallback<T>) {

    }

    override fun saveItem(item: T) {

    }

    override fun updateItem(itemId: String, item: T) {

    }

    override fun deleteAllItems() {

    }

    override fun deleteItem(itemId: String) {

    }

    override fun getItems(callback: DataSource.LoadItemsCallback<T>) {

    }

}
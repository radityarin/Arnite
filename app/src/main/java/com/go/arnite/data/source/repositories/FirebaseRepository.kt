package com.go.arnite.data.source.repositories

import com.go.arnite.data.source.DataSource

class FirebaseRepository<T>: DataSource<T> {

    lateinit var mFirebaseDataSource: DataSource<T>

    constructor(firebaseDataSource: DataSource<T>) {
        this.mFirebaseDataSource = firebaseDataSource
    }

    override fun getItems(callback: DataSource.LoadItemsCallback<T>) {
        mFirebaseDataSource.getItems(object :
            DataSource.LoadItemsCallback<T> {
            override fun onItemsLoaded(items: List<T>) {
                callback.onItemsLoaded(items)
            }

            override fun onDataNotAvailable() {

            }
        })
    }

    override fun getItem(itemId: String, callback: DataSource.GetItemCallback<T>) {
        mFirebaseDataSource.getItem(itemId, object :
            DataSource.GetItemCallback<T> {
            override fun onItemLoaded(item: T) {
                callback.onItemLoaded(item)
            }

            override fun onDataNotAvailable() {

            }

        })
    }

    override fun saveItem(item: T) {
        mFirebaseDataSource.saveItem(item)
    }

    override fun updateItem(itemId: String, item: T) {
        mFirebaseDataSource.updateItem(itemId, item)
    }

    override fun deleteAllItems() {
        mFirebaseDataSource.deleteAllItems()
    }

    override fun deleteItem(itemId: String) {
        mFirebaseDataSource.deleteItem(itemId)
    }

}
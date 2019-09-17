package com.example.kotlinmvvmdemo.data

class FakeDataBase private constructor() {
      val quoteDao =FakeQouteDao()
    companion object {
        @Volatile
        private var instance: FakeDataBase? = null

        fun getInstance() =
            instance ?: synchronized(this)
            {
                instance ?: FakeDataBase().also { instance = it }
            }
    }

}
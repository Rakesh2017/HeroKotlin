package com.example.herokotlin.repostories;

abstract class BaseRepository<T> {

    private T instance;

    public T getInstance () {
        if (instance == null) {
            instance  = createInstance();
        }
        return instance;
    }

    abstract T createInstance();

    public void destroyInstance () {
        if (instance != null) {
            instance = null;
        }
    }

}

package com.example.networkconnectivityapplication;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;

@Singleton
public class AppExecutors {

    private final Executor networkIO;
    private final Executor diskIO;
    private final Executor mainThread;

    @Inject
    public AppExecutors() {
        this.networkIO = Executors.newSingleThreadExecutor();
        this.diskIO = Executors.newFixedThreadPool(3);
        this.mainThread = new MainThreadExecutor();
    }

    public Executor getNetworkIO() {
        return networkIO;
    }

    public Executor getDiskIO() {
        return diskIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }

}

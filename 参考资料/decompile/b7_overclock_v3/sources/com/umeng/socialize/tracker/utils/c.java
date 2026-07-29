package com.umeng.socialize.tracker.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24819a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f24820b = Executors.newFixedThreadPool(1);

    public static void a(Runnable runnable) {
        if (runnable != null) {
            f24820b.execute(runnable);
        }
    }
}

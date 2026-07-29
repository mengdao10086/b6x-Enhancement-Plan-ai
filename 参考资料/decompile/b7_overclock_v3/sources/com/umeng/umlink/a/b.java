package com.umeng.umlink.a;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static BlockingQueue<Runnable> f24861d = new ArrayBlockingQueue(64);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f24858a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f24859b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f24860c = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f24862e = new ThreadPoolExecutor(f24858a, f24859b, f24860c, TimeUnit.SECONDS, f24861d);

    public static void a(Runnable runnable) {
        f24862e.execute(runnable);
    }
}

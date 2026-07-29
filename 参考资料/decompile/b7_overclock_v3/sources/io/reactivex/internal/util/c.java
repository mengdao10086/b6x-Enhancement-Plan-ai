package io.reactivex.internal.util;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public c() {
        throw new IllegalStateException("No instances!");
    }

    public static void a(CountDownLatch countDownLatch, io.reactivex.disposables.b bVar) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            b();
            countDownLatch.await();
        } catch (InterruptedException e10) {
            bVar.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e10);
        }
    }

    public static void b() {
        if (kj.a.L()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.h) || kj.a.W()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}

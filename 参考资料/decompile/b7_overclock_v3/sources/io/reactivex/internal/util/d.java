package io.reactivex.internal.util;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes5.dex */
public final class d extends CountDownLatch implements dj.g<Throwable>, dj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f35255a;

    public d() {
        super(1);
    }

    @Override // dj.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th2) {
        this.f35255a = th2;
        countDown();
    }

    @Override // dj.a
    public void run() {
        countDown();
    }
}

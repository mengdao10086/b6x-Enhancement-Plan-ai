package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.m;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T extends m> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12295b = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<T> f12296a = v4.o.f(20);

    public abstract T a();

    public T b() {
        T tPoll = this.f12296a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t10) {
        if (this.f12296a.size() < 20) {
            this.f12296a.offer(t10);
        }
    }
}

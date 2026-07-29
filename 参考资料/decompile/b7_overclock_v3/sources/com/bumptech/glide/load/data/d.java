package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public interface d<T> {

    public interface a<T> {
        void c(@n0 Exception exc);

        void d(@p0 T t10);
    }

    @n0
    Class<T> a();

    void b();

    void cancel();

    @n0
    DataSource e();

    void f(@n0 Priority priority, @n0 a<? super T> aVar);
}

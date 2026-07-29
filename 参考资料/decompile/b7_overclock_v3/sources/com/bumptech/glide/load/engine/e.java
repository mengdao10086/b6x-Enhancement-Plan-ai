package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public interface a {
        void c(c4.b bVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource);

        void d();

        void e(c4.b bVar, @p0 Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, c4.b bVar2);
    }

    boolean a();

    void cancel();
}

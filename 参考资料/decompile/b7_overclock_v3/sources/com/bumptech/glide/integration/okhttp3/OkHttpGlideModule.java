package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.b;
import g.n0;
import h4.g;
import java.io.InputStream;
import q4.c;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OkHttpGlideModule implements c {
    @Override // q4.b
    public void a(@n0 Context context, @n0 com.bumptech.glide.c cVar) {
    }

    @Override // q4.f
    public void b(Context context, com.bumptech.glide.b bVar, Registry registry) {
        registry.y(g.class, InputStream.class, new b.a());
    }
}

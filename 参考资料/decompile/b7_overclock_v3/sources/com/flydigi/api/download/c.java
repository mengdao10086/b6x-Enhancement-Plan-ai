package com.flydigi.api.download;

import java.io.IOException;
import kotlin.jvm.internal.f0;
import okhttp3.d0;
import okhttp3.v;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final d f13306a;

    public c(@k d listener) {
        f0.p(listener, "listener");
        this.f13306a = listener;
    }

    @k
    public final d a() {
        return this.f13306a;
    }

    @Override // okhttp3.v
    @k
    public d0 intercept(@k v.a chain) throws IOException {
        f0.p(chain, "chain");
        d0 d0VarE = chain.e(chain.T());
        return d0VarE.s1().b(new e(d0VarE.L(), this.f13306a)).c();
    }
}

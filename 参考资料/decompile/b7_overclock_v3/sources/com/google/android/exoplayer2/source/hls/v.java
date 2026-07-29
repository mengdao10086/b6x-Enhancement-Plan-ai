package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import hd.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<p0> f18118a = new SparseArray<>();

    public p0 a(int i10) {
        p0 p0Var = this.f18118a.get(i10);
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0(Long.MAX_VALUE);
        this.f18118a.put(i10, p0Var2);
        return p0Var2;
    }

    public void b() {
        this.f18118a.clear();
    }
}

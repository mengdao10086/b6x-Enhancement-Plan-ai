package com.bumptech.glide;

import com.bumptech.glide.j;
import g.n0;
import t4.j;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t4.g<? super TranscodeType> f12164a = t4.e.c();

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    @n0
    public final CHILD b() {
        return (CHILD) f(t4.e.c());
    }

    public final t4.g<? super TranscodeType> c() {
        return this.f12164a;
    }

    public final CHILD d() {
        return this;
    }

    @n0
    public final CHILD e(int i10) {
        return (CHILD) f(new t4.h(i10));
    }

    @n0
    public final CHILD f(@n0 t4.g<? super TranscodeType> gVar) {
        this.f12164a = (t4.g) m.d(gVar);
        return (CHILD) d();
    }

    @n0
    public final CHILD g(@n0 j.a aVar) {
        return (CHILD) f(new t4.i(aVar));
    }
}

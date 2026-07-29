package com.bumptech.glide.load.engine;

import androidx.core.util.n;
import g.n0;
import w4.a;

/* JADX INFO: loaded from: classes2.dex */
public final class r<Z> implements s<Z>, a.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n.a<r<?>> f12466e = w4.a.e(20, new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w4.c f12467a = w4.c.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s<Z> f12468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12470d;

    public class a implements a.d<r<?>> {
        @Override // w4.a.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r<?> create() {
            return new r<>();
        }
    }

    @n0
    public static <Z> r<Z> e(s<Z> sVar) {
        r<Z> rVar = (r) v4.m.d(f12466e.a());
        rVar.b(sVar);
        return rVar;
    }

    @Override // com.bumptech.glide.load.engine.s
    public synchronized void a() {
        this.f12467a.c();
        this.f12470d = true;
        if (!this.f12469c) {
            this.f12468b.a();
            g();
        }
    }

    public final void b(s<Z> sVar) {
        this.f12470d = false;
        this.f12469c = true;
        this.f12468b = sVar;
    }

    @Override // com.bumptech.glide.load.engine.s
    public int c() {
        return this.f12468b.c();
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<Z> d() {
        return this.f12468b.d();
    }

    @Override // w4.a.f
    @n0
    public w4.c f() {
        return this.f12467a;
    }

    public final void g() {
        this.f12468b = null;
        f12466e.b(this);
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Z get() {
        return this.f12468b.get();
    }

    public synchronized void h() {
        this.f12467a.c();
        if (!this.f12469c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f12469c = false;
        if (this.f12470d) {
            a();
        }
    }
}

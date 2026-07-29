package com.bumptech.glide.load.engine;

import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class n<Z> implements s<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s<Z> f12455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f12456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c4.b f12457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12459g;

    public interface a {
        void c(c4.b bVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z10, boolean z11, c4.b bVar, a aVar) {
        this.f12455c = (s) v4.m.d(sVar);
        this.f12453a = z10;
        this.f12454b = z11;
        this.f12457e = bVar;
        this.f12456d = (a) v4.m.d(aVar);
    }

    @Override // com.bumptech.glide.load.engine.s
    public synchronized void a() {
        if (this.f12458f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f12459g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f12459g = true;
        if (this.f12454b) {
            this.f12455c.a();
        }
    }

    public synchronized void b() {
        if (this.f12459g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f12458f++;
    }

    @Override // com.bumptech.glide.load.engine.s
    public int c() {
        return this.f12455c.c();
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<Z> d() {
        return this.f12455c.d();
    }

    public s<Z> e() {
        return this.f12455c;
    }

    public boolean f() {
        return this.f12453a;
    }

    public void g() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f12458f;
            if (i10 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z10 = true;
            int i11 = i10 - 1;
            this.f12458f = i11;
            if (i11 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            this.f12456d.c(this.f12457e, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Z get() {
        return this.f12455c.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f12453a + ", listener=" + this.f12456d + ", key=" + this.f12457e + ", acquired=" + this.f12458f + ", isRecycled=" + this.f12459g + ", resource=" + this.f12455c + '}';
    }
}

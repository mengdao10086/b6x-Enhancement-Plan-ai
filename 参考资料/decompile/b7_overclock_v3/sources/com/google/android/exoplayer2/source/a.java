package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import ed.z;
import g.p0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<l.b> f17505a = new ArrayList<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<l.b> f17506b = new HashSet<>(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m.a f17507c = new m.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.a f17508d = new b.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public Looper f17509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public x1 f17510f;

    public void A() {
    }

    public final boolean B() {
        return !this.f17506b.isEmpty();
    }

    public abstract void C(@p0 z zVar);

    public final void D(x1 x1Var) {
        this.f17510f = x1Var;
        Iterator<l.b> it2 = this.f17505a.iterator();
        while (it2.hasNext()) {
            it2.next().b(this, x1Var);
        }
    }

    public abstract void E();

    @Override // com.google.android.exoplayer2.source.l
    public final void b(l.b bVar) {
        this.f17505a.remove(bVar);
        if (!this.f17505a.isEmpty()) {
            f(bVar);
            return;
        }
        this.f17509e = null;
        this.f17510f = null;
        this.f17506b.clear();
        E();
    }

    @Override // com.google.android.exoplayer2.source.l
    public final void d(Handler handler, m mVar) {
        hd.a.g(handler);
        hd.a.g(mVar);
        this.f17507c.g(handler, mVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public final void e(m mVar) {
        this.f17507c.C(mVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public final void f(l.b bVar) {
        boolean z10 = !this.f17506b.isEmpty();
        this.f17506b.remove(bVar);
        if (z10 && this.f17506b.isEmpty()) {
            z();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public /* synthetic */ Object h() {
        return ec.o.b(this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public final void k(Handler handler, com.google.android.exoplayer2.drm.b bVar) {
        hd.a.g(handler);
        hd.a.g(bVar);
        this.f17508d.g(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public final void m(com.google.android.exoplayer2.drm.b bVar) {
        this.f17508d.t(bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public /* synthetic */ boolean o() {
        return ec.o.c(this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public /* synthetic */ x1 q() {
        return ec.o.a(this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public final void r(l.b bVar) {
        hd.a.g(this.f17509e);
        boolean zIsEmpty = this.f17506b.isEmpty();
        this.f17506b.add(bVar);
        if (zIsEmpty) {
            A();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public final void s(l.b bVar, @p0 z zVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f17509e;
        hd.a.a(looper == null || looper == looperMyLooper);
        x1 x1Var = this.f17510f;
        this.f17505a.add(bVar);
        if (this.f17509e == null) {
            this.f17509e = looperMyLooper;
            this.f17506b.add(bVar);
            C(zVar);
        } else if (x1Var != null) {
            r(bVar);
            bVar.b(this, x1Var);
        }
    }

    public final b.a u(int i10, @p0 l.a aVar) {
        return this.f17508d.u(i10, aVar);
    }

    public final b.a v(@p0 l.a aVar) {
        return this.f17508d.u(0, aVar);
    }

    public final m.a w(int i10, @p0 l.a aVar, long j10) {
        return this.f17507c.F(i10, aVar, j10);
    }

    public final m.a x(@p0 l.a aVar) {
        return this.f17507c.F(0, aVar, 0L);
    }

    public final m.a y(l.a aVar, long j10) {
        hd.a.g(aVar);
        return this.f17507c.F(0, aVar, j10);
    }

    public void z() {
    }
}

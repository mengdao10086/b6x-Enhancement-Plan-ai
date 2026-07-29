package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.t;
import ed.z;
import g.p0;
import java.util.HashMap;
import java.util.Map;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends c<Void> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j f17767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f17768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<l.a, l.a> f17769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<k, l.a> f17770m;

    public static final class a extends ec.i {
        public a(x1 x1Var) {
            super(x1Var);
        }

        @Override // ec.i, ya.x1
        public int e(int i10, int i11, boolean z10) {
            int iE = this.f26836b.e(i10, i11, z10);
            return iE == -1 ? a(z10) : iE;
        }

        @Override // ec.i, ya.x1
        public int l(int i10, int i11, boolean z10) {
            int iL = this.f26836b.l(i10, i11, z10);
            return iL == -1 ? c(z10) : iL;
        }
    }

    public static final class b extends ya.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final x1 f17771e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f17772f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f17773g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f17774h;

        public b(x1 x1Var, int i10) {
            super(false, new t.b(i10));
            this.f17771e = x1Var;
            int i11 = x1Var.i();
            this.f17772f = i11;
            this.f17773g = x1Var.q();
            this.f17774h = i10;
            if (i11 > 0) {
                hd.a.j(i10 <= Integer.MAX_VALUE / i11, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // ya.a
        public int A(int i10) {
            return i10 * this.f17772f;
        }

        @Override // ya.a
        public int B(int i10) {
            return i10 * this.f17773g;
        }

        @Override // ya.a
        public x1 E(int i10) {
            return this.f17771e;
        }

        @Override // ya.x1
        public int i() {
            return this.f17772f * this.f17774h;
        }

        @Override // ya.x1
        public int q() {
            return this.f17773g * this.f17774h;
        }

        @Override // ya.a
        public int t(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // ya.a
        public int u(int i10) {
            return i10 / this.f17772f;
        }

        @Override // ya.a
        public int v(int i10) {
            return i10 / this.f17773g;
        }

        @Override // ya.a
        public Object y(int i10) {
            return Integer.valueOf(i10);
        }
    }

    public h(l lVar) {
        this(lVar, Integer.MAX_VALUE);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        super.C(zVar);
        N(null, this.f17767j);
    }

    @Override // com.google.android.exoplayer2.source.c
    @p0
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public l.a I(Void r22, l.a aVar) {
        return this.f17768k != Integer.MAX_VALUE ? this.f17769l.get(aVar) : aVar;
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void L(Void r12, l lVar, x1 x1Var) {
        D(this.f17768k != Integer.MAX_VALUE ? new b(x1Var, this.f17768k) : new a(x1Var));
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        if (this.f17768k == Integer.MAX_VALUE) {
            return this.f17767j.a(aVar, bVar, j10);
        }
        l.a aVarA = aVar.a(ya.a.w(aVar.f26856a));
        this.f17769l.put(aVarA, aVar);
        i iVarA = this.f17767j.a(aVarA, bVar, j10);
        this.f17770m.put(iVarA, aVarA);
        return iVarA;
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return this.f17767j.h();
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f17767j.j();
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    public boolean o() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        this.f17767j.p(kVar);
        l.a aVarRemove = this.f17770m.remove(kVar);
        if (aVarRemove != null) {
            this.f17769l.remove(aVarRemove);
        }
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    public x1 q() {
        return this.f17768k != Integer.MAX_VALUE ? new b(this.f17767j.T(), this.f17768k) : new a(this.f17767j.T());
    }

    public h(l lVar, int i10) {
        hd.a.a(i10 > 0);
        this.f17767j = new j(lVar, false);
        this.f17768k = i10;
        this.f17769l = new HashMap();
        this.f17770m = new HashMap();
    }
}

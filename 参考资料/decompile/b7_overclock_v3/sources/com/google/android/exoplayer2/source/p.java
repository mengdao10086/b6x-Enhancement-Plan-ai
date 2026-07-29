package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import ec.e0;
import ec.x;
import ed.z;
import g.p0;
import java.util.List;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends com.google.android.exoplayer2.source.a implements o.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f18223s = 1048576;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v0 f18224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v0.g f18225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a.InterfaceC0197a f18226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final hb.q f18227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f18228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f18229l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f18230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18231n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f18232o = ya.g.f56663b;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f18233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18234q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public z f18235r;

    public class a extends ec.i {
        public a(x1 x1Var) {
            super(x1Var);
        }

        @Override // ec.i, ya.x1
        public x1.c o(int i10, x1.c cVar, long j10) {
            super.o(i10, cVar, j10);
            cVar.f57251l = true;
            return cVar;
        }
    }

    public static final class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0197a f18237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public hb.q f18238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public gb.r f18240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.j f18241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f18242f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public String f18243g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public Object f18244h;

        public b(a.InterfaceC0197a interfaceC0197a) {
            this(interfaceC0197a, new hb.h());
        }

        public static /* synthetic */ com.google.android.exoplayer2.drm.c m(com.google.android.exoplayer2.drm.c cVar, v0 v0Var) {
            return cVar;
        }

        @Override // ec.x
        public /* synthetic */ x b(List list) {
            return ec.w.b(this, list);
        }

        @Override // ec.x
        public int[] e() {
            return new int[]{3};
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public p h(Uri uri) {
            return c(new v0.c().F(uri).a());
        }

        @Override // ec.x
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public p c(v0 v0Var) {
            hd.a.g(v0Var.f57132b);
            v0.g gVar = v0Var.f57132b;
            boolean z10 = gVar.f57190h == null && this.f18244h != null;
            boolean z11 = gVar.f57188f == null && this.f18243g != null;
            if (z10 && z11) {
                v0Var = v0Var.a().E(this.f18244h).j(this.f18243g).a();
            } else if (z10) {
                v0Var = v0Var.a().E(this.f18244h).a();
            } else if (z11) {
                v0Var = v0Var.a().j(this.f18243g).a();
            }
            v0 v0Var2 = v0Var;
            return new p(v0Var2, this.f18237a, this.f18238b, this.f18240d.a(v0Var2), this.f18241e, this.f18242f);
        }

        public b n(int i10) {
            this.f18242f = i10;
            return this;
        }

        @Deprecated
        public b o(@p0 String str) {
            this.f18243g = str;
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public b d(@p0 HttpDataSource.b bVar) {
            if (!this.f18239c) {
                ((com.google.android.exoplayer2.drm.a) this.f18240d).c(bVar);
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b g(@p0 final com.google.android.exoplayer2.drm.c cVar) {
            if (cVar == null) {
                f(null);
            } else {
                f(new gb.r() { // from class: ec.c0
                    @Override // gb.r
                    public final com.google.android.exoplayer2.drm.c a(v0 v0Var) {
                        return p.b.m(cVar, v0Var);
                    }
                });
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public b f(@p0 gb.r rVar) {
            if (rVar != null) {
                this.f18240d = rVar;
                this.f18239c = true;
            } else {
                this.f18240d = new com.google.android.exoplayer2.drm.a();
                this.f18239c = false;
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b a(@p0 String str) {
            if (!this.f18239c) {
                ((com.google.android.exoplayer2.drm.a) this.f18240d).d(str);
            }
            return this;
        }

        @Deprecated
        public b t(@p0 hb.q qVar) {
            if (qVar == null) {
                qVar = new hb.h();
            }
            this.f18238b = qVar;
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b i(@p0 com.google.android.exoplayer2.upstream.j jVar) {
            if (jVar == null) {
                jVar = new com.google.android.exoplayer2.upstream.g();
            }
            this.f18241e = jVar;
            return this;
        }

        @Deprecated
        public b v(@p0 Object obj) {
            this.f18244h = obj;
            return this;
        }

        public b(a.InterfaceC0197a interfaceC0197a, hb.q qVar) {
            this.f18237a = interfaceC0197a;
            this.f18238b = qVar;
            this.f18240d = new com.google.android.exoplayer2.drm.a();
            this.f18241e = new com.google.android.exoplayer2.upstream.g();
            this.f18242f = 1048576;
        }
    }

    public p(v0 v0Var, a.InterfaceC0197a interfaceC0197a, hb.q qVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.j jVar, int i10) {
        this.f18225h = (v0.g) hd.a.g(v0Var.f57132b);
        this.f18224g = v0Var;
        this.f18226i = interfaceC0197a;
        this.f18227j = qVar;
        this.f18228k = cVar;
        this.f18229l = jVar;
        this.f18230m = i10;
    }

    @Override // com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        this.f18235r = zVar;
        this.f18228k.f();
        F();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void E() {
        this.f18228k.release();
    }

    public final void F() {
        x1 e0Var = new e0(this.f18232o, this.f18233p, false, this.f18234q, (Object) null, this.f18224g);
        if (this.f18231n) {
            e0Var = new a(e0Var);
        }
        D(e0Var);
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        com.google.android.exoplayer2.upstream.a aVarA = this.f18226i.a();
        z zVar = this.f18235r;
        if (zVar != null) {
            aVarA.d(zVar);
        }
        return new o(this.f18225h.f57183a, aVarA, this.f18227j, this.f18228k, v(aVar), this.f18229l, x(aVar), this, bVar, this.f18225h.f57188f, this.f18230m);
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void g(long j10, boolean z10, boolean z11) {
        if (j10 == ya.g.f56663b) {
            j10 = this.f18232o;
        }
        if (!this.f18231n && this.f18232o == j10 && this.f18233p == z10 && this.f18234q == z11) {
            return;
        }
        this.f18232o = j10;
        this.f18233p = z10;
        this.f18234q = z11;
        this.f18231n = false;
        F();
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return this.f18225h.f57190h;
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f18224g;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void n() {
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        ((o) kVar).c0();
    }
}

package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import ec.x;
import ed.z;
import g.p0;
import java.io.IOException;
import java.util.List;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class f extends com.google.android.exoplayer2.source.c<Void> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Deprecated
    public static final int f17753k = 1048576;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p f17754j;

    @Deprecated
    public interface b {
        void a(IOException iOException);
    }

    @Deprecated
    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f17755a;

        public c(b bVar) {
            this.f17755a = (b) hd.a.g(bVar);
        }

        @Override // com.google.android.exoplayer2.source.m
        public void E(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10) {
            this.f17755a.a(iOException);
        }

        @Override // com.google.android.exoplayer2.source.m
        public /* synthetic */ void I(int i10, l.a aVar, ec.k kVar) {
            ec.p.a(this, i10, aVar, kVar);
        }

        @Override // com.google.android.exoplayer2.source.m
        public /* synthetic */ void J(int i10, l.a aVar, ec.j jVar, ec.k kVar) {
            ec.p.e(this, i10, aVar, jVar, kVar);
        }

        @Override // com.google.android.exoplayer2.source.m
        public /* synthetic */ void N(int i10, l.a aVar, ec.k kVar) {
            ec.p.f(this, i10, aVar, kVar);
        }

        @Override // com.google.android.exoplayer2.source.m
        public /* synthetic */ void U(int i10, l.a aVar, ec.j jVar, ec.k kVar) {
            ec.p.b(this, i10, aVar, jVar, kVar);
        }

        @Override // com.google.android.exoplayer2.source.m
        public /* synthetic */ void u(int i10, l.a aVar, ec.j jVar, ec.k kVar) {
            ec.p.c(this, i10, aVar, jVar, kVar);
        }
    }

    @Deprecated
    public static final class d implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0197a f17756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public hb.q f17757b = new hb.h();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.j f17758c = new com.google.android.exoplayer2.upstream.g();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17759d = 1048576;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public String f17760e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public Object f17761f;

        public d(a.InterfaceC0197a interfaceC0197a) {
            this.f17756a = interfaceC0197a;
        }

        @Override // ec.x
        @Deprecated
        public x a(@p0 String str) {
            throw new UnsupportedOperationException();
        }

        @Override // ec.x
        public /* synthetic */ x b(List list) {
            return ec.w.b(this, list);
        }

        @Override // ec.x
        @Deprecated
        public x d(@p0 HttpDataSource.b bVar) {
            throw new UnsupportedOperationException();
        }

        @Override // ec.x
        public int[] e() {
            return new int[]{3};
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public f h(Uri uri) {
            return c(new v0.c().F(uri).a());
        }

        @Override // ec.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public f c(v0 v0Var) {
            hd.a.g(v0Var.f57132b);
            v0.g gVar = v0Var.f57132b;
            Uri uri = gVar.f57183a;
            a.InterfaceC0197a interfaceC0197a = this.f17756a;
            hb.q qVar = this.f17757b;
            com.google.android.exoplayer2.upstream.j jVar = this.f17758c;
            String str = this.f17760e;
            int i10 = this.f17759d;
            Object obj = gVar.f57190h;
            if (obj == null) {
                obj = this.f17761f;
            }
            return new f(uri, interfaceC0197a, qVar, jVar, str, i10, obj);
        }

        public d l(int i10) {
            this.f17759d = i10;
            return this;
        }

        public d m(@p0 String str) {
            this.f17760e = str;
            return this;
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public d g(@p0 com.google.android.exoplayer2.drm.c cVar) {
            throw new UnsupportedOperationException();
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public d f(@p0 gb.r rVar) {
            throw new UnsupportedOperationException();
        }

        public d p(@p0 hb.q qVar) {
            if (qVar == null) {
                qVar = new hb.h();
            }
            this.f17757b = qVar;
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public d i(@p0 com.google.android.exoplayer2.upstream.j jVar) {
            if (jVar == null) {
                jVar = new com.google.android.exoplayer2.upstream.g();
            }
            this.f17758c = jVar;
            return this;
        }

        @Deprecated
        public d r(@p0 Object obj) {
            this.f17761f = obj;
            return this;
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        super.C(zVar);
        N(null, this.f17754j);
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void L(@p0 Void r12, l lVar, x1 x1Var) {
        D(x1Var);
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        return this.f17754j.a(aVar, bVar, j10);
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return this.f17754j.h();
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f17754j.j();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        this.f17754j.p(kVar);
    }

    @Deprecated
    public f(Uri uri, a.InterfaceC0197a interfaceC0197a, hb.q qVar, @p0 Handler handler, @p0 b bVar) {
        this(uri, interfaceC0197a, qVar, handler, bVar, null);
    }

    @Deprecated
    public f(Uri uri, a.InterfaceC0197a interfaceC0197a, hb.q qVar, @p0 Handler handler, @p0 b bVar, @p0 String str) {
        this(uri, interfaceC0197a, qVar, handler, bVar, str, 1048576);
    }

    @Deprecated
    public f(Uri uri, a.InterfaceC0197a interfaceC0197a, hb.q qVar, @p0 Handler handler, @p0 b bVar, @p0 String str, int i10) {
        this(uri, interfaceC0197a, qVar, new com.google.android.exoplayer2.upstream.g(), str, i10, (Object) null);
        if (bVar == null || handler == null) {
            return;
        }
        d(handler, new c(bVar));
    }

    public f(Uri uri, a.InterfaceC0197a interfaceC0197a, hb.q qVar, com.google.android.exoplayer2.upstream.j jVar, @p0 String str, int i10, @p0 Object obj) {
        this.f17754j = new p(new v0.c().F(uri).j(str).E(obj).a(), interfaceC0197a, qVar, com.google.android.exoplayer2.drm.c.f17057a, jVar, i10);
    }
}

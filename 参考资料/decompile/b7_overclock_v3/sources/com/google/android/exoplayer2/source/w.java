package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import ec.e0;
import ed.z;
import g.p0;
import hd.u0;
import java.util.Collections;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends com.google.android.exoplayer2.source.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f18483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a.InterfaceC0197a f18484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Format f18485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f18486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f18487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f18488l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final x1 f18489m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v0 f18490n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public z f18491o;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0197a f18492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.j f18493b = new com.google.android.exoplayer2.upstream.g();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18494c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public Object f18495d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public String f18496e;

        public b(a.InterfaceC0197a interfaceC0197a) {
            this.f18492a = (a.InterfaceC0197a) hd.a.g(interfaceC0197a);
        }

        @Deprecated
        public w a(Uri uri, Format format, long j10) {
            String str = format.f16687a;
            if (str == null) {
                str = this.f18496e;
            }
            return new w(str, new v0.h(uri, (String) hd.a.g(format.f16699l), format.f16689c, format.f16690d), this.f18492a, j10, this.f18493b, this.f18494c, this.f18495d);
        }

        public w b(v0.h hVar, long j10) {
            return new w(this.f18496e, hVar, this.f18492a, j10, this.f18493b, this.f18494c, this.f18495d);
        }

        public b c(@p0 com.google.android.exoplayer2.upstream.j jVar) {
            if (jVar == null) {
                jVar = new com.google.android.exoplayer2.upstream.g();
            }
            this.f18493b = jVar;
            return this;
        }

        public b d(@p0 Object obj) {
            this.f18495d = obj;
            return this;
        }

        public b e(@p0 String str) {
            this.f18496e = str;
            return this;
        }

        public b f(boolean z10) {
            this.f18494c = z10;
            return this;
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        this.f18491o = zVar;
        D(this.f18489m);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void E() {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        return new v(this.f18483g, this.f18484h, this.f18491o, this.f18485i, this.f18486j, this.f18487k, x(aVar), this.f18488l);
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return ((v0.g) u0.k(this.f18490n.f57132b)).f57190h;
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f18490n;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void n() {
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        ((v) kVar).o();
    }

    public w(@p0 String str, v0.h hVar, a.InterfaceC0197a interfaceC0197a, long j10, com.google.android.exoplayer2.upstream.j jVar, boolean z10, @p0 Object obj) {
        this.f18484h = interfaceC0197a;
        this.f18486j = j10;
        this.f18487k = jVar;
        this.f18488l = z10;
        v0 v0VarA = new v0.c().F(Uri.EMPTY).z(hVar.f57191a.toString()).D(Collections.singletonList(hVar)).E(obj).a();
        this.f18490n = v0VarA;
        this.f18485i = new Format.b().S(str).e0(hVar.f57192b).V(hVar.f57193c).g0(hVar.f57194d).c0(hVar.f57195e).U(hVar.f57196f).E();
        this.f18483g = new b.C0198b().j(hVar.f57191a).c(1).a();
        this.f18489m = new e0(j10, true, false, false, (Object) null, v0VarA);
    }
}

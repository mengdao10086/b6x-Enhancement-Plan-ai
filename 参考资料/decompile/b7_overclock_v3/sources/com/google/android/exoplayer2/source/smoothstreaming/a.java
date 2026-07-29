package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.a;
import ed.u;
import ed.z;
import g.p0;
import gc.d;
import gc.e;
import gc.f;
import gc.j;
import gc.m;
import gc.n;
import java.io.IOException;
import java.util.List;
import ob.g;
import ob.o;
import ob.p;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public class a implements com.google.android.exoplayer2.source.smoothstreaming.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f18314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f[] f18316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f18317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.android.exoplayer2.trackselection.b f18318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f18319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public IOException f18321h;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a, reason: collision with other inner class name */
    public static final class C0191a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0197a f18322a;

        public C0191a(a.InterfaceC0197a interfaceC0197a) {
            this.f18322a = interfaceC0197a;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public com.google.android.exoplayer2.source.smoothstreaming.b a(u uVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i10, com.google.android.exoplayer2.trackselection.b bVar, @p0 z zVar) {
            com.google.android.exoplayer2.upstream.a aVarA = this.f18322a.a();
            if (zVar != null) {
                aVarA.d(zVar);
            }
            return new a(uVar, aVar, i10, bVar, aVarA);
        }
    }

    public static final class b extends gc.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a.b f18323e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f18324f;

        public b(a.b bVar, int i10, int i11) {
            super(i11, bVar.f18430k - 1);
            this.f18323e = bVar;
            this.f18324f = i10;
        }

        @Override // gc.n
        public long a() {
            e();
            return this.f18323e.e((int) f());
        }

        @Override // gc.n
        public com.google.android.exoplayer2.upstream.b c() {
            e();
            return new com.google.android.exoplayer2.upstream.b(this.f18323e.a(this.f18324f, (int) f()));
        }

        @Override // gc.n
        public long d() {
            return a() + this.f18323e.c((int) f());
        }
    }

    public a(u uVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i10, com.google.android.exoplayer2.trackselection.b bVar, com.google.android.exoplayer2.upstream.a aVar2) {
        this.f18314a = uVar;
        this.f18319f = aVar;
        this.f18315b = i10;
        this.f18318e = bVar;
        this.f18317d = aVar2;
        a.b bVar2 = aVar.f18410f[i10];
        this.f18316c = new f[bVar.length()];
        int i11 = 0;
        while (i11 < this.f18316c.length) {
            int iC = bVar.c(i11);
            Format format = bVar2.f18429j[iC];
            p[] pVarArr = format.f16702o != null ? ((a.C0192a) hd.a.g(aVar.f18409e)).f18415c : null;
            int i12 = bVar2.f18420a;
            int i13 = i11;
            this.f18316c[i13] = new d(new g(3, null, new o(iC, i12, bVar2.f18422c, ya.g.f56663b, aVar.f18411g, format, 0, pVarArr, i12 == 2 ? 4 : 0, null, null)), bVar2.f18420a, format);
            i11 = i13 + 1;
        }
    }

    public static m k(Format format, com.google.android.exoplayer2.upstream.a aVar, Uri uri, int i10, long j10, long j11, long j12, int i11, @p0 Object obj, f fVar) {
        return new j(aVar, new com.google.android.exoplayer2.upstream.b(uri), format, i11, obj, j10, j11, j12, ya.g.f56663b, i10, 1, j10, fVar);
    }

    @Override // gc.i
    public void a() throws IOException {
        IOException iOException = this.f18321h;
        if (iOException != null) {
            throw iOException;
        }
        this.f18314a.a();
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void b(com.google.android.exoplayer2.trackselection.b bVar) {
        this.f18318e = bVar;
    }

    @Override // gc.i
    public long c(long j10, t1 t1Var) {
        a.b bVar = this.f18319f.f18410f[this.f18315b];
        int iD = bVar.d(j10);
        long jE = bVar.e(iD);
        return t1Var.a(j10, jE, (jE >= j10 || iD >= bVar.f18430k + (-1)) ? jE : bVar.e(iD + 1));
    }

    @Override // gc.i
    public void d(e eVar) {
    }

    @Override // gc.i
    public boolean e(long j10, e eVar, List<? extends m> list) {
        if (this.f18321h != null) {
            return false;
        }
        return this.f18318e.h(j10, eVar, list);
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void f(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b[] bVarArr = this.f18319f.f18410f;
        int i10 = this.f18315b;
        a.b bVar = bVarArr[i10];
        int i11 = bVar.f18430k;
        a.b bVar2 = aVar.f18410f[i10];
        if (i11 == 0 || bVar2.f18430k == 0) {
            this.f18320g += i11;
        } else {
            int i12 = i11 - 1;
            long jE = bVar.e(i12) + bVar.c(i12);
            long jE2 = bVar2.e(0);
            if (jE <= jE2) {
                this.f18320g += i11;
            } else {
                this.f18320g += bVar.d(jE2);
            }
        }
        this.f18319f = aVar;
    }

    @Override // gc.i
    public boolean h(e eVar, boolean z10, Exception exc, long j10) {
        if (z10 && j10 != ya.g.f56663b) {
            com.google.android.exoplayer2.trackselection.b bVar = this.f18318e;
            if (bVar.j(bVar.d(eVar.f29166d), j10)) {
                return true;
            }
        }
        return false;
    }

    @Override // gc.i
    public int i(long j10, List<? extends m> list) {
        return (this.f18321h != null || this.f18318e.length() < 2) ? list.size() : this.f18318e.n(j10, list);
    }

    @Override // gc.i
    public final void j(long j10, long j11, List<? extends m> list, gc.g gVar) {
        int iG;
        long j12 = j11;
        if (this.f18321h != null) {
            return;
        }
        a.b bVar = this.f18319f.f18410f[this.f18315b];
        if (bVar.f18430k == 0) {
            gVar.f29173b = !r4.f18408d;
            return;
        }
        if (list.isEmpty()) {
            iG = bVar.d(j12);
        } else {
            iG = (int) (list.get(list.size() - 1).g() - ((long) this.f18320g));
            if (iG < 0) {
                this.f18321h = new BehindLiveWindowException();
                return;
            }
        }
        if (iG >= bVar.f18430k) {
            gVar.f29173b = !this.f18319f.f18408d;
            return;
        }
        long j13 = j12 - j10;
        long jL = l(j10);
        int length = this.f18318e.length();
        n[] nVarArr = new n[length];
        for (int i10 = 0; i10 < length; i10++) {
            nVarArr[i10] = new b(bVar, this.f18318e.c(i10), iG);
        }
        this.f18318e.m(j10, j13, jL, list, nVarArr);
        long jE = bVar.e(iG);
        long jC = jE + bVar.c(iG);
        if (!list.isEmpty()) {
            j12 = ya.g.f56663b;
        }
        long j14 = j12;
        int i11 = iG + this.f18320g;
        int i12 = this.f18318e.i();
        gVar.f29172a = k(this.f18318e.p(), this.f18317d, bVar.a(this.f18318e.c(i12), iG), i11, jE, jC, j14, this.f18318e.q(), this.f18318e.s(), this.f18316c[i12]);
    }

    public final long l(long j10) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f18319f;
        if (!aVar.f18408d) {
            return ya.g.f56663b;
        }
        a.b bVar = aVar.f18410f[this.f18315b];
        int i10 = bVar.f18430k - 1;
        return (bVar.e(i10) + bVar.c(i10)) - j10;
    }

    @Override // gc.i
    public void release() {
        for (f fVar : this.f18316c) {
            fVar.release();
        }
    }
}

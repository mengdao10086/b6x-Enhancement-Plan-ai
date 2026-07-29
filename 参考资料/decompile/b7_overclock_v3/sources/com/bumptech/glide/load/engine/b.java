package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import g.n0;
import h4.n;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements e, d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c4.b> f12279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f<?> f12280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e.a f12281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c4.b f12283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<h4.n<File, ?>> f12284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile n.a<?> f12286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f12287i;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (b() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.f12284f;
        r3 = r7.f12285g;
        r7.f12285g = r3 + 1;
        r7.f12286h = r0.get(r3).a(r7.f12287i, r7.f12280b.t(), r7.f12280b.f(), r7.f12280b.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.f12286h == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.f12280b.u(r7.f12286h.f30488c.a()) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.f12286h.f30488c.f(r7.f12280b.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.f12286h = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r1 != false) goto L39;
     */
    @Override // com.bumptech.glide.load.engine.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            w4.b.a(r0)
        L5:
            java.util.List<h4.n<java.io.File, ?>> r0 = r7.f12284f     // Catch: java.lang.Throwable -> Lae
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L6c
            boolean r0 = r7.b()     // Catch: java.lang.Throwable -> Lae
            if (r0 != 0) goto L12
            goto L6c
        L12:
            r0 = 0
            r7.f12286h = r0     // Catch: java.lang.Throwable -> Lae
        L15:
            if (r1 != 0) goto L68
            boolean r0 = r7.b()     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto L68
            java.util.List<h4.n<java.io.File, ?>> r0 = r7.f12284f     // Catch: java.lang.Throwable -> Lae
            int r3 = r7.f12285g     // Catch: java.lang.Throwable -> Lae
            int r4 = r3 + 1
            r7.f12285g = r4     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lae
            h4.n r0 = (h4.n) r0     // Catch: java.lang.Throwable -> Lae
            java.io.File r3 = r7.f12287i     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.engine.f<?> r4 = r7.f12280b     // Catch: java.lang.Throwable -> Lae
            int r4 = r4.t()     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.engine.f<?> r5 = r7.f12280b     // Catch: java.lang.Throwable -> Lae
            int r5 = r5.f()     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.engine.f<?> r6 = r7.f12280b     // Catch: java.lang.Throwable -> Lae
            c4.e r6 = r6.k()     // Catch: java.lang.Throwable -> Lae
            h4.n$a r0 = r0.a(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lae
            r7.f12286h = r0     // Catch: java.lang.Throwable -> Lae
            h4.n$a<?> r0 = r7.f12286h     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto L15
            com.bumptech.glide.load.engine.f<?> r0 = r7.f12280b     // Catch: java.lang.Throwable -> Lae
            h4.n$a<?> r3 = r7.f12286h     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.data.d<Data> r3 = r3.f30488c     // Catch: java.lang.Throwable -> Lae
            java.lang.Class r3 = r3.a()     // Catch: java.lang.Throwable -> Lae
            boolean r0 = r0.u(r3)     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto L15
            h4.n$a<?> r0 = r7.f12286h     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.data.d<Data> r0 = r0.f30488c     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.engine.f<?> r1 = r7.f12280b     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.Priority r1 = r1.l()     // Catch: java.lang.Throwable -> Lae
            r0.f(r1, r7)     // Catch: java.lang.Throwable -> Lae
            r1 = 1
            goto L15
        L68:
            w4.b.f()
            return r1
        L6c:
            int r0 = r7.f12282d     // Catch: java.lang.Throwable -> Lae
            int r0 = r0 + r2
            r7.f12282d = r0     // Catch: java.lang.Throwable -> Lae
            java.util.List<c4.b> r2 = r7.f12279a     // Catch: java.lang.Throwable -> Lae
            int r2 = r2.size()     // Catch: java.lang.Throwable -> Lae
            if (r0 < r2) goto L7d
            w4.b.f()
            return r1
        L7d:
            java.util.List<c4.b> r0 = r7.f12279a     // Catch: java.lang.Throwable -> Lae
            int r2 = r7.f12282d     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> Lae
            c4.b r0 = (c4.b) r0     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.engine.c r2 = new com.bumptech.glide.load.engine.c     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.engine.f<?> r3 = r7.f12280b     // Catch: java.lang.Throwable -> Lae
            c4.b r3 = r3.p()     // Catch: java.lang.Throwable -> Lae
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.engine.f<?> r3 = r7.f12280b     // Catch: java.lang.Throwable -> Lae
            e4.a r3 = r3.d()     // Catch: java.lang.Throwable -> Lae
            java.io.File r2 = r3.a(r2)     // Catch: java.lang.Throwable -> Lae
            r7.f12287i = r2     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto L5
            r7.f12283e = r0     // Catch: java.lang.Throwable -> Lae
            com.bumptech.glide.load.engine.f<?> r0 = r7.f12280b     // Catch: java.lang.Throwable -> Lae
            java.util.List r0 = r0.j(r2)     // Catch: java.lang.Throwable -> Lae
            r7.f12284f = r0     // Catch: java.lang.Throwable -> Lae
            r7.f12285g = r1     // Catch: java.lang.Throwable -> Lae
            goto L5
        Lae:
            r0 = move-exception
            w4.b.f()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.b.a():boolean");
    }

    public final boolean b() {
        return this.f12285g < this.f12284f.size();
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@n0 Exception exc) {
        this.f12281c.c(this.f12283e, exc, this.f12286h.f30488c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.e
    public void cancel() {
        n.a<?> aVar = this.f12286h;
        if (aVar != null) {
            aVar.f30488c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void d(Object obj) {
        this.f12281c.e(this.f12283e, obj, this.f12286h.f30488c, DataSource.DATA_DISK_CACHE, this.f12283e);
    }

    public b(List<c4.b> list, f<?> fVar, e.a aVar) {
        this.f12282d = -1;
        this.f12279a = list;
        this.f12280b = fVar;
        this.f12281c = aVar;
    }
}

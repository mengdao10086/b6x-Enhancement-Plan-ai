package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import fd.i;
import fd.j;
import fd.k;
import fd.l;
import fd.m;
import fd.r;
import g.j1;
import g.p0;
import hd.t;
import hd.u0;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Cache {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f19203m = "SimpleCache";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f19204n = 10;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f19205o = ".uid";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashSet<File> f19206p = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f19207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f19208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f19209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final fd.c f19210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, ArrayList<Cache.a>> f19211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Random f19212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f19214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f19215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Cache.CacheException f19217l;

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f19218a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f19218a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (e.this) {
                this.f19218a.open();
                e.this.A();
                e.this.f19208c.d();
            }
        }
    }

    @Deprecated
    public e(File file, c cVar) {
        this(file, cVar, (byte[]) null, false);
    }

    public static synchronized boolean B(File file) {
        return f19206p.contains(file.getAbsoluteFile());
    }

    public static long D(File[] fileArr) {
        int length = fileArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            File file = fileArr[i10];
            String name = file.getName();
            if (name.endsWith(f19205o)) {
                try {
                    return I(name);
                } catch (NumberFormatException unused) {
                    t.d(f19203m, "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean E(File file) {
        return f19206p.add(file.getAbsoluteFile());
    }

    public static long I(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public static synchronized void M(File file) {
        f19206p.remove(file.getAbsoluteFile());
    }

    public static void w(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        t.d(f19203m, str);
        throw new Cache.CacheException(str);
    }

    public static long x(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + f19205o);
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    @j1
    public static void y(File file, @p0 db.a aVar) {
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                file.delete();
                return;
            }
            if (aVar != null) {
                long jD = D(fileArrListFiles);
                if (jD != -1) {
                    try {
                        fd.c.a(aVar, jD);
                    } catch (DatabaseIOException unused) {
                        t.n(f19203m, "Failed to delete file metadata: " + jD);
                    }
                    try {
                        j.g(aVar, jD);
                    } catch (DatabaseIOException unused2) {
                        t.n(f19203m, "Failed to delete file metadata: " + jD);
                    }
                }
            }
            u0.e1(file);
        }
    }

    public final void A() {
        if (!this.f19207b.exists()) {
            try {
                w(this.f19207b);
            } catch (Cache.CacheException e10) {
                this.f19217l = e10;
                return;
            }
        }
        File[] fileArrListFiles = this.f19207b.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.f19207b;
            t.d(f19203m, str);
            this.f19217l = new Cache.CacheException(str);
            return;
        }
        long jD = D(fileArrListFiles);
        this.f19214i = jD;
        if (jD == -1) {
            try {
                this.f19214i = x(this.f19207b);
            } catch (IOException e11) {
                String str2 = "Failed to create cache UID: " + this.f19207b;
                t.e(f19203m, str2, e11);
                this.f19217l = new Cache.CacheException(str2, e11);
                return;
            }
        }
        try {
            this.f19209d.p(this.f19214i);
            fd.c cVar = this.f19210e;
            if (cVar != null) {
                cVar.f(this.f19214i);
                Map<String, fd.b> mapC = this.f19210e.c();
                C(this.f19207b, true, fileArrListFiles, mapC);
                this.f19210e.h(mapC.keySet());
            } else {
                C(this.f19207b, true, fileArrListFiles, null);
            }
            this.f19209d.t();
            try {
                this.f19209d.u();
            } catch (IOException e12) {
                t.e(f19203m, "Storing index file failed", e12);
            }
        } catch (IOException e13) {
            String str3 = "Failed to initialize cache indices: " + this.f19207b;
            t.e(f19203m, str3, e13);
            this.f19217l = new Cache.CacheException(str3, e13);
        }
    }

    public final void C(File file, boolean z10, @p0 File[] fileArr, @p0 Map<String, fd.b> map) {
        if (fileArr == null || fileArr.length == 0) {
            if (z10) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z10 && name.indexOf(46) == -1) {
                C(file2, false, file2.listFiles(), map);
            } else if (!z10 || (!j.q(name) && !name.endsWith(f19205o))) {
                long j10 = -1;
                long j11 = g.f56663b;
                fd.b bVarRemove = map != null ? map.remove(name) : null;
                if (bVarRemove != null) {
                    j10 = bVarRemove.f28037a;
                    j11 = bVarRemove.f28038b;
                }
                r rVarG = r.g(file2, j10, j11, this.f19209d);
                if (rVarG != null) {
                    u(rVarG);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final void F(r rVar) {
        ArrayList<Cache.a> arrayList = this.f19211f.get(rVar.f28054a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).b(this, rVar);
            }
        }
        this.f19208c.b(this, rVar);
    }

    public final void G(fd.g gVar) {
        ArrayList<Cache.a> arrayList = this.f19211f.get(gVar.f28054a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).c(this, gVar);
            }
        }
        this.f19208c.c(this, gVar);
    }

    public final void H(r rVar, fd.g gVar) {
        ArrayList<Cache.a> arrayList = this.f19211f.get(rVar.f28054a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).f(this, rVar, gVar);
            }
        }
        this.f19208c.f(this, rVar, gVar);
    }

    public final void J(fd.g gVar) {
        i iVarH = this.f19209d.h(gVar.f28054a);
        if (iVarH == null || !iVarH.k(gVar)) {
            return;
        }
        this.f19215j -= gVar.f28056c;
        if (this.f19210e != null) {
            String name = gVar.f28058e.getName();
            try {
                this.f19210e.g(name);
            } catch (IOException unused) {
                t.n(f19203m, "Failed to remove file index entry for: " + name);
            }
        }
        this.f19209d.r(iVarH.f28075b);
        G(gVar);
    }

    public final void K() {
        ArrayList arrayList = new ArrayList();
        Iterator<i> it2 = this.f19209d.i().iterator();
        while (it2.hasNext()) {
            for (r rVar : it2.next().f()) {
                if (rVar.f28058e.length() != rVar.f28056c) {
                    arrayList.add(rVar);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            J((fd.g) arrayList.get(i10));
        }
    }

    public final r L(String str, r rVar) {
        if (!this.f19213h) {
            return rVar;
        }
        String name = ((File) hd.a.g(rVar.f28058e)).getName();
        long j10 = rVar.f28056c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = false;
        fd.c cVar = this.f19210e;
        if (cVar != null) {
            try {
                cVar.i(name, j10, jCurrentTimeMillis);
            } catch (IOException unused) {
                t.n(f19203m, "Failed to update index with new touch timestamp.");
            }
        } else {
            z10 = true;
        }
        r rVarL = this.f19209d.h(str).l(rVar, jCurrentTimeMillis, z10);
        H(rVar, rVarL);
        return rVarL;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long a() {
        return this.f19214i;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File b(String str, long j10, long j11) throws Cache.CacheException {
        i iVarH;
        File file;
        hd.a.i(!this.f19216k);
        v();
        iVarH = this.f19209d.h(str);
        hd.a.g(iVarH);
        hd.a.i(iVarH.h(j10, j11));
        if (!this.f19207b.exists()) {
            w(this.f19207b);
            K();
        }
        this.f19208c.a(this, str, j10, j11);
        file = new File(this.f19207b, Integer.toString(this.f19212g.nextInt(10)));
        if (!file.exists()) {
            w(file);
        }
        return r.k(file, iVarH.f28074a, j10, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void c(fd.g gVar) {
        hd.a.i(!this.f19216k);
        J(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized l d(String str) {
        hd.a.i(!this.f19216k);
        return this.f19209d.k(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long e(String str, long j10, long j11) {
        long j12;
        long j13 = j11 == -1 ? Long.MAX_VALUE : j11 + j10;
        long j14 = j13 >= 0 ? j13 : Long.MAX_VALUE;
        j12 = 0;
        while (j10 < j14) {
            long jG = g(str, j10, j14 - j10);
            if (jG > 0) {
                j12 += jG;
            } else {
                jG = -jG;
            }
            j10 += jG;
        }
        return j12;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @p0
    public synchronized fd.g f(String str, long j10, long j11) throws Cache.CacheException {
        hd.a.i(!this.f19216k);
        v();
        r rVarZ = z(str, j10, j11);
        if (rVarZ.f28057d) {
            return L(str, rVarZ);
        }
        if (this.f19209d.o(str).j(j10, rVarZ.f28056c)) {
            return rVarZ;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long g(String str, long j10, long j11) {
        i iVarH;
        hd.a.i(!this.f19216k);
        if (j11 == -1) {
            j11 = Long.MAX_VALUE;
        }
        iVarH = this.f19209d.h(str);
        return iVarH != null ? iVarH.c(j10, j11) : -j11;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized fd.g h(String str, long j10, long j11) throws InterruptedException, Cache.CacheException {
        fd.g gVarF;
        hd.a.i(!this.f19216k);
        v();
        while (true) {
            gVarF = f(str, j10, j11);
            if (gVarF == null) {
                wait();
            }
        }
        return gVarF;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized Set<String> i() {
        hd.a.i(!this.f19216k);
        return new HashSet(this.f19209d.m());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void j(File file, long j10) throws Cache.CacheException {
        boolean z10 = true;
        hd.a.i(!this.f19216k);
        if (file.exists()) {
            if (j10 == 0) {
                file.delete();
                return;
            }
            r rVar = (r) hd.a.g(r.h(file, j10, this.f19209d));
            i iVar = (i) hd.a.g(this.f19209d.h(rVar.f28054a));
            hd.a.i(iVar.h(rVar.f28055b, rVar.f28056c));
            long jA = k.a(iVar.d());
            if (jA != -1) {
                if (rVar.f28055b + rVar.f28056c > jA) {
                    z10 = false;
                }
                hd.a.i(z10);
            }
            if (this.f19210e == null) {
                u(rVar);
                this.f19209d.u();
                notifyAll();
                return;
            }
            try {
                this.f19210e.i(file.getName(), rVar.f28056c, rVar.f28059f);
                u(rVar);
                try {
                    this.f19209d.u();
                    notifyAll();
                    return;
                } catch (IOException e10) {
                    throw new Cache.CacheException(e10);
                }
            } catch (IOException e11) {
                throw new Cache.CacheException(e11);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void k(String str) {
        hd.a.i(!this.f19216k);
        Iterator<fd.g> it2 = q(str).iterator();
        while (it2.hasNext()) {
            J(it2.next());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void l(String str, m mVar) throws Cache.CacheException {
        hd.a.i(!this.f19216k);
        v();
        this.f19209d.e(str, mVar);
        try {
            this.f19209d.u();
        } catch (IOException e10) {
            throw new Cache.CacheException(e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long m() {
        hd.a.i(!this.f19216k);
        return this.f19215j;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void n(fd.g gVar) {
        hd.a.i(!this.f19216k);
        i iVar = (i) hd.a.g(this.f19209d.h(gVar.f28054a));
        iVar.m(gVar.f28055b);
        this.f19209d.r(iVar.f28075b);
        notifyAll();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean o(java.lang.String r4, long r5, long r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f19216k     // Catch: java.lang.Throwable -> L21
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L9
            r0 = 1
            goto La
        L9:
            r0 = 0
        La:
            hd.a.i(r0)     // Catch: java.lang.Throwable -> L21
            fd.j r0 = r3.f19209d     // Catch: java.lang.Throwable -> L21
            fd.i r4 = r0.h(r4)     // Catch: java.lang.Throwable -> L21
            if (r4 == 0) goto L1e
            long r4 = r4.c(r5, r7)     // Catch: java.lang.Throwable -> L21
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 < 0) goto L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            monitor-exit(r3)
            return r1
        L21:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.e.o(java.lang.String, long, long):boolean");
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<fd.g> p(String str, Cache.a aVar) {
        hd.a.i(!this.f19216k);
        hd.a.g(str);
        hd.a.g(aVar);
        ArrayList<Cache.a> arrayList = this.f19211f.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f19211f.put(str, arrayList);
        }
        arrayList.add(aVar);
        return q(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<fd.g> q(String str) {
        i iVarH;
        hd.a.i(!this.f19216k);
        iVarH = this.f19209d.h(str);
        return (iVarH == null || iVarH.g()) ? new TreeSet() : new TreeSet((Collection) iVarH.f());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void r(String str, Cache.a aVar) {
        if (this.f19216k) {
            return;
        }
        ArrayList<Cache.a> arrayList = this.f19211f.get(str);
        if (arrayList != null) {
            arrayList.remove(aVar);
            if (arrayList.isEmpty()) {
                this.f19211f.remove(str);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void release() {
        if (this.f19216k) {
            return;
        }
        this.f19211f.clear();
        K();
        try {
            try {
                this.f19209d.u();
                M(this.f19207b);
            } catch (IOException e10) {
                t.e(f19203m, "Storing index file failed", e10);
                M(this.f19207b);
            }
            this.f19216k = true;
        } catch (Throwable th2) {
            M(this.f19207b);
            this.f19216k = true;
            throw th2;
        }
    }

    public final void u(r rVar) {
        this.f19209d.o(rVar.f28054a).a(rVar);
        this.f19215j += rVar.f28056c;
        F(rVar);
    }

    public synchronized void v() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f19217l;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public final r z(String str, long j10, long j11) {
        r rVarE;
        i iVarH = this.f19209d.h(str);
        if (iVarH == null) {
            return r.i(str, j10, j11);
        }
        while (true) {
            rVarE = iVarH.e(j10, j11);
            if (!rVarE.f28057d || rVarE.f28058e.length() == rVarE.f28056c) {
                break;
            }
            K();
        }
        return rVarE;
    }

    @Deprecated
    public e(File file, c cVar, @p0 byte[] bArr) {
        this(file, cVar, bArr, bArr != null);
    }

    @Deprecated
    public e(File file, c cVar, @p0 byte[] bArr, boolean z10) {
        this(file, cVar, null, bArr, z10, true);
    }

    public e(File file, c cVar, db.a aVar) {
        this(file, cVar, aVar, null, false, false);
    }

    public e(File file, c cVar, @p0 db.a aVar, @p0 byte[] bArr, boolean z10, boolean z11) {
        this(file, cVar, new j(aVar, file, bArr, z10, z11), (aVar == null || z11) ? null : new fd.c(aVar));
    }

    public e(File file, c cVar, j jVar, @p0 fd.c cVar2) {
        if (E(file)) {
            this.f19207b = file;
            this.f19208c = cVar;
            this.f19209d = jVar;
            this.f19210e = cVar2;
            this.f19211f = new HashMap<>();
            this.f19212g = new Random();
            this.f19213h = cVar.e();
            this.f19214i = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}

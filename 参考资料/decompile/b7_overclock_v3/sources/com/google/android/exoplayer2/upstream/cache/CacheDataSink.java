package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import ed.j;
import g.p0;
import hd.f0;
import hd.t;
import hd.u0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheDataSink implements j {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f19133k = 5242880;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f19134l = 20480;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f19135m = 2097152;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f19136n = "CacheDataSink";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f19137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f19138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.upstream.b f19140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public File f19142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public OutputStream f19143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f19144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f19145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f0 f19146j;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public static final class a implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cache f19147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19148b = CacheDataSink.f19133k;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19149c = CacheDataSink.f19134l;

        @Override // ed.j.a
        public j a() {
            return new CacheDataSink((Cache) hd.a.g(this.f19147a), this.f19148b, this.f19149c);
        }

        public a b(int i10) {
            this.f19149c = i10;
            return this;
        }

        public a c(Cache cache) {
            this.f19147a = cache;
            return this;
        }

        public a d(long j10) {
            this.f19148b = j10;
            return this;
        }
    }

    public CacheDataSink(Cache cache, long j10) {
        this(cache, j10, f19134l);
    }

    @Override // ed.j
    public void a(com.google.android.exoplayer2.upstream.b bVar) throws CacheDataSinkException {
        hd.a.g(bVar.f19100i);
        if (bVar.f19099h == -1 && bVar.d(2)) {
            this.f19140d = null;
            return;
        }
        this.f19140d = bVar;
        this.f19141e = bVar.d(4) ? this.f19138b : Long.MAX_VALUE;
        this.f19145i = 0L;
        try {
            c(bVar);
        } catch (IOException e10) {
            throw new CacheDataSinkException(e10);
        }
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.f19143g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            u0.q(this.f19143g);
            this.f19143g = null;
            File file = (File) u0.k(this.f19142f);
            this.f19142f = null;
            this.f19137a.j(file, this.f19144h);
        } catch (Throwable th2) {
            u0.q(this.f19143g);
            this.f19143g = null;
            File file2 = (File) u0.k(this.f19142f);
            this.f19142f = null;
            file2.delete();
            throw th2;
        }
    }

    public final void c(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        long j10 = bVar.f19099h;
        this.f19142f = this.f19137a.b((String) u0.k(bVar.f19100i), bVar.f19098g + this.f19145i, j10 != -1 ? Math.min(j10 - this.f19145i, this.f19141e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f19142f);
        if (this.f19139c > 0) {
            f0 f0Var = this.f19146j;
            if (f0Var == null) {
                this.f19146j = new f0(fileOutputStream, this.f19139c);
            } else {
                f0Var.a(fileOutputStream);
            }
            this.f19143g = this.f19146j;
        } else {
            this.f19143g = fileOutputStream;
        }
        this.f19144h = 0L;
    }

    @Override // ed.j
    public void close() throws CacheDataSinkException {
        if (this.f19140d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e10) {
            throw new CacheDataSinkException(e10);
        }
    }

    @Override // ed.j
    public void write(byte[] bArr, int i10, int i11) throws CacheDataSinkException {
        com.google.android.exoplayer2.upstream.b bVar = this.f19140d;
        if (bVar == null) {
            return;
        }
        int i12 = 0;
        while (i12 < i11) {
            try {
                if (this.f19144h == this.f19141e) {
                    b();
                    c(bVar);
                }
                int iMin = (int) Math.min(i11 - i12, this.f19141e - this.f19144h);
                ((OutputStream) u0.k(this.f19143g)).write(bArr, i10 + i12, iMin);
                i12 += iMin;
                long j10 = iMin;
                this.f19144h += j10;
                this.f19145i += j10;
            } catch (IOException e10) {
                throw new CacheDataSinkException(e10);
            }
        }
    }

    public CacheDataSink(Cache cache, long j10, int i10) {
        hd.a.j(j10 > 0 || j10 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j10 != -1 && j10 < 2097152) {
            t.n(f19136n, "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f19137a = (Cache) hd.a.g(cache);
        this.f19138b = j10 == -1 ? Long.MAX_VALUE : j10;
        this.f19139c = i10;
    }
}

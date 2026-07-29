package fd;

import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import g.j1;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f28060m = 131072;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.cache.a f28061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cache f28062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f28063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f28064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f28065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f28066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final a f28067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f28068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f28069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f28070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f28071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f28072l;

    public interface a {
        void a(long j10, long j11, long j12);
    }

    public h(com.google.android.exoplayer2.upstream.cache.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10, @p0 byte[] bArr, @p0 a aVar2) {
        this.f28061a = aVar;
        this.f28062b = aVar.v();
        this.f28063c = bVar;
        this.f28064d = z10;
        this.f28066f = bArr == null ? new byte[131072] : bArr;
        this.f28067g = aVar2;
        this.f28065e = aVar.w().a(bVar);
        this.f28069i = bVar.f19098g;
    }

    @j1
    public void a() throws IOException {
        g();
        if (!this.f28068h) {
            com.google.android.exoplayer2.upstream.b bVar = this.f28063c;
            long j10 = bVar.f19099h;
            if (j10 != -1) {
                this.f28070j = bVar.f19098g + j10;
            } else {
                long jA = k.a(this.f28062b.d(this.f28065e));
                if (jA == -1) {
                    jA = -1;
                }
                this.f28070j = jA;
            }
            Cache cache = this.f28062b;
            String str = this.f28065e;
            com.google.android.exoplayer2.upstream.b bVar2 = this.f28063c;
            this.f28071k = cache.e(str, bVar2.f19098g, bVar2.f19099h);
            a aVar = this.f28067g;
            if (aVar != null) {
                aVar.a(c(), this.f28071k, 0L);
            }
            this.f28068h = true;
        }
        while (true) {
            long j11 = this.f28070j;
            if (j11 != -1 && this.f28069i >= j11) {
                return;
            }
            g();
            long j12 = this.f28070j;
            long jG = this.f28062b.g(this.f28065e, this.f28069i, j12 == -1 ? Long.MAX_VALUE : j12 - this.f28069i);
            if (jG > 0) {
                this.f28069i += jG;
            } else {
                long j13 = -jG;
                if (j13 == Long.MAX_VALUE) {
                    j13 = -1;
                }
                long j14 = this.f28069i;
                this.f28069i = j14 + f(j14, j13);
            }
        }
    }

    public void b() {
        this.f28072l = true;
    }

    public final long c() {
        long j10 = this.f28070j;
        if (j10 == -1) {
            return -1L;
        }
        return j10 - this.f28063c.f19098g;
    }

    public final void d(long j10) {
        this.f28071k += j10;
        a aVar = this.f28067g;
        if (aVar != null) {
            aVar.a(c(), this.f28071k, j10);
        }
    }

    public final void e(long j10) {
        if (this.f28070j == j10) {
            return;
        }
        this.f28070j = j10;
        a aVar = this.f28067g;
        if (aVar != null) {
            aVar.a(c(), this.f28071k, 0L);
        }
    }

    public final long f(long j10, long j11) throws IOException {
        long jA;
        boolean z10 = true;
        boolean z11 = j10 + j11 == this.f28070j || j11 == -1;
        try {
            if (j11 != -1) {
                try {
                    jA = this.f28061a.a(this.f28063c.a().i(j10).h(j11).a());
                } catch (IOException e10) {
                    if (!this.f28064d || !z11 || !DataSourceException.a(e10)) {
                        throw e10;
                    }
                    u0.p(this.f28061a);
                    jA = -1;
                    z10 = false;
                }
            } else {
                jA = -1;
                z10 = false;
            }
            if (!z10) {
                g();
                jA = this.f28061a.a(this.f28063c.a().i(j10).h(-1L).a());
            }
            if (z11 && jA != -1) {
                e(jA + j10);
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 != -1) {
                g();
                com.google.android.exoplayer2.upstream.cache.a aVar = this.f28061a;
                byte[] bArr = this.f28066f;
                i10 = aVar.read(bArr, 0, bArr.length);
                if (i10 != -1) {
                    d(i10);
                    i11 += i10;
                }
            }
            if (z11) {
                e(j10 + ((long) i11));
            }
            return i11;
        } finally {
            u0.p(this.f28061a);
        }
    }

    public final void g() throws InterruptedIOException {
        if (this.f28072l) {
            throw new InterruptedIOException();
        }
    }
}

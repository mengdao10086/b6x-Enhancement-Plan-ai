package okhttp3.internal.cache;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.e0;
import okhttp3.internal.cache.c;
import okhttp3.r;
import okhttp3.t;
import okhttp3.v;
import okio.j;
import okio.r0;
import okio.t0;
import okio.v0;
import rl.f;
import vl.h;
import w.w;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\tB\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/cache/a;", "Lokhttp3/v;", "Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "Lokhttp3/internal/cache/b;", "cacheRequest", "response", "a", "Lokhttp3/c;", "Lokhttp3/c;", "b", "()Lokhttp3/c;", "cache", "<init>", "(Lokhttp3/c;)V", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final C0493a f43747c = new C0493a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final okhttp3.c f43748a;

    /* JADX INFO: renamed from: okhttp3.internal.cache.a$a, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/a$a;", "", "Lokhttp3/d0;", "response", "f", "Lokhttp3/t;", "cachedHeaders", "networkHeaders", "c", "", "fieldName", "", "e", "d", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0493a {
        public C0493a() {
        }

        public /* synthetic */ C0493a(u uVar) {
            this();
        }

        public final t c(t tVar, t tVar2) {
            t.a aVar = new t.a();
            int size = tVar.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                String strJ = tVar.j(i11);
                String strR = tVar.r(i11);
                if ((!kotlin.text.u.L1(HttpHeaders.WARNING, strJ, true) || !kotlin.text.u.v2(strR, "1", false, 2, null)) && (d(strJ) || !e(strJ) || tVar2.d(strJ) == null)) {
                    aVar.g(strJ, strR);
                }
                i11 = i12;
            }
            int size2 = tVar2.size();
            while (i10 < size2) {
                int i13 = i10 + 1;
                String strJ2 = tVar2.j(i10);
                if (!d(strJ2) && e(strJ2)) {
                    aVar.g(strJ2, tVar2.r(i10));
                }
                i10 = i13;
            }
            return aVar.i();
        }

        public final boolean d(String str) {
            return kotlin.text.u.L1(HttpHeaders.CONTENT_LENGTH, str, true) || kotlin.text.u.L1(HttpHeaders.CONTENT_ENCODING, str, true) || kotlin.text.u.L1("Content-Type", str, true);
        }

        public final boolean e(String str) {
            return (kotlin.text.u.L1(HttpHeaders.CONNECTION, str, true) || kotlin.text.u.L1("Keep-Alive", str, true) || kotlin.text.u.L1(HttpHeaders.PROXY_AUTHENTICATE, str, true) || kotlin.text.u.L1(HttpHeaders.PROXY_AUTHORIZATION, str, true) || kotlin.text.u.L1(HttpHeaders.TE, str, true) || kotlin.text.u.L1("Trailers", str, true) || kotlin.text.u.L1(HttpHeaders.TRANSFER_ENCODING, str, true) || kotlin.text.u.L1(HttpHeaders.UPGRADE, str, true)) ? false : true;
        }

        public final okhttp3.d0 f(okhttp3.d0 d0Var) {
            return (d0Var == null ? null : d0Var.L()) != null ? d0Var.s1().b(null).c() : d0Var;
        }
    }

    @d0(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"okhttp3/internal/cache/a$b", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "", "a", "Z", "cacheRequestClosed", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f43749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ okio.l f43750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ okhttp3.internal.cache.b f43751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ okio.k f43752d;

        public b(okio.l lVar, okhttp3.internal.cache.b bVar, okio.k kVar) {
            this.f43750b = lVar;
            this.f43751c = bVar;
            this.f43752d = kVar;
        }

        @Override // okio.t0
        public long F1(@k j sink, long j10) throws IOException {
            f0.p(sink, "sink");
            try {
                long jF1 = this.f43750b.F1(sink, j10);
                if (jF1 != -1) {
                    sink.u(this.f43752d.g(), sink.m2() - jF1, jF1);
                    this.f43752d.l0();
                    return jF1;
                }
                if (!this.f43749a) {
                    this.f43749a = true;
                    this.f43752d.close();
                }
                return -1L;
            } catch (IOException e10) {
                if (!this.f43749a) {
                    this.f43749a = true;
                    this.f43751c.abort();
                }
                throw e10;
            }
        }

        @Override // okio.t0
        @k
        public v0 U() {
            return this.f43750b.U();
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f43749a && !f.w(this, 100, TimeUnit.MILLISECONDS)) {
                this.f43749a = true;
                this.f43751c.abort();
            }
            this.f43750b.close();
        }
    }

    public a(@l okhttp3.c cVar) {
        this.f43748a = cVar;
    }

    public final okhttp3.d0 a(okhttp3.internal.cache.b bVar, okhttp3.d0 d0Var) throws IOException {
        if (bVar == null) {
            return d0Var;
        }
        r0 r0VarA = bVar.a();
        e0 e0VarL = d0Var.L();
        f0.m(e0VarL);
        b bVar2 = new b(e0VarL.source(), bVar, okio.f0.d(r0VarA));
        return d0Var.s1().b(new h(okhttp3.d0.M0(d0Var, "Content-Type", null, 2, null), d0Var.L().contentLength(), okio.f0.e(bVar2))).c();
    }

    @l
    public final okhttp3.c b() {
        return this.f43748a;
    }

    @Override // okhttp3.v
    @k
    public okhttp3.d0 intercept(@k v.a chain) throws IOException {
        e0 e0VarL;
        e0 e0VarL2;
        f0.p(chain, "chain");
        e eVarCall = chain.call();
        okhttp3.c cVar = this.f43748a;
        okhttp3.d0 d0VarI = cVar == null ? null : cVar.i(chain.T());
        c cVarB = new c.b(System.currentTimeMillis(), chain.T(), d0VarI).b();
        b0 b0VarB = cVarB.b();
        okhttp3.d0 d0VarA = cVarB.a();
        okhttp3.c cVar2 = this.f43748a;
        if (cVar2 != null) {
            cVar2.G0(cVarB);
        }
        okhttp3.internal.connection.e eVar = eVarCall instanceof okhttp3.internal.connection.e ? (okhttp3.internal.connection.e) eVarCall : null;
        r rVarM = eVar != null ? eVar.m() : null;
        if (rVarM == null) {
            rVarM = r.NONE;
        }
        if (d0VarI != null && d0VarA == null && (e0VarL2 = d0VarI.L()) != null) {
            f.o(e0VarL2);
        }
        if (b0VarB == null && d0VarA == null) {
            okhttp3.d0 d0VarC = new d0.a().E(chain.T()).B(Protocol.HTTP_1_1).g(w.g.f53773l).y("Unsatisfiable Request (only-if-cached)").b(f.f48798c).F(-1L).C(System.currentTimeMillis()).c();
            rVarM.satisfactionFailure(eVarCall, d0VarC);
            return d0VarC;
        }
        if (b0VarB == null) {
            f0.m(d0VarA);
            okhttp3.d0 d0VarC2 = d0VarA.s1().d(f43747c.f(d0VarA)).c();
            rVarM.cacheHit(eVarCall, d0VarC2);
            return d0VarC2;
        }
        if (d0VarA != null) {
            rVarM.cacheConditionalHit(eVarCall, d0VarA);
        } else if (this.f43748a != null) {
            rVarM.cacheMiss(eVarCall);
        }
        try {
            okhttp3.d0 d0VarE = chain.e(b0VarB);
            if (d0VarE == null && d0VarI != null && e0VarL != null) {
            }
            if (d0VarA != null) {
                boolean z10 = false;
                if (d0VarE != null && d0VarE.W() == 304) {
                    z10 = true;
                }
                if (z10) {
                    d0.a aVarS1 = d0VarA.s1();
                    C0493a c0493a = f43747c;
                    okhttp3.d0 d0VarC3 = aVarS1.w(c0493a.c(d0VarA.h1(), d0VarE.h1())).F(d0VarE.Y1()).C(d0VarE.L1()).d(c0493a.f(d0VarA)).z(c0493a.f(d0VarE)).c();
                    e0 e0VarL3 = d0VarE.L();
                    f0.m(e0VarL3);
                    e0VarL3.close();
                    okhttp3.c cVar3 = this.f43748a;
                    f0.m(cVar3);
                    cVar3.F0();
                    this.f43748a.M0(d0VarA, d0VarC3);
                    rVarM.cacheHit(eVarCall, d0VarC3);
                    return d0VarC3;
                }
                e0 e0VarL4 = d0VarA.L();
                if (e0VarL4 != null) {
                    f.o(e0VarL4);
                }
            }
            f0.m(d0VarE);
            d0.a aVarS12 = d0VarE.s1();
            C0493a c0493a2 = f43747c;
            okhttp3.d0 d0VarC4 = aVarS12.d(c0493a2.f(d0VarA)).z(c0493a2.f(d0VarE)).c();
            if (this.f43748a != null) {
                if (vl.e.c(d0VarC4) && c.f43753c.a(d0VarC4, b0VarB)) {
                    okhttp3.d0 d0VarA2 = a(this.f43748a.M(d0VarC4), d0VarC4);
                    if (d0VarA != null) {
                        rVarM.cacheMiss(eVarCall);
                    }
                    return d0VarA2;
                }
                if (vl.f.f53205a.a(b0VarB.m())) {
                    try {
                        this.f43748a.P(b0VarB);
                    } catch (IOException unused) {
                    }
                }
            }
            return d0VarC4;
        } finally {
            if (d0VarI != null && (e0VarL = d0VarI.L()) != null) {
                f.o(e0VarL);
            }
        }
    }
}

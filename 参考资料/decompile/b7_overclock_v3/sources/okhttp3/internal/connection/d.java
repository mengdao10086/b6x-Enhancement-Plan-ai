package okhttp3.internal.connection;

import com.tencent.connect.common.Constants;
import f0.v;
import java.io.IOException;
import kotlin.d0;
import okhttp3.a0;
import okhttp3.f0;
import okhttp3.internal.connection.h;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.r;
import okhttp3.u;
import xf.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020'¢\u0006\u0004\b8\u00109J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\rJ8\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0002J0\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\fH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u001a\u0010#\u001a\u00020\u001f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010.R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00100R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00100R\u0016\u00104\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00100R\u0018\u00107\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lokhttp3/internal/connection/d;", "", "Lokhttp3/a0;", "client", "Lvl/g;", "chain", "Lvl/d;", "a", "Ljava/io/IOException;", "e", "Lkotlin/z1;", "h", "", "Lokhttp3/u;", "url", "g", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lokhttp3/internal/connection/RealConnection;", "c", "b", "Lokhttp3/f0;", "f", "Lokhttp3/internal/connection/f;", "Lokhttp3/internal/connection/f;", "connectionPool", "Lokhttp3/a;", "Lokhttp3/a;", "d", "()Lokhttp3/a;", m7.a.f40701a, "Lokhttp3/internal/connection/e;", "Lokhttp3/internal/connection/e;", v.E0, "Lokhttp3/r;", "Lokhttp3/r;", "eventListener", "Lokhttp3/internal/connection/h$b;", "Lokhttp3/internal/connection/h$b;", "routeSelection", "Lokhttp3/internal/connection/h;", "Lokhttp3/internal/connection/h;", "routeSelector", "I", "refusedStreamCount", "connectionShutdownCount", "i", "otherFailureCount", j.f55230b, "Lokhttp3/f0;", "nextRouteToTry", "<init>", "(Lokhttp3/internal/connection/f;Lokhttp3/a;Lokhttp3/internal/connection/e;Lokhttp3/r;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final f f43817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final okhttp3.a f43818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final e f43819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final r f43820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public h.b f43821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public h f43822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f43823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f43824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f43825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public f0 f43826j;

    public d(@k f connectionPool, @k okhttp3.a address, @k e call, @k r eventListener) {
        kotlin.jvm.internal.f0.p(connectionPool, "connectionPool");
        kotlin.jvm.internal.f0.p(address, "address");
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(eventListener, "eventListener");
        this.f43817a = connectionPool;
        this.f43818b = address;
        this.f43819c = call;
        this.f43820d = eventListener;
    }

    @k
    public final vl.d a(@k a0 client, @k vl.g chain) {
        kotlin.jvm.internal.f0.p(client, "client");
        kotlin.jvm.internal.f0.p(chain, "chain");
        try {
            return c(chain.l(), chain.n(), chain.p(), client.h0(), client.n0(), !kotlin.jvm.internal.f0.g(chain.o().m(), Constants.HTTP_GET)).B(client, chain);
        } catch (IOException e10) {
            h(e10);
            throw new RouteException(e10);
        } catch (RouteException e11) {
            h(e11.c());
            throw e11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.internal.connection.RealConnection b(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.d.b(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    public final RealConnection c(int i10, int i11, int i12, int i13, boolean z10, boolean z11) throws IOException {
        while (true) {
            RealConnection realConnectionB = b(i10, i11, i12, i13, z10);
            if (realConnectionB.z(z11)) {
                return realConnectionB;
            }
            realConnectionB.E();
            if (this.f43826j == null) {
                h.b bVar = this.f43821e;
                if (bVar == null ? true : bVar.b()) {
                    continue;
                } else {
                    h hVar = this.f43822f;
                    if (!(hVar != null ? hVar.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    @k
    public final okhttp3.a d() {
        return this.f43818b;
    }

    public final boolean e() {
        h hVar;
        boolean z10 = false;
        if (this.f43823g == 0 && this.f43824h == 0 && this.f43825i == 0) {
            return false;
        }
        if (this.f43826j != null) {
            return true;
        }
        f0 f0VarF = f();
        if (f0VarF != null) {
            this.f43826j = f0VarF;
            return true;
        }
        h.b bVar = this.f43821e;
        if (bVar != null && bVar.b()) {
            z10 = true;
        }
        if (z10 || (hVar = this.f43822f) == null) {
            return true;
        }
        return hVar.a();
    }

    public final f0 f() {
        RealConnection realConnectionK;
        if (this.f43823g > 1 || this.f43824h > 1 || this.f43825i > 0 || (realConnectionK = this.f43819c.k()) == null) {
            return null;
        }
        synchronized (realConnectionK) {
            if (realConnectionK.w() != 0) {
                return null;
            }
            if (rl.f.l(realConnectionK.b().d().w(), d().w())) {
                return realConnectionK.b();
            }
            return null;
        }
    }

    public final boolean g(@k u url) {
        kotlin.jvm.internal.f0.p(url, "url");
        u uVarW = this.f43818b.w();
        return url.N() == uVarW.N() && kotlin.jvm.internal.f0.g(url.F(), uVarW.F());
    }

    public final void h(@k IOException e10) {
        kotlin.jvm.internal.f0.p(e10, "e");
        this.f43826j = null;
        if ((e10 instanceof StreamResetException) && ((StreamResetException) e10).errorCode == ErrorCode.REFUSED_STREAM) {
            this.f43823g++;
        } else if (e10 instanceof ConnectionShutdownException) {
            this.f43824h++;
        } else {
            this.f43825i++;
        }
    }
}

package vl;

import com.flydigi.sdk.bluetooth.l;
import com.tencent.open.SocialConstants;
import f0.v;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.b0;
import okhttp3.v;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0019\u001a\u00020\u001d\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b/\u00100JM\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u0019\u001a\u00020\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\b\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\t\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b*\u0010)R\u001a\u0010\n\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b+\u0010)¨\u00061"}, d2 = {"Lvl/g;", "Lokhttp3/v$a;", "", "index", "Lokhttp3/internal/connection/c;", "exchange", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "i", "(ILokhttp3/internal/connection/c;Lokhttp3/b0;III)Lvl/g;", "Lokhttp3/i;", "f", "h", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "d", "b", "g", "c", "a", "Lokhttp3/e;", v.E0, i1.a.f31577d5, "Lokhttp3/d0;", "e", "Lokhttp3/internal/connection/e;", "Lokhttp3/internal/connection/e;", "k", "()Lokhttp3/internal/connection/e;", "Lokhttp3/internal/connection/c;", m0.k.f40564b, "()Lokhttp3/internal/connection/c;", "Lokhttp3/b0;", "o", "()Lokhttp3/b0;", "I", l.f16298a, "()I", "n", "p", "", "Lokhttp3/v;", "interceptors", "<init>", "(Lokhttp3/internal/connection/e;Ljava/util/List;ILokhttp3/internal/connection/c;Lokhttp3/b0;III)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class g implements v.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final okhttp3.internal.connection.e f53206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final List<okhttp3.v> f53207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final okhttp3.internal.connection.c f53209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final b0 f53210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f53212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f53213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f53214i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@yt.k okhttp3.internal.connection.e call, @yt.k List<? extends okhttp3.v> interceptors, int i10, @yt.l okhttp3.internal.connection.c cVar, @yt.k b0 request, int i11, int i12, int i13) {
        f0.p(call, "call");
        f0.p(interceptors, "interceptors");
        f0.p(request, "request");
        this.f53206a = call;
        this.f53207b = interceptors;
        this.f53208c = i10;
        this.f53209d = cVar;
        this.f53210e = request;
        this.f53211f = i11;
        this.f53212g = i12;
        this.f53213h = i13;
    }

    public static /* synthetic */ g j(g gVar, int i10, okhttp3.internal.connection.c cVar, b0 b0Var, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = gVar.f53208c;
        }
        if ((i14 & 2) != 0) {
            cVar = gVar.f53209d;
        }
        okhttp3.internal.connection.c cVar2 = cVar;
        if ((i14 & 4) != 0) {
            b0Var = gVar.f53210e;
        }
        b0 b0Var2 = b0Var;
        if ((i14 & 8) != 0) {
            i11 = gVar.f53211f;
        }
        int i15 = i11;
        if ((i14 & 16) != 0) {
            i12 = gVar.f53212g;
        }
        int i16 = i12;
        if ((i14 & 32) != 0) {
            i13 = gVar.f53213h;
        }
        return gVar.i(i10, cVar2, b0Var2, i15, i16, i13);
    }

    @Override // okhttp3.v.a
    @yt.k
    public b0 T() {
        return this.f53210e;
    }

    @Override // okhttp3.v.a
    @yt.k
    public v.a a(int i10, @yt.k TimeUnit unit) {
        f0.p(unit, "unit");
        if (this.f53209d == null) {
            return j(this, 0, null, null, 0, 0, rl.f.m("writeTimeout", i10, unit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.v.a
    public int b() {
        return this.f53212g;
    }

    @Override // okhttp3.v.a
    public int c() {
        return this.f53213h;
    }

    @Override // okhttp3.v.a
    @yt.k
    public okhttp3.e call() {
        return this.f53206a;
    }

    @Override // okhttp3.v.a
    @yt.k
    public v.a d(int i10, @yt.k TimeUnit unit) {
        f0.p(unit, "unit");
        if (this.f53209d == null) {
            return j(this, 0, null, null, rl.f.m("connectTimeout", i10, unit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.v.a
    @yt.k
    public okhttp3.d0 e(@yt.k b0 request) throws IOException {
        f0.p(request, "request");
        if (!(this.f53208c < this.f53207b.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f53214i++;
        okhttp3.internal.connection.c cVar = this.f53209d;
        if (cVar != null) {
            if (!cVar.j().g(request.q())) {
                throw new IllegalStateException(("network interceptor " + this.f53207b.get(this.f53208c - 1) + " must retain the same host and port").toString());
            }
            if (!(this.f53214i == 1)) {
                throw new IllegalStateException(("network interceptor " + this.f53207b.get(this.f53208c - 1) + " must call proceed() exactly once").toString());
            }
        }
        g gVarJ = j(this, this.f53208c + 1, null, request, 0, 0, 0, 58, null);
        okhttp3.v vVar = this.f53207b.get(this.f53208c);
        okhttp3.d0 d0VarIntercept = vVar.intercept(gVarJ);
        if (d0VarIntercept == null) {
            throw new NullPointerException("interceptor " + vVar + " returned null");
        }
        if (this.f53209d != null) {
            if (!(this.f53208c + 1 >= this.f53207b.size() || gVarJ.f53214i == 1)) {
                throw new IllegalStateException(("network interceptor " + vVar + " must call proceed() exactly once").toString());
            }
        }
        if (d0VarIntercept.L() != null) {
            return d0VarIntercept;
        }
        throw new IllegalStateException(("interceptor " + vVar + " returned a response with no body").toString());
    }

    @Override // okhttp3.v.a
    @yt.l
    public okhttp3.i f() {
        okhttp3.internal.connection.c cVar = this.f53209d;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    @Override // okhttp3.v.a
    @yt.k
    public v.a g(int i10, @yt.k TimeUnit unit) {
        f0.p(unit, "unit");
        if (this.f53209d == null) {
            return j(this, 0, null, null, 0, rl.f.m("readTimeout", i10, unit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.v.a
    public int h() {
        return this.f53211f;
    }

    @yt.k
    public final g i(int i10, @yt.l okhttp3.internal.connection.c cVar, @yt.k b0 request, int i11, int i12, int i13) {
        f0.p(request, "request");
        return new g(this.f53206a, this.f53207b, i10, cVar, request, i11, i12, i13);
    }

    @yt.k
    public final okhttp3.internal.connection.e k() {
        return this.f53206a;
    }

    public final int l() {
        return this.f53211f;
    }

    @yt.l
    public final okhttp3.internal.connection.c m() {
        return this.f53209d;
    }

    public final int n() {
        return this.f53212g;
    }

    @yt.k
    public final b0 o() {
        return this.f53210e;
    }

    public final int p() {
        return this.f53213h;
    }
}

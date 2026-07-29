package vl;

import com.google.common.net.HttpHeaders;
import com.tencent.connect.common.Constants;
import f0.v;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.Regex;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.e0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.v;
import xf.z;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¨\u0006\u001e"}, d2 = {"Lvl/j;", "Lokhttp3/v;", "Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "Ljava/io/IOException;", "e", "Lokhttp3/internal/connection/e;", v.E0, "Lokhttp3/b0;", "userRequest", "", "requestSendStarted", "d", "c", "userResponse", "Lokhttp3/internal/connection/c;", "exchange", "b", "", z.f55306i, "a", "", "defaultDelay", "f", "Lokhttp3/a0;", "client", "<init>", "(Lokhttp3/a0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class j implements okhttp3.v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f53219c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f53220d = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a0 f53221a;

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lvl/j$a;", "", "", "MAX_FOLLOW_UPS", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public j(@yt.k a0 client) {
        f0.p(client, "client");
        this.f53221a = client;
    }

    public final b0 a(okhttp3.d0 d0Var, String str) {
        String strM0;
        okhttp3.u uVarW;
        if (!this.f53221a.V() || (strM0 = okhttp3.d0.M0(d0Var, "Location", null, 2, null)) == null || (uVarW = d0Var.V1().q().W(strM0)) == null) {
            return null;
        }
        if (!f0.g(uVarW.X(), d0Var.V1().q().X()) && !this.f53221a.Y()) {
            return null;
        }
        b0.a aVarN = d0Var.V1().n();
        if (f.b(str)) {
            int iW = d0Var.W();
            f fVar = f.f53205a;
            boolean z10 = fVar.d(str) || iW == 308 || iW == 307;
            if (!fVar.c(str) || iW == 308 || iW == 307) {
                aVarN.p(str, z10 ? d0Var.V1().f() : null);
            } else {
                aVarN.p(Constants.HTTP_GET, null);
            }
            if (!z10) {
                aVarN.t(HttpHeaders.TRANSFER_ENCODING);
                aVarN.t(HttpHeaders.CONTENT_LENGTH);
                aVarN.t("Content-Type");
            }
        }
        if (!rl.f.l(d0Var.V1().q(), uVarW)) {
            aVarN.t("Authorization");
        }
        return aVarN.D(uVarW).b();
    }

    public final b0 b(okhttp3.d0 d0Var, okhttp3.internal.connection.c cVar) throws IOException {
        RealConnection realConnectionH;
        okhttp3.f0 f0VarB = (cVar == null || (realConnectionH = cVar.h()) == null) ? null : realConnectionH.b();
        int iW = d0Var.W();
        String strM = d0Var.V1().m();
        if (iW != 307 && iW != 308) {
            if (iW == 401) {
                return this.f53221a.G().a(f0VarB, d0Var);
            }
            if (iW == 421) {
                c0 c0VarF = d0Var.V1().f();
                if ((c0VarF != null && c0VarF.q()) || cVar == null || !cVar.k()) {
                    return null;
                }
                cVar.h().D();
                return d0Var.V1();
            }
            if (iW == 503) {
                okhttp3.d0 d0VarZ1 = d0Var.z1();
                if ((d0VarZ1 == null || d0VarZ1.W() != 503) && f(d0Var, Integer.MAX_VALUE) == 0) {
                    return d0Var.V1();
                }
                return null;
            }
            if (iW == 407) {
                f0.m(f0VarB);
                if (f0VarB.e().type() == Proxy.Type.HTTP) {
                    return this.f53221a.k0().a(f0VarB, d0Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iW == 408) {
                if (!this.f53221a.n0()) {
                    return null;
                }
                c0 c0VarF2 = d0Var.V1().f();
                if (c0VarF2 != null && c0VarF2.q()) {
                    return null;
                }
                okhttp3.d0 d0VarZ12 = d0Var.z1();
                if ((d0VarZ12 == null || d0VarZ12.W() != 408) && f(d0Var, 0) <= 0) {
                    return d0Var.V1();
                }
                return null;
            }
            switch (iW) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return a(d0Var, strM);
    }

    public final boolean c(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public final boolean d(IOException iOException, okhttp3.internal.connection.e eVar, b0 b0Var, boolean z10) {
        if (this.f53221a.n0()) {
            return !(z10 && e(iOException, b0Var)) && c(iOException, z10) && eVar.w();
        }
        return false;
    }

    public final boolean e(IOException iOException, b0 b0Var) {
        c0 c0VarF = b0Var.f();
        return (c0VarF != null && c0VarF.q()) || (iOException instanceof FileNotFoundException);
    }

    public final int f(okhttp3.d0 d0Var, int i10) {
        String strM0 = okhttp3.d0.M0(d0Var, HttpHeaders.RETRY_AFTER, null, 2, null);
        if (strM0 == null) {
            return i10;
        }
        if (!new Regex("\\d+").n(strM0)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strM0);
        f0.o(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    @Override // okhttp3.v
    @yt.k
    public okhttp3.d0 intercept(@yt.k v.a chain) throws IOException {
        okhttp3.internal.connection.c cVarO;
        b0 b0VarB;
        f0.p(chain, "chain");
        g gVar = (g) chain;
        b0 b0VarO = gVar.o();
        okhttp3.internal.connection.e eVarK = gVar.k();
        List listE = CollectionsKt__CollectionsKt.E();
        okhttp3.d0 d0Var = null;
        boolean z10 = true;
        int i10 = 0;
        while (true) {
            eVarK.h(b0VarO, z10);
            try {
                if (eVarK.W()) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        okhttp3.d0 d0VarE = gVar.e(b0VarO);
                        if (d0Var != null) {
                            d0VarE = d0VarE.s1().A(d0Var.s1().b(null).c()).c();
                        }
                        d0Var = d0VarE;
                        cVarO = eVarK.o();
                        b0VarB = b(d0Var, cVarO);
                    } catch (RouteException e10) {
                        if (!d(e10.c(), eVarK, b0VarO, false)) {
                            throw rl.f.o0(e10.b(), listE);
                        }
                        listE = CollectionsKt___CollectionsKt.z4(listE, e10.b());
                        eVarK.i(true);
                        z10 = false;
                    }
                } catch (IOException e11) {
                    if (!d(e11, eVarK, b0VarO, !(e11 instanceof ConnectionShutdownException))) {
                        throw rl.f.o0(e11, listE);
                    }
                    listE = CollectionsKt___CollectionsKt.z4(listE, e11);
                    eVarK.i(true);
                    z10 = false;
                }
                if (b0VarB == null) {
                    if (cVarO != null && cVarO.l()) {
                        eVarK.A();
                    }
                    eVarK.i(false);
                    return d0Var;
                }
                c0 c0VarF = b0VarB.f();
                if (c0VarF != null && c0VarF.q()) {
                    eVarK.i(false);
                    return d0Var;
                }
                e0 e0VarL = d0Var.L();
                if (e0VarL != null) {
                    rl.f.o(e0VarL);
                }
                i10++;
                if (i10 > 20) {
                    throw new ProtocolException(f0.C("Too many follow-up requests: ", Integer.valueOf(i10)));
                }
                eVarK.i(true);
                b0VarO = b0VarB;
                z10 = true;
            } catch (Throwable th2) {
                eVarK.i(true);
                throw th2;
            }
        }
    }
}

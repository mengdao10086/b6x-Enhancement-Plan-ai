package vl;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.u;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.v;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lvl/b;", "Lokhttp3/v;", "Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "", "forWebSocket", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53194a;

    public b(boolean z10) {
        this.f53194a = z10;
    }

    @Override // okhttp3.v
    @yt.k
    public okhttp3.d0 intercept(@yt.k v.a chain) throws IOException {
        d0.a aVarQ;
        boolean z10;
        f0.p(chain, "chain");
        g gVar = (g) chain;
        okhttp3.internal.connection.c cVarM = gVar.m();
        f0.m(cVarM);
        b0 b0VarO = gVar.o();
        c0 c0VarF = b0VarO.f();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVarM.w(b0VarO);
        if (!f.b(b0VarO.m()) || c0VarF == null) {
            cVarM.o();
            aVarQ = null;
            z10 = true;
        } else {
            if (u.L1("100-continue", b0VarO.i(HttpHeaders.EXPECT), true)) {
                cVarM.f();
                aVarQ = cVarM.q(true);
                cVarM.s();
                z10 = false;
            } else {
                aVarQ = null;
                z10 = true;
            }
            if (aVarQ != null) {
                cVarM.o();
                if (!cVarM.h().A()) {
                    cVarM.n();
                }
            } else if (c0VarF.p()) {
                cVarM.f();
                c0VarF.r(okio.f0.d(cVarM.c(b0VarO, true)));
            } else {
                okio.k kVarD = okio.f0.d(cVarM.c(b0VarO, false));
                c0VarF.r(kVarD);
                kVarD.close();
            }
        }
        if (c0VarF == null || !c0VarF.p()) {
            cVarM.e();
        }
        if (aVarQ == null) {
            aVarQ = cVarM.q(false);
            f0.m(aVarQ);
            if (z10) {
                cVarM.s();
                z10 = false;
            }
        }
        okhttp3.d0 d0VarC = aVarQ.E(b0VarO).u(cVarM.h().c()).F(jCurrentTimeMillis).C(System.currentTimeMillis()).c();
        int iW = d0VarC.W();
        if (iW == 100) {
            d0.a aVarQ2 = cVarM.q(false);
            f0.m(aVarQ2);
            if (z10) {
                cVarM.s();
            }
            d0VarC = aVarQ2.E(b0VarO).u(cVarM.h().c()).F(jCurrentTimeMillis).C(System.currentTimeMillis()).c();
            iW = d0VarC.W();
        }
        cVarM.r(d0VarC);
        okhttp3.d0 d0VarC2 = (this.f53194a && iW == 101) ? d0VarC.s1().b(rl.f.f48798c).c() : d0VarC.s1().b(cVarM.p(d0VarC)).c();
        if (u.L1("close", d0VarC2.V1().i(HttpHeaders.CONNECTION), true) || u.L1("close", okhttp3.d0.M0(d0VarC2, HttpHeaders.CONNECTION, null, 2, null), true)) {
            cVarM.n();
        }
        if (iW == 204 || iW == 205) {
            e0 e0VarL = d0VarC2.L();
            if ((e0VarL == null ? -1L : e0VarL.contentLength()) > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("HTTP ");
                sb2.append(iW);
                sb2.append(" had non-zero Content-Length: ");
                e0 e0VarL2 = d0VarC2.L();
                sb2.append(e0VarL2 != null ? Long.valueOf(e0VarL2.contentLength()) : null);
                throw new ProtocolException(sb2.toString());
            }
        }
        return d0VarC2;
    }
}

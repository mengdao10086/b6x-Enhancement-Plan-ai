package vl;

import com.efs.sdk.base.Constants;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.u;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.m;
import okhttp3.n;
import okhttp3.v;
import okhttp3.w;
import okio.x;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¨\u0006\u000f"}, d2 = {"Lvl/a;", "Lokhttp3/v;", "Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "", "Lokhttp3/m;", "cookies", "", "a", "Lokhttp3/n;", "cookieJar", "<init>", "(Lokhttp3/n;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final n f53193a;

    public a(@yt.k n cookieJar) {
        f0.p(cookieJar, "cookieJar");
        this.f53193a = cookieJar;
    }

    public final String a(List<m> list) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            m mVar = (m) obj;
            if (i10 > 0) {
                sb2.append("; ");
            }
            sb2.append(mVar.s());
            sb2.append('=');
            sb2.append(mVar.z());
            i10 = i11;
        }
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // okhttp3.v
    @yt.k
    public okhttp3.d0 intercept(@yt.k v.a chain) throws IOException {
        e0 e0VarL;
        f0.p(chain, "chain");
        b0 b0VarT = chain.T();
        b0.a aVarN = b0VarT.n();
        c0 c0VarF = b0VarT.f();
        if (c0VarF != null) {
            w wVarB = c0VarF.b();
            if (wVarB != null) {
                aVarN.n("Content-Type", wVarB.toString());
            }
            long jA = c0VarF.a();
            if (jA != -1) {
                aVarN.n(HttpHeaders.CONTENT_LENGTH, String.valueOf(jA));
                aVarN.t(HttpHeaders.TRANSFER_ENCODING);
            } else {
                aVarN.n(HttpHeaders.TRANSFER_ENCODING, "chunked");
                aVarN.t(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z10 = false;
        if (b0VarT.i(HttpHeaders.HOST) == null) {
            aVarN.n(HttpHeaders.HOST, rl.f.g0(b0VarT.q(), false, 1, null));
        }
        if (b0VarT.i(HttpHeaders.CONNECTION) == null) {
            aVarN.n(HttpHeaders.CONNECTION, "Keep-Alive");
        }
        if (b0VarT.i(HttpHeaders.ACCEPT_ENCODING) == null && b0VarT.i(HttpHeaders.RANGE) == null) {
            aVarN.n(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            z10 = true;
        }
        List<m> listB = this.f53193a.b(b0VarT.q());
        if (!listB.isEmpty()) {
            aVarN.n(HttpHeaders.COOKIE, a(listB));
        }
        if (b0VarT.i("User-Agent") == null) {
            aVarN.n("User-Agent", rl.f.f48805j);
        }
        okhttp3.d0 d0VarE = chain.e(aVarN.b());
        e.g(this.f53193a, b0VarT.q(), d0VarE.h1());
        d0.a aVarE = d0VarE.s1().E(b0VarT);
        if (z10 && u.L1(Constants.CP_GZIP, okhttp3.d0.M0(d0VarE, HttpHeaders.CONTENT_ENCODING, null, 2, null), true) && e.c(d0VarE) && (e0VarL = d0VarE.L()) != null) {
            x xVar = new x(e0VarL.source());
            aVarE.w(d0VarE.h1().m().l(HttpHeaders.CONTENT_ENCODING).l(HttpHeaders.CONTENT_LENGTH).i());
            aVarE.b(new h(okhttp3.d0.M0(d0VarE, "Content-Type", null, 2, null), -1L, okio.f0.e(xVar)));
        }
        return aVarE.c();
    }
}

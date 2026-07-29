package vl;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.common.net.HttpHeaders;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.t0;
import kotlin.text.u;
import okhttp3.m;
import okhttp3.n;
import okhttp3.t;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "HttpHeaders")
@d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\n\u001a\u00020\t*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0006H\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0002\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0002\u001a\u001a\u0010\u0016\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0000\u001a\n\u0010\u0018\u001a\u00020\u000b*\u00020\u0017\u001a\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0017H\u0007¨\u0006\u001b"}, d2 = {"Lokhttp3/t;", "", "headerName", "", "Lokhttp3/g;", "b", "Lokio/j;", "", CommonNetImpl.RESULT, "Lkotlin/z1;", "d", "", "h", "", "prefix", "i", "e", "f", "Lokhttp3/n;", "Lokhttp3/u;", "url", IOptionConstant.headers, "g", "Lokhttp3/d0;", "c", "response", "a", "okhttp"}, k = 2, mv = {1, 6, 0})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final ByteString f53203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final ByteString f53204b;

    static {
        ByteString.a aVar = ByteString.f44029c;
        f53203a = aVar.l("\"\\");
        f53204b = aVar.l("\t ,=");
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @t0(expression = "response.promisesBody()", imports = {}))
    public static final boolean a(@yt.k okhttp3.d0 response) {
        f0.p(response, "response");
        return c(response);
    }

    @yt.k
    public static final List<okhttp3.g> b(@yt.k t tVar, @yt.k String headerName) {
        f0.p(tVar, "<this>");
        f0.p(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = tVar.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (u.L1(headerName, tVar.j(i10), true)) {
                try {
                    d(new okio.j().H0(tVar.r(i10)), arrayList);
                } catch (EOFException e10) {
                    zl.h.f58636a.g().m("Unable to parse challenge", 5, e10);
                }
            }
            i10 = i11;
        }
        return arrayList;
    }

    public static final boolean c(@yt.k okhttp3.d0 d0Var) {
        f0.p(d0Var, "<this>");
        if (f0.g(d0Var.V1().m(), "HEAD")) {
            return false;
        }
        int iW = d0Var.W();
        return (((iW >= 100 && iW < 200) || iW == 204 || iW == 304) && rl.f.A(d0Var) == -1 && !u.L1("chunked", okhttp3.d0.M0(d0Var, HttpHeaders.TRANSFER_ENCODING, null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0079, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0079, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(okio.j r7, java.util.List<okhttp3.g> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            h(r7)
            java.lang.String r1 = f(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = h(r7)
            java.lang.String r3 = f(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.d0()
            if (r7 != 0) goto L1f
            return
        L1f:
            okhttp3.g r7 = new okhttp3.g
            java.util.Map r0 = kotlin.collections.s0.z()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            int r5 = rl.f.W(r7, r4)
            boolean r6 = h(r7)
            if (r2 != 0) goto L5c
            if (r6 != 0) goto L40
            boolean r2 = r7.d0()
            if (r2 == 0) goto L5c
        L40:
            okhttp3.g r2 = new okhttp3.g
            java.lang.String r4 = "="
            java.lang.String r4 = kotlin.text.u.h2(r4, r5)
            java.lang.String r3 = kotlin.jvm.internal.f0.C(r3, r4)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap<String, Str…ek + \"=\".repeat(eqCount))"
            kotlin.jvm.internal.f0.o(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L5c:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = rl.f.W(r7, r4)
            int r5 = r5 + r6
        L66:
            if (r3 != 0) goto L77
            java.lang.String r3 = f(r7)
            boolean r5 = h(r7)
            if (r5 == 0) goto L73
            goto L79
        L73:
            int r5 = rl.f.W(r7, r4)
        L77:
            if (r5 != 0) goto L84
        L79:
            okhttp3.g r4 = new okhttp3.g
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L84:
            r6 = 1
            if (r5 <= r6) goto L88
            return
        L88:
            boolean r6 = h(r7)
            if (r6 == 0) goto L8f
            return
        L8f:
            r6 = 34
            boolean r6 = i(r7, r6)
            if (r6 == 0) goto L9c
            java.lang.String r6 = e(r7)
            goto La0
        L9c:
            java.lang.String r6 = f(r7)
        La0:
            if (r6 != 0) goto La3
            return
        La3:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lac
            return
        Lac:
            boolean r3 = h(r7)
            if (r3 != 0) goto Lb9
            boolean r3 = r7.d0()
            if (r3 != 0) goto Lb9
            return
        Lb9:
            r3 = r0
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: vl.e.d(okio.j, java.util.List):void");
    }

    public static final String e(okio.j jVar) throws EOFException {
        if (!(jVar.readByte() == 34)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        okio.j jVar2 = new okio.j();
        while (true) {
            long jJ0 = jVar.j0(f53203a);
            if (jJ0 == -1) {
                return null;
            }
            if (jVar.d1(jJ0) == 34) {
                jVar2.V0(jVar, jJ0);
                jVar.readByte();
                return jVar2.y1();
            }
            if (jVar.m2() == jJ0 + 1) {
                return null;
            }
            jVar2.V0(jVar, jJ0);
            jVar.readByte();
            jVar2.V0(jVar, 1L);
        }
    }

    public static final String f(okio.j jVar) {
        long jJ0 = jVar.j0(f53204b);
        if (jJ0 == -1) {
            jJ0 = jVar.m2();
        }
        if (jJ0 != 0) {
            return jVar.q(jJ0);
        }
        return null;
    }

    public static final void g(@yt.k n nVar, @yt.k okhttp3.u url, @yt.k t headers) {
        f0.p(nVar, "<this>");
        f0.p(url, "url");
        f0.p(headers, "headers");
        if (nVar == n.f43925b) {
            return;
        }
        List<m> listG = m.f43901j.g(url, headers);
        if (listG.isEmpty()) {
            return;
        }
        nVar.a(url, listG);
    }

    public static final boolean h(okio.j jVar) throws EOFException {
        boolean z10 = false;
        while (!jVar.d0()) {
            byte bD1 = jVar.d1(0L);
            if (bD1 != 44) {
                if (!(bD1 == 32 || bD1 == 9)) {
                    break;
                }
                jVar.readByte();
            } else {
                jVar.readByte();
                z10 = true;
            }
        }
        return z10;
    }

    public static final boolean i(okio.j jVar, byte b10) {
        return !jVar.d0() && jVar.d1(0L) == b10;
    }
}

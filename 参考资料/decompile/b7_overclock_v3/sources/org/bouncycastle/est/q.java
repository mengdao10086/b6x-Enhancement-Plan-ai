package org.bouncycastle.est;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class q implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final cs.n f44846f = new cs.j();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f44847g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f44849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[] f44850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SecureRandom f44851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cs.p f44852e;

    public class a implements i {
        public a() {
        }

        @Override // org.bouncycastle.est.i
        public l a(j jVar, s sVar) throws IOException {
            l lVar = new l(jVar, sVar);
            if (lVar.l() != 401) {
                return lVar;
            }
            String strF = lVar.f(HttpHeaders.WWW_AUTHENTICATE);
            if (strF == null) {
                throw new ESTException("Status of 401 but no WWW-Authenticate header");
            }
            String strK = Strings.k(strF);
            if (strK.startsWith(so.d.f50128b)) {
                return q.this.f(lVar);
            }
            if (!strK.startsWith("basic")) {
                throw new ESTException("Unknown auth mode: " + strK);
            }
            lVar.d();
            Map<String, String> mapC = HttpUtil.c("Basic", lVar.f(HttpHeaders.WWW_AUTHENTICATE));
            if (q.this.f44848a != null && !q.this.f44848a.equals(mapC.get("realm"))) {
                throw new ESTException("Supplied realm '" + q.this.f44848a + "' does not match server realm '" + mapC.get("realm") + "'", null, 401, null);
            }
            k kVarG = new k(jVar).g(null);
            if (q.this.f44848a != null && q.this.f44848a.length() > 0) {
                kVarG.c(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"" + q.this.f44848a + "\"");
            }
            if (q.this.f44849b.contains(":")) {
                throw new IllegalArgumentException("User must not contain a ':'");
            }
            char[] cArr = new char[q.this.f44849b.length() + 1 + q.this.f44850c.length];
            System.arraycopy(q.this.f44849b.toCharArray(), 0, cArr, 0, q.this.f44849b.length());
            cArr[q.this.f44849b.length()] = ':';
            System.arraycopy(q.this.f44850c, 0, cArr, q.this.f44849b.length() + 1, q.this.f44850c.length);
            kVarG.c("Authorization", "Basic " + jt.c.i(Strings.j(cArr)));
            l lVarA = jVar.a().a(kVarG.b());
            org.bouncycastle.util.a.f0(cArr, (char) 0);
            return lVarA;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("realm");
        hashSet.add("nonce");
        hashSet.add("opaque");
        hashSet.add("algorithm");
        hashSet.add("qop");
        f44847g = Collections.unmodifiableSet(hashSet);
    }

    public q(String str, String str2, char[] cArr) {
        this(str, str2, cArr, null, null);
    }

    public q(String str, String str2, char[] cArr, SecureRandom secureRandom, cs.p pVar) {
        this.f44848a = str;
        this.f44849b = str2;
        this.f44850c = cArr;
        this.f44851d = secureRandom;
        this.f44852e = pVar;
    }

    public q(String str, char[] cArr) {
        this(null, str, cArr, null, null);
    }

    public q(String str, char[] cArr, SecureRandom secureRandom, cs.p pVar) {
        this(null, str, cArr, secureRandom, pVar);
    }

    @Override // org.bouncycastle.est.e
    public void a(k kVar) {
        kVar.g(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x02b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.bouncycastle.est.l f(org.bouncycastle.est.l r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 855
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.est.q.f(org.bouncycastle.est.l):org.bouncycastle.est.l");
    }

    public final cs.o g(String str, zn.b bVar) throws IOException {
        try {
            return this.f44852e.a(bVar);
        } catch (OperatorCreationException e10) {
            throw new IOException("cannot create digest calculator for " + str + ": " + e10.getMessage());
        }
    }

    public final zn.b h(String str) {
        if (str.endsWith("-SESS")) {
            str = str.substring(0, str.length() - 5);
        }
        return str.equals("SHA-512-256") ? f44846f.b(kn.d.f37602h) : f44846f.a(str);
    }

    public final String i(int i10) {
        byte[] bArr = new byte[i10];
        this.f44851d.nextBytes(bArr);
        return jt.h.j(bArr);
    }

    public final void j(OutputStream outputStream, String str) throws IOException {
        outputStream.write(Strings.m(str));
    }

    public final void k(OutputStream outputStream, char[] cArr) throws IOException {
        outputStream.write(Strings.n(cArr));
    }
}

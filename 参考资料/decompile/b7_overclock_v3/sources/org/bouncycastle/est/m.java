package org.bouncycastle.est;

import com.blankj.utilcode.util.i0;
import com.google.common.net.HttpHeaders;
import com.just.agentweb.DefaultWebClient;
import com.tencent.connect.common.Constants;
import gm.f0;
import gm.i2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cmc.CMCException;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f44826c = "/cacerts";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f44827d = "/simpleenroll";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f44828e = "/simplereenroll";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f44829f = "/fullcmc";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f44830g = "/serverkeygen";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f44831h = "/csrattrs";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f44832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f44833j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f44835b;

    public class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ es.c f44836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ cs.f f44837b;

        public a(es.c cVar, cs.f fVar) {
            this.f44836a = cVar;
            this.f44837b = fVar;
        }

        @Override // org.bouncycastle.est.o
        public j a(s sVar, j jVar) throws IOException {
            if (sVar instanceof t) {
                t tVar = (t) sVar;
                if (tVar.a()) {
                    es.c cVar = new es.c(this.f44836a);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cVar.d(pn.s.B4, new i2(jt.c.i(tVar.f())));
                    byteArrayOutputStream.write(m.this.b(cVar.c(this.f44837b).c()).getBytes());
                    byteArrayOutputStream.flush();
                    k kVarF = new k(jVar).f(byteArrayOutputStream.toByteArray());
                    kVarF.c("Content-Type", "application/pkcs10");
                    kVarF.c("Content-Transfer-Encoding", "base64");
                    kVarF.c(HttpHeaders.CONTENT_LENGTH, Long.toString(byteArrayOutputStream.size()));
                    return kVarF.b();
                }
            }
            throw new IOException("Source does not supply TLS unique.");
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f44832i = hashSet;
        hashSet.add("cacerts");
        hashSet.add("simpleenroll");
        hashSet.add("simplereenroll");
        hashSet.add("fullcmc");
        hashSet.add("serverkeygen");
        hashSet.add("csrattrs");
        f44833j = Pattern.compile("^[0-9a-zA-Z_\\-.~!$&'()*+,;:=]+");
    }

    public m(String str, String str2, g gVar) {
        String str3;
        String strL = l(str);
        if (str2 != null) {
            str3 = DefaultWebClient.f21815w + strL + "/.well-known/est/" + k(str2);
        } else {
            str3 = DefaultWebClient.f21815w + strL + "/.well-known/est";
        }
        this.f44834a = str3;
        this.f44835b = gVar;
    }

    public static X509CertificateHolder[] i(org.bouncycastle.util.s<X509CertificateHolder> sVar) {
        return j(sVar, null);
    }

    public static X509CertificateHolder[] j(org.bouncycastle.util.s<X509CertificateHolder> sVar, org.bouncycastle.util.q<X509CertificateHolder> qVar) {
        Collection<X509CertificateHolder> collectionA = sVar.a(qVar);
        return (X509CertificateHolder[]) collectionA.toArray(new X509CertificateHolder[collectionA.size()]);
    }

    public final String b(byte[] bArr) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        int length = 0;
        do {
            int i10 = length + 48;
            if (i10 < bArr.length) {
                printWriter.print(jt.c.j(bArr, length, 48));
                length = i10;
            } else {
                printWriter.print(jt.c.j(bArr, length, bArr.length - length));
                length = bArr.length;
            }
            printWriter.print('\n');
        } while (length < bArr.length);
        printWriter.flush();
        return stringWriter.toString();
    }

    public org.bouncycastle.est.a c() throws ESTException {
        l lVarA;
        ESTException th2;
        org.bouncycastle.util.s<X509CertificateHolder> sVar;
        org.bouncycastle.util.s<X509CRLHolder> sVar2;
        String str;
        org.bouncycastle.util.s<X509CertificateHolder> sVarB;
        org.bouncycastle.util.s<X509CRLHolder> sVarA;
        try {
            URL url = new URL(this.f44834a + f44826c);
            f fVarB = this.f44835b.b();
            j jVarB = new k(Constants.HTTP_GET, url).d(fVarB).b();
            lVarA = fVarB.a(jVarB);
            try {
                if (lVarA.l() == 200) {
                    String strH = lVarA.g().h("Content-Type");
                    if (strH == null || !strH.startsWith("application/pkcs7-mime")) {
                        if (strH != null) {
                            str = " got " + strH;
                        } else {
                            str = " but was not present.";
                        }
                        throw new ESTException("Response : " + url.toString() + "Expecting application/pkcs7-mime " + str, null, lVarA.l(), lVarA.i());
                    }
                    try {
                        if (lVarA.e() == null || lVarA.e().longValue() <= 0) {
                            sVarB = null;
                            sVarA = null;
                        } else {
                            ro.a aVar = new ro.a(mm.n.A((f0) new gm.s(lVarA.i()).n()));
                            sVarB = aVar.b();
                            sVarA = aVar.a();
                        }
                        sVar = sVarB;
                        sVar2 = sVarA;
                    } catch (Throwable th3) {
                        throw new ESTException("Decoding CACerts: " + url.toString() + i0.f11861z + th3.getMessage(), th3, lVarA.l(), lVarA.i());
                    }
                } else {
                    if (lVarA.l() != 204) {
                        throw new ESTException("Get CACerts: " + url.toString(), null, lVarA.l(), lVarA.i());
                    }
                    sVar = null;
                    sVar2 = null;
                }
                org.bouncycastle.est.a aVar2 = new org.bouncycastle.est.a(sVar, sVar2, jVarB, lVarA.k(), this.f44835b.a());
                try {
                    lVarA.d();
                    e = null;
                } catch (Exception e10) {
                    e = e10;
                }
                if (e == null) {
                    return aVar2;
                }
                if (e instanceof ESTException) {
                    throw ((ESTException) e);
                }
                throw new ESTException("Get CACerts: " + url.toString(), e, lVarA.l(), null);
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    if (th2 instanceof ESTException) {
                        throw th2;
                    }
                    throw new ESTException(th2.getMessage(), th2);
                } catch (Throwable th5) {
                    if (lVarA != null) {
                        try {
                            lVarA.d();
                        } catch (Exception unused) {
                        }
                    }
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            lVarA = null;
            th2 = th6;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:59|6|(2:8|(2:13|14))(7:55|15|(0)(1:19)|57|22|23|(2:26|(2:28|29)(2:30|31))(2:32|33))|21|57|22|23|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
    
        r1 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.bouncycastle.est.c d() throws org.bouncycastle.est.ESTException {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.est.m.d():org.bouncycastle.est.c");
    }

    public p e(l lVar) throws IOException {
        long time;
        j jVarJ = lVar.j();
        if (lVar.l() != 202) {
            if (lVar.l() == 200) {
                try {
                    return new p(new ro.a(mm.n.A(new gm.s(lVar.i()).n())).b(), -1L, null, lVar.k());
                } catch (CMCException e10) {
                    throw new ESTException(e10.getMessage(), e10.getCause());
                }
            }
            throw new ESTException("Simple Enroll: " + jVarJ.f().toString(), null, lVar.l(), lVar.i());
        }
        String strF = lVar.f(HttpHeaders.RETRY_AFTER);
        if (strF == null) {
            throw new ESTException("Got Status 202 but not Retry-After header from: " + jVarJ.f().toString());
        }
        try {
            try {
                time = System.currentTimeMillis() + (Long.parseLong(strF) * 1000);
            } catch (Exception e11) {
                throw new ESTException("Unable to parse Retry-After header:" + jVarJ.f().toString() + i0.f11861z + e11.getMessage(), null, lVar.l(), lVar.i());
            }
        } catch (NumberFormatException unused) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            time = simpleDateFormat.parse(strF).getTime();
        }
        return new p(null, time, jVarJ, lVar.k());
    }

    public p f(p pVar) throws Exception {
        if (!this.f44835b.a()) {
            throw new IllegalStateException("No trust anchors.");
        }
        l lVarA = null;
        try {
            f fVarB = this.f44835b.b();
            lVarA = fVarB.a(new k(pVar.c()).d(fVarB).b());
            return e(lVarA);
        } catch (Throwable th2) {
            try {
                if (th2 instanceof ESTException) {
                    throw th2;
                }
                throw new ESTException(th2.getMessage(), th2);
            } finally {
                if (lVarA != null) {
                    lVarA.d();
                }
            }
        }
    }

    public p g(boolean z10, es.b bVar, e eVar) throws IOException {
        if (!this.f44835b.a()) {
            throw new IllegalStateException("No trust anchors.");
        }
        l lVarA = null;
        try {
            byte[] bytes = b(bVar.c()).getBytes();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f44834a);
            sb2.append(z10 ? f44828e : f44827d);
            URL url = new URL(sb2.toString());
            f fVarB = this.f44835b.b();
            k kVarD = new k(Constants.HTTP_POST, url).f(bytes).d(fVarB);
            kVarD.a("Content-Type", "application/pkcs10");
            kVarD.a(HttpHeaders.CONTENT_LENGTH, "" + bytes.length);
            kVarD.a("Content-Transfer-Encoding", "base64");
            if (eVar != null) {
                eVar.a(kVarD);
            }
            lVarA = fVarB.a(kVarD.b());
            return e(lVarA);
        } catch (Throwable th2) {
            try {
                if (th2 instanceof ESTException) {
                    throw th2;
                }
                throw new ESTException(th2.getMessage(), th2);
            } finally {
                if (lVarA != null) {
                    lVarA.d();
                }
            }
        }
    }

    public p h(boolean z10, es.c cVar, cs.f fVar, e eVar) throws IOException {
        if (!this.f44835b.a()) {
            throw new IllegalStateException("No trust anchors.");
        }
        l lVarA = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f44834a);
            sb2.append(z10 ? f44828e : f44827d);
            URL url = new URL(sb2.toString());
            f fVarB = this.f44835b.b();
            k kVarE = new k(Constants.HTTP_POST, url).d(fVarB).e(new a(cVar, fVar));
            if (eVar != null) {
                eVar.a(kVarE);
            }
            lVarA = fVarB.a(kVarE.b());
            return e(lVarA);
        } catch (Throwable th2) {
            try {
                if (th2 instanceof ESTException) {
                    throw th2;
                }
                throw new ESTException(th2.getMessage(), th2);
            } finally {
                if (lVarA != null) {
                    lVarA.d();
                }
            }
        }
    }

    public final String k(String str) {
        while (str.endsWith(fh.a.f28350w) && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        while (str.startsWith(fh.a.f28350w) && str.length() > 0) {
            str = str.substring(1);
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Label set but after trimming '/' is not zero length string.");
        }
        if (!f44833j.matcher(str).matches()) {
            throw new IllegalArgumentException("Server path " + str + " contains invalid characters");
        }
        if (!f44832i.contains(str)) {
            return str;
        }
        throw new IllegalArgumentException("Label " + str + " is a reserved path segment.");
    }

    public final String l(String str) {
        while (str.endsWith(fh.a.f28350w) && str.length() > 0) {
            try {
                str = str.substring(0, str.length() - 1);
            } catch (Exception e10) {
                if (e10 instanceof IllegalArgumentException) {
                    throw ((IllegalArgumentException) e10);
                }
                throw new IllegalArgumentException("Scheme and host is invalid: " + e10.getMessage(), e10);
            }
        }
        if (str.contains("://")) {
            throw new IllegalArgumentException("Server contains scheme, must only be <dnsname/ipaddress>:port, https:// will be added arbitrarily.");
        }
        URL url = new URL(DefaultWebClient.f21815w + str);
        if (url.getPath().length() != 0 && !url.getPath().equals(fh.a.f28350w)) {
            throw new IllegalArgumentException("Server contains path, must only be <dnsname/ipaddress>:port, a path of '/.well-known/est/<label>' will be added arbitrarily.");
        }
        return str;
    }
}

package xp;

import com.blankj.utilcode.util.i0;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.est.ESTException;
import org.bouncycastle.est.s;
import org.bouncycastle.util.p;

/* JADX INFO: loaded from: classes5.dex */
public class b implements org.bouncycastle.est.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f55716b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static byte[] f55717c = {13, 10};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.est.h f55718a;

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f55719a;

        public a(OutputStream outputStream) {
            this.f55719a = outputStream;
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            System.out.print(String.valueOf((char) i10));
            this.f55719a.write(i10);
        }
    }

    public b(org.bouncycastle.est.h hVar) {
        this.f55718a = hVar;
    }

    public static void d(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes());
        outputStream.write(f55717c);
    }

    @Override // org.bouncycastle.est.f
    public org.bouncycastle.est.l a(org.bouncycastle.est.j jVar) throws IOException {
        org.bouncycastle.est.l lVarB;
        int i10 = 15;
        while (true) {
            lVarB = b(jVar);
            org.bouncycastle.est.j jVarC = c(lVarB);
            if (jVarC == null || i10 - 1 <= 0) {
                break;
            }
            jVar = jVarC;
        }
        if (i10 != 0) {
            return lVarB;
        }
        throw new ESTException("Too many redirects..");
    }

    public org.bouncycastle.est.l b(org.bouncycastle.est.j jVar) throws IOException {
        s sVar = null;
        try {
            s sVarA = this.f55718a.a(jVar.f().getHost(), jVar.f().getPort());
            if (jVar.d() != null) {
                jVar = jVar.d().a(sVarA, jVar);
            }
            Set<String> setB = p.b("org.bouncycastle.debug.est");
            OutputStream aVar = (setB.contains("output") || setB.contains("all")) ? new a(sVarA.b()) : sVarA.b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(jVar.f().getPath());
            sb2.append(jVar.f().getQuery() != null ? jVar.f().getQuery() : "");
            String string = sb2.toString();
            org.bouncycastle.est.k kVar = new org.bouncycastle.est.k(jVar);
            if (!jVar.b().containsKey(HttpHeaders.CONNECTION)) {
                kVar.a(HttpHeaders.CONNECTION, "close");
            }
            URL urlF = jVar.f();
            kVar.c(HttpHeaders.HOST, urlF.getPort() > -1 ? String.format("%s:%d", urlF.getHost(), Integer.valueOf(urlF.getPort())) : urlF.getHost());
            org.bouncycastle.est.j jVarB = kVar.b();
            d(aVar, jVarB.e() + i0.f11861z + string + " HTTP/1.1");
            for (Map.Entry<String, String[]> entry : jVarB.b().entrySet()) {
                String[] value = entry.getValue();
                for (int i10 = 0; i10 != value.length; i10++) {
                    d(aVar, entry.getKey() + ": " + value[i10]);
                }
            }
            aVar.write(f55717c);
            aVar.flush();
            jVarB.g(aVar);
            aVar.flush();
            if (jVarB.c() == null) {
                return new org.bouncycastle.est.l(jVarB, sVarA);
            }
            org.bouncycastle.est.l lVarA = jVarB.c().a(jVarB, sVarA);
            if (sVarA != null && lVarA == null) {
                sVarA.close();
            }
            return lVarA;
        } catch (Throwable th2) {
            if (0 != 0) {
                sVar.close();
            }
            throw th2;
        }
    }

    public org.bouncycastle.est.j c(org.bouncycastle.est.l lVar) throws IOException {
        org.bouncycastle.est.j jVarB;
        org.bouncycastle.est.k kVarH;
        if (lVar.l() < 300 || lVar.l() > 399) {
            jVarB = null;
        } else {
            switch (lVar.l()) {
                case 301:
                case 302:
                case 303:
                case 306:
                case 307:
                    String strF = lVar.f("Location");
                    if ("".equals(strF)) {
                        throw new ESTException("Redirect status type: " + lVar.l() + " but no location header");
                    }
                    org.bouncycastle.est.k kVar = new org.bouncycastle.est.k(lVar.j());
                    if (strF.startsWith("http")) {
                        kVarH = kVar.h(new URL(strF));
                    } else {
                        URL urlF = lVar.j().f();
                        kVarH = kVar.h(new URL(urlF.getProtocol(), urlF.getHost(), urlF.getPort(), strF));
                    }
                    jVarB = kVarH.b();
                    break;
                case 304:
                case 305:
                default:
                    throw new ESTException("Client does not handle http status code: " + lVar.l());
            }
        }
        if (jVarB != null) {
            lVar.d();
        }
        return jVarB;
    }
}

package org.bouncycastle.jcajce.provider.asymmetric.x509;

import gm.f0;
import java.io.IOException;
import java.io.InputStream;
import zr.i;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0509b[] f45081a;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.asymmetric.x509.b$b, reason: collision with other inner class name */
    public class C0509b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f45082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f45083b;

        public C0509b(String str) {
            this.f45082a = lt.e.f40452a + str + "-----";
            this.f45083b = lt.e.f40453b + str + "-----";
        }

        public boolean a(String str) {
            return str.startsWith(this.f45083b);
        }

        public boolean b(String str) {
            return str.startsWith(this.f45082a);
        }
    }

    public b(String str) {
        this.f45081a = new C0509b[]{new C0509b(str), new C0509b("X509 " + str), new C0509b(i.f59664j)};
    }

    public final C0509b a(String str) {
        C0509b c0509b;
        int i10 = 0;
        while (true) {
            C0509b[] c0509bArr = this.f45081a;
            if (i10 == c0509bArr.length) {
                return null;
            }
            c0509b = c0509bArr[i10];
            if (c0509b.b(str) || c0509b.a(str)) {
                break;
            }
            i10++;
        }
        return c0509b;
    }

    public final String b(InputStream inputStream) throws IOException {
        int i10;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            i10 = inputStream.read();
            if (i10 != 13 && i10 != 10 && i10 >= 0) {
                stringBuffer.append((char) i10);
            } else if (i10 < 0 || stringBuffer.length() != 0) {
                break;
            }
        }
        if (i10 < 0) {
            if (stringBuffer.length() == 0) {
                return null;
            }
            return stringBuffer.toString();
        }
        if (i10 == 13) {
            inputStream.mark(1);
            int i11 = inputStream.read();
            if (i11 == 10) {
                inputStream.mark(1);
            }
            if (i11 > 0) {
                inputStream.reset();
            }
        }
        return stringBuffer.toString();
    }

    public f0 c(InputStream inputStream, boolean z10) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        C0509b c0509bA = null;
        while (c0509bA == null) {
            String strB = b(inputStream);
            if (strB == null) {
                break;
            }
            c0509bA = a(strB);
            if (c0509bA != null && !c0509bA.b(strB)) {
                throw new IOException("malformed PEM data: found footer where header was expected");
            }
        }
        if (c0509bA == null) {
            if (z10) {
                throw new IOException("malformed PEM data: no header found");
            }
            return null;
        }
        C0509b c0509bA2 = null;
        while (c0509bA2 == null) {
            String strB2 = b(inputStream);
            if (strB2 == null) {
                break;
            }
            c0509bA2 = a(strB2);
            if (c0509bA2 == null) {
                stringBuffer.append(strB2);
            } else if (!c0509bA.a(strB2)) {
                throw new IOException("malformed PEM data: header/footer mismatch");
            }
        }
        if (c0509bA2 == null) {
            throw new IOException("malformed PEM data: no footer found");
        }
        if (stringBuffer.length() == 0) {
            return null;
        }
        try {
            return f0.J(jt.c.c(stringBuffer.toString()));
        } catch (Exception unused) {
            throw new IOException("malformed PEM data encountered");
        }
    }
}

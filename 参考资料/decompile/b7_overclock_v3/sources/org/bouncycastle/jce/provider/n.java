package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f45492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f45493d;

    public n(String str) {
        this.f45490a = lt.e.f40452a + str + "-----";
        this.f45491b = "-----BEGIN X509 " + str + "-----";
        this.f45492c = lt.e.f40453b + str + "-----";
        this.f45493d = "-----END X509 " + str + "-----";
    }

    public final String a(InputStream inputStream) throws IOException {
        int i10;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            i10 = inputStream.read();
            if (i10 == 13 || i10 == 10 || i10 < 0) {
                if (i10 < 0 || stringBuffer.length() != 0) {
                    break;
                }
            } else if (i10 != 13) {
                stringBuffer.append((char) i10);
            }
        }
        if (i10 < 0) {
            return null;
        }
        return stringBuffer.toString();
    }

    public gm.f0 b(InputStream inputStream) throws IOException {
        String strA;
        StringBuffer stringBuffer = new StringBuffer();
        do {
            strA = a(inputStream);
            if (strA == null || strA.startsWith(this.f45490a)) {
                break;
            }
        } while (!strA.startsWith(this.f45491b));
        while (true) {
            String strA2 = a(inputStream);
            if (strA2 == null || strA2.startsWith(this.f45492c) || strA2.startsWith(this.f45493d)) {
                break;
            }
            stringBuffer.append(strA2);
        }
        if (stringBuffer.length() == 0) {
            return null;
        }
        gm.c0 c0VarN = new gm.s(jt.c.c(stringBuffer.toString())).n();
        if (c0VarN instanceof gm.f0) {
            return (gm.f0) c0VarN;
        }
        throw new IOException("malformed PEM data encountered");
    }
}

package org.bouncycastle.jcajce.util;

import gm.c0;
import gm.y;
import java.io.IOException;
import java.security.AlgorithmParameters;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class e {
    public static gm.h a(AlgorithmParameters algorithmParameters) throws IOException {
        try {
            return c0.D(algorithmParameters.getEncoded("ASN.1"));
        } catch (Exception unused) {
            return c0.D(algorithmParameters.getEncoded());
        }
    }

    public static String b(y yVar) {
        return s.f46803f4.C(yVar) ? "MD5" : on.b.f44365i.C(yVar) ? "SHA1" : kn.d.f37598f.C(yVar) ? "SHA224" : kn.d.f37592c.C(yVar) ? "SHA256" : kn.d.f37594d.C(yVar) ? "SHA384" : kn.d.f37596e.C(yVar) ? "SHA512" : tn.b.f51361c.C(yVar) ? "RIPEMD128" : tn.b.f51360b.C(yVar) ? "RIPEMD160" : tn.b.f51362d.C(yVar) ? "RIPEMD256" : qm.a.f47452b.C(yVar) ? "GOST3411" : yVar.L();
    }

    public static void c(AlgorithmParameters algorithmParameters, gm.h hVar) throws IOException {
        try {
            algorithmParameters.init(hVar.b().getEncoded(), "ASN.1");
        } catch (Exception unused) {
            algorithmParameters.init(hVar.b().getEncoded());
        }
    }
}

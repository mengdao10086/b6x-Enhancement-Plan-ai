package ws;

import gm.y;
import org.bouncycastle.crypto.m0;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static byte[] a(s sVar) {
        int iB = b(sVar);
        byte[] bArr = new byte[iB];
        if (sVar instanceof m0) {
            ((m0) sVar).f(bArr, 0, iB);
        } else {
            sVar.c(bArr, 0);
        }
        return bArr;
    }

    public static int b(s sVar) {
        boolean z10 = sVar instanceof m0;
        int iH = sVar.h();
        return z10 ? iH * 2 : iH;
    }

    public static String c(y yVar) {
        if (yVar.C(kn.d.f37592c)) {
            return "SHA256";
        }
        if (yVar.C(kn.d.f37596e)) {
            return "SHA512";
        }
        if (yVar.C(kn.d.f37612m)) {
            return "SHAKE128";
        }
        if (yVar.C(kn.d.f37614n)) {
            return "SHAKE256";
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + yVar);
    }
}

package zs;

import gm.y;
import org.bouncycastle.crypto.m0;
import org.bouncycastle.crypto.s;
import zo.e0;
import zo.h0;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static s a(y yVar) {
        if (yVar.C(kn.d.f37592c)) {
            return new e0();
        }
        if (yVar.C(kn.d.f37596e)) {
            return new h0();
        }
        if (yVar.C(kn.d.f37612m)) {
            return new j0(128);
        }
        if (yVar.C(kn.d.f37614n)) {
            return new j0(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + yVar);
    }

    public static byte[] b(s sVar) {
        int iC = c(sVar);
        byte[] bArr = new byte[iC];
        if (sVar instanceof m0) {
            ((m0) sVar).f(bArr, 0, iC);
        } else {
            sVar.c(bArr, 0);
        }
        return bArr;
    }

    public static int c(s sVar) {
        boolean z10 = sVar instanceof m0;
        int iH = sVar.h();
        return z10 ? iH * 2 : iH;
    }
}

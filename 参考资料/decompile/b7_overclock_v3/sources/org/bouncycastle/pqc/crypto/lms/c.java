package org.bouncycastle.pqc.crypto.lms;

import java.util.Arrays;
import java.util.List;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    public static class a extends u {
        public a(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i10, byte[] bArr, int i11, byte[] bArr2) {
            super(lMSigParameters, lMOtsParameters, i10, bArr, i11, bArr2);
        }

        @Override // org.bouncycastle.pqc.crypto.lms.u
        public j n() {
            throw new RuntimeException("placeholder only");
        }

        @Override // org.bouncycastle.pqc.crypto.lms.u
        public v p() {
            throw new RuntimeException("placeholder only");
        }
    }

    public static f a(d dVar) {
        int i10;
        byte[] bArr;
        int iC = dVar.c();
        u[] uVarArr = new u[iC];
        w[] wVarArr = new w[dVar.c() - 1];
        byte[] bArr2 = new byte[32];
        dVar.a().nextBytes(bArr2);
        byte[] bArr3 = new byte[16];
        dVar.a().nextBytes(bArr3);
        byte[] bArr4 = new byte[0];
        long jC = 1;
        int i11 = 0;
        while (i11 < iC) {
            if (i11 == 0) {
                uVarArr[i11] = new u(dVar.d()[i11].b(), dVar.d()[i11].a(), 0, bArr3, 1 << dVar.d()[i11].b().c(), bArr2);
                i10 = i11;
                bArr = bArr4;
            } else {
                i10 = i11;
                bArr = bArr4;
                uVarArr[i10] = new a(dVar.d()[i11].b(), dVar.d()[i11].a(), -1, bArr, 1 << dVar.d()[i11].b().c(), bArr);
            }
            jC *= (long) (1 << dVar.d()[i10].b().c());
            i11 = i10 + 1;
            bArr4 = bArr;
        }
        if (jC == 0) {
            jC = Long.MAX_VALUE;
        }
        return new f(dVar.c(), Arrays.asList(uVarArr), Arrays.asList(wVarArr), 0L, jC);
    }

    public static h b(int i10, n nVar) {
        return new h(i10 - 1, nVar.n(), m.b(nVar));
    }

    public static h c(f fVar, byte[] bArr) {
        u uVar;
        x[] xVarArr;
        int iJ = fVar.j();
        synchronized (fVar) {
            e(fVar);
            List<u> listI = fVar.i();
            List<w> listN = fVar.n();
            int i10 = iJ - 1;
            uVar = fVar.i().get(i10);
            xVarArr = new x[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i11 + 1;
                xVarArr[i11] = new x(listN.get(i11), listI.get(i12).p());
                i11 = i12;
            }
            fVar.o();
        }
        n nVarO = uVar.W().o(xVarArr);
        nVarO.update(bArr, 0, bArr.length);
        return b(iJ, nVarO);
    }

    public static void d(f fVar) {
        synchronized (fVar) {
            e(fVar);
            fVar.o();
            fVar.i().get(fVar.j() - 1).r();
        }
    }

    public static void e(f fVar) {
        synchronized (fVar) {
            if (fVar.e() >= fVar.f()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("hss private key");
                sb2.append(fVar.p() ? " shard" : "");
                sb2.append(" is exhausted");
                throw new ExhaustedPrivateKeyException(sb2.toString());
            }
            int iJ = fVar.j();
            List<u> listI = fVar.i();
            int i10 = iJ;
            while (true) {
                int i11 = i10 - 1;
                if (listI.get(i11).j() != (1 << listI.get(i11).q().c())) {
                    while (i10 < iJ) {
                        fVar.r(i10);
                        i10++;
                    }
                } else {
                    if (i11 == 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("hss private key");
                        sb3.append(fVar.p() ? " shard" : "");
                        sb3.append(" is exhausted the maximum limit for this HSS private key");
                        throw new ExhaustedPrivateKeyException(sb3.toString());
                    }
                    i10 = i11;
                }
            }
        }
    }

    public static boolean f(g gVar, h hVar, byte[] bArr) {
        int iD = hVar.d();
        int i10 = iD + 1;
        if (i10 != gVar.e()) {
            return false;
        }
        w[] wVarArr = new w[i10];
        v[] vVarArr = new v[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            wVarArr[i11] = hVar.c()[i11].b();
            vVarArr[i11] = hVar.c()[i11].a();
        }
        wVarArr[iD] = hVar.b();
        v vVarF = gVar.f();
        for (int i12 = 0; i12 < iD; i12++) {
            if (!m.e(vVarF, wVarArr[i12], vVarArr[i12].toByteArray())) {
                return false;
            }
            try {
                vVarF = vVarArr[i12];
            } catch (Exception e10) {
                throw new IllegalStateException(e10.getMessage(), e10);
            }
        }
        return m.e(vVarF, wVarArr[iD], bArr);
    }
}

package org.bouncycastle.crypto.util;

import cp.o0;
import cp.q0;
import cp.t;
import gm.c0;
import gm.u;
import gm.y;
import gm.z;
import java.io.OutputStream;
import kg.c;
import np.a2;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.k0;
import pn.s;
import pn.v;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final short[] f44729a = {93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, c.a.Y4, 58, c.a.V4, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, c.a.Z4, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, c.a.X4, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, c.a.W4, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, c.a.U4, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, c.a.T4, 19, 236, c.a.f37346a5, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, c.a.S4, 24, 210, 205, 95, 50, 136, 14, 53, 253};

    public static jp.a a(y yVar) {
        if (kn.d.C.C(yVar) || kn.d.K.C(yVar) || kn.d.S.C(yVar)) {
            return new jp.n(new cp.a());
        }
        if (kn.d.D.C(yVar) || kn.d.L.C(yVar) || kn.d.T.C(yVar)) {
            return new jp.d(new cp.a());
        }
        throw new IllegalArgumentException("cannot recognise cipher: " + yVar);
    }

    public static org.bouncycastle.crypto.h b(y yVar) throws IllegalArgumentException {
        jp.c cVar;
        if (kn.d.f37625y.C(yVar) || kn.d.G.C(yVar) || kn.d.O.C(yVar)) {
            cVar = new jp.c(new cp.a());
        } else if (s.Z3.C(yVar)) {
            cVar = new jp.c(new t());
        } else if (on.b.f44361e.C(yVar)) {
            cVar = new jp.c(new cp.s());
        } else if (s.f46788a4.C(yVar)) {
            cVar = new jp.c(new o0());
        } else {
            if (!in.c.f32565u.C(yVar)) {
                throw new IllegalArgumentException("cannot recognise cipher: " + yVar);
            }
            cVar = new jp.c(new cp.j());
        }
        return new mp.e(cVar, new mp.d());
    }

    public static Object c(boolean z10, org.bouncycastle.crypto.k kVar, zn.b bVar) throws IllegalArgumentException {
        jp.a aVarA;
        np.a aVar;
        v1 v1Var;
        y yVarX = bVar.x();
        if (yVarX.C(s.f46791b4)) {
            q0 q0Var = new q0();
            q0Var.a(z10, kVar);
            return q0Var;
        }
        if (yVarX.C(kn.d.C) || yVarX.C(kn.d.K) || yVarX.C(kn.d.S)) {
            aVarA = a(bVar.x());
            cq.c cVarY = cq.c.y(bVar.A());
            if (!(kVar instanceof n1)) {
                throw new IllegalArgumentException("key data must be accessible for GCM operation");
            }
            aVar = new np.a((n1) kVar, cVarY.x() * 8, cVarY.z());
        } else {
            if (!yVarX.C(kn.d.D) && !yVarX.C(kn.d.L) && !yVarX.C(kn.d.T)) {
                org.bouncycastle.crypto.h hVarB = b(bVar.x());
                c0 c0VarB = bVar.A().b();
                if (c0VarB != null && !(c0VarB instanceof u)) {
                    if (yVarX.C(s.Z3) || yVarX.C(a.f44724a) || yVarX.C(kn.d.f37625y) || yVarX.C(kn.d.G) || yVarX.C(kn.d.O) || yVarX.C(mn.a.f41443a) || yVarX.C(mn.a.f41444b) || yVarX.C(mn.a.f41445c) || yVarX.C(gn.a.f29838a) || yVarX.C(on.b.f44361e)) {
                        v1Var = new v1(kVar, z.I(c0VarB).J());
                    } else if (yVarX.C(a.f44725b)) {
                        v1Var = new v1(kVar, in.a.y(c0VarB).x());
                    } else {
                        if (!yVarX.C(s.f46788a4)) {
                            throw new IllegalArgumentException("cannot match parameters");
                        }
                        v vVarY = v.y(c0VarB);
                        v1Var = new v1(new a2(((n1) kVar).a(), f44729a[vVarY.z().intValue()]), vVarY.x());
                    }
                    hVarB.f(z10, v1Var);
                } else if (yVarX.C(s.Z3) || yVarX.C(a.f44724a) || yVarX.C(a.f44725b)) {
                    hVarB.f(z10, new v1(kVar, new byte[8]));
                } else {
                    hVarB.f(z10, kVar);
                }
                return hVarB;
            }
            aVarA = a(bVar.x());
            cq.a aVarY = cq.a.y(bVar.A());
            if (!(kVar instanceof n1)) {
                throw new IllegalArgumentException("key data must be accessible for GCM operation");
            }
            aVar = new np.a((n1) kVar, aVarY.x() * 8, aVarY.z());
        }
        aVarA.a(z10, aVar);
        return aVarA;
    }

    public static gp.b d(OutputStream outputStream, Object obj) {
        if (obj instanceof org.bouncycastle.crypto.h) {
            return new gp.b(outputStream, (org.bouncycastle.crypto.h) obj);
        }
        if (obj instanceof k0) {
            return new gp.b(outputStream, (k0) obj);
        }
        if (obj instanceof jp.a) {
            return new gp.b(outputStream, (jp.a) obj);
        }
        throw new IllegalArgumentException("unknown cipher object: " + obj);
    }
}

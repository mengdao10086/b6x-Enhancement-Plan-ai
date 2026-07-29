package org.bouncycastle.crypto.util;

import gm.d2;
import gm.f2;
import gm.y;
import java.security.SecureRandom;
import kg.c;
import pn.s;
import pn.v;
import so.a0;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f44724a = new y(a0.f50037f).O();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f44725b = new y(a0.f50038g).O();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final short[] f44726c = {189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, c.a.V4, 44, 195, 39, 95, c.a.Z4, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, c.a.U4, 23, 245, c.a.T4, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, c.a.Y4, 3, 121, 137, 98, 198, 215, 192, 210, 124, c.a.X4, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, c.a.S4, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, c.a.f37346a5, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, c.a.W4, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};

    public static zn.b a(y yVar, int i10, SecureRandom secureRandom) throws IllegalArgumentException {
        if (yVar.C(kn.d.f37625y) || yVar.C(kn.d.G) || yVar.C(kn.d.O) || yVar.C(mn.a.f41443a) || yVar.C(mn.a.f41444b) || yVar.C(mn.a.f41445c) || yVar.C(gn.a.f29838a)) {
            byte[] bArr = new byte[16];
            secureRandom.nextBytes(bArr);
            return new zn.b(yVar, new f2(bArr));
        }
        if (yVar.C(kn.d.C) || yVar.C(kn.d.K) || yVar.C(kn.d.S)) {
            byte[] bArr2 = new byte[12];
            secureRandom.nextBytes(bArr2);
            return new zn.b(yVar, new cq.c(bArr2, 16));
        }
        if (yVar.C(kn.d.D) || yVar.C(kn.d.L) || yVar.C(kn.d.T)) {
            byte[] bArr3 = new byte[8];
            secureRandom.nextBytes(bArr3);
            return new zn.b(yVar, new cq.a(bArr3, 16));
        }
        if (yVar.C(s.Z3) || yVar.C(f44724a) || yVar.C(on.b.f44361e)) {
            byte[] bArr4 = new byte[8];
            secureRandom.nextBytes(bArr4);
            return new zn.b(yVar, new f2(bArr4));
        }
        if (yVar.C(f44725b)) {
            byte[] bArr5 = new byte[8];
            secureRandom.nextBytes(bArr5);
            return new zn.b(yVar, new in.a(bArr5, i10));
        }
        if (yVar.C(s.f46791b4)) {
            return new zn.b(yVar, d2.f29657b);
        }
        if (!yVar.C(s.f46788a4)) {
            throw new IllegalArgumentException("unable to match algorithm");
        }
        byte[] bArr6 = new byte[8];
        secureRandom.nextBytes(bArr6);
        return new zn.b(yVar, new v(f44726c[128], bArr6));
    }
}

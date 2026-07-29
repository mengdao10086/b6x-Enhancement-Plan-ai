package ir;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f35629a = "bc_wnaf";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f35631c = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f35630b = {13, 41, 121, 337, 897, 2305};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f35632d = new byte[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f35633e = new int[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i[] f35634f = new i[0];

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f35635a;

        public a(int i10) {
            this.f35635a = i10;
        }

        @Override // ir.p
        public q a(q qVar) {
            a0 a0Var = qVar instanceof a0 ? (a0) qVar : null;
            if (a0Var != null && a0Var.b() == this.f35635a) {
                a0Var.l(0);
                return a0Var;
            }
            a0 a0Var2 = new a0();
            a0Var2.l(0);
            a0Var2.i(this.f35635a);
            if (a0Var != null) {
                a0Var2.j(a0Var.c());
                a0Var2.k(a0Var.d());
                a0Var2.m(a0Var.f());
                a0Var2.n(a0Var.g());
            }
            return a0Var2;
        }
    }

    public static class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f35636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f35637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f35638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f35639d;

        public b(int i10, boolean z10, i iVar, e eVar) {
            this.f35636a = i10;
            this.f35637b = z10;
            this.f35638c = iVar;
            this.f35639d = eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00ef A[PHI: r14
  0x00ef: PHI (r14v6 ir.i) = (r14v4 ir.i), (r14v9 ir.i), (r14v9 ir.i), (r14v9 ir.i), (r14v9 ir.i) binds: [B:28:0x0091, B:30:0x009d, B:32:0x00a5, B:34:0x00af, B:40:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0117 A[LOOP:1: B:57:0x0115->B:58:0x0117, LOOP_END] */
        @Override // ir.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.q a(ir.q r14) {
            /*
                Method dump skipped, instruction units count: 303
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.b0.b.a(ir.q):ir.q");
        }

        public final boolean b(a0 a0Var, int i10, int i11, boolean z10) {
            return a0Var != null && a0Var.g() >= Math.max(a0Var.b(), i10) && c(a0Var.c(), i11) && (!z10 || c(a0Var.d(), i11));
        }

        public final boolean c(i[] iVarArr, int i10) {
            return iVarArr != null && iVarArr.length >= i10;
        }
    }

    public static class c implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f35640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f35641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f35642c;

        public c(a0 a0Var, boolean z10, j jVar) {
            this.f35640a = a0Var;
            this.f35641b = z10;
            this.f35642c = jVar;
        }

        @Override // ir.p
        public q a(q qVar) {
            a0 a0Var = qVar instanceof a0 ? (a0) qVar : null;
            int iG = this.f35640a.g();
            if (b(a0Var, iG, this.f35640a.c().length, this.f35641b)) {
                a0Var.a();
                return a0Var;
            }
            a0 a0Var2 = new a0();
            a0Var2.l(this.f35640a.e());
            i iVarF = this.f35640a.f();
            if (iVarF != null) {
                a0Var2.m(this.f35642c.a(iVarF));
            }
            i[] iVarArrC = this.f35640a.c();
            int length = iVarArrC.length;
            i[] iVarArr = new i[length];
            for (int i10 = 0; i10 < iVarArrC.length; i10++) {
                iVarArr[i10] = this.f35642c.a(iVarArrC[i10]);
            }
            a0Var2.j(iVarArr);
            a0Var2.n(iG);
            if (this.f35641b) {
                i[] iVarArr2 = new i[length];
                for (int i11 = 0; i11 < length; i11++) {
                    iVarArr2[i11] = iVarArr[i11].A();
                }
                a0Var2.k(iVarArr2);
            }
            return a0Var2;
        }

        public final boolean b(a0 a0Var, int i10, int i11, boolean z10) {
            return a0Var != null && a0Var.g() >= i10 && c(a0Var.c(), i11) && (!z10 || c(a0Var.d(), i11));
        }

        public final boolean c(i[] iVarArr, int i10) {
            return iVarArr != null && iVarArr.length >= i10;
        }
    }

    public static void c(i iVar) {
        e eVarI = iVar.i();
        if (eVarI == null) {
            return;
        }
        BigInteger bigIntegerY = eVarI.y();
        eVarI.E(iVar, f35629a, new a(Math.min(16, l(bigIntegerY == null ? eVarI.v() + 1 : bigIntegerY.bitLength()) + 3)));
    }

    public static int[] d(BigInteger bigInteger) {
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (bigInteger.signum() == 0) {
            return f35633e;
        }
        BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
        int iBitLength = bigIntegerAdd.bitLength();
        int i10 = iBitLength >> 1;
        int[] iArr = new int[i10];
        BigInteger bigIntegerXor = bigIntegerAdd.xor(bigInteger);
        int i11 = iBitLength - 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1;
        while (i14 < i11) {
            if (bigIntegerXor.testBit(i14)) {
                iArr[i12] = i13 | ((bigInteger.testBit(i14) ? -1 : 1) << 16);
                i14++;
                i12++;
                i13 = 1;
            } else {
                i13++;
            }
            i14++;
        }
        int i15 = i12 + 1;
        iArr[i12] = 65536 | i13;
        return i10 > i15 ? t(iArr, i15) : iArr;
    }

    public static int[] e(int i10, BigInteger bigInteger) {
        if (i10 == 2) {
            return d(bigInteger);
        }
        if (i10 < 2 || i10 > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        }
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (bigInteger.signum() == 0) {
            return f35633e;
        }
        int iBitLength = (bigInteger.bitLength() / i10) + 1;
        int[] iArr = new int[iBitLength];
        int i11 = 1 << i10;
        int i12 = i11 - 1;
        int i13 = i11 >>> 1;
        int i14 = 0;
        int i15 = 0;
        boolean z10 = false;
        while (i14 <= bigInteger.bitLength()) {
            if (bigInteger.testBit(i14) == z10) {
                i14++;
            } else {
                bigInteger = bigInteger.shiftRight(i14);
                int iIntValue = bigInteger.intValue() & i12;
                if (z10) {
                    iIntValue++;
                }
                z10 = (iIntValue & i13) != 0;
                if (z10) {
                    iIntValue -= i11;
                }
                if (i15 > 0) {
                    i14--;
                }
                iArr[i15] = i14 | (iIntValue << 16);
                i14 = i10;
                i15++;
            }
        }
        return iBitLength > i15 ? t(iArr, i15) : iArr;
    }

    public static byte[] f(BigInteger bigInteger, BigInteger bigInteger2) {
        int iMax = Math.max(bigInteger.bitLength(), bigInteger2.bitLength()) + 1;
        byte[] bArr = new byte[iMax];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if ((i10 | i11) == 0 && bigInteger.bitLength() <= i12 && bigInteger2.bitLength() <= i12) {
                break;
            }
            int iIntValue = ((bigInteger.intValue() >>> i12) + i10) & 7;
            int iIntValue2 = ((bigInteger2.intValue() >>> i12) + i11) & 7;
            int i14 = iIntValue & 1;
            if (i14 != 0) {
                i14 -= iIntValue & 2;
                if (iIntValue + i14 == 4 && (iIntValue2 & 3) == 2) {
                    i14 = -i14;
                }
            }
            int i15 = iIntValue2 & 1;
            if (i15 != 0) {
                i15 -= iIntValue2 & 2;
                if (iIntValue2 + i15 == 4 && (iIntValue & 3) == 2) {
                    i15 = -i15;
                }
            }
            if ((i10 << 1) == i14 + 1) {
                i10 ^= 1;
            }
            if ((i11 << 1) == i15 + 1) {
                i11 ^= 1;
            }
            i12++;
            if (i12 == 30) {
                bigInteger = bigInteger.shiftRight(30);
                bigInteger2 = bigInteger2.shiftRight(30);
                i12 = 0;
            }
            bArr[i13] = (byte) ((i14 << 4) | (i15 & 15));
            i13++;
        }
        return iMax > i13 ? s(bArr, i13) : bArr;
    }

    public static byte[] g(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return f35632d;
        }
        BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
        int iBitLength = bigIntegerAdd.bitLength() - 1;
        byte[] bArr = new byte[iBitLength];
        BigInteger bigIntegerXor = bigIntegerAdd.xor(bigInteger);
        int i10 = 1;
        while (i10 < iBitLength) {
            if (bigIntegerXor.testBit(i10)) {
                bArr[i10 - 1] = (byte) (bigInteger.testBit(i10) ? -1 : 1);
                i10++;
            }
            i10++;
        }
        bArr[iBitLength - 1] = 1;
        return bArr;
    }

    public static byte[] h(int i10, BigInteger bigInteger) {
        if (i10 == 2) {
            return g(bigInteger);
        }
        if (i10 < 2 || i10 > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        }
        if (bigInteger.signum() == 0) {
            return f35632d;
        }
        int iBitLength = bigInteger.bitLength() + 1;
        byte[] bArr = new byte[iBitLength];
        int i11 = 1 << i10;
        int i12 = i11 - 1;
        int i13 = i11 >>> 1;
        int i14 = 0;
        int i15 = 0;
        boolean z10 = false;
        while (i14 <= bigInteger.bitLength()) {
            if (bigInteger.testBit(i14) == z10) {
                i14++;
            } else {
                bigInteger = bigInteger.shiftRight(i14);
                int iIntValue = bigInteger.intValue() & i12;
                if (z10) {
                    iIntValue++;
                }
                z10 = (iIntValue & i13) != 0;
                if (z10) {
                    iIntValue -= i11;
                }
                if (i15 > 0) {
                    i14--;
                }
                int i16 = i15 + i14;
                bArr[i16] = (byte) iIntValue;
                i15 = i16 + 1;
                i14 = i10;
            }
        }
        return iBitLength > i15 ? s(bArr, i15) : bArr;
    }

    public static int i(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static a0 j(i iVar) {
        return k(iVar.i().z(iVar, f35629a));
    }

    public static a0 k(q qVar) {
        if (qVar instanceof a0) {
            return (a0) qVar;
        }
        return null;
    }

    public static int l(int i10) {
        return o(i10, f35630b, 16);
    }

    public static int m(int i10, int i11) {
        return o(i10, f35630b, i11);
    }

    public static int n(int i10, int[] iArr) {
        return o(i10, iArr, 16);
    }

    public static int o(int i10, int[] iArr, int i11) {
        int i12 = 0;
        while (i12 < iArr.length && i10 >= iArr[i12]) {
            i12++;
        }
        return Math.max(2, Math.min(i11, i12 + 2));
    }

    public static a0 p(i iVar, int i10, boolean z10) {
        e eVarI = iVar.i();
        return (a0) eVarI.E(iVar, f35629a, new b(i10, z10, iVar, eVarI));
    }

    public static a0 q(i iVar, j jVar, a0 a0Var, boolean z10) {
        return (a0) iVar.i().E(iVar, f35629a, new c(a0Var, z10, jVar));
    }

    public static i[] r(i[] iVarArr, int i10) {
        i[] iVarArr2 = new i[i10];
        System.arraycopy(iVarArr, 0, iVarArr2, 0, iVarArr.length);
        return iVarArr2;
    }

    public static byte[] s(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        return bArr2;
    }

    public static int[] t(int[] iArr, int i10) {
        int[] iArr2 = new int[i10];
        System.arraycopy(iArr, 0, iArr2, 0, i10);
        return iArr2;
    }
}

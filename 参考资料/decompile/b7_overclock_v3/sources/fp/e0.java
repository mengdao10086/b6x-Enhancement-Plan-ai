package fp;

import com.flydigi.sdk.waspwing.WaspWingInfo;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import no.nordicsemi.android.dfu.DfuBaseService;
import np.r1;
import np.s1;
import np.t1;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
public class e0 implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int[] f28633h = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, WaspWingInfo.COLD_LEVEL_STANDARD_B7, rc.c.f48463k0, 157, 163, 167, WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, 179, 181, 191, s0.c.f49294u, 197, 199, hr.a.f31427a, 223, 227, 229, 233, 239, 241, mb.e.f41067u1, 257, 263, 269, 271, 277, 281, DfuBaseService.NOTIFICATION_ID, 293, 307, 311, 313, w.a.f53656r, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, gg.b.f29477q, 397, 401, 409, 419, 421, 431, 433, 439, rb.a0.f47912q, 449, 457, 461, 463, 467, 479, 487, 491, 499, w.g.f53772k, 509, gg.b.f29450j0, gg.b.f29462m0, gg.b.K0, gg.b.T0, gg.b.f29439g1};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f28634i = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r1 f28635g;

    public static Vector c(int i10) {
        Vector vector = new Vector(i10);
        for (int i11 = 0; i11 != i10; i11++) {
            vector.addElement(BigInteger.valueOf(f28633h[i11]));
        }
        return vector;
    }

    public static BigInteger d(int i10, int i11, SecureRandom secureRandom) {
        BigInteger bigIntegerH;
        do {
            bigIntegerH = org.bouncycastle.util.b.h(i10, i11, secureRandom);
        } while (bigIntegerH.bitLength() != i10);
        return bigIntegerH;
    }

    public static int e(SecureRandom secureRandom, int i10) {
        int iNextInt;
        int i11;
        if (((-i10) & i10) == i10) {
            return (int) ((((long) i10) * ((long) (secureRandom.nextInt() & Integer.MAX_VALUE))) >> 31);
        }
        do {
            iNextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i11 = iNextInt % i10;
        } while ((iNextInt - i11) + (i10 - 1) < 0);
        return i11;
    }

    public static Vector f(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i10 = 0; i10 < vector.size(); i10++) {
            vector3.addElement(vector.elementAt(i10));
        }
        vector2.addElement(vector3.elementAt(0));
        while (true) {
            vector3.removeElementAt(0);
            if (vector3.size() == 0) {
                return vector2;
            }
            vector2.insertElementAt(vector3.elementAt(0), e(secureRandom, vector2.size() + 1));
        }
    }

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28635g = (r1) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        long j10;
        BigInteger bigIntegerD;
        BigInteger bigIntegerAdd;
        BigInteger bigIntegerD2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigIntegerAdd2;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        BigInteger bigIntegerMod;
        boolean z10;
        BigInteger bigInteger7;
        BigInteger bigInteger8;
        int i10;
        PrintStream printStream;
        StringBuilder sb2;
        String str;
        long j11;
        BigInteger bigIntegerH;
        int i11;
        int iB = this.f28635g.b();
        SecureRandom secureRandomA = this.f28635g.a();
        int iC = this.f28635g.c();
        boolean zE = this.f28635g.e();
        if (zE) {
            System.out.println("Fetching first " + this.f28635g.d() + " primes.");
        }
        Vector vectorF = f(c(this.f28635g.d()), secureRandomA);
        BigInteger bigIntegerMultiply = f28634i;
        BigInteger bigIntegerMultiply2 = bigIntegerMultiply;
        for (int i12 = 0; i12 < vectorF.size() / 2; i12++) {
            bigIntegerMultiply2 = bigIntegerMultiply2.multiply((BigInteger) vectorF.elementAt(i12));
        }
        for (int size = vectorF.size() / 2; size < vectorF.size(); size++) {
            bigIntegerMultiply = bigIntegerMultiply.multiply((BigInteger) vectorF.elementAt(size));
        }
        BigInteger bigIntegerMultiply3 = bigIntegerMultiply2.multiply(bigIntegerMultiply);
        int iBitLength = (((iB - bigIntegerMultiply3.bitLength()) - 48) / 2) + 1;
        BigInteger bigIntegerD3 = d(iBitLength, iC, secureRandomA);
        BigInteger bigIntegerD4 = d(iBitLength, iC, secureRandomA);
        if (zE) {
            System.out.println("generating p and q");
        }
        BigInteger bigIntegerShiftLeft = bigIntegerD3.multiply(bigIntegerMultiply2).shiftLeft(1);
        BigInteger bigIntegerShiftLeft2 = bigIntegerD4.multiply(bigIntegerMultiply).shiftLeft(1);
        long j12 = 0;
        while (true) {
            j10 = j12 + 1;
            bigIntegerD = d(24, iC, secureRandomA);
            bigIntegerAdd = bigIntegerD.multiply(bigIntegerShiftLeft).add(f28634i);
            if (bigIntegerAdd.isProbablePrime(iC)) {
                while (true) {
                    do {
                        bigIntegerD2 = d(24, iC, secureRandomA);
                    } while (bigIntegerD.equals(bigIntegerD2));
                    BigInteger bigIntegerMultiply4 = bigIntegerD2.multiply(bigIntegerShiftLeft2);
                    bigInteger = bigIntegerShiftLeft2;
                    bigInteger2 = f28634i;
                    bigIntegerAdd2 = bigIntegerMultiply4.add(bigInteger2);
                    if (bigIntegerAdd2.isProbablePrime(iC)) {
                        break;
                    }
                    bigIntegerShiftLeft2 = bigInteger;
                }
                bigInteger3 = bigIntegerShiftLeft;
                if (!bigIntegerMultiply3.gcd(bigIntegerD.multiply(bigIntegerD2)).equals(bigInteger2)) {
                    continue;
                } else {
                    if (bigIntegerAdd.multiply(bigIntegerAdd2).bitLength() >= iB) {
                        break;
                    }
                    if (zE) {
                        System.out.println("key size too small. Should be " + iB + " but is actually " + bigIntegerAdd.multiply(bigIntegerAdd2).bitLength());
                    }
                }
            } else {
                bigInteger = bigIntegerShiftLeft2;
                bigInteger3 = bigIntegerShiftLeft;
            }
            j12 = j10;
            bigIntegerShiftLeft2 = bigInteger;
            bigIntegerShiftLeft = bigInteger3;
        }
        BigInteger bigInteger9 = bigIntegerD4;
        if (zE) {
            bigInteger4 = bigIntegerD3;
            System.out.println("needed " + j10 + " tries to generate p and q.");
        } else {
            bigInteger4 = bigIntegerD3;
        }
        BigInteger bigIntegerMultiply5 = bigIntegerAdd.multiply(bigIntegerAdd2);
        BigInteger bigIntegerMultiply6 = bigIntegerAdd.subtract(bigInteger2).multiply(bigIntegerAdd2.subtract(bigInteger2));
        if (zE) {
            System.out.println("generating g");
        }
        long j13 = 0;
        while (true) {
            Vector vector = new Vector();
            bigInteger5 = bigIntegerAdd;
            bigInteger6 = bigIntegerAdd2;
            int i13 = 0;
            while (i13 != vectorF.size()) {
                BigInteger bigIntegerDivide = bigIntegerMultiply6.divide((BigInteger) vectorF.elementAt(i13));
                while (true) {
                    j11 = j13 + 1;
                    bigIntegerH = org.bouncycastle.util.b.h(iB, iC, secureRandomA);
                    i11 = iB;
                    if (bigIntegerH.modPow(bigIntegerDivide, bigIntegerMultiply5).equals(f28634i)) {
                        j13 = j11;
                        iB = i11;
                    }
                }
                vector.addElement(bigIntegerH);
                i13++;
                j13 = j11;
                iB = i11;
            }
            int i14 = iB;
            bigIntegerMod = f28634i;
            int i15 = 0;
            while (i15 < vectorF.size()) {
                bigIntegerMod = bigIntegerMod.multiply(((BigInteger) vector.elementAt(i15)).modPow(bigIntegerMultiply3.divide((BigInteger) vectorF.elementAt(i15)), bigIntegerMultiply5)).mod(bigIntegerMultiply5);
                i15++;
                secureRandomA = secureRandomA;
            }
            SecureRandom secureRandom = secureRandomA;
            int i16 = 0;
            while (true) {
                if (i16 >= vectorF.size()) {
                    z10 = false;
                    break;
                }
                if (bigIntegerMod.modPow(bigIntegerMultiply6.divide((BigInteger) vectorF.elementAt(i16)), bigIntegerMultiply5).equals(f28634i)) {
                    if (zE) {
                        System.out.println("g has order phi(n)/" + vectorF.elementAt(i16) + "\n g: " + bigIntegerMod);
                    }
                    z10 = true;
                } else {
                    i16++;
                }
            }
            if (z10) {
                bigInteger8 = bigInteger9;
                bigInteger7 = bigInteger4;
                i10 = iC;
            } else {
                BigInteger bigIntegerModPow = bigIntegerMod.modPow(bigIntegerMultiply6.divide(BigInteger.valueOf(4L)), bigIntegerMultiply5);
                BigInteger bigInteger10 = f28634i;
                if (bigIntegerModPow.equals(bigInteger10)) {
                    if (zE) {
                        printStream = System.out;
                        sb2 = new StringBuilder();
                        str = "g has order phi(n)/4\n g:";
                        sb2.append(str);
                        sb2.append(bigIntegerMod);
                        printStream.println(sb2.toString());
                    }
                    bigInteger8 = bigInteger9;
                    bigInteger7 = bigInteger4;
                    i10 = iC;
                } else if (bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerD), bigIntegerMultiply5).equals(bigInteger10)) {
                    if (zE) {
                        printStream = System.out;
                        sb2 = new StringBuilder();
                        str = "g has order phi(n)/p'\n g: ";
                        sb2.append(str);
                        sb2.append(bigIntegerMod);
                        printStream.println(sb2.toString());
                    }
                    bigInteger8 = bigInteger9;
                    bigInteger7 = bigInteger4;
                    i10 = iC;
                } else if (bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerD2), bigIntegerMultiply5).equals(bigInteger10)) {
                    if (zE) {
                        printStream = System.out;
                        sb2 = new StringBuilder();
                        str = "g has order phi(n)/q'\n g: ";
                        sb2.append(str);
                        sb2.append(bigIntegerMod);
                        printStream.println(sb2.toString());
                    }
                    bigInteger8 = bigInteger9;
                    bigInteger7 = bigInteger4;
                    i10 = iC;
                } else {
                    bigInteger7 = bigInteger4;
                    if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger7), bigIntegerMultiply5).equals(bigInteger10)) {
                        bigInteger8 = bigInteger9;
                        if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger8), bigIntegerMultiply5).equals(bigInteger10)) {
                            break;
                        }
                        if (zE) {
                            PrintStream printStream2 = System.out;
                            StringBuilder sb3 = new StringBuilder();
                            i10 = iC;
                            sb3.append("g has order phi(n)/b\n g: ");
                            sb3.append(bigIntegerMod);
                            printStream2.println(sb3.toString());
                        }
                    } else {
                        if (zE) {
                            System.out.println("g has order phi(n)/a\n g: " + bigIntegerMod);
                        }
                        bigInteger8 = bigInteger9;
                    }
                    i10 = iC;
                }
            }
            bigInteger4 = bigInteger7;
            iC = i10;
            bigIntegerAdd2 = bigInteger6;
            bigIntegerAdd = bigInteger5;
            iB = i14;
            secureRandomA = secureRandom;
            bigInteger9 = bigInteger8;
        }
        if (zE) {
            System.out.println("needed " + j13 + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            System.out.println("smallPrimes: " + vectorF);
            System.out.println("sigma:...... " + bigIntegerMultiply3 + " (" + bigIntegerMultiply3.bitLength() + " bits)");
            PrintStream printStream3 = System.out;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("a:.......... ");
            sb4.append(bigInteger7);
            printStream3.println(sb4.toString());
            System.out.println("b:.......... " + bigInteger8);
            System.out.println("p':......... " + bigIntegerD);
            System.out.println("q':......... " + bigIntegerD2);
            System.out.println("p:.......... " + bigInteger5);
            System.out.println("q:.......... " + bigInteger6);
            System.out.println("n:.......... " + bigIntegerMultiply5);
            System.out.println("phi(n):..... " + bigIntegerMultiply6);
            System.out.println("g:.......... " + bigIntegerMod);
            System.out.println();
        }
        return new org.bouncycastle.crypto.c((np.c) new s1(false, bigIntegerMod, bigIntegerMultiply5, bigIntegerMultiply3.bitLength()), (np.c) new t1(bigIntegerMod, bigIntegerMultiply5, bigIntegerMultiply3.bitLength(), vectorF, bigIntegerMultiply6));
    }
}

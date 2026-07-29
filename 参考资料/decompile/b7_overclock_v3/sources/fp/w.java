package fp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.b1;
import np.e1;

/* JADX INFO: loaded from: classes5.dex */
public class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f28696d = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f28697e = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f28700c;

    public b1 a() {
        BigInteger[] bigIntegerArr = new BigInteger[2];
        if (this.f28699b == 1) {
            int iNextInt = this.f28700c.nextInt();
            int iNextInt2 = this.f28700c.nextInt();
            int i10 = this.f28698a;
            if (i10 == 512) {
                c(iNextInt, iNextInt2, bigIntegerArr, 512);
            } else {
                if (i10 != 1024) {
                    throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
                }
                e(iNextInt, iNextInt2, bigIntegerArr);
            }
            BigInteger bigInteger = bigIntegerArr[0];
            BigInteger bigInteger2 = bigIntegerArr[1];
            return new b1(bigInteger, bigInteger2, g(bigInteger, bigInteger2), new e1(iNextInt, iNextInt2));
        }
        long jNextLong = this.f28700c.nextLong();
        long jNextLong2 = this.f28700c.nextLong();
        int i11 = this.f28698a;
        if (i11 == 512) {
            d(jNextLong, jNextLong2, bigIntegerArr, 512);
        } else {
            if (i11 != 1024) {
                throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
            }
            f(jNextLong, jNextLong2, bigIntegerArr);
        }
        BigInteger bigInteger3 = bigIntegerArr[0];
        BigInteger bigInteger4 = bigIntegerArr[1];
        return new b1(bigInteger3, bigInteger4, g(bigInteger3, bigInteger4), new e1(jNextLong, jNextLong2));
    }

    public void b(int i10, int i11, SecureRandom secureRandom) {
        this.f28698a = i10;
        this.f28699b = i11;
        this.f28700c = secureRandom;
    }

    public final int c(int i10, int i11, BigInteger[] bigIntegerArr, int i12) {
        BigInteger bigInteger;
        BigInteger[] bigIntegerArr2;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        int i13;
        int i14;
        int iNextInt = i10;
        while (true) {
            if (iNextInt >= 0 && iNextInt <= 65536) {
                break;
            }
            iNextInt = this.f28700c.nextInt() / 32768;
        }
        int iNextInt2 = i11;
        while (true) {
            if (iNextInt2 >= 0 && iNextInt2 <= 65536 && iNextInt2 / 2 != 0) {
                break;
            }
            iNextInt2 = (this.f28700c.nextInt() / 32768) + 1;
        }
        BigInteger bigInteger4 = new BigInteger(Integer.toString(iNextInt2));
        BigInteger bigInteger5 = new BigInteger("19381");
        BigInteger bigInteger6 = new BigInteger(Integer.toString(iNextInt));
        int i15 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger6};
        int[] iArr = {i12};
        int i16 = 0;
        int i17 = 0;
        while (iArr[i16] >= 17) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i17 = i16 + 1;
            iArr[i17] = iArr[i16] / 2;
            i16 = i17;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[i17 + 1];
        int i18 = 16;
        bigIntegerArr4[i17] = new BigInteger("8003", 16);
        int i19 = i17 - 1;
        int i20 = 0;
        while (true) {
            if (i20 >= i17) {
                bigInteger = bigIntegerArr3[0];
                break;
            }
            int i21 = iArr[i19] / i18;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i15, bigIntegerArr5, i15, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[i21 + 1];
                System.arraycopy(bigIntegerArr5, i15, bigIntegerArr2, i15, length2);
                int i22 = 0;
                while (i22 < i21) {
                    int i23 = i22 + 1;
                    bigIntegerArr2[i23] = bigIntegerArr2[i22].multiply(bigInteger5).add(bigInteger4).mod(f28697e.pow(i18));
                    i22 = i23;
                }
                BigInteger bigInteger7 = new BigInteger("0");
                for (int i24 = 0; i24 < i21; i24++) {
                    bigInteger7 = bigInteger7.add(bigIntegerArr2[i24].multiply(f28697e.pow(i24 * 16)));
                }
                bigIntegerArr2[i15] = bigIntegerArr2[i21];
                BigInteger bigInteger8 = f28697e;
                int i25 = i19 + 1;
                BigInteger bigIntegerAdd = bigInteger8.pow(iArr[i19] - 1).divide(bigIntegerArr4[i25]).add(bigInteger8.pow(iArr[i19] - 1).multiply(bigInteger7).divide(bigIntegerArr4[i25].multiply(bigInteger8.pow(i21 * 16))));
                BigInteger bigIntegerMod = bigIntegerAdd.mod(bigInteger8);
                BigInteger bigInteger9 = f28696d;
                if (bigIntegerMod.compareTo(bigInteger9) == 0) {
                    bigIntegerAdd = bigIntegerAdd.add(bigInteger9);
                }
                int i26 = 0;
                while (true) {
                    bigInteger2 = bigInteger4;
                    bigInteger3 = bigInteger5;
                    long j10 = i26;
                    i13 = i17;
                    BigInteger bigIntegerMultiply = bigIntegerArr4[i25].multiply(bigIntegerAdd.add(BigInteger.valueOf(j10)));
                    BigInteger bigInteger10 = f28696d;
                    bigIntegerArr4[i19] = bigIntegerMultiply.add(bigInteger10);
                    BigInteger bigInteger11 = bigIntegerArr4[i19];
                    BigInteger bigInteger12 = f28697e;
                    i14 = i21;
                    if (bigInteger11.compareTo(bigInteger12.pow(iArr[i19])) == 1) {
                        break;
                    }
                    if (bigInteger12.modPow(bigIntegerArr4[i25].multiply(bigIntegerAdd.add(BigInteger.valueOf(j10))), bigIntegerArr4[i19]).compareTo(bigInteger10) == 0 && bigInteger12.modPow(bigIntegerAdd.add(BigInteger.valueOf(j10)), bigIntegerArr4[i19]).compareTo(bigInteger10) != 0) {
                        break;
                    }
                    i26 += 2;
                    i17 = i13;
                    bigInteger5 = bigInteger3;
                    bigInteger4 = bigInteger2;
                    i21 = i14;
                }
                i17 = i13;
                bigInteger5 = bigInteger3;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger4 = bigInteger2;
                i21 = i14;
                i15 = 0;
                i18 = 16;
            }
            i19--;
            if (i19 < 0) {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                bigInteger = bigIntegerArr2[0];
                break;
            }
            i20++;
            i17 = i13;
            bigInteger5 = bigInteger3;
            bigIntegerArr3 = bigIntegerArr2;
            bigInteger4 = bigInteger2;
            i15 = 0;
            i18 = 16;
        }
        return bigInteger.intValue();
    }

    public final long d(long j10, long j11, BigInteger[] bigIntegerArr, int i10) {
        BigInteger bigInteger;
        BigInteger[] bigIntegerArr2;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        int i11;
        long jNextInt = j10;
        while (true) {
            if (jNextInt >= 0 && jNextInt <= 4294967296L) {
                break;
            }
            jNextInt = this.f28700c.nextInt() * 2;
        }
        long jNextInt2 = j11;
        while (true) {
            if (jNextInt2 >= 0 && jNextInt2 <= 4294967296L && jNextInt2 / 2 != 0) {
                break;
            }
            jNextInt2 = (this.f28700c.nextInt() * 2) + 1;
        }
        BigInteger bigInteger4 = new BigInteger(Long.toString(jNextInt2));
        BigInteger bigInteger5 = new BigInteger("97781173");
        BigInteger bigInteger6 = new BigInteger(Long.toString(jNextInt));
        int i12 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger6};
        int[] iArr = {i10};
        int i13 = 0;
        int i14 = 0;
        while (iArr[i13] >= 33) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i14 = i13 + 1;
            iArr[i14] = iArr[i13] / 2;
            i13 = i14;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[i14 + 1];
        bigIntegerArr4[i14] = new BigInteger("8000000B", 16);
        int i15 = i14 - 1;
        int i16 = 0;
        while (true) {
            if (i16 >= i14) {
                bigInteger = bigIntegerArr3[0];
                break;
            }
            int i17 = 32;
            int i18 = iArr[i15] / 32;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i12, bigIntegerArr5, i12, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[i18 + 1];
                System.arraycopy(bigIntegerArr5, i12, bigIntegerArr2, i12, length2);
                int i19 = 0;
                while (i19 < i18) {
                    int i20 = i19 + 1;
                    bigIntegerArr2[i20] = bigIntegerArr2[i19].multiply(bigInteger5).add(bigInteger4).mod(f28697e.pow(i17));
                    i19 = i20;
                }
                BigInteger bigInteger7 = new BigInteger("0");
                for (int i21 = 0; i21 < i18; i21++) {
                    bigInteger7 = bigInteger7.add(bigIntegerArr2[i21].multiply(f28697e.pow(i21 * 32)));
                }
                bigIntegerArr2[i12] = bigIntegerArr2[i18];
                BigInteger bigInteger8 = f28697e;
                int i22 = i15 + 1;
                BigInteger bigIntegerAdd = bigInteger8.pow(iArr[i15] - 1).divide(bigIntegerArr4[i22]).add(bigInteger8.pow(iArr[i15] - 1).multiply(bigInteger7).divide(bigIntegerArr4[i22].multiply(bigInteger8.pow(i18 * 32))));
                BigInteger bigIntegerMod = bigIntegerAdd.mod(bigInteger8);
                BigInteger bigInteger9 = f28696d;
                if (bigIntegerMod.compareTo(bigInteger9) == 0) {
                    bigIntegerAdd = bigIntegerAdd.add(bigInteger9);
                }
                int i23 = 0;
                while (true) {
                    long j12 = i23;
                    bigInteger2 = bigInteger4;
                    BigInteger bigIntegerMultiply = bigIntegerArr4[i22].multiply(bigIntegerAdd.add(BigInteger.valueOf(j12)));
                    BigInteger bigInteger10 = f28696d;
                    bigIntegerArr4[i15] = bigIntegerMultiply.add(bigInteger10);
                    BigInteger bigInteger11 = bigIntegerArr4[i15];
                    bigInteger3 = bigInteger5;
                    BigInteger bigInteger12 = f28697e;
                    i11 = i14;
                    if (bigInteger11.compareTo(bigInteger12.pow(iArr[i15])) == 1) {
                        break;
                    }
                    if (bigInteger12.modPow(bigIntegerArr4[i22].multiply(bigIntegerAdd.add(BigInteger.valueOf(j12))), bigIntegerArr4[i15]).compareTo(bigInteger10) == 0 && bigInteger12.modPow(bigIntegerAdd.add(BigInteger.valueOf(j12)), bigIntegerArr4[i15]).compareTo(bigInteger10) != 0) {
                        break;
                    }
                    i23 += 2;
                    bigInteger4 = bigInteger2;
                    i14 = i11;
                    bigInteger5 = bigInteger3;
                }
                bigInteger4 = bigInteger2;
                i14 = i11;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger5 = bigInteger3;
                i12 = 0;
                i17 = 32;
            }
            i15--;
            if (i15 < 0) {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                bigInteger = bigIntegerArr2[0];
                break;
            }
            i16++;
            bigInteger4 = bigInteger2;
            i14 = i11;
            bigIntegerArr3 = bigIntegerArr2;
            bigInteger5 = bigInteger3;
            i12 = 0;
        }
        return bigInteger.longValue();
    }

    public final void e(int i10, int i11, BigInteger[] bigIntegerArr) {
        int iNextInt = i10;
        while (true) {
            if (iNextInt >= 0 && iNextInt <= 65536) {
                break;
            } else {
                iNextInt = this.f28700c.nextInt() / 32768;
            }
        }
        int iNextInt2 = i11;
        while (true) {
            if (iNextInt2 >= 0 && iNextInt2 <= 65536 && iNextInt2 / 2 != 0) {
                break;
            } else {
                iNextInt2 = (this.f28700c.nextInt() / 32768) + 1;
            }
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Integer.toString(iNextInt2));
        BigInteger bigInteger2 = new BigInteger("19381");
        int iC = c(iNextInt, iNextInt2, bigIntegerArr2, 256);
        char c10 = 0;
        BigInteger bigInteger3 = bigIntegerArr2[0];
        int iC2 = c(iC, iNextInt2, bigIntegerArr2, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr3 = new BigInteger[65];
        bigIntegerArr3[0] = new BigInteger(Integer.toString(iC2));
        while (true) {
            int i12 = 0;
            while (i12 < 64) {
                int i13 = i12 + 1;
                bigIntegerArr3[i13] = bigIntegerArr3[i12].multiply(bigInteger2).add(bigInteger).mod(f28697e.pow(16));
                i12 = i13;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i14 = 0; i14 < 64; i14++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr3[i14].multiply(f28697e.pow(i14 * 16)));
            }
            bigIntegerArr3[c10] = bigIntegerArr3[64];
            BigInteger bigInteger6 = f28697e;
            int i15 = 1024;
            BigInteger bigIntegerAdd = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
            BigInteger bigIntegerMod = bigIntegerAdd.mod(bigInteger6);
            BigInteger bigInteger7 = f28696d;
            if (bigIntegerMod.compareTo(bigInteger7) == 0) {
                bigIntegerAdd = bigIntegerAdd.add(bigInteger7);
            }
            BigInteger bigInteger8 = bigIntegerAdd;
            int i16 = 0;
            while (true) {
                long j10 = i16;
                BigInteger bigIntegerMultiply = bigInteger3.multiply(bigInteger4).multiply(bigInteger8.add(BigInteger.valueOf(j10)));
                BigInteger bigInteger9 = f28696d;
                BigInteger bigIntegerAdd2 = bigIntegerMultiply.add(bigInteger9);
                BigInteger bigInteger10 = f28697e;
                if (bigIntegerAdd2.compareTo(bigInteger10.pow(i15)) == 1) {
                    break;
                }
                if (bigInteger10.modPow(bigInteger3.multiply(bigInteger4).multiply(bigInteger8.add(BigInteger.valueOf(j10))), bigIntegerAdd2).compareTo(bigInteger9) == 0 && bigInteger10.modPow(bigInteger3.multiply(bigInteger8.add(BigInteger.valueOf(j10))), bigIntegerAdd2).compareTo(bigInteger9) != 0) {
                    bigIntegerArr[0] = bigIntegerAdd2;
                    bigIntegerArr[1] = bigInteger3;
                    return;
                } else {
                    i16 += 2;
                    i15 = 1024;
                }
            }
            c10 = 0;
        }
    }

    public final void f(long j10, long j11, BigInteger[] bigIntegerArr) {
        long jNextInt = j10;
        while (true) {
            if (jNextInt >= 0 && jNextInt <= 4294967296L) {
                break;
            } else {
                jNextInt = this.f28700c.nextInt() * 2;
            }
        }
        long jNextInt2 = j11;
        while (true) {
            if (jNextInt2 >= 0 && jNextInt2 <= 4294967296L && jNextInt2 / 2 != 0) {
                break;
            } else {
                jNextInt2 = (this.f28700c.nextInt() * 2) + 1;
            }
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Long.toString(jNextInt2));
        BigInteger bigInteger2 = new BigInteger("97781173");
        long j12 = jNextInt2;
        long jD = d(jNextInt, j12, bigIntegerArr2, 256);
        char c10 = 0;
        BigInteger bigInteger3 = bigIntegerArr2[0];
        long jD2 = d(jD, j12, bigIntegerArr2, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr3 = new BigInteger[33];
        bigIntegerArr3[0] = new BigInteger(Long.toString(jD2));
        while (true) {
            int i10 = 0;
            while (i10 < 32) {
                int i11 = i10 + 1;
                bigIntegerArr3[i11] = bigIntegerArr3[i10].multiply(bigInteger2).add(bigInteger).mod(f28697e.pow(32));
                i10 = i11;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i12 = 0; i12 < 32; i12++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr3[i12].multiply(f28697e.pow(i12 * 32)));
            }
            bigIntegerArr3[c10] = bigIntegerArr3[32];
            BigInteger bigInteger6 = f28697e;
            int i13 = 1024;
            BigInteger bigIntegerAdd = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
            BigInteger bigIntegerMod = bigIntegerAdd.mod(bigInteger6);
            BigInteger bigInteger7 = f28696d;
            if (bigIntegerMod.compareTo(bigInteger7) == 0) {
                bigIntegerAdd = bigIntegerAdd.add(bigInteger7);
            }
            int i14 = 0;
            while (true) {
                long j13 = i14;
                BigInteger bigIntegerMultiply = bigInteger3.multiply(bigInteger4).multiply(bigIntegerAdd.add(BigInteger.valueOf(j13)));
                BigInteger bigInteger8 = f28696d;
                BigInteger bigIntegerAdd2 = bigIntegerMultiply.add(bigInteger8);
                BigInteger bigInteger9 = f28697e;
                if (bigIntegerAdd2.compareTo(bigInteger9.pow(i13)) == 1) {
                    break;
                }
                if (bigInteger9.modPow(bigInteger3.multiply(bigInteger4).multiply(bigIntegerAdd.add(BigInteger.valueOf(j13))), bigIntegerAdd2).compareTo(bigInteger8) == 0 && bigInteger9.modPow(bigInteger3.multiply(bigIntegerAdd.add(BigInteger.valueOf(j13))), bigIntegerAdd2).compareTo(bigInteger8) != 0) {
                    bigIntegerArr[0] = bigIntegerAdd2;
                    bigIntegerArr[1] = bigInteger3;
                    return;
                } else {
                    i14 += 2;
                    i13 = 1024;
                }
            }
            c10 = 0;
        }
    }

    public final BigInteger g(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerSubtract = bigInteger.subtract(f28696d);
        BigInteger bigIntegerDivide = bigIntegerSubtract.divide(bigInteger2);
        int iBitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigIntegerF = org.bouncycastle.util.b.f(iBitLength, this.f28700c);
            BigInteger bigInteger3 = f28696d;
            if (bigIntegerF.compareTo(bigInteger3) > 0 && bigIntegerF.compareTo(bigIntegerSubtract) < 0) {
                BigInteger bigIntegerModPow = bigIntegerF.modPow(bigIntegerDivide, bigInteger);
                if (bigIntegerModPow.compareTo(bigInteger3) != 0) {
                    return bigIntegerModPow;
                }
            }
        }
    }
}

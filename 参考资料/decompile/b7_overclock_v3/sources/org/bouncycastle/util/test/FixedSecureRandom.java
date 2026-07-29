package org.bouncycastle.util.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Provider;
import java.security.SecureRandom;
import jt.h;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes6.dex */
public class FixedSecureRandom extends SecureRandom {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BigInteger f46053a = new BigInteger("01020304ffffffff0506070811111111", 16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static BigInteger f46054b = new BigInteger("1111111105060708ffffffff01020304", 16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static BigInteger f46055c = new BigInteger("3020104ffffffff05060708111111", 16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f46056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f46057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f46058f;
    private byte[] _data;
    private int _index;

    public static class DummyProvider extends Provider {
        public DummyProvider() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    public static class RandomChecker extends SecureRandom {
        public byte[] data;
        public int index;

        public RandomChecker() {
            super(null, new DummyProvider());
            this.data = h.b("01020304ffffffff0506070811111111");
            this.index = 0;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void nextBytes(byte[] bArr) {
            System.arraycopy(this.data, this.index, bArr, 0, bArr.length);
            this.index += bArr.length;
        }
    }

    public static class a extends c {
        public a(int i10, String str) {
            super(FixedSecureRandom.c(i10, h.b(str)));
        }

        public a(int i10, byte[] bArr) {
            super(FixedSecureRandom.c(i10, bArr));
        }

        public a(String str) {
            this(h.b(str));
        }

        public a(byte[] bArr) {
            super(bArr);
        }
    }

    public static class b extends c {
        public b(byte[] bArr) {
            super(bArr);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f46059a;

        public c(byte[] bArr) {
            this.f46059a = bArr;
        }
    }

    static {
        BigInteger bigInteger = new BigInteger(128, new RandomChecker());
        BigInteger bigInteger2 = new BigInteger(120, new RandomChecker());
        f46056d = bigInteger.equals(f46054b);
        f46058f = bigInteger.equals(f46053a);
        f46057e = bigInteger2.equals(f46055c);
    }

    public FixedSecureRandom(byte[] bArr) {
        this(new c[]{new b(bArr)});
    }

    public FixedSecureRandom(c[] cVarArr) {
        super(null, new DummyProvider());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        if (!f46058f) {
            if (!f46056d) {
                throw new IllegalStateException("Unrecognized BigInteger implementation");
            }
            for (int i11 = 0; i11 != cVarArr.length; i11++) {
                try {
                    if (cVarArr[i11] instanceof a) {
                        byte[] bArr = cVarArr[i11].f46059a;
                        int length = bArr.length - (bArr.length % 4);
                        int i12 = 0;
                        while (i12 < length) {
                            i12 += 4;
                            byteArrayOutputStream.write(bArr, bArr.length - i12, 4);
                        }
                        if (bArr.length - length != 0) {
                            for (int i13 = 0; i13 != 4 - (bArr.length - length); i13++) {
                                byteArrayOutputStream.write(0);
                            }
                        }
                        for (int i14 = 0; i14 != bArr.length - length; i14++) {
                            byteArrayOutputStream.write(bArr[length + i14]);
                        }
                    } else {
                        byteArrayOutputStream.write(cVarArr[i11].f46059a);
                    }
                } catch (IOException unused) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else if (f46057e) {
            while (i10 != cVarArr.length) {
                try {
                    if (cVarArr[i10] instanceof a) {
                        byte[] bArr2 = cVarArr[i10].f46059a;
                        int length2 = bArr2.length - (bArr2.length % 4);
                        for (int length3 = (bArr2.length - length2) - 1; length3 >= 0; length3--) {
                            byteArrayOutputStream.write(bArr2[length3]);
                        }
                        for (int length4 = bArr2.length - length2; length4 < bArr2.length; length4 += 4) {
                            byteArrayOutputStream.write(bArr2, length4, 4);
                        }
                    } else {
                        byteArrayOutputStream.write(cVarArr[i10].f46059a);
                    }
                    i10++;
                } catch (IOException unused2) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else {
            while (i10 != cVarArr.length) {
                try {
                    byteArrayOutputStream.write(cVarArr[i10].f46059a);
                    i10++;
                } catch (IOException unused3) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        }
        this._data = byteArrayOutputStream.toByteArray();
    }

    public FixedSecureRandom(byte[][] bArr) {
        this(b(bArr));
    }

    public static b[] b(byte[][] bArr) {
        b[] bVarArr = new b[bArr.length];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bVarArr[i10] = new b(bArr[i10]);
        }
        return bVarArr;
    }

    public static byte[] c(int i10, byte[] bArr) {
        int i11;
        int i12;
        int i13 = (i10 + 7) / 8;
        if (i13 <= bArr.length) {
            if (f46056d && i10 < bArr.length * 8 && (i11 = i10 % 8) != 0) {
                o.h(o.a(bArr, 0) << (8 - i11), bArr, 0);
            }
            return bArr;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, 0, bArr2, i13 - bArr.length, bArr.length);
        if (f46056d && (i12 = i10 % 8) != 0) {
            o.h(o.a(bArr2, 0) << (8 - i12), bArr2, 0);
        }
        return bArr2;
    }

    public boolean d() {
        return this._index == this._data.length;
    }

    public final int f() {
        byte[] bArr = this._data;
        int i10 = this._index;
        this._index = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i10) {
        byte[] bArr = new byte[i10];
        nextBytes(bArr);
        return bArr;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        System.arraycopy(this._data, this._index, bArr, 0, bArr.length);
        this._index += bArr.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        return (f() << 24) | 0 | (f() << 16) | (f() << 8) | f();
    }

    @Override // java.util.Random
    public long nextLong() {
        return (((long) f()) << 56) | 0 | (((long) f()) << 48) | (((long) f()) << 40) | (((long) f()) << 32) | (((long) f()) << 24) | (((long) f()) << 16) | (((long) f()) << 8) | ((long) f());
    }
}

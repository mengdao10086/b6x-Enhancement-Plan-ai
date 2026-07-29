package moe.shizuku.manager.adb;

import android.util.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.interfaces.RSAPublicKey;
import kotlin.LazyThreadSafetyMode;
import kotlin.b0;
import kotlin.collections.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nAdbKey.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbKey.kt\nmoe/shizuku/manager/adb/AdbKeyKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,392:1\n13600#2,2:393\n13600#2,2:395\n*S KotlinDebug\n*F\n+ 1 AdbKey.kt\nmoe/shizuku/manager/adb/AdbKeyKt\n*L\n379#1:393,2\n380#1:395,2\n*E\n"})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final String f41497a = "AdbKey";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f41498b = 256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f41499c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f41500d = 524;

    public static final byte[] b(RSAPublicKey rSAPublicKey, String str) {
        BigInteger bigInteger = BigInteger.ZERO;
        BigInteger bit = bigInteger.setBit(32);
        BigInteger bigIntegerNegate = rSAPublicKey.getModulus().remainder(bit).modInverse(bit).negate();
        BigInteger rr2 = bigInteger.setBit(2048).modPow(BigInteger.valueOf(2L), rSAPublicKey.getModulus());
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(524).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(64);
        byteBufferOrder.putInt(bigIntegerNegate.intValue());
        BigInteger modulus = rSAPublicKey.getModulus();
        f0.o(modulus, "modulus");
        for (int i10 : c(modulus)) {
            byteBufferOrder.putInt(i10);
        }
        f0.o(rr2, "rr");
        for (int i11 : c(rr2)) {
            byteBufferOrder.putInt(i11);
        }
        byteBufferOrder.putInt(rSAPublicKey.getPublicExponent().intValue());
        byte[] base64Bytes = Base64.encode(byteBufferOrder.array(), 2);
        byte[] bytes = (zc.f.f58383m + str + (char) 0).getBytes(kotlin.text.d.f38161b);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArr = new byte[base64Bytes.length + bytes.length];
        f0.o(base64Bytes, "base64Bytes");
        m.f1(base64Bytes, bArr, 0, 0, 0, 14, null);
        m.f1(bytes, bArr, base64Bytes.length, 0, 0, 12, null);
        return bArr;
    }

    public static final int[] c(BigInteger bigInteger) {
        int[] iArr = new int[64];
        BigInteger bigInteger2 = BigInteger.ZERO;
        BigInteger bit = bigInteger2.setBit(32);
        BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
        int i10 = 0;
        while (i10 < 64) {
            BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerAdd.divideAndRemainder(bit);
            BigInteger bigInteger3 = bigIntegerArrDivideAndRemainder[0];
            iArr[i10] = bigIntegerArrDivideAndRemainder[1].intValue();
            i10++;
            bigIntegerAdd = bigInteger3;
        }
        return iArr;
    }

    @k
    public static final <T> z<T> d(@k ik.a<? extends T> initializer) {
        f0.p(initializer, "initializer");
        return b0.c(LazyThreadSafetyMode.NONE, initializer);
    }
}

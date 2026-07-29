package io.objectbox.flatbuffers;

import java.nio.ByteBuffer;
import okio.w0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Utf8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Utf8 f32697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f32698b = false;

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    public static class a {
        public static void a(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws IllegalArgumentException {
            if (f(b11) || (((b10 << 28) + (b11 + pq.b.f46994k)) >> 30) != 0 || f(b12) || f(b13)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int iK = ((b10 & 7) << 18) | (k(b11) << 12) | (k(b12) << 6) | k(b13);
            cArr[i10] = e(iK);
            cArr[i10 + 1] = j(iK);
        }

        public static void b(byte b10, char[] cArr, int i10) {
            cArr[i10] = (char) b10;
        }

        public static void c(byte b10, byte b11, byte b12, char[] cArr, int i10) throws IllegalArgumentException {
            if (f(b11) || ((b10 == -32 && b11 < -96) || ((b10 == -19 && b11 >= -96) || f(b12)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i10] = (char) (((b10 & 15) << 12) | (k(b11) << 6) | k(b12));
        }

        public static void d(byte b10, byte b11, char[] cArr, int i10) throws IllegalArgumentException {
            if (b10 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (f(b11)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i10] = (char) (((b10 & 31) << 6) | k(b11));
        }

        public static char e(int i10) {
            return (char) ((i10 >>> 10) + w0.f44232d);
        }

        public static boolean f(byte b10) {
            return b10 > -65;
        }

        public static boolean g(byte b10) {
            return b10 >= 0;
        }

        public static boolean h(byte b10) {
            return b10 < -16;
        }

        public static boolean i(byte b10) {
            return b10 < -32;
        }

        public static char j(int i10) {
            return (char) ((i10 & 1023) + w0.f44233e);
        }

        public static int k(byte b10) {
            return b10 & w0.f44229a;
        }
    }

    public static int c(CharSequence charSequence, int i10, byte[] bArr) {
        int length = charSequence.length();
        if (i10 >= length) {
            return 0;
        }
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt < 128) {
            bArr[0] = (byte) cCharAt;
            return 1;
        }
        if (cCharAt < 2048) {
            bArr[0] = (byte) ((cCharAt >>> 6) | 192);
            bArr[1] = (byte) ((cCharAt & '?') | 128);
            return 2;
        }
        if (cCharAt < 55296 || 57343 < cCharAt) {
            bArr[0] = (byte) ((cCharAt >>> '\f') | 224);
            bArr[1] = (byte) (((cCharAt >>> 6) & 63) | 128);
            bArr[2] = (byte) ((cCharAt & '?') | 128);
            return 3;
        }
        int i11 = i10 + 1;
        if (i11 != length) {
            char cCharAt2 = charSequence.charAt(i11);
            if (Character.isSurrogatePair(cCharAt, cCharAt2)) {
                int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                bArr[0] = (byte) ((codePoint >>> 18) | 240);
                bArr[1] = (byte) (((codePoint >>> 12) & 63) | 128);
                bArr[2] = (byte) (((codePoint >>> 6) & 63) | 128);
                bArr[3] = (byte) ((codePoint & 63) | 128);
                return 4;
            }
        }
        throw new UnpairedSurrogateException(i10, length);
    }

    public static Utf8 e() {
        if (f32697a == null) {
            f32697a = new Utf8Safe();
        }
        return f32697a;
    }

    public static void f(Utf8 utf8) {
        f32697a = utf8;
    }

    public abstract String a(ByteBuffer byteBuffer, int i10, int i11);

    public abstract void b(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int d(CharSequence charSequence);
}

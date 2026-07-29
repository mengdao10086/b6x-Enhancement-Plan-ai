package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import okio.w0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Utf8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Utf8 f5441a;

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

    public static Utf8 d() {
        if (f5441a == null) {
            f5441a = new Utf8Safe();
        }
        return f5441a;
    }

    public static void e(Utf8 utf8) {
        f5441a = utf8;
    }

    public abstract String a(ByteBuffer byteBuffer, int i10, int i11);

    public abstract void b(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int c(CharSequence charSequence);
}

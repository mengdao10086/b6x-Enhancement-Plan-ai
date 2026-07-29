package kt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.io.StreamOverflowException;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f39243a = 4096;

    public static void a(InputStream inputStream) throws IOException {
        int i10 = f39243a;
        while (inputStream.read(new byte[i10], 0, i10) >= 0) {
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        c(inputStream, outputStream, f39243a);
    }

    public static void c(InputStream inputStream, OutputStream outputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        while (true) {
            int i11 = inputStream.read(bArr, 0, i10);
            if (i11 < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i11);
            }
        }
    }

    public static long d(InputStream inputStream, long j10, OutputStream outputStream) throws IOException {
        int i10 = f39243a;
        byte[] bArr = new byte[i10];
        long j11 = 0;
        while (true) {
            int i11 = inputStream.read(bArr, 0, i10);
            if (i11 < 0) {
                return j11;
            }
            long j12 = i11;
            if (j10 - j11 < j12) {
                throw new StreamOverflowException("Data Overflow");
            }
            j11 += j12;
            outputStream.write(bArr, 0, i11);
        }
    }

    public static byte[] e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] f(InputStream inputStream, int i10) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d(inputStream, i10, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int g(InputStream inputStream, byte[] bArr) throws IOException {
        return h(inputStream, bArr, 0, bArr.length);
    }

    public static int h(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 < i11) {
            int i13 = inputStream.read(bArr, i10 + i12, i11 - i12);
            if (i13 < 0) {
                break;
            }
            i12 += i13;
        }
        return i12;
    }

    public static void i(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) throws IOException {
        byteArrayOutputStream.writeTo(outputStream);
    }
}

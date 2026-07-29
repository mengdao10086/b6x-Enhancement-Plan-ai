package a;

import Decoder.CEStreamExhausted;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public abstract int a();

    public abstract int b();

    public void c(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i10) throws IOException {
        throw new CEStreamExhausted();
    }

    public void d(InputStream inputStream, OutputStream outputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        g(pushbackInputStream, outputStream);
        while (true) {
            try {
                int iK = k(pushbackInputStream, outputStream);
                int iA = 0;
                while (a() + iA < iK) {
                    c(pushbackInputStream, outputStream, a());
                    a();
                    iA += a();
                }
                if (a() + iA == iK) {
                    c(pushbackInputStream, outputStream, a());
                    a();
                } else {
                    c(pushbackInputStream, outputStream, iK - iA);
                }
                l(pushbackInputStream, outputStream);
            } catch (CEStreamExhausted unused) {
                h(pushbackInputStream, outputStream);
                return;
            }
        }
    }

    public byte[] e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] f(String str) throws IOException {
        byte[] bArr = new byte[str.length()];
        str.getBytes(0, str.length(), bArr, 0);
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d(byteArrayInputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void g(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    public void h(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    public ByteBuffer i(InputStream inputStream) throws IOException {
        return ByteBuffer.wrap(e(inputStream));
    }

    public ByteBuffer j(String str) throws IOException {
        return ByteBuffer.wrap(f(str));
    }

    public int k(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
        return b();
    }

    public void l(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    public int m(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = inputStream.read();
            if (i13 == -1) {
                if (i12 == 0) {
                    return -1;
                }
                return i12;
            }
            bArr[i12 + i10] = (byte) i13;
        }
        return i11;
    }
}

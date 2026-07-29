package a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PrintStream f5a;

    public abstract int a();

    public abstract int b();

    public String c(ByteBuffer byteBuffer) {
        return d(r(byteBuffer));
    }

    public String d(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString("8859_1");
        } catch (Exception unused) {
            throw new Error("CharacterEncoder.encode internal error");
        }
    }

    public void e(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[b()];
        n(outputStream);
        while (true) {
            int iS = s(inputStream, bArr);
            if (iS == 0) {
                break;
            }
            p(outputStream, iS);
            int iA = 0;
            while (iA < iS) {
                if (a() + iA <= iS) {
                    h(outputStream, bArr, iA, a());
                } else {
                    h(outputStream, bArr, iA, iS - iA);
                }
                iA += a();
            }
            if (iS < b()) {
                break;
            } else {
                q(outputStream);
            }
        }
        o(outputStream);
    }

    public void f(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        g(r(byteBuffer), outputStream);
    }

    public void g(byte[] bArr, OutputStream outputStream) throws IOException {
        e(new ByteArrayInputStream(bArr), outputStream);
    }

    public abstract void h(OutputStream outputStream, byte[] bArr, int i10, int i11) throws IOException;

    public String i(ByteBuffer byteBuffer) {
        return j(r(byteBuffer));
    }

    public String j(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            k(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (Exception unused) {
            throw new Error("CharacterEncoder.encodeBuffer internal error");
        }
    }

    public void k(InputStream inputStream, OutputStream outputStream) throws IOException {
        int iS;
        byte[] bArr = new byte[b()];
        n(outputStream);
        do {
            iS = s(inputStream, bArr);
            if (iS == 0) {
                break;
            }
            p(outputStream, iS);
            int iA = 0;
            while (iA < iS) {
                if (a() + iA <= iS) {
                    h(outputStream, bArr, iA, a());
                } else {
                    h(outputStream, bArr, iA, iS - iA);
                }
                iA += a();
            }
            q(outputStream);
        } while (iS >= b());
        o(outputStream);
    }

    public void l(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        m(r(byteBuffer), outputStream);
    }

    public void m(byte[] bArr, OutputStream outputStream) throws IOException {
        k(new ByteArrayInputStream(bArr), outputStream);
    }

    public void n(OutputStream outputStream) throws IOException {
        this.f5a = new PrintStream(outputStream);
    }

    public void o(OutputStream outputStream) throws IOException {
    }

    public void p(OutputStream outputStream, int i10) throws IOException {
    }

    public void q(OutputStream outputStream) throws IOException {
        this.f5a.println();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] r(java.nio.ByteBuffer r4) {
        /*
            r3 = this;
            boolean r0 = r4.hasArray()
            if (r0 == 0) goto L20
            byte[] r0 = r4.array()
            int r1 = r0.length
            int r2 = r4.capacity()
            if (r1 != r2) goto L20
            int r1 = r0.length
            int r2 = r4.remaining()
            if (r1 != r2) goto L20
            int r1 = r4.limit()
            r4.position(r1)
            goto L21
        L20:
            r0 = 0
        L21:
            if (r0 != 0) goto L2c
            int r0 = r4.remaining()
            byte[] r0 = new byte[r0]
            r4.get(r0)
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.r(java.nio.ByteBuffer):byte[]");
    }

    public int s(InputStream inputStream, byte[] bArr) throws IOException {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = inputStream.read();
            if (i11 == -1) {
                return i10;
            }
            bArr[i10] = (byte) i11;
        }
        return bArr.length;
    }
}

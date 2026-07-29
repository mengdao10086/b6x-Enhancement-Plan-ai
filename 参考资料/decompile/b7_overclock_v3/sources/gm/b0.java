package gm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f29640a;

    public b0(OutputStream outputStream) {
        this.f29640a = outputStream;
    }

    public static b0 b(OutputStream outputStream) {
        return new b0(outputStream);
    }

    public static b0 c(OutputStream outputStream, String str) {
        return str.equals(j.f29713a) ? new h2(outputStream) : str.equals(j.f29714b) ? new y2(outputStream) : new b0(outputStream);
    }

    public static int h(int i10) {
        if (i10 < 128) {
            return 1;
        }
        int i11 = 2;
        while (true) {
            i10 >>>= 8;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public static int i(boolean z10, int i10) {
        return (z10 ? 1 : 0) + h(i10) + i10;
    }

    public static int j(int i10) {
        if (i10 < 31) {
            return 1;
        }
        int i11 = 2;
        while (true) {
            i10 >>>= 7;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public void A(c0[] c0VarArr) throws IOException {
        for (c0 c0Var : c0VarArr) {
            c0Var.y(this, true);
        }
    }

    public void a() throws IOException {
        this.f29640a.close();
    }

    public void d() throws IOException {
        this.f29640a.flush();
    }

    public void e() throws IOException {
    }

    public h2 f() {
        return new h2(this.f29640a);
    }

    public y2 g() {
        return new y2(this.f29640a);
    }

    public final void k(int i10) throws IOException {
        this.f29640a.write(i10);
    }

    public final void l(byte[] bArr, int i10, int i11) throws IOException {
        this.f29640a.write(bArr, i10, i11);
    }

    public final void m(int i10) throws IOException {
        if (i10 < 128) {
            k(i10);
            return;
        }
        int i11 = 5;
        byte[] bArr = new byte[5];
        do {
            i11--;
            bArr[i11] = (byte) i10;
            i10 >>>= 8;
        } while (i10 != 0);
        int i12 = 5 - i11;
        int i13 = i11 - 1;
        bArr[i13] = (byte) (i12 | 128);
        l(bArr, i13, i12 + 1);
    }

    public void n(h[] hVarArr) throws IOException {
        for (h hVar : hVarArr) {
            hVar.b().y(this, true);
        }
    }

    public final void o(boolean z10, int i10, byte b10) throws IOException {
        v(z10, i10);
        m(1);
        k(b10);
    }

    public final void p(boolean z10, int i10, byte b10, byte[] bArr, int i11, int i12) throws IOException {
        v(z10, i10);
        m(i12 + 1);
        k(b10);
        l(bArr, i11, i12);
    }

    public final void q(boolean z10, int i10, int i11, byte[] bArr) throws IOException {
        w(z10, i10, i11);
        m(bArr.length);
        l(bArr, 0, bArr.length);
    }

    public final void r(boolean z10, int i10, byte[] bArr) throws IOException {
        v(z10, i10);
        m(bArr.length);
        l(bArr, 0, bArr.length);
    }

    public final void s(boolean z10, int i10, byte[] bArr, int i11, int i12) throws IOException {
        v(z10, i10);
        m(i12);
        l(bArr, i11, i12);
    }

    public final void t(boolean z10, int i10, byte[] bArr, int i11, int i12, byte b10) throws IOException {
        v(z10, i10);
        m(i12 + 1);
        l(bArr, i11, i12);
        k(b10);
    }

    public final void u(boolean z10, int i10, h[] hVarArr) throws IOException {
        v(z10, i10);
        k(128);
        n(hVarArr);
        k(0);
        k(0);
    }

    public final void v(boolean z10, int i10) throws IOException {
        if (z10) {
            k(i10);
        }
    }

    public final void w(boolean z10, int i10, int i11) throws IOException {
        if (z10) {
            if (i11 < 31) {
                k(i10 | i11);
                return;
            }
            byte[] bArr = new byte[6];
            int i12 = 5;
            bArr[5] = (byte) (i11 & 127);
            while (i11 > 127) {
                i11 >>>= 7;
                i12--;
                bArr[i12] = (byte) ((i11 & 127) | 128);
            }
            int i13 = i12 - 1;
            bArr[i13] = (byte) (31 | i10);
            l(bArr, i13, 6 - i13);
        }
    }

    public final void x(h hVar) throws IOException {
        if (hVar == null) {
            throw new IOException("null object detected");
        }
        z(hVar.b(), true);
        e();
    }

    public final void y(c0 c0Var) throws IOException {
        if (c0Var == null) {
            throw new IOException("null object detected");
        }
        z(c0Var, true);
        e();
    }

    public void z(c0 c0Var, boolean z10) throws IOException {
        c0Var.y(this, z10);
    }
}

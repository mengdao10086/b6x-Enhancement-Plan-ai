package so;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f50252b = "1.2.840.113549.1.9.16.3.8";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50253a;

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OutputStream f50254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.j1 f50255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public gm.j1 f50256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public gm.j1 f50257d;

        public a(OutputStream outputStream, gm.j1 j1Var, gm.j1 j1Var2, gm.j1 j1Var3) {
            this.f50254a = outputStream;
            this.f50255b = j1Var;
            this.f50256c = j1Var2;
            this.f50257d = j1Var3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f50254a.close();
            this.f50257d.g();
            this.f50256c.g();
            this.f50255b.g();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f50254a.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f50254a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f50254a.write(bArr, i10, i11);
        }
    }

    public OutputStream a(gm.y yVar, OutputStream outputStream, cs.c0 c0Var) throws IOException {
        gm.j1 j1Var = new gm.j1(outputStream);
        j1Var.f(mm.k.Q2);
        gm.j1 j1Var2 = new gm.j1(j1Var.a(), 0, true);
        j1Var2.f(new gm.t(0L));
        j1Var2.e(c0Var.a());
        gm.j1 j1Var3 = new gm.j1(j1Var2.a());
        j1Var3.f(yVar);
        return new a(c0Var.b(t0.e(j1Var3.a(), 0, true, this.f50253a)), j1Var, j1Var2, j1Var3);
    }

    public OutputStream b(OutputStream outputStream, cs.c0 c0Var) throws IOException {
        return a(mm.k.I2, outputStream, c0Var);
    }

    public void c(int i10) {
        this.f50253a = i10;
    }
}

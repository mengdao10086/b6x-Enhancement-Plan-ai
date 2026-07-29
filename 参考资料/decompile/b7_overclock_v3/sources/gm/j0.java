package gm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Exception;

/* JADX INFO: loaded from: classes5.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f29716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[][] f29718c;

    public j0(InputStream inputStream) {
        this(inputStream, n3.a(inputStream));
    }

    public j0(InputStream inputStream, int i10) {
        this(inputStream, i10, new byte[11][]);
    }

    public j0(InputStream inputStream, int i10, byte[][] bArr) {
        this.f29716a = inputStream;
        this.f29717b = i10;
        this.f29718c = bArr;
    }

    public j0(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public h a(int i10) throws IOException {
        l(false);
        int iU = s.u(this.f29716a, i10);
        int iM = s.m(this.f29716a, this.f29717b, iU == 3 || iU == 4 || iU == 16 || iU == 17 || iU == 8);
        if (iM < 0) {
            if ((i10 & 32) == 0) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            j0 j0Var = new j0(new i3(this.f29716a, this.f29717b), this.f29717b, this.f29718c);
            int i11 = i10 & 192;
            return i11 != 0 ? 64 == i11 ? new z0(iU, j0Var) : new o1(i11, iU, j0Var) : j0Var.e(iU);
        }
        g3 g3Var = new g3(this.f29716a, iM, this.f29717b);
        if ((i10 & 224) == 0) {
            return g(iU, g3Var);
        }
        j0 j0Var2 = new j0(g3Var, g3Var.a(), this.f29718c);
        int i12 = i10 & 192;
        if (i12 == 0) {
            return j0Var2.d(iU);
        }
        boolean z10 = (i10 & 32) != 0;
        return 64 == i12 ? (t2) j0Var2.b(i12, iU, z10) : new e3(i12, iU, z10, j0Var2);
    }

    public c0 b(int i10, int i11, boolean z10) throws IOException {
        return !z10 ? n0.J(i10, i11, ((g3) this.f29716a).h()) : n0.H(i10, i11, k());
    }

    public c0 c(int i10, int i11) throws IOException {
        return n0.I(i10, i11, k());
    }

    public h d(int i10) throws IOException {
        if (i10 == 3) {
            return new b1(this);
        }
        if (i10 == 4) {
            return new g1(this);
        }
        if (i10 == 8) {
            return new w1(this);
        }
        if (i10 == 16) {
            return new a3(this);
        }
        if (i10 == 17) {
            return new c3(this);
        }
        throw new ASN1Exception("unknown DL object encountered: 0x" + Integer.toHexString(i10));
    }

    public h e(int i10) throws IOException {
        if (i10 == 3) {
            return new b1(this);
        }
        if (i10 == 4) {
            return new g1(this);
        }
        if (i10 == 8) {
            return new w1(this);
        }
        if (i10 == 16) {
            return new k1(this);
        }
        if (i10 == 17) {
            return new m1(this);
        }
        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(i10));
    }

    public h f(int i10) throws IOException {
        return g(i10, (g3) this.f29716a);
    }

    public h g(int i10, g3 g3Var) throws IOException {
        if (i10 == 3) {
            return new v2(g3Var);
        }
        if (i10 == 4) {
            return new g2(g3Var);
        }
        if (i10 == 8) {
            throw new ASN1Exception("externals must use constructed encoding (see X.690 8.18)");
        }
        if (i10 == 16) {
            throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
        }
        if (i10 == 17) {
            throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
        }
        try {
            return s.f(i10, g3Var, this.f29718c);
        } catch (IllegalArgumentException e10) {
            throw new ASN1Exception("corrupted stream detected", e10);
        }
    }

    public h h(int i10) throws IOException {
        if (i10 < 0 || i10 > 30) {
            throw new IllegalArgumentException("invalid universal tag number: " + i10);
        }
        int i11 = this.f29716a.read();
        if (i11 < 0) {
            return null;
        }
        if ((i11 & (-33)) == i10) {
            return a(i11);
        }
        throw new IOException("unexpected identifier encountered: " + i11);
    }

    public o0 i() throws IOException {
        int i10 = this.f29716a.read();
        if (i10 < 0) {
            return null;
        }
        if ((i10 & 192) != 0) {
            return (o0) a(i10);
        }
        throw new ASN1Exception("no tagged object found");
    }

    public h j() throws IOException {
        int i10 = this.f29716a.read();
        if (i10 < 0) {
            return null;
        }
        return a(i10);
    }

    public i k() throws IOException {
        int i10 = this.f29716a.read();
        if (i10 < 0) {
            return new i(0);
        }
        i iVar = new i();
        do {
            h hVarA = a(i10);
            iVar.a(hVarA instanceof h3 ? ((h3) hVarA).o() : hVarA.b());
            i10 = this.f29716a.read();
        } while (i10 >= 0);
        return iVar;
    }

    public final void l(boolean z10) {
        InputStream inputStream = this.f29716a;
        if (inputStream instanceof i3) {
            ((i3) inputStream).f(z10);
        }
    }
}

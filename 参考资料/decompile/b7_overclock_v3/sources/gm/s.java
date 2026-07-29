package gm;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Exception;

/* JADX INFO: loaded from: classes5.dex */
public class s extends FilterInputStream implements p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f29800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[][] f29801c;

    public s(InputStream inputStream) {
        this(inputStream, n3.a(inputStream));
    }

    public s(InputStream inputStream, int i10) {
        this(inputStream, i10, false);
    }

    public s(InputStream inputStream, int i10, boolean z10) {
        this(inputStream, i10, z10, new byte[11][]);
    }

    public s(InputStream inputStream, int i10, boolean z10, byte[][] bArr) {
        super(inputStream);
        this.f29799a = i10;
        this.f29800b = z10;
        this.f29801c = bArr;
    }

    public s(InputStream inputStream, boolean z10) {
        this(inputStream, n3.a(inputStream), z10);
    }

    public s(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public s(byte[] bArr, boolean z10) {
        this(new ByteArrayInputStream(bArr), bArr.length, z10);
    }

    public static c0 f(int i10, g3 g3Var, byte[][] bArr) throws IOException {
        switch (i10) {
            case 1:
                return f.G(i(g3Var, bArr));
            case 2:
                return t.G(g3Var.h());
            case 3:
                return d.G(g3Var.h());
            case 4:
                return z.G(g3Var.h());
            case 5:
                return u.G(g3Var.h());
            case 6:
                return y.H(i(g3Var, bArr), true);
            case 7:
                return x.G(g3Var.h());
            case 8:
            case 9:
            case 11:
            case 14:
            case 15:
            case 16:
            case 17:
            case 29:
            default:
                throw new IOException("unknown tag " + i10 + " encountered");
            case 10:
                return k.G(i(g3Var, bArr), true);
            case 12:
                return r0.G(g3Var.h());
            case 13:
                return e0.H(g3Var.h(), false);
            case 18:
                return v.G(g3Var.h());
            case 19:
                return d0.G(g3Var.h());
            case 20:
                return l0.G(g3Var.h());
            case 21:
                return w0.G(g3Var.h());
            case 22:
                return r.G(g3Var.h());
            case 23:
                return q0.G(g3Var.h());
            case 24:
                return o.J(g3Var.h());
            case 25:
                return q.G(g3Var.h());
            case 26:
                return x0.G(g3Var.h());
            case 27:
                return n.G(g3Var.h());
            case 28:
                return s0.G(g3Var.h());
            case 30:
                return c.H(h(g3Var));
        }
    }

    public static char[] h(g3 g3Var) throws IOException {
        int i10;
        int iD = g3Var.d();
        if ((iD & 1) != 0) {
            throw new IOException("malformed BMPString encoding encountered");
        }
        int i11 = iD / 2;
        char[] cArr = new char[i11];
        byte[] bArr = new byte[8];
        int i12 = 0;
        int i13 = 0;
        while (iD >= 8) {
            if (kt.c.h(g3Var, bArr, 0, 8) != 8) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            cArr[i13] = (char) ((bArr[0] << 8) | (bArr[1] & 255));
            cArr[i13 + 1] = (char) ((bArr[2] << 8) | (bArr[3] & 255));
            cArr[i13 + 2] = (char) ((bArr[4] << 8) | (bArr[5] & 255));
            cArr[i13 + 3] = (char) ((bArr[6] << 8) | (bArr[7] & 255));
            i13 += 4;
            iD -= 8;
        }
        if (iD > 0) {
            if (kt.c.h(g3Var, bArr, 0, iD) != iD) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            while (true) {
                int i14 = i12 + 1;
                int i15 = i14 + 1;
                i10 = i13 + 1;
                cArr[i13] = (char) ((bArr[i12] << 8) | (bArr[i14] & 255));
                if (i15 >= iD) {
                    break;
                }
                i12 = i15;
                i13 = i10;
            }
            i13 = i10;
        }
        if (g3Var.d() == 0 && i11 == i13) {
            return cArr;
        }
        throw new IllegalStateException();
    }

    public static byte[] i(g3 g3Var, byte[][] bArr) throws IOException {
        int iD = g3Var.d();
        if (iD >= bArr.length) {
            return g3Var.h();
        }
        byte[] bArr2 = bArr[iD];
        if (bArr2 == null) {
            bArr2 = new byte[iD];
            bArr[iD] = bArr2;
        }
        g3Var.f(bArr2);
        return bArr2;
    }

    public static int m(InputStream inputStream, int i10, boolean z10) throws IOException {
        int i11 = inputStream.read();
        if ((i11 >>> 7) == 0) {
            return i11;
        }
        if (128 == i11) {
            return -1;
        }
        if (i11 < 0) {
            throw new EOFException("EOF found when length expected");
        }
        if (255 == i11) {
            throw new IOException("invalid long form definite-length 0xFF");
        }
        int i12 = i11 & 127;
        int i13 = 0;
        int i14 = 0;
        do {
            int i15 = inputStream.read();
            if (i15 < 0) {
                throw new EOFException("EOF found reading length");
            }
            if ((i13 >>> 23) != 0) {
                throw new IOException("long form definite-length more than 31 bits");
            }
            i13 = (i13 << 8) + i15;
            i14++;
        } while (i14 < i12);
        if (i13 < i10 || z10) {
            return i13;
        }
        throw new IOException("corrupted stream - out of bounds length found: " + i13 + " >= " + i10);
    }

    public static int u(InputStream inputStream, int i10) throws IOException {
        int i11 = i10 & 31;
        if (i11 != 31) {
            return i11;
        }
        int i12 = 0;
        int i13 = inputStream.read();
        if (i13 < 31) {
            if (i13 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            throw new IOException("corrupted stream - high tag number < 31 found");
        }
        if ((i13 & 127) == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        while ((i13 & 128) != 0) {
            if ((i12 >>> 24) != 0) {
                throw new IOException("Tag number more than 31 bits");
            }
            i12 = (i12 | (i13 & 127)) << 7;
            i13 = inputStream.read();
            if (i13 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
        }
        return i12 | (i13 & 127);
    }

    public i I() throws IOException {
        c0 c0VarN = n();
        if (c0VarN == null) {
            return new i(0);
        }
        i iVar = new i();
        do {
            iVar.a(c0VarN);
            c0VarN = n();
        } while (c0VarN != null);
        return iVar;
    }

    public i L(g3 g3Var) throws IOException {
        int iD = g3Var.d();
        return iD < 1 ? new i(0) : new s(g3Var, iD, this.f29800b, this.f29801c).I();
    }

    public d a(i iVar) throws IOException {
        int i10 = iVar.i();
        d[] dVarArr = new d[i10];
        for (int i11 = 0; i11 != i10; i11++) {
            h hVarG = iVar.g(i11);
            if (!(hVarG instanceof d)) {
                throw new ASN1Exception("unknown object encountered in constructed BIT STRING: " + hVarG.getClass());
            }
            dVarArr[i11] = (d) hVarG;
        }
        return new a1(dVarArr);
    }

    public z c(i iVar) throws IOException {
        int i10 = iVar.i();
        z[] zVarArr = new z[i10];
        for (int i11 = 0; i11 != i10; i11++) {
            h hVarG = iVar.g(i11);
            if (!(hVarG instanceof z)) {
                throw new ASN1Exception("unknown object encountered in constructed OCTET STRING: " + hVarG.getClass());
            }
            zVarArr[i11] = (z) hVarG;
        }
        return new e1(zVarArr);
    }

    public c0 d(int i10, int i11, int i12) throws IOException {
        g3 g3Var = new g3(this, i12, this.f29799a);
        if ((i10 & 224) == 0) {
            return f(i11, g3Var, this.f29801c);
        }
        int i13 = i10 & 192;
        if (i13 != 0) {
            return z(i13, i11, (i10 & 32) != 0, g3Var);
        }
        if (i11 == 3) {
            return a(L(g3Var));
        }
        if (i11 == 4) {
            return c(L(g3Var));
        }
        if (i11 == 8) {
            return x2.a(L(g3Var)).O();
        }
        if (i11 == 16) {
            return g3Var.d() < 1 ? x2.f29825a : this.f29800b ? new k3(g3Var.h()) : x2.a(L(g3Var));
        }
        if (i11 == 17) {
            return x2.b(L(g3Var));
        }
        throw new IOException("unknown tag " + i11 + " encountered");
    }

    public int k() {
        return this.f29799a;
    }

    public int l() throws IOException {
        return m(this, this.f29799a, false);
    }

    public c0 n() throws IOException {
        int i10 = read();
        if (i10 <= 0) {
            if (i10 != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int iU = u(this, i10);
        int iL = l();
        if (iL >= 0) {
            try {
                return d(i10, iU, iL);
            } catch (IllegalArgumentException e10) {
                throw new ASN1Exception("corrupted stream detected", e10);
            }
        }
        if ((i10 & 32) == 0) {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
        j0 j0Var = new j0(new i3(this, this.f29799a), this.f29799a, this.f29801c);
        int i11 = i10 & 192;
        if (i11 != 0) {
            return j0Var.c(i11, iU);
        }
        if (iU == 3) {
            return b1.c(j0Var);
        }
        if (iU == 4) {
            return g1.c(j0Var);
        }
        if (iU == 8) {
            return w1.c(j0Var);
        }
        if (iU == 16) {
            return k1.c(j0Var);
        }
        if (iU == 17) {
            return m1.c(j0Var);
        }
        throw new IOException("unknown BER object encountered");
    }

    public void readFully(byte[] bArr) throws IOException {
        if (kt.c.h(this, bArr, 0, bArr.length) != bArr.length) {
            throw new EOFException("EOF encountered in middle of object");
        }
    }

    public c0 z(int i10, int i11, boolean z10, g3 g3Var) throws IOException {
        return !z10 ? n0.J(i10, i11, g3Var.h()) : n0.H(i10, i11, L(g3Var));
    }
}

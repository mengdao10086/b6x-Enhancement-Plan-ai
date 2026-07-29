package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f45728a = new ByteArrayOutputStream();

    public static a i() {
        return new a();
    }

    public a a(boolean z10) {
        this.f45728a.write(z10 ? 1 : 0);
        return this;
    }

    public byte[] b() {
        return this.f45728a.toByteArray();
    }

    public a c(org.bouncycastle.util.g gVar) {
        try {
            this.f45728a.write(gVar.getEncoded());
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public a d(byte[] bArr) {
        try {
            this.f45728a.write(bArr);
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public a e(byte[] bArr, int i10, int i11) {
        try {
            this.f45728a.write(bArr, i10, i11);
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public a f(org.bouncycastle.util.g[] gVarArr) {
        try {
            for (org.bouncycastle.util.g gVar : gVarArr) {
                this.f45728a.write(gVar.getEncoded());
            }
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public a g(byte[][] bArr) {
        try {
            for (byte[] bArr2 : bArr) {
                this.f45728a.write(bArr2);
            }
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public a h(byte[][] bArr, int i10, int i11) {
        while (i10 != i11) {
            try {
                this.f45728a.write(bArr[i10]);
                i10++;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage(), e10);
            }
        }
        return this;
    }

    public a j(int i10, int i11) {
        while (i11 >= 0) {
            try {
                this.f45728a.write(i10);
                i11--;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage(), e10);
            }
        }
        return this;
    }

    public a k(int i10, int i11) {
        while (this.f45728a.size() < i11) {
            this.f45728a.write(i10);
        }
        return this;
    }

    public a l(int i10) {
        int i11 = i10 & 65535;
        this.f45728a.write((byte) (i11 >>> 8));
        this.f45728a.write((byte) i11);
        return this;
    }

    public a m(int i10) {
        this.f45728a.write((byte) (i10 >>> 24));
        this.f45728a.write((byte) (i10 >>> 16));
        this.f45728a.write((byte) (i10 >>> 8));
        this.f45728a.write((byte) i10);
        return this;
    }

    public a n(long j10) {
        m((int) (j10 >>> 32));
        m((int) j10);
        return this;
    }
}

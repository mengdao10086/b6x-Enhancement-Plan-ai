package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class g extends s implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f45745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f45746c;

    public g(int i10, v vVar) {
        super(false);
        this.f45745b = i10;
        this.f45746c = vVar;
    }

    public static g d(Object obj) throws Throwable {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj instanceof DataInputStream) {
            return new g(((DataInputStream) obj).readInt(), v.f(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return d(kt.c.e((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                g gVarD = d(dataInputStream2);
                dataInputStream2.close();
                return gVarD;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // org.bouncycastle.pqc.crypto.lms.p
    public n a(byte[] bArr) throws Throwable {
        try {
            h hVarA = h.a(bArr, e());
            x[] xVarArrC = hVarA.c();
            return xVarArrC[xVarArrC.length - 1].a().d(hVarA.b()).o(xVarArrC);
        } catch (IOException e10) {
            throw new IllegalStateException("cannot parse signature: " + e10.getMessage());
        }
    }

    @Override // org.bouncycastle.pqc.crypto.lms.p
    public boolean b(n nVar) {
        x[] xVarArrN = nVar.n();
        if (xVarArrN.length != e() - 1) {
            return false;
        }
        v vVarF = f();
        boolean z10 = false;
        for (int i10 = 0; i10 < xVarArrN.length; i10++) {
            if (!m.e(vVarF, xVarArrN[i10].b(), xVarArrN[i10].a().toByteArray())) {
                z10 = true;
            }
            vVarF = xVarArrN[i10].a();
        }
        return vVarF.b(nVar) & (!z10);
    }

    public int e() {
        return this.f45745b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f45745b != gVar.f45745b) {
            return false;
        }
        return this.f45746c.equals(gVar.f45746c);
    }

    public v f() {
        return this.f45746c;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.s, org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return a.i().m(this.f45745b).d(this.f45746c.getEncoded()).b();
    }

    public int hashCode() {
        return (this.f45745b * 31) + this.f45746c.hashCode();
    }
}

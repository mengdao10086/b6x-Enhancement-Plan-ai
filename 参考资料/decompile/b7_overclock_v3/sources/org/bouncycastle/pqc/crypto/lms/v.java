package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class v extends s implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LMSigParameters f45790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LMOtsParameters f45791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f45792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f45793e;

    public v(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, byte[] bArr, byte[] bArr2) {
        super(false);
        this.f45790b = lMSigParameters;
        this.f45791c = lMOtsParameters;
        this.f45792d = org.bouncycastle.util.a.p(bArr2);
        this.f45793e = org.bouncycastle.util.a.p(bArr);
    }

    public static v f(Object obj) throws Throwable {
        if (obj instanceof v) {
            return (v) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            LMSigParameters lMSigParametersE = LMSigParameters.e(dataInputStream.readInt());
            LMOtsParameters lMOtsParametersF = LMOtsParameters.f(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[lMSigParametersE.d()];
            dataInputStream.readFully(bArr2);
            return new v(lMSigParametersE, lMOtsParametersF, bArr2, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return f(kt.c.e((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                v vVarF = f(dataInputStream3);
                dataInputStream3.close();
                return vVarF;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // org.bouncycastle.pqc.crypto.lms.p
    public n a(byte[] bArr) {
        try {
            return d(w.a(bArr));
        } catch (IOException e10) {
            throw new IllegalStateException("cannot parse signature: " + e10.getMessage());
        }
    }

    @Override // org.bouncycastle.pqc.crypto.lms.p
    public boolean b(n nVar) {
        return m.d(this, nVar);
    }

    public n d(w wVar) {
        int iH = h().h();
        if (wVar.b().c().h() == iH) {
            return new k(LMOtsParameters.f(iH), this.f45792d, wVar.d(), null).b(wVar);
        }
        throw new IllegalArgumentException("ots type from lsm signature does not match ots signature type from embedded ots signature");
    }

    public byte[] e() {
        return org.bouncycastle.util.a.p(this.f45792d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f45790b.equals(vVar.f45790b) && this.f45791c.equals(vVar.f45791c) && org.bouncycastle.util.a.g(this.f45792d, vVar.f45792d)) {
            return org.bouncycastle.util.a.g(this.f45793e, vVar.f45793e);
        }
        return false;
    }

    public t g() {
        return new t(i(), h());
    }

    @Override // org.bouncycastle.pqc.crypto.lms.s, org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public LMOtsParameters h() {
        return this.f45791c;
    }

    public int hashCode() {
        return (((((this.f45790b.hashCode() * 31) + this.f45791c.hashCode()) * 31) + org.bouncycastle.util.a.s0(this.f45792d)) * 31) + org.bouncycastle.util.a.s0(this.f45793e);
    }

    public LMSigParameters i() {
        return this.f45790b;
    }

    public byte[] j() {
        return org.bouncycastle.util.a.p(this.f45793e);
    }

    public boolean k(byte[] bArr) {
        return org.bouncycastle.util.a.I(this.f45793e, bArr);
    }

    public byte[] l() {
        return this.f45792d;
    }

    public byte[] toByteArray() {
        return a.i().m(this.f45790b.f()).m(this.f45791c.h()).d(this.f45792d).d(this.f45793e).b();
    }
}

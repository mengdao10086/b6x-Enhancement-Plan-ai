package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class k implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LMOtsParameters f45756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f45757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f45759d;

    public k(LMOtsParameters lMOtsParameters, byte[] bArr, int i10, byte[] bArr2) {
        this.f45756a = lMOtsParameters;
        this.f45757b = bArr;
        this.f45758c = i10;
        this.f45759d = bArr2;
    }

    public static k d(Object obj) throws Exception {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            LMOtsParameters lMOtsParametersF = LMOtsParameters.f(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            int i10 = dataInputStream.readInt();
            byte[] bArr2 = new byte[lMOtsParametersF.d()];
            dataInputStream.readFully(bArr2);
            return new k(lMOtsParametersF, bArr, i10, bArr2);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return d(kt.c.e((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                k kVarD = d(dataInputStream3);
                dataInputStream3.close();
                return kVarD;
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

    public n a(l lVar) {
        org.bouncycastle.crypto.s sVarA = b.a(this.f45756a.b());
        a0.b(this.f45757b, sVarA);
        a0.e(this.f45758c, sVarA);
        a0.d(z.f45809h, sVarA);
        a0.b(lVar.a(), sVarA);
        return new n(this, lVar, sVarA);
    }

    public n b(w wVar) {
        org.bouncycastle.crypto.s sVarA = b.a(this.f45756a.b());
        a0.b(this.f45757b, sVarA);
        a0.e(this.f45758c, sVarA);
        a0.d(z.f45809h, sVarA);
        a0.b(wVar.b().a(), sVarA);
        return new n(this, wVar, sVarA);
    }

    public byte[] c() {
        return this.f45757b;
    }

    public byte[] e() {
        return this.f45759d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f45758c != kVar.f45758c) {
            return false;
        }
        LMOtsParameters lMOtsParameters = this.f45756a;
        if (lMOtsParameters == null ? kVar.f45756a != null : !lMOtsParameters.equals(kVar.f45756a)) {
            return false;
        }
        if (Arrays.equals(this.f45757b, kVar.f45757b)) {
            return Arrays.equals(this.f45759d, kVar.f45759d);
        }
        return false;
    }

    public LMOtsParameters f() {
        return this.f45756a;
    }

    public int g() {
        return this.f45758c;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return a.i().m(this.f45756a.h()).d(this.f45757b).m(this.f45758c).d(this.f45759d).b();
    }

    public int hashCode() {
        LMOtsParameters lMOtsParameters = this.f45756a;
        return ((((((lMOtsParameters != null ? lMOtsParameters.hashCode() : 0) * 31) + Arrays.hashCode(this.f45757b)) * 31) + this.f45758c) * 31) + Arrays.hashCode(this.f45759d);
    }
}

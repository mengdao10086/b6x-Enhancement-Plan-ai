package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class l implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LMOtsParameters f45760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f45761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f45762c;

    public l(LMOtsParameters lMOtsParameters, byte[] bArr, byte[] bArr2) {
        this.f45760a = lMOtsParameters;
        this.f45761b = bArr;
        this.f45762c = bArr2;
    }

    public static l b(Object obj) throws Throwable {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            LMOtsParameters lMOtsParametersF = LMOtsParameters.f(dataInputStream.readInt());
            byte[] bArr = new byte[lMOtsParametersF.d()];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[lMOtsParametersF.e() * lMOtsParametersF.d()];
            dataInputStream.readFully(bArr2);
            return new l(lMOtsParametersF, bArr, bArr2);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return b(kt.c.e((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                l lVarB = b(dataInputStream3);
                dataInputStream3.close();
                return lVarB;
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

    public byte[] a() {
        return this.f45761b;
    }

    public LMOtsParameters c() {
        return this.f45760a;
    }

    public byte[] d() {
        return this.f45762c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        LMOtsParameters lMOtsParameters = this.f45760a;
        if (lMOtsParameters == null ? lVar.f45760a != null : !lMOtsParameters.equals(lVar.f45760a)) {
            return false;
        }
        if (Arrays.equals(this.f45761b, lVar.f45761b)) {
            return Arrays.equals(this.f45762c, lVar.f45762c);
        }
        return false;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return a.i().m(this.f45760a.h()).d(this.f45761b).d(this.f45762c).b();
    }

    public int hashCode() {
        LMOtsParameters lMOtsParameters = this.f45760a;
        return ((((lMOtsParameters != null ? lMOtsParameters.hashCode() : 0) * 31) + Arrays.hashCode(this.f45761b)) * 31) + Arrays.hashCode(this.f45762c);
    }
}

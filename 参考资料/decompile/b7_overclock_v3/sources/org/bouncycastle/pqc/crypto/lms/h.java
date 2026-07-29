package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class h implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x[] f45748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f45749c;

    public h(int i10, x[] xVarArr, w wVar) {
        this.f45747a = i10;
        this.f45748b = xVarArr;
        this.f45749c = wVar;
    }

    public static h a(Object obj, int i10) throws Throwable {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj instanceof DataInputStream) {
            int i11 = ((DataInputStream) obj).readInt();
            if (i11 != i10 - 1) {
                throw new IllegalStateException("nspk exceeded maxNspk");
            }
            x[] xVarArr = new x[i11];
            if (i11 != 0) {
                for (int i12 = 0; i12 < i11; i12++) {
                    xVarArr[i12] = new x(w.a(obj), v.f(obj));
                }
            }
            return new h(i11, xVarArr, w.a(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(kt.c.e((InputStream) obj), i10);
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                h hVarA = a(dataInputStream2, i10);
                dataInputStream2.close();
                return hVarA;
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

    public w b() {
        return this.f45749c;
    }

    public x[] c() {
        return this.f45748b;
    }

    public int d() {
        return this.f45747a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f45747a != hVar.f45747a || this.f45748b.length != hVar.f45748b.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            x[] xVarArr = this.f45748b;
            if (i10 >= xVarArr.length) {
                w wVar = this.f45749c;
                w wVar2 = hVar.f45749c;
                return wVar != null ? wVar.equals(wVar2) : wVar2 == null;
            }
            if (!xVarArr[i10].equals(hVar.f45748b[i10])) {
                return false;
            }
            i10++;
        }
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        a aVarI = a.i();
        aVarI.m(this.f45747a);
        x[] xVarArr = this.f45748b;
        if (xVarArr != null) {
            for (x xVar : xVarArr) {
                aVarI.c(xVar);
            }
        }
        aVarI.c(this.f45749c);
        return aVarI.b();
    }

    public int hashCode() {
        int iHashCode = ((this.f45747a * 31) + Arrays.hashCode(this.f45748b)) * 31;
        w wVar = this.f45749c;
        return iHashCode + (wVar != null ? wVar.hashCode() : 0);
    }
}

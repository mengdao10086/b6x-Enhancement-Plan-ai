package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class w implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f45795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LMSigParameters f45796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[][] f45797d;

    public w(int i10, l lVar, LMSigParameters lMSigParameters, byte[][] bArr) {
        this.f45794a = i10;
        this.f45795b = lVar;
        this.f45796c = lMSigParameters;
        this.f45797d = bArr;
    }

    public static w a(Object obj) throws Throwable {
        if (obj instanceof w) {
            return (w) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            int i10 = dataInputStream.readInt();
            l lVarB = l.b(obj);
            LMSigParameters lMSigParametersE = LMSigParameters.e(dataInputStream.readInt());
            int iC = lMSigParametersE.c();
            byte[][] bArr = new byte[iC][];
            for (int i11 = 0; i11 < iC; i11++) {
                bArr[i11] = new byte[lMSigParametersE.d()];
                dataInputStream.readFully(bArr[i11]);
            }
            return new w(i10, lVarB, lMSigParametersE, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(kt.c.e((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                w wVarA = a(dataInputStream3);
                dataInputStream3.close();
                return wVarA;
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

    public l b() {
        return this.f45795b;
    }

    public LMSigParameters c() {
        return this.f45796c;
    }

    public int d() {
        return this.f45794a;
    }

    public byte[][] e() {
        return this.f45797d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        w wVar = (w) obj;
        if (this.f45794a != wVar.f45794a) {
            return false;
        }
        l lVar = this.f45795b;
        if (lVar == null ? wVar.f45795b != null : !lVar.equals(wVar.f45795b)) {
            return false;
        }
        LMSigParameters lMSigParameters = this.f45796c;
        if (lMSigParameters == null ? wVar.f45796c == null : lMSigParameters.equals(wVar.f45796c)) {
            return Arrays.deepEquals(this.f45797d, wVar.f45797d);
        }
        return false;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return a.i().m(this.f45794a).d(this.f45795b.getEncoded()).m(this.f45796c.f()).g(this.f45797d).b();
    }

    public int hashCode() {
        int i10 = this.f45794a * 31;
        l lVar = this.f45795b;
        int iHashCode = (i10 + (lVar != null ? lVar.hashCode() : 0)) * 31;
        LMSigParameters lMSigParameters = this.f45796c;
        return ((iHashCode + (lMSigParameters != null ? lMSigParameters.hashCode() : 0)) * 31) + Arrays.deepHashCode(this.f45797d);
    }
}

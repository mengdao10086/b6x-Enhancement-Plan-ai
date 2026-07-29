package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;

/* JADX INFO: loaded from: classes6.dex */
public class u extends s implements o {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static a f45777l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static a[] f45778m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f45779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LMSigParameters f45780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LMOtsParameters f45781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f45782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f45783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<a, byte[]> f45784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f45785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f45786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f45787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v f45788k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45789a;

        public a(int i10) {
            this.f45789a = i10;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && ((a) obj).f45789a == this.f45789a;
        }

        public int hashCode() {
            return this.f45789a;
        }
    }

    static {
        a aVar = new a(1);
        f45777l = aVar;
        a[] aVarArr = new a[129];
        f45778m = aVarArr;
        aVarArr[1] = aVar;
        int i10 = 2;
        while (true) {
            a[] aVarArr2 = f45778m;
            if (i10 >= aVarArr2.length) {
                return;
            }
            aVarArr2[i10] = new a(i10);
            i10++;
        }
    }

    public u(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i10, byte[] bArr, int i11, byte[] bArr2) {
        super(true);
        this.f45780c = lMSigParameters;
        this.f45781d = lMOtsParameters;
        this.f45787j = i10;
        this.f45779b = org.bouncycastle.util.a.p(bArr);
        this.f45782e = i11;
        this.f45783f = org.bouncycastle.util.a.p(bArr2);
        this.f45785h = 1 << (lMSigParameters.c() + 1);
        this.f45784g = new WeakHashMap();
        this.f45786i = b.a(lMSigParameters.b());
    }

    public u(u uVar, int i10, int i11) {
        super(true);
        LMSigParameters lMSigParameters = uVar.f45780c;
        this.f45780c = lMSigParameters;
        this.f45781d = uVar.f45781d;
        this.f45787j = i10;
        this.f45779b = uVar.f45779b;
        this.f45782e = i11;
        this.f45783f = uVar.f45783f;
        this.f45785h = 1 << lMSigParameters.c();
        this.f45784g = uVar.f45784g;
        this.f45786i = b.a(lMSigParameters.b());
        this.f45788k = uVar.f45788k;
    }

    public static u k(Object obj) throws Throwable {
        DataInputStream dataInputStream;
        if (obj instanceof u) {
            return (u) obj;
        }
        if (!(obj instanceof DataInputStream)) {
            if (!(obj instanceof byte[])) {
                if (obj instanceof InputStream) {
                    return k(kt.c.e((InputStream) obj));
                }
                throw new IllegalArgumentException("cannot parse " + obj);
            }
            DataInputStream dataInputStream2 = null;
            try {
                dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                u uVarK = k(dataInputStream);
                dataInputStream.close();
                return uVarK;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        }
        DataInputStream dataInputStream3 = (DataInputStream) obj;
        if (dataInputStream3.readInt() != 0) {
            throw new IllegalStateException("expected version 0 lms private key");
        }
        LMSigParameters lMSigParametersE = LMSigParameters.e(dataInputStream3.readInt());
        LMOtsParameters lMOtsParametersF = LMOtsParameters.f(dataInputStream3.readInt());
        byte[] bArr = new byte[16];
        dataInputStream3.readFully(bArr);
        int i10 = dataInputStream3.readInt();
        int i11 = dataInputStream3.readInt();
        int i12 = dataInputStream3.readInt();
        if (i12 < 0) {
            throw new IllegalStateException("secret length less than zero");
        }
        if (i12 <= dataInputStream3.available()) {
            byte[] bArr2 = new byte[i12];
            dataInputStream3.readFully(bArr2);
            return new u(lMSigParametersE, lMOtsParametersF, i10, bArr, i11, bArr2);
        }
        throw new IOException("secret length exceeded " + dataInputStream3.available());
    }

    public static u l(byte[] bArr, byte[] bArr2) throws Throwable {
        u uVarK = k(bArr);
        uVarK.f45788k = v.f(bArr2);
        return uVarK;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.o
    public long V() {
        return this.f45782e - this.f45787j;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.o
    public n W() {
        int iC = q().c();
        int iJ = j();
        j jVarN = n();
        int i10 = (1 << iC) + iJ;
        byte[][] bArr = new byte[iC][];
        for (int i11 = 0; i11 < iC; i11++) {
            bArr[i11] = f((i10 / (1 << i11)) ^ 1);
        }
        return jVarN.f(q(), bArr);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.o
    public byte[] X(n nVar) {
        try {
            return m.b(nVar).getEncoded();
        } catch (IOException e10) {
            throw new IllegalStateException("unable to encode signature: " + e10.getMessage(), e10);
        }
    }

    public final byte[] d(int i10) {
        int iC = 1 << q().c();
        if (i10 >= iC) {
            a0.b(i(), this.f45786i);
            a0.e(i10, this.f45786i);
            a0.d(m.f45763a, this.f45786i);
            a0.b(z.i(o(), i(), i10 - iC, m()), this.f45786i);
            byte[] bArr = new byte[this.f45786i.h()];
            this.f45786i.c(bArr, 0);
            return bArr;
        }
        int i11 = i10 * 2;
        byte[] bArrF = f(i11);
        byte[] bArrF2 = f(i11 + 1);
        a0.b(i(), this.f45786i);
        a0.e(i10, this.f45786i);
        a0.d(m.f45764b, this.f45786i);
        a0.b(bArrF, this.f45786i);
        a0.b(bArrF2, this.f45786i);
        byte[] bArr2 = new byte[this.f45786i.h()];
        this.f45786i.c(bArr2, 0);
        return bArr2;
    }

    public u e(int i10) {
        u uVar;
        synchronized (this) {
            int i11 = this.f45787j;
            if (i11 + i10 >= this.f45782e) {
                throw new IllegalArgumentException("usageCount exceeds usages remaining");
            }
            uVar = new u(this, i11, i11 + i10);
            this.f45787j += i10;
        }
        return uVar;
    }

    public boolean equals(Object obj) {
        v vVar;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f45787j != uVar.f45787j || this.f45782e != uVar.f45782e || !org.bouncycastle.util.a.g(this.f45779b, uVar.f45779b)) {
            return false;
        }
        LMSigParameters lMSigParameters = this.f45780c;
        if (lMSigParameters == null ? uVar.f45780c != null : !lMSigParameters.equals(uVar.f45780c)) {
            return false;
        }
        LMOtsParameters lMOtsParameters = this.f45781d;
        if (lMOtsParameters == null ? uVar.f45781d != null : !lMOtsParameters.equals(uVar.f45781d)) {
            return false;
        }
        if (!org.bouncycastle.util.a.g(this.f45783f, uVar.f45783f)) {
            return false;
        }
        v vVar2 = this.f45788k;
        if (vVar2 == null || (vVar = uVar.f45788k) == null) {
            return true;
        }
        return vVar2.equals(vVar);
    }

    public byte[] f(int i10) {
        if (i10 >= this.f45785h) {
            return d(i10);
        }
        a[] aVarArr = f45778m;
        return g(i10 < aVarArr.length ? aVarArr[i10] : new a(i10));
    }

    public final byte[] g(a aVar) {
        synchronized (this.f45784g) {
            byte[] bArr = this.f45784g.get(aVar);
            if (bArr != null) {
                return bArr;
            }
            byte[] bArrD = d(aVar.f45789a);
            this.f45784g.put(aVar, bArrD);
            return bArrD;
        }
    }

    @Override // org.bouncycastle.pqc.crypto.lms.s, org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return org.bouncycastle.pqc.crypto.lms.a.i().m(0).m(this.f45780c.f()).m(this.f45781d.h()).d(this.f45779b).m(this.f45787j).m(this.f45782e).m(this.f45783f.length).d(this.f45783f).b();
    }

    public j h() {
        j jVar;
        synchronized (this) {
            int i10 = this.f45787j;
            if (i10 >= this.f45782e) {
                throw new ExhaustedPrivateKeyException("ots private keys expired");
            }
            jVar = new j(this.f45781d, this.f45779b, i10, this.f45783f);
        }
        return jVar;
    }

    public int hashCode() {
        int iS0 = ((this.f45787j * 31) + org.bouncycastle.util.a.s0(this.f45779b)) * 31;
        LMSigParameters lMSigParameters = this.f45780c;
        int iHashCode = (iS0 + (lMSigParameters != null ? lMSigParameters.hashCode() : 0)) * 31;
        LMOtsParameters lMOtsParameters = this.f45781d;
        int iHashCode2 = (((((iHashCode + (lMOtsParameters != null ? lMOtsParameters.hashCode() : 0)) * 31) + this.f45782e) * 31) + org.bouncycastle.util.a.s0(this.f45783f)) * 31;
        v vVar = this.f45788k;
        return iHashCode2 + (vVar != null ? vVar.hashCode() : 0);
    }

    public byte[] i() {
        return org.bouncycastle.util.a.p(this.f45779b);
    }

    public synchronized int j() {
        return this.f45787j;
    }

    public byte[] m() {
        return org.bouncycastle.util.a.p(this.f45783f);
    }

    public j n() {
        j jVar;
        synchronized (this) {
            int i10 = this.f45787j;
            if (i10 >= this.f45782e) {
                throw new ExhaustedPrivateKeyException("ots private key exhausted");
            }
            jVar = new j(this.f45781d, this.f45779b, i10, this.f45783f);
            r();
        }
        return jVar;
    }

    public LMOtsParameters o() {
        return this.f45781d;
    }

    public v p() {
        v vVar;
        synchronized (this) {
            if (this.f45788k == null) {
                this.f45788k = new v(this.f45780c, this.f45781d, g(f45777l), this.f45779b);
            }
            vVar = this.f45788k;
        }
        return vVar;
    }

    public LMSigParameters q() {
        return this.f45780c;
    }

    public synchronized void r() {
        this.f45787j++;
    }
}

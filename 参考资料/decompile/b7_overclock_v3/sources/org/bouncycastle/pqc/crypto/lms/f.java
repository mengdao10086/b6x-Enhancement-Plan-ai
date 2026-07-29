package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class f extends s implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f45738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f45739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<u> f45740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<w> f45741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f45742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f45743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f45744h;

    public f(int i10, List<u> list, List<w> list2, long j10, long j11) {
        super(true);
        this.f45743g = 0L;
        this.f45738b = i10;
        this.f45740d = Collections.unmodifiableList(list);
        this.f45741e = Collections.unmodifiableList(list2);
        this.f45743g = j10;
        this.f45742f = j11;
        this.f45739c = false;
        s();
    }

    public f(int i10, List<u> list, List<w> list2, long j10, long j11, boolean z10) {
        super(true);
        this.f45743g = 0L;
        this.f45738b = i10;
        this.f45740d = Collections.unmodifiableList(list);
        this.f45741e = Collections.unmodifiableList(list2);
        this.f45743g = j10;
        this.f45742f = j11;
        this.f45739c = z10;
    }

    public static f g(Object obj) throws Throwable {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("unknown version for hss private key");
            }
            int i10 = dataInputStream.readInt();
            long j10 = dataInputStream.readLong();
            long j11 = dataInputStream.readLong();
            boolean z10 = dataInputStream.readBoolean();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(u.k(obj));
            }
            for (int i12 = 0; i12 < i10 - 1; i12++) {
                arrayList2.add(w.a(obj));
            }
            return new f(i10, arrayList, arrayList2, j10, j11, z10);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return g(kt.c.e((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                f fVarG = g(dataInputStream3);
                dataInputStream3.close();
                return fVarG;
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

    public static f h(byte[] bArr, byte[] bArr2) throws Throwable {
        f fVarG = g(bArr);
        fVarG.f45744h = g.d(bArr2);
        return fVarG;
    }

    public static f q(f fVar) {
        try {
            return g(fVar.getEncoded());
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    @Override // org.bouncycastle.pqc.crypto.lms.o
    public long V() {
        return this.f45742f - this.f45743g;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.o
    public n W() {
        u uVar;
        x[] xVarArr;
        int iJ = j();
        synchronized (this) {
            c.e(this);
            List<u> listI = i();
            List<w> listN = n();
            int i10 = iJ - 1;
            uVar = i().get(i10);
            int i11 = 0;
            xVarArr = new x[i10];
            while (i11 < i10) {
                int i12 = i11 + 1;
                xVarArr[i11] = new x(listN.get(i11), listI.get(i12).p());
                i11 = i12;
            }
            o();
        }
        return uVar.W().o(xVarArr);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.o
    public byte[] X(n nVar) {
        try {
            return c.b(j(), nVar).getEncoded();
        } catch (IOException e10) {
            throw new IllegalStateException("unable to encode signature: " + e10.getMessage(), e10);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return q(this);
    }

    public f d(int i10) {
        f fVarQ;
        synchronized (this) {
            long j10 = i10;
            if (V() < j10) {
                throw new IllegalArgumentException("usageCount exceeds usages remaining in current leaf");
            }
            long j11 = this.f45743g;
            this.f45743g = j10 + j11;
            fVarQ = q(new f(this.f45738b, new ArrayList(i()), new ArrayList(n()), j11, j11 + j10, true));
            s();
        }
        return fVarQ;
    }

    public synchronized long e() {
        return this.f45743g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f45738b == fVar.f45738b && this.f45739c == fVar.f45739c && this.f45742f == fVar.f45742f && this.f45743g == fVar.f45743g && this.f45740d.equals(fVar.f45740d)) {
            return this.f45741e.equals(fVar.f45741e);
        }
        return false;
    }

    public long f() {
        return this.f45742f;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.s, org.bouncycastle.util.g
    public synchronized byte[] getEncoded() throws IOException {
        a aVarA;
        aVarA = a.i().m(0).m(this.f45738b).n(this.f45743g).n(this.f45742f).a(this.f45739c);
        Iterator<u> it2 = this.f45740d.iterator();
        while (it2.hasNext()) {
            aVarA.c(it2.next());
        }
        Iterator<w> it3 = this.f45741e.iterator();
        while (it3.hasNext()) {
            aVarA.c(it3.next());
        }
        return aVarA.b();
    }

    public int hashCode() {
        int iHashCode = ((((((this.f45738b * 31) + (this.f45739c ? 1 : 0)) * 31) + this.f45740d.hashCode()) * 31) + this.f45741e.hashCode()) * 31;
        long j10 = this.f45742f;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f45743g;
        return i10 + ((int) (j11 ^ (j11 >>> 32)));
    }

    public synchronized List<u> i() {
        return this.f45740d;
    }

    public int j() {
        return this.f45738b;
    }

    public synchronized t[] k() {
        t[] tVarArr;
        int size = this.f45740d.size();
        tVarArr = new t[size];
        for (int i10 = 0; i10 < size; i10++) {
            u uVar = this.f45740d.get(i10);
            tVarArr[i10] = new t(uVar.q(), uVar.o());
        }
        return tVarArr;
    }

    public synchronized g l() {
        return new g(this.f45738b, m().p());
    }

    public u m() {
        return this.f45740d.get(0);
    }

    public synchronized List<w> n() {
        return this.f45741e;
    }

    public synchronized void o() {
        this.f45743g++;
    }

    public boolean p() {
        return this.f45739c;
    }

    public void r(int i10) {
        int i11 = i10 - 1;
        b0 b0VarA = this.f45740d.get(i11).h().a();
        b0VarA.h(-2);
        byte[] bArr = new byte[32];
        b0VarA.a(bArr, true);
        byte[] bArr2 = new byte[32];
        b0VarA.a(bArr2, false);
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr2, 0, bArr3, 0, 16);
        ArrayList arrayList = new ArrayList(this.f45740d);
        u uVar = this.f45740d.get(i10);
        arrayList.set(i10, m.a(uVar.q(), uVar.o(), 0, bArr3, bArr));
        ArrayList arrayList2 = new ArrayList(this.f45741e);
        arrayList2.set(i11, m.c((u) arrayList.get(i11), ((u) arrayList.get(i10)).p().toByteArray()));
        this.f45740d = Collections.unmodifiableList(arrayList);
        this.f45741e = Collections.unmodifiableList(arrayList2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s() {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.f.s():void");
    }

    public void t(u[] uVarArr, w[] wVarArr) {
        synchronized (this) {
            this.f45740d = Collections.unmodifiableList(Arrays.asList(uVarArr));
            this.f45741e = Collections.unmodifiableList(Arrays.asList(wVarArr));
        }
    }
}

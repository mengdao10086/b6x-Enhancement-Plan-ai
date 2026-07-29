package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.pqc.crypto.xmss.g;

/* JADX INFO: loaded from: classes6.dex */
public class BDSStateMap implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient long f45813a;
    private final Map<Integer, BDS> bdsState = new TreeMap();

    public BDSStateMap(long j10) {
        this.f45813a = j10;
    }

    public BDSStateMap(BDSStateMap bDSStateMap, long j10) {
        for (Integer num : bDSStateMap.bdsState.keySet()) {
            this.bdsState.put(num, new BDS(bDSStateMap.bdsState.get(num)));
        }
        this.f45813a = j10;
    }

    public BDSStateMap(w wVar, long j10, byte[] bArr, byte[] bArr2) {
        this.f45813a = (1 << wVar.a()) - 1;
        for (long j11 = 0; j11 < j10; j11++) {
            h(wVar, j11, bArr, bArr2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f45813a = objectInputStream.available() != 0 ? objectInputStream.readLong() : 0L;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.f45813a);
    }

    public BDS a(int i10) {
        return this.bdsState.get(org.bouncycastle.util.j.g(i10));
    }

    public long b() {
        return this.f45813a;
    }

    public boolean c() {
        return this.bdsState.isEmpty();
    }

    public void d(int i10, BDS bds) {
        this.bdsState.put(org.bouncycastle.util.j.g(i10), bds);
    }

    public BDS f(int i10, byte[] bArr, byte[] bArr2, g gVar) {
        return this.bdsState.put(org.bouncycastle.util.j.g(i10), this.bdsState.get(org.bouncycastle.util.j.g(i10)).f(bArr, bArr2, gVar));
    }

    public void h(w wVar, long j10, byte[] bArr, byte[] bArr2) {
        d0 d0VarJ = wVar.j();
        int iB = d0VarJ.b();
        long jL = k0.l(j10, iB);
        int iK = k0.k(j10, iB);
        g gVar = (g) new g.b().i(jL).p(iK).e();
        int i10 = (1 << iB) - 1;
        if (iK < i10) {
            if (a(0) == null || iK == 0) {
                d(0, new BDS(d0VarJ, bArr, bArr2, gVar));
            }
            f(0, bArr, bArr2, gVar);
        }
        for (int i11 = 1; i11 < wVar.b(); i11++) {
            int iK2 = k0.k(jL, iB);
            jL = k0.l(jL, iB);
            g gVar2 = (g) new g.b().h(i11).i(jL).p(iK2).e();
            if (this.bdsState.get(Integer.valueOf(i11)) == null || k0.p(j10, iB, i11)) {
                this.bdsState.put(Integer.valueOf(i11), new BDS(d0VarJ, bArr, bArr2, gVar2));
            }
            if (iK2 < i10 && k0.o(j10, iB, i11)) {
                f(i11, bArr, bArr2, gVar2);
            }
        }
    }

    public BDSStateMap i(gm.y yVar) {
        BDSStateMap bDSStateMap = new BDSStateMap(this.f45813a);
        for (Integer num : this.bdsState.keySet()) {
            bDSStateMap.bdsState.put(num, this.bdsState.get(num).q(yVar));
        }
        return bDSStateMap;
    }
}

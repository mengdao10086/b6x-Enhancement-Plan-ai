package org.bouncycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.g;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f45891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f45892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f45893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f45894d;

    public h(j jVar) {
        Objects.requireNonNull(jVar, "params == null");
        this.f45891a = jVar;
        int iF = jVar.f();
        this.f45892b = new e(jVar.e(), iF);
        this.f45893c = new byte[iF];
        this.f45894d = new byte[iF];
    }

    public final byte[] a(byte[] bArr, int i10, int i11, g gVar) {
        int iF = this.f45891a.f();
        Objects.requireNonNull(bArr, "startHash == null");
        if (bArr.length != iF) {
            throw new IllegalArgumentException("startHash needs to be " + iF + "bytes");
        }
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        Objects.requireNonNull(gVar.e(), "otsHashAddress byte array == null");
        int i12 = i10 + i11;
        if (i12 > this.f45891a.g() - 1) {
            throw new IllegalArgumentException("max chain length must not be greater than w");
        }
        if (i11 == 0) {
            return bArr;
        }
        byte[] bArrA = a(bArr, i10, i11 - 1, gVar);
        g gVar2 = (g) new g.b().h(gVar.b()).i(gVar.c()).p(gVar.h()).n(gVar.f()).o(i12 - 1).g(0).e();
        byte[] bArrD = this.f45892b.d(this.f45894d, gVar2.e());
        byte[] bArrD2 = this.f45892b.d(this.f45894d, ((g) new g.b().h(gVar2.b()).i(gVar2.c()).p(gVar2.h()).n(gVar2.f()).o(gVar2.g()).g(1).e()).e());
        byte[] bArr2 = new byte[iF];
        for (int i13 = 0; i13 < iF; i13++) {
            bArr2[i13] = (byte) (bArrA[i13] ^ bArrD2[i13]);
        }
        return this.f45892b.a(bArrD, bArr2);
    }

    public final List<Integer> b(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "msg == null");
        if (i10 != 4 && i10 != 16) {
            throw new IllegalArgumentException("w needs to be 4 or 16");
        }
        int iQ = k0.q(i10);
        if (i11 > (bArr.length * 8) / iQ) {
            throw new IllegalArgumentException("outLength too big");
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 : bArr) {
            for (int i13 = 8 - iQ; i13 >= 0; i13 -= iQ) {
                arrayList.add(Integer.valueOf((i12 >> i13) & (i10 - 1)));
                if (arrayList.size() == i11) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public final byte[] c(int i10) {
        if (i10 < 0 || i10 >= this.f45891a.a()) {
            throw new IllegalArgumentException("index out of bounds");
        }
        return this.f45892b.d(this.f45893c, k0.t(i10, 32));
    }

    public e d() {
        return this.f45892b;
    }

    public j e() {
        return this.f45891a;
    }

    public k f() {
        int iA = this.f45891a.a();
        byte[][] bArr = new byte[iA][];
        for (int i10 = 0; i10 < iA; i10++) {
            bArr[i10] = c(i10);
        }
        return new k(this.f45891a, bArr);
    }

    public l g(g gVar) {
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        byte[][] bArr = new byte[this.f45891a.a()][];
        for (int i10 = 0; i10 < this.f45891a.a(); i10++) {
            gVar = (g) new g.b().h(gVar.b()).i(gVar.c()).p(gVar.h()).n(i10).o(gVar.g()).g(gVar.a()).e();
            bArr[i10] = a(c(i10), 0, this.f45891a.g() - 1, gVar);
        }
        return new l(this.f45891a, bArr);
    }

    public l h(byte[] bArr, m mVar, g gVar) {
        Objects.requireNonNull(bArr, "messageDigest == null");
        if (bArr.length != this.f45891a.f()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        Objects.requireNonNull(mVar, "signature == null");
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        List<Integer> listB = b(bArr, this.f45891a.g(), this.f45891a.b());
        int iG = 0;
        for (int i10 = 0; i10 < this.f45891a.b(); i10++) {
            iG += (this.f45891a.g() - 1) - listB.get(i10).intValue();
        }
        listB.addAll(b(k0.t(iG << (8 - ((this.f45891a.c() * k0.q(this.f45891a.g())) % 8)), (int) Math.ceil(((double) (this.f45891a.c() * k0.q(this.f45891a.g()))) / 8.0d)), this.f45891a.g(), this.f45891a.c()));
        byte[][] bArr2 = new byte[this.f45891a.a()][];
        for (int i11 = 0; i11 < this.f45891a.a(); i11++) {
            gVar = (g) new g.b().h(gVar.b()).i(gVar.c()).p(gVar.h()).n(i11).o(gVar.g()).g(gVar.a()).e();
            bArr2[i11] = a(mVar.a()[i11], listB.get(i11).intValue(), (this.f45891a.g() - 1) - listB.get(i11).intValue(), gVar);
        }
        return new l(this.f45891a, bArr2);
    }

    public byte[] i() {
        return org.bouncycastle.util.a.p(this.f45894d);
    }

    public byte[] j() {
        return org.bouncycastle.util.a.p(this.f45893c);
    }

    public byte[] k(byte[] bArr, g gVar) {
        return this.f45892b.d(bArr, ((g) new g.b().h(gVar.b()).i(gVar.c()).p(gVar.h()).e()).e());
    }

    public void l(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "secretKeySeed == null");
        if (bArr.length != this.f45891a.f()) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        }
        Objects.requireNonNull(bArr2, "publicSeed == null");
        if (bArr2.length != this.f45891a.f()) {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        this.f45893c = bArr;
        this.f45894d = bArr2;
    }

    public m m(byte[] bArr, g gVar) {
        Objects.requireNonNull(bArr, "messageDigest == null");
        if (bArr.length != this.f45891a.f()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        List<Integer> listB = b(bArr, this.f45891a.g(), this.f45891a.b());
        int iG = 0;
        for (int i10 = 0; i10 < this.f45891a.b(); i10++) {
            iG += (this.f45891a.g() - 1) - listB.get(i10).intValue();
        }
        listB.addAll(b(k0.t(iG << (8 - ((this.f45891a.c() * k0.q(this.f45891a.g())) % 8)), (int) Math.ceil(((double) (this.f45891a.c() * k0.q(this.f45891a.g()))) / 8.0d)), this.f45891a.g(), this.f45891a.c()));
        byte[][] bArr2 = new byte[this.f45891a.a()][];
        for (int i11 = 0; i11 < this.f45891a.a(); i11++) {
            gVar = (g) new g.b().h(gVar.b()).i(gVar.c()).p(gVar.h()).n(i11).o(gVar.g()).g(gVar.a()).e();
            bArr2[i11] = a(c(i11), 0, listB.get(i11).intValue(), gVar);
        }
        return new m(this.f45891a, bArr2);
    }
}

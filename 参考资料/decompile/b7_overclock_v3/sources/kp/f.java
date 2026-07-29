package kp;

import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f39091a;

    @Override // kp.c
    public void a(byte[] bArr) {
        long[] jArrK = e.k(bArr);
        Vector vector = this.f39091a;
        if (vector == null || 0 == e.c(jArrK, (long[]) vector.elementAt(0))) {
            Vector vector2 = new Vector(8);
            this.f39091a = vector2;
            vector2.addElement(jArrK);
        }
    }

    @Override // kp.c
    public void b(long j10, byte[] bArr) {
        long[] jArrG = e.G();
        int i10 = 0;
        while (j10 > 0) {
            if ((1 & j10) != 0) {
                c(i10);
                e.s(jArrG, (long[]) this.f39091a.elementAt(i10));
            }
            i10++;
            j10 >>>= 1;
        }
        e.e(jArrG, bArr);
    }

    public final void c(int i10) {
        int size = this.f39091a.size() - 1;
        if (size >= i10) {
            return;
        }
        long[] jArr = (long[]) this.f39091a.elementAt(size);
        while (true) {
            long[] jArr2 = new long[2];
            e.I(jArr, jArr2);
            this.f39091a.addElement(jArr2);
            size++;
            if (size >= i10) {
                return;
            } else {
                jArr = jArr2;
            }
        }
    }
}

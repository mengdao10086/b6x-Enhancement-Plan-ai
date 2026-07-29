package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class a1 extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29633f = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f29634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d[] f29635e;

    public a1(byte b10, int i10) {
        super(b10, i10);
        this.f29635e = null;
        this.f29634d = 1000;
    }

    public a1(h hVar) throws IOException {
        this(hVar.b().v(j.f29713a), 0);
    }

    public a1(byte[] bArr) {
        this(bArr, 0);
    }

    public a1(byte[] bArr, int i10) {
        this(bArr, i10, 1000);
    }

    public a1(byte[] bArr, int i10, int i11) {
        super(bArr, i10);
        this.f29635e = null;
        this.f29634d = i11;
    }

    public a1(byte[] bArr, boolean z10) {
        super(bArr, z10);
        this.f29635e = null;
        this.f29634d = 1000;
    }

    public a1(d[] dVarArr) {
        this(dVarArr, 1000);
    }

    public a1(d[] dVarArr, int i10) {
        super(P(dVarArr), false);
        this.f29635e = dVarArr;
        this.f29634d = i10;
    }

    public static byte[] P(d[] dVarArr) {
        int length = dVarArr.length;
        if (length == 0) {
            return new byte[]{0};
        }
        if (length == 1) {
            return dVarArr[0].f29651a;
        }
        int i10 = length - 1;
        int length2 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            byte[] bArr = dVarArr[i11].f29651a;
            if (bArr[0] != 0) {
                throw new IllegalArgumentException("only the last nested bitstring can have padding");
            }
            length2 += bArr.length - 1;
        }
        byte[] bArr2 = dVarArr[i10].f29651a;
        byte b10 = bArr2[0];
        byte[] bArr3 = new byte[length2 + bArr2.length];
        bArr3[0] = b10;
        int i12 = 1;
        for (d dVar : dVarArr) {
            byte[] bArr4 = dVar.f29651a;
            int length3 = bArr4.length - 1;
            System.arraycopy(bArr4, 1, bArr3, i12, length3);
            i12 += length3;
        }
        return bArr3;
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        if (!z()) {
            return u2.R(z10, this.f29651a.length);
        }
        int iA = z10 ? 4 : 3;
        if (this.f29635e == null) {
            byte[] bArr = this.f29651a;
            if (bArr.length < 2) {
                return iA;
            }
            int length = bArr.length - 2;
            int i10 = this.f29634d;
            int i11 = length / (i10 - 1);
            return iA + (u2.R(true, i10) * i11) + u2.R(true, this.f29651a.length - (i11 * (this.f29634d - 1)));
        }
        int i12 = 0;
        while (true) {
            d[] dVarArr = this.f29635e;
            if (i12 >= dVarArr.length) {
                return iA;
            }
            iA += dVarArr[i12].A(true);
            i12++;
        }
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        if (!z()) {
            byte[] bArr = this.f29651a;
            u2.Q(b0Var, z10, bArr, 0, bArr.length);
            return;
        }
        b0Var.v(z10, 35);
        b0Var.k(128);
        d[] dVarArr = this.f29635e;
        if (dVarArr != null) {
            b0Var.A(dVarArr);
        } else {
            byte[] bArr2 = this.f29651a;
            if (bArr2.length >= 2) {
                byte b10 = bArr2[0];
                int length = bArr2.length;
                int i10 = length - 1;
                int i11 = this.f29634d - 1;
                while (i10 > i11) {
                    u2.P(b0Var, true, (byte) 0, this.f29651a, length - i10, i11);
                    i10 -= i11;
                }
                u2.P(b0Var, true, b10, this.f29651a, length - i10, i10);
            }
        }
        b0Var.k(0);
        b0Var.k(0);
    }

    @Override // gm.c0
    public boolean z() {
        return this.f29635e != null || this.f29651a.length > this.f29634d;
    }
}

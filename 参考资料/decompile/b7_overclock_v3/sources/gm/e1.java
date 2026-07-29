package gm;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class e1 extends z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29663f = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f29664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z[] f29665e;

    public class a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29666a = 0;

        public a() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f29666a < e1.this.f29836a.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i10 = this.f29666a;
            e1 e1Var = e1.this;
            byte[] bArr = e1Var.f29836a;
            if (i10 >= bArr.length) {
                throw new NoSuchElementException();
            }
            int iMin = Math.min(bArr.length - i10, e1Var.f29664d);
            byte[] bArr2 = new byte[iMin];
            System.arraycopy(e1.this.f29836a, this.f29666a, bArr2, 0, iMin);
            this.f29666a += iMin;
            return new f2(bArr2);
        }
    }

    public class b implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29668a = 0;

        public b() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f29668a < e1.this.f29665e.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            if (this.f29668a >= e1.this.f29665e.length) {
                throw new NoSuchElementException();
            }
            z[] zVarArr = e1.this.f29665e;
            int i10 = this.f29668a;
            this.f29668a = i10 + 1;
            return zVarArr[i10];
        }
    }

    public e1(byte[] bArr) {
        this(bArr, 1000);
    }

    public e1(byte[] bArr, int i10) {
        this(bArr, null, i10);
    }

    public e1(byte[] bArr, z[] zVarArr, int i10) {
        super(bArr);
        this.f29665e = zVarArr;
        this.f29664d = i10;
    }

    public e1(z[] zVarArr) {
        this(zVarArr, 1000);
    }

    public e1(z[] zVarArr, int i10) {
        this(N(zVarArr), zVarArr, i10);
    }

    public static byte[] N(z[] zVarArr) {
        int length = zVarArr.length;
        if (length == 0) {
            return z.f29835c;
        }
        if (length == 1) {
            return zVarArr[0].f29836a;
        }
        int length2 = 0;
        for (z zVar : zVarArr) {
            length2 += zVar.f29836a.length;
        }
        byte[] bArr = new byte[length2];
        int length3 = 0;
        for (z zVar2 : zVarArr) {
            byte[] bArr2 = zVar2.f29836a;
            System.arraycopy(bArr2, 0, bArr, length3, bArr2.length);
            length3 += bArr2.length;
        }
        return bArr;
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        if (!z()) {
            return f2.M(z10, this.f29836a.length);
        }
        int iA = z10 ? 4 : 3;
        if (this.f29665e == null) {
            int length = this.f29836a.length;
            int i10 = this.f29664d;
            int i11 = length / i10;
            int iM = iA + (f2.M(true, i10) * i11);
            int length2 = this.f29836a.length - (i11 * this.f29664d);
            return length2 > 0 ? iM + f2.M(true, length2) : iM;
        }
        int i12 = 0;
        while (true) {
            z[] zVarArr = this.f29665e;
            if (i12 >= zVarArr.length) {
                return iA;
            }
            iA += zVarArr[i12].A(true);
            i12++;
        }
    }

    public Enumeration O() {
        return this.f29665e == null ? new a() : new b();
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        if (!z()) {
            byte[] bArr = this.f29836a;
            f2.L(b0Var, z10, bArr, 0, bArr.length);
            return;
        }
        b0Var.v(z10, 36);
        b0Var.k(128);
        z[] zVarArr = this.f29665e;
        if (zVarArr == null) {
            int i10 = 0;
            while (true) {
                byte[] bArr2 = this.f29836a;
                if (i10 >= bArr2.length) {
                    break;
                }
                int iMin = Math.min(bArr2.length - i10, this.f29664d);
                f2.L(b0Var, true, this.f29836a, i10, iMin);
                i10 += iMin;
            }
        } else {
            b0Var.A(zVarArr);
        }
        b0Var.k(0);
        b0Var.k(0);
    }

    @Override // gm.c0
    public boolean z() {
        return this.f29665e != null || this.f29836a.length > this.f29664d;
    }
}

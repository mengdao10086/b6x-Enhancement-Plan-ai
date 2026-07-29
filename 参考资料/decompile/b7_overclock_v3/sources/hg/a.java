package hg;

import com.qualcomm.qti.libraries.gaia.GaiaException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31265b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f31267d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31264a = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f31266c = new byte[0];

    public static a b(int i10, int i11, int i12, byte[] bArr, int i13) throws GaiaException {
        byte[] bArr2;
        if ((i11 & 16384) != 16384) {
            throw new GaiaException(2);
        }
        if (bArr != null) {
            bArr2 = new byte[bArr.length + 1];
            bArr2[0] = (byte) i12;
            System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        } else {
            bArr2 = new byte[]{(byte) i12};
        }
        return i13 == 0 ? new b(i10, i11, bArr2) : new c(i10, i11, bArr2);
    }

    public abstract byte[] a(int i10, byte[] bArr) throws GaiaException;

    public byte[] c(int i10, byte[] bArr) throws GaiaException {
        byte[] bArr2;
        if (l()) {
            throw new GaiaException(1);
        }
        int i11 = this.f31265b | 32768;
        if (bArr != null) {
            int length = bArr.length + 1;
            bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 1, length - 1);
        } else {
            bArr2 = new byte[1];
        }
        bArr2[0] = (byte) i10;
        return a(i11, bArr2);
    }

    public byte[] d() throws GaiaException {
        byte[] bArr = this.f31267d;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArrA = a(this.f31265b, this.f31266c);
        this.f31267d = bArrA;
        return bArrA;
    }

    public int e() {
        return this.f31265b & gg.b.f29413a;
    }

    public int f() {
        return this.f31265b;
    }

    public int g() {
        byte[] bArr;
        if ((this.f31265b & 16384) < 1 || (bArr = this.f31266c) == null || bArr.length < 1) {
            return 0;
        }
        return gg.b.a(bArr[0]);
    }

    public byte[] h() {
        return this.f31266c;
    }

    public abstract int i();

    public int j() {
        byte[] bArr;
        if (!l() || (bArr = this.f31266c) == null || bArr.length < 1) {
            return -1;
        }
        return gg.b.b(bArr[0]);
    }

    public int k() {
        return this.f31264a;
    }

    public boolean l() {
        return (this.f31265b & 32768) > 0;
    }
}

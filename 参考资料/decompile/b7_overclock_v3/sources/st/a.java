package st;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f50508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f50512e;

    public a() {
        this(8192);
    }

    public synchronized int a() {
        return this.f50510c;
    }

    public int b() {
        return this.f50509b;
    }

    public synchronized void c() {
        this.f50510c = 0;
        this.f50512e = 0;
        this.f50511d = 0;
    }

    public synchronized int d() {
        return this.f50509b - this.f50510c;
    }

    public synchronized int e() {
        int i10 = this.f50510c;
        if (i10 == 0) {
            return -1;
        }
        byte[] bArr = this.f50508a;
        int i11 = this.f50511d;
        byte b10 = bArr[i11];
        this.f50511d = (i11 + 1) % this.f50509b;
        this.f50510c = i10 - 1;
        return b10;
    }

    public int f(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public synchronized int g(byte[] bArr, int i10, int i11) {
        if (this.f50510c == 0) {
            return 0;
        }
        int i12 = this.f50511d;
        int i13 = this.f50512e;
        if (i12 >= i13) {
            i13 = this.f50509b;
        }
        int iMin = Math.min(i13 - i12, i11);
        System.arraycopy(this.f50508a, this.f50511d, bArr, i10, iMin);
        int i14 = this.f50511d + iMin;
        this.f50511d = i14;
        if (i14 == this.f50509b) {
            int iMin2 = Math.min(i11 - iMin, this.f50512e);
            if (iMin2 > 0) {
                System.arraycopy(this.f50508a, 0, bArr, i10 + iMin, iMin2);
                this.f50511d = iMin2;
                iMin += iMin2;
            } else {
                this.f50511d = 0;
            }
        }
        this.f50510c -= iMin;
        return iMin;
    }

    public synchronized int h() {
        return this.f50510c > 0 ? this.f50508a[this.f50511d] : (byte) -1;
    }

    public int i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public synchronized int j(byte[] bArr, int i10, int i11) {
        int i12 = this.f50510c;
        int i13 = this.f50509b;
        if (i12 == i13) {
            return 0;
        }
        int i14 = this.f50512e;
        int i15 = this.f50511d;
        if (i14 < i15) {
            i13 = i15;
        }
        int iMin = Math.min(i13 - i14, i11);
        System.arraycopy(bArr, i10, this.f50508a, this.f50512e, iMin);
        int i16 = this.f50512e + iMin;
        this.f50512e = i16;
        if (i16 == this.f50509b) {
            int iMin2 = Math.min(i11 - iMin, this.f50511d);
            if (iMin2 > 0) {
                System.arraycopy(bArr, i10 + iMin, this.f50508a, 0, iMin2);
                this.f50512e = iMin2;
                iMin += iMin2;
            } else {
                this.f50512e = 0;
            }
        }
        this.f50510c += iMin;
        return iMin;
    }

    public synchronized boolean k(byte b10) {
        int i10 = this.f50510c;
        int i11 = this.f50509b;
        if (i10 == i11) {
            return false;
        }
        byte[] bArr = this.f50508a;
        int i12 = this.f50512e;
        bArr[i12] = b10;
        this.f50512e = (i12 + 1) % i11;
        this.f50510c = i10 + 1;
        return true;
    }

    public synchronized byte[] l() {
        return this.f50508a;
    }

    public synchronized int m() {
        return this.f50511d;
    }

    public synchronized int n() {
        return this.f50512e;
    }

    public synchronized int o(int i10) {
        int i11 = this.f50510c;
        if (i10 > i11) {
            i10 = i11;
        }
        this.f50511d = (this.f50511d + i10) % this.f50509b;
        this.f50510c = i11 - i10;
        return i10;
    }

    public a(int i10) {
        this.f50509b = i10;
        this.f50508a = new byte[i10];
    }
}

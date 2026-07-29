package ve;

/* JADX INFO: loaded from: classes7.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f53128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53129b;

    public e(int i10, int i11) {
        this.f53128a = i10;
        this.f53129b = i11;
    }

    public e a(int i10, int i11, int i12, int i13) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int b() {
        return this.f53129b;
    }

    public abstract byte[] c();

    public abstract byte[] d(int i10, byte[] bArr);

    public final int e() {
        return this.f53128a;
    }

    public e f() {
        return new d(this);
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public e i() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public e j() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i10 = this.f53128a;
        byte[] bArrD = new byte[i10];
        StringBuilder sb2 = new StringBuilder(this.f53129b * (i10 + 1));
        for (int i11 = 0; i11 < this.f53129b; i11++) {
            bArrD = d(i11, bArrD);
            for (int i12 = 0; i12 < this.f53128a; i12++) {
                int i13 = bArrD[i12] & 255;
                sb2.append(i13 < 64 ? '#' : i13 < 128 ? '+' : i13 < 192 ? '.' : zc.f.f58383m);
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}

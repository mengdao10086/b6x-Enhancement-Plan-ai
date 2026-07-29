package rb;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f48366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f48369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f48370e;

    public u(int i10, int i11) {
        this.f48366a = i10;
        byte[] bArr = new byte[i11 + 3];
        this.f48369d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i10, int i11) {
        if (this.f48367b) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f48369d;
            int length = bArr2.length;
            int i13 = this.f48370e;
            if (length < i13 + i12) {
                this.f48369d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy(bArr, i10, this.f48369d, this.f48370e, i12);
            this.f48370e += i12;
        }
    }

    public boolean b(int i10) {
        if (!this.f48367b) {
            return false;
        }
        this.f48370e -= i10;
        this.f48367b = false;
        this.f48368c = true;
        return true;
    }

    public boolean c() {
        return this.f48368c;
    }

    public void d() {
        this.f48367b = false;
        this.f48368c = false;
    }

    public void e(int i10) {
        hd.a.i(!this.f48367b);
        boolean z10 = i10 == this.f48366a;
        this.f48367b = z10;
        if (z10) {
            this.f48370e = 3;
            this.f48368c = false;
        }
    }
}

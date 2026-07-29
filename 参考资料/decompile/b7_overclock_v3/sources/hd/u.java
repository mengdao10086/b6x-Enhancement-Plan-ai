package hd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31151c = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f31153b;

    public u() {
        this(32);
    }

    public void a(long j10) {
        int i10 = this.f31152a;
        long[] jArr = this.f31153b;
        if (i10 == jArr.length) {
            this.f31153b = Arrays.copyOf(jArr, i10 * 2);
        }
        long[] jArr2 = this.f31153b;
        int i11 = this.f31152a;
        this.f31152a = i11 + 1;
        jArr2[i11] = j10;
    }

    public long b(int i10) {
        if (i10 >= 0 && i10 < this.f31152a) {
            return this.f31153b[i10];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i10 + ", size is " + this.f31152a);
    }

    public int c() {
        return this.f31152a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f31153b, this.f31152a);
    }

    public u(int i10) {
        this.f31153b = new long[i10];
    }
}

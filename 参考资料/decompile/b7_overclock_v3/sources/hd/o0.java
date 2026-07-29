package hd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class o0<V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f31105e = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f31106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public V[] f31107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31109d;

    public o0() {
        this(10);
    }

    public static <V> V[] f(int i10) {
        return (V[]) new Object[i10];
    }

    public synchronized void a(long j10, V v10) {
        d(j10);
        e();
        b(j10, v10);
    }

    public final void b(long j10, V v10) {
        int i10 = this.f31108c;
        int i11 = this.f31109d;
        V[] vArr = this.f31107b;
        int length = (i10 + i11) % vArr.length;
        this.f31106a[length] = j10;
        vArr[length] = v10;
        this.f31109d = i11 + 1;
    }

    public synchronized void c() {
        this.f31108c = 0;
        this.f31109d = 0;
        Arrays.fill(this.f31107b, (Object) null);
    }

    public final void d(long j10) {
        if (this.f31109d > 0) {
            if (j10 <= this.f31106a[((this.f31108c + r0) - 1) % this.f31107b.length]) {
                c();
            }
        }
    }

    public final void e() {
        int length = this.f31107b.length;
        if (this.f31109d < length) {
            return;
        }
        int i10 = length * 2;
        long[] jArr = new long[i10];
        V[] vArr = (V[]) f(i10);
        int i11 = this.f31108c;
        int i12 = length - i11;
        System.arraycopy(this.f31106a, i11, jArr, 0, i12);
        System.arraycopy(this.f31107b, this.f31108c, vArr, 0, i12);
        int i13 = this.f31108c;
        if (i13 > 0) {
            System.arraycopy(this.f31106a, 0, jArr, i12, i13);
            System.arraycopy(this.f31107b, 0, vArr, i12, this.f31108c);
        }
        this.f31106a = jArr;
        this.f31107b = vArr;
        this.f31108c = 0;
    }

    @g.p0
    public synchronized V g(long j10) {
        return h(j10, false);
    }

    @g.p0
    public final V h(long j10, boolean z10) {
        V vK = null;
        long j11 = Long.MAX_VALUE;
        while (this.f31109d > 0) {
            long j12 = j10 - this.f31106a[this.f31108c];
            if (j12 < 0 && (z10 || (-j12) >= j11)) {
                break;
            }
            vK = k();
            j11 = j12;
        }
        return vK;
    }

    @g.p0
    public synchronized V i() {
        return this.f31109d == 0 ? null : k();
    }

    @g.p0
    public synchronized V j(long j10) {
        return h(j10, true);
    }

    @g.p0
    public final V k() {
        a.i(this.f31109d > 0);
        V[] vArr = this.f31107b;
        int i10 = this.f31108c;
        V v10 = vArr[i10];
        vArr[i10] = null;
        this.f31108c = (i10 + 1) % vArr.length;
        this.f31109d--;
        return v10;
    }

    public synchronized int l() {
        return this.f31109d;
    }

    public o0(int i10) {
        this.f31106a = new long[i10];
        this.f31107b = (V[]) f(i10);
    }
}

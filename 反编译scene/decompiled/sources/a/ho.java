package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ho {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6328a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ho f1197a;

    public void a(int i) {
        if (i < 64) {
            this.f6328a &= ~(1 << i);
            return;
        }
        ho hoVar = this.f1197a;
        if (hoVar != null) {
            hoVar.a(i - 64);
        }
    }

    public int b(int i) {
        ho hoVar = this.f1197a;
        return hoVar == null ? i >= 64 ? Long.bitCount(this.f6328a) : Long.bitCount(this.f6328a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f6328a & ((1 << i) - 1)) : hoVar.b(i - 64) + Long.bitCount(this.f6328a);
    }

    public final void c() {
        if (this.f1197a == null) {
            this.f1197a = new ho();
        }
    }

    public boolean d(int i) {
        if (i < 64) {
            return (this.f6328a & (1 << i)) != 0;
        }
        c();
        return this.f1197a.d(i - 64);
    }

    public void e(int i, boolean z) {
        if (i >= 64) {
            c();
            this.f1197a.e(i - 64, z);
            return;
        }
        boolean z2 = (this.f6328a & Long.MIN_VALUE) != 0;
        long j = (1 << i) - 1;
        long j2 = this.f6328a;
        this.f6328a = ((j2 & (~j)) << 1) | (j2 & j);
        if (z) {
            h(i);
        } else {
            a(i);
        }
        if (z2 || this.f1197a != null) {
            c();
            this.f1197a.e(0, z2);
        }
    }

    public boolean f(int i) {
        if (i >= 64) {
            c();
            return this.f1197a.f(i - 64);
        }
        long j = 1 << i;
        boolean z = (this.f6328a & j) != 0;
        long j2 = this.f6328a & (~j);
        this.f6328a = j2;
        long j3 = j - 1;
        this.f6328a = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
        ho hoVar = this.f1197a;
        if (hoVar != null) {
            if (hoVar.d(0)) {
                h(63);
            }
            this.f1197a.f(0);
        }
        return z;
    }

    public void g() {
        this.f6328a = 0L;
        ho hoVar = this.f1197a;
        if (hoVar != null) {
            hoVar.g();
        }
    }

    public void h(int i) {
        if (i < 64) {
            this.f6328a |= 1 << i;
        } else {
            c();
            this.f1197a.h(i - 64);
        }
    }

    public String toString() {
        if (this.f1197a == null) {
            return Long.toBinaryString(this.f6328a);
        }
        return this.f1197a.toString() + "xx" + Long.toBinaryString(this.f6328a);
    }
}

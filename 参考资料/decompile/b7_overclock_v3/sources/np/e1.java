package np;

/* JADX INFO: loaded from: classes5.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f42387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f42388d;

    public e1(int i10, int i11) {
        this.f42385a = i10;
        this.f42386b = i11;
    }

    public e1(long j10, long j11) {
        this.f42387c = j10;
        this.f42388d = j11;
    }

    public int a() {
        return this.f42386b;
    }

    public long b() {
        return this.f42388d;
    }

    public int c() {
        return this.f42385a;
    }

    public long d() {
        return this.f42387c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return e1Var.f42386b == this.f42386b && e1Var.f42385a == this.f42385a && e1Var.f42388d == this.f42388d && e1Var.f42387c == this.f42387c;
    }

    public int hashCode() {
        int i10 = this.f42385a ^ this.f42386b;
        long j10 = this.f42387c;
        int i11 = (i10 ^ ((int) j10)) ^ ((int) (j10 >> 32));
        long j11 = this.f42388d;
        return (i11 ^ ((int) j11)) ^ ((int) (j11 >> 32));
    }
}

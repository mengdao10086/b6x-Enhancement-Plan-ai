package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6473a;
    public int b;
    public int c;
    public int d;

    public j41(int i, int i2, int i3, int i4) {
        this.f6473a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.f6473a;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j41)) {
            return false;
        }
        j41 j41Var = (j41) obj;
        return this.f6473a == j41Var.f6473a && this.b == j41Var.b && this.c == j41Var.c && this.d == j41Var.d;
    }

    public int hashCode() {
        return (((((this.f6473a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "TimeLines(max=" + this.f6473a + ", columns=" + this.b + ", lineInterval=" + this.c + ", textInterval=" + this.d + ")";
    }
}

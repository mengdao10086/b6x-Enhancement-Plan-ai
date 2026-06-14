package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1122a;
    public final String b;

    public h50(int i, String str, String str2) {
        f92.d(str, "version");
        f92.d(str2, "buildTime");
        this.f6276a = i;
        this.f1122a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.f6276a;
    }

    public final String c() {
        return this.f1122a;
    }

    public final void d(int i) {
        this.f6276a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h50)) {
            return false;
        }
        h50 h50Var = (h50) obj;
        return this.f6276a == h50Var.f6276a && f92.a(this.f1122a, h50Var.f1122a) && f92.a(this.b, h50Var.b);
    }

    public int hashCode() {
        int i = this.f6276a * 31;
        String str = this.f1122a;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DaemonConfig(port=" + this.f6276a + ", version=" + this.f1122a + ", buildTime=" + this.b + ")";
    }
}

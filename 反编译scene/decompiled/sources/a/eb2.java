package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class eb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ea2 f5988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f720a;

    public eb2(String str, ea2 ea2Var) {
        f92.d(str, "value");
        f92.d(ea2Var, "range");
        this.f720a = str;
        this.f5988a = ea2Var;
    }

    public final String a() {
        return this.f720a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eb2)) {
            return false;
        }
        eb2 eb2Var = (eb2) obj;
        return f92.a(this.f720a, eb2Var.f720a) && f92.a(this.f5988a, eb2Var.f5988a);
    }

    public int hashCode() {
        String str = this.f720a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ea2 ea2Var = this.f5988a;
        return iHashCode + (ea2Var != null ? ea2Var.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.f720a + ", range=" + this.f5988a + ")";
    }
}

package np;

/* JADX INFO: loaded from: classes5.dex */
public class u0 extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v0 f42548b;

    public u0(boolean z10, v0 v0Var) {
        super(z10);
        this.f42548b = v0Var;
    }

    public v0 d() {
        return this.f42548b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u0)) {
            return false;
        }
        v0 v0Var = this.f42548b;
        v0 v0VarD = ((u0) obj).d();
        return v0Var == null ? v0VarD == null : v0Var.equals(v0VarD);
    }

    public int hashCode() {
        v0 v0Var = this.f42548b;
        if (v0Var != null) {
            return v0Var.hashCode();
        }
        return 0;
    }
}

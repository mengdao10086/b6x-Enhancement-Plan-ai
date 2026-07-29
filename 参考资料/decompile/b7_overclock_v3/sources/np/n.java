package np;

/* JADX INFO: loaded from: classes5.dex */
public class n extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f42485b;

    public n(boolean z10, q qVar) {
        super(z10);
        this.f42485b = qVar;
    }

    public q d() {
        return this.f42485b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        q qVar = this.f42485b;
        q qVarD = ((n) obj).d();
        return qVar == null ? qVarD == null : qVar.equals(qVarD);
    }

    public int hashCode() {
        int i10 = !c() ? 1 : 0;
        q qVar = this.f42485b;
        return qVar != null ? i10 ^ qVar.hashCode() : i10;
    }
}

package np;

/* JADX INFO: loaded from: classes5.dex */
public class g extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f42406b;

    public g(boolean z10, h hVar) {
        super(z10);
        this.f42406b = hVar;
    }

    public h d() {
        return this.f42406b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        h hVar = this.f42406b;
        h hVarD = ((g) obj).d();
        return hVar == null ? hVarD == null : hVar.equals(hVarD);
    }

    public int hashCode() {
        int i10 = !c() ? 1 : 0;
        h hVar = this.f42406b;
        return hVar != null ? i10 ^ hVar.hashCode() : i10;
    }
}

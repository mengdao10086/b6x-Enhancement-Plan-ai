package ap;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ir.i f8826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ir.i f8827b;

    public i(ir.i iVar, ir.i iVar2) {
        this.f8826a = iVar;
        this.f8827b = iVar2;
    }

    public boolean a(i iVar) {
        return iVar.b().e(b()) && iVar.c().e(c());
    }

    public ir.i b() {
        return this.f8826a;
    }

    public ir.i c() {
        return this.f8827b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return a((i) obj);
        }
        return false;
    }

    public int hashCode() {
        return this.f8826a.hashCode() + (this.f8827b.hashCode() * 37);
    }
}

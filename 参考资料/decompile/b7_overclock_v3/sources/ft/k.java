package ft;

/* JADX INFO: loaded from: classes6.dex */
public abstract class k implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f28773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28774b;

    @Override // ft.r
    public final r c(r rVar) {
        return d(rVar);
    }

    @Override // ft.r
    public abstract Object clone();

    @Override // ft.r
    public final void h(r rVar) {
        k(rVar);
    }

    public abstract void l();

    public abstract void m();

    public final k n(l lVar) {
        return this.f28773a.c(this, lVar);
    }

    public final l o() {
        return this.f28773a;
    }

    public abstract k p();

    public abstract void q();

    public abstract k r() throws RuntimeException;

    public abstract k s();

    public abstract k t();

    public abstract void u();

    public abstract void v();

    public abstract boolean w(int i10);

    public abstract boolean x();

    public abstract int y();
}

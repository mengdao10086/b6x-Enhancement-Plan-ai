package eb;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26745a;

    public final void g(int i10) {
        this.f26745a = i10 | this.f26745a;
    }

    public void h() {
        this.f26745a = 0;
    }

    public final void i(int i10) {
        this.f26745a = (~i10) & this.f26745a;
    }

    public final boolean j(int i10) {
        return (this.f26745a & i10) == i10;
    }

    public final boolean k() {
        return j(268435456);
    }

    public final boolean l() {
        return j(Integer.MIN_VALUE);
    }

    public final boolean m() {
        return j(4);
    }

    public final boolean n() {
        return j(1);
    }

    public final void o(int i10) {
        this.f26745a = i10;
    }
}

package s4;

import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class n<Z> extends b<Z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49498c;

    public n() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // s4.p
    public void f(@n0 o oVar) {
    }

    @Override // s4.p
    public final void m(@n0 o oVar) {
        if (v4.o.w(this.f49497b, this.f49498c)) {
            oVar.e(this.f49497b, this.f49498c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f49497b + " and height: " + this.f49498c + ", either provide dimensions in the constructor or call override()");
    }

    public n(int i10, int i11) {
        this.f49497b = i10;
        this.f49498c = i11;
    }
}

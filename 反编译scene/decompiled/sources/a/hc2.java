package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class hc2<T> extends bg2 implements qf2, b62<T>, wd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l62 f6302a;
    public final l62 b;

    public hc2(l62 l62Var, boolean z) {
        super(z);
        this.b = l62Var;
        this.f6302a = l62Var.plus(this);
    }

    public void D0(Object obj) {
        E(obj);
    }

    public final void E0() {
        d0((qf2) this.b.get(qf2.f7209a));
    }

    public void F0(Throwable th, boolean z) {
    }

    public void G0(T t) {
    }

    public void H0() {
    }

    public final <R> void I0(zd2 zd2Var, R r, k82<? super R, ? super b62<? super T>, ? extends Object> k82Var) {
        E0();
        zd2Var.a(k82Var, r, this);
    }

    @Override // a.bg2
    public String M() {
        return ce2.a(this) + " was cancelled";
    }

    @Override // a.bg2, a.qf2
    public boolean a() {
        return super.a();
    }

    @Override // a.b62
    public final l62 c() {
        return this.f6302a;
    }

    @Override // a.bg2
    public final void c0(Throwable th) {
        rd2.a(this.f6302a, th);
    }

    @Override // a.wd2
    public l62 f() {
        return this.f6302a;
    }

    @Override // a.bg2
    public String i0() {
        String strB = ld2.b(this.f6302a);
        if (strB == null) {
            return super.i0();
        }
        return '\"' + strB + "\":" + super.i0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.bg2
    public final void n0(Object obj) {
        if (!(obj instanceof gd2)) {
            G0(obj);
        } else {
            gd2 gd2Var = (gd2) obj;
            F0(gd2Var.f999a, gd2Var.a());
        }
    }

    @Override // a.bg2
    public final void o0() {
        H0();
    }

    @Override // a.b62
    public final void y(Object obj) {
        Object objG0 = g0(hd2.b(obj));
        if (objG0 == cg2.b) {
            return;
        }
        D0(objG0);
    }
}

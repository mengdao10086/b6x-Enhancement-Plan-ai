package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kg2<T> extends wf2<bg2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uc2<T> f6604a;

    /* JADX WARN: Multi-variable type inference failed */
    public kg2(bg2 bg2Var, uc2<? super T> uc2Var) {
        super(bg2Var);
        this.f6604a = uc2Var;
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        v(th);
        return m42.f6769a;
    }

    @Override // a.zh2
    public String toString() {
        return "ResumeAwaitOnCompletion[" + this.f6604a + ']';
    }

    @Override // a.id2
    public void v(Throwable th) {
        uc2<T> uc2Var;
        Object objH;
        Object objA0 = ((bg2) super.f7784a).a0();
        if (be2.a() && !(!(objA0 instanceof jf2))) {
            throw new AssertionError();
        }
        if (objA0 instanceof gd2) {
            uc2Var = this.f6604a;
            Throwable th2 = ((gd2) objA0).f999a;
            e42 e42Var = g42.f6169a;
            objH = h42.a(th2);
        } else {
            uc2Var = this.f6604a;
            objH = cg2.h(objA0);
            e42 e42Var2 = g42.f6169a;
        }
        g42.a(objH);
        uc2Var.y(objH);
    }
}

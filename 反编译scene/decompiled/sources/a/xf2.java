package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xf2<T> extends uc2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bg2 f7885a;

    public xf2(b62<? super T> b62Var, bg2 bg2Var) {
        super(b62Var, 1);
        this.f7885a = bg2Var;
    }

    @Override // a.uc2
    public String F() {
        return "AwaitContinuation";
    }

    @Override // a.uc2
    public Throwable u(qf2 qf2Var) {
        Throwable thF;
        Object objA0 = this.f7885a.a0();
        return (!(objA0 instanceof zf2) || (thF = ((zf2) objA0).f()) == null) ? objA0 instanceof gd2 ? ((gd2) objA0).f999a : qf2Var.m() : thF;
    }
}

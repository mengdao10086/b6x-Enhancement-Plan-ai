package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xg2 extends od2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xg2 f7889a = new xg2();

    @Override // a.od2
    public void l(l62 l62Var, Runnable runnable) {
        ah2 ah2Var = (ah2) l62Var.get(ah2.f5608a);
        if (ah2Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        ah2Var.b = true;
    }

    @Override // a.od2
    public boolean o(l62 l62Var) {
        return false;
    }

    @Override // a.od2
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}

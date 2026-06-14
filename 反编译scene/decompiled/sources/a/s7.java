package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t7 f7368a;

    public s7(t7 t7Var) {
        this.f7368a = t7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        h7 h7Var = this.f7368a.f2973a;
        if (h7Var == null || !eh.P(h7Var) || this.f7368a.f2973a.getCount() <= this.f7368a.f2973a.getChildCount()) {
            return;
        }
        int childCount = this.f7368a.f2973a.getChildCount();
        t7 t7Var = this.f7368a;
        if (childCount <= t7Var.g) {
            t7Var.f2987a.setInputMethodMode(2);
            this.f7368a.c();
        }
    }
}

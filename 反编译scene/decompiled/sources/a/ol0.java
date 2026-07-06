package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.FocusedApp", f = "FocusedApp.kt", l = {12, 44}, m = "getFocusedApps")
public final class ol0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pl0 f2268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f2269a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ol0(pl0 pl0Var, b62 b62Var) {
        super(b62Var);
        this.f2268a = pl0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f2269a = obj;
        this.f7035a |= Integer.MIN_VALUE;
        return this.f2268a.a(this);
    }
}

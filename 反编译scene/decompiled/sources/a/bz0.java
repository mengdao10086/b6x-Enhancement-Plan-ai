package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.store.RefreshRateManager", f = "RefreshRateManager.kt", l = {92}, m = "getConfig")
public final class bz0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ez0 f312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f313a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz0(ez0 ez0Var, b62 b62Var) {
        super(b62Var);
        this.f312a = ez0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f313a = obj;
        this.f5744a |= Integer.MIN_VALUE;
        return this.f312a.c(null, this);
    }
}

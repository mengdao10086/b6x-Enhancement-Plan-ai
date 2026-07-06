package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.ProcessPID", f = "ProcessPID.kt", l = {52}, m = "getAppMainProcess")
public final class sm0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ tm0 f2904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f2905a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sm0(tm0 tm0Var, b62 b62Var) {
        super(b62Var);
        this.f2904a = tm0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f2905a = obj;
        this.f7413a |= Integer.MIN_VALUE;
        return this.f2904a.a(null, this);
    }
}

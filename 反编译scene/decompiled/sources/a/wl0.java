package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.MemoryUtils", f = "MemoryUtils.kt", l = {25}, m = "getMemoryInfo")
public final class wl0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xl0 f3455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3456a;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl0(xl0 xl0Var, b62 b62Var) {
        super(b62Var);
        this.f3455a = xl0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3456a = obj;
        this.f7801a |= Integer.MIN_VALUE;
        return this.f3455a.b(this);
    }
}

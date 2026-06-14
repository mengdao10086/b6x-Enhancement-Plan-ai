package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.shell.KernelProp", f = "KernelProp.kt", l = {93}, m = "getPropAsync")
public final class v60 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ x60 f3249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3250a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v60(x60 x60Var, b62 b62Var) {
        super(b62Var);
        this.f3249a = x60Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3250a = obj;
        this.f7662a |= Integer.MIN_VALUE;
        return this.f3249a.e(null, this);
    }
}

package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.ProcessList", f = "ProcessList.kt", l = {100}, m = "getProcessDetail")
public final class mm0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ om0 f1955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1956a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1957b;
    public Object c;
    public Object d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mm0(om0 om0Var, b62 b62Var) {
        super(b62Var);
        this.f1955a = om0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1956a = obj;
        this.f6822a |= Integer.MIN_VALUE;
        return this.f1955a.b(0, this);
    }
}

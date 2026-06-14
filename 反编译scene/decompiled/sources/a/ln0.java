package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.ThreadsSchedStat", f = "ThreadsSchedStat.kt", l = {113}, m = "reset")
public final class ln0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ mn0 f1837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1838a;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ln0(mn0 mn0Var, b62 b62Var) {
        super(b62Var);
        this.f1837a = mn0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1838a = obj;
        this.f6724a |= Integer.MIN_VALUE;
        return this.f1837a.d(this);
    }
}

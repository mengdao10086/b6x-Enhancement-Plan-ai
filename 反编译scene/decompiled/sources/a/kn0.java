package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.ThreadsSchedStat", f = "ThreadsSchedStat.kt", l = {101, 103}, m = "getRealtimeState$app_release_mini")
public final class kn0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ mn0 f1666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1667a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1668b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kn0(mn0 mn0Var, b62 b62Var) {
        super(b62Var);
        this.f1666a = mn0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1667a = obj;
        this.f6622a |= Integer.MIN_VALUE;
        return this.f1666a.a(0, this);
    }
}

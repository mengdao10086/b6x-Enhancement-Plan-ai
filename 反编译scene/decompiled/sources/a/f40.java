package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {167}, m = "ping")
public final class f40 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f852a;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f40(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f851a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f852a = obj;
        this.f6071a |= Integer.MIN_VALUE;
        return this.f851a.L0(this);
    }
}

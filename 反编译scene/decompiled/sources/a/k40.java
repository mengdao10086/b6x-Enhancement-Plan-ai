package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {573}, m = "setFTMonitor")
public final class k40 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f1602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1603a;
    public Object b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1604b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k40(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f1602a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1603a = obj;
        this.f6571a |= Integer.MIN_VALUE;
        return this.f1602a.Y0(false, this);
    }
}

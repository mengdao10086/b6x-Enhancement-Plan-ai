package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.BatteryUtils$Companion", f = "BatteryUtils.kt", l = {43}, m = "dumpBatteryStatus")
public final class cl0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ dl0 f423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f424a;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl0(dl0 dl0Var, b62 b62Var) {
        super(b62Var);
        this.f423a = dl0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f424a = obj;
        this.f5805a |= Integer.MIN_VALUE;
        return this.f423a.a(this);
    }
}

package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qk0 extends g92 implements g82<String, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nb2 f7217a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qk0(nb2 nb2Var) {
        super(1);
        this.f7217a = nb2Var;
    }

    public final boolean a(String str) {
        f92.d(str, "resourceName");
        return bc2.x(str, "mtrl_", false, 2, null) || bc2.x(str, "abc_", false, 2, null) || this.f7217a.f(str) || bc2.x(str, "path_password", false, 2, null) || bc2.x(str, "xp_", false, 2, null) || bc2.x(str, "com_google_", false, 2, null) || bc2.x(str, "config_", false, 2, null) || bc2.x(str, "cmd_", false, 2, null);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ Boolean f(String str) {
        return Boolean.valueOf(a(str));
    }
}

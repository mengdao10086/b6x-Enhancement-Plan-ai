package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.scene_mode.ProfileInstaller$installThreadsJSON$1", f = "ProfileInstaller.kt", l = {}, m = "invokeSuspend")
public final class av0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bv0 f5644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f142a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f143a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av0(bv0 bv0Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f5644a = bv0Var;
        this.f143a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        av0 av0Var = new av0(this.f5644a, this.f143a, b62Var);
        av0Var.f142a = (wd2) obj;
        return av0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((av0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        String strI = new ho0(this.f5644a.f303a).I();
        if (strI != null) {
            c60 c60Var = c60.f5764a;
            byte[] bytes = strI.getBytes(bb2.f5692a);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            c60Var.l(bytes, this.f143a, this.f5644a.f303a);
            e50.f677a.P0("version-update");
        }
        return m42.f6769a;
    }
}

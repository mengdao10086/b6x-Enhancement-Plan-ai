package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.permissions.CheckRootStatus$switchSU$2$onConfirm$1", f = "CheckRootStatus.kt", l = {50}, m = "invokeSuspend")
public final class up0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vp0 f7619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3203a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up0(vp0 vp0Var, b62 b62Var) {
        super(2, b62Var);
        this.f7619a = vp0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        up0 up0Var = new up0(this.f7619a, b62Var);
        up0Var.f3202a = (wd2) obj;
        return up0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((up0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3202a;
            wp0 wp0Var = this.f7619a.f7714a;
            this.f3203a = wd2Var;
            this.b = 1;
            if (wp0Var.d(this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}

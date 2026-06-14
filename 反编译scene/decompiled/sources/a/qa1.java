package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSession$bindEvent$11$1", f = "ActivityFpsSession.kt", l = {}, m = "invokeSuspend")
public final class qa1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ey0 f7193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2557a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qa1(ey0 ey0Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f7193a = ey0Var;
        this.f2557a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        qa1 qa1Var = new qa1(this.f7193a, this.f2557a, b62Var);
        qa1Var.f2556a = (wd2) obj;
        return qa1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((qa1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        new co0().A(this.f7193a.a(), this.f2557a);
        return m42.f6769a;
    }
}

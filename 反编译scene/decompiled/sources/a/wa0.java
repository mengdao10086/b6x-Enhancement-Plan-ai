package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.data.publisher.ScreenState$autoRegister$1", f = "ScreenState.kt", l = {}, m = "invokeSuspend")
public final class wa0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ya0 f3414a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa0(ya0 ya0Var, b62 b62Var) {
        super(2, b62Var);
        this.f3414a = ya0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        wa0 wa0Var = new wa0(this.f3414a, b62Var);
        wa0Var.f7769a = (wd2) obj;
        return wa0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((wa0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f3414a.d();
        return m42.f6769a;
    }
}

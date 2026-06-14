package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.Scene$Companion$async$1", f = "Scene.kt", l = {106}, m = "invokeSuspend")
public final class s20 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g82 f7354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2829a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s20(g82 g82Var, b62 b62Var) {
        super(2, b62Var);
        this.f7354a = g82Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        s20 s20Var = new s20(this.f7354a, b62Var);
        s20Var.f2828a = (wd2) obj;
        return s20Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((s20) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2828a;
            g82 g82Var = this.f7354a;
            this.f2829a = wd2Var;
            this.b = 1;
            if (g82Var.f(this) == objC) {
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

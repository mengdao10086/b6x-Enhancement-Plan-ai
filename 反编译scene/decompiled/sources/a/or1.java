package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentAppUser$setList$1", f = "FragmentAppUser.kt", l = {127}, m = "invokeSuspend")
public final class or1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rr1 f7050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2295a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public or1(rr1 rr1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7050a = rr1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        or1 or1Var = new or1(this.f7050a, b62Var);
        or1Var.f2294a = (wd2) obj;
        return or1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((or1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2294a;
            rr1 rr1Var = this.f7050a;
            rr1Var.f2773a = rr1.y1(rr1Var).l();
            fg2 fg2VarC = qe2.c();
            nr1 nr1Var = new nr1(this, null);
            this.f2295a = wd2Var;
            this.b = 1;
            if (oc2.g(fg2VarC, nr1Var, this) == objC) {
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

package a;

import com.omarea.vtools.activities.ActivityFpsSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$1$1$1$1", f = "ActivityFpsSession.kt", l = {635}, m = "invokeSuspend")
public final class wa1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xa1 f3416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3417a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa1(xa1 xa1Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3416a = xa1Var;
        this.f7770a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        wa1 wa1Var = new wa1(this.f3416a, this.f7770a, b62Var);
        wa1Var.f3415a = (wd2) obj;
        return wa1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((wa1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3415a;
            ActivityFpsSession.t tVar = this.f3416a.f7870a.f7963a;
            ActivityFpsSession.this.u(tVar.f8672a, this.f3416a.f3564a + ".csv");
            fg2 fg2VarC = qe2.c();
            va1 va1Var = new va1(this, null);
            this.f3417a = wd2Var;
            this.b = 1;
            if (oc2.g(fg2VarC, va1Var, this) == objC) {
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

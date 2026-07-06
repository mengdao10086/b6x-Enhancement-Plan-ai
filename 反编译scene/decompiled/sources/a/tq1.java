package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentAppBackup$setList$1", f = "FragmentAppBackup.kt", l = {108}, m = "invokeSuspend")
public final class tq1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wq1 f3055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3056a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tq1(wq1 wq1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3055a = wq1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        tq1 tq1Var = new tq1(this.f3055a, b62Var);
        tq1Var.f7525a = (wd2) obj;
        return tq1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((tq1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7525a;
            wq1 wq1Var = this.f3055a;
            wq1Var.f3473a = wq1.y1(wq1Var).i();
            fg2 fg2VarC = qe2.c();
            sq1 sq1Var = new sq1(this, null);
            this.f3056a = wd2Var;
            this.b = 1;
            if (oc2.g(fg2VarC, sq1Var, this) == objC) {
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

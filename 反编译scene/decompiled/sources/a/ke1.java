package a;

import com.omarea.vtools.activities.ActivityPowerBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityPowerBench$onViewCreated$14$1$1$1", f = "ActivityPowerBench.kt", l = {410}, m = "invokeSuspend")
public final class ke1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ le1 f6598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f1622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1624a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ke1(le1 le1Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f6598a = le1Var;
        this.f1622a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ke1 ke1Var = new ke1(this.f6598a, this.f1622a, b62Var);
        ke1Var.f1623a = (wd2) obj;
        return ke1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ke1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws Throwable {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1623a;
            ActivityPowerBench.this.E();
            fg2 fg2VarC = qe2.c();
            je1 je1Var = new je1(this, null);
            this.f1624a = wd2Var;
            this.b = 1;
            if (oc2.g(fg2VarC, je1Var, this) == objC) {
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

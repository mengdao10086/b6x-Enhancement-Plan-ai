package a;

import com.omarea.vtools.activities.ActivityPowerBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityPowerBench$onViewCreated$10$next$1$1", f = "ActivityPowerBench.kt", l = {326}, m = "invokeSuspend")
public final class fe1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ge1 f6098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f894a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe1(ge1 ge1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6098a = ge1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        fe1 fe1Var = new fe1(this.f6098a, b62Var);
        fe1Var.f893a = (wd2) obj;
        return fe1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((fe1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f893a;
            ActivityPowerBench activityPowerBench = ActivityPowerBench.this;
            boolean[] zArr = activityPowerBench.f5409a;
            this.f894a = wd2Var;
            this.b = 1;
            if (activityPowerBench.W(zArr, this) == objC) {
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

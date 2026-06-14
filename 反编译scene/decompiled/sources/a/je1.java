package a;

import a.p80;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityPowerBench$onViewCreated$14$1$1$1$1", f = "ActivityPowerBench.kt", l = {}, m = "invokeSuspend")
public final class je1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ke1 f6504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1531a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je1(ke1 ke1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6504a = ke1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        je1 je1Var = new je1(this.f6504a, b62Var);
        je1Var.f1531a = (wd2) obj;
        return je1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((je1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((p80.b) this.f6504a.f1622a.f6891a).c();
        return m42.f6769a;
    }
}

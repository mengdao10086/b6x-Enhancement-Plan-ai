package a;

import com.omarea.vtools.activities.ActivityFpsSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$15$3", f = "ActivityFpsSession.kt", l = {}, m = "invokeSuspend")
public final class ab1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f54a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession.s f55a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab1(ActivityFpsSession.s sVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f55a = sVar;
        this.f5590a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ab1 ab1Var = new ab1(this.f55a, this.f5590a, b62Var);
        ab1Var.f54a = (wd2) obj;
        return ab1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ab1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityFpsSession.this.q((StringBuilder) this.f5590a.f6891a);
        return m42.f6769a;
    }
}

package a;

import com.omarea.vtools.activities.ActivityModuleDetail;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityModuleDetail$onCreate$1$2", f = "ActivityModuleDetail.kt", l = {}, m = "invokeSuspend")
public final class qc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModuleDetail.a f2566a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qc1(ActivityModuleDetail.a aVar, b62 b62Var) {
        super(2, b62Var);
        this.f2566a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        qc1 qc1Var = new qc1(this.f2566a, b62Var);
        qc1Var.f7199a = (wd2) obj;
        return qc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((qc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityModuleDetail.this.finishAfterTransition();
        return m42.f6769a;
    }
}

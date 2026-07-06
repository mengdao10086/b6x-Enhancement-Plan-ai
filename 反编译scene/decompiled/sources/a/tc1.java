package a;

import com.omarea.vtools.activities.ActivityModuleUpload;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityModuleUpload$onCreate$1$2", f = "ActivityModuleUpload.kt", l = {}, m = "invokeSuspend")
public final class tc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModuleUpload.a f3011a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tc1(ActivityModuleUpload.a aVar, b62 b62Var) {
        super(2, b62Var);
        this.f3011a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        tc1 tc1Var = new tc1(this.f3011a, b62Var);
        tc1Var.f7488a = (wd2) obj;
        return tc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((tc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityModuleUpload.this.finishAfterTransition();
        return m42.f6769a;
    }
}

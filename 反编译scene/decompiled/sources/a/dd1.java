package a;

import com.omarea.vtools.activities.ActivityModules;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityModules$refreshCloudList$1$1", f = "ActivityModules.kt", l = {}, m = "invokeSuspend")
public final class dd1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModules.c f550a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd1(ActivityModules.c cVar, b62 b62Var) {
        super(2, b62Var);
        this.f550a = cVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        dd1 dd1Var = new dd1(this.f550a, b62Var);
        dd1Var.f5886a = (wd2) obj;
        return dd1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((dd1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityModules.this.s();
        return m42.f6769a;
    }
}

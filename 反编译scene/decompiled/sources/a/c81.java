package a;

import com.omarea.vtools.activities.ActivityAppContents;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityAppContents$myHandler$1$onAppStateChange$1", f = "ActivityAppContents.kt", l = {}, m = "invokeSuspend")
public final class c81 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppContents.a f358a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c81(ActivityAppContents.a aVar, b62 b62Var) {
        super(2, b62Var);
        this.f358a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        c81 c81Var = new c81(this.f358a, b62Var);
        c81Var.f5767a = (wd2) obj;
        return c81Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((c81) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityAppContents.this.u();
        return m42.f6769a;
    }
}

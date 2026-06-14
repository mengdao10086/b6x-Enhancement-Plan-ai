package a;

import com.omarea.vtools.activities.ActivityApplications;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityApplications$myHandler$1$onAppStateChange$1", f = "ActivityApplications.kt", l = {54}, m = "invokeSuspend")
public final class u81 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7575a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityApplications.b f3155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3156a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u81(ActivityApplications.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f3155a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        u81 u81Var = new u81(this.f3155a, b62Var);
        u81Var.f7575a = (wd2) obj;
        return u81Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((u81) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            this.f3156a = this.f7575a;
            this.b = 1;
            if (ke2.a(2000L, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        ActivityApplications.this.o();
        return m42.f6769a;
    }
}

package a;

import a.p80;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityApplications$onOptionsItemSelected$1$1$2$1$1", f = "ActivityApplications.kt", l = {}, m = "invokeSuspend")
public final class w81 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ x81 f3413a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w81(x81 x81Var, b62 b62Var) {
        super(2, b62Var);
        this.f3413a = x81Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        w81 w81Var = new w81(this.f3413a, b62Var);
        w81Var.f7766a = (wd2) obj;
        return w81Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((w81) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((p80.b) this.f3413a.f3544a.f7958a.f51a.f8567a.f6891a).c();
        return m42.f6769a;
    }
}

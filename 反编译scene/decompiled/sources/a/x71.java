package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityAppComponents$onCreate$4$1$2", f = "ActivityAppComponents.kt", l = {}, m = "invokeSuspend")
public final class x71 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ y71 f3538a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x71(y71 y71Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3538a = y71Var;
        this.f7859a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        x71 x71Var = new x71(this.f3538a, this.f7859a, b62Var);
        x71Var.f3537a = (wd2) obj;
        return x71Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((x71) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((u41) this.f3538a.f7955a.f6891a).h((ArrayList) this.f7859a.f6891a);
        return m42.f6769a;
    }
}

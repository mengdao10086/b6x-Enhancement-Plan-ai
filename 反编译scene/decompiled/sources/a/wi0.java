package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.MagiskModulesRepo$initRepository$2$1", f = "MagiskModulesRepo.kt", l = {}, m = "invokeSuspend")
public final class wi0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xi0 f3446a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wi0(xi0 xi0Var, b62 b62Var) {
        super(2, b62Var);
        this.f3446a = xi0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        wi0 wi0Var = new wi0(this.f3446a, b62Var);
        wi0Var.f7791a = (wd2) obj;
        return wi0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((wi0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Iterator it = this.f3446a.f3595a.iterator();
        while (it.hasNext()) {
            cy0 cy0VarC = this.f3446a.f3594a.c(((by0) it.next()).getPropUrl());
            if (cy0VarC != null) {
                t62.a(this.f3446a.f3594a.f7986a.b(cy0VarC));
            }
        }
        return m42.f6769a;
    }
}

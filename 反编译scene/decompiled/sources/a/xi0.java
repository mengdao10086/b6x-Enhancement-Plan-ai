package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.MagiskModulesRepo$initRepository$2", f = "MagiskModulesRepo.kt", l = {}, m = "invokeSuspend")
public final class xi0 extends d72 implements k82<wd2, b62<? super fe2<? extends m42>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yi0 f3594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f3595a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xi0(yi0 yi0Var, ArrayList arrayList, b62 b62Var) {
        super(2, b62Var);
        this.f3594a = yi0Var;
        this.f3595a = arrayList;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xi0 xi0Var = new xi0(this.f3594a, this.f3595a, b62Var);
        xi0Var.f7894a = (wd2) obj;
        return xi0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super fe2<? extends m42>> b62Var) {
        return ((xi0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        return qc2.b(this.f7894a, null, null, new wi0(this, null), 3, null);
    }
}

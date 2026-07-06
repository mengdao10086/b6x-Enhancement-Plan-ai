package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$setMainDevice$1$1$1$onConfirm$1$1", f = "FragmentUser.kt", l = {}, m = "invokeSuspend")
public final class uw1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vw1 f7639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3220a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uw1(vw1 vw1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7639a = vw1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        uw1 uw1Var = new uw1(this.f7639a, b62Var);
        uw1Var.f3220a = (wd2) obj;
        return uw1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((uw1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        cl clVarJ = this.f7639a.f3310a.f7830a.f7925a.f8016a.j();
        if (clVarJ != null) {
            clVarJ.finishAfterTransition();
        }
        return m42.f6769a;
    }
}

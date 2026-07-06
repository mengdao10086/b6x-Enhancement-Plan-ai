package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$getSceneProfile$1$3", f = "FragmentPerf.kt", l = {}, m = "invokeSuspend")
public final class cu1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ du1 f5830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f446a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu1(du1 du1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5830a = du1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        cu1 cu1Var = new cu1(this.f5830a, b62Var);
        cu1Var.f446a = (wd2) obj;
        return cu1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((cu1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Scene.c cVar = Scene.f4798a;
        String strJ = this.f5830a.f614a.J(u61.schedule_cloud_get_failure);
        f92.c(strJ, "getString(R.string.schedule_cloud_get_failure)");
        cVar.o(strJ, 0);
        return m42.f6769a;
    }
}

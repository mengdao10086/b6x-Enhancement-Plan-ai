package a;

import a.p80;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$getSceneProfile$1$2", f = "FragmentPerf.kt", l = {}, m = "invokeSuspend")
public final class bu1 extends d72 implements k82<wd2, b62<? super p80.b>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ du1 f5734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f301a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu1(du1 du1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5734a = du1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        bu1 bu1Var = new bu1(this.f5734a, b62Var);
        bu1Var.f301a = (wd2) obj;
        return bu1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super p80.b> b62Var) {
        return ((bu1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        p80.a aVar = p80.f2403a;
        cl clVarJ = this.f5734a.f614a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        String strJ = this.f5734a.f614a.J(u61.schedule_unsupported);
        f92.c(strJ, "getString(R.string.schedule_unsupported)");
        return p80.a.C(aVar, clVarJ, strJ, null, 4, null);
    }
}

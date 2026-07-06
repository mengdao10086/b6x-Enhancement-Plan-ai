package a;

import a.p80;
import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$getSceneProfile$1$1", f = "FragmentPerf.kt", l = {}, m = "invokeSuspend")
public final class au1 extends d72 implements k82<wd2, b62<? super p80.b>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ du1 f5643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f141a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au1(du1 du1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5643a = du1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        au1 au1Var = new au1(this.f5643a, b62Var);
        au1Var.f141a = (wd2) obj;
        return au1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super p80.b> b62Var) {
        return ((au1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        p80.a aVar = p80.f2403a;
        Context contextD1 = this.f5643a.f614a.d1();
        f92.c(contextD1, "requireContext()");
        String strJ = this.f5643a.f614a.J(u61.source_reboot);
        f92.c(strJ, "getString(R.string.source_reboot)");
        return aVar.i(contextD1, (16 & 2) != 0 ? "" : strJ, (16 & 4) != 0 ? "" : "", (16 & 8) != 0 ? null : new zt1(this), (16 & 16) != 0 ? null : null);
    }
}

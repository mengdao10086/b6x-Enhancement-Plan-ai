package a;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentHome$onViewCreated$7", f = "FragmentHome.kt", l = {}, m = "invokeSuspend")
public final class ls1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zs1 f1849a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ls1(zs1 zs1Var, b62 b62Var) {
        super(2, b62Var);
        this.f1849a = zs1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ls1 ls1Var = new ls1(this.f1849a, b62Var);
        ls1Var.f6737a = (wd2) obj;
        return ls1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ls1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        gk0.a((FrameLayout) this.f1849a.w1(t61.home_gpu_info), new ks1(this));
        return m42.f6769a;
    }
}

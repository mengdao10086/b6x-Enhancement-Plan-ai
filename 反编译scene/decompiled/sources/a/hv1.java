package a;

import android.widget.Switch;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$updateState$1$1", f = "FragmentPerf.kt", l = {}, m = "invokeSuspend")
public final class hv1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f6347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ iv1 f1209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1210a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ i92 f1211b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hv1(iv1 iv1Var, i92 i92Var, i92 i92Var2, b62 b62Var) {
        super(2, b62Var);
        this.f1209a = iv1Var;
        this.f6347a = i92Var;
        this.f1211b = i92Var2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        hv1 hv1Var = new hv1(this.f1209a, this.f6347a, this.f1211b, b62Var);
        hv1Var.f1210a = (wd2) obj;
        return hv1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((hv1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Switch r4 = (Switch) this.f1209a.f6447a.w1(t61.extreme_performance_on);
        if (r4 != null) {
            r4.setChecked(this.f6347a.b);
        }
        if (this.f1211b.b) {
            hz0.f1282a.K0(false);
            Switch r42 = (Switch) this.f1209a.f6447a.w1(t61.dynamic_control);
            if (r42 != null) {
                r42.setChecked(false);
            }
            z90.b(z90.f8048a, aa0.SCENE_CONFIG, null, 2, null);
        }
        return m42.f6769a;
    }
}

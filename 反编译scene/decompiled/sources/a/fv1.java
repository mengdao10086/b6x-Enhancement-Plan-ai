package a;

import android.content.pm.PackageManager;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$profileUpdateAsync$3", f = "FragmentPerf.kt", l = {}, m = "invokeSuspend")
public final class fv1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ho0 f6143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ kv1 f944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f945a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fv1(kv1 kv1Var, ho0 ho0Var, b62 b62Var) {
        super(2, b62Var);
        this.f944a = kv1Var;
        this.f6143a = ho0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        fv1 fv1Var = new fv1(this.f944a, this.f6143a, b62Var);
        fv1Var.f945a = (wd2) obj;
        return fv1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((fv1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws PackageManager.NameNotFoundException {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        String strH = Scene.f4798a.h(hz0.f1282a.x(), null);
        if (strH == null) {
            strH = "normal";
        }
        long jC = this.f6143a.C(strH);
        if (jC > 0 && jC != Scene.f4798a.g().getLong(hz0.f1282a.y(), 0L)) {
            this.f944a.P1(strH, !hz0.f1282a.b0());
        }
        return m42.f6769a;
    }
}

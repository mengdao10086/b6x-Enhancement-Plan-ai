package a;

import android.content.pm.PackageManager;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$getSceneProfile$1", f = "FragmentPerf.kt", l = {685, 699, 705}, m = "invokeSuspend")
public final class du1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ho0 f5939a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ kv1 f614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f617a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f618b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f619b;
    public final /* synthetic */ boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du1(kv1 kv1Var, ho0 ho0Var, String str, boolean z, boolean z2, b62 b62Var) {
        super(2, b62Var);
        this.f614a = kv1Var;
        this.f5939a = ho0Var;
        this.f617a = str;
        this.f619b = z;
        this.c = z2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        du1 du1Var = new du1(this.f614a, this.f5939a, this.f617a, this.f619b, this.c, b62Var);
        du1Var.f615a = (wd2) obj;
        return du1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((du1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws PackageManager.NameNotFoundException {
        ar0 ar0VarP;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f615a;
            ar0 ar0VarB = this.f5939a.B(this.f617a);
            if (ar0VarB.p() > 0) {
                Scene.f4798a.g().edit().putString(hz0.f1282a.c0(), "SOURCE_SCENE_ONLINE").putLong(hz0.f1282a.y(), ar0VarB.p()).putString(hz0.f1282a.x(), this.f617a).putString("machine", jm0.f6525a.a()).apply();
                if (!f92.a(this.f617a, "normal")) {
                    new wr0().c();
                }
                if (!this.f619b && this.c && !this.f614a.R() && (ar0VarP = this.f614a.f1689a.p()) != null && ar0VarP.j()) {
                    fg2 fg2VarC = qe2.c();
                    au1 au1Var = new au1(this, null);
                    this.f616a = wd2Var;
                    this.f618b = ar0VarB;
                    this.b = 1;
                    if (oc2.g(fg2VarC, au1Var, this) == objC) {
                        return objC;
                    }
                }
                this.f614a.N1();
            } else if (ar0VarB.p() == 0) {
                if (!this.f614a.R() && !this.f619b) {
                    fg2 fg2VarC2 = qe2.c();
                    bu1 bu1Var = new bu1(this, null);
                    this.f616a = wd2Var;
                    this.f618b = ar0VarB;
                    this.b = 2;
                    if (oc2.g(fg2VarC2, bu1Var, this) == objC) {
                        return objC;
                    }
                }
            } else if (!this.f614a.R() && !this.f619b) {
                fg2 fg2VarC3 = qe2.c();
                cu1 cu1Var = new cu1(this, null);
                this.f616a = wd2Var;
                this.f618b = ar0VarB;
                this.b = 3;
                if (oc2.g(fg2VarC3, cu1Var, this) == objC) {
                    return objC;
                }
            }
        } else if (i == 1) {
            h42.b(obj);
            this.f614a.N1();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}

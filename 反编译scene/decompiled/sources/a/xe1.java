package a;

import android.content.Context;
import com.omarea.vtools.activities.ActivityPowerStat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xe1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zg0 f3575a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityPowerStat f3576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3577a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xe1(zg0 zg0Var, b62 b62Var, ActivityPowerStat activityPowerStat) {
        super(2, b62Var);
        this.f3575a = zg0Var;
        this.f3576a = activityPowerStat;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xe1 xe1Var = new xe1(this.f3575a, b62Var, this.f3576a);
        xe1Var.f7880a = (wd2) obj;
        return xe1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((xe1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f7880a;
            zg0 zg0Var = this.f3575a;
            Context applicationContext = this.f3576a.getApplicationContext();
            f92.c(applicationContext, "applicationContext");
            zg0Var.b(applicationContext);
            e50.f677a.U0(null);
            this.f3577a = wd2Var;
            this.b = 1;
            if (ke2.a(500L, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            wd2Var = (wd2) this.f3577a;
            h42.b(obj);
        }
        fg2 fg2VarC = qe2.c();
        we1 we1Var = new we1(this, null);
        this.f3577a = wd2Var;
        this.b = 2;
        if (oc2.g(fg2VarC, we1Var, this) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}

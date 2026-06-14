package a;

import com.omarea.vtools.activities.ActivityFpsSessions;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gb1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u90 f6191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSessions.a f988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f989a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f990b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb1(u90 u90Var, b62 b62Var, ActivityFpsSessions.a aVar) {
        super(2, b62Var);
        this.f6191a = u90Var;
        this.f988a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        gb1 gb1Var = new gb1(this.f6191a, b62Var, this.f988a);
        gb1Var.f987a = (wd2) obj;
        return gb1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((gb1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f987a;
            List<String> listD = (f92.a(this.f988a.f8680a.getPackageName(), "android") ? ActivityFpsSessions.o(ActivityFpsSessions.this).b() : ActivityFpsSessions.o(ActivityFpsSessions.this).e(this.f988a.f8680a.getPackageName())).d();
            if (!listD.isEmpty()) {
                ActivityFpsSessions.this.y(listD);
            }
            ActivityFpsSessions.C(ActivityFpsSessions.this, false, 1, null);
            fg2 fg2VarC = qe2.c();
            fb1 fb1Var = new fb1(this, null);
            this.f989a = wd2Var;
            this.f990b = listD;
            this.b = 1;
            if (oc2.g(fg2VarC, fb1Var, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}

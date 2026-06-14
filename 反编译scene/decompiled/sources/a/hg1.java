package a;

import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityStartSplash$loginCallback$2$1$onLoginSuccess$2", f = "ActivityStartSplash.kt", l = {90}, m = "invokeSuspend")
public final class hg1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ig1 f6311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1168a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f1169b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hg1(ig1 ig1Var, boolean z, b62 b62Var) {
        super(2, b62Var);
        this.f6311a = ig1Var;
        this.f1169b = z;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        hg1 hg1Var = new hg1(this.f6311a, this.f1169b, b62Var);
        hg1Var.f1167a = (wd2) obj;
        return hg1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((hg1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1167a;
            if (this.f1169b) {
                ActivityStartSplash activityStartSplash = ActivityStartSplash.this;
                this.f1168a = wd2Var;
                this.b = 1;
                if (activityStartSplash.O(this) == objC) {
                    return objC;
                }
            } else {
                ActivityStartSplash.this.H().p();
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

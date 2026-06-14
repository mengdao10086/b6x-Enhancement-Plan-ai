package a;

import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityStartSplash$checkRoot$2$2", f = "ActivityStartSplash.kt", l = {539, 540}, m = "invokeSuspend")
public final class wf1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sn0 f7783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityStartSplash.h f3433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3434a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wf1(ActivityStartSplash.h hVar, sn0 sn0Var, b62 b62Var) {
        super(2, b62Var);
        this.f3433a = hVar;
        this.f7783a = sn0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        wf1 wf1Var = new wf1(this.f3433a, this.f7783a, b62Var);
        wf1Var.f3432a = (wd2) obj;
        return wf1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((wf1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f3432a;
            ActivityStartSplash activityStartSplash = ActivityStartSplash.this;
            this.f3434a = wd2Var;
            this.b = 1;
            if (activityStartSplash.O(this) == objC) {
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
            wd2Var = (wd2) this.f3434a;
            h42.b(obj);
        }
        sn0 sn0Var = this.f7783a;
        this.f3434a = wd2Var;
        this.b = 2;
        if (sn0.b(sn0Var, null, this, 1, null) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}

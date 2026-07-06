package a;

import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityStartSplash$checkRoot$2$3$1$onFail$2", f = "ActivityStartSplash.kt", l = {}, m = "invokeSuspend")
public final class xf1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yf1 f3579a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f3580b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xf1(yf1 yf1Var, boolean z, b62 b62Var) {
        super(2, b62Var);
        this.f3579a = yf1Var;
        this.f3580b = z;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xf1 xf1Var = new xf1(this.f3579a, this.f3580b, b62Var);
        xf1Var.f7884a = (wd2) obj;
        return xf1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((xf1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityStartSplash.this.G();
        if (!this.f3580b) {
            String strB0 = hz0.f1282a.B0();
            if (strB0 == null || strB0.length() == 0) {
                ActivityStartSplash activityStartSplash = ActivityStartSplash.this;
                new zm1(activityStartSplash, activityStartSplash.J(), ActivityStartSplash.this.I()).j();
            } else {
                ActivityStartSplash.this.H().p();
            }
        }
        return m42.f6769a;
    }
}

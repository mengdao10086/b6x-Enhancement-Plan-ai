package a;

import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityStartSplash$checkRoot$2$3", f = "ActivityStartSplash.kt", l = {544}, m = "invokeSuspend")
public final class zf1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sn0 f8068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityStartSplash.h f3843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3844a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zf1(ActivityStartSplash.h hVar, sn0 sn0Var, b62 b62Var) {
        super(2, b62Var);
        this.f3843a = hVar;
        this.f8068a = sn0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        zf1 zf1Var = new zf1(this.f3843a, this.f8068a, b62Var);
        zf1Var.f3842a = (wd2) obj;
        return zf1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((zf1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3842a;
            sn0 sn0Var = this.f8068a;
            yf1 yf1Var = new yf1(this);
            this.f3844a = wd2Var;
            this.b = 1;
            if (sn0Var.a(yf1Var, this) == objC) {
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

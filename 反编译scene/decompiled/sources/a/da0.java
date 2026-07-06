package a;

import com.omarea.model.BatteryStatus;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.data.GlobalStatus$updateBatteryTemperature$bat$1", f = "GlobalStatus.kt", l = {105}, m = "invokeSuspend")
public final class da0 extends d72 implements k82<wd2, b62<? super BatteryStatus>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f522a;
    public int b;

    public da0(b62 b62Var) {
        super(2, b62Var);
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        da0 da0Var = new da0(b62Var);
        da0Var.f5877a = (wd2) obj;
        return da0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super BatteryStatus> b62Var) {
        return ((da0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f5877a;
            dl0 dl0Var = hl0.f6321a;
            this.f522a = wd2Var;
            this.b = 1;
            obj = dl0Var.a(this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return obj;
    }
}

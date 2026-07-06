package a;

import com.omarea.ui.BatteryRealtimeStatus;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h91 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j91 f6289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1141a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1142a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h91(j91 j91Var, b62 b62Var) {
        super(2, b62Var);
        this.f6289a = j91Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        h91 h91Var = new h91(this.f6289a, b62Var);
        h91Var.f1141a = (wd2) obj;
        return h91Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((h91) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1141a;
            BatteryRealtimeStatus batteryRealtimeStatus = (BatteryRealtimeStatus) this.f6289a.f1516a._$_findCachedViewById(t61.view_realtime_values);
            this.f1142a = wd2Var;
            this.b = 1;
            if (batteryRealtimeStatus.e(this) == objC) {
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

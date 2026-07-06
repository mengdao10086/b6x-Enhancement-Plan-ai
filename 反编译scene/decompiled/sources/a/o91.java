package a;

import android.widget.TextView;
import com.omarea.vtools.activities.ActivityChargeStat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityChargeStat$onCreate$3$1", f = "ActivityChargeStat.kt", l = {}, m = "invokeSuspend")
public final class o91 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityChargeStat.c f2219a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o91(ActivityChargeStat.c cVar, b62 b62Var) {
        super(2, b62Var);
        this.f2219a = cVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        o91 o91Var = new o91(this.f2219a, b62Var);
        o91Var.f6997a = (wd2) obj;
        return o91Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((o91) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        TextView textView = (TextView) ActivityChargeStat.this._$_findCachedViewById(t61.charge_controller);
        f92.c(textView, "charge_controller");
        textView.setVisibility(0);
        ((TextView) ActivityChargeStat.this._$_findCachedViewById(t61.charge_controller)).setOnClickListener(new n91(this));
        return m42.f6769a;
    }
}

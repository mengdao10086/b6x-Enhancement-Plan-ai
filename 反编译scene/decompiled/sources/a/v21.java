package a;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.omarea.ui.BatteryRealtimeStatus;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.BatteryRealtimeStatus$initOnce$1$1", f = "BatteryRealtimeStatus.kt", l = {}, m = "invokeSuspend")
public final class v21 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BatteryRealtimeStatus.a f3229a;
    public int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v21(BatteryRealtimeStatus.a aVar, int i, b62 b62Var) {
        super(2, b62Var);
        this.f3229a = aVar;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        v21 v21Var = new v21(this.f3229a, this.c, b62Var);
        v21Var.f7651a = (wd2) obj;
        return v21Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((v21) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        TextView textView = (TextView) BatteryRealtimeStatus.this.a(t61.battery_cycle);
        f92.c(textView, "battery_cycle");
        SpannableString spannableString = new SpannableString(this.c + "  ");
        spannableString.setSpan(new UnderlineSpan(), 0, String.valueOf(this.c).length(), 0);
        m42 m42Var = m42.f6769a;
        textView.setText(spannableString);
        ((TextView) BatteryRealtimeStatus.this.a(t61.battery_cycle)).setOnClickListener(new u21(this));
        return m42.f6769a;
    }
}

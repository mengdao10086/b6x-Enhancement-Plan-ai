package a;

import android.widget.TextView;
import com.omarea.vtools.activities.ActivityFpsSession;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$4$1", f = "ActivityFpsSession.kt", l = {}, m = "invokeSuspend")
public final class db1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f5880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession.w f539a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ j92 f540b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ l92 f541b;
    public final /* synthetic */ j92 c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final /* synthetic */ l92 f542c;
    public final /* synthetic */ l92 d;
    public final /* synthetic */ l92 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db1(ActivityFpsSession.w wVar, l92 l92Var, l92 l92Var2, j92 j92Var, j92 j92Var2, j92 j92Var3, l92 l92Var3, l92 l92Var4, l92 l92Var5, b62 b62Var) {
        super(2, b62Var);
        this.f539a = wVar;
        this.f537a = l92Var;
        this.f541b = l92Var2;
        this.f5880a = j92Var;
        this.f540b = j92Var2;
        this.c = j92Var3;
        this.f542c = l92Var3;
        this.d = l92Var4;
        this.e = l92Var5;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        db1 db1Var = new db1(this.f539a, this.f537a, this.f541b, this.f5880a, this.f540b, this.c, this.f542c, this.d, this.e, b62Var);
        db1Var.f538a = (wd2) obj;
        return db1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((db1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        TextView textView = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.battery_io_max);
        f92.c(textView, "battery_io_max");
        q92 q92Var = q92.f7191a;
        String str = String.format("%dmA", Arrays.copyOf(new Object[]{t62.e(this.f537a.f6687a)}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        textView.setText(str);
        TextView textView2 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.battery_io_min);
        f92.c(textView2, "battery_io_min");
        q92 q92Var2 = q92.f7191a;
        String str2 = String.format("%dmA", Arrays.copyOf(new Object[]{t62.e(this.f541b.f6687a)}, 1));
        f92.c(str2, "java.lang.String.format(format, *args)");
        textView2.setText(str2);
        TextView textView3 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.power_max);
        f92.c(textView3, "power_max");
        q92 q92Var3 = q92.f7191a;
        String str3 = String.format("%.2fW", Arrays.copyOf(new Object[]{t62.c(this.f5880a.f6490a)}, 1));
        f92.c(str3, "java.lang.String.format(format, *args)");
        textView3.setText(str3);
        TextView textView4 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.power_min);
        f92.c(textView4, "power_min");
        q92 q92Var4 = q92.f7191a;
        String str4 = String.format("%.2fW", Arrays.copyOf(new Object[]{t62.c(this.f540b.f6490a)}, 1));
        f92.c(str4, "java.lang.String.format(format, *args)");
        textView4.setText(str4);
        TextView textView5 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.power_avg);
        f92.c(textView5, "power_avg");
        q92 q92Var5 = q92.f7191a;
        String str5 = String.format("%.2fW", Arrays.copyOf(new Object[]{t62.c(this.c.f6490a)}, 1));
        f92.c(str5, "java.lang.String.format(format, *args)");
        textView5.setText(str5);
        TextView textView6 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_avg);
        f92.c(textView6, "chart_power_avg");
        q92 q92Var6 = q92.f7191a;
        String str6 = String.format("%.2f", Arrays.copyOf(new Object[]{t62.c(this.c.f6490a)}, 1));
        f92.c(str6, "java.lang.String.format(format, *args)");
        textView6.setText(str6);
        TextView textView7 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.jank);
        f92.c(textView7, "jank");
        q92 q92Var7 = q92.f7191a;
        String str7 = String.format("%d", Arrays.copyOf(new Object[]{t62.e(this.f542c.f6687a)}, 1));
        f92.c(str7, "java.lang.String.format(format, *args)");
        textView7.setText(str7);
        TextView textView8 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.big_jank);
        f92.c(textView8, "big_jank");
        q92 q92Var8 = q92.f7191a;
        String str8 = String.format("%d", Arrays.copyOf(new Object[]{t62.e(this.d.f6687a)}, 1));
        f92.c(str8, "java.lang.String.format(format, *args)");
        textView8.setText(str8);
        TextView textView9 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.ftime_max);
        f92.c(textView9, "ftime_max");
        textView9.setText(this.e.f6687a + "ms");
        return m42.f6769a;
    }
}

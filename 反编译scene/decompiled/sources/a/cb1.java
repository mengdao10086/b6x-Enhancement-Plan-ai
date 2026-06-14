package a;

import android.widget.TextView;
import com.omarea.model.FpsWatchSession;
import com.omarea.vtools.activities.ActivityFpsSession;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$3$1", f = "ActivityFpsSession.kt", l = {}, m = "invokeSuspend")
public final class cb1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f5775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ k92 f365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession.v f369a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ j92 f370b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ k92 f371b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ n92 f372b;
    public final /* synthetic */ j92 c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final /* synthetic */ k92 f373c;
    public final /* synthetic */ k92 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb1(ActivityFpsSession.v vVar, k92 k92Var, n92 n92Var, n92 n92Var2, j92 j92Var, j92 j92Var2, k92 k92Var2, k92 k92Var3, k92 k92Var4, j92 j92Var3, l92 l92Var, b62 b62Var) {
        super(2, b62Var);
        this.f369a = vVar;
        this.f365a = k92Var;
        this.f367a = n92Var;
        this.f372b = n92Var2;
        this.f5775a = j92Var;
        this.f370b = j92Var2;
        this.f371b = k92Var2;
        this.f373c = k92Var3;
        this.d = k92Var4;
        this.c = j92Var3;
        this.f366a = l92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        cb1 cb1Var = new cb1(this.f369a, this.f365a, this.f367a, this.f372b, this.f5775a, this.f370b, this.f371b, this.f373c, this.d, this.c, this.f366a, b62Var);
        cb1Var.f368a = (wd2) obj;
        return cb1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((cb1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        String string;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        StringBuilder sb = new StringBuilder();
        float f = 45;
        if (this.f365a.f6587a > f) {
            sb.append(ActivityFpsSession.this.getString(u61.fps_warn_bat_temp) + this.f365a.f6587a + (char) 8451);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("    ≥45℃ ");
            ArrayList arrayList = (ArrayList) this.f367a.f6891a;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (t62.a(((Number) obj2).floatValue() > f).booleanValue()) {
                    arrayList2.add(obj2);
                }
            }
            sb2.append(arrayList2.size());
            sb2.append(ActivityFpsSession.this.getString(u61.fps_warn_seconds));
            sb.append(sb2.toString());
            ActivityFpsSession.this.q(sb);
        }
        String str = ((FpsWatchSession) this.f372b.f6891a).viewSize;
        if (!(str == null || str.length() == 0)) {
            TextView textView = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_view_size);
            f92.c(textView, "chart_view_size");
            textView.setText("crop: " + ((FpsWatchSession) this.f372b.f6891a).viewSize);
        }
        if (((FpsWatchSession) this.f372b.f6891a).packageVersion != null) {
            TextView textView2 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_session_name);
            f92.c(textView2, "chart_session_name");
            StringBuilder sb3 = new StringBuilder();
            TextView textView3 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_session_name);
            f92.c(textView3, "chart_session_name");
            CharSequence text = textView3.getText();
            if (text == null || (string = text.toString()) == null) {
                string = "";
            }
            sb3.append(string);
            sb3.append('(');
            sb3.append(((FpsWatchSession) this.f372b.f6891a).packageVersion);
            sb3.append(')');
            textView2.setText(sb3.toString());
        }
        TextView textView4 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_smooth_ratio);
        f92.c(textView4, "chart_smooth_ratio");
        q92 q92Var = q92.f7191a;
        String str2 = String.format("%.1f%%", Arrays.copyOf(new Object[]{t62.c(this.f5775a.f6490a)}, 1));
        f92.c(str2, "java.lang.String.format(format, *args)");
        textView4.setText(str2);
        if (this.f370b.f6490a > 0) {
            TextView textView5 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_low_fps);
            f92.c(textView5, "chart_low_fps");
            q92 q92Var2 = q92.f7191a;
            String str3 = String.format("%.1f", Arrays.copyOf(new Object[]{t62.c(this.f370b.f6490a)}, 1));
            f92.c(str3, "java.lang.String.format(format, *args)");
            textView5.setText(str3);
        }
        TextView textView6 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_temp_max);
        f92.c(textView6, "chart_temp_max");
        q92 q92Var3 = q92.f7191a;
        String str4 = String.format("%.1f", Arrays.copyOf(new Object[]{t62.d(this.f365a.f6587a)}, 1));
        f92.c(str4, "java.lang.String.format(format, *args)");
        textView6.setText(str4);
        TextView textView7 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_fps_max);
        f92.c(textView7, "chart_fps_max");
        q92 q92Var4 = q92.f7191a;
        String str5 = String.format("%.1f", Arrays.copyOf(new Object[]{t62.d(this.f371b.f6587a)}, 1));
        f92.c(str5, "java.lang.String.format(format, *args)");
        textView7.setText(str5);
        TextView textView8 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_fps_min);
        f92.c(textView8, "chart_fps_min");
        q92 q92Var5 = q92.f7191a;
        String str6 = String.format("%.1f", Arrays.copyOf(new Object[]{t62.d(this.f373c.f6587a)}, 1));
        f92.c(str6, "java.lang.String.format(format, *args)");
        textView8.setText(str6);
        TextView textView9 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_fps_avg);
        f92.c(textView9, "chart_fps_avg");
        q92 q92Var6 = q92.f7191a;
        String str7 = String.format("%.1f", Arrays.copyOf(new Object[]{t62.d(this.d.f6587a)}, 1));
        f92.c(str7, "java.lang.String.format(format, *args)");
        textView9.setText(str7);
        TextView textView10 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_fps_variance);
        f92.c(textView10, "chart_fps_variance");
        q92 q92Var7 = q92.f7191a;
        String str8 = String.format("%.1f", Arrays.copyOf(new Object[]{t62.c(this.c.f6490a)}, 1));
        f92.c(str8, "java.lang.String.format(format, *args)");
        textView10.setText(str8);
        TextView textView11 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.battery_io_avg);
        f92.c(textView11, "battery_io_avg");
        q92 q92Var8 = q92.f7191a;
        String str9 = String.format("%dmA", Arrays.copyOf(new Object[]{t62.e(this.f366a.f6687a)}, 1));
        f92.c(str9, "java.lang.String.format(format, *args)");
        textView11.setText(str9);
        return m42.f6769a;
    }
}

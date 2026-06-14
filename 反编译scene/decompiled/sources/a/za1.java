package a;

import android.widget.TextView;
import com.omarea.vtools.activities.ActivityFpsSession;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$15$1", f = "ActivityFpsSession.kt", l = {}, m = "invokeSuspend")
public final class za1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k92 f8053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession.s f3822a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ k92 f3823b;
    public final /* synthetic */ k92 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za1(ActivityFpsSession.s sVar, k92 k92Var, k92 k92Var2, k92 k92Var3, b62 b62Var) {
        super(2, b62Var);
        this.f3822a = sVar;
        this.f8053a = k92Var;
        this.f3823b = k92Var2;
        this.c = k92Var3;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        za1 za1Var = new za1(this.f3822a, this.f8053a, this.f3823b, this.c, b62Var);
        za1Var.f3821a = (wd2) obj;
        return za1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((za1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        TextView textView = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.cpu_temperature_max);
        f92.c(textView, "cpu_temperature_max");
        q92 q92Var = q92.f7191a;
        String str = String.format("%.1f℃", Arrays.copyOf(new Object[]{t62.d(this.f8053a.f6587a)}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        textView.setText(str);
        TextView textView2 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.cpu_temperature_min);
        f92.c(textView2, "cpu_temperature_min");
        q92 q92Var2 = q92.f7191a;
        String str2 = String.format("%.1f℃", Arrays.copyOf(new Object[]{t62.d(this.f3823b.f6587a)}, 1));
        f92.c(str2, "java.lang.String.format(format, *args)");
        textView2.setText(str2);
        TextView textView3 = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.cpu_temperature_avg);
        f92.c(textView3, "cpu_temperature_avg");
        q92 q92Var3 = q92.f7191a;
        String str3 = String.format("%.1f℃", Arrays.copyOf(new Object[]{t62.d(this.c.f6587a)}, 1));
        f92.c(str3, "java.lang.String.format(format, *args)");
        textView3.setText(str3);
        return m42.f6769a;
    }
}

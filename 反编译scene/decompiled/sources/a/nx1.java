package a;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.omarea.ui.FloatMonitorBatteryView;
import com.omarea.ui.FloatMonitorChartView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nx1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ double f6957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ int f2158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ j92 f2159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ox1 f2160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SpannableStringBuilder f2161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2162a;
    public final /* synthetic */ String b;

    public nx1(ox1 ox1Var, SpannableStringBuilder spannableStringBuilder, j92 j92Var, String str, String str2, int i, double d) {
        this.f2160a = ox1Var;
        this.f2161a = spannableStringBuilder;
        this.f2159a = j92Var;
        this.f2162a = str;
        this.b = str2;
        this.f2158a = i;
        this.f6957a = d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = this.f2160a.f2341e;
        if (textView != null) {
            textView.setText(this.f2160a.f2337b ? this.f2161a : null);
        }
        FloatMonitorChartView floatMonitorChartView = this.f2160a.f2329a;
        f92.b(floatMonitorChartView);
        floatMonitorChartView.d(100.0f, (float) (((double) 100) - this.f2159a.f6490a));
        TextView textView2 = this.f2160a.f2327a;
        f92.b(textView2);
        textView2.setText(this.f2160a.x(this.f2162a) + "MHz");
        TextView textView3 = this.f2160a.f2335b;
        f92.b(textView3);
        textView3.setText(this.b);
        if (this.f2158a > -1) {
            FloatMonitorChartView floatMonitorChartView2 = this.f2160a.f2336b;
            f92.b(floatMonitorChartView2);
            floatMonitorChartView2.d(100.0f, 100.0f - this.f2158a);
        }
        FloatMonitorBatteryView floatMonitorBatteryView = this.f2160a.f2328a;
        f92.b(floatMonitorBatteryView);
        floatMonitorBatteryView.d(100.0d, 100.0d - ((double) fa0.f867a.a()), this.f6957a);
        TextView textView4 = this.f2160a.f2338c;
        f92.b(textView4);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6957a);
        sb.append((char) 8451);
        textView4.setText(sb.toString());
        TextView textView5 = this.f2160a.f2340d;
        f92.b(textView5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.valueOf(fa0.f867a.a()));
        sb2.append("%");
        sb2.append(fa0.f867a.c() == 2 ? "+" : "");
        textView5.setText(sb2.toString());
    }
}

package a;

import android.widget.TextView;
import com.omarea.ui.MemoryChartView;
import com.omarea.ui.RamBarView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ys1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ long f3770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ vl0 f3771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zs1 f3772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Long f3773a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public ys1(zs1 zs1Var, vl0 vl0Var, long j, long j2, long j3, long j4, int i, Long l) {
        this.f3772a = zs1Var;
        this.f3771a = vl0Var;
        this.f3770a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.f8009a = i;
        this.f3773a = l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        try {
            TextView textView = (TextView) this.f3772a.w1(t61.home_swap_cached);
            f92.c(textView, "home_swap_cached");
            textView.setText("" + (this.f3771a.c() / 1024) + "MB");
            long j = (long) 100;
            long j2 = ((this.f3770a - this.b) * j) / this.f3770a;
            TextView textView2 = (TextView) this.f3772a.w1(t61.home_raminfo_text);
            if (textView2 != null) {
                textView2.setText(j2 + "% (" + this.f3772a.M1(this.f3770a / 1048576.0d) + "GB)");
            }
            RamBarView ramBarView = (RamBarView) this.f3772a.w1(t61.home_ramstat);
            if (ramBarView != null) {
                ramBarView.e(this.f3770a, this.c, 0.0f, this.d);
            }
            RamBarView ramBarView2 = (RamBarView) this.f3772a.w1(t61.home_swapstat);
            if (ramBarView2 != null) {
                RamBarView.f(ramBarView2, this.f3771a.e(), this.f3771a.e() - this.f8009a, 5.0f, 0.0f, 8, null);
            }
            float fE = this.f3770a + ((long) this.f3771a.e());
            float f = this.f3770a;
            long jE = ((this.f3770a + ((long) this.f3771a.e())) - this.b) - ((long) this.f3771a.d());
            if (this.f3773a != null) {
                long jLongValue = jE - this.f3773a.longValue();
                MemoryChartView memoryChartView = (MemoryChartView) this.f3772a.w1(t61.home_memory_total);
                if (memoryChartView != null) {
                    memoryChartView.c(fE, fE - jE, f);
                }
                TextView textView3 = (TextView) this.f3772a.w1(t61.home_memory_ratio);
                if (textView3 != null) {
                    long j3 = (jE * j) / this.f3770a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(j3);
                    sb.append('%');
                    textView3.setText(sb.toString());
                    kk0.a(textView3, "(" + ((int) ((j * jLongValue) / f)) + "%)", new ws1(textView3, this, jE, jLongValue, f));
                }
            } else {
                MemoryChartView memoryChartView2 = (MemoryChartView) this.f3772a.w1(t61.home_memory_total);
                if (memoryChartView2 != null) {
                    memoryChartView2.c(fE, fE - jE, f);
                }
                TextView textView4 = (TextView) this.f3772a.w1(t61.home_memory_ratio);
                if (textView4 != null) {
                    textView4.setText("" + ((int) ((jE * j) / f)) + "%");
                }
                TextView textView5 = (TextView) this.f3772a.w1(t61.home_memory_ratio);
                if (textView5 != null) {
                    kk0.a(textView5, "( ≤ )", new xs1(this));
                }
            }
            int iE = (int) ((((double) this.f8009a) * 100.0d) / ((double) this.f3771a.e()));
            TextView textView6 = (TextView) this.f3772a.w1(t61.home_zramsize_text);
            if (textView6 != null) {
                if (this.f3771a.e() >= 1048576) {
                    str = iE + "% (" + this.f3772a.M1(((double) this.f3771a.e()) / 1048576.0d) + "GB)";
                } else {
                    str = iE + "% (" + (this.f3771a.e() / 1024) + "MB)";
                }
                textView6.setText(str);
            }
        } catch (Exception unused) {
        }
    }
}

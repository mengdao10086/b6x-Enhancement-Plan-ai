package a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.omarea.common.ui.OverScrollGridView;
import com.omarea.ui.CpuBigBarView;
import com.omarea.ui.CpuChartView;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class us1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ double f7628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ int f3207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ bm0 f3208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zs1 f3209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f3211a;
    public final /* synthetic */ double b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ String f3212b;
    public final /* synthetic */ double c;

    public us1(zs1 zs1Var, int i, double d, double d2, String str, bm0 bm0Var, double d3, ArrayList arrayList, String str2) {
        this.f3209a = zs1Var;
        this.f3207a = i;
        this.f7628a = d;
        this.b = d2;
        this.f3210a = str;
        this.f3208a = bm0Var;
        this.c = d3;
        this.f3211a = arrayList;
        this.f3212b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        StringBuilder sb;
        String str;
        int iI1;
        try {
            TextView textView2 = (TextView) this.f3209a.w1(t61.home_running_time);
            f92.c(textView2, "home_running_time");
            textView2.setText(this.f3209a.K1());
            TextView textView3 = (TextView) this.f3209a.w1(t61.home_battery_now);
            f92.c(textView3, "home_battery_now");
            textView3.setText(fa0.f867a.n());
            TextView textView4 = (TextView) this.f3209a.w1(t61.home_battery_capacity);
            f92.c(textView4, "home_battery_capacity");
            textView4.setText(this.f3207a + "%  " + this.f7628a + 'v');
            TextView textView5 = (TextView) this.f3209a.w1(t61.home_battery_temperature);
            f92.c(textView5, "home_battery_temperature");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.b);
            sb2.append((char) 8451);
            textView5.setText(sb2.toString());
            TextView textView6 = (TextView) this.f3209a.w1(t61.home_gpu_freq);
            f92.c(textView6, "home_gpu_freq");
            textView6.setText(this.f3210a);
            if (this.f3208a.e() >= 0.0d) {
                textView = (TextView) this.f3209a.w1(t61.home_gpu_load);
                f92.c(textView, "home_gpu_load");
                sb = new StringBuilder();
                sb.append(this.f3209a.J(u61.home_utilization));
                sb.append(this.f3208a.e());
                sb.append('%');
            } else {
                textView = (TextView) this.f3209a.w1(t61.home_gpu_load);
                f92.c(textView, "home_gpu_load");
                sb = new StringBuilder();
                sb.append(this.f3209a.J(u61.home_utilization));
                sb.append("--%");
            }
            textView.setText(sb.toString());
            if (this.f3208a.e() > -1) {
                ((CpuChartView) this.f3209a.w1(t61.home_gpu_chat)).f(100, 100 - this.f3208a.e());
            }
            TextView textView7 = (TextView) this.f3209a.w1(t61.cput_temperature);
            f92.c(textView7, "cput_temperature");
            if (this.f3208a.l() > 0) {
                q92 q92Var = q92.f7191a;
                str = String.format("%.1f℃", Arrays.copyOf(new Object[]{Double.valueOf(this.f3208a.l())}, 1));
                f92.c(str, "java.lang.String.format(format, *args)");
            } else {
                str = "";
            }
            textView7.setText(str);
            TextView textView8 = (TextView) this.f3209a.w1(t61.cpu_core_total_load);
            f92.c(textView8, "cpu_core_total_load");
            textView8.setText(this.f3209a.J(u61.home_utilization) + String.valueOf((int) this.c) + "%");
            ((CpuBigBarView) this.f3209a.w1(t61.home_cpu_chat)).a((float) 100, (float) (100 - ((int) this.c)));
            OverScrollGridView overScrollGridView = (OverScrollGridView) this.f3209a.w1(t61.cpu_core_list);
            f92.c(overScrollGridView, "cpu_core_list");
            if (overScrollGridView.getAdapter() == null) {
                OverScrollGridView overScrollGridView2 = (OverScrollGridView) this.f3209a.w1(t61.cpu_core_list);
                f92.c(overScrollGridView2, "cpu_core_list");
                ViewGroup.LayoutParams layoutParams = overScrollGridView2.getLayoutParams();
                if (this.f3211a.size() < 6) {
                    OverScrollGridView overScrollGridView3 = (OverScrollGridView) this.f3209a.w1(t61.cpu_core_list);
                    f92.c(overScrollGridView3, "cpu_core_list");
                    overScrollGridView3.setNumColumns(2);
                } else {
                    if (this.f3211a.size() > 12) {
                        iI1 = this.f3209a.I1(340.0f);
                    } else if (this.f3211a.size() > 8) {
                        iI1 = this.f3209a.I1(255.0f);
                    }
                    layoutParams.height = iI1;
                    OverScrollGridView overScrollGridView4 = (OverScrollGridView) this.f3209a.w1(t61.cpu_core_list);
                    f92.c(overScrollGridView4, "cpu_core_list");
                    overScrollGridView4.setLayoutParams(layoutParams);
                    OverScrollGridView overScrollGridView5 = (OverScrollGridView) this.f3209a.w1(t61.cpu_core_list);
                    f92.c(overScrollGridView5, "cpu_core_list");
                    Context contextP = this.f3209a.p();
                    f92.b(contextP);
                    f92.c(contextP, "context!!");
                    overScrollGridView5.setAdapter((ListAdapter) new z01(contextP, this.f3211a));
                }
                iI1 = this.f3209a.I1(170.0f);
                layoutParams.height = iI1;
                OverScrollGridView overScrollGridView42 = (OverScrollGridView) this.f3209a.w1(t61.cpu_core_list);
                f92.c(overScrollGridView42, "cpu_core_list");
                overScrollGridView42.setLayoutParams(layoutParams);
                OverScrollGridView overScrollGridView52 = (OverScrollGridView) this.f3209a.w1(t61.cpu_core_list);
                f92.c(overScrollGridView52, "cpu_core_list");
                Context contextP2 = this.f3209a.p();
                f92.b(contextP2);
                f92.c(contextP2, "context!!");
                overScrollGridView52.setAdapter((ListAdapter) new z01(contextP2, this.f3211a));
            } else {
                OverScrollGridView overScrollGridView6 = (OverScrollGridView) this.f3209a.w1(t61.cpu_core_list);
                f92.c(overScrollGridView6, "cpu_core_list");
                ListAdapter adapter = overScrollGridView6.getAdapter();
                if (adapter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterCpuCores");
                }
                ((z01) adapter).b(this.f3211a);
            }
            TextView textView9 = (TextView) this.f3209a.w1(t61.home_gpu_info_text);
            f92.c(textView9, "home_gpu_info_text");
            textView9.setText(this.f3209a.d);
            TextView textView10 = (TextView) this.f3209a.w1(t61.cpu_soc_platform);
            if (textView10 != null) {
                textView10.setText(this.f3212b + " (" + this.f3209a.O1() + ')');
            }
        } catch (Exception unused) {
        }
    }
}

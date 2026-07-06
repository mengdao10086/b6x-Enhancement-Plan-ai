package a;

import android.app.ActivityManager;
import android.widget.TextView;
import com.omarea.ui.CpuChartBarView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zy1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ double f8109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ az1 f3905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ cm0 f3906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f3907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f3908a;

    public zy1(az1 az1Var, l92 l92Var, cm0 cm0Var, n92 n92Var, double d) {
        this.f3905a = az1Var;
        this.f3907a = l92Var;
        this.f3906a = cm0Var;
        this.f3908a = n92Var;
        this.f8109a = d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        int iA;
        TextView textView = this.f3905a.f173a;
        if (textView != null) {
            textView.setText(String.valueOf(this.f3907a.f6687a / 1000));
        }
        CpuChartBarView cpuChartBarView = this.f3905a.f174a;
        if (cpuChartBarView != null) {
            cpuChartBarView.setData(az1.c(this.f3905a));
        }
        CpuChartBarView cpuChartBarView2 = this.f3905a.f180b;
        if (cpuChartBarView2 != null) {
            cpuChartBarView2.a(100.0f, 100.0f - this.f3906a.e());
        }
        TextView textView2 = this.f3905a.f179b;
        if (textView2 != null) {
            textView2.setText(this.f3906a.d() > -1 ? String.valueOf(this.f3906a.d()) : "--");
        }
        TextView textView3 = this.f3905a.f183c;
        if (textView3 != null) {
            textView3.setText((String) this.f3908a.f6891a);
        }
        if (!this.f3905a.x()) {
            TextView textView4 = this.f3905a.f184d;
            if (textView4 != null) {
                double d = this.f8109a;
                textView4.setText(d >= ((double) 100) ? String.valueOf((int) d) : String.valueOf(d));
                return;
            }
            return;
        }
        if (this.f3905a.c % 3 == 1) {
            ActivityManager activityManager = this.f3905a.f169a;
            f92.b(activityManager);
            activityManager.getMemoryInfo(this.f3905a.f168a);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager2 = this.f3905a.f169a;
            f92.b(activityManager2);
            activityManager2.getMemoryInfo(memoryInfo);
            long j = 1024;
            int i = (int) ((memoryInfo.totalMem / j) / 1024.0f);
            if (this.f3905a.s() && (!f92.a(e50.f677a.y0(), "basic"))) {
                vl0 vl0Var = (vl0) pc2.b(null, new yy1(this, null), 1, null);
                iA = (vl0Var.a() + vl0Var.c()) / 1024;
            } else {
                iA = (int) ((memoryInfo.availMem / j) / 1024.0f);
            }
            TextView textView5 = this.f3905a.f184d;
            if (textView5 != null) {
                textView5.setText("" + (((i - iA) * 100) / i) + "%");
            }
        }
        this.f3905a.c++;
    }
}

package a;

import android.content.Context;
import android.widget.Toast;
import com.omarea.vtools.activities.ActivitySwap;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rg1 f2569a;

    public qg1(rg1 rg1Var, long j) {
        this.f2569a = rg1Var;
        this.f7211a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivitySwap.j(ActivitySwap.this).c();
        rg1 rg1Var = this.f2569a;
        int i = (int) ((((double) rg1Var.f7298a) * 1000.0d) / this.f7211a);
        Context context = ActivitySwap.this.getContext();
        String string = ActivitySwap.this.getString(u61.swap_swapfile_speed);
        f92.c(string, "getString(R.string.swap_swapfile_speed)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(this.f7211a / ((long) 1000)), Integer.valueOf(i)}, 2));
        f92.c(str, "java.lang.String.format(this, *args)");
        Toast.makeText(context, str, 1).show();
        ActivitySwap.this.J();
    }
}

package a;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rx1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aa0 f7340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ sx1 f2798a;

    public rx1(sx1 sx1Var, aa0 aa0Var) {
        this.f2798a = sx1Var;
        this.f7340a = aa0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        int i;
        this.f2798a.f7442a.E();
        int i2 = qx1.f7249a[this.f7340a.ordinal()];
        if (i2 == 1 || i2 == 2) {
            context = this.f2798a.f7442a.f2473a;
            context2 = this.f2798a.f7442a.f2473a;
            i = u61.fps_record_stop_screen;
        } else if (i2 == 3 || i2 == 4) {
            context = this.f2798a.f7442a.f2473a;
            context2 = this.f2798a.f7442a.f2473a;
            i = u61.fps_record_stop_power;
        } else {
            context = this.f2798a.f7442a.f2473a;
            context2 = this.f2798a.f7442a.f2473a;
            i = u61.fps_record_stop_foreground;
        }
        Toast.makeText(context, context2.getString(i), 0).show();
    }
}

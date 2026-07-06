package a;

import a.p80;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ai1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ di1 f5610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f71a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Activity f72a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Point f73a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ DisplayMetrics f74a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Display f75a;

    public ai1(di1 di1Var, p80.b bVar, Display display, Point point, DisplayMetrics displayMetrics, Activity activity) {
        this.f5610a = di1Var;
        this.f71a = bVar;
        this.f75a = display;
        this.f73a = point;
        this.f74a = displayMetrics;
        this.f72a = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f71a.g()) {
            try {
                this.f71a.c();
            } catch (Exception unused) {
            }
        }
        this.f5610a.o();
        if (Build.VERSION.SDK_INT >= 24) {
            this.f75a.getRealSize(this.f73a);
            new Handler(Looper.getMainLooper()).postDelayed(new zh1(this), 1000L);
        }
    }
}

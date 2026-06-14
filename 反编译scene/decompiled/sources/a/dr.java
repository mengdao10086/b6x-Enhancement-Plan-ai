package a;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f595a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public dr(View view) {
        this.f595a = view;
    }

    public void a(PointF pointF) {
        this.c = Math.round(pointF.x);
        this.d = Math.round(pointF.y);
        int i = this.f + 1;
        this.f = i;
        if (this.e == i) {
            b();
        }
    }

    public final void b() {
        ys.f(this.f595a, this.f5929a, this.b, this.c, this.d);
        this.e = 0;
        this.f = 0;
    }

    public void c(PointF pointF) {
        this.f5929a = Math.round(pointF.x);
        this.b = Math.round(pointF.y);
        int i = this.e + 1;
        this.e = i;
        if (i == this.f) {
            b();
        }
    }
}

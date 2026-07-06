package a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2606a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2608b;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2604a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2607b = Integer.MAX_VALUE;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Integer> f2605a = new ArrayList();

    public int a() {
        return this.g;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.h - this.i;
    }

    public void d(View view, int i, int i2, int i3, int i4) {
        pu puVar = (pu) view.getLayoutParams();
        this.f2604a = Math.min(this.f2604a, (view.getLeft() - puVar.g()) - i);
        this.f2607b = Math.min(this.f2607b, (view.getTop() - puVar.f()) - i2);
        this.c = Math.max(this.c, view.getRight() + puVar.i() + i3);
        this.d = Math.max(this.d, view.getBottom() + puVar.p() + i4);
    }
}

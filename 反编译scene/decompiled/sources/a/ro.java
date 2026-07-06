package a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ro {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView.d0 f2765a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public RecyclerView.d0 f2766b;
    public int c;
    public int d;

    public ro(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        this.f2765a = d0Var;
        this.f2766b = d0Var2;
    }

    public ro(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i, int i2, int i3, int i4) {
        this(d0Var, d0Var2);
        this.f7318a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.f2765a + ", newHolder=" + this.f2766b + ", fromX=" + this.f7318a + ", fromY=" + this.b + ", toX=" + this.c + ", toY=" + this.d + '}';
    }
}

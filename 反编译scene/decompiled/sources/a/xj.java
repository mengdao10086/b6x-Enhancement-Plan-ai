package a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class xj extends uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f7896a;
    public int b;
    public int c;

    @Deprecated
    public xj(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.c = i;
        this.b = i;
        this.f7896a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // a.uj
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f7896a.inflate(this.c, viewGroup, false);
    }

    @Override // a.uj
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f7896a.inflate(this.b, viewGroup, false);
    }
}

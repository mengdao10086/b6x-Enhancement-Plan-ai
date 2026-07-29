package d1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f25940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LayoutInflater f25942n;

    @Deprecated
    public c(Context context, int i10, Cursor cursor) {
        super(context, cursor);
        this.f25941m = i10;
        this.f25940l = i10;
        this.f25942n = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // d1.a
    public View i(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f25942n.inflate(this.f25941m, viewGroup, false);
    }

    @Override // d1.a
    public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f25942n.inflate(this.f25940l, viewGroup, false);
    }

    public void n(int i10) {
        this.f25941m = i10;
    }

    public void o(int i10) {
        this.f25940l = i10;
    }

    @Deprecated
    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f25941m = i10;
        this.f25940l = i10;
        this.f25942n = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public c(Context context, int i10, Cursor cursor, int i11) {
        super(context, cursor, i11);
        this.f25941m = i10;
        this.f25940l = i10;
        this.f25942n = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}

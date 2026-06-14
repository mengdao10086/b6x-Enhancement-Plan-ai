package a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zp implements jq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.o f8086a;

    public zp(RecyclerView.o oVar) {
        this.f8086a = oVar;
    }

    @Override // a.jq
    public View a(int i) {
        return this.f8086a.S(i);
    }

    @Override // a.jq
    public int b(View view) {
        return this.f8086a.Y(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }

    @Override // a.jq
    public int c() {
        return this.f8086a.getPaddingTop();
    }

    @Override // a.jq
    public int d() {
        return this.f8086a.g0() - this.f8086a.getPaddingBottom();
    }

    @Override // a.jq
    public int e(View view) {
        return this.f8086a.e0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }
}

package a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yp implements jq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.o f8000a;

    public yp(RecyclerView.o oVar) {
        this.f8000a = oVar;
    }

    @Override // a.jq
    public View a(int i) {
        return this.f8000a.S(i);
    }

    @Override // a.jq
    public int b(View view) {
        return this.f8000a.d0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
    }

    @Override // a.jq
    public int c() {
        return this.f8000a.getPaddingLeft();
    }

    @Override // a.jq
    public int d() {
        return this.f8000a.t0() - this.f8000a.getPaddingRight();
    }

    @Override // a.jq
    public int e(View view) {
        return this.f8000a.a0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
    }
}

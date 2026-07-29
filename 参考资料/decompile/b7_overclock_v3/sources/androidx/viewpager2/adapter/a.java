package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends RecyclerView.e0 {
    public a(@n0 FrameLayout frameLayout) {
        super(frameLayout);
    }

    @n0
    public static a h(@n0 ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(u0.D());
        frameLayout.setSaveEnabled(false);
        return new a(frameLayout);
    }

    @n0
    public FrameLayout i() {
        return (FrameLayout) this.itemView;
    }
}

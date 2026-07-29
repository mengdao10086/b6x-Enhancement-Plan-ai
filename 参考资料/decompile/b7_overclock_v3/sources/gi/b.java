package gi;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends RecyclerView.e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f29555b;

    public b(View view, eu.davidea.flexibleadapter.b bVar, boolean z10) {
        super(z10 ? new FrameLayout(view.getContext()) : view);
        this.f29554a = -1;
        if (z10) {
            this.itemView.setLayoutParams(bVar.getRecyclerView().getLayoutManager().U(view.getLayoutParams()));
            ((FrameLayout) this.itemView).addView(view);
            float fR = u0.R(view);
            if (fR > 0.0f) {
                u0.I1(this.itemView, view.getBackground());
                u0.N1(this.itemView, fR);
            }
            this.f29555b = view;
        }
    }

    public final View h() {
        View view = this.f29555b;
        return view != null ? view : this.itemView;
    }

    public final int i() {
        int adapterPosition = getAdapterPosition();
        return adapterPosition == -1 ? this.f29554a : adapterPosition;
    }

    public final void j(int i10) {
        this.f29554a = i10;
    }
}

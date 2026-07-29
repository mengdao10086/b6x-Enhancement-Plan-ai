package u8;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.game.R;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class b extends RecyclerView.n {
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(@k Rect rect, @k View view, @k RecyclerView recyclerView, @k RecyclerView.b0 b0Var) {
        super.d(rect, view, recyclerView, b0Var);
        if (recyclerView.r0(view) < ((GridLayoutManager) recyclerView.getLayoutManager()).H3()) {
            rect.top = view.getResources().getDimensionPixelSize(R.dimen.qb_px_12);
        }
        rect.bottom = view.getResources().getDimensionPixelSize(R.dimen.qb_px_12);
    }
}

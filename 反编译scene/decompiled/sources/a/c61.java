package a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class c61 extends RecyclerView.d0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c61(View view) {
        super(view);
        f92.d(view, "view");
    }

    public final void M() {
        View view = ((RecyclerView.d0) this).f4387a;
        f92.c(view, "itemView");
        view.setAlpha(1.0f);
    }

    public final void N() {
        View view = ((RecyclerView.d0) this).f4387a;
        f92.c(view, "itemView");
        view.setAlpha(0.8f);
    }
}

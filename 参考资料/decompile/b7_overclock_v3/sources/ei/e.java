package ei;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import ei.i;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e<VH extends RecyclerView.e0, H extends i> extends c<VH> implements k<VH, H> {
    public H header;

    public e(H h10) {
        this.header = h10;
    }

    @Override // ei.k
    public void t(H h10) {
        this.header = h10;
    }

    @Override // ei.k
    public H u() {
        return this.header;
    }
}

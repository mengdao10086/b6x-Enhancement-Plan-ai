package xh;

import android.database.Cursor;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import com.umeng.analytics.pro.ar;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d<VH extends RecyclerView.e0> extends RecyclerView.g<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cursor f55335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f55336b;

    public d(Cursor cursor) {
        setHasStableIds(true);
        p(cursor);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        if (n(this.f55335a)) {
            return this.f55335a.getCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i10) {
        if (!n(this.f55335a)) {
            throw new IllegalStateException("Cannot lookup item id when cursor is in invalid state.");
        }
        if (this.f55335a.moveToPosition(i10)) {
            return this.f55335a.getLong(this.f55336b);
        }
        throw new IllegalStateException("Could not move cursor to position " + i10 + " when trying to get an item id");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i10) {
        if (this.f55335a.moveToPosition(i10)) {
            return m(i10, this.f55335a);
        }
        throw new IllegalStateException("Could not move cursor to position " + i10 + " when trying to get item view type.");
    }

    public Cursor l() {
        return this.f55335a;
    }

    public abstract int m(int i10, Cursor cursor);

    public final boolean n(Cursor cursor) {
        return (cursor == null || cursor.isClosed()) ? false : true;
    }

    public abstract void o(VH vh2, Cursor cursor);

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(VH vh2, int i10) {
        if (!n(this.f55335a)) {
            throw new IllegalStateException("Cannot bind view holder when cursor is in invalid state.");
        }
        if (this.f55335a.moveToPosition(i10)) {
            o(vh2, this.f55335a);
            return;
        }
        throw new IllegalStateException("Could not move cursor to position " + i10 + " when trying to bind view holder");
    }

    public void p(Cursor cursor) {
        if (cursor == this.f55335a) {
            return;
        }
        if (cursor != null) {
            this.f55335a = cursor;
            this.f55336b = cursor.getColumnIndexOrThrow(ar.f23316d);
            notifyDataSetChanged();
        } else {
            notifyItemRangeRemoved(0, getItemCount());
            this.f55335a = null;
            this.f55336b = -1;
        }
    }
}

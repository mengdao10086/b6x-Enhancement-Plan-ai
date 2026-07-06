package a;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wj extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vj f7794a;

    public wj(vj vjVar) {
        this.f7794a = vjVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f7794a.a((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorC = this.f7794a.c(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorC != null) {
            filterResults.count = cursorC.getCount();
        } else {
            filterResults.count = 0;
            cursorC = null;
        }
        filterResults.values = cursorC;
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorB = this.f7794a.b();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorB) {
            return;
        }
        this.f7794a.d((Cursor) obj);
    }
}

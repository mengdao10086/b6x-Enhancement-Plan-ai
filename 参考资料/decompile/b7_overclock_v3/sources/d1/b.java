package d1;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f25939a;

    public interface a {
        CharSequence a(Cursor cursor);

        void b(Cursor cursor);

        Cursor c();

        Cursor d(CharSequence charSequence);
    }

    public b(a aVar) {
        this.f25939a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f25939a.a((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorD = this.f25939a.d(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorD != null) {
            filterResults.count = cursorD.getCount();
            filterResults.values = cursorD;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorC = this.f25939a.c();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorC) {
            return;
        }
        this.f25939a.b((Cursor) obj);
    }
}

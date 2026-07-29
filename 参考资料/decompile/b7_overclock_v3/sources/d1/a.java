package d1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;
import com.umeng.analytics.pro.ar;
import d1.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final int f25926j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25927k = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean f25928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean f25929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Cursor f25930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context f25931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int f25932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public C0289a f25933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DataSetObserver f25934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public d1.b f25935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FilterQueryProvider f25936i;

    /* JADX INFO: renamed from: d1.a$a, reason: collision with other inner class name */
    public class C0289a extends ContentObserver {
        public C0289a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            a.this.k();
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f25928a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f25928a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public a(Context context, Cursor cursor) {
        g(context, cursor, 1);
    }

    public CharSequence a(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public void b(Cursor cursor) {
        Cursor cursorM = m(cursor);
        if (cursorM != null) {
            cursorM.close();
        }
    }

    @Override // d1.b.a
    public Cursor c() {
        return this.f25930c;
    }

    public Cursor d(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f25936i;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f25930c;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    public FilterQueryProvider f() {
        return this.f25936i;
    }

    public void g(Context context, Cursor cursor, int i10) {
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f25929b = true;
        } else {
            this.f25929b = false;
        }
        boolean z10 = cursor != null;
        this.f25930c = cursor;
        this.f25928a = z10;
        this.f25931d = context;
        this.f25932e = z10 ? cursor.getColumnIndexOrThrow(ar.f23316d) : -1;
        if ((i10 & 2) == 2) {
            this.f25933f = new C0289a();
            this.f25934g = new b();
        } else {
            this.f25933f = null;
            this.f25934g = null;
        }
        if (z10) {
            C0289a c0289a = this.f25933f;
            if (c0289a != null) {
                cursor.registerContentObserver(c0289a);
            }
            DataSetObserver dataSetObserver = this.f25934g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f25928a || (cursor = this.f25930c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f25928a) {
            return null;
        }
        this.f25930c.moveToPosition(i10);
        if (view == null) {
            view = i(this.f25931d, this.f25930c, viewGroup);
        }
        e(view, this.f25931d, this.f25930c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f25935h == null) {
            this.f25935h = new d1.b(this);
        }
        return this.f25935h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f25928a || (cursor = this.f25930c) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f25930c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        if (this.f25928a && (cursor = this.f25930c) != null && cursor.moveToPosition(i10)) {
            return this.f25930c.getLong(this.f25932e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f25928a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f25930c.moveToPosition(i10)) {
            if (view == null) {
                view = j(this.f25931d, this.f25930c, viewGroup);
            }
            e(view, this.f25931d, this.f25930c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i10);
    }

    @Deprecated
    public void h(Context context, Cursor cursor, boolean z10) {
        g(context, cursor, z10 ? 1 : 2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public View i(Context context, Cursor cursor, ViewGroup viewGroup) {
        return j(context, cursor, viewGroup);
    }

    public abstract View j(Context context, Cursor cursor, ViewGroup viewGroup);

    public void k() {
        Cursor cursor;
        if (!this.f25929b || (cursor = this.f25930c) == null || cursor.isClosed()) {
            return;
        }
        this.f25928a = this.f25930c.requery();
    }

    public void l(FilterQueryProvider filterQueryProvider) {
        this.f25936i = filterQueryProvider;
    }

    public Cursor m(Cursor cursor) {
        Cursor cursor2 = this.f25930c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0289a c0289a = this.f25933f;
            if (c0289a != null) {
                cursor2.unregisterContentObserver(c0289a);
            }
            DataSetObserver dataSetObserver = this.f25934g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f25930c = cursor;
        if (cursor != null) {
            C0289a c0289a2 = this.f25933f;
            if (c0289a2 != null) {
                cursor.registerContentObserver(c0289a2);
            }
            DataSetObserver dataSetObserver2 = this.f25934g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f25932e = cursor.getColumnIndexOrThrow(ar.f23316d);
            this.f25928a = true;
            notifyDataSetChanged();
        } else {
            this.f25932e = -1;
            this.f25928a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public a(Context context, Cursor cursor, boolean z10) {
        g(context, cursor, z10 ? 1 : 2);
    }

    public a(Context context, Cursor cursor, int i10) {
        g(context, cursor, i10);
    }
}

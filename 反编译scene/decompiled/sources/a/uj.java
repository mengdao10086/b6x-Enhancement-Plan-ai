package a;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class uj extends BaseAdapter implements Filterable, vj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sj f3179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wj f3180a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f3181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Cursor f3182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataSetObserver f3183a;
    public boolean b;
    public boolean c;

    public uj(Context context, Cursor cursor, boolean z) {
        f(context, cursor, z ? 1 : 2);
    }

    public abstract CharSequence a(Cursor cursor);

    @Override // a.vj
    public Cursor b() {
        return this.f3182a;
    }

    public void d(Cursor cursor) {
        Cursor cursorJ = j(cursor);
        if (cursorJ != null) {
            cursorJ.close();
        }
    }

    public abstract void e(View view, Context context, Cursor cursor);

    public void f(Context context, Cursor cursor, int i) {
        tj tjVar;
        if ((i & 1) == 1) {
            i |= 2;
            this.c = true;
        } else {
            this.c = false;
        }
        boolean z = cursor != null;
        this.f3182a = cursor;
        this.b = z;
        this.f3181a = context;
        this.f7603a = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f3179a = new sj(this);
            tjVar = new tj(this);
        } else {
            tjVar = null;
            this.f3179a = null;
        }
        this.f3183a = tjVar;
        if (z) {
            sj sjVar = this.f3179a;
            if (sjVar != null) {
                cursor.registerContentObserver(sjVar);
            }
            DataSetObserver dataSetObserver = this.f3183a;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.b || (cursor = this.f3182a) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.b) {
            return null;
        }
        this.f3182a.moveToPosition(i);
        if (view == null) {
            view = g(this.f3181a, this.f3182a, viewGroup);
        }
        e(view, this.f3181a, this.f3182a);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f3180a == null) {
            this.f3180a = new wj(this);
        }
        return this.f3180a;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.b || (cursor = this.f3182a) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f3182a;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.b && (cursor = this.f3182a) != null && cursor.moveToPosition(i)) {
            return this.f3182a.getLong(this.f7603a);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f3182a.moveToPosition(i)) {
            if (view == null) {
                view = h(this.f3181a, this.f3182a, viewGroup);
            }
            e(view, this.f3181a, this.f3182a);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    public void i() {
        Cursor cursor;
        if (!this.c || (cursor = this.f3182a) == null || cursor.isClosed()) {
            return;
        }
        this.b = this.f3182a.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f3182a;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            sj sjVar = this.f3179a;
            if (sjVar != null) {
                cursor2.unregisterContentObserver(sjVar);
            }
            DataSetObserver dataSetObserver = this.f3183a;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f3182a = cursor;
        if (cursor != null) {
            sj sjVar2 = this.f3179a;
            if (sjVar2 != null) {
                cursor.registerContentObserver(sjVar2);
            }
            DataSetObserver dataSetObserver2 = this.f3183a;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f7603a = cursor.getColumnIndexOrThrow("_id");
            this.b = true;
            notifyDataSetChanged();
        } else {
            this.f7603a = -1;
            this.b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}

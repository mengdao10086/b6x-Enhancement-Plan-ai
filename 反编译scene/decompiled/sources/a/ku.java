package a;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ku {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSetObservable f6641a = new DataSetObservable();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataSetObserver f1688a;

    public abstract void a(ViewGroup viewGroup, int i, Object obj);

    public abstract void b(ViewGroup viewGroup);

    public abstract int c();

    public int d(Object obj) {
        return -1;
    }

    public abstract CharSequence e(int i);

    public float f(int i) {
        return 1.0f;
    }

    public abstract Object g(ViewGroup viewGroup, int i);

    public abstract boolean h(View view, Object obj);

    public void i() {
        synchronized (this) {
            if (this.f1688a != null) {
                this.f1688a.onChanged();
            }
        }
        this.f6641a.notifyChanged();
    }

    public void j(DataSetObserver dataSetObserver) {
        this.f6641a.registerObserver(dataSetObserver);
    }

    public abstract void k(Parcelable parcelable, ClassLoader classLoader);

    public abstract Parcelable l();

    public abstract void m(ViewGroup viewGroup, int i, Object obj);

    public void n(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f1688a = dataSetObserver;
        }
    }

    public abstract void o(ViewGroup viewGroup);

    public void p(DataSetObserver dataSetObserver) {
        this.f6641a.unregisterObserver(dataSetObserver);
    }
}

package il;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSetObservable f32470a = new DataSetObservable();

    public abstract int a();

    public abstract c b(Context context);

    public abstract d c(Context context, int i10);

    public float d(Context context, int i10) {
        return 1.0f;
    }

    public final void e() {
        this.f32470a.notifyChanged();
    }

    public final void f() {
        this.f32470a.notifyInvalidated();
    }

    public final void g(DataSetObserver dataSetObserver) {
        this.f32470a.registerObserver(dataSetObserver);
    }

    public final void h(DataSetObserver dataSetObserver) {
        this.f32470a.unregisterObserver(dataSetObserver);
    }
}

package ji;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import g.n0;
import io.objectbox.query.Query;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class f<T> extends PositionalDataSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Query<T> f36429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pi.a<List<T>> f36430b;

    public static class a<Item> extends DataSource.Factory<Integer, Item> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Query<Item> f36431a;

        public a(Query<Item> query) {
            this.f36431a = query;
        }

        @n0
        public DataSource<Integer, Item> a() {
            return new f(this.f36431a);
        }
    }

    public f(Query<T> query) {
        this.f36429a = query;
        pi.a<List<T>> aVar = new pi.a() { // from class: ji.e
            @Override // pi.a
            public final void b(Object obj) {
                this.f36428a.b((List) obj);
            }
        };
        this.f36430b = aVar;
        query.J2().i().l().f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list) {
        invalidate();
    }

    public void c(@n0 PositionalDataSource.LoadInitialParams loadInitialParams, @n0 PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        int iU = (int) this.f36429a.u();
        if (iU == 0) {
            loadInitialCallback.onResult(Collections.emptyList(), 0, 0);
            return;
        }
        int iComputeInitialLoadPosition = computeInitialLoadPosition(loadInitialParams, iU);
        int iComputeInitialLoadSize = computeInitialLoadSize(loadInitialParams, iComputeInitialLoadPosition, iU);
        List<T> listD = d(iComputeInitialLoadPosition, iComputeInitialLoadSize);
        if (listD.size() == iComputeInitialLoadSize) {
            loadInitialCallback.onResult(listD, iComputeInitialLoadPosition, iU);
        } else {
            invalidate();
        }
    }

    public final List<T> d(int i10, int i11) {
        return this.f36429a.Z(i10, i11);
    }

    public void e(@n0 PositionalDataSource.LoadRangeParams loadRangeParams, @n0 PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(d(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }
}

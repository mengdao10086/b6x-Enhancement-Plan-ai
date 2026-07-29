package ii;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.Transaction;
import io.objectbox.exception.DbException;
import io.objectbox.query.QueryBuilder;
import io.objectbox.query.h0;
import io.objectbox.relation.RelationInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BoxStore f32381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f32382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadLocal<Cursor<T>> f32383c = new ThreadLocal<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Cursor<T>> f32384d = new ThreadLocal<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ni.c<T> f32385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EntityInfo<T> f32386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Field f32387g;

    public a(BoxStore boxStore, Class<T> cls) {
        this.f32381a = boxStore;
        this.f32382b = cls;
        this.f32385e = boxStore.p1(cls).getIdGetter();
    }

    @li.c
    public List<T> A(int i10, Property<?> property, long j10) {
        Cursor<T> cursorQ = q();
        try {
            return cursorQ.getBacklinkEntities(i10, property, j10);
        } finally {
            O(cursorQ);
        }
    }

    @li.c
    public List<T> B(int i10, int i11, long j10, boolean z10) {
        Cursor<T> cursorQ = q();
        try {
            return cursorQ.getRelationEntities(i10, i11, j10, z10);
        } finally {
            O(cursorQ);
        }
    }

    @li.c
    public long[] C(int i10, int i11, long j10, boolean z10) {
        Cursor<T> cursorQ = q();
        try {
            return cursorQ.getRelationIds(i10, i11, j10, z10);
        } finally {
            O(cursorQ);
        }
    }

    public final boolean D(T t10) {
        return false;
    }

    public boolean E() {
        return f(1L) == 0;
    }

    @li.b
    public long F() {
        return this.f32381a.A2(m().getEntityId());
    }

    public long G(T t10) {
        Cursor<T> cursorX = x();
        try {
            long jPut = cursorX.put(t10);
            c(cursorX);
            return jPut;
        } finally {
            P(cursorX);
        }
    }

    public void H(@Nullable Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Cursor<T> cursorX = x();
        try {
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                cursorX.put(it2.next());
            }
            c(cursorX);
        } finally {
            P(cursorX);
        }
    }

    @SafeVarargs
    public final void I(@Nullable T... tArr) {
        if (tArr == null || tArr.length == 0) {
            return;
        }
        Cursor<T> cursorX = x();
        try {
            for (T t10 : tArr) {
                cursorX.put(t10);
            }
            c(cursorX);
        } finally {
            P(cursorX);
        }
    }

    public void J(@Nullable Collection<T> collection, int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("Batch size must be 1 or greater but was " + i10);
        }
        if (collection == null) {
            return;
        }
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            Cursor<T> cursorX = x();
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= i10) {
                    break;
                }
                try {
                    if (!it2.hasNext()) {
                        break;
                    }
                    cursorX.put(it2.next());
                    i11 = i12;
                } finally {
                    P(cursorX);
                }
            }
            c(cursorX);
        }
    }

    public final boolean K(T t10) {
        return false;
    }

    public QueryBuilder<T> L() {
        return new QueryBuilder<>(this, this.f32381a.j2(), this.f32381a.i1(this.f32382b));
    }

    @li.b
    public QueryBuilder<T> M(h0<T> h0Var) {
        return L().b(h0Var);
    }

    public void N(Transaction transaction) {
        Cursor<T> cursor = this.f32383c.get();
        if (cursor == null || cursor.getTx() != transaction) {
            return;
        }
        this.f32383c.remove();
        cursor.close();
    }

    public void O(Cursor<T> cursor) {
        if (this.f32383c.get() == null) {
            Transaction tx = cursor.getTx();
            if (tx.isClosed() || tx.u() || !tx.e0()) {
                throw new IllegalStateException("Illegal reader TX state");
            }
            tx.z();
        }
    }

    public void P(Cursor<T> cursor) {
        if (this.f32383c.get() == null) {
            Transaction tx = cursor.getTx();
            if (tx.isClosed()) {
                return;
            }
            cursor.close();
            tx.a();
            tx.close();
        }
    }

    public void Q(@Nullable Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Cursor<T> cursorX = x();
        try {
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                cursorX.deleteEntity(cursorX.getId(it2.next()));
            }
            c(cursorX);
        } finally {
            P(cursorX);
        }
    }

    public void R(@Nullable long... jArr) {
        if (jArr == null || jArr.length == 0) {
            return;
        }
        Cursor<T> cursorX = x();
        try {
            for (long j10 : jArr) {
                cursorX.deleteEntity(j10);
            }
            c(cursorX);
        } finally {
            P(cursorX);
        }
    }

    @SafeVarargs
    public final void S(@Nullable T... tArr) {
        if (tArr == null || tArr.length == 0) {
            return;
        }
        Cursor<T> cursorX = x();
        try {
            for (T t10 : tArr) {
                cursorX.deleteEntity(cursorX.getId(t10));
            }
            c(cursorX);
        } finally {
            P(cursorX);
        }
    }

    public boolean T(long j10) {
        Cursor<T> cursorX = x();
        try {
            boolean zDeleteEntity = cursorX.deleteEntity(j10);
            c(cursorX);
            return zDeleteEntity;
        } finally {
            P(cursorX);
        }
    }

    public boolean U(T t10) {
        Cursor<T> cursorX = x();
        try {
            boolean zDeleteEntity = cursorX.deleteEntity(cursorX.getId(t10));
            c(cursorX);
            return zDeleteEntity;
        } finally {
            P(cursorX);
        }
    }

    public void V() {
        Cursor<T> cursorX = x();
        try {
            cursorX.deleteAll();
            c(cursorX);
        } finally {
            P(cursorX);
        }
    }

    public void W(@Nullable Collection<Long> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Cursor<T> cursorX = x();
        try {
            Iterator<Long> it2 = collection.iterator();
            while (it2.hasNext()) {
                cursorX.deleteEntity(it2.next().longValue());
            }
            c(cursorX);
        } finally {
            P(cursorX);
        }
    }

    @Deprecated
    public void X(@Nullable Collection<Long> collection) {
        W(collection);
    }

    public void Y(Transaction transaction) {
        Cursor<T> cursor = this.f32383c.get();
        if (cursor != null) {
            this.f32383c.remove();
            cursor.close();
        }
    }

    @li.a
    public void a(T t10) {
        if (this.f32387g == null) {
            try {
                this.f32387g = ni.f.b().a(this.f32382b, "__boxStore");
            } catch (Exception e10) {
                throw new DbException("Entity cannot be attached - only active entities with relationships support attaching (class has no __boxStore field(?)) : " + this.f32382b, e10);
            }
        }
        try {
            this.f32387g.set(t10, this.f32381a);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        }
    }

    public void b() {
        Cursor<T> cursor = this.f32384d.get();
        if (cursor != null) {
            cursor.close();
            cursor.getTx().close();
            this.f32384d.remove();
        }
    }

    public void c(Cursor<T> cursor) {
        if (this.f32383c.get() == null) {
            cursor.close();
            cursor.getTx().f();
        }
    }

    public boolean d(long j10) {
        Cursor<T> cursorQ = q();
        try {
            return cursorQ.seek(j10);
        } finally {
            O(cursorQ);
        }
    }

    public long e() {
        return f(0L);
    }

    public long f(long j10) {
        Cursor<T> cursorQ = q();
        try {
            return cursorQ.count(j10);
        } finally {
            O(cursorQ);
        }
    }

    public T g(long j10) {
        Cursor<T> cursorQ = q();
        try {
            return cursorQ.get(j10);
        } finally {
            O(cursorQ);
        }
    }

    public List<T> h(Iterable<Long> iterable) {
        ArrayList arrayList = new ArrayList();
        Cursor<T> cursorQ = q();
        try {
            Iterator<Long> it2 = iterable.iterator();
            while (it2.hasNext()) {
                T t10 = cursorQ.get(it2.next().longValue());
                if (t10 != null) {
                    arrayList.add(t10);
                }
            }
            return arrayList;
        } finally {
            O(cursorQ);
        }
    }

    public List<T> i(long[] jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        Cursor<T> cursorQ = q();
        try {
            for (long j10 : jArr) {
                T t10 = cursorQ.get(Long.valueOf(j10).longValue());
                if (t10 != null) {
                    arrayList.add(t10);
                }
            }
            return arrayList;
        } finally {
            O(cursorQ);
        }
    }

    public Cursor<T> j() {
        Transaction transaction = this.f32381a.f32631p.get();
        if (transaction == null) {
            return null;
        }
        if (transaction.isClosed()) {
            throw new IllegalStateException("Active TX is closed");
        }
        Cursor<T> cursor = this.f32383c.get();
        if (cursor != null && !cursor.getTx().isClosed()) {
            return cursor;
        }
        Cursor<T> cursorH = transaction.h(this.f32382b);
        this.f32383c.set(cursorH);
        return cursorH;
    }

    public List<T> k() {
        ArrayList arrayList = new ArrayList();
        Cursor<T> cursorQ = q();
        try {
            for (T tFirst = cursorQ.first(); tFirst != null; tFirst = cursorQ.next()) {
                arrayList.add(tFirst);
            }
            return arrayList;
        } finally {
            O(cursorQ);
        }
    }

    public Class<T> l() {
        return this.f32382b;
    }

    public synchronized EntityInfo<T> m() {
        if (this.f32386f == null) {
            Cursor<T> cursorQ = q();
            try {
                this.f32386f = cursorQ.getEntityInfo();
                O(cursorQ);
            } catch (Throwable th2) {
                O(cursorQ);
                throw th2;
            }
        }
        return this.f32386f;
    }

    @li.c
    public long n(T t10) {
        return this.f32385e.getId(t10);
    }

    public Map<Long, T> o(Iterable<Long> iterable) {
        HashMap map = new HashMap();
        Cursor<T> cursorQ = q();
        try {
            for (Long l10 : iterable) {
                map.put(l10, cursorQ.get(l10.longValue()));
            }
            return map;
        } finally {
            O(cursorQ);
        }
    }

    public int p(String str) {
        Cursor<T> cursorQ = q();
        try {
            return cursorQ.getPropertyId(str);
        } finally {
            O(cursorQ);
        }
    }

    public Cursor<T> q() {
        Cursor<T> cursorJ = j();
        if (cursorJ != null) {
            return cursorJ;
        }
        Cursor<T> cursor = this.f32384d.get();
        if (cursor == null) {
            Cursor<T> cursorH = this.f32381a.f().h(this.f32382b);
            this.f32384d.set(cursorH);
            return cursorH;
        }
        Transaction transaction = cursor.tx;
        if (transaction.isClosed() || !transaction.u()) {
            throw new IllegalStateException("Illegal reader TX state");
        }
        transaction.I();
        cursor.renew();
        return cursor;
    }

    public String r() {
        Cursor<T> cursorQ = q();
        try {
            return cursorQ + " with " + cursorQ.getTx() + "; store's commit count: " + w().f32634s;
        } finally {
            O(cursorQ);
        }
    }

    public List<T> s(RelationInfo<T, ?> relationInfo, long j10) {
        return B(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j10, true);
    }

    public long[] t(RelationInfo<T, ?> relationInfo, long j10) {
        return C(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j10, true);
    }

    public List<T> u(RelationInfo<?, T> relationInfo, long j10) {
        return B(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j10, false);
    }

    public long[] v(RelationInfo<?, T> relationInfo, long j10) {
        return C(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j10, false);
    }

    public BoxStore w() {
        return this.f32381a;
    }

    public Cursor<T> x() {
        Cursor<T> cursorJ = j();
        if (cursorJ != null) {
            return cursorJ;
        }
        Transaction transactionH = this.f32381a.h();
        try {
            return transactionH.h(this.f32382b);
        } catch (RuntimeException e10) {
            transactionH.close();
            throw e10;
        }
    }

    @li.c
    public <RESULT> RESULT y(ni.a<RESULT> aVar) {
        Cursor<T> cursorQ = q();
        try {
            return aVar.a(cursorQ.internalHandle());
        } finally {
            O(cursorQ);
        }
    }

    @li.c
    public <RESULT> RESULT z(ni.a<RESULT> aVar) {
        Cursor<T> cursorX = x();
        try {
            RESULT resultA = aVar.a(cursorX.internalHandle());
            c(cursorX);
            return resultA;
        } finally {
            P(cursorX);
        }
    }
}

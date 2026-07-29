package io.objectbox.relation;

import ii.i;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.exception.DbDetachedException;
import io.objectbox.internal.ToManyGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.query.k0;
import io.objectbox.relation.ListFactory;
import j3.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import ni.c;
import ni.f;

/* JADX INFO: loaded from: classes5.dex */
public class ToMany<TARGET> implements List<TARGET>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f32911f = 1;
    private static final long serialVersionUID = 2367317778240689006L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient BoxStore f32912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ii.a<Object> f32913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile transient ii.a<TARGET> f32914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient boolean f32915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient Comparator<TARGET> f32916e;
    private List<TARGET> entities;
    private volatile Map<TARGET, Boolean> entitiesAdded;
    private Map<TARGET, Boolean> entitiesRemoved;
    public List<TARGET> entitiesToPut;
    public List<TARGET> entitiesToRemoveFromDb;
    private final Object entity;
    private Map<TARGET, Integer> entityCounts;
    private volatile ListFactory listFactory;
    private final RelationInfo<Object, TARGET> relationInfo;

    public class a implements Comparator<TARGET> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<TARGET> f32917a;

        public a() {
            this.f32917a = ToMany.this.relationInfo.targetInfo.getIdGetter();
        }

        @Override // java.util.Comparator
        public int compare(TARGET target, TARGET target2) {
            long id2 = this.f32917a.getId(target);
            long id3 = this.f32917a.getId(target2);
            if (id2 == 0) {
                id2 = Long.MAX_VALUE;
            }
            if (id3 == 0) {
                id3 = Long.MAX_VALUE;
            }
            long j10 = id2 - id3;
            if (j10 < 0) {
                return -1;
            }
            return j10 > 0 ? 1 : 0;
        }
    }

    public ToMany(Object obj, RelationInfo<?, TARGET> relationInfo) {
        if (obj == null) {
            throw new IllegalArgumentException("No source entity given (null)");
        }
        if (relationInfo == null) {
            throw new IllegalArgumentException("No relation info given (null)");
        }
        this.entity = obj;
        this.relationInfo = relationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        y(i.d(this.f32913b), i.d(this.f32914c));
    }

    public boolean A() {
        return this.entities != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean C(long j10, c<TARGET> cVar, @Nullable Map<TARGET, Boolean> map, @Nullable Map<TARGET, Boolean> map2) {
        boolean z10;
        ToManyGetter<TARGET> toManyGetter = this.relationInfo.backlinkToManyGetter;
        synchronized (this) {
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        for (TARGET target : map.keySet()) {
                            ToMany toMany = (ToMany) toManyGetter.s(target);
                            if (toMany == 0) {
                                throw new IllegalStateException("The ToMany property for " + this.relationInfo.targetInfo.getEntityName() + " is null");
                            }
                            if (toMany.p(j10) == null) {
                                toMany.add(this.entity);
                                this.entitiesToPut.add(target);
                            } else if (cVar.getId(target) == 0) {
                                this.entitiesToPut.add(target);
                            }
                        }
                        map.clear();
                    }
                } finally {
                }
            }
            if (map2 != null) {
                for (TARGET target2 : map2.keySet()) {
                    ToMany toMany2 = (ToMany) toManyGetter.s(target2);
                    if (toMany2.p(j10) != null) {
                        toMany2.E(j10);
                        if (cVar.getId(target2) != 0) {
                            if (this.f32915d) {
                                this.entitiesToRemoveFromDb.add(target2);
                            } else {
                                this.entitiesToPut.add(target2);
                            }
                        }
                    }
                }
                map2.clear();
            }
            z10 = (this.entitiesToPut.isEmpty() && this.entitiesToRemoveFromDb.isEmpty()) ? false : true;
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean D(long j10, c<TARGET> cVar, @Nullable Map<TARGET, Boolean> map, @Nullable Map<TARGET, Boolean> map2) {
        boolean z10;
        ToOneGetter<TARGET> toOneGetter = this.relationInfo.backlinkToOneGetter;
        synchronized (this) {
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        for (TARGET target : map.keySet()) {
                            ToOne<TARGET> toOneJ0 = toOneGetter.j0(target);
                            if (toOneJ0 == 0) {
                                throw new IllegalStateException("The ToOne property for " + this.relationInfo.targetInfo.getEntityName() + b.f36044h + this.relationInfo.targetIdProperty.name + " is null");
                            }
                            if (toOneJ0.k() != j10) {
                                toOneJ0.x(this.entity);
                                this.entitiesToPut.add(target);
                            } else if (cVar.getId(target) == 0) {
                                this.entitiesToPut.add(target);
                            }
                        }
                        map.clear();
                    }
                } finally {
                }
            }
            if (map2 != null) {
                for (TARGET target2 : map2.keySet()) {
                    ToOne<TARGET> toOneJ02 = toOneGetter.j0(target2);
                    if (toOneJ02.k() == j10) {
                        toOneJ02.x(null);
                        if (cVar.getId(target2) != 0) {
                            if (this.f32915d) {
                                this.entitiesToRemoveFromDb.add(target2);
                            } else {
                                this.entitiesToPut.add(target2);
                            }
                        }
                    }
                }
                map2.clear();
            }
            z10 = (this.entitiesToPut.isEmpty() && this.entitiesToRemoveFromDb.isEmpty()) ? false : true;
        }
        return z10;
    }

    public synchronized TARGET E(long j10) {
        l();
        int size = this.entities.size();
        c<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        for (int i10 = 0; i10 < size; i10++) {
            TARGET target = this.entities.get(i10);
            if (idGetter.getId(target) == j10) {
                TARGET targetRemove = remove(i10);
                if (targetRemove == target) {
                    return target;
                }
                throw new IllegalStateException("Mismatch: " + targetRemove + " vs. " + target);
            }
        }
        return null;
    }

    public final void G(Cursor<?> cursor, long j10, List<TARGET> list, c<TARGET> cVar) {
        Iterator<TARGET> it2 = list.iterator();
        while (it2.hasNext()) {
            if (cVar.getId(it2.next()) == 0) {
                it2.remove();
            }
        }
        int size = list.size();
        if (size > 0) {
            long[] jArr = new long[size];
            for (int i10 = 0; i10 < size; i10++) {
                jArr[i10] = cVar.getId(list.get(i10));
            }
            cursor.modifyRelations(this.relationInfo.relationId, j10, jArr, true);
        }
    }

    public synchronized void H() {
        this.entities = null;
        this.entitiesAdded = null;
        this.entitiesRemoved = null;
        this.entitiesToRemoveFromDb = null;
        this.entitiesToPut = null;
        this.entityCounts = null;
    }

    @li.b
    public void I(Comparator<TARGET> comparator) {
        this.f32916e = comparator;
    }

    @li.b
    public void J(ListFactory listFactory) {
        if (listFactory == null) {
            throw new IllegalArgumentException("ListFactory is null");
        }
        this.listFactory = listFactory;
    }

    @li.b
    public synchronized void K(boolean z10) {
        this.f32915d = z10;
    }

    public void L() {
        l();
        Collections.sort(this.entities, new a());
    }

    public final void M(TARGET target) {
        m();
        Integer numPut = this.entityCounts.put(target, f32911f);
        if (numPut != null) {
            this.entityCounts.put(target, Integer.valueOf(numPut.intValue() + 1));
        }
        this.entitiesAdded.put(target, Boolean.TRUE);
        this.entitiesRemoved.remove(target);
    }

    public final void N(Collection<? extends TARGET> collection) {
        m();
        Iterator<? extends TARGET> it2 = collection.iterator();
        while (it2.hasNext()) {
            M(it2.next());
        }
    }

    public final void O(TARGET target) {
        m();
        Integer numRemove = this.entityCounts.remove(target);
        if (numRemove != null) {
            if (numRemove.intValue() == 1) {
                this.entityCounts.remove(target);
                this.entitiesAdded.remove(target);
                this.entitiesRemoved.put(target, Boolean.TRUE);
            } else {
                if (numRemove.intValue() > 1) {
                    this.entityCounts.put(target, Integer.valueOf(numRemove.intValue() - 1));
                    return;
                }
                throw new IllegalStateException("Illegal count: " + numRemove);
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean add(TARGET target) {
        M(target);
        return this.entities.add(target);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean addAll(Collection<? extends TARGET> collection) {
        N(collection);
        return this.entities.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized void clear() {
        m();
        List<TARGET> list = this.entities;
        if (list != null) {
            Iterator<TARGET> it2 = list.iterator();
            while (it2.hasNext()) {
                this.entitiesRemoved.put(it2.next(), Boolean.TRUE);
            }
            list.clear();
        }
        Map<TARGET, Boolean> map = this.entitiesAdded;
        if (map != null) {
            map.clear();
        }
        Map<TARGET, Integer> map2 = this.entityCounts;
        if (map2 != null) {
            map2.clear();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        l();
        return this.entities.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        l();
        return this.entities.containsAll(collection);
    }

    public final void d(Cursor<?> cursor, long j10, TARGET[] targetArr, c<TARGET> cVar) {
        int length = targetArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            long id2 = cVar.getId(targetArr[i10]);
            if (id2 == 0) {
                throw new IllegalStateException("Target entity has no ID (should have been put before)");
            }
            jArr[i10] = id2;
        }
        cursor.modifyRelations(this.relationInfo.relationId, j10, jArr, false);
    }

    public void f() {
        if (this.relationInfo.sourceInfo.getIdGetter().getId(this.entity) == 0) {
            throw new IllegalStateException("The source entity was not yet persisted (no ID), use box.put() on it instead");
        }
        try {
            i();
            if (z()) {
                this.f32912a.D2(new Runnable() { // from class: qi.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f47364a.B();
                    }
                });
            }
        } catch (DbDetachedException unused) {
            throw new IllegalStateException("The source entity was not yet persisted, use box.put() on it instead");
        }
    }

    @Override // java.util.List
    public TARGET get(int i10) {
        l();
        return this.entities.get(i10);
    }

    public final void i() {
        if (this.f32914c == null) {
            try {
                BoxStore boxStore = (BoxStore) f.b().a(this.entity.getClass(), "__boxStore").get(this.entity);
                this.f32912a = boxStore;
                if (boxStore == null) {
                    throw new DbDetachedException("Cannot resolve relation for detached entities, call box.attach(entity) beforehand.");
                }
                this.f32913b = boxStore.i(this.relationInfo.sourceInfo.getEntityClass());
                this.f32914c = this.f32912a.i(this.relationInfo.targetInfo.getEntityClass());
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        l();
        return this.entities.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        l();
        return this.entities.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @Nonnull
    public Iterator<TARGET> iterator() {
        l();
        return this.entities.iterator();
    }

    public final void l() {
        if (this.entities == null) {
            long id2 = this.relationInfo.sourceInfo.getIdGetter().getId(this.entity);
            if (id2 == 0) {
                synchronized (this) {
                    if (this.entities == null) {
                        this.entities = r().h0();
                    }
                }
                return;
            }
            i();
            RelationInfo<Object, TARGET> relationInfo = this.relationInfo;
            int i10 = relationInfo.relationId;
            List<TARGET> listB = i10 != 0 ? this.f32914c.B(relationInfo.sourceInfo.getEntityId(), i10, id2, false) : relationInfo.targetIdProperty != null ? this.f32914c.A(this.relationInfo.targetInfo.getEntityId(), this.relationInfo.targetIdProperty, id2) : this.f32914c.B(this.relationInfo.targetInfo.getEntityId(), this.relationInfo.targetRelationId, id2, true);
            Comparator<TARGET> comparator = this.f32916e;
            if (comparator != null) {
                Collections.sort(listB, comparator);
            }
            synchronized (this) {
                if (this.entities == null) {
                    this.entities = listB;
                }
            }
        }
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        l();
        return this.entities.lastIndexOf(obj);
    }

    @Override // java.util.List
    @Nonnull
    public ListIterator<TARGET> listIterator() {
        l();
        return this.entities.listIterator();
    }

    public final void m() {
        l();
        if (this.entitiesAdded == null) {
            synchronized (this) {
                if (this.entitiesAdded == null) {
                    this.entitiesAdded = new LinkedHashMap();
                    this.entitiesRemoved = new LinkedHashMap();
                    this.entityCounts = new HashMap();
                    for (TARGET target : this.entities) {
                        Integer numPut = this.entityCounts.put(target, f32911f);
                        if (numPut != null) {
                            this.entityCounts.put(target, Integer.valueOf(numPut.intValue() + 1));
                        }
                    }
                }
            }
        }
    }

    public int o() {
        Map<TARGET, Boolean> map = this.entitiesAdded;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    @li.a
    public TARGET p(long j10) {
        l();
        Object[] array = this.entities.toArray();
        c<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        for (Object obj : array) {
            TARGET target = (TARGET) obj;
            if (idGetter.getId(target) == j10) {
                return target;
            }
        }
        return null;
    }

    public Object q() {
        return this.entity;
    }

    public ListFactory r() {
        ListFactory copyOnWriteArrayListFactory = this.listFactory;
        if (copyOnWriteArrayListFactory == null) {
            synchronized (this) {
                copyOnWriteArrayListFactory = this.listFactory;
                if (copyOnWriteArrayListFactory == null) {
                    copyOnWriteArrayListFactory = new ListFactory.CopyOnWriteArrayListFactory();
                    this.listFactory = copyOnWriteArrayListFactory;
                }
            }
        }
        return copyOnWriteArrayListFactory;
    }

    @Override // java.util.List
    public synchronized TARGET remove(int i10) {
        TARGET targetRemove;
        m();
        targetRemove = this.entities.remove(i10);
        O(targetRemove);
        return targetRemove;
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean removeAll(Collection<?> collection) {
        boolean zRemove;
        zRemove = false;
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            zRemove |= remove(it2.next());
        }
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean retainAll(Collection<?> collection) {
        boolean z10;
        m();
        z10 = false;
        ArrayList arrayList = null;
        for (TARGET target : this.entities) {
            if (!collection.contains(target)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(target);
                z10 = true;
            }
        }
        if (arrayList != null) {
            removeAll(arrayList);
        }
        return z10;
    }

    @Override // java.util.List
    public synchronized TARGET set(int i10, TARGET target) {
        TARGET target2;
        m();
        target2 = this.entities.set(i10, target);
        O(target2);
        M(target);
        return target2;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        l();
        return this.entities.size();
    }

    @Override // java.util.List
    @Nonnull
    public List<TARGET> subList(int i10, int i11) {
        l();
        return this.entities.subList(i10, i11);
    }

    public int t() {
        Map<TARGET, Boolean> map = this.entitiesRemoved;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    @Nonnull
    public Object[] toArray() {
        l();
        return this.entities.toArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @li.a
    public boolean u(k0<TARGET> k0Var) {
        for (Object obj : toArray()) {
            if (k0Var.a(obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @li.a
    public boolean v(k0<TARGET> k0Var) {
        Object[] array = toArray();
        if (array.length == 0) {
            return false;
        }
        for (Object obj : array) {
            if (!k0Var.a(obj)) {
                return false;
            }
        }
        return true;
    }

    public boolean w() {
        Map<TARGET, Boolean> map = this.entitiesAdded;
        if (map != null && !map.isEmpty()) {
            return true;
        }
        Map<TARGET, Boolean> map2 = this.entitiesRemoved;
        return (map2 == null || map2.isEmpty()) ? false : true;
    }

    @li.a
    public int x(long j10) {
        l();
        Object[] array = this.entities.toArray();
        c<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        int i10 = 0;
        for (Object obj : array) {
            if (idGetter.getId(obj) == j10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @li.c
    public void y(Cursor<?> cursor, Cursor<TARGET> cursor2) {
        Object[] array;
        Object[] array2;
        ArrayList arrayList;
        Object[] objArr;
        Object[] array3;
        RelationInfo<Object, TARGET> relationInfo = this.relationInfo;
        boolean z10 = relationInfo.relationId != 0;
        c<TARGET> idGetter = relationInfo.targetInfo.getIdGetter();
        synchronized (this) {
            array = null;
            if (z10) {
                for (TARGET target : this.entitiesAdded.keySet()) {
                    if (idGetter.getId(target) == 0) {
                        this.entitiesToPut.add(target);
                    }
                }
                if (this.f32915d) {
                    this.entitiesToRemoveFromDb.addAll(this.entitiesRemoved.keySet());
                }
                if (this.entitiesAdded.isEmpty()) {
                    array2 = null;
                } else {
                    array2 = this.entitiesAdded.keySet().toArray();
                    this.entitiesAdded.clear();
                }
                if (this.entitiesRemoved.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(this.entitiesRemoved.keySet());
                    this.entitiesRemoved.clear();
                }
                objArr = array2;
            } else {
                arrayList = null;
                objArr = null;
            }
            array3 = this.entitiesToRemoveFromDb.isEmpty() ? null : this.entitiesToRemoveFromDb.toArray();
            this.entitiesToRemoveFromDb.clear();
            if (!this.entitiesToPut.isEmpty()) {
                array = this.entitiesToPut.toArray();
            }
            this.entitiesToPut.clear();
        }
        if (array3 != null) {
            for (Object obj : array3) {
                long id2 = idGetter.getId(obj);
                if (id2 != 0) {
                    cursor2.deleteEntity(id2);
                }
            }
        }
        if (array != null) {
            for (Object obj2 : array) {
                cursor2.put(obj2);
            }
        }
        if (z10) {
            long id3 = this.relationInfo.sourceInfo.getIdGetter().getId(this.entity);
            if (id3 == 0) {
                throw new IllegalStateException("Source entity has no ID (should have been put before)");
            }
            if (arrayList != null) {
                G(cursor, id3, arrayList, idGetter);
            }
            if (objArr != null) {
                d(cursor, id3, objArr, idGetter);
            }
        }
    }

    @li.c
    public boolean z() {
        if (!w()) {
            return false;
        }
        synchronized (this) {
            if (this.entitiesToPut == null) {
                this.entitiesToPut = new ArrayList();
                this.entitiesToRemoveFromDb = new ArrayList();
            }
        }
        RelationInfo<Object, TARGET> relationInfo = this.relationInfo;
        if (relationInfo.relationId != 0) {
            return true;
        }
        long id2 = relationInfo.sourceInfo.getIdGetter().getId(this.entity);
        if (id2 == 0) {
            throw new IllegalStateException("Source entity has no ID (should have been put before)");
        }
        c<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        Map<TARGET, Boolean> map = this.entitiesAdded;
        Map<TARGET, Boolean> map2 = this.entitiesRemoved;
        return this.relationInfo.targetRelationId != 0 ? C(id2, idGetter, map, map2) : D(id2, idGetter, map, map2);
    }

    @Override // java.util.List
    public synchronized void add(int i10, TARGET target) {
        M(target);
        this.entities.add(i10, target);
    }

    @Override // java.util.List
    public synchronized boolean addAll(int i10, Collection<? extends TARGET> collection) {
        N(collection);
        return this.entities.addAll(i10, collection);
    }

    @Override // java.util.List
    @Nonnull
    public ListIterator<TARGET> listIterator(int i10) {
        l();
        return this.entities.listIterator(i10);
    }

    @Override // java.util.List, java.util.Collection
    @Nonnull
    public <T> T[] toArray(T[] tArr) {
        l();
        return (T[]) this.entities.toArray(tArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public synchronized boolean remove(Object obj) {
        boolean zRemove;
        m();
        zRemove = this.entities.remove(obj);
        if (zRemove) {
            O(obj);
        }
        return zRemove;
    }
}

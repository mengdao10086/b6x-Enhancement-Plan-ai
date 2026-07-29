package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public final class AtomicLongMap<K> implements Serializable {

    @MonotonicNonNullDecl
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>() { // from class: com.google.common.util.concurrent.AtomicLongMap.1
            @Override // com.google.common.base.Function
            public Long apply(AtomicLong atomicLong) {
                return Long.valueOf(atomicLong.get());
            }
        }));
    }

    @CanIgnoreReturnValue
    public long addAndGet(K k10, long j10) {
        AtomicLong atomicLongPutIfAbsent;
        long j11;
        long j12;
        do {
            atomicLongPutIfAbsent = this.map.get(k10);
            if (atomicLongPutIfAbsent == null && (atomicLongPutIfAbsent = this.map.putIfAbsent(k10, new AtomicLong(j10))) == null) {
                return j10;
            }
            do {
                j11 = atomicLongPutIfAbsent.get();
                if (j11 != 0) {
                    j12 = j11 + j10;
                }
            } while (!atomicLongPutIfAbsent.compareAndSet(j11, j12));
            return j12;
        } while (!this.map.replace(k10, atomicLongPutIfAbsent, new AtomicLong(j10)));
        return j10;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Long> mapCreateAsMap = createAsMap();
        this.asMap = mapCreateAsMap;
        return mapCreateAsMap;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public long decrementAndGet(K k10) {
        return addAndGet(k10, -1L);
    }

    public long get(K k10) {
        AtomicLong atomicLong = this.map.get(k10);
        if (atomicLong == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    @CanIgnoreReturnValue
    public long getAndAdd(K k10, long j10) {
        AtomicLong atomicLongPutIfAbsent;
        long j11;
        do {
            atomicLongPutIfAbsent = this.map.get(k10);
            if (atomicLongPutIfAbsent == null && (atomicLongPutIfAbsent = this.map.putIfAbsent(k10, new AtomicLong(j10))) == null) {
                return 0L;
            }
            do {
                j11 = atomicLongPutIfAbsent.get();
                if (j11 == 0) {
                }
            } while (!atomicLongPutIfAbsent.compareAndSet(j11, j11 + j10));
            return j11;
        } while (!this.map.replace(k10, atomicLongPutIfAbsent, new AtomicLong(j10)));
        return 0L;
    }

    @CanIgnoreReturnValue
    public long getAndDecrement(K k10) {
        return getAndAdd(k10, -1L);
    }

    @CanIgnoreReturnValue
    public long getAndIncrement(K k10) {
        return getAndAdd(k10, 1L);
    }

    @CanIgnoreReturnValue
    public long incrementAndGet(K k10) {
        return addAndGet(k10, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @CanIgnoreReturnValue
    public long put(K k10, long j10) {
        AtomicLong atomicLongPutIfAbsent;
        long j11;
        do {
            atomicLongPutIfAbsent = this.map.get(k10);
            if (atomicLongPutIfAbsent == null && (atomicLongPutIfAbsent = this.map.putIfAbsent(k10, new AtomicLong(j10))) == null) {
                return 0L;
            }
            do {
                j11 = atomicLongPutIfAbsent.get();
                if (j11 == 0) {
                }
            } while (!atomicLongPutIfAbsent.compareAndSet(j11, j10));
            return j11;
        } while (!this.map.replace(k10, atomicLongPutIfAbsent, new AtomicLong(j10)));
        return 0L;
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().longValue());
        }
    }

    public long putIfAbsent(K k10, long j10) {
        AtomicLong atomicLongPutIfAbsent;
        do {
            atomicLongPutIfAbsent = this.map.get(k10);
            if (atomicLongPutIfAbsent == null && (atomicLongPutIfAbsent = this.map.putIfAbsent(k10, new AtomicLong(j10))) == null) {
                return 0L;
            }
            long j11 = atomicLongPutIfAbsent.get();
            if (j11 != 0) {
                return j11;
            }
        } while (!this.map.replace(k10, atomicLongPutIfAbsent, new AtomicLong(j10)));
        return 0L;
    }

    @CanIgnoreReturnValue
    public long remove(K k10) {
        long j10;
        AtomicLong atomicLong = this.map.get(k10);
        if (atomicLong == null) {
            return 0L;
        }
        do {
            j10 = atomicLong.get();
            if (j10 == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j10, 0L));
        this.map.remove(k10, atomicLong);
        return j10;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it2 = this.map.entrySet().iterator();
        while (it2.hasNext()) {
            AtomicLong value = it2.next().getValue();
            if (value != null && value.get() == 0) {
                it2.remove();
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public boolean removeIfZero(K k10) {
        return remove(k10, 0L);
    }

    public boolean replace(K k10, long j10, long j11) {
        if (j10 == 0) {
            return putIfAbsent(k10, j11) == 0;
        }
        AtomicLong atomicLong = this.map.get(k10);
        if (atomicLong == null) {
            return false;
        }
        return atomicLong.compareAndSet(j10, j11);
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        Iterator<AtomicLong> it2 = this.map.values().iterator();
        long j10 = 0;
        while (it2.hasNext()) {
            j10 += it2.next().get();
        }
        return j10;
    }

    public String toString() {
        return this.map.toString();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> atomicLongMapCreate = create();
        atomicLongMapCreate.putAll(map);
        return atomicLongMapCreate;
    }

    public boolean remove(K k10, long j10) {
        AtomicLong atomicLong = this.map.get(k10);
        if (atomicLong == null) {
            return false;
        }
        long j11 = atomicLong.get();
        if (j11 != j10) {
            return false;
        }
        if (j11 != 0 && !atomicLong.compareAndSet(j11, 0L)) {
            return false;
        }
        this.map.remove(k10, atomicLong);
        return true;
    }
}

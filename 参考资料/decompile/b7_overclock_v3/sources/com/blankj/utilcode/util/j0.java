package com.blankj.utilcode.util;

import android.util.Pair;
import com.alibaba.android.arouter.routes.ARouter$$Group$$device;
import com.bumptech.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap;
import com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.util.test.FixedSecureRandom;

/* JADX INFO: loaded from: classes2.dex */
public class j0 {

    /* JADX INFO: Add missing generic type declarations: [K1, V1] */
    public static class a<K1, V1> implements b<K1, V1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f11892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f11893b;

        public a(c cVar, Map map) {
            this.f11892a = cVar;
            this.f11893b = map;
        }

        @Override // com.blankj.utilcode.util.j0.b
        public void a(K1 k12, V1 v12) {
            Pair pairA = this.f11892a.a(k12, v12);
            this.f11893b.put(pairA.first, pairA.second);
        }
    }

    public interface b<K, V> {
        void a(K k10, V v10);
    }

    public interface c<K1, V1, K2, V2> {
        Pair<K2, V2> a(K1 k12, V1 v12);
    }

    public j0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <K, V> void a(Map<K, V> map, b<K, V> bVar) {
        if (map == null || bVar == null) {
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            bVar.a(entry.getKey(), entry.getValue());
        }
    }

    public static boolean b(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean c(Map map) {
        return !b(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> d(Pair<K, V>... pairArr) {
        ARouter$$Group$$device.AnonymousClass2 anonymousClass2 = (HashMap<K, V>) new HashMap();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    anonymousClass2.put(pair.first, pair.second);
                }
            }
        }
        return anonymousClass2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> Hashtable<K, V> e(Pair<K, V>... pairArr) {
        FixedSecureRandom.DummyProvider dummyProvider = (Hashtable<K, V>) new Hashtable();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    dummyProvider.put(pair.first, pair.second);
                }
            }
        }
        return dummyProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> LinkedHashMap<K, V> f(Pair<K, V>... pairArr) {
        FullSegmentEncryptionKeyCache.AnonymousClass1 anonymousClass1 = (LinkedHashMap<K, V>) new LinkedHashMap();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    anonymousClass1.put(pair.first, pair.second);
                }
            }
        }
        return anonymousClass1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> TreeMap<K, V> g(Comparator<K> comparator, Pair<K, V>... pairArr) {
        if (comparator == null) {
            throw new IllegalArgumentException("comparator must not be null");
        }
        PrettyPrintTreeMap prettyPrintTreeMap = (TreeMap<K, V>) new TreeMap(comparator);
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    prettyPrintTreeMap.put(pair.first, pair.second);
                }
            }
        }
        return prettyPrintTreeMap;
    }

    @SafeVarargs
    public static <K, V> Map<K, V> h(Pair<K, V>... pairArr) {
        return Collections.unmodifiableMap(d(pairArr));
    }

    public static int i(Map map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static String j(Map map) {
        return map == null ? i0.f11859x : map.toString();
    }

    public static <K1, V1, K2, V2> Map<K2, V2> k(Map<K1, V1> map, c<K1, V1, K2, V2> cVar) {
        if (map != null && cVar != null) {
            try {
                Map<K2, V2> map2 = (Map) map.getClass().newInstance();
                a(map, new a(cVar, map2));
                return map2;
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InstantiationException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }
}

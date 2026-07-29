package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
import androidx.savedstate.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
public final class r0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final String f6236g = "values";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final String f6237h = "keys";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Map<String, Object> f6239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Map<String, b.c> f6240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final Map<String, b<?>> f6241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final Map<String, kotlinx.coroutines.flow.j<Object>> f6242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final b.c f6243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final a f6235f = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final Class<? extends Object>[] f6238i = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final r0 a(@yt.l Bundle bundle, @yt.l Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new r0();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.f0.o(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new r0(map);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(r0.f6237h);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(r0.f6236g);
            if (!((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true)) {
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = parcelableArrayList.get(i10);
                kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
            }
            return new r0(linkedHashMap);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean b(@yt.l Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : r0.f6238i) {
                kotlin.jvm.internal.f0.m(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public r0(@yt.k Map<String, ? extends Object> initialState) {
        kotlin.jvm.internal.f0.p(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f6239a = linkedHashMap;
        this.f6240b = new LinkedHashMap();
        this.f6241c = new LinkedHashMap();
        this.f6242d = new LinkedHashMap();
        this.f6243e = new b.c() { // from class: androidx.lifecycle.q0
            @Override // androidx.savedstate.b.c
            public final Bundle a() {
                return r0.p(this.f6234a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    @hk.m
    @yt.k
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final r0 g(@yt.l Bundle bundle, @yt.l Bundle bundle2) {
        return f6235f.a(bundle, bundle2);
    }

    public static final Bundle p(r0 this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        for (Map.Entry entry : kotlin.collections.s0.D0(this$0.f6240b).entrySet()) {
            this$0.q((String) entry.getKey(), ((b.c) entry.getValue()).a());
        }
        Set<String> setKeySet = this$0.f6239a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f6239a.get(str));
        }
        return androidx.core.os.e.b(kotlin.d1.a(f6237h, arrayList), kotlin.d1.a(f6236g, arrayList2));
    }

    @g.k0
    public final void e(@yt.k String key) {
        kotlin.jvm.internal.f0.p(key, "key");
        this.f6240b.remove(key);
    }

    @g.k0
    public final boolean f(@yt.k String key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return this.f6239a.containsKey(key);
    }

    @g.k0
    @yt.l
    public final <T> T h(@yt.k String key) {
        kotlin.jvm.internal.f0.p(key, "key");
        try {
            return (T) this.f6239a.get(key);
        } catch (ClassCastException unused) {
            n(key);
            return null;
        }
    }

    @g.k0
    @yt.k
    public final <T> j0<T> i(@yt.k String key) {
        kotlin.jvm.internal.f0.p(key, "key");
        j0<T> j0VarK = k(key, false, null);
        kotlin.jvm.internal.f0.n(j0VarK, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return j0VarK;
    }

    @g.k0
    @yt.k
    public final <T> j0<T> j(@yt.k String key, T t10) {
        kotlin.jvm.internal.f0.p(key, "key");
        return k(key, true, t10);
    }

    public final <T> j0<T> k(String str, boolean z10, T t10) {
        b<?> bVar;
        b<?> bVar2 = this.f6241c.get(str);
        b<?> bVar3 = bVar2 instanceof j0 ? bVar2 : null;
        if (bVar3 != null) {
            return bVar3;
        }
        if (this.f6239a.containsKey(str)) {
            bVar = new b<>(this, str, this.f6239a.get(str));
        } else if (z10) {
            this.f6239a.put(str, t10);
            bVar = new b<>(this, str, t10);
        } else {
            bVar = new b<>(this, str);
        }
        this.f6241c.put(str, bVar);
        return bVar;
    }

    @g.k0
    @yt.k
    public final <T> kotlinx.coroutines.flow.u<T> l(@yt.k String key, T t10) {
        kotlin.jvm.internal.f0.p(key, "key");
        Map<String, kotlinx.coroutines.flow.j<Object>> map = this.f6242d;
        kotlinx.coroutines.flow.j<Object> jVarA = map.get(key);
        if (jVarA == null) {
            if (!this.f6239a.containsKey(key)) {
                this.f6239a.put(key, t10);
            }
            jVarA = kotlinx.coroutines.flow.v.a(this.f6239a.get(key));
            this.f6242d.put(key, jVarA);
            map.put(key, jVarA);
        }
        kotlinx.coroutines.flow.u<T> uVarM = kotlinx.coroutines.flow.g.m(jVarA);
        kotlin.jvm.internal.f0.n(uVarM, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return uVarM;
    }

    @g.k0
    @yt.k
    public final Set<String> m() {
        return kotlin.collections.e1.C(kotlin.collections.e1.C(this.f6239a.keySet(), this.f6240b.keySet()), this.f6241c.keySet());
    }

    @g.k0
    @yt.l
    public final <T> T n(@yt.k String key) {
        kotlin.jvm.internal.f0.p(key, "key");
        T t10 = (T) this.f6239a.remove(key);
        b<?> bVarRemove = this.f6241c.remove(key);
        if (bVarRemove != null) {
            bVarRemove.s();
        }
        this.f6242d.remove(key);
        return t10;
    }

    @yt.k
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final b.c o() {
        return this.f6243e;
    }

    @g.k0
    public final <T> void q(@yt.k String key, @yt.l T t10) {
        kotlin.jvm.internal.f0.p(key, "key");
        if (!f6235f.b(t10)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't put value with type ");
            kotlin.jvm.internal.f0.m(t10);
            sb2.append(t10.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        b<?> bVar = this.f6241c.get(key);
        b<?> bVar2 = bVar instanceof j0 ? bVar : null;
        if (bVar2 != null) {
            bVar2.r(t10);
        } else {
            this.f6239a.put(key, t10);
        }
        kotlinx.coroutines.flow.j<Object> jVar = this.f6242d.get(key);
        if (jVar == null) {
            return;
        }
        jVar.setValue(t10);
    }

    @g.k0
    public final void r(@yt.k String key, @yt.k b.c provider) {
        kotlin.jvm.internal.f0.p(key, "key");
        kotlin.jvm.internal.f0.p(provider, "provider");
        this.f6240b.put(key, provider);
    }

    public static final class b<T> extends j0<T> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @yt.k
        public String f6244m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @yt.l
        public r0 f6245n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@yt.l r0 r0Var, @yt.k String key, T t10) {
            super(t10);
            kotlin.jvm.internal.f0.p(key, "key");
            this.f6244m = key;
            this.f6245n = r0Var;
        }

        @Override // androidx.lifecycle.j0, androidx.lifecycle.LiveData
        public void r(T t10) {
            r0 r0Var = this.f6245n;
            if (r0Var != null) {
                r0Var.f6239a.put(this.f6244m, t10);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) r0Var.f6242d.get(this.f6244m);
                if (jVar != null) {
                    jVar.setValue(t10);
                }
            }
            super.r(t10);
        }

        public final void s() {
            this.f6245n = null;
        }

        public b(@yt.l r0 r0Var, @yt.k String key) {
            kotlin.jvm.internal.f0.p(key, "key");
            this.f6244m = key;
            this.f6245n = r0Var;
        }
    }

    public r0() {
        this.f6239a = new LinkedHashMap();
        this.f6240b = new LinkedHashMap();
        this.f6241c = new LinkedHashMap();
        this.f6242d = new LinkedHashMap();
        this.f6243e = new b.c() { // from class: androidx.lifecycle.q0
            @Override // androidx.savedstate.b.c
            public final Bundle a() {
                return r0.p(this.f6234a);
            }
        };
    }
}

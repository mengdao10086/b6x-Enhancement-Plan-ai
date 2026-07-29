package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import g.k0;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityResultRegistry {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f1391i = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f1392j = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f1393k = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f1394l = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f1395m = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f1396n = "ActivityResultRegistry";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f1397o = 65536;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f1398a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, String> f1399b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f1400c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, d> f1401d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<String> f1402e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient Map<String, c<?>> f1403f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f1404g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bundle f1405h = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class a<I> extends g<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f.a f1411b;

        public a(String str, f.a aVar) {
            this.f1410a = str;
            this.f1411b = aVar;
        }

        @Override // androidx.activity.result.g
        @n0
        public f.a<I, ?> a() {
            return this.f1411b;
        }

        @Override // androidx.activity.result.g
        public void c(I i10, @p0 f0.e eVar) throws Exception {
            Integer num = ActivityResultRegistry.this.f1400c.get(this.f1410a);
            if (num != null) {
                ActivityResultRegistry.this.f1402e.add(this.f1410a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f1411b, i10, eVar);
                    return;
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f1402e.remove(this.f1410a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f1411b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.g
        public void d() {
            ActivityResultRegistry.this.l(this.f1410a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class b<I> extends g<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f.a f1414b;

        public b(String str, f.a aVar) {
            this.f1413a = str;
            this.f1414b = aVar;
        }

        @Override // androidx.activity.result.g
        @n0
        public f.a<I, ?> a() {
            return this.f1414b;
        }

        @Override // androidx.activity.result.g
        public void c(I i10, @p0 f0.e eVar) throws Exception {
            Integer num = ActivityResultRegistry.this.f1400c.get(this.f1413a);
            if (num != null) {
                ActivityResultRegistry.this.f1402e.add(this.f1413a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f1414b, i10, eVar);
                    return;
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f1402e.remove(this.f1413a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f1414b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.g
        public void d() {
            ActivityResultRegistry.this.l(this.f1413a);
        }
    }

    public static class c<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.activity.result.a<O> f1416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f.a<?, O> f1417b;

        public c(androidx.activity.result.a<O> aVar, f.a<?, O> aVar2) {
            this.f1416a = aVar;
            this.f1417b = aVar2;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f1418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<v> f1419b = new ArrayList<>();

        public d(@n0 Lifecycle lifecycle) {
            this.f1418a = lifecycle;
        }

        public void a(@n0 v vVar) {
            this.f1418a.a(vVar);
            this.f1419b.add(vVar);
        }

        public void b() {
            Iterator<v> it2 = this.f1419b.iterator();
            while (it2.hasNext()) {
                this.f1418a.d(it2.next());
            }
            this.f1419b.clear();
        }
    }

    public final void a(int i10, String str) {
        this.f1399b.put(Integer.valueOf(i10), str);
        this.f1400c.put(str, Integer.valueOf(i10));
    }

    @k0
    public final boolean b(int i10, int i11, @p0 Intent intent) {
        String str = this.f1399b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, this.f1403f.get(str));
        return true;
    }

    @k0
    public final <O> boolean c(int i10, @SuppressLint({"UnknownNullness"}) O o10) {
        androidx.activity.result.a<?> aVar;
        String str = this.f1399b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f1403f.get(str);
        if (cVar == null || (aVar = cVar.f1416a) == null) {
            this.f1405h.remove(str);
            this.f1404g.put(str, o10);
            return true;
        }
        if (!this.f1402e.remove(str)) {
            return true;
        }
        aVar.a(o10);
        return true;
    }

    public final <O> void d(String str, int i10, @p0 Intent intent, @p0 c<O> cVar) {
        if (cVar == null || cVar.f1416a == null || !this.f1402e.contains(str)) {
            this.f1404g.remove(str);
            this.f1405h.putParcelable(str, new ActivityResult(i10, intent));
        } else {
            cVar.f1416a.a(cVar.f1417b.c(i10, intent));
            this.f1402e.remove(str);
        }
    }

    public final int e() {
        int iNextInt = this.f1398a.nextInt(2147418112);
        while (true) {
            int i10 = iNextInt + 65536;
            if (!this.f1399b.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            iNextInt = this.f1398a.nextInt(2147418112);
        }
    }

    @k0
    public abstract <I, O> void f(int i10, @n0 f.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i11, @p0 f0.e eVar);

    public final void g(@p0 Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f1391i);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(f1392j);
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f1402e = bundle.getStringArrayList(f1393k);
        this.f1398a = (Random) bundle.getSerializable(f1395m);
        this.f1405h.putAll(bundle.getBundle(f1394l));
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            if (this.f1400c.containsKey(str)) {
                Integer numRemove = this.f1400c.remove(str);
                if (!this.f1405h.containsKey(str)) {
                    this.f1399b.remove(numRemove);
                }
            }
            a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
        }
    }

    public final void h(@n0 Bundle bundle) {
        bundle.putIntegerArrayList(f1391i, new ArrayList<>(this.f1400c.values()));
        bundle.putStringArrayList(f1392j, new ArrayList<>(this.f1400c.keySet()));
        bundle.putStringArrayList(f1393k, new ArrayList<>(this.f1402e));
        bundle.putBundle(f1394l, (Bundle) this.f1405h.clone());
        bundle.putSerializable(f1395m, this.f1398a);
    }

    @n0
    public final <I, O> g<I> i(@n0 final String str, @n0 y yVar, @n0 final f.a<I, O> aVar, @n0 final androidx.activity.result.a<O> aVar2) {
        Lifecycle lifecycleE = yVar.e();
        if (lifecycleE.b().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + yVar + " is attempting to register while current state is " + lifecycleE.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        d dVar = this.f1401d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycleE);
        }
        dVar.a(new v() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.v
            public void c(@n0 y yVar2, @n0 Lifecycle.Event event) {
                if (!Lifecycle.Event.ON_START.equals(event)) {
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f1403f.remove(str);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f1403f.put(str, new c<>(aVar2, aVar));
                if (ActivityResultRegistry.this.f1404g.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f1404g.get(str);
                    ActivityResultRegistry.this.f1404g.remove(str);
                    aVar2.a(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f1405h.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.f1405h.remove(str);
                    aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
                }
            }
        });
        this.f1401d.put(str, dVar);
        return new a(str, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @n0
    public final <I, O> g<I> j(@n0 String str, @n0 f.a<I, O> aVar, @n0 androidx.activity.result.a<O> aVar2) {
        k(str);
        this.f1403f.put(str, new c<>(aVar2, aVar));
        if (this.f1404g.containsKey(str)) {
            Object obj = this.f1404g.get(str);
            this.f1404g.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f1405h.getParcelable(str);
        if (activityResult != null) {
            this.f1405h.remove(str);
            aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
        }
        return new b(str, aVar);
    }

    public final void k(String str) {
        if (this.f1400c.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    @k0
    public final void l(@n0 String str) {
        Integer numRemove;
        if (!this.f1402e.contains(str) && (numRemove = this.f1400c.remove(str)) != null) {
            this.f1399b.remove(numRemove);
        }
        this.f1403f.remove(str);
        if (this.f1404g.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(this.f1404g.get(str));
            this.f1404g.remove(str);
        }
        if (this.f1405h.containsKey(str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Dropping pending result for request ");
            sb3.append(str);
            sb3.append(": ");
            sb3.append(this.f1405h.getParcelable(str));
            this.f1405h.remove(str);
        }
        d dVar = this.f1401d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f1401d.remove(str);
        }
    }
}

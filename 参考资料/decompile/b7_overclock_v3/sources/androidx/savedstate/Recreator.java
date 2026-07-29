package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import androidx.savedstate.b;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class Recreator implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final a f7625b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final String f7626c = "classes_to_restore";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final String f7627d = "androidx.savedstate.Restarter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final d f7628a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static final class b implements b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final Set<String> f7629a;

        public b(@k androidx.savedstate.b registry) {
            f0.p(registry, "registry");
            this.f7629a = new LinkedHashSet();
            registry.j(Recreator.f7627d, this);
        }

        @Override // androidx.savedstate.b.c
        @k
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(Recreator.f7626c, new ArrayList<>(this.f7629a));
            return bundle;
        }

        public final void b(@k String className) {
            f0.p(className, "className");
            this.f7629a.add(className);
        }
    }

    public Recreator(@k d owner) {
        f0.p(owner, "owner");
        this.f7628a = owner;
    }

    @Override // androidx.lifecycle.v
    public void c(@k y source, @k Lifecycle.Event event) {
        f0.p(source, "source");
        f0.p(event, "event");
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.e().d(this);
        Bundle bundleB = this.f7628a.l1().b(f7627d);
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList(f7626c);
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it2 = stringArrayList.iterator();
        while (it2.hasNext()) {
            h(it2.next());
        }
    }

    public final void h(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(b.a.class);
            f0.o(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                    f0.o(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((b.a) objNewInstance).a(this.f7628a);
                } catch (Exception e10) {
                    throw new RuntimeException("Failed to instantiate " + str, e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("Class " + str + " wasn't found", e12);
        }
    }
}

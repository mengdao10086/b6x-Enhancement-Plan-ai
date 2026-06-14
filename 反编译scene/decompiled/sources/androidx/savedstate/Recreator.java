package androidx.savedstate;

import a.hn;
import a.in;
import a.kn;
import a.pq;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"RestrictedApi"})
public final class Recreator implements in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pq f8249a;

    public Recreator(pq pqVar) {
        this.f8249a = pqVar;
    }

    @Override // a.in
    public void a(kn knVar, hn.a aVar) {
        if (aVar != hn.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        knVar.getLifecycle().c(this);
        Bundle bundleA = this.f8249a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
    }

    public final void h(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class);
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.a) declaredConstructor.newInstance(new Object[0])).a(this.f8249a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class" + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }
}

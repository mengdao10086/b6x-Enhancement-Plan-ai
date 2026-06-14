package a;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class es {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static as f6035a = new sq();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ThreadLocal<WeakReference<ba<ViewGroup, ArrayList<as>>>> f786a = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ArrayList<ViewGroup> f787a = new ArrayList<>();

    public static void a(ViewGroup viewGroup, as asVar) {
        if (f787a.contains(viewGroup) || !eh.Q(viewGroup)) {
            return;
        }
        f787a.add(viewGroup);
        if (asVar == null) {
            asVar = f6035a;
        }
        as asVarClone = asVar.clone();
        d(viewGroup, asVarClone);
        tr.c(viewGroup, null);
        c(viewGroup, asVarClone);
    }

    public static ba<ViewGroup, ArrayList<as>> b() {
        ba<ViewGroup, ArrayList<as>> baVar;
        WeakReference<ba<ViewGroup, ArrayList<as>>> weakReference = f786a.get();
        if (weakReference != null && (baVar = weakReference.get()) != null) {
            return baVar;
        }
        ba<ViewGroup, ArrayList<as>> baVar2 = new ba<>();
        f786a.set(new WeakReference<>(baVar2));
        return baVar2;
    }

    public static void c(ViewGroup viewGroup, as asVar) {
        if (asVar == null || viewGroup == null) {
            return;
        }
        ds dsVar = new ds(asVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(dsVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(dsVar);
    }

    public static void d(ViewGroup viewGroup, as asVar) {
        ArrayList<as> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<as> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().N(viewGroup);
            }
        }
        if (asVar != null) {
            asVar.k(viewGroup, true);
        }
        tr trVarB = tr.b(viewGroup);
        if (trVarB != null) {
            trVarB.a();
        }
    }
}

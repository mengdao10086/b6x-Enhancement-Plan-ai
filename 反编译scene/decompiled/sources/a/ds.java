package a;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ds implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public as f5932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f598a;

    public ds(as asVar, ViewGroup viewGroup) {
        this.f5932a = asVar;
        this.f598a = viewGroup;
    }

    public final void a() {
        this.f598a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f598a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        if (!es.f787a.remove(this.f598a)) {
            return true;
        }
        ba<ViewGroup, ArrayList<as>> baVarB = es.b();
        ArrayList<as> arrayList = baVarB.get(this.f598a);
        ArrayList arrayList2 = null;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            baVarB.put(this.f598a, arrayList);
        } else if (arrayList.size() > 0) {
            arrayList2 = new ArrayList(arrayList);
        }
        arrayList.add(this.f5932a);
        this.f5932a.a(new cs(this, baVarB));
        this.f5932a.k(this.f598a, false);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((as) it.next()).R(this.f598a);
            }
        }
        this.f5932a.O(this.f598a);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
        es.f787a.remove(this.f598a);
        ArrayList<as> arrayList = es.b().get(this.f598a);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<as> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().R(this.f598a);
            }
        }
        this.f5932a.l(true);
    }
}

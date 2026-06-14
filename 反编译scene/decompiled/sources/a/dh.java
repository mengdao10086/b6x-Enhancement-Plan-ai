package a;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<WeakReference<View>> f5899a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakHashMap<View, Boolean> f559a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray<WeakReference<View>> f557a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<KeyEvent> f558a = null;

    public static dh a(View view) {
        dh dhVar = (dh) view.getTag(ra.tag_unhandled_key_event_manager);
        if (dhVar != null) {
            return dhVar;
        }
        dh dhVar2 = new dh();
        view.setTag(ra.tag_unhandled_key_event_manager, dhVar2);
        return dhVar2;
    }

    public boolean b(View view, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            g();
        }
        View viewC = c(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                d().put(keyCode, new WeakReference<>(viewC));
            }
        }
        return viewC != null;
    }

    public final View c(View view, KeyEvent keyEvent) {
        WeakHashMap<View, Boolean> weakHashMap = this.f559a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                    if (viewC != null) {
                        return viewC;
                    }
                }
            }
            if (e(view, keyEvent)) {
                return view;
            }
        }
        return null;
    }

    public final SparseArray<WeakReference<View>> d() {
        if (this.f557a == null) {
            this.f557a = new SparseArray<>();
        }
        return this.f557a;
    }

    public final boolean e(View view, KeyEvent keyEvent) {
        ArrayList arrayList = (ArrayList) view.getTag(ra.tag_unhandled_key_listeners);
        if (arrayList == null) {
            return false;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((ch) arrayList.get(size)).a(view, keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(KeyEvent keyEvent) {
        int iIndexOfKey;
        WeakReference<KeyEvent> weakReference = this.f558a;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        this.f558a = new WeakReference<>(keyEvent);
        WeakReference<View> weakReferenceValueAt = null;
        SparseArray<WeakReference<View>> sparseArrayD = d();
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReferenceValueAt = sparseArrayD.valueAt(iIndexOfKey);
            sparseArrayD.removeAt(iIndexOfKey);
        }
        if (weakReferenceValueAt == null) {
            weakReferenceValueAt = sparseArrayD.get(keyEvent.getKeyCode());
        }
        if (weakReferenceValueAt == null) {
            return false;
        }
        View view = weakReferenceValueAt.get();
        if (view != null && eh.P(view)) {
            e(view, keyEvent);
        }
        return true;
    }

    public final void g() {
        WeakHashMap<View, Boolean> weakHashMap = this.f559a;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
        if (f5899a.isEmpty()) {
            return;
        }
        synchronized (f5899a) {
            if (this.f559a == null) {
                this.f559a = new WeakHashMap<>();
            }
            for (int size = f5899a.size() - 1; size >= 0; size--) {
                View view = f5899a.get(size).get();
                if (view == null) {
                    f5899a.remove(size);
                } else {
                    this.f559a.put(view, Boolean.TRUE);
                    for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                        this.f559a.put((View) parent, Boolean.TRUE);
                    }
                }
            }
        }
    }
}

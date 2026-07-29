package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import g.n0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class k extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public ViewGroup f7896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7897b;

    public k(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f7896a = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        g2.v.b(this.f7896a).c(this);
        this.f7897b = true;
    }

    public static k b(@n0 ViewGroup viewGroup) {
        return (k) viewGroup.getTag(R.id.ghost_view_holder);
    }

    public static void d(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    public static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(g2.v.a(viewGroup, i10));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    public static boolean f(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        for (int i10 = 1; i10 < iMin; i10++) {
            View view = arrayList.get(i10);
            View view2 = arrayList2.get(i10);
            if (view != view2) {
                return e(view, view2);
            }
        }
        return arrayList2.size() == iMin;
    }

    public void a(l lVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        d(lVar.f7900c, arrayList);
        int iC = c(arrayList);
        if (iC < 0 || iC >= getChildCount()) {
            addView(lVar);
        } else {
            addView(lVar, iC);
        }
    }

    public final int c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i10 = 0;
        while (i10 <= childCount) {
            int i11 = (i10 + childCount) / 2;
            d(((l) getChildAt(i11)).f7900c, arrayList2);
            if (f(arrayList, arrayList2)) {
                i10 = i11 + 1;
            } else {
                childCount = i11 - 1;
            }
            arrayList2.clear();
        }
        return i10;
    }

    public void g() {
        if (!this.f7897b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        g2.v.b(this.f7896a).d(this);
        g2.v.b(this.f7896a).c(this);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.f7897b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f7896a.setTag(R.id.ghost_view_holder, null);
            g2.v.b(this.f7896a).d(this);
            this.f7897b = false;
        }
    }
}

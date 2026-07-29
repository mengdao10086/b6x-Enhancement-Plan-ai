package com.google.android.material.button;

import a1.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.r;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import g.d0;
import g.h;
import g.i1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f19839k = MaterialButtonToggleGroup.class.getSimpleName();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f19840l = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f19841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f19842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<d> f19843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Comparator<MaterialButton> f19844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer[] f19845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @d0
    public final int f19849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Set<Integer> f19850j;

    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    public class b extends androidx.core.view.a {
        public b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            dVar.e1(d.e.h(0, 1, MaterialButtonToggleGroup.this.k(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final le.d f19853e = new le.a(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public le.d f19854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public le.d f19855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public le.d f19856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public le.d f19857d;

        public c(le.d dVar, le.d dVar2, le.d dVar3, le.d dVar4) {
            this.f19854a = dVar;
            this.f19855b = dVar3;
            this.f19856c = dVar4;
            this.f19857d = dVar2;
        }

        public static c a(c cVar) {
            le.d dVar = f19853e;
            return new c(dVar, cVar.f19857d, dVar, cVar.f19856c);
        }

        public static c b(c cVar, View view) {
            return b0.l(view) ? c(cVar) : d(cVar);
        }

        public static c c(c cVar) {
            le.d dVar = cVar.f19854a;
            le.d dVar2 = cVar.f19857d;
            le.d dVar3 = f19853e;
            return new c(dVar, dVar2, dVar3, dVar3);
        }

        public static c d(c cVar) {
            le.d dVar = f19853e;
            return new c(dVar, dVar, cVar.f19855b, cVar.f19856c);
        }

        public static c e(c cVar, View view) {
            return b0.l(view) ? d(cVar) : c(cVar);
        }

        public static c f(c cVar) {
            le.d dVar = cVar.f19854a;
            le.d dVar2 = f19853e;
            return new c(dVar, dVar2, cVar.f19855b, dVar2);
        }
    }

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @d0 int i10, boolean z10);
    }

    public class e implements MaterialButton.c {
        public e() {
        }

        @Override // com.google.android.material.button.MaterialButton.c
        public void a(@n0 MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@n0 Context context) {
        this(context, null);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (m(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (m(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && m(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private void setGeneratedIdIfNeeded(@n0 MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(u0.D());
        }
    }

    private void setupButtonChild(@n0 MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f19842b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public static void u(o.b bVar, @p0 c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.L(cVar.f19854a).y(cVar.f19857d).Q(cVar.f19855b).D(cVar.f19856c);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i10, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            f(materialButton.getId(), materialButton.isChecked());
            o shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.f19841a.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
            u0.B1(materialButton, new b());
        }
    }

    public void b(@n0 d dVar) {
        this.f19843c.add(dVar);
    }

    public final void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
            MaterialButton materialButtonJ = j(i10);
            int iMin = Math.min(materialButtonJ.getStrokeWidth(), j(i10 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsD = d(materialButtonJ);
            if (getOrientation() == 0) {
                r.g(layoutParamsD, 0);
                r.h(layoutParamsD, -iMin);
                layoutParamsD.topMargin = 0;
            } else {
                layoutParamsD.bottomMargin = 0;
                layoutParamsD.topMargin = -iMin;
                r.h(layoutParamsD, 0);
            }
            materialButtonJ.setLayoutParams(layoutParamsD);
        }
        r(firstVisibleChildIndex);
    }

    @n0
    public final LinearLayout.LayoutParams d(@n0 View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@n0 Canvas canvas) {
        w();
        super.dispatchDraw(canvas);
    }

    public void e(@d0 int i10) {
        f(i10, true);
    }

    public final void f(@d0 int i10, boolean z10) {
        if (i10 == -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Button ID is not valid: ");
            sb2.append(i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f19850j);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f19847g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else {
            if (z10 || !hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            if (!this.f19848h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        }
        v(hashSet);
    }

    public void g() {
        v(new HashSet());
    }

    @d0
    public int getCheckedButtonId() {
        if (!this.f19847g || this.f19850j.isEmpty()) {
            return -1;
        }
        return this.f19850j.iterator().next().intValue();
    }

    @n0
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = j(i10).getId();
            if (this.f19850j.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f19845e;
        return (numArr == null || i11 >= numArr.length) ? i11 : numArr[i11].intValue();
    }

    public void h() {
        this.f19843c.clear();
    }

    public final void i(@d0 int i10, boolean z10) {
        Iterator<d> it2 = this.f19843c.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, i10, z10);
        }
    }

    public final MaterialButton j(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    public final int k(@p0 View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && m(i11)) {
                i10++;
            }
        }
        return -1;
    }

    @p0
    public final c l(int i10, int i11, int i12) {
        c cVar = this.f19841a.get(i10);
        if (i11 == i12) {
            return cVar;
        }
        boolean z10 = getOrientation() == 0;
        if (i10 == i11) {
            return z10 ? c.e(cVar, this) : c.f(cVar);
        }
        if (i10 == i12) {
            return z10 ? c.b(cVar, this) : c.a(cVar);
        }
        return null;
    }

    public final boolean m(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    public boolean n() {
        return this.f19848h;
    }

    public boolean o() {
        return this.f19847g;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f19849i;
        if (i10 != -1) {
            v(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        a1.d.g2(accessibilityNodeInfo).d1(d.C0006d.f(1, getVisibleButtonCount(), false, o() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        x();
        c();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f19841a.remove(iIndexOfChild);
        }
        x();
        c();
    }

    public void p(@n0 MaterialButton materialButton, boolean z10) {
        if (this.f19846f) {
            return;
        }
        f(materialButton.getId(), z10);
    }

    public void q(@n0 d dVar) {
        this.f19843c.remove(dVar);
    }

    public final void r(int i10) {
        if (getChildCount() == 0 || i10 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) j(i10).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            r.g(layoutParams, 0);
            r.h(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    public final void s(@d0 int i10, boolean z10) {
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById instanceof MaterialButton) {
            this.f19846f = true;
            ((MaterialButton) viewFindViewById).setChecked(z10);
            this.f19846f = false;
        }
    }

    public void setSelectionRequired(boolean z10) {
        this.f19848h = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f19847g != z10) {
            this.f19847g = z10;
            g();
        }
    }

    public void t(@d0 int i10) {
        f(i10, false);
    }

    public final void v(Set<Integer> set) {
        Set<Integer> set2 = this.f19850j;
        this.f19850j = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = j(i10).getId();
            s(id2, set.contains(Integer.valueOf(id2)));
            if (set2.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                i(id2, set.contains(Integer.valueOf(id2)));
            }
        }
        invalidate();
    }

    public final void w() {
        TreeMap treeMap = new TreeMap(this.f19844d);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(j(i10), Integer.valueOf(i10));
        }
        this.f19845e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    @i1
    public void x() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i10 = 0; i10 < childCount; i10++) {
            MaterialButton materialButtonJ = j(i10);
            if (materialButtonJ.getVisibility() != 8) {
                o.b bVarV = materialButtonJ.getShapeAppearanceModel().v();
                u(bVarV, l(i10, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonJ.setShapeAppearanceModel(bVarV.m());
            }
        }
    }

    public MaterialButtonToggleGroup(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f19840l;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f19841a = new ArrayList();
        this.f19842b = new e(this, null);
        this.f19843c = new LinkedHashSet<>();
        this.f19844d = new a();
        this.f19846f = false;
        this.f19850j = new HashSet();
        TypedArray typedArrayK = t.k(getContext(), attributeSet, R.styleable.MaterialButtonToggleGroup, i10, i11, new int[0]);
        setSingleSelection(typedArrayK.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f19849i = typedArrayK.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f19848h = typedArrayK.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayK.recycle();
        u0.R1(this, 1);
    }

    public void setSingleSelection(@h int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}

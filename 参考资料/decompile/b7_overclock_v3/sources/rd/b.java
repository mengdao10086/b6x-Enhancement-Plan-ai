package rd;

import a1.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.a;
import com.google.android.material.internal.g;
import com.google.android.material.internal.t;
import g.d0;
import g.h;
import g.n0;
import g.p0;
import g.q;
import g.r;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class b extends g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f48546k = R.style.Widget_MaterialComponents_ChipGroup;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @r
    public int f48547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @r
    public int f48548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public e f48549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.material.internal.a<Chip> f48550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f48551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final f f48552j;

    public class a implements a.b {
        public a() {
        }

        @Override // com.google.android.material.internal.a.b
        public void a(Set<Integer> set) {
            if (b.this.f48549g != null) {
                e eVar = b.this.f48549g;
                b bVar = b.this;
                eVar.a(bVar, bVar.f48550h.j(b.this));
            }
        }
    }

    /* JADX INFO: renamed from: rd.b$b, reason: collision with other inner class name */
    public class C0555b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f48554a;

        public C0555b(d dVar) {
            this.f48554a = dVar;
        }

        @Override // rd.b.e
        public void a(@n0 b bVar, @n0 List<Integer> list) {
            if (b.this.f48550h.m()) {
                this.f48554a.a(bVar, b.this.getCheckedChipId());
            }
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {
        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Deprecated
    public interface d {
        void a(@n0 b bVar, @d0 int i10);
    }

    public interface e {
        void a(@n0 b bVar, @n0 List<Integer> list);
    }

    public class f implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f48556a;

        public f() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == b.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(u0.D());
                }
                b.this.f48550h.e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f48556a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            b bVar = b.this;
            if (view == bVar && (view2 instanceof Chip)) {
                bVar.f48550h.o((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f48556a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this();
        }
    }

    public b(Context context) {
        this(context, null);
    }

    private int getVisibleChipCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof Chip) && j(i11)) {
                i10++;
            }
        }
        return i10;
    }

    @Override // com.google.android.material.internal.g
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    public void g(@d0 int i10) {
        this.f48550h.f(i10);
    }

    @Override // android.view.ViewGroup
    @n0
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    @n0
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @d0
    public int getCheckedChipId() {
        return this.f48550h.k();
    }

    @n0
    public List<Integer> getCheckedChipIds() {
        return this.f48550h.j(this);
    }

    @r
    public int getChipSpacingHorizontal() {
        return this.f48547e;
    }

    @r
    public int getChipSpacingVertical() {
        return this.f48548f;
    }

    public void h() {
        this.f48550h.h();
    }

    public int i(@p0 View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt instanceof Chip) && j(i11)) {
                if (((Chip) childAt) == view) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public final boolean j(int i10) {
        return getChildAt(i10).getVisibility() == 0;
    }

    public boolean k() {
        return this.f48550h.l();
    }

    public boolean l() {
        return this.f48550h.m();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f48551i;
        if (i10 != -1) {
            this.f48550h.f(i10);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        a1.d.g2(accessibilityNodeInfo).d1(d.C0006d.f(getRowCount(), c() ? getVisibleChipCount() : -1, false, l() ? 1 : 2));
    }

    public void setChipSpacing(@r int i10) {
        setChipSpacingHorizontal(i10);
        setChipSpacingVertical(i10);
    }

    public void setChipSpacingHorizontal(@r int i10) {
        if (this.f48547e != i10) {
            this.f48547e = i10;
            setItemSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@q int i10) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingResource(@q int i10) {
        setChipSpacing(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingVertical(@r int i10) {
        if (this.f48548f != i10) {
            this.f48548f = i10;
            setLineSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@q int i10) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i10));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@p0 Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i10) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@p0 d dVar) {
        if (dVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new C0555b(dVar));
        }
    }

    public void setOnCheckedStateChangeListener(@p0 e eVar) {
        this.f48549g = eVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f48552j.f48556a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z10) {
        this.f48550h.q(z10);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.g
    public void setSingleLine(boolean z10) {
        super.setSingleLine(z10);
    }

    public void setSingleSelection(boolean z10) {
        this.f48550h.r(z10);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    @n0
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public void setSingleLine(@h int i10) {
        setSingleLine(getResources().getBoolean(i10));
    }

    public void setSingleSelection(@h int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f48546k;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        com.google.android.material.internal.a<Chip> aVar = new com.google.android.material.internal.a<>();
        this.f48550h = aVar;
        f fVar = new f(this, null);
        this.f48552j = fVar;
        TypedArray typedArrayK = t.k(getContext(), attributeSet, R.styleable.ChipGroup, i10, i11, new int[0]);
        int dimensionPixelOffset = typedArrayK.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayK.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayK.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayK.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayK.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayK.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
        this.f48551i = typedArrayK.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        typedArrayK.recycle();
        aVar.p(new a());
        super.setOnHierarchyChangeListener(fVar);
        u0.R1(this, 1);
    }
}

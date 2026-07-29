package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.d;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f4169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f4171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y.a f4172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View[] f4176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap<Integer, String> f4177i;

    public a(Context context) {
        super(context);
        this.f4169a = new int[32];
        this.f4173e = false;
        this.f4176h = null;
        this.f4177i = new HashMap<>();
        this.f4171c = context;
        y(null);
    }

    public int A(View view) {
        int i10;
        int id2 = view.getId();
        int i11 = -1;
        if (id2 == -1) {
            return -1;
        }
        this.f4174f = null;
        int i12 = 0;
        while (true) {
            if (i12 >= this.f4170b) {
                break;
            }
            if (this.f4169a[i12] == id2) {
                int i13 = i12;
                while (true) {
                    i10 = this.f4170b;
                    if (i13 >= i10 - 1) {
                        break;
                    }
                    int[] iArr = this.f4169a;
                    int i14 = i13 + 1;
                    iArr[i13] = iArr[i14];
                    i13 = i14;
                }
                this.f4169a[i10 - 1] = 0;
                this.f4170b = i10 - 1;
                i11 = i12;
            } else {
                i12++;
            }
        }
        requestLayout();
        return i11;
    }

    public void B(ConstraintWidget widget, boolean isRtl) {
    }

    public void C(ConstraintLayout container) {
    }

    public void D(ConstraintLayout container) {
    }

    public void E(ConstraintLayout container) {
    }

    public void F(ConstraintLayout container) {
    }

    public void G(androidx.constraintlayout.core.widgets.d container, y.a helper, SparseArray<ConstraintWidget> map) {
        helper.a();
        for (int i10 = 0; i10 < this.f4170b; i10++) {
            helper.b(map.get(this.f4169a[i10]));
        }
    }

    public void H(ConstraintLayout container) {
        String str;
        int iU;
        if (isInEditMode()) {
            setIds(this.f4174f);
        }
        y.a aVar = this.f4172d;
        if (aVar == null) {
            return;
        }
        aVar.a();
        for (int i10 = 0; i10 < this.f4170b; i10++) {
            int i11 = this.f4169a[i10];
            View viewS = container.s(i11);
            if (viewS == null && (iU = u(container, (str = this.f4177i.get(Integer.valueOf(i11))))) != 0) {
                this.f4169a[i10] = iU;
                this.f4177i.put(Integer.valueOf(iU), str);
                viewS = container.s(iU);
            }
            if (viewS != null) {
                this.f4172d.b(container.t(viewS));
            }
        }
        this.f4172d.c(container.f4046c);
    }

    public void I() {
        if (this.f4172d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f4116v0 = (ConstraintWidget) this.f4172d;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f4169a, this.f4170b);
    }

    public final void l(String idString) {
        if (idString == null || idString.length() == 0 || this.f4171c == null) {
            return;
        }
        String strTrim = idString.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iV = v(strTrim);
        if (iV != 0) {
            this.f4177i.put(Integer.valueOf(iV), strTrim);
            m(iV);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find id of \"");
            sb2.append(strTrim);
            sb2.append("\"");
        }
    }

    public final void m(int id2) {
        if (id2 == getId()) {
            return;
        }
        int i10 = this.f4170b + 1;
        int[] iArr = this.f4169a;
        if (i10 > iArr.length) {
            this.f4169a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f4169a;
        int i11 = this.f4170b;
        iArr2[i11] = id2;
        this.f4170b = i11 + 1;
    }

    public final void n(String tagString) {
        if (tagString == null || tagString.length() == 0 || this.f4171c == null) {
            return;
        }
        String strTrim = tagString.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && strTrim.equals(((ConstraintLayout.b) layoutParams).f4078c0)) {
                if (childAt.getId() == -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("to use ConstraintTag view ");
                    sb2.append(childAt.getClass().getSimpleName());
                    sb2.append(" must have an ID");
                } else {
                    m(childAt.getId());
                }
            }
        }
    }

    public void o(View view) {
        if (view == this || view.getId() == -1 || view.getParent() == null) {
            return;
        }
        this.f4174f = null;
        m(view.getId());
        requestLayout();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f4174f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f4175g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f4173e) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        q((ConstraintLayout) parent);
    }

    public void q(ConstraintLayout container) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i10 = 0; i10 < this.f4170b; i10++) {
            View viewS = container.s(this.f4169a[i10]);
            if (viewS != null) {
                viewS.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewS.setTranslationZ(viewS.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void r(ConstraintLayout container) {
    }

    public boolean s(final int id2) {
        for (int i10 : this.f4169a) {
            if (i10 == id2) {
                return true;
            }
        }
        return false;
    }

    public void setIds(String idList) {
        this.f4174f = idList;
        if (idList == null) {
            return;
        }
        int i10 = 0;
        this.f4170b = 0;
        while (true) {
            int iIndexOf = idList.indexOf(44, i10);
            if (iIndexOf == -1) {
                l(idList.substring(i10));
                return;
            } else {
                l(idList.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String tagList) {
        this.f4175g = tagList;
        if (tagList == null) {
            return;
        }
        int i10 = 0;
        this.f4170b = 0;
        while (true) {
            int iIndexOf = tagList.indexOf(44, i10);
            if (iIndexOf == -1) {
                n(tagList.substring(i10));
                return;
            } else {
                n(tagList.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] ids) {
        this.f4174f = null;
        this.f4170b = 0;
        for (int i10 : ids) {
            m(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int key, Object tag) {
        super.setTag(key, tag);
        if (tag == null && this.f4174f == null) {
            m(key);
        }
    }

    public final int[] t(View view, String referenceIdString) {
        String[] strArrSplit = referenceIdString.split(ag.c.f654g);
        view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        for (String str : strArrSplit) {
            int iV = v(str.trim());
            if (iV != 0) {
                iArr[i10] = iV;
                i10++;
            }
        }
        return i10 != strArrSplit.length ? Arrays.copyOf(iArr, i10) : iArr;
    }

    public final int u(ConstraintLayout container, String idString) {
        Resources resources;
        if (idString == null || container == null || (resources = this.f4171c.getResources()) == null) {
            return 0;
        }
        int childCount = container.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = container.getChildAt(i10);
            if (childAt.getId() != -1) {
                String resourceEntryName = null;
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (idString.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int v(String referenceId) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iU = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objQ = constraintLayout.q(0, referenceId);
            if (objQ instanceof Integer) {
                iU = ((Integer) objQ).intValue();
            }
        }
        if (iU == 0 && constraintLayout != null) {
            iU = u(constraintLayout, referenceId);
        }
        if (iU == 0) {
            try {
                iU = R.id.class.getField(referenceId).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iU == 0 ? this.f4171c.getResources().getIdentifier(referenceId, "id", this.f4171c.getPackageName()) : iU;
    }

    public View[] w(ConstraintLayout layout) {
        View[] viewArr = this.f4176h;
        if (viewArr == null || viewArr.length != this.f4170b) {
            this.f4176h = new View[this.f4170b];
        }
        for (int i10 = 0; i10 < this.f4170b; i10++) {
            this.f4176h[i10] = layout.s(this.f4169a[i10]);
        }
        return this.f4176h;
    }

    public int x(final int id2) {
        int i10 = -1;
        for (int i11 : this.f4169a) {
            i10++;
            if (i11 == id2) {
                return i10;
            }
        }
        return i10;
    }

    public void y(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f4174f = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f4175g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void z(d.a constraint, y.b child, ConstraintLayout.b layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        d.b bVar = constraint.f4295e;
        int[] iArr = bVar.f4371k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar.f4373l0;
            if (str != null) {
                if (str.length() > 0) {
                    d.b bVar2 = constraint.f4295e;
                    bVar2.f4371k0 = t(this, bVar2.f4373l0);
                } else {
                    constraint.f4295e.f4371k0 = null;
                }
            }
        }
        if (child == null) {
            return;
        }
        child.a();
        if (constraint.f4295e.f4371k0 == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            int[] iArr2 = constraint.f4295e.f4371k0;
            if (i10 >= iArr2.length) {
                return;
            }
            ConstraintWidget constraintWidget = mapIdToWidget.get(iArr2[i10]);
            if (constraintWidget != null) {
                child.b(constraintWidget);
            }
            i10++;
        }
    }

    public a(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4169a = new int[32];
        this.f4173e = false;
        this.f4176h = null;
        this.f4177i = new HashMap<>();
        this.f4171c = context;
        y(attrs);
    }

    public a(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4169a = new int[32];
        this.f4173e = false;
        this.f4176h = null;
        this.f4177i = new HashMap<>();
        this.f4171c = context;
        y(attrs);
    }
}

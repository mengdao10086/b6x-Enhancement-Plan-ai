package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<View> f2319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f2320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f2321e;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f2317a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f2320d;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f2317a, viewGroup, false);
        int i10 = this.f2318b;
        if (i10 != -1) {
            viewInflate.setId(i10);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f2319c = new WeakReference<>(viewInflate);
        a aVar = this.f2321e;
        if (aVar != null) {
            aVar.a(this, viewInflate);
        }
        return viewInflate;
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f2318b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2320d;
    }

    public int getLayoutResource() {
        return this.f2317a;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i10) {
        this.f2318b = i10;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2320d = layoutInflater;
    }

    public void setLayoutResource(int i10) {
        this.f2317a = i10;
    }

    public void setOnInflateListener(a aVar) {
        this.f2321e = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        WeakReference<View> weakReference = this.f2319c;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i10);
            return;
        }
        super.setVisibility(i10);
        if (i10 == 0 || i10 == 4) {
            a();
        }
    }

    public ViewStubCompat(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2317a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, i10, 0);
        this.f2318b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f2317a = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}

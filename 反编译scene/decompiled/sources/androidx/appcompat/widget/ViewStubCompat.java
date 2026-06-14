package androidx.appcompat.widget;

import a.c0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8180a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayoutInflater f4135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f4136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<View> f4137a;
    public int b;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8180a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.ViewStubCompat, i, 0);
        this.b = typedArrayObtainStyledAttributes.getResourceId(c0.ViewStubCompat_android_inflatedId, -1);
        this.f8180a = typedArrayObtainStyledAttributes.getResourceId(c0.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(c0.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f8180a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f4135a;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f8180a, viewGroup, false);
        int i = this.b;
        if (i != -1) {
            viewInflate.setId(i);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f4137a = new WeakReference<>(viewInflate);
        a aVar = this.f4136a;
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
        return this.b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f4135a;
    }

    public int getLayoutResource() {
        return this.f8180a;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f4135a = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f8180a = i;
    }

    public void setOnInflateListener(a aVar) {
        this.f4136a = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f4137a;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            a();
        }
    }
}

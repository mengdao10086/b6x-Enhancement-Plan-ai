package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class o implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6019b = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f6020a;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f6021a;

        public a(d0 d0Var) {
            this.f6021a = d0Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f6021a.k();
            this.f6021a.m();
            SpecialEffectsController.n((ViewGroup) fragmentK.C1.getParent(), o.this.f6020a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public o(FragmentManager fragmentManager) {
        this.f6020a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    @p0
    public View onCreateView(@g.n0 String str, @g.n0 Context context, @g.n0 AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    @p0
    public View onCreateView(@p0 View view, @g.n0 String str, @g.n0 Context context, @g.n0 AttributeSet attributeSet) {
        d0 d0VarD;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f6020a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !k.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentR0 = resourceId != -1 ? this.f6020a.r0(resourceId) : null;
        if (fragmentR0 == null && string != null) {
            fragmentR0 = this.f6020a.s0(string);
        }
        if (fragmentR0 == null && id2 != -1) {
            fragmentR0 = this.f6020a.r0(id2);
        }
        if (fragmentR0 == null) {
            fragmentR0 = this.f6020a.G0().a(context.getClassLoader(), attributeValue);
            fragmentR0.f5657o = true;
            fragmentR0.f5668x = resourceId != 0 ? resourceId : id2;
            fragmentR0.f5669y = id2;
            fragmentR0.f5670z = string;
            fragmentR0.f5658p = true;
            FragmentManager fragmentManager = this.f6020a;
            fragmentR0.f5662t = fragmentManager;
            fragmentR0.f5663u = fragmentManager.J0();
            fragmentR0.W3(this.f6020a.J0().g(), attributeSet, fragmentR0.f5642b);
            d0VarD = this.f6020a.n(fragmentR0);
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(fragmentR0);
                sb2.append(" has been inflated via the <fragment> tag: id=0x");
                sb2.append(Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentR0.f5658p) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
            }
            fragmentR0.f5658p = true;
            FragmentManager fragmentManager2 = this.f6020a;
            fragmentR0.f5662t = fragmentManager2;
            fragmentR0.f5663u = fragmentManager2.J0();
            fragmentR0.W3(this.f6020a.J0().g(), attributeSet, fragmentR0.f5642b);
            d0VarD = this.f6020a.D(fragmentR0);
            if (FragmentManager.W0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Retained Fragment ");
                sb3.append(fragmentR0);
                sb3.append(" has been re-attached via the <fragment> tag: id=0x");
                sb3.append(Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.j(fragmentR0, viewGroup);
        fragmentR0.f5665v1 = viewGroup;
        d0VarD.m();
        d0VarD.j();
        View view2 = fragmentR0.C1;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentR0.C1.getTag() == null) {
            fragmentR0.C1.setTag(string);
        }
        fragmentR0.C1.addOnAttachStateChangeListener(new a(d0VarD));
        return fragmentR0.C1;
    }
}

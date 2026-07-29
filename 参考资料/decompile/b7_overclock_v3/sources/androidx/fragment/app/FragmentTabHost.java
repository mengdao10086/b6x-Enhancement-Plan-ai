package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import g.p0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f5794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f5795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f5796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentManager f5797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TabHost.OnTabChangeListener f5799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f5800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5801h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5802a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @g.n0
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f5802a + zc.a.f58317e;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f5802a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f5802a = parcel.readString();
        }
    }

    public static class a implements TabHost.TabContentFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f5803a;

        public a(Context context) {
            this.f5803a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f5803a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final String f5804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.n0
        public final Class<?> f5805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final Bundle f5806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Fragment f5807d;

        public b(@g.n0 String str, @g.n0 Class<?> cls, @p0 Bundle bundle) {
            this.f5804a = str;
            this.f5805b = cls;
            this.f5806c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@g.n0 Context context) {
        super(context, null);
        this.f5794a = new ArrayList<>();
        f(context, null);
    }

    @Deprecated
    public void a(@g.n0 TabHost.TabSpec tabSpec, @g.n0 Class<?> cls, @p0 Bundle bundle) {
        tabSpec.setContent(new a(this.f5796c));
        String tag = tabSpec.getTag();
        b bVar = new b(tag, cls, bundle);
        if (this.f5801h) {
            Fragment fragmentS0 = this.f5797d.s0(tag);
            bVar.f5807d = fragmentS0;
            if (fragmentS0 != null && !fragmentS0.t3()) {
                g0 g0VarU = this.f5797d.u();
                g0VarU.v(bVar.f5807d);
                g0VarU.q();
            }
        }
        this.f5794a.add(bVar);
        addTab(tabSpec);
    }

    @p0
    public final g0 b(@p0 String str, @p0 g0 g0Var) {
        Fragment fragment;
        b bVarE = e(str);
        if (this.f5800g != bVarE) {
            if (g0Var == null) {
                g0Var = this.f5797d.u();
            }
            b bVar = this.f5800g;
            if (bVar != null && (fragment = bVar.f5807d) != null) {
                g0Var.v(fragment);
            }
            if (bVarE != null) {
                Fragment fragment2 = bVarE.f5807d;
                if (fragment2 == null) {
                    Fragment fragmentA = this.f5797d.G0().a(this.f5796c.getClassLoader(), bVarE.f5805b.getName());
                    bVarE.f5807d = fragmentA;
                    fragmentA.c5(bVarE.f5806c);
                    g0Var.g(this.f5798e, bVarE.f5807d, bVarE.f5804a);
                } else {
                    g0Var.p(fragment2);
                }
            }
            this.f5800g = bVarE;
        }
        return g0Var;
    }

    public final void c() {
        if (this.f5795b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f5798e);
            this.f5795b = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.f5798e);
        }
    }

    public final void d(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f5795b = frameLayout2;
            frameLayout2.setId(this.f5798e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @p0
    public final b e(String str) {
        int size = this.f5794a.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f5794a.get(i10);
            if (bVar.f5804a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    public final void f(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f5798e = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void g(@g.n0 Context context, @g.n0 FragmentManager fragmentManager) {
        d(context);
        super.setup();
        this.f5796c = context;
        this.f5797d = fragmentManager;
        c();
    }

    @Deprecated
    public void h(@g.n0 Context context, @g.n0 FragmentManager fragmentManager, int i10) {
        d(context);
        super.setup();
        this.f5796c = context;
        this.f5797d = fragmentManager;
        this.f5798e = i10;
        c();
        this.f5795b.setId(i10);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f5794a.size();
        g0 g0VarU = null;
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f5794a.get(i10);
            Fragment fragmentS0 = this.f5797d.s0(bVar.f5804a);
            bVar.f5807d = fragmentS0;
            if (fragmentS0 != null && !fragmentS0.t3()) {
                if (bVar.f5804a.equals(currentTabTag)) {
                    this.f5800g = bVar;
                } else {
                    if (g0VarU == null) {
                        g0VarU = this.f5797d.u();
                    }
                    g0VarU.v(bVar.f5807d);
                }
            }
        }
        this.f5801h = true;
        g0 g0VarB = b(currentTabTag, g0VarU);
        if (g0VarB != null) {
            g0VarB.q();
            this.f5797d.n0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5801h = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f5802a);
    }

    @Override // android.view.View
    @g.n0
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5802a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@p0 String str) {
        g0 g0VarB;
        if (this.f5801h && (g0VarB = b(str, null)) != null) {
            g0VarB.q();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f5799f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@p0 TabHost.OnTabChangeListener onTabChangeListener) {
        this.f5799f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public FragmentTabHost(@g.n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5794a = new ArrayList<>();
        f(context, attributeSet);
    }
}

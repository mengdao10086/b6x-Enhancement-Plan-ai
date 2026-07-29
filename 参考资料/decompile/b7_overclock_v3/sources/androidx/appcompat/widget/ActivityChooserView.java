package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.c;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f2101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f2102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f2103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f2104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f2105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f2106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f2107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public androidx.core.view.b f2109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataSetObserver f2110k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f2111l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j0 f2112m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PopupWindow.OnDismissListener f2113n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2114o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2115p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2116q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2117r;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f2118a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            y0 y0VarF = y0.F(context, attributeSet, f2118a);
            setBackgroundDrawable(y0VarF.h(0));
            y0VarF.I();
        }
    }

    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f2100a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f2100a.notifyDataSetInvalidated();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.b()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().a();
                androidx.core.view.b bVar = ActivityChooserView.this.f2109j;
                if (bVar != null) {
                    bVar.m(true);
                }
            }
        }
    }

    public class c extends View.AccessibilityDelegate {
        public c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            a1.d.g2(accessibilityNodeInfo).Y0(true);
        }
    }

    public class d extends h0 {
        public d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.h0
        public m.f b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.h0
        public boolean c() {
            ActivityChooserView.this.c();
            return true;
        }

        @Override // androidx.appcompat.widget.h0
        public boolean d() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.e();
        }
    }

    public class f extends BaseAdapter {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f2124g = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f2125h = 4;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f2126i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f2127j = 1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f2128k = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.widget.c f2129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2130b = 4;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2132d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2133e;

        public f() {
        }

        public int a() {
            return this.f2129a.f();
        }

        public androidx.appcompat.widget.c b() {
            return this.f2129a;
        }

        public ResolveInfo c() {
            return this.f2129a.h();
        }

        public int d() {
            return this.f2129a.j();
        }

        public boolean e() {
            return this.f2131c;
        }

        public int f() {
            int i10 = this.f2130b;
            this.f2130b = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int iMax = 0;
            for (int i11 = 0; i11 < count; i11++) {
                view = getView(i11, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f2130b = i10;
            return iMax;
        }

        public void g(androidx.appcompat.widget.c cVar) {
            androidx.appcompat.widget.c cVarB = ActivityChooserView.this.f2100a.b();
            if (cVarB != null && ActivityChooserView.this.isShown()) {
                cVarB.unregisterObserver(ActivityChooserView.this.f2110k);
            }
            this.f2129a = cVar;
            if (cVar != null && ActivityChooserView.this.isShown()) {
                cVar.registerObserver(ActivityChooserView.this.f2110k);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iF = this.f2129a.f();
            if (!this.f2131c && this.f2129a.h() != null) {
                iF--;
            }
            int iMin = Math.min(iF, this.f2130b);
            return this.f2133e ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f2131c && this.f2129a.h() != null) {
                i10++;
            }
            return this.f2129a.e(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i10) {
            return (this.f2133e && i10 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                viewInflate.setId(1);
                ((TextView) viewInflate.findViewById(androidx.appcompat.R.id.title)).setText(ActivityChooserView.this.getContext().getString(androidx.appcompat.R.string.abc_activity_chooser_view_see_all));
                return viewInflate;
            }
            if (view == null || view.getId() != androidx.appcompat.R.id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(androidx.appcompat.R.id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i10);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(androidx.appcompat.R.id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f2131c && i10 == 0 && this.f2132d) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void h(int i10) {
            if (this.f2130b != i10) {
                this.f2130b = i10;
                notifyDataSetChanged();
            }
        }

        public void i(boolean z10, boolean z11) {
            if (this.f2131c == z10 && this.f2132d == z11) {
                return;
            }
            this.f2131c = z10;
            this.f2132d = z11;
            notifyDataSetChanged();
        }

        public void j(boolean z10) {
            if (this.f2133e != z10) {
                this.f2133e = z10;
                notifyDataSetChanged();
            }
        }
    }

    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public g() {
        }

        public final void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f2113n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f2106g) {
                if (view != activityChooserView.f2104e) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.f2114o = false;
                activityChooserView.d(activityChooserView.f2115p);
                return;
            }
            activityChooserView.a();
            Intent intentB = ActivityChooserView.this.f2100a.b().b(ActivityChooserView.this.f2100a.b().g(ActivityChooserView.this.f2100a.c()));
            if (intentB != null) {
                intentB.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentB);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            androidx.core.view.b bVar = ActivityChooserView.this.f2109j;
            if (bVar != null) {
                bVar.m(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.d(Integer.MAX_VALUE);
                return;
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.f2114o) {
                if (i10 > 0) {
                    activityChooserView.f2100a.b().r(i10);
                    return;
                }
                return;
            }
            if (!activityChooserView.f2100a.e()) {
                i10++;
            }
            Intent intentB = ActivityChooserView.this.f2100a.b().b(i10);
            if (intentB != null) {
                intentB.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentB);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f2106g) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f2100a.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.f2114o = true;
                activityChooserView2.d(activityChooserView2.f2115p);
            }
            return true;
        }
    }

    public ActivityChooserView(@g.n0 Context context) {
        this(context, null);
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f2111l);
        return true;
    }

    public boolean b() {
        return getListPopupWindow().d();
    }

    public boolean c() {
        if (b() || !this.f2116q) {
            return false;
        }
        this.f2114o = false;
        d(this.f2115p);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void d(int i10) {
        if (this.f2100a.b() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f2111l);
        ?? r02 = this.f2106g.getVisibility() == 0 ? 1 : 0;
        int iA = this.f2100a.a();
        if (i10 == Integer.MAX_VALUE || iA <= i10 + r02) {
            this.f2100a.j(false);
            this.f2100a.h(i10);
        } else {
            this.f2100a.j(true);
            this.f2100a.h(i10 - 1);
        }
        j0 listPopupWindow = getListPopupWindow();
        if (listPopupWindow.d()) {
            return;
        }
        if (this.f2114o || r02 == 0) {
            this.f2100a.i(true, r02);
        } else {
            this.f2100a.i(false, false);
        }
        listPopupWindow.U(Math.min(this.f2100a.f(), this.f2108i));
        listPopupWindow.a();
        androidx.core.view.b bVar = this.f2109j;
        if (bVar != null) {
            bVar.m(true);
        }
        listPopupWindow.k().setContentDescription(getContext().getString(androidx.appcompat.R.string.abc_activitychooserview_choose_application));
        listPopupWindow.k().setSelector(new ColorDrawable(0));
    }

    public void e() {
        if (this.f2100a.getCount() > 0) {
            this.f2104e.setEnabled(true);
        } else {
            this.f2104e.setEnabled(false);
        }
        int iA = this.f2100a.a();
        int iD = this.f2100a.d();
        if (iA == 1 || (iA > 1 && iD > 0)) {
            this.f2106g.setVisibility(0);
            ResolveInfo resolveInfoC = this.f2100a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f2107h.setImageDrawable(resolveInfoC.loadIcon(packageManager));
            if (this.f2117r != 0) {
                this.f2106g.setContentDescription(getContext().getString(this.f2117r, resolveInfoC.loadLabel(packageManager)));
            }
        } else {
            this.f2106g.setVisibility(8);
        }
        if (this.f2106g.getVisibility() == 0) {
            this.f2102c.setBackgroundDrawable(this.f2103d);
        } else {
            this.f2102c.setBackgroundDrawable(null);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public androidx.appcompat.widget.c getDataModel() {
        return this.f2100a.b();
    }

    public j0 getListPopupWindow() {
        if (this.f2112m == null) {
            j0 j0Var = new j0(getContext());
            this.f2112m = j0Var;
            j0Var.q(this.f2100a);
            this.f2112m.S(this);
            this.f2112m.d0(true);
            this.f2112m.f0(this.f2101b);
            this.f2112m.e0(this.f2101b);
        }
        return this.f2112m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.appcompat.widget.c cVarB = this.f2100a.b();
        if (cVarB != null) {
            cVarB.registerObserver(this.f2110k);
        }
        this.f2116q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.c cVarB = this.f2100a.b();
        if (cVarB != null) {
            cVarB.unregisterObserver(this.f2110k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2111l);
        }
        if (b()) {
            a();
        }
        this.f2116q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f2102c.layout(0, 0, i12 - i10, i13 - i11);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        View view = this.f2102c;
        if (this.f2106g.getVisibility() != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), 1073741824);
        }
        measureChild(view, i10, i11);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.c.a
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(androidx.appcompat.widget.c cVar) {
        this.f2100a.g(cVar);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i10) {
        this.f2117r = i10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i10) {
        this.f2105f.setContentDescription(getContext().getString(i10));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2105f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i10) {
        this.f2115p = i10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f2113n = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(androidx.core.view.b bVar) {
        this.f2109j = bVar;
    }

    public ActivityChooserView(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2110k = new a();
        this.f2111l = new b();
        this.f2115p = 4;
        int[] iArr = androidx.appcompat.R.styleable.ActivityChooserView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        androidx.core.view.u0.z1(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        this.f2115p = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        g gVar = new g();
        this.f2101b = gVar;
        View viewFindViewById = findViewById(androidx.appcompat.R.id.activity_chooser_view_content);
        this.f2102c = viewFindViewById;
        this.f2103d = viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(androidx.appcompat.R.id.default_activity_button);
        this.f2106g = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i11 = androidx.appcompat.R.id.image;
        this.f2107h = (ImageView) frameLayout.findViewById(i11);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(androidx.appcompat.R.id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f2104e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i11);
        this.f2105f = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f2100a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f2108i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_config_prefDialogWidth));
    }
}

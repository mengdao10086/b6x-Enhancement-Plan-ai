package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.e;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatSpinner extends Spinner implements androidx.core.view.r0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.e1
    @SuppressLint({"ResourceType"})
    public static final int[] f2146i = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f2147j = 15;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f2148k = "AppCompatSpinner";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f2149l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f2150m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2151n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.appcompat.widget.e f2152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f2154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f2155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f2157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f2159h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2160a;

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

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f2160a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2160a = parcel.readByte() != 0;
        }
    }

    public class a extends h0 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h f2161j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, h hVar) {
            super(view);
            this.f2161j = hVar;
        }

        @Override // androidx.appcompat.widget.h0
        public m.f b() {
            return this.f2161j;
        }

        @Override // androidx.appcompat.widget.h0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().d()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().d()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                c.a(viewTreeObserver, this);
            }
        }
    }

    @g.v0(16)
    public static final class c {
        @g.u
        public static void a(@g.n0 ViewTreeObserver viewTreeObserver, @g.p0 ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    @g.v0(17)
    public static final class d {
        @g.u
        public static int a(@g.n0 View view) {
            return view.getTextAlignment();
        }

        @g.u
        public static int b(@g.n0 View view) {
            return view.getTextDirection();
        }

        @g.u
        public static void c(@g.n0 View view, int i10) {
            view.setTextAlignment(i10);
        }

        @g.u
        public static void d(@g.n0 View view, int i10) {
            view.setTextDirection(i10);
        }
    }

    @g.v0(23)
    public static final class e {
        @g.u
        public static void a(@g.n0 ThemedSpinnerAdapter themedSpinnerAdapter, @g.p0 Resources.Theme theme) {
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    @g.i1
    public class f implements i, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.i1
        public androidx.appcompat.app.e f2164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ListAdapter f2165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f2166c;

        public f() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void c(Drawable drawable) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public boolean d() {
            androidx.appcompat.app.e eVar = this.f2164a;
            if (eVar != null) {
                return eVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void dismiss() {
            androidx.appcompat.app.e eVar = this.f2164a;
            if (eVar != null) {
                eVar.dismiss();
                this.f2164a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public int e() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void f(int i10) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public CharSequence g() {
            return this.f2166c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void j(CharSequence charSequence) {
            this.f2166c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void l(int i10) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void m(int i10) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void n(int i10, int i11) {
            if (this.f2165b == null) {
                return;
            }
            e.a aVar = new e.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f2166c;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            androidx.appcompat.app.e eVarCreate = aVar.D(this.f2165b, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
            this.f2164a = eVarCreate;
            ListView listViewM = eVarCreate.m();
            d.d(listViewM, i10);
            d.c(listViewM, i11);
            this.f2164a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public int o() {
            return 0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i10, this.f2165b.getItemId(i10));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public int p() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void q(ListAdapter listAdapter) {
            this.f2165b = listAdapter;
        }
    }

    public static class g implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f2168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ListAdapter f2169b;

        public g(@g.p0 SpinnerAdapter spinnerAdapter, @g.p0 Resources.Theme theme) {
            this.f2168a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2169b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    e.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof u0) {
                    u0 u0Var = (u0) spinnerAdapter;
                    if (u0Var.getDropDownViewTheme() == null) {
                        u0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2169b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f2168a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f2168a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f2168a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f2168a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f2168a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f2169b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2168a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2168a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    @g.i1
    public class h extends j0 implements i {
        public CharSequence K7;
        public ListAdapter L7;
        public final Rect M7;
        public int N7;

        public class a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppCompatSpinner f2170a;

            public a(AppCompatSpinner appCompatSpinner) {
                this.f2170a = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    AppCompatSpinner.this.performItemClick(view, i10, hVar.L7.getItemId(i10));
                }
                h.this.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.r0(AppCompatSpinner.this)) {
                    h.this.dismiss();
                } else {
                    h.this.q0();
                    h.super.a();
                }
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f2173a;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f2173a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f2173a);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.M7 = new Rect();
            S(AppCompatSpinner.this);
            d0(true);
            j0(0);
            f0(new a(AppCompatSpinner.this));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public CharSequence g() {
            return this.K7;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void j(CharSequence charSequence) {
            this.K7 = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void m(int i10) {
            this.N7 = i10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void n(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean zD = d();
            q0();
            a0(2);
            super.a();
            ListView listViewK = k();
            listViewK.setChoiceMode(1);
            d.d(listViewK, i10);
            d.c(listViewK, i11);
            l0(AppCompatSpinner.this.getSelectedItemPosition());
            if (zD || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            e0(new c(bVar));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public int p() {
            return this.N7;
        }

        @Override // androidx.appcompat.widget.j0, androidx.appcompat.widget.AppCompatSpinner.i
        public void q(ListAdapter listAdapter) {
            super.q(listAdapter);
            this.L7 = listAdapter;
        }

        public void q0() {
            Drawable drawableI = i();
            int i10 = 0;
            if (drawableI != null) {
                drawableI.getPadding(AppCompatSpinner.this.f2159h);
                i10 = h1.b(AppCompatSpinner.this) ? AppCompatSpinner.this.f2159h.right : -AppCompatSpinner.this.f2159h.left;
            } else {
                Rect rect = AppCompatSpinner.this.f2159h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i11 = appCompatSpinner.f2158g;
            if (i11 == -2) {
                int iA = appCompatSpinner.a((SpinnerAdapter) this.L7, i());
                int i12 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f2159h;
                int i13 = (i12 - rect2.left) - rect2.right;
                if (iA > i13) {
                    iA = i13;
                }
                U(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i11 == -1) {
                U((width - paddingLeft) - paddingRight);
            } else {
                U(i11);
            }
            f(h1.b(AppCompatSpinner.this) ? i10 + (((width - paddingRight) - H()) - p()) : i10 + paddingLeft + p());
        }

        public boolean r0(View view) {
            return androidx.core.view.u0.O0(view) && view.getGlobalVisibleRect(this.M7);
        }
    }

    @g.i1
    public interface i {
        void c(Drawable drawable);

        boolean d();

        void dismiss();

        int e();

        void f(int i10);

        CharSequence g();

        Drawable i();

        void j(CharSequence charSequence);

        void l(int i10);

        void m(int i10);

        void n(int i10, int i11);

        int o();

        int p();

        void q(ListAdapter listAdapter);
    }

    public AppCompatSpinner(@g.n0 Context context) {
        this(context, (AttributeSet) null);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f2159h);
        Rect rect = this.f2159h;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        this.f2157f.n(d.b(this), d.a(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.f2152a;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        i iVar = this.f2157f;
        return iVar != null ? iVar.e() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        i iVar = this.f2157f;
        return iVar != null ? iVar.o() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f2157f != null ? this.f2158g : super.getDropDownWidth();
    }

    @g.i1
    public final i getInternalPopup() {
        return this.f2157f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        i iVar = this.f2157f;
        return iVar != null ? iVar.i() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f2153b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        i iVar = this.f2157f;
        return iVar != null ? iVar.g() : super.getPrompt();
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e eVar = this.f2152a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e eVar = this.f2152a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f2157f;
        if (iVar == null || !iVar.d()) {
            return;
        }
        this.f2157f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f2157f == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f2160a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        i iVar = this.f2157f;
        savedState.f2160a = iVar != null && iVar.d();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var = this.f2154c;
        if (h0Var == null || !h0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        i iVar = this.f2157f;
        if (iVar == null) {
            return super.performClick();
        }
        if (iVar.d()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@g.p0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e eVar = this.f2152a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@g.v int i10) {
        super.setBackgroundResource(i10);
        androidx.appcompat.widget.e eVar = this.f2152a;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        i iVar = this.f2157f;
        if (iVar == null) {
            super.setDropDownHorizontalOffset(i10);
        } else {
            iVar.m(i10);
            this.f2157f.f(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        i iVar = this.f2157f;
        if (iVar != null) {
            iVar.l(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f2157f != null) {
            this.f2158g = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        i iVar = this.f2157f;
        if (iVar != null) {
            iVar.c(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@g.v int i10) {
        setPopupBackgroundDrawable(i.a.b(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        i iVar = this.f2157f;
        if (iVar != null) {
            iVar.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList) {
        androidx.appcompat.widget.e eVar = this.f2152a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode) {
        androidx.appcompat.widget.e eVar = this.f2152a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public AppCompatSpinner(@g.n0 Context context, int i10) {
        this(context, null, androidx.appcompat.R.attr.spinnerStyle, i10);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f2156e) {
            this.f2155d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2157f != null) {
            Context context = this.f2153b;
            if (context == null) {
                context = getContext();
            }
            this.f2157f.q(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    public AppCompatSpinner(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(@g.n0 android.content.Context r6, @g.p0 android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}

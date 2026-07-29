package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.g0;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.b0;
import g.c1;
import g.d1;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    public static final String Z8 = "OVERRIDE_THEME_RES_ID";

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public static final String f20041a9 = "DATE_SELECTOR_KEY";

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public static final String f20042b9 = "CALENDAR_CONSTRAINTS_KEY";

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    public static final String f20043c9 = "TITLE_TEXT_RES_ID_KEY";

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public static final String f20044d9 = "TITLE_TEXT_KEY";

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public static final String f20045e9 = "POSITIVE_BUTTON_TEXT_RES_ID_KEY";

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    public static final String f20046f9 = "POSITIVE_BUTTON_TEXT_KEY";

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    public static final String f20047g9 = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public static final String f20048h9 = "NEGATIVE_BUTTON_TEXT_KEY";

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    public static final String f20049i9 = "INPUT_MODE_KEY";

    /* JADX INFO: renamed from: j9, reason: collision with root package name */
    public static final Object f20050j9 = "CONFIRM_BUTTON_TAG";

    /* JADX INFO: renamed from: k9, reason: collision with root package name */
    public static final Object f20051k9 = "CANCEL_BUTTON_TAG";

    /* JADX INFO: renamed from: l9, reason: collision with root package name */
    public static final Object f20052l9 = "TOGGLE_BUTTON_TAG";

    /* JADX INFO: renamed from: m9, reason: collision with root package name */
    public static final int f20053m9 = 0;

    /* JADX INFO: renamed from: n9, reason: collision with root package name */
    public static final int f20054n9 = 1;
    public final LinkedHashSet<j<? super S>> D8 = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> E8 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> F8 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> G8 = new LinkedHashSet<>();

    @d1
    public int H8;

    @p0
    public DateSelector<S> I8;
    public o<S> J8;

    @p0
    public CalendarConstraints K8;
    public MaterialCalendar<S> L8;

    @c1
    public int M8;
    public CharSequence N8;
    public boolean O8;
    public int P8;

    @c1
    public int Q8;
    public CharSequence R8;

    @c1
    public int S8;
    public CharSequence T8;
    public TextView U8;
    public CheckableImageButton V8;

    @p0
    public le.j W8;
    public Button X8;
    public boolean Y8;

    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it2 = MaterialDatePicker.this.D8.iterator();
            while (it2.hasNext()) {
                ((j) it2.next()).a(MaterialDatePicker.this.w6());
            }
            MaterialDatePicker.this.H5();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it2 = MaterialDatePicker.this.E8.iterator();
            while (it2.hasNext()) {
                ((View.OnClickListener) it2.next()).onClick(view);
            }
            MaterialDatePicker.this.H5();
        }
    }

    public class c implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f20058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f20059c;

        public c(int i10, View view, int i11) {
            this.f20057a = i10;
            this.f20058b = view;
            this.f20059c = i11;
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, j1 j1Var) {
            int i10 = j1Var.f(j1.m.i()).f40560b;
            if (this.f20057a >= 0) {
                this.f20058b.getLayoutParams().height = this.f20057a + i10;
                View view2 = this.f20058b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f20058b;
            view3.setPadding(view3.getPaddingLeft(), this.f20059c + i10, this.f20058b.getPaddingRight(), this.f20058b.getPaddingBottom());
            return j1Var;
        }
    }

    public class d extends n<S> {
        public d() {
        }

        @Override // com.google.android.material.datepicker.n
        public void a() {
            MaterialDatePicker.this.X8.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.n
        public void b(S s10) {
            MaterialDatePicker.this.K6();
            MaterialDatePicker.this.X8.setEnabled(MaterialDatePicker.this.t6().G());
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialDatePicker.this.X8.setEnabled(MaterialDatePicker.this.t6().G());
            MaterialDatePicker.this.V8.toggle();
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.L6(materialDatePicker.V8);
            MaterialDatePicker.this.H6();
        }
    }

    public static final class f<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DateSelector<S> f20063a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CalendarConstraints f20065c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20064b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20066d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f20067e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f20068f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CharSequence f20069g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f20070h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f20071i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public S f20072j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20073k = 0;

        public f(DateSelector<S> dateSelector) {
            this.f20063a = dateSelector;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public static <S> f<S> c(@n0 DateSelector<S> dateSelector) {
            return new f<>(dateSelector);
        }

        @n0
        public static f<Long> d() {
            return new f<>(new SingleDateSelector());
        }

        @n0
        public static f<androidx.core.util.k<Long, Long>> e() {
            return new f<>(new RangeDateSelector());
        }

        public static boolean f(Month month, CalendarConstraints calendarConstraints) {
            return month.compareTo(calendarConstraints.T()) >= 0 && month.compareTo(calendarConstraints.C()) <= 0;
        }

        @n0
        public MaterialDatePicker<S> a() {
            if (this.f20065c == null) {
                this.f20065c = new CalendarConstraints.b().a();
            }
            if (this.f20066d == 0) {
                this.f20066d = this.f20063a.w();
            }
            S s10 = this.f20072j;
            if (s10 != null) {
                this.f20063a.i(s10);
            }
            if (this.f20065c.S() == null) {
                this.f20065c.W(b());
            }
            return MaterialDatePicker.B6(this);
        }

        public final Month b() {
            if (!this.f20063a.H().isEmpty()) {
                Month monthJ = Month.j(this.f20063a.H().iterator().next().longValue());
                if (f(monthJ, this.f20065c)) {
                    return monthJ;
                }
            }
            Month monthS = Month.s();
            return f(monthS, this.f20065c) ? monthS : this.f20065c.T();
        }

        @n0
        public f<S> g(CalendarConstraints calendarConstraints) {
            this.f20065c = calendarConstraints;
            return this;
        }

        @n0
        public f<S> h(int i10) {
            this.f20073k = i10;
            return this;
        }

        @n0
        public f<S> i(@c1 int i10) {
            this.f20070h = i10;
            this.f20071i = null;
            return this;
        }

        @n0
        public f<S> j(@p0 CharSequence charSequence) {
            this.f20071i = charSequence;
            this.f20070h = 0;
            return this;
        }

        @n0
        public f<S> k(@c1 int i10) {
            this.f20068f = i10;
            this.f20069g = null;
            return this;
        }

        @n0
        public f<S> l(@p0 CharSequence charSequence) {
            this.f20069g = charSequence;
            this.f20068f = 0;
            return this;
        }

        @n0
        public f<S> m(S s10) {
            this.f20072j = s10;
            return this;
        }

        @n0
        public f<S> n(@d1 int i10) {
            this.f20064b = i10;
            return this;
        }

        @n0
        public f<S> o(@c1 int i10) {
            this.f20066d = i10;
            this.f20067e = null;
            return this;
        }

        @n0
        public f<S> p(@p0 CharSequence charSequence) {
            this.f20067e = charSequence;
            this.f20066d = 0;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    public static boolean A6(@n0 Context context) {
        return C6(context, R.attr.nestedScrollable);
    }

    @n0
    public static <S> MaterialDatePicker<S> B6(@n0 f<S> fVar) {
        MaterialDatePicker<S> materialDatePicker = new MaterialDatePicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt(Z8, fVar.f20064b);
        bundle.putParcelable("DATE_SELECTOR_KEY", fVar.f20063a);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", fVar.f20065c);
        bundle.putInt(f20043c9, fVar.f20066d);
        bundle.putCharSequence(f20044d9, fVar.f20067e);
        bundle.putInt(f20049i9, fVar.f20073k);
        bundle.putInt(f20045e9, fVar.f20068f);
        bundle.putCharSequence(f20046f9, fVar.f20069g);
        bundle.putInt(f20047g9, fVar.f20070h);
        bundle.putCharSequence(f20048h9, fVar.f20071i);
        materialDatePicker.c5(bundle);
        return materialDatePicker;
    }

    public static boolean C6(@n0 Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(ie.b.g(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i10});
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }

    public static long I6() {
        return Month.s().f20086f;
    }

    public static long J6() {
        return r.t().getTimeInMillis();
    }

    @n0
    public static Drawable r6(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, i.a.b(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], i.a.b(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    public static int v6(@n0 Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i10 = Month.s().f20084d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    public static boolean z6(@n0 Context context) {
        return C6(context, android.R.attr.windowFullscreen);
    }

    public boolean D6(DialogInterface.OnCancelListener onCancelListener) {
        return this.F8.remove(onCancelListener);
    }

    public boolean E6(DialogInterface.OnDismissListener onDismissListener) {
        return this.G8.remove(onDismissListener);
    }

    public boolean F6(View.OnClickListener onClickListener) {
        return this.E8.remove(onClickListener);
    }

    public boolean G6(j<? super S> jVar) {
        return this.D8.remove(jVar);
    }

    public final void H6() {
        int iX6 = x6(R4());
        this.L8 = MaterialCalendar.X5(t6(), iX6, this.K8);
        this.J8 = this.V8.isChecked() ? MaterialTextInputPicker.I5(t6(), iX6, this.K8) : this.L8;
        K6();
        g0 g0VarU = U1().u();
        g0VarU.C(R.id.mtrl_calendar_frame, this.J8);
        g0VarU.s();
        this.J8.E5(new d());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (bundle == null) {
            bundle = T1();
        }
        this.H8 = bundle.getInt(Z8);
        this.I8 = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.K8 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.M8 = bundle.getInt(f20043c9);
        this.N8 = bundle.getCharSequence(f20044d9);
        this.P8 = bundle.getInt(f20049i9);
        this.Q8 = bundle.getInt(f20045e9);
        this.R8 = bundle.getCharSequence(f20046f9);
        this.S8 = bundle.getInt(f20047g9);
        this.T8 = bundle.getCharSequence(f20048h9);
    }

    public final void K6() {
        String strU6 = u6();
        this.U8.setContentDescription(String.format(c3(R.string.mtrl_picker_announce_current_selection), strU6));
        this.U8.setText(strU6);
    }

    public final void L6(@n0 CheckableImageButton checkableImageButton) {
        this.V8.setContentDescription(this.V8.isChecked() ? checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.Fragment
    @n0
    public final View O3(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.O8 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.O8) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(v6(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(v6(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.U8 = textView;
        u0.D1(textView, 1);
        this.V8 = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.N8;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.M8);
        }
        y6(context);
        this.X8 = (Button) viewInflate.findViewById(R.id.confirm_button);
        if (t6().G()) {
            this.X8.setEnabled(true);
        } else {
            this.X8.setEnabled(false);
        }
        this.X8.setTag(f20050j9);
        CharSequence charSequence2 = this.R8;
        if (charSequence2 != null) {
            this.X8.setText(charSequence2);
        } else {
            int i10 = this.Q8;
            if (i10 != 0) {
                this.X8.setText(i10);
            }
        }
        this.X8.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        button.setTag(f20051k9);
        CharSequence charSequence3 = this.T8;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i11 = this.S8;
            if (i11 != 0) {
                button.setText(i11);
            }
        }
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment
    @n0
    public final Dialog P5(@p0 Bundle bundle) {
        Dialog dialog = new Dialog(R4(), x6(R4()));
        Context context = dialog.getContext();
        this.O8 = z6(context);
        int iG = ie.b.g(context, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        le.j jVar = new le.j(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.W8 = jVar;
        jVar.Z(context);
        this.W8.o0(ColorStateList.valueOf(iG));
        this.W8.n0(u0.R(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void g4(@n0 Bundle bundle) {
        super.g4(bundle);
        bundle.putInt(Z8, this.H8);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.I8);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.K8);
        if (this.L8.T5() != null) {
            bVar.d(this.L8.T5().f20086f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt(f20043c9, this.M8);
        bundle.putCharSequence(f20044d9, this.N8);
        bundle.putInt(f20045e9, this.Q8);
        bundle.putCharSequence(f20046f9, this.R8);
        bundle.putInt(f20047g9, this.S8);
        bundle.putCharSequence(f20048h9, this.T8);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        Window window = T5().getWindow();
        if (this.O8) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.W8);
            s6(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = V2().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.W8, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new wd.a(T5(), rect));
        }
        H6();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void i4() {
        this.J8.F5();
        super.i4();
    }

    public boolean j6(DialogInterface.OnCancelListener onCancelListener) {
        return this.F8.add(onCancelListener);
    }

    public boolean k6(DialogInterface.OnDismissListener onDismissListener) {
        return this.G8.add(onDismissListener);
    }

    public boolean l6(View.OnClickListener onClickListener) {
        return this.E8.add(onClickListener);
    }

    public boolean m6(j<? super S> jVar) {
        return this.D8.add(jVar);
    }

    public void n6() {
        this.F8.clear();
    }

    public void o6() {
        this.G8.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@n0 DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it2 = this.F8.iterator();
        while (it2.hasNext()) {
            it2.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@n0 DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it2 = this.G8.iterator();
        while (it2.hasNext()) {
            it2.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) k3();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public void p6() {
        this.E8.clear();
    }

    public void q6() {
        this.D8.clear();
    }

    public final void s6(Window window) {
        if (this.Y8) {
            return;
        }
        View viewFindViewById = V4().findViewById(R.id.fullscreen_header);
        com.google.android.material.internal.e.b(window, true, b0.f(viewFindViewById), null);
        u0.a2(viewFindViewById, new c(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.Y8 = true;
    }

    public final DateSelector<S> t6() {
        if (this.I8 == null) {
            this.I8 = (DateSelector) T1().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.I8;
    }

    public String u6() {
        return t6().d(X1());
    }

    @p0
    public final S w6() {
        return t6().J();
    }

    public final int x6(Context context) {
        int i10 = this.H8;
        return i10 != 0 ? i10 : t6().B(context);
    }

    public final void y6(Context context) {
        this.V8.setTag(f20052l9);
        this.V8.setImageDrawable(r6(context));
        this.V8.setChecked(this.P8 != 0);
        u0.B1(this.V8, null);
        L6(this.V8);
        this.V8.setOnClickListener(new e());
    }
}

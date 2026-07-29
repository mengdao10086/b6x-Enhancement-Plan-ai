package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.TimePickerView;
import g.c1;
import g.d1;
import g.f0;
import g.i1;
import g.n0;
import g.p0;
import g.v;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.d {
    public static final int Z8 = 0;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public static final int f21084a9 = 1;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public static final String f21085b9 = "TIME_PICKER_TIME_MODEL";

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    public static final String f21086c9 = "TIME_PICKER_INPUT_MODE";

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public static final String f21087d9 = "TIME_PICKER_TITLE_RES";

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public static final String f21088e9 = "TIME_PICKER_TITLE_TEXT";

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    public static final String f21089f9 = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    public static final String f21090g9 = "TIME_PICKER_POSITIVE_BUTTON_TEXT";

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public static final String f21091h9 = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    public static final String f21092i9 = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";

    /* JADX INFO: renamed from: j9, reason: collision with root package name */
    public static final String f21093j9 = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    public TimePickerView H8;
    public ViewStub I8;

    @p0
    public f J8;

    @p0
    public k K8;

    @p0
    public h L8;

    @v
    public int M8;

    @v
    public int N8;
    public CharSequence P8;
    public CharSequence R8;
    public CharSequence T8;
    public MaterialButton U8;
    public Button V8;
    public TimeModel X8;
    public final Set<View.OnClickListener> D8 = new LinkedHashSet();
    public final Set<View.OnClickListener> E8 = new LinkedHashSet();
    public final Set<DialogInterface.OnCancelListener> F8 = new LinkedHashSet();
    public final Set<DialogInterface.OnDismissListener> G8 = new LinkedHashSet();

    @c1
    public int O8 = 0;

    @c1
    public int Q8 = 0;

    @c1
    public int S8 = 0;
    public int W8 = 0;
    public int Y8 = 0;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it2 = MaterialTimePicker.this.D8.iterator();
            while (it2.hasNext()) {
                ((View.OnClickListener) it2.next()).onClick(view);
            }
            MaterialTimePicker.this.H5();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it2 = MaterialTimePicker.this.E8.iterator();
            while (it2.hasNext()) {
                ((View.OnClickListener) it2.next()).onClick(view);
            }
            MaterialTimePicker.this.H5();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.W8 = materialTimePicker.W8 == 0 ? 1 : 0;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.H6(materialTimePicker2.U8);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21098b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f21100d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f21102f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f21104h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TimeModel f21097a = new TimeModel();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c1
        public int f21099c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c1
        public int f21101e = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @c1
        public int f21103g = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f21105i = 0;

        @n0
        public MaterialTimePicker j() {
            return MaterialTimePicker.x6(this);
        }

        @n0
        public d k(@f0(from = 0, to = 23) int i10) {
            this.f21097a.C(i10);
            return this;
        }

        @n0
        public d l(int i10) {
            this.f21098b = i10;
            return this;
        }

        @n0
        public d m(@f0(from = 0, to = 59) int i10) {
            this.f21097a.F(i10);
            return this;
        }

        @n0
        public d n(@c1 int i10) {
            this.f21103g = i10;
            return this;
        }

        @n0
        public d o(@p0 CharSequence charSequence) {
            this.f21104h = charSequence;
            return this;
        }

        @n0
        public d p(@c1 int i10) {
            this.f21101e = i10;
            return this;
        }

        @n0
        public d q(@p0 CharSequence charSequence) {
            this.f21102f = charSequence;
            return this;
        }

        @n0
        public d r(@d1 int i10) {
            this.f21105i = i10;
            return this;
        }

        @n0
        public d s(int i10) {
            TimeModel timeModel = this.f21097a;
            int i11 = timeModel.f21111d;
            int i12 = timeModel.f21112e;
            TimeModel timeModel2 = new TimeModel(i10);
            this.f21097a = timeModel2;
            timeModel2.F(i12);
            this.f21097a.C(i11);
            return this;
        }

        @n0
        public d t(@c1 int i10) {
            this.f21099c = i10;
            return this;
        }

        @n0
        public d u(@p0 CharSequence charSequence) {
            this.f21100d = charSequence;
            return this;
        }
    }

    @n0
    public static MaterialTimePicker x6(@n0 d dVar) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(f21085b9, dVar.f21097a);
        bundle.putInt(f21086c9, dVar.f21098b);
        bundle.putInt(f21087d9, dVar.f21099c);
        if (dVar.f21100d != null) {
            bundle.putCharSequence(f21088e9, dVar.f21100d);
        }
        bundle.putInt(f21089f9, dVar.f21101e);
        if (dVar.f21102f != null) {
            bundle.putCharSequence(f21090g9, dVar.f21102f);
        }
        bundle.putInt(f21091h9, dVar.f21103g);
        if (dVar.f21104h != null) {
            bundle.putCharSequence(f21092i9, dVar.f21104h);
        }
        bundle.putInt(f21093j9, dVar.f21105i);
        materialTimePicker.c5(bundle);
        return materialTimePicker;
    }

    public boolean A6(@n0 View.OnClickListener onClickListener) {
        return this.E8.remove(onClickListener);
    }

    public boolean B6(@n0 View.OnClickListener onClickListener) {
        return this.D8.remove(onClickListener);
    }

    public final void C6(@p0 Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable(f21085b9);
        this.X8 = timeModel;
        if (timeModel == null) {
            this.X8 = new TimeModel();
        }
        this.W8 = bundle.getInt(f21086c9, 0);
        this.O8 = bundle.getInt(f21087d9, 0);
        this.P8 = bundle.getCharSequence(f21088e9);
        this.Q8 = bundle.getInt(f21089f9, 0);
        this.R8 = bundle.getCharSequence(f21090g9);
        this.S8 = bundle.getInt(f21091h9, 0);
        this.T8 = bundle.getCharSequence(f21092i9);
        this.Y8 = bundle.getInt(f21093j9, 0);
    }

    @i1
    public void D6(@p0 h hVar) {
        this.L8 = hVar;
    }

    public void E6(@f0(from = 0, to = 23) int i10) {
        this.X8.z(i10);
        h hVar = this.L8;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void F6(@f0(from = 0, to = 59) int i10) {
        this.X8.F(i10);
        h hVar = this.L8;
        if (hVar != null) {
            hVar.d();
        }
    }

    public final void G6() {
        Button button = this.V8;
        if (button != null) {
            button.setVisibility(O5() ? 0 : 8);
        }
    }

    public final void H6(MaterialButton materialButton) {
        if (materialButton == null || this.H8 == null || this.I8 == null) {
            return;
        }
        h hVar = this.L8;
        if (hVar != null) {
            hVar.c();
        }
        h hVarW6 = w6(this.W8, this.H8, this.I8);
        this.L8 = hVarW6;
        hVarW6.a();
        this.L8.d();
        Pair<Integer, Integer> pairQ6 = q6(this.W8);
        materialButton.setIconResource(((Integer) pairQ6.first).intValue());
        materialButton.setContentDescription(V2().getString(((Integer) pairQ6.second).intValue()));
        materialButton.sendAccessibilityEvent(4);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (bundle == null) {
            bundle = T1();
        }
        C6(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @n0
    public final View O3(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.H8 = timePickerView;
        timePickerView.X(this);
        this.I8 = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.U8 = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        int i10 = this.O8;
        if (i10 != 0) {
            textView.setText(i10);
        } else if (!TextUtils.isEmpty(this.P8)) {
            textView.setText(this.P8);
        }
        H6(this.U8);
        Button button = (Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button);
        button.setOnClickListener(new a());
        int i11 = this.Q8;
        if (i11 != 0) {
            button.setText(i11);
        } else if (!TextUtils.isEmpty(this.R8)) {
            button.setText(this.R8);
        }
        Button button2 = (Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button);
        this.V8 = button2;
        button2.setOnClickListener(new b());
        int i12 = this.S8;
        if (i12 != 0) {
            this.V8.setText(i12);
        } else if (!TextUtils.isEmpty(this.T8)) {
            this.V8.setText(this.T8);
        }
        G6();
        this.U8.setOnClickListener(new c());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment
    @n0
    public final Dialog P5(@p0 Bundle bundle) {
        Dialog dialog = new Dialog(R4(), u6());
        Context context = dialog.getContext();
        int iG = ie.b.g(context, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i10 = R.attr.materialTimePickerStyle;
        int i11 = R.style.Widget_MaterialComponents_TimePicker;
        le.j jVar = new le.j(context, null, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, i10, i11);
        this.N8 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.M8 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        typedArrayObtainStyledAttributes.recycle();
        jVar.Z(context);
        jVar.o0(ColorStateList.valueOf(iG));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(jVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        jVar.n0(u0.R(window.getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void R3() {
        super.R3();
        this.L8 = null;
        this.J8 = null;
        this.K8 = null;
        TimePickerView timePickerView = this.H8;
        if (timePickerView != null) {
            timePickerView.X(null);
            this.H8 = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void U5(boolean z10) {
        super.U5(z10);
        G6();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void g() {
        this.W8 = 1;
        H6(this.U8);
        this.K8.l();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void g4(@n0 Bundle bundle) {
        super.g4(bundle);
        bundle.putParcelable(f21085b9, this.X8);
        bundle.putInt(f21086c9, this.W8);
        bundle.putInt(f21087d9, this.O8);
        bundle.putCharSequence(f21088e9, this.P8);
        bundle.putInt(f21089f9, this.Q8);
        bundle.putCharSequence(f21090g9, this.R8);
        bundle.putInt(f21091h9, this.S8);
        bundle.putCharSequence(f21092i9, this.T8);
        bundle.putInt(f21093j9, this.Y8);
    }

    public boolean i6(@n0 DialogInterface.OnCancelListener onCancelListener) {
        return this.F8.add(onCancelListener);
    }

    public boolean j6(@n0 DialogInterface.OnDismissListener onDismissListener) {
        return this.G8.add(onDismissListener);
    }

    public boolean k6(@n0 View.OnClickListener onClickListener) {
        return this.E8.add(onClickListener);
    }

    public boolean l6(@n0 View.OnClickListener onClickListener) {
        return this.D8.add(onClickListener);
    }

    public void m6() {
        this.F8.clear();
    }

    public void n6() {
        this.G8.clear();
    }

    public void o6() {
        this.E8.clear();
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
        super.onDismiss(dialogInterface);
    }

    public void p6() {
        this.D8.clear();
    }

    public final Pair<Integer, Integer> q6(int i10) {
        if (i10 == 0) {
            return new Pair<>(Integer.valueOf(this.M8), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
        }
        if (i10 == 1) {
            return new Pair<>(Integer.valueOf(this.N8), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i10);
    }

    @f0(from = 0, to = 23)
    public int r6() {
        return this.X8.f21111d % 24;
    }

    public int s6() {
        return this.W8;
    }

    @f0(from = 0, to = 59)
    public int t6() {
        return this.X8.f21112e;
    }

    public final int u6() {
        int i10 = this.Y8;
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValueA = ie.b.a(R4(), R.attr.materialTimePickerTheme);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    @p0
    public f v6() {
        return this.J8;
    }

    public final h w6(int i10, @n0 TimePickerView timePickerView, @n0 ViewStub viewStub) {
        if (i10 != 0) {
            if (this.K8 == null) {
                this.K8 = new k((LinearLayout) viewStub.inflate(), this.X8);
            }
            this.K8.i();
            return this.K8;
        }
        f fVar = this.J8;
        if (fVar == null) {
            fVar = new f(timePickerView, this.X8);
        }
        this.J8 = fVar;
        return fVar;
    }

    public boolean y6(@n0 DialogInterface.OnCancelListener onCancelListener) {
        return this.F8.remove(onCancelListener);
    }

    public boolean z6(@n0 DialogInterface.OnDismissListener onDismissListener) {
        return this.G8.remove(onDismissListener);
    }
}

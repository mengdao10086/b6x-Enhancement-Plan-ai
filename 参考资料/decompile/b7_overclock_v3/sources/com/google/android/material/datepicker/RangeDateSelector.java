package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import com.blankj.utilcode.util.i0;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import g.n0;
import g.p0;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<androidx.core.util.k<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20089b = i0.f11861z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public Long f20090c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public Long f20091d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public Long f20092e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public Long f20093f = null;

    public class a extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f20094h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f20095i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ n f20096j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, n nVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f20094h = textInputLayout2;
            this.f20095i = textInputLayout3;
            this.f20096j = nVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void f() {
            RangeDateSelector.this.f20092e = null;
            RangeDateSelector.this.S(this.f20094h, this.f20095i, this.f20096j);
        }

        @Override // com.google.android.material.datepicker.e
        public void g(@p0 Long l10) {
            RangeDateSelector.this.f20092e = l10;
            RangeDateSelector.this.S(this.f20094h, this.f20095i, this.f20096j);
        }
    }

    public class b extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f20098h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f20099i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ n f20100j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, n nVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f20098h = textInputLayout2;
            this.f20099i = textInputLayout3;
            this.f20100j = nVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void f() {
            RangeDateSelector.this.f20093f = null;
            RangeDateSelector.this.S(this.f20098h, this.f20099i, this.f20100j);
        }

        @Override // com.google.android.material.datepicker.e
        public void g(@p0 Long l10) {
            RangeDateSelector.this.f20093f = l10;
            RangeDateSelector.this.S(this.f20098h, this.f20099i, this.f20100j);
        }
    }

    public class c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(@n0 Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f20090c = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f20091d = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int B(@n0 Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return ie.b.g(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public final boolean C(long j10, long j11) {
        return j10 <= j11;
    }

    public final void F(@n0 TextInputLayout textInputLayout, @n0 TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f20088a);
        textInputLayout2.setError(i0.f11861z);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean G() {
        Long l10 = this.f20090c;
        return (l10 == null || this.f20091d == null || !C(l10.longValue(), this.f20091d.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @n0
    public Collection<Long> H() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f20090c;
        if (l10 != null) {
            arrayList.add(l10);
        }
        Long l11 = this.f20091d;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void i(@n0 androidx.core.util.k<Long, Long> kVar) {
        Long l10 = kVar.f4741a;
        if (l10 != null && kVar.f4742b != null) {
            androidx.core.util.o.a(C(l10.longValue(), kVar.f4742b.longValue()));
        }
        Long l11 = kVar.f4741a;
        this.f20090c = l11 == null ? null : Long.valueOf(r.a(l11.longValue()));
        Long l12 = kVar.f4742b;
        this.f20091d = l12 != null ? Long.valueOf(r.a(l12.longValue())) : null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void P(long j10) {
        Long l10 = this.f20090c;
        if (l10 == null) {
            this.f20090c = Long.valueOf(j10);
        } else if (this.f20091d == null && C(l10.longValue(), j10)) {
            this.f20091d = Long.valueOf(j10);
        } else {
            this.f20091d = null;
            this.f20090c = Long.valueOf(j10);
        }
    }

    public final void S(@n0 TextInputLayout textInputLayout, @n0 TextInputLayout textInputLayout2, @n0 n<androidx.core.util.k<Long, Long>> nVar) {
        Long l10 = this.f20092e;
        if (l10 == null || this.f20093f == null) {
            s(textInputLayout, textInputLayout2);
            nVar.a();
        } else if (!C(l10.longValue(), this.f20093f.longValue())) {
            F(textInputLayout, textInputLayout2);
            nVar.a();
        } else {
            this.f20090c = this.f20092e;
            this.f20091d = this.f20093f;
            nVar.b(J());
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @n0
    public String d(@n0 Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f20090c;
        if (l10 == null && this.f20091d == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l11 = this.f20091d;
        if (l11 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, h.c(l10.longValue()));
        }
        if (l10 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, h.c(l11.longValue()));
        }
        androidx.core.util.k<String, String> kVarA = h.a(l10, l11);
        return resources.getString(R.string.mtrl_picker_range_header_selected, kVarA.f4741a, kVarA.f4742b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @n0
    public Collection<androidx.core.util.k<Long, Long>> h() {
        if (this.f20090c == null || this.f20091d == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new androidx.core.util.k(this.f20090c, this.f20091d));
        return arrayList;
    }

    public final void s(@n0 TextInputLayout textInputLayout, @n0 TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f20088a.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !i0.f11861z.contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View v(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle, CalendarConstraints calendarConstraints, @n0 n<androidx.core.util.k<Long, Long>> nVar) {
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.i.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f20088a = viewInflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatP = r.p();
        Long l10 = this.f20090c;
        if (l10 != null) {
            editText.setText(simpleDateFormatP.format(l10));
            this.f20092e = this.f20090c;
        }
        Long l11 = this.f20091d;
        if (l11 != null) {
            editText2.setText(simpleDateFormatP.format(l11));
            this.f20093f = this.f20091d;
        }
        String strQ = r.q(viewInflate.getResources(), simpleDateFormatP);
        textInputLayout.setPlaceholderText(strQ);
        textInputLayout2.setPlaceholderText(strQ);
        editText.addTextChangedListener(new a(strQ, simpleDateFormatP, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, nVar));
        editText2.addTextChangedListener(new b(strQ, simpleDateFormatP, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, nVar));
        g.b(editText, editText2);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int w() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeValue(this.f20090c);
        parcel.writeValue(this.f20091d);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @n0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public androidx.core.util.k<Long, Long> J() {
        return new androidx.core.util.k<>(this.f20090c, this.f20091d);
    }
}

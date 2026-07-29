package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
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
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public Long f20102a;

    public class a extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ n f20103h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, n nVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f20103h = nVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void f() {
            this.f20103h.a();
        }

        @Override // com.google.android.material.datepicker.e
        public void g(@p0 Long l10) {
            if (l10 == null) {
                SingleDateSelector.this.e();
            } else {
                SingleDateSelector.this.P(l10.longValue());
            }
            this.f20103h.b(SingleDateSelector.this.J());
        }
    }

    public class b implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector createFromParcel(@n0 Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f20102a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector[] newArray(int i10) {
            return new SingleDateSelector[i10];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int B(Context context) {
        return ie.b.g(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean G() {
        return this.f20102a != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @n0
    public Collection<Long> H() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f20102a;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void P(long j10) {
        this.f20102a = Long.valueOf(j10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @n0
    public String d(@n0 Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f20102a;
        if (l10 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, h.j(l10.longValue()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e() {
        this.f20102a = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @p0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Long J() {
        return this.f20102a;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @n0
    public Collection<androidx.core.util.k<Long, Long>> h() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void i(@p0 Long l10) {
        this.f20102a = l10 == null ? null : Long.valueOf(r.a(l10.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View v(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle, CalendarConstraints calendarConstraints, @n0 n<Long> nVar) {
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (com.google.android.material.internal.i.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatP = r.p();
        String strQ = r.q(viewInflate.getResources(), simpleDateFormatP);
        textInputLayout.setPlaceholderText(strQ);
        Long l10 = this.f20102a;
        if (l10 != null) {
            editText.setText(simpleDateFormatP.format(l10));
        }
        editText.addTextChangedListener(new a(strQ, simpleDateFormatP, textInputLayout, calendarConstraints, nVar));
        g.b(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int w() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeValue(this.f20102a);
    }
}

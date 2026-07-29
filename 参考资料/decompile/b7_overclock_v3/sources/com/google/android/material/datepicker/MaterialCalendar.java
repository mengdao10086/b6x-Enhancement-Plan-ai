package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.x;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import g.d1;
import g.i1;
import g.n0;
import g.p0;
import g.t0;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends o<S> {

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public static final String f20003n8 = "THEME_RES_ID_KEY";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public static final String f20004o8 = "GRID_SELECTOR_KEY";

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public static final String f20005p8 = "CALENDAR_CONSTRAINTS_KEY";

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public static final String f20006q8 = "CURRENT_MONTH_KEY";

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public static final int f20007r8 = 3;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @i1
    public static final Object f20008s8 = "MONTHS_VIEW_GROUP_TAG";

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @i1
    public static final Object f20009t8 = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @i1
    public static final Object f20010u8 = "NAVIGATION_NEXT_TAG";

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @i1
    public static final Object f20011v8 = "SELECTOR_TOGGLE_TAG";

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    @d1
    public int f20012d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    @p0
    public DateSelector<S> f20013e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    @p0
    public CalendarConstraints f20014f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    @p0
    public Month f20015g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public CalendarSelector f20016h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public com.google.android.material.datepicker.b f20017i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public RecyclerView f20018j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public RecyclerView f20019k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public View f20020l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public View f20021m8;

    public enum CalendarSelector {
        DAY,
        YEAR
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20022a;

        public a(int i10) {
            this.f20022a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.f20019k8.L1(this.f20022a);
        }
    }

    public class b extends androidx.core.view.a {
        public b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            dVar.d1(null);
        }
    }

    public class c extends p {
        public final /* synthetic */ int G7;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.G7 = i11;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void k2(@n0 RecyclerView.b0 b0Var, @n0 int[] iArr) {
            if (this.G7 == 0) {
                iArr[0] = MaterialCalendar.this.f20019k8.getWidth();
                iArr[1] = MaterialCalendar.this.f20019k8.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.f20019k8.getHeight();
                iArr[1] = MaterialCalendar.this.f20019k8.getHeight();
            }
        }
    }

    public class d implements k {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.k
        public void a(long j10) {
            if (MaterialCalendar.this.f20014f8.z().D(j10)) {
                MaterialCalendar.this.f20013e8.P(j10);
                Iterator<n<S>> it2 = MaterialCalendar.this.f20155c8.iterator();
                while (it2.hasNext()) {
                    it2.next().b(MaterialCalendar.this.f20013e8.J());
                }
                MaterialCalendar.this.f20019k8.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.f20018j8 != null) {
                    MaterialCalendar.this.f20018j8.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    public class e extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Calendar f20026a = r.v();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Calendar f20027b = r.v();

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void f(@n0 Canvas canvas, @n0 RecyclerView recyclerView, @n0 RecyclerView.b0 b0Var) {
            if ((recyclerView.getAdapter() instanceof s) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                s sVar = (s) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (androidx.core.util.k<Long, Long> kVar : MaterialCalendar.this.f20013e8.h()) {
                    Long l10 = kVar.f4741a;
                    if (l10 != null && kVar.f4742b != null) {
                        this.f20026a.setTimeInMillis(l10.longValue());
                        this.f20027b.setTimeInMillis(kVar.f4742b.longValue());
                        int iN = sVar.n(this.f20026a.get(1));
                        int iN2 = sVar.n(this.f20027b.get(1));
                        View viewR = gridLayoutManager.R(iN);
                        View viewR2 = gridLayoutManager.R(iN2);
                        int iH3 = iN / gridLayoutManager.H3();
                        int iH32 = iN2 / gridLayoutManager.H3();
                        int i10 = iH3;
                        while (i10 <= iH32) {
                            if (gridLayoutManager.R(gridLayoutManager.H3() * i10) != null) {
                                canvas.drawRect(i10 == iH3 ? viewR.getLeft() + (viewR.getWidth() / 2) : 0, r9.getTop() + MaterialCalendar.this.f20017i8.f20114d.e(), i10 == iH32 ? viewR2.getLeft() + (viewR2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - MaterialCalendar.this.f20017i8.f20114d.b(), MaterialCalendar.this.f20017i8.f20118h);
                            }
                            i10++;
                        }
                    }
                }
            }
        }
    }

    public class f extends androidx.core.view.a {
        public f() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            dVar.q1(MaterialCalendar.this.f20021m8.getVisibility() == 0 ? MaterialCalendar.this.c3(R.string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.c3(R.string.mtrl_picker_toggle_to_day_selection));
        }
    }

    public class g extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f20030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialButton f20031b;

        public g(m mVar, MaterialButton materialButton) {
            this.f20030a = mVar;
            this.f20031b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(@n0 RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                recyclerView.announceForAccessibility(this.f20031b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(@n0 RecyclerView recyclerView, int i10, int i11) {
            int iY2 = i10 < 0 ? MaterialCalendar.this.W5().y2() : MaterialCalendar.this.W5().C2();
            MaterialCalendar.this.f20015g8 = this.f20030a.m(iY2);
            this.f20031b.setText(this.f20030a.n(iY2));
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.b6();
        }
    }

    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f20034a;

        public i(m mVar) {
            this.f20034a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iY2 = MaterialCalendar.this.W5().y2() + 1;
            if (iY2 < MaterialCalendar.this.f20019k8.getAdapter().getItemCount()) {
                MaterialCalendar.this.Z5(this.f20034a.m(iY2));
            }
        }
    }

    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f20036a;

        public j(m mVar) {
            this.f20036a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iC2 = MaterialCalendar.this.W5().C2() - 1;
            if (iC2 >= 0) {
                MaterialCalendar.this.Z5(this.f20036a.m(iC2));
            }
        }
    }

    public interface k {
        void a(long j10);
    }

    @t0
    public static int U5(@n0 Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    public static int V5(@n0 Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i10 = l.f20140f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    @n0
    public static <T> MaterialCalendar<T> X5(@n0 DateSelector<T> dateSelector, @d1 int i10, @n0 CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable(f20004o8, dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable(f20006q8, calendarConstraints.S());
        materialCalendar.c5(bundle);
        return materialCalendar;
    }

    @Override // com.google.android.material.datepicker.o
    public boolean E5(@n0 n<S> nVar) {
        return super.E5(nVar);
    }

    @Override // com.google.android.material.datepicker.o
    @p0
    public DateSelector<S> G5() {
        return this.f20013e8;
    }

    @Override // androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (bundle == null) {
            bundle = T1();
        }
        this.f20012d8 = bundle.getInt("THEME_RES_ID_KEY");
        this.f20013e8 = (DateSelector) bundle.getParcelable(f20004o8);
        this.f20014f8 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f20015g8 = (Month) bundle.getParcelable(f20006q8);
    }

    @Override // androidx.fragment.app.Fragment
    @n0
    public View O3(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        int i10;
        int i11;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(X1(), this.f20012d8);
        this.f20017i8 = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month monthT = this.f20014f8.T();
        if (MaterialDatePicker.z6(contextThemeWrapper)) {
            i10 = R.layout.mtrl_calendar_vertical;
            i11 = 1;
        } else {
            i10 = R.layout.mtrl_calendar_horizontal;
            i11 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i10, viewGroup, false);
        viewInflate.setMinimumHeight(V5(R4()));
        GridView gridView = (GridView) viewInflate.findViewById(R.id.mtrl_calendar_days_of_week);
        u0.B1(gridView, new b());
        int iF = this.f20014f8.F();
        gridView.setAdapter((ListAdapter) (iF > 0 ? new com.google.android.material.datepicker.i(iF) : new com.google.android.material.datepicker.i()));
        gridView.setNumColumns(monthT.f20084d);
        gridView.setEnabled(false);
        this.f20019k8 = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_months);
        this.f20019k8.setLayoutManager(new c(X1(), i11, false, i11));
        this.f20019k8.setTag(f20008s8);
        m mVar = new m(contextThemeWrapper, this.f20013e8, this.f20014f8, new d());
        this.f20019k8.setAdapter(mVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f20018j8 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f20018j8.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f20018j8.setAdapter(new s(this));
            this.f20018j8.n(Q5());
        }
        if (viewInflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            P5(viewInflate, mVar);
        }
        if (!MaterialDatePicker.z6(contextThemeWrapper)) {
            new x().b(this.f20019k8);
        }
        this.f20019k8.D1(mVar.o(this.f20015g8));
        return viewInflate;
    }

    public final void P5(@n0 View view, @n0 m mVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(f20011v8);
        u0.B1(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(f20009t8);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(f20010u8);
        this.f20020l8 = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f20021m8 = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        a6(CalendarSelector.DAY);
        materialButton.setText(this.f20015g8.T());
        this.f20019k8.r(new g(mVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(mVar));
        materialButton2.setOnClickListener(new j(mVar));
    }

    @n0
    public final RecyclerView.n Q5() {
        return new e();
    }

    @p0
    public CalendarConstraints R5() {
        return this.f20014f8;
    }

    public com.google.android.material.datepicker.b S5() {
        return this.f20017i8;
    }

    @p0
    public Month T5() {
        return this.f20015g8;
    }

    @n0
    public LinearLayoutManager W5() {
        return (LinearLayoutManager) this.f20019k8.getLayoutManager();
    }

    public final void Y5(int i10) {
        this.f20019k8.post(new a(i10));
    }

    public void Z5(Month month) {
        m mVar = (m) this.f20019k8.getAdapter();
        int iO = mVar.o(month);
        int iO2 = iO - mVar.o(this.f20015g8);
        boolean z10 = Math.abs(iO2) > 3;
        boolean z11 = iO2 > 0;
        this.f20015g8 = month;
        if (z10 && z11) {
            this.f20019k8.D1(iO - 3);
            Y5(iO);
        } else if (!z10) {
            Y5(iO);
        } else {
            this.f20019k8.D1(iO + 3);
            Y5(iO);
        }
    }

    public void a6(CalendarSelector calendarSelector) {
        this.f20016h8 = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f20018j8.getLayoutManager().R1(((s) this.f20018j8.getAdapter()).n(this.f20015g8.f20083c));
            this.f20020l8.setVisibility(0);
            this.f20021m8.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.f20020l8.setVisibility(8);
            this.f20021m8.setVisibility(0);
            Z5(this.f20015g8);
        }
    }

    public void b6() {
        CalendarSelector calendarSelector = this.f20016h8;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            a6(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            a6(calendarSelector2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void g4(@n0 Bundle bundle) {
        super.g4(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f20012d8);
        bundle.putParcelable(f20004o8, this.f20013e8);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f20014f8);
        bundle.putParcelable(f20006q8, this.f20015g8);
    }
}

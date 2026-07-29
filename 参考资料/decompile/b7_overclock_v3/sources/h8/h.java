package h8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.l1;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l1 f30704e;

    public static final class a implements FloatViewTwoSeekBarView.d {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewTwoSeekBarView.d
        public void a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewTwoSeekBarView.d
        public void b() {
            h hVar = h.this;
            String str = h.this.a().getString(R.string.floatview_reverse) + h.this.a().getString(R.string.floatview_introduction);
            String string = h.this.a().getString(R.string.floatview_property_reverse_help_vertical);
            f0.o(string, "context.getString(R.stri…ty_reverse_help_vertical)");
            hVar.j(str, string);
        }

        @Override // com.flydigi.float_view.widget.FloatViewTwoSeekBarView.d
        public void c() {
            h hVar = h.this;
            String str = h.this.a().getString(R.string.floatview_reverse) + h.this.a().getString(R.string.floatview_introduction);
            String string = h.this.a().getString(R.string.floatview_property_reverse_help_horizontal);
            f0.o(string, "context.getString(R.stri…_reverse_help_horizontal)");
            hVar.j(str, string);
        }
    }

    public static final class b implements FloatViewSingleSeekBarView.c {
        public b() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleSeekBarView.c
        public void a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleSeekBarView.c
        public void b() {
            h hVar = h.this;
            String str = h.this.a().getString(R.string.floatview_property_lock_duration) + h.this.a().getString(R.string.floatview_introduction);
            String string = h.this.a().getString(R.string.floatview_property_lock_view_help);
            f0.o(string, "context.getString(R.stri…_property_lock_view_help)");
            hVar.j(str, string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_motion_view);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 35;
        l1 l1Var = this.f30704e;
        l1 l1Var2 = null;
        if (l1Var == null) {
            f0.S("viewBinding");
            l1Var = null;
        }
        Pair<Integer, Integer> value = l1Var.f54252d.getValue();
        cFGPropertyKey.senty_x = value.f().intValue();
        cFGPropertyKey.senty_y = value.h().intValue();
        l1 l1Var3 = this.f30704e;
        if (l1Var3 == null) {
            f0.S("viewBinding");
            l1Var3 = null;
        }
        Pair<Boolean, Boolean> checkBoxValue = l1Var3.f54252d.getCheckBoxValue();
        if (checkBoxValue.f().booleanValue()) {
            cFGPropertyKey.senty_x = -cFGPropertyKey.senty_x;
        }
        if (checkBoxValue.h().booleanValue()) {
            cFGPropertyKey.senty_y = -cFGPropertyKey.senty_y;
        }
        l1 l1Var4 = this.f30704e;
        if (l1Var4 == null) {
            f0.S("viewBinding");
        } else {
            l1Var2 = l1Var4;
        }
        cFGPropertyKey.duration = nk.d.L0(l1Var2.f54251c.getValue() * 3.33f);
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        l1 l1VarA = l1.a(view);
        f0.o(l1VarA, "bind(view)");
        this.f30704e = l1VarA;
        l1 l1Var = null;
        if (l1VarA == null) {
            f0.S("viewBinding");
            l1VarA = null;
        }
        l1VarA.f54252d.setOnHelpClickListener$float_view_officialRelease(new a());
        l1 l1Var2 = this.f30704e;
        if (l1Var2 == null) {
            f0.S("viewBinding");
        } else {
            l1Var = l1Var2;
        }
        l1Var.f54251c.setOnHelpClickListener$float_view_officialRelease(new b());
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        l1 l1Var = this.f30704e;
        l1 l1Var2 = null;
        if (l1Var == null) {
            f0.S("viewBinding");
            l1Var = null;
        }
        l1Var.f54252d.m0(Math.abs(pkey.senty_x), Math.abs(pkey.senty_y), pkey.senty_x < 0, pkey.senty_y < 0);
        l1 l1Var3 = this.f30704e;
        if (l1Var3 == null) {
            f0.S("viewBinding");
        } else {
            l1Var2 = l1Var3;
        }
        l1Var2.f54251c.setValue(nk.d.L0(pkey.duration / 3.33f));
    }

    @Override // d8.a
    public void g() {
        l1 l1Var = this.f30704e;
        l1 l1Var2 = null;
        if (l1Var == null) {
            f0.S("viewBinding");
            l1Var = null;
        }
        l1Var.f54252d.k0();
        l1 l1Var3 = this.f30704e;
        if (l1Var3 == null) {
            f0.S("viewBinding");
        } else {
            l1Var2 = l1Var3;
        }
        l1Var2.f54251c.U();
    }
}

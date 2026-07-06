package com.omarea.ui;

import a.b62;
import a.bc2;
import a.d72;
import a.e50;
import a.ec2;
import a.f92;
import a.fa0;
import a.fg2;
import a.g82;
import a.g92;
import a.h42;
import a.hf2;
import a.hl0;
import a.i92;
import a.j92;
import a.k82;
import a.k92;
import a.kd;
import a.l92;
import a.m42;
import a.oc2;
import a.q92;
import a.qc2;
import a.qe2;
import a.r62;
import a.s60;
import a.t61;
import a.t62;
import a.u42;
import a.u61;
import a.v21;
import a.v61;
import a.wd2;
import a.x62;
import a.zu;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.omarea.Scene;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class BatteryRealtimeStatus extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hl0 f8373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f4829a;

    @x62(c = "com.omarea.ui.BatteryRealtimeStatus$initOnce$1", f = "BatteryRealtimeStatus.kt", l = {70}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8374a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4831a;
        public int b;
        public int c;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = BatteryRealtimeStatus.this.new a(b62Var);
            aVar.f8374a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.c;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8374a;
                int iK = BatteryRealtimeStatus.this.f8373a.k();
                if (iK > -1) {
                    fg2 fg2VarC = qe2.c();
                    v21 v21Var = new v21(this, iK, null);
                    this.f4831a = wd2Var;
                    this.b = iK;
                    this.c = 1;
                    if (oc2.g(fg2VarC, v21Var, this) == objC) {
                        return objC;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g82 f8375a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ i92 f4832a;

        public b(g82 g82Var, i92 i92Var) {
            this.f8375a = g82Var;
            this.f4832a = i92Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8375a.f(Boolean.valueOf(!this.f4832a.b));
            view.setKeepScreenOn(this.f4832a.b);
        }
    }

    public static final class c extends g92 implements g82<Boolean, m42> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i92 f8376a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f4834a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i92 i92Var, boolean z, String str) {
            super(1);
            this.f8376a = i92Var;
            this.b = z;
            this.f4834a = str;
        }

        public final void a(boolean z) {
            ColorStateList colorStateList;
            this.f8376a.b = z;
            ImageView imageView = (ImageView) BatteryRealtimeStatus.this.a(t61.charge_display_light);
            Drawable drawable = BatteryRealtimeStatus.this.getContext().getDrawable(2131230932);
            f92.b(drawable);
            Drawable drawableMutate = drawable.mutate();
            f92.c(drawableMutate, "context.getDrawable(R.dr…able.ic_light)!!.mutate()");
            Drawable drawableR = kd.r(drawableMutate);
            if (this.f8376a.b) {
                colorStateList = BatteryRealtimeStatus.this.getResources().getColorStateList(2131099700);
                f92.c(colorStateList, "resources.getColorStateList(R.color.colorAccent)");
                f92.c(imageView, "img");
                imageView.setAlpha(1.0f);
                Scene.c cVar = Scene.f4798a;
                String string = BatteryRealtimeStatus.this.getContext().getString(u61.charge_display_keep);
                f92.c(string, "context.getString(R.string.charge_display_keep)");
                Scene.c.p(cVar, string, 0, 2, null);
            } else {
                colorStateList = BatteryRealtimeStatus.this.getResources().getColorStateList(R.color.darker_gray);
                f92.c(colorStateList, "resources.getColorStateL…roid.R.color.darker_gray)");
                f92.c(imageView, "img");
                imageView.setAlpha(0.3f);
            }
            kd.o(drawableR, colorStateList);
            imageView.setImageDrawable(drawableR);
            if (this.b) {
                s60 s60Var = s60.f7366a;
                StringBuilder sb = new StringBuilder();
                sb.append(bc2.t(this.f4834a, " get ", " put ", false, 4, null));
                sb.append(this.f8376a.b ? " 15" : " 0");
                s60Var.c(sb.toString());
            }
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(Boolean bool) {
            a(bool.booleanValue());
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.ui.BatteryRealtimeStatus$updateUI$2", f = "BatteryRealtimeStatus.kt", l = {}, m = "invokeSuspend")
    public static final class d extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i92 f8377a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ j92 f4835a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ k92 f4836a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ l92 f4837a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f4838a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ j92 f4840b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i92 i92Var, k92 k92Var, l92 l92Var, j92 j92Var, j92 j92Var2, b62 b62Var) {
            super(2, b62Var);
            this.f8377a = i92Var;
            this.f4836a = k92Var;
            this.f4837a = l92Var;
            this.f4835a = j92Var;
            this.f4840b = j92Var2;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            d dVar = BatteryRealtimeStatus.this.new d(this.f8377a, this.f4836a, this.f4837a, this.f4835a, this.f4840b, b62Var);
            dVar.f4838a = (wd2) obj;
            return dVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((d) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            TextView textView;
            CharSequence string;
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            TextView textView2 = (TextView) BatteryRealtimeStatus.this.a(t61.charge_state);
            f92.c(textView2, "charge_state");
            Context context = BatteryRealtimeStatus.this.getContext();
            int iC = fa0.f867a.c();
            int i = u61.battery_status_unknown;
            if (iC != 1) {
                if (iC == 2) {
                    this.f8377a.b = true;
                    i = u61.battery_status_charging;
                } else if (iC == 3) {
                    i = u61.battery_status_discharging;
                } else if (iC == 4) {
                    i = u61.battery_status_not_charging;
                } else if (iC == 5) {
                    i = u61.battery_status_full;
                }
            }
            textView2.setText(context.getString(i));
            if (this.f4836a.f6587a > -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f4836a.f6587a);
                sb.append('%');
                String string2 = sb.toString();
                SpannableString spannableString = new SpannableString(string2);
                if (ec2.C(string2, ".", false, 2, null)) {
                    TextView textView3 = (TextView) BatteryRealtimeStatus.this.a(t61.battrystatus_level);
                    f92.c(textView3, "battrystatus_level");
                    spannableString.setSpan(new AbsoluteSizeSpan((int) (((double) textView3.getTextSize()) * 0.3d), false), ec2.N(string2, ".", 0, false, 6, null), ec2.S(string2, "%", 0, false, 6, null), 33);
                    TextView textView4 = (TextView) BatteryRealtimeStatus.this.a(t61.battrystatus_level);
                    f92.c(textView4, "battrystatus_level");
                    spannableString.setSpan(new AbsoluteSizeSpan((int) (((double) textView4.getTextSize()) * 0.5d), false), ec2.N(string2, "%", 0, false, 6, null), string2.length(), 33);
                }
                TextView textView5 = (TextView) BatteryRealtimeStatus.this.a(t61.battrystatus_level);
                f92.c(textView5, "battrystatus_level");
                string = spannableString;
                textView = textView5;
            } else {
                TextView textView6 = (TextView) BatteryRealtimeStatus.this.a(t61.battrystatus_level);
                f92.c(textView6, "battrystatus_level");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f4837a.f6687a);
                sb2.append('%');
                string = sb2.toString();
                textView = textView6;
            }
            textView.setText(string);
            TextView textView7 = (TextView) BatteryRealtimeStatus.this.a(t61.battery_size);
            f92.c(textView7, "battery_size");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(fa0.f867a.k()));
            sb3.append("mAh");
            sb3.append(" (≈");
            q92 q92Var = q92.f7191a;
            String str = String.format("%.1f", Arrays.copyOf(new Object[]{t62.c(fa0.f867a.l() / ((double) 1000))}, 1));
            f92.c(str, "java.lang.String.format(format, *args)");
            sb3.append(str);
            sb3.append("Wh)");
            textView7.setText(sb3.toString());
            TextView textView8 = (TextView) BatteryRealtimeStatus.this.a(t61.battery_temperature);
            f92.c(textView8, "battery_temperature");
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.f4835a.f6490a);
            sb4.append((char) 8451);
            textView8.setText(sb4.toString());
            TextView textView9 = (TextView) BatteryRealtimeStatus.this.a(t61.battery_status);
            f92.c(textView9, "battery_status");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f4840b.f6490a);
            sb5.append('v');
            textView9.setText(sb5.toString());
            TextView textView10 = (TextView) BatteryRealtimeStatus.this.a(t61.battery_power);
            f92.c(textView10, "battery_power");
            textView10.setText(fa0.f867a.n());
            TextView textView11 = (TextView) BatteryRealtimeStatus.this.a(t61.battery_charge_power);
            f92.c(textView11, "battery_charge_power");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("");
            sb6.append(this.f8377a.b ? fa0.f867a.f() : "--");
            textView11.setText(sb6.toString());
            ((BatteryView) BatteryRealtimeStatus.this.a(t61.battery_capacity_chart)).c(100.0f, 100.0f - this.f4837a.f6687a, (float) this.f4835a.f6490a);
            return m42.f6769a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatteryRealtimeStatus(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        this.f8373a = new hl0();
        d(context, attributeSet);
    }

    public View a(int i) {
        if (this.f4829a == null) {
            this.f4829a = new HashMap();
        }
        View view = (View) this.f4829a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f4829a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void c() {
        qc2.d(hf2.f6309a, qe2.b(), null, new a(null), 2, null);
        boolean zK = u42.k(new String[]{"root", "adb"}, e50.f677a.y0());
        i92 i92Var = new i92();
        boolean z = false;
        i92Var.b = false;
        c cVar = new c(i92Var, zK, "settings get global stay_on_while_plugged_in");
        if (zK) {
            String strC = s60.f7366a.c("settings get global stay_on_while_plugged_in");
            if (!(strC.length() == 0) && !f92.a(strC, "0")) {
                z = true;
            }
            cVar.f(Boolean.valueOf(z));
        }
        ((ImageView) a(t61.charge_display_light)).setOnClickListener(new b(cVar, i92Var));
    }

    public final void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.NavItem);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…trs, R.styleable.NavItem)");
        LayoutInflater.from(context).inflate(2131558602, (ViewGroup) this, true);
        typedArrayObtainStyledAttributes.recycle();
        c();
    }

    public final Object e(b62<? super m42> b62Var) {
        l92 l92Var = new l92();
        l92Var.f6687a = fa0.f867a.a();
        j92 j92Var = new j92();
        j92Var.f6490a = fa0.f867a.o();
        k92 k92Var = new k92();
        k92Var.f6587a = this.f8373a.l(l92Var.f6687a);
        j92 j92Var2 = new j92();
        j92Var2.f6490a = fa0.f867a.p();
        i92 i92Var = new i92();
        i92Var.b = false;
        Object objG = oc2.g(qe2.c(), new d(i92Var, k92Var, l92Var, j92Var, j92Var2, null), b62Var);
        return objG == r62.c() ? objG : m42.f6769a;
    }

    public final int getColorAccent() {
        TypedValue typedValue = new TypedValue();
        Context context = getContext();
        f92.c(context, "this.context");
        context.getTheme().resolveAttribute(zu.colorAccent, typedValue, true);
        return typedValue.data;
    }
}

package com.flydigi.float_view.ui.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import eu.davidea.flexibleadapter.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.greenrobot.eventbus.ThreadMode;
import top.androidman.SuperButton;
import v7.a;
import w.w;
import z7.j;

/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"ClickableViewAccessibility"})
public class h2 extends y7.b implements View.OnClickListener {
    public static final int[] U7 = {235, MediaSessionCompat.M, a.c.D, 490, 575, 660, 745, 830, 915, 1000, 235, MediaSessionCompat.M, a.c.D, 490, 575, 660, 745, 830, 915, 1000, 235, MediaSessionCompat.M, a.c.D, 490, 575, 660, 745, 830, 915, 1000, 235, MediaSessionCompat.M, a.c.D, 490, 575, 660, 745, 830, 915, 1000, 235, MediaSessionCompat.M, a.c.D, 490, 575, 660, 745, 830, 915, 1000, 235, MediaSessionCompat.M, a.c.D, 490, 575, 660, 745, 830, 915, 1000};
    public static final int[] V7 = {180, 180, 180, 180, 180, 180, 180, 180, 180, 180, 240, 240, 240, 240, 240, 240, 240, 240, 240, 240, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 360, 360, 360, 360, 360, 360, 360, 360, 360, 360, w.c.f53698r, w.c.f53698r, w.c.f53698r, w.c.f53698r, w.c.f53698r, w.c.f53698r, w.c.f53698r, w.c.f53698r, w.c.f53698r, w.c.f53698r, 480, 480, 480, 480, 480, 480, 480, 480, 480, 480};
    public final ArrayList<o8.b> A;
    public o8.b B;
    public int C;
    public float C1;
    public TextView C2;
    public int D;
    public RecyclerView E7;
    public eu.davidea.flexibleadapter.b<MacroEffectTypeItem> F7;
    public View G7;
    public final int H7;
    public final String I7;
    public float J7;
    public CFGPropertyMacro K0;
    public final int K1;
    public SuperButton K2;
    public float K7;
    public long L7;
    public float M7;
    public float N7;
    public float O7;
    public float P7;
    public boolean Q7;
    public final View.OnTouchListener R7;
    public final Handler S7;
    public boolean T7;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public j8.b f15627k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f15628k1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FrameLayout f15629p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f15630q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SuperButton f15631r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SuperButton f15632s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f15633t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SuperButton f15634u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SuperButton f15635v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f15636v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public View f15637v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f15638w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f15639x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f15640y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f15641z;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            h2.this.E7.setVisibility(8);
            o8.b bVar = (o8.b) view;
            int action = motionEvent.getAction();
            if (action == 0) {
                if (h2.this.B != null && h2.this.B != bVar) {
                    h2.this.B.setUIFocus(false);
                }
                h2.this.L7 = System.currentTimeMillis();
                h2.this.M7 = motionEvent.getRawX();
                h2.this.N7 = motionEvent.getRawY();
                h2.this.O7 = motionEvent.getRawX() - view.getX();
                h2.this.P7 = motionEvent.getRawY() - view.getY();
                h2.this.t0(bVar);
                h2.this.H0(true);
                h2.this.G0((motionEvent.getRawX() - h2.this.O7) + (bVar.getWidth() / 2.0f), (motionEvent.getRawY() - h2.this.P7) + (bVar.getHeight() / 2.0f));
                h2.this.f15629p.removeView(view);
                h2.this.f15629p.addView(view);
            } else if (action == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if ((Math.abs(motionEvent.getRawX() - h2.this.M7) < h2.this.C1 * 5.0f && Math.abs(motionEvent.getRawY() - h2.this.N7) < h2.this.C1 * 5.0f && jCurrentTimeMillis - h2.this.L7 < 500) || h2.this.Q7) {
                    h2.this.B = bVar;
                }
                if (!h2.this.Q7 && bVar.a()) {
                    h2.this.L0(bVar);
                }
                bVar.setUIFocus(true);
                h2.this.f15629p.removeView(h2.this.f15630q);
                h2.this.f15629p.addView(h2.this.f15630q);
                h2.this.f15630q.setVisibility(0);
                h2.this.J0(bVar, true);
                h2.this.Q7 = false;
            } else if (action == 2) {
                if (!h2.this.Q7 && (Math.abs((motionEvent.getRawX() - view.getX()) - h2.this.O7) > 5.0f || Math.abs((motionEvent.getRawY() - view.getY()) - h2.this.P7) > 5.0f)) {
                    h2.this.Q7 = true;
                    h2.this.f15630q.setVisibility(8);
                }
                float rawX = (motionEvent.getRawX() - h2.this.O7) + (bVar.getWidth() / 2.0f);
                float rawY = (motionEvent.getRawY() - h2.this.P7) + (bVar.getHeight() / 2.0f);
                if (0.0f < rawX && rawX < h2.this.C && 0.0f < rawY && rawY < h2.this.D) {
                    bVar.setX(motionEvent.getRawX() - h2.this.O7);
                    bVar.setY(motionEvent.getRawY() - h2.this.P7);
                    h2.this.G0(rawX, rawY);
                }
            }
            return false;
        }
    }

    public class b implements j.a {
        public b() {
        }

        @Override // z7.j.a
        public void a() {
            h2.this.q(22);
            u9.h.k(h2.this.f56478a, h2.this.I7, "FloatView_Setting_Config_Macro_Cancel", "悬浮窗_宏_取消");
        }

        @Override // z7.j.a
        public void b(boolean z10) {
            if (h2.this.A.size() == 0) {
                n8.b.m(h2.this.f56478a, h2.this.f56478a.getString(R.string.floatview_property_key_macro_key_atleast_one));
                return;
            }
            h2 h2Var = h2.this;
            h2Var.t(23, h2Var.K0);
            u9.h.k(h2.this.f56478a, h2.this.I7, "FloatView_Setting_Config_Macro_Save", "悬浮窗_宏_保存");
        }
    }

    public h2(Context context, Handler handler, CFGPropertyMacro cFGPropertyMacro, GamepadInfo gamepadInfo, String str) {
        super(context, null, handler, gamepadInfo);
        this.A = new ArrayList<>();
        this.B = null;
        this.f15627k0 = null;
        this.f15628k1 = 0;
        this.f15636v1 = 0;
        this.J7 = 0.0f;
        this.K7 = 0.0f;
        this.L7 = 0L;
        this.M7 = 0.0f;
        this.N7 = 0.0f;
        this.O7 = 0.0f;
        this.P7 = 0.0f;
        this.R7 = new a();
        this.S7 = new Handler(new Handler.Callback() { // from class: com.flydigi.float_view.ui.config.b2
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f15592a.D0(message);
            }
        });
        this.T7 = false;
        this.I7 = str;
        String firmwareVersion = gamepadInfo.getFirmwareVersion();
        Objects.requireNonNull(firmwareVersion);
        if (l9.c.b(m9.k.f40818d, firmwareVersion)) {
            this.K1 = 60;
        } else {
            this.K1 = 40;
        }
        this.K0 = cFGPropertyMacro.copy();
        this.H7 = cFGPropertyMacro.hashCode();
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean A0(View view, MotionEvent motionEvent) {
        this.E7.setVisibility(8);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.J7 = motionEvent.getRawX() - this.f15630q.getX();
            this.K7 = motionEvent.getRawY() - this.f15630q.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        if ((motionEvent.getRawX() - this.J7 > 0.0f && motionEvent.getRawX() - this.J7 < this.C - this.f15630q.getWidth() && motionEvent.getRawY() - this.K7 > 0.0f) || motionEvent.getRawY() - this.K7 < this.D - this.f15630q.getHeight()) {
            this.f15630q.setX(motionEvent.getRawX() - this.J7);
            this.f15630q.setY(motionEvent.getRawY() - this.K7);
        }
        if (motionEvent.getRawX() - this.J7 < 0.0f || motionEvent.getRawX() - this.J7 > this.C - this.f15630q.getWidth()) {
            this.f15630q.setY(motionEvent.getRawY() - this.K7);
        }
        if (motionEvent.getRawY() - this.K7 < 0.0f || motionEvent.getRawY() - this.K7 > this.D - this.f15630q.getHeight()) {
            this.f15630q.setX(motionEvent.getRawX() - this.J7);
        }
        if (this.f15630q.getX() < 0.0f) {
            this.f15630q.setX(0.0f);
        } else if (this.f15630q.getX() > this.C - this.f15630q.getWidth()) {
            this.f15630q.setX(this.C - r4.getWidth());
        } else {
            this.f15630q.setX(motionEvent.getRawX() - this.J7);
        }
        if (this.f15630q.getY() < 0.0f) {
            this.f15630q.setY(0.0f);
            return false;
        }
        if (this.f15630q.getY() <= this.D - this.f15630q.getHeight()) {
            this.f15630q.setY(motionEvent.getRawY() - this.K7);
            return false;
        }
        this.f15630q.setY(this.D - r4.getHeight());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(View view) {
        this.G7.setVisibility(8);
        this.T7 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0() {
        this.C = this.f15629p.getWidth();
        this.D = this.f15629p.getHeight();
        this.C1 = n8.b.k(this.C);
        w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean D0(Message message) {
        if (message.what == 101) {
            CFGSubPropertyMacro cFGSubPropertyMacro = (CFGSubPropertyMacro) message.obj;
            if (this.B != null) {
                com.flydigi.userBehavior.a.a().b(this.f56478a, "悬浮窗_宏属性设置_" + com.flydigi.sdk.gamepad.extension.a.i(this.K0.key_id, this.f56484g.getDeviceMode()) + "_保存" + this.f56478a.getString(n8.b.i(cFGSubPropertyMacro.getType())));
                this.B.setPropertyMacro(cFGSubPropertyMacro);
                this.B.setReset(false);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(View view) {
        float measuredWidth;
        int[] iArr = new int[2];
        View viewFindViewById = this.f15638w.findViewById(R.id.iv_indicator_down);
        View viewFindViewById2 = this.f15638w.findViewById(R.id.iv_indicator_left);
        View viewFindViewById3 = this.f15638w.findViewById(R.id.iv_indicator_right);
        view.getLocationOnScreen(iArr);
        int measuredWidth2 = this.f15638w.getMeasuredWidth();
        float measuredWidth3 = iArr[0] - ((measuredWidth2 - view.getMeasuredWidth()) / 2.0f);
        if (iArr[1] < this.f15638w.getMeasuredHeight() || measuredWidth3 < 0.0f || measuredWidth3 + measuredWidth2 > this.C) {
            float measuredHeight = iArr[1] - ((r5 - view.getMeasuredHeight()) / 2.0f);
            this.f15638w.setY(measuredHeight >= 0.0f ? measuredHeight : 0.0f);
            if (iArr[0] + view.getMeasuredWidth() + this.f15638w.getMeasuredWidth() > this.C) {
                measuredWidth = iArr[0] - this.f15638w.getMeasuredWidth();
                viewFindViewById3.setVisibility(0);
                viewFindViewById2.setVisibility(4);
            } else {
                measuredWidth = iArr[0] + view.getMeasuredWidth();
                viewFindViewById3.setVisibility(4);
                viewFindViewById2.setVisibility(0);
            }
            this.f15638w.setX(measuredWidth);
            viewFindViewById.setVisibility(4);
        } else {
            this.f15638w.setX(iArr[0] - ((measuredWidth2 - view.getMeasuredWidth()) / 2.0f));
            this.f15638w.setY(iArr[1] - r5);
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(4);
            viewFindViewById3.setVisibility(4);
        }
        this.f15629p.removeView(this.f15638w);
        this.f15629p.addView(this.f15638w);
        this.f15629p.removeView(this.f15630q);
        this.f15629p.addView(this.f15630q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean z0(View view, int i10) {
        if (i10 == -1) {
            return false;
        }
        this.K0.type = ((MacroEffectTypeItem) this.F7.g2(i10)).z().intValue();
        M0();
        this.E7.setVisibility(8);
        return false;
    }

    public final void F0() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.A.size(); i11++) {
            o8.b bVar = this.A.get(i11);
            if (bVar.getVisibility() == 0) {
                i10++;
                bVar.setNumber(i10);
            }
        }
    }

    public final void G0(float f10, float f11) {
        this.f15640y.setY(f11);
        this.f15641z.setX(f10);
    }

    public void H(byte[] bArr) {
        if (this.T7) {
            List<Integer> listV0 = m9.b.v0(bArr, this.f56484g);
            if (listV0.size() != 0) {
                this.T7 = false;
                int iIntValue = listV0.get(0).intValue();
                CFGPropertyMacro cFGPropertyMacro = this.K0;
                if (iIntValue == cFGPropertyMacro.key_id) {
                    Context context = this.f56478a;
                    n8.b.m(context, context.getString(R.string.floatview_property_macro_key_cannot_set_as_cancel));
                    this.G7.setVisibility(8);
                    return;
                }
                cFGPropertyMacro.key_id_cancel = listV0.get(0).intValue();
                this.K0.key_cancel = com.flydigi.sdk.gamepad.extension.a.i(listV0.get(0).intValue(), this.f56484g.getDeviceMode());
                this.f15632s.setIconColor(0);
                this.f15632s.setIcon(com.flydigi.sdk.gamepad.extension.a.k(this.f56478a, listV0.get(0).intValue(), this.f56484g, false));
                this.f15633t.setVisibility(0);
                this.G7.setVisibility(8);
            }
        }
    }

    public final void H0(boolean z10) {
        if (!z10) {
            this.f15640y.setVisibility(4);
            this.f15641z.setVisibility(4);
            return;
        }
        this.f15640y.setVisibility(0);
        this.f15641z.setVisibility(0);
        this.f15629p.removeView(this.f15640y);
        this.f15629p.removeView(this.f15641z);
        this.f15629p.addView(this.f15640y);
        this.f15629p.addView(this.f15641z);
    }

    public final void I0(CFGSubPropertyMacro cFGSubPropertyMacro, String str) {
        j8.b bVar = this.f15627k0;
        if (bVar == null) {
            this.f15627k0 = new j8.b(this.f56478a, this.S7, cFGSubPropertyMacro, str, this.f56484g);
        } else {
            bVar.y();
            this.f15627k0.J(cFGSubPropertyMacro, str);
        }
    }

    public final void J0(final View view, boolean z10) {
        if (!z10) {
            this.f15638w.setVisibility(8);
        } else {
            this.f15638w.setVisibility(0);
            this.f15638w.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.g2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15620a.E0(view);
                }
            });
        }
    }

    public final void K0() {
        Context context = this.f56478a;
        new z7.j(context, 2, "", context.getString(R.string.floatview_change_not_saved), this.f56478a.getString(R.string.floatview_save), this.f56478a.getString(R.string.floatview_discard_change), new b());
    }

    public final void L0(o8.b bVar) {
        CFGSubPropertyMacro propertyMacro = bVar.getPropertyMacro();
        com.flydigi.userBehavior.a aVarA = com.flydigi.userBehavior.a.a();
        Context context = this.f56478a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("悬浮窗_宏属性设置_");
        CFGPropertyMacro cFGPropertyMacro = this.K0;
        sb2.append(com.flydigi.sdk.gamepad.extension.a.j(cFGPropertyMacro.key_id, cFGPropertyMacro.comboKeyFirst, cFGPropertyMacro.comboKeySecond, this.f56484g.getDeviceMode()));
        sb2.append("_");
        sb2.append(this.f56478a.getString(n8.b.i(bVar.getPropertyMacro().getType())));
        aVarA.b(context, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        Context context2 = this.f56478a;
        CFGPropertyMacro cFGPropertyMacro2 = this.K0;
        sb3.append(n8.b.g(context2, cFGPropertyMacro2.key_id, cFGPropertyMacro2.comboKeyFirst, cFGPropertyMacro2.comboKeySecond, this.f56484g.getDeviceMode(), this.f56484g.getDeviceType()));
        sb3.append("-");
        sb3.append(bVar.getNumber());
        I0(propertyMacro, sb3.toString());
    }

    public final void M0() {
        int i10 = this.K0.type;
        if (i10 == 0) {
            this.C2.setText(this.f56478a.getString(R.string.floatview_property_macro_key_trigger_mode_pressed));
            this.K2.setIcon(h0.d.i(this.f56478a, R.drawable.ic_press));
        } else if (i10 == 1) {
            this.C2.setText(this.f56478a.getString(R.string.floatview_property_macro_key_trigger_mode_released));
            this.K2.setIcon(h0.d.i(this.f56478a, R.drawable.ic_release));
        } else if (i10 == 2) {
            this.C2.setText(this.f56478a.getString(R.string.floatview_property_macro_key_trigger_mode_hold));
            this.K2.setIcon(h0.d.i(this.f56478a, R.drawable.ic_circle));
        }
    }

    @Override // y7.b
    public void g() {
        super.g();
        FrameLayout frameLayout = new FrameLayout(this.f56478a);
        this.f15629p = frameLayout;
        this.f56479b = frameLayout;
        frameLayout.setBackgroundResource(R.color.transparent_black);
        this.f56479b.setOnClickListener(this);
        u();
    }

    @Override // y7.b
    public void h() {
        super.h();
        u0();
    }

    @Override // y7.b
    public int i() {
        return 0;
    }

    @Override // y7.b
    public void l() {
        super.l();
        u0();
    }

    @Override // y7.b
    public void n() {
        this.f15630q = View.inflate(this.f56478a, R.layout.floatview_layout_setting_macro, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        this.f15630q.setLayoutParams(layoutParams);
        this.f15629p.addView(this.f15630q);
        this.f15639x = (TextView) this.f15630q.findViewById(R.id.tv_key_count);
        SuperButton superButton = (SuperButton) this.f15630q.findViewById(R.id.btn_add);
        this.f15631r = superButton;
        superButton.setOnClickListener(this);
        SuperButton superButton2 = (SuperButton) this.f15630q.findViewById(R.id.btn_cancel_key);
        this.f15632s = superButton2;
        superButton2.setOnClickListener(this);
        View viewFindViewById = this.f15630q.findViewById(R.id.iv_cancel_key_delete);
        this.f15633t = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        SuperButton superButton3 = (SuperButton) this.f15630q.findViewById(R.id.btn_cancel);
        this.f15634u = superButton3;
        superButton3.setOnClickListener(this);
        SuperButton superButton4 = (SuperButton) this.f15630q.findViewById(R.id.btn_apply);
        this.f15635v = superButton4;
        superButton4.setOnClickListener(this);
        y0();
        x0();
        this.f15638w = View.inflate(this.f56478a, R.layout.floatview_layout_setting_config_key_menu, null);
        this.f15638w.setLayoutParams(new ConstraintLayout.b(-2, -2));
        this.f15638w.setVisibility(8);
        com.blankj.utilcode.util.o.r(this.f15638w.findViewById(R.id.btn_delete), this);
        com.blankj.utilcode.util.o.r(this.f15638w.findViewById(R.id.btn_setting), this);
        this.f15629p.addView(this.f15638w);
        FrameLayout frameLayout = this.f15629p;
        View view = this.f15638w;
        frameLayout.updateViewLayout(view, view.getLayoutParams());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.blankj.utilcode.util.b1.b(1.0f));
        View view2 = new View(this.f56478a);
        this.f15640y = view2;
        Resources resources = this.f56478a.getResources();
        int i10 = R.color.lib_color_11;
        view2.setBackgroundColor(resources.getColor(i10));
        this.f15640y.setLayoutParams(layoutParams2);
        this.f15640y.setVisibility(4);
        this.f15629p.addView(this.f15640y);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.blankj.utilcode.util.b1.b(1.0f), -1);
        View view3 = new View(this.f56478a);
        this.f15641z = view3;
        view3.setBackgroundColor(this.f56478a.getResources().getColor(i10));
        this.f15641z.setLayoutParams(layoutParams3);
        this.f15641z.setVisibility(4);
        this.f15629p.addView(this.f15641z);
        View viewInflate = View.inflate(this.f56478a, R.layout.floatview_widget_key_listen, null);
        this.G7 = viewInflate;
        ((TextView) viewInflate.findViewById(R.id.wait_click_text)).setText(n8.b.l(this.f56478a, this.f56484g.getDeviceMode()));
        this.G7.setOnClickListener(this);
        this.G7.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                this.f15596a.B0(view4);
            }
        });
        this.G7.setVisibility(8);
        this.f15629p.addView(this.G7);
        FrameLayout frameLayout2 = this.f15629p;
        View view4 = this.G7;
        frameLayout2.updateViewLayout(view4, view4.getLayoutParams());
        this.f15629p.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.f2
            @Override // java.lang.Runnable
            public final void run() {
                this.f15616a.C0();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.E7.setVisibility(8);
        if (view == this.f56479b) {
            s0();
            H0(false);
            this.T7 = false;
            return;
        }
        if (view == this.f15631r) {
            if (this.f15636v1 < this.f15628k1) {
                r0();
                return;
            } else {
                Context context = this.f56478a;
                n8.b.m(context, String.format(context.getString(R.string.max__marco), Integer.valueOf(this.K1)));
                return;
            }
        }
        SuperButton superButton = this.f15632s;
        if (view == superButton || view == this.f15633t) {
            CFGPropertyMacro cFGPropertyMacro = this.K0;
            if (cFGPropertyMacro.key_id_cancel == 255) {
                this.T7 = true;
                this.G7.setVisibility(0);
                this.f15629p.removeView(this.G7);
                this.f15629p.addView(this.G7);
                return;
            }
            cFGPropertyMacro.key_id_cancel = 255;
            cFGPropertyMacro.key_cancel = "";
            superButton.setIconColor(-1);
            this.f15632s.setIcon(h0.d.i(this.f56478a, R.drawable.ic_stop));
            this.f15633t.setVisibility(8);
            return;
        }
        View view2 = this.f15637v2;
        if (view == view2) {
            view2.getLocationOnScreen(new int[2]);
            this.E7.getLayoutParams().width = this.f15637v2.getMeasuredWidth();
            this.E7.setX(r9[0]);
            this.E7.setY(r9[1] + this.f15637v2.getMeasuredHeight());
            this.E7.setVisibility(0);
            this.f15629p.removeView(this.E7);
            this.f15629p.addView(this.E7);
            return;
        }
        if (view == this.f15634u) {
            this.K0.macro_keys.clear();
            for (int i10 = 0; i10 < this.A.size(); i10++) {
                o8.b bVar = this.A.get(i10);
                CFGSubPropertyMacro propertyMacro = bVar.getPropertyMacro();
                propertyMacro.setX((bVar.getX() + (bVar.getWidth() / 2.0f)) / this.C);
                propertyMacro.setY((bVar.getY() + (bVar.getHeight() / 2.0f)) / this.D);
                this.K0.macro_keys.add(propertyMacro);
            }
            if (com.blankj.utilcode.util.n0.z(this.K0.macro_keys)) {
                CFGPropertyMacro cFGPropertyMacro2 = this.K0;
                int i11 = cFGPropertyMacro2.type;
                if (i11 == 0 || i11 == 1) {
                    ArrayList<CFGSubPropertyMacro> arrayList = cFGPropertyMacro2.macro_keys;
                    arrayList.get(arrayList.size() - 1).setNextVKey(0);
                } else if (i11 == 2) {
                    ArrayList<CFGSubPropertyMacro> arrayList2 = cFGPropertyMacro2.macro_keys;
                    arrayList2.get(arrayList2.size() - 1).setNextVKey(1);
                }
            }
            if (this.H7 != this.K0.hashCode()) {
                K0();
                return;
            } else {
                q(22);
                u9.h.k(this.f56478a, this.I7, "FloatView_Setting_Config_Macro_Cancel", "悬浮窗_宏_取消");
                return;
            }
        }
        if (view != this.f15635v) {
            if (view.getId() == R.id.btn_setting) {
                o8.b bVar2 = this.B;
                if (bVar2 != null) {
                    L0(bVar2);
                    return;
                }
                return;
            }
            if (view.getId() == R.id.btn_delete) {
                if (this.f15636v1 <= 1) {
                    Context context2 = this.f56478a;
                    n8.b.m(context2, context2.getString(R.string.floatview_property_key_macro_key_atleast_one));
                    return;
                } else {
                    if (this.B != null) {
                        u9.h.k(this.f56478a, this.I7, "FloatView_Setting_Config_Macro_Delete", "悬浮窗_宏_删除");
                        v0(this.B);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.A.size() == 0) {
            Context context3 = this.f56478a;
            n8.b.m(context3, context3.getString(R.string.floatview_property_key_macro_key_atleast_one));
            return;
        }
        this.K0.macro_keys.clear();
        for (int i12 = 0; i12 < this.A.size(); i12++) {
            o8.b bVar3 = this.A.get(i12);
            CFGSubPropertyMacro propertyMacro2 = bVar3.getPropertyMacro();
            propertyMacro2.setX((bVar3.getX() + (bVar3.getWidth() / 2.0f)) / this.C);
            propertyMacro2.setY((bVar3.getY() + (bVar3.getHeight() / 2.0f)) / this.D);
            this.K0.macro_keys.add(propertyMacro2);
        }
        CFGPropertyMacro cFGPropertyMacro3 = this.K0;
        int i13 = cFGPropertyMacro3.type;
        if (i13 == 0 || i13 == 1) {
            ArrayList<CFGSubPropertyMacro> arrayList3 = cFGPropertyMacro3.macro_keys;
            arrayList3.get(arrayList3.size() - 1).setNextVKey(0);
        } else if (i13 == 2) {
            ArrayList<CFGSubPropertyMacro> arrayList4 = cFGPropertyMacro3.macro_keys;
            arrayList4.get(arrayList4.size() - 1).setNextVKey(1);
        }
        t(23, this.K0);
        u9.h.k(this.f56478a, this.I7, "FloatView_Setting_Config_Macro_Save", "悬浮窗_宏_保存");
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(BluetoothDeviceOperateEvent bluetoothDeviceOperateEvent) {
        H(bluetoothDeviceOperateEvent.value);
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }

    public final void r0() {
        o8.b bVar = new o8.b(this.f56478a);
        bVar.setPropertyMacro(new CFGSubPropertyMacro());
        CFGPropertyMacro cFGPropertyMacro = this.K0;
        bVar.b(cFGPropertyMacro.key_id, cFGPropertyMacro.comboKeyFirst, cFGPropertyMacro.comboKeySecond, this.f56484g);
        bVar.setNumber(this.f15636v1 + 1);
        bVar.setReset(false);
        bVar.setClickable(true);
        bVar.setX(U7[this.f15636v1] * this.C1);
        bVar.setY(V7[this.f15636v1] * this.C1);
        bVar.setReset(true);
        bVar.setOnTouchListener(this.R7);
        this.f15629p.addView(bVar);
        this.A.add(bVar);
        int i10 = this.f15636v1 + 1;
        this.f15636v1 = i10;
        this.f15639x.setText(this.f56478a.getString(R.string.floatview_macro_key_kount, Integer.valueOf(i10)));
    }

    public final void s0() {
        for (int i10 = 0; i10 < this.A.size(); i10++) {
            this.A.get(i10).setSelected(false);
        }
        J0(this.B, false);
    }

    public final void t0(o8.b bVar) {
        bVar.setSelected(true);
        for (int i10 = 0; i10 < this.A.size(); i10++) {
            if (!this.A.get(i10).equals(bVar)) {
                this.A.get(i10).setSelected(false);
            }
        }
    }

    public final void u0() {
        j8.b bVar = this.f15627k0;
        if (bVar != null) {
            bVar.h();
            this.f15627k0 = null;
        }
    }

    public final void v0(o8.b bVar) {
        this.f15629p.removeView(bVar);
        this.A.remove(bVar);
        this.f15636v1--;
        F0();
        s0();
        H0(false);
        this.f15639x.setText(this.f56478a.getString(R.string.floatview_macro_key_kount, Integer.valueOf(this.f15636v1)));
    }

    public final void w0() {
        CFGPropertyMacro cFGPropertyMacro = this.K0;
        if (cFGPropertyMacro == null) {
            return;
        }
        int iMin = Math.min(cFGPropertyMacro.macro_keys.size(), this.K1);
        int i10 = 0;
        while (i10 < iMin) {
            CFGSubPropertyMacro cFGSubPropertyMacro = this.K0.macro_keys.get(i10);
            o8.b bVar = new o8.b(this.f56478a);
            CFGPropertyMacro cFGPropertyMacro2 = this.K0;
            bVar.b(cFGPropertyMacro2.key_id, cFGPropertyMacro2.comboKeyFirst, cFGPropertyMacro2.comboKeySecond, this.f56484g);
            i10++;
            bVar.setNumber(i10);
            bVar.setReset(false);
            bVar.setClickable(true);
            bVar.setX((this.C * cFGSubPropertyMacro.getX()) - (bVar.getLayoutParams().width / 2.0f));
            bVar.setY((this.D * cFGSubPropertyMacro.getY()) - (bVar.getLayoutParams().height / 2.0f));
            bVar.setPropertyMacro(cFGSubPropertyMacro);
            bVar.setOnTouchListener(this.R7);
            this.f15629p.addView(bVar);
            this.A.add(bVar);
        }
        this.f15636v1 = this.K0.macro_keys.size();
        this.f15628k1 = this.K1 - (x7.f.f54912s - this.K0.macro_keys.size());
        this.f15639x.setText(this.f56478a.getString(R.string.floatview_macro_key_kount, Integer.valueOf(this.f15636v1)));
        M0();
        if (this.K0.key_id_cancel != 255) {
            this.f15632s.setIconColor(0);
            this.f15632s.setIcon(com.flydigi.sdk.gamepad.extension.a.k(this.f56478a, this.K0.key_id_cancel, this.f56484g, false));
            this.f15633t.setVisibility(0);
        }
        this.f15629p.removeView(this.f15630q);
        this.f15629p.addView(this.f15630q);
    }

    public final void x0() {
        View viewFindViewById = this.f15630q.findViewById(R.id.btn_effect_type);
        this.f15637v2 = viewFindViewById;
        com.blankj.utilcode.util.o.r(viewFindViewById, this);
        this.C2 = (TextView) this.f15630q.findViewById(R.id.tv_effect_type);
        this.K2 = (SuperButton) this.f15630q.findViewById(R.id.iv_effect_type);
        this.E7 = new RecyclerView(this.f56478a);
        eu.davidea.flexibleadapter.b<MacroEffectTypeItem> bVar = new eu.davidea.flexibleadapter.b<>(Arrays.asList(new MacroEffectTypeItem(0), new MacroEffectTypeItem(1), new MacroEffectTypeItem(2)), new b.z() { // from class: com.flydigi.float_view.ui.config.e2
            @Override // eu.davidea.flexibleadapter.b.z
            public final boolean M(View view, int i10) {
                return this.f15604a.z0(view, i10);
            }
        });
        this.F7 = bVar;
        this.E7.setAdapter(bVar);
        this.E7.setVisibility(8);
        this.E7.setLayoutManager(new LinearLayoutManager(this.f56478a));
        this.f15629p.addView(this.E7);
    }

    public final void y0() {
        View viewFindViewById = this.f15630q.findViewById(R.id.button_menu_move_bar);
        viewFindViewById.setClickable(true);
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.flydigi.float_view.ui.config.d2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f15600a.A0(view, motionEvent);
            }
        });
    }
}

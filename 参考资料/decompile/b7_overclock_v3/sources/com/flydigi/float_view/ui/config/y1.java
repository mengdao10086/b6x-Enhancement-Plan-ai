package com.flydigi.float_view.ui.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.data.DataConstant;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.float_view.R;
import com.flydigi.float_view.ui.config.a2;
import com.flydigi.float_view.widget.ExpandView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.greenrobot.eventbus.ThreadMode;
import top.androidman.SuperLine;
import z7.j;
import z7.p;

/* JADX INFO: loaded from: classes7.dex */
public class y1 extends y7.b implements View.OnClickListener {

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final int f15718f8 = 0;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final int f15719g8 = 1;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final int f15720h8 = 2;
    public SuperLine A;
    public SuperLine B;
    public final ArrayList<ExpandView> C;
    public int C1;
    public b8.d C2;
    public CFGEntity D;
    public z7.r0 E7;
    public z7.p F7;
    public a2 G7;
    public final String H7;
    public float I7;
    public float J7;
    public int K0;
    public float K1;
    public b8.e K2;
    public final androidx.collection.a<Integer, ExpandView> K7;
    public final int L7;
    public ImageView M7;
    public View N7;
    public TextView O7;
    public View P7;
    public View Q7;
    public TextView R7;
    public View S7;
    public View T7;
    public TextView U7;
    public View V7;
    public View W7;
    public View X7;
    public View Y7;
    public final View.OnTouchListener Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public final View.OnTouchListener f15721a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public float f15722b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public float f15723c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public boolean f15724d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public Handler f15725e8;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final int f15726k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public ExpandView f15727k1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<CFGEntity> f15729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f15730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FrameLayout f15731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FrameLayout f15732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public FrameLayout f15733u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f15734v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f15735v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public d8.d f15736v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f15737w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f15738x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f15739y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f15740z;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    if (!y1.this.f15724d8) {
                        y1 y1Var = y1.this;
                        y1Var.c2(y1Var.f15727k1, false);
                        y1.this.f15724d8 = true;
                        ExpandView expandView = new ExpandView(y1.this.f56478a);
                        int iIntValue = ((Integer) view.getTag()).intValue();
                        if (iIntValue == 240 || iIntValue == 241 || iIntValue == 242) {
                            CFGPropertyJS cFGPropertyJS = new CFGPropertyJS();
                            cFGPropertyJS.key_id = iIntValue;
                            cFGPropertyJS.type = iIntValue == 242 ? 4 : 1;
                            cFGPropertyJS.radius = 64;
                            cFGPropertyJS.senty_x = 63;
                            cFGPropertyJS.senty_y = 63;
                            expandView.j(cFGPropertyJS, y1.this.f56484g, false);
                        } else {
                            CFGPropertyKey cFGPropertyKey = new CFGPropertyKey(iIntValue);
                            if (iIntValue == 116) {
                                cFGPropertyKey.senty_x = 63;
                                cFGPropertyKey.senty_y = 63;
                            }
                            expandView.k(cFGPropertyKey, y1.this.f56484g, false);
                        }
                        expandView.setSelected(true);
                        y1.this.j1(expandView.getKeyId(), expandView.getComboKeyFirst(), expandView.getComboKeySecond(), expandView);
                        expandView.setNumber(y1.this.r1(expandView.getKeyId(), expandView.getComboKeyFirst(), expandView.getComboKeySecond()) + 1);
                        y1.this.Y1(true);
                        y1.this.f15731s.addView(expandView);
                        y1.this.C.add(expandView);
                        if (y1.this.D1(expandView.getKeyId())) {
                            view.setVisibility(8);
                        }
                        y1.this.f15732t.setVisibility(8);
                    }
                    ExpandView expandView2 = (ExpandView) y1.this.C.get(y1.this.C.size() - 1);
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    if (0.0f < rawX && rawX < y1.this.f15735v1 && 0.0f < rawY && rawY < y1.this.C1) {
                        expandView2.setX(motionEvent.getRawX() - (expandView2.getWidth() / 2.0f));
                        expandView2.setY(motionEvent.getRawY() - (expandView2.getHeight() / 2.0f));
                        y1.this.X1(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                }
            } else if (y1.this.f15724d8) {
                y1.this.f15724d8 = false;
                ExpandView expandView3 = (ExpandView) y1.this.C.get(y1.this.C.size() - 1);
                y1.this.q1();
                androidx.core.util.k<Integer, String> kVarA = n8.b.a(y1.this.f56478a, y1.this.D, y1.this.f56484g);
                Integer num = kVarA.f4741a;
                if (num != null && num.intValue() != 0) {
                    n8.b.m(y1.this.f56478a, kVarA.f4742b);
                    y1.this.f15731s.removeView(expandView3);
                    y1.this.C.remove(expandView3);
                    y1.this.Y1(false);
                    y1.this.f15731s.removeView(y1.this.f15732t);
                    y1.this.f15731s.addView(y1.this.f15732t);
                    y1.this.f15732t.setVisibility(0);
                    if (y1.this.D1(expandView3.getKeyId())) {
                        view.setVisibility(8);
                    } else {
                        view.setVisibility(0);
                    }
                    return false;
                }
                expandView3.setUIFocus(true);
                expandView3.setClickable(true);
                expandView3.setOnTouchListener(y1.this.f15721a8);
                y1.this.f15731s.removeView(y1.this.f15732t);
                y1.this.f15731s.addView(y1.this.f15732t);
                y1.this.f15727k1 = expandView3;
                if (y1.this.f56484g.isGamepadKeyboard() && expandView3.getKeyId() == -1) {
                    y1.this.f15738x = true;
                    y1.this.f15739y = 2;
                    y1.this.f15734v.setVisibility(0);
                } else if (expandView3.getKeyId() != 256) {
                    com.flydigi.userBehavior.a.a().b(y1.this.f56478a, "悬浮窗_调整配置_拖出按键");
                    y1.this.c2(expandView3, true);
                    y1.this.f15732t.setVisibility(0);
                } else if (y1.this.f56484g.getDeviceType() == 68) {
                    com.flydigi.userBehavior.a.a().b(y1.this.f56478a, "悬浮窗_调整配置_拖出按键");
                    CFGPropertyKey cFGPropertyKey2 = new CFGPropertyKey(12, 14);
                    expandView3.k(cFGPropertyKey2, y1.this.f56484g, false);
                    y1.this.c2(expandView3, true);
                    y1.this.g1();
                    y1.this.j1(cFGPropertyKey2.key_id, 12, 14, expandView3);
                    y1.this.f15732t.setVisibility(0);
                } else {
                    y1.this.Z1(expandView3);
                }
            }
            return false;
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (y1.this.f15734v != null && y1.this.f15734v.getVisibility() == 0) {
                return false;
            }
            ExpandView expandView = (ExpandView) view;
            int action = motionEvent.getAction();
            if (action == 0) {
                if (y1.this.f15727k1 != null && y1.this.f15727k1 != expandView) {
                    y1.this.f15727k1.setUIFocus(false);
                }
                y1.this.f15722b8 = motionEvent.getRawX() - view.getX();
                y1.this.f15723c8 = motionEvent.getRawY() - view.getY();
                y1.this.j1(expandView.getKeyId(), expandView.getComboKeyFirst(), expandView.getComboKeySecond(), expandView);
                y1.this.Y1(true);
                y1.this.X1((motionEvent.getRawX() - y1.this.f15722b8) + (expandView.getWidth() / 2.0f), (motionEvent.getRawY() - y1.this.f15723c8) + (expandView.getHeight() / 2.0f));
                y1.this.f15731s.removeView(view);
                y1.this.f15731s.addView(view);
            } else if (action != 1) {
                if (action == 2) {
                    if (!y1.this.f15724d8 && (Math.abs((motionEvent.getRawX() - view.getX()) - y1.this.f15722b8) > 5.0f || Math.abs((motionEvent.getRawY() - view.getY()) - y1.this.f15723c8) > 5.0f)) {
                        y1.this.f15724d8 = true;
                        y1.this.c2(expandView, false);
                        y1.this.f15732t.setVisibility(8);
                    }
                    float rawX = (motionEvent.getRawX() - y1.this.f15722b8) + (expandView.getWidth() / 2.0f);
                    float rawY = (motionEvent.getRawY() - y1.this.f15723c8) + (expandView.getHeight() / 2.0f);
                    if (0.0f < rawX && rawX < y1.this.f15735v1 && 0.0f < rawY && rawY < y1.this.C1) {
                        expandView.setX(motionEvent.getRawX() - y1.this.f15722b8);
                        expandView.setY(motionEvent.getRawY() - y1.this.f15723c8);
                        y1.this.X1(rawX, rawY);
                    }
                }
            } else if (y1.this.f15724d8 || !expandView.c()) {
                y1.this.f15724d8 = false;
                y1.this.f15727k1 = expandView;
                expandView.setUIFocus(true);
                y1.this.f15731s.removeView(y1.this.f15732t);
                y1.this.f15731s.addView(y1.this.f15732t);
                y1.this.W1(false);
                y1.this.f15732t.setVisibility(0);
                y1.this.c2(expandView, true);
            } else {
                y1.this.g2(expandView);
            }
            return false;
        }
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r9) {
            /*
                Method dump skipped, instruction units count: 638
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flydigi.float_view.ui.config.y1.c.handleMessage(android.os.Message):void");
        }
    }

    public class d implements j.a {
        public d() {
        }

        @Override // z7.j.a
        public void a() {
            y1.this.q(20);
        }

        @Override // z7.j.a
        public void b(boolean z10) {
            androidx.core.util.k<Integer, String> kVarA = n8.b.a(y1.this.f56478a, y1.this.D, y1.this.f56484g);
            Integer num = kVarA.f4741a;
            if (num != null && num.intValue() != 0) {
                n8.b.m(y1.this.f56478a, kVarA.f4742b);
            } else if (y1.this.f15728p == 2) {
                y1 y1Var = y1.this;
                y1Var.t(11, y1Var.D);
            } else {
                y1 y1Var2 = y1.this;
                y1Var2.s(10, y1Var2.f15726k0, y1.this.D);
            }
        }
    }

    public class e implements p.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15745a;

        public e(boolean z10) {
            this.f15745a = z10;
        }

        @Override // z7.p.c
        public void a(String str) {
            if (com.blankj.utilcode.util.n0.m(str.trim())) {
                n8.b.m(y1.this.f56478a, y1.this.f56478a.getString(R.string.floatview_config_name_cannot_empty));
                return;
            }
            if (str.length() > 20) {
                n8.b.m(y1.this.f56478a, y1.this.f56478a.getString(R.string.floatview_config_name_too_long));
                return;
            }
            y1 y1Var = y1.this;
            if (y1Var.T1(y1Var.D, str)) {
                y1.this.k1();
            }
        }

        @Override // z7.p.c
        public void onCancel() {
            if (this.f15745a) {
                y1.this.q(20);
            }
        }
    }

    public y1(Context context, y7.n nVar, Handler handler, String str, GamepadInfo gamepadInfo, List<CFGEntity> list, CFGEntity cFGEntity, int i10, int i11) {
        super(context, nVar, gamepadInfo);
        this.f15728p = 0;
        this.f15738x = false;
        this.f15739y = 0;
        this.f15740z = null;
        this.C = new ArrayList<>();
        this.f15727k1 = null;
        this.f15735v1 = 0;
        this.C1 = 0;
        this.f15736v2 = null;
        this.C2 = null;
        this.K2 = null;
        this.I7 = 0.0f;
        this.J7 = 0.0f;
        this.K7 = new androidx.collection.a<>();
        this.L7 = 3;
        this.Z7 = new a();
        this.f15721a8 = new b();
        this.f15722b8 = 0.0f;
        this.f15723c8 = 0.0f;
        this.f15725e8 = new c(Looper.getMainLooper());
        this.f56482e = handler;
        this.H7 = str;
        if (cFGEntity != null) {
            this.D = cFGEntity.copy();
        }
        this.f15729q = list;
        this.f15726k0 = i10;
        this.f15728p = i11;
    }

    public static /* synthetic */ void F1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G1(ExpandView expandView) {
        X1((this.f15735v1 / 2.0f) + (expandView.getWidth() / 2.0f), ((this.C1 / 6.0f) * 5.0f) + (expandView.getHeight() / 2.0f));
        Y1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H1(View view) {
        this.f15738x = false;
        this.f15734v.setVisibility(8);
        if (this.f15739y == 2) {
            this.f15732t.setVisibility(0);
            e1();
            m1(this.f15727k1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean I1(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.I7 = motionEvent.getRawX() - this.f15732t.getX();
            this.J7 = motionEvent.getRawY() - this.f15732t.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        if ((motionEvent.getRawX() - this.I7 > 0.0f && motionEvent.getRawX() - this.I7 < this.f15735v1 - this.f15732t.getWidth() && motionEvent.getRawY() - this.J7 > 0.0f) || motionEvent.getRawY() - this.J7 < this.C1 - this.f15732t.getHeight()) {
            this.f15732t.setX(motionEvent.getRawX() - this.I7);
            this.f15732t.setY(motionEvent.getRawY() - this.J7);
        }
        if (motionEvent.getRawX() - this.I7 < 0.0f || motionEvent.getRawX() - this.I7 > this.f15735v1 - this.f15732t.getWidth()) {
            this.f15732t.setY(motionEvent.getRawY() - this.J7);
        }
        if (motionEvent.getRawY() - this.J7 < 0.0f || motionEvent.getRawY() - this.J7 > this.C1 - this.f15732t.getHeight()) {
            this.f15732t.setX(motionEvent.getRawX() - this.I7);
        }
        if (this.f15732t.getX() < 0.0f) {
            this.f15732t.setX(0.0f);
        } else if (this.f15732t.getX() > this.f15735v1 - this.f15732t.getWidth()) {
            this.f15732t.setX(this.f15735v1 - r4.getWidth());
        } else {
            this.f15732t.setX(motionEvent.getRawX() - this.I7);
        }
        if (this.f15732t.getY() < 0.0f) {
            this.f15732t.setY(0.0f);
            return false;
        }
        if (this.f15732t.getY() <= this.C1 - this.f15732t.getHeight()) {
            this.f15732t.setY(motionEvent.getRawY() - this.J7);
            return false;
        }
        this.f15732t.setY(this.C1 - r4.getHeight());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J1() {
        FrameLayout frameLayout = this.f15731s;
        if (frameLayout != null) {
            this.f15735v1 = Math.max(frameLayout.getMeasuredHeight(), this.f15731s.getMeasuredWidth());
            this.C1 = Math.min(this.f15731s.getMeasuredHeight(), this.f15731s.getMeasuredWidth());
            this.f15731s.getLocationOnScreen(new int[2]);
            this.K1 = (this.f15735v1 * 1.0f) / 1280.0f;
            w1();
            u1();
            this.f15737w = View.inflate(this.f56478a, R.layout.floatview_layout_setting_config_key_menu, null);
            this.f15737w.setLayoutParams(new ConstraintLayout.b(-2, -2));
            this.f15737w.setVisibility(8);
            com.blankj.utilcode.util.o.r(this.f15737w.findViewById(R.id.btn_delete), this);
            com.blankj.utilcode.util.o.r(this.f15737w.findViewById(R.id.btn_setting), this);
            com.blankj.utilcode.util.o.r(this.f15737w.findViewById(R.id.btn_mode), this);
            this.f15731s.addView(this.f15737w);
            FrameLayout frameLayout2 = this.f15731s;
            View view = this.f15737w;
            frameLayout2.updateViewLayout(view, view.getLayoutParams());
            Iterator<Integer> it2 = this.K7.keySet().iterator();
            while (it2.hasNext()) {
                ExpandView expandView = this.K7.get(it2.next());
                if (expandView != null && expandView.getAlpha() == 1.0f) {
                    expandView.setClickable(true);
                    expandView.setOnTouchListener(this.Z7);
                }
            }
            h1();
            y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K1() {
        q1();
        this.K0 = this.D.hashCode();
        this.f15730r.setText(String.format(this.f56478a.getString(R.string.floatview_current_config), com.blankj.utilcode.util.d1.l(this.D.title)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L1(View view) {
        V1(view);
        f2(this.W7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M1(View view) {
        V1(view);
        f2(this.X7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(View view) {
        V1(view);
        f2(this.Y7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean O1(Message message) {
        ExpandView expandView;
        if (message.what != 24 || (expandView = this.f15727k1) == null) {
            return false;
        }
        f1(expandView.getComboKeyFirst(), this.f15727k1.getComboKeySecond(), message.arg1);
        if (this.f15727k1.getConfigType() == 2) {
            this.f15727k1.getPropertyMacro().comboKeyMode = message.arg1;
            return false;
        }
        this.f15727k1.getPropertyKey().comboKeyMode = message.arg1;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1() {
        if (this.f15732t.getY() > this.C1 - this.f15732t.getHeight()) {
            this.f15732t.setY(this.C1 - r0.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Q1(ExpandView expandView, Message message) {
        int i10 = message.what;
        if (i10 == 25) {
            m1(expandView);
        } else if (i10 == 26) {
            if (r1(256, message.arg1, message.arg2) == 3) {
                Context context = this.f56478a;
                n8.b.m(context, String.format(context.getString(R.string.floatview_property_macro_key_max_child_per_key), 3));
                m1(expandView);
            } else {
                CFGPropertyKey cFGPropertyKey = new CFGPropertyKey(message.arg1, message.arg2);
                this.f15727k1.k(cFGPropertyKey, this.f56484g, false);
                c2(this.f15727k1, true);
                g1();
                j1(cFGPropertyKey.key_id, message.arg1, message.arg2, this.f15727k1);
            }
        }
        this.f15732t.setVisibility(0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(ExpandView expandView) {
        float measuredWidth;
        int[] iArr = new int[2];
        View viewFindViewById = this.f15737w.findViewById(R.id.iv_indicator_down);
        View viewFindViewById2 = this.f15737w.findViewById(R.id.iv_indicator_left);
        View viewFindViewById3 = this.f15737w.findViewById(R.id.iv_indicator_right);
        expandView.getLocationOnScreen(iArr);
        int measuredWidth2 = this.f15737w.getMeasuredWidth();
        float measuredWidth3 = iArr[0] - ((measuredWidth2 - expandView.getMeasuredWidth()) / 2.0f);
        if (iArr[1] < this.f15737w.getMeasuredHeight() || measuredWidth3 < 0.0f || measuredWidth3 + measuredWidth2 > this.f15735v1) {
            float measuredHeight = iArr[1] - ((r5 - expandView.getMeasuredHeight()) / 2.0f);
            this.f15737w.setY(measuredHeight >= 0.0f ? measuredHeight : 0.0f);
            if (iArr[0] + expandView.getMeasuredWidth() + this.f15737w.getMeasuredWidth() > this.f15735v1) {
                measuredWidth = iArr[0] - this.f15737w.getMeasuredWidth();
                viewFindViewById3.setVisibility(0);
                viewFindViewById2.setVisibility(4);
            } else {
                measuredWidth = iArr[0] + expandView.getMeasuredWidth();
                viewFindViewById3.setVisibility(4);
                viewFindViewById2.setVisibility(0);
            }
            this.f15737w.setX(measuredWidth);
            viewFindViewById.setVisibility(4);
        } else {
            this.f15737w.setX(iArr[0] - ((measuredWidth2 - expandView.getMeasuredWidth()) / 2.0f));
            this.f15737w.setY(iArr[1] - r5);
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(4);
            viewFindViewById3.setVisibility(4);
        }
        this.f15731s.removeView(this.f15737w);
        this.f15731s.addView(this.f15737w);
        this.f15731s.removeView(this.f15732t);
        this.f15731s.addView(this.f15732t);
    }

    public final void A1() {
        x1(R.id.view_key_leftstick, 240);
        x1(R.id.view_key_rightstick, 241);
        if (this.f56484g.getDeviceType() == 19 && (this.f56484g.isDriverMode() || l9.c.b(m9.k.f40830p, this.f56484g.getFirmwareVersion()))) {
            int i10 = R.id.view_key_lunpan;
            x1(i10, m9.m.f40854e0);
            this.f15733u.findViewById(i10).setVisibility(0);
        }
        x1(R.id.view_key_up, 0);
        x1(R.id.view_key_down, 2);
        x1(R.id.view_key_lt, 12);
        x1(R.id.view_key_rt, 13);
        x1(R.id.view_key_a, 4);
        x1(R.id.view_key_b, 5);
        x1(R.id.view_key_left, 3);
        x1(R.id.view_key_right, 1);
        x1(R.id.view_key_lb, 10);
        x1(R.id.view_key_rb, 11);
        x1(R.id.view_key_x, 7);
        x1(R.id.view_key_y, 8);
        x1(R.id.view_key_z, 38);
        x1(R.id.view_key_c, 37);
    }

    public final void B1() {
        x1(R.id.view_key_lta, 21);
        x1(R.id.view_key_ltb, 22);
        x1(R.id.view_key_ltx, 23);
        x1(R.id.view_key_lty, 24);
        x1(R.id.view_key_ltc, 27);
        x1(R.id.view_key_ltz, 28);
        x1(R.id.view_key_ltrb, 25);
        x1(R.id.view_key_ltrt, 26);
        x1(R.id.view_key_lba, 29);
        x1(R.id.view_key_lbb, 30);
        x1(R.id.view_key_lbx, 31);
        x1(R.id.view_key_lby, 32);
        x1(R.id.view_key_lbc, 35);
        x1(R.id.view_key_lbz, 36);
        x1(R.id.view_key_lbrb, 33);
        x1(R.id.view_key_lbrt, 34);
        x1(R.id.view_key_m1a, 44);
        x1(R.id.view_key_m1b, 45);
        x1(R.id.view_key_m1x, 46);
        x1(R.id.view_key_m1y, 47);
        x1(R.id.view_key_m2a, 48);
        x1(R.id.view_key_m2b, 49);
        x1(R.id.view_key_m2x, 50);
        x1(R.id.view_key_m2y, 51);
    }

    public final void C1() {
        x1(R.id.view_key_menu, 20);
        x1(R.id.view_key_home, 19);
        x1(R.id.view_key_back, 18);
        x1(R.id.view_key_l3, 14);
        x1(R.id.view_key_r3, 15);
        x1(R.id.view_key_start, 9);
        x1(R.id.view_key_select, 6);
        x1(R.id.view_key_m1, 39);
        x1(R.id.view_key_m2, 40);
        x1(R.id.view_key_m3, 41);
        x1(R.id.view_key_m4, 42);
        x1(R.id.view_key_m5, 53);
        x1(R.id.view_key_m6, 54);
        x1(R.id.view_key_combo, 256);
    }

    public final boolean D1(int i10) {
        if (i10 == 256) {
            return false;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.C.size(); i12++) {
            int keyId = this.C.get(i12).getKeyId();
            if (keyId == i10 && (keyId == 240 || keyId == 241 || keyId == 242 || keyId == 240 || keyId == 116 || (i11 = i11 + 1) == 3)) {
                return true;
            }
        }
        return false;
    }

    public boolean E1() {
        FrameLayout frameLayout = this.f15731s;
        return frameLayout != null && frameLayout.getVisibility() == 0;
    }

    public final void S1(int i10) {
        float x10 = this.f15727k1.getX();
        float y10 = this.f15727k1.getY();
        float width = this.f15727k1.getWidth() + x10;
        float height = this.f15727k1.getHeight() + y10;
        Iterator<ExpandView> it2 = this.C.iterator();
        boolean z10 = true;
        boolean z11 = true;
        boolean z12 = true;
        boolean z13 = true;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ExpandView next = it2.next();
            if (i10 == 241) {
                if (next.getKeyId() == 67) {
                    z10 = false;
                } else if (next.getKeyId() == 64) {
                    z11 = false;
                } else if (next.getKeyId() == 65) {
                    z12 = false;
                } else if (next.getKeyId() == 66) {
                    z13 = false;
                }
            } else if (i10 == 240) {
                if (next.getKeyId() == 71) {
                    z10 = false;
                } else if (next.getKeyId() == 68) {
                    z11 = false;
                } else if (next.getKeyId() == 69) {
                    z12 = false;
                } else if (next.getKeyId() == 70) {
                    z13 = false;
                }
            } else if (i10 == 242) {
                if (next.getKeyId() == 75) {
                    z10 = false;
                } else if (next.getKeyId() == 72) {
                    z11 = false;
                } else if (next.getKeyId() == 73) {
                    z12 = false;
                } else if (next.getKeyId() == 74) {
                    z13 = false;
                }
            }
        }
        if (z10) {
            c1(new CFGPropertyKey(i10 != 241 ? i10 == 242 ? 75 : 71 : 67), x10, (this.f15727k1.getHeight() / 2.0f) + y10);
        }
        if (z11) {
            c1(new CFGPropertyKey(i10 != 241 ? i10 == 242 ? 72 : 68 : 64), (this.f15727k1.getWidth() / 2.0f) + x10, y10);
        }
        if (z12) {
            c1(new CFGPropertyKey(i10 != 241 ? i10 == 242 ? 73 : 69 : 65), width, y10 + (this.f15727k1.getHeight() / 2.0f));
        }
        if (z13) {
            c1(new CFGPropertyKey(i10 == 241 ? 66 : i10 == 242 ? 74 : 70), x10 + (this.f15727k1.getWidth() / 2.0f), height);
        }
    }

    public final boolean T1(CFGEntity cFGEntity, String str) {
        if (e6.z.z(this.f15729q, cFGEntity, str)) {
            Context context = this.f56478a;
            new z7.j(context, 1, "", context.getString(R.string.floatview_exist_same_config_name_please_rename_try_again), this.f56478a.getString(R.string.confirm), "", null);
            return false;
        }
        CFGEntity cFGEntityCopy = cFGEntity.copy();
        cFGEntityCopy.setInTop(false);
        cFGEntityCopy.setInUse(false);
        cFGEntityCopy.title = str;
        if (this.f15728p == 2) {
            t(11, cFGEntityCopy);
            return true;
        }
        t(12, cFGEntityCopy);
        return true;
    }

    public final void U1(int i10, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < this.C.size(); i14++) {
            ExpandView expandView = this.C.get(i14);
            if (m9.m.a(i10) && expandView.a()) {
                if (expandView.b(i11, i12)) {
                    i13++;
                    expandView.setNumber(i13);
                }
            } else if (expandView.getKeyId() == i10) {
                i13++;
                expandView.setNumber(i13);
            }
        }
    }

    public final void V1(View view) {
        View view2 = this.N7;
        view2.setSelected(view == view2);
        View view3 = this.Q7;
        view3.setSelected(view == view3);
        View view4 = this.T7;
        view4.setSelected(view == view4);
        this.O7.setSelected(view == this.N7);
        this.R7.setSelected(view == this.Q7);
        this.U7.setSelected(view == this.T7);
        this.P7.setVisibility(view == this.N7 ? 0 : 8);
        this.S7.setVisibility(view == this.Q7 ? 0 : 8);
        this.V7.setVisibility(view == this.T7 ? 0 : 8);
        this.O7.setTypeface(Typeface.defaultFromStyle(view == this.N7 ? 1 : 0));
        this.R7.setTypeface(Typeface.defaultFromStyle(view == this.Q7 ? 1 : 0));
        this.U7.setTypeface(Typeface.defaultFromStyle(view != this.T7 ? 0 : 1));
    }

    public final void W1(boolean z10) {
        if (!z10) {
            this.M7.setImageResource(R.drawable.floatview_ic_expand);
            this.f15733u.setVisibility(8);
        } else {
            this.f15733u.setVisibility(0);
            this.M7.setImageResource(R.drawable.floatview_ic_collopse);
            this.f15733u.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.w1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15712a.P1();
                }
            });
        }
    }

    public final void X1(float f10, float f11) {
        this.A.setY(f11);
        this.B.setX(f10);
    }

    public final void Y1(boolean z10) {
        if (!z10) {
            this.A.setVisibility(4);
            this.B.setVisibility(4);
            return;
        }
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.f15731s.removeView(this.A);
        this.f15731s.removeView(this.B);
        this.f15731s.addView(this.A);
        this.f15731s.addView(this.B);
    }

    public final void Z1(final ExpandView expandView) {
        new h1(this.f56478a, new Handler(new Handler.Callback() { // from class: com.flydigi.float_view.ui.config.p1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f15688a.Q1(expandView, message);
            }
        }), this.f56484g).y();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a1(CFGPropertyJS cFGPropertyJS) {
        ExpandView expandView = new ExpandView(this.f56478a);
        if (cFGPropertyJS.type == 2 && this.f56484g.isFlashplayMode() && cFGPropertyJS.key_id == 240 && l9.c.b(m9.k.f40828n, this.f56484g.getFirmwareVersion()) && !l9.c.b(m9.k.f40830p, this.f56484g.getFirmwareVersion())) {
            cFGPropertyJS.type = 1;
        }
        expandView.j(cFGPropertyJS, this.f56484g, false);
        expandView.setX((this.f15735v1 * cFGPropertyJS.f16345x) - (expandView.getLayoutParams().width / 2.0f));
        expandView.setY((this.C1 * cFGPropertyJS.f16346y) - (expandView.getLayoutParams().height / 2.0f));
        expandView.setClickable(true);
        expandView.setOnTouchListener(this.f15721a8);
        if (cFGPropertyJS.type == 2) {
            expandView.setAlpha(0.4f);
        } else {
            expandView.setAlpha(1.0f);
        }
        this.f15731s.addView(expandView);
        this.C.add(expandView);
    }

    public final void a2(CFGPropertyJS cFGPropertyJS) {
        this.C2 = new b8.d(this.f56478a, this.f15725e8, cFGPropertyJS, this.f56484g, this.H7);
    }

    public final void b1(CFGPropertyKey cFGPropertyKey) {
        c1(cFGPropertyKey, this.f15735v1 * cFGPropertyKey.f16347x, this.C1 * cFGPropertyKey.f16348y);
    }

    public final void b2(Object obj) {
        q1();
        u9.h.k(this.f56478a, this.H7, "Float_View_Setting_Config_Show_Property", "悬浮窗_调整配置_设置");
        d8.d dVar = this.f15736v2;
        if (dVar == null) {
            this.f15736v2 = new d8.d(this.f56478a, this.f15725e8, obj, this.H7, this.f56484g, this.D);
        } else {
            dVar.y();
            this.f15736v2.a0(obj, this.D);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void c1(CFGPropertyKey cFGPropertyKey, float f10, float f11) {
        ExpandView expandView = new ExpandView(this.f56478a);
        expandView.k(cFGPropertyKey, this.f56484g, false);
        expandView.setX(f10 - (expandView.getLayoutParams().width / 2.0f));
        expandView.setY(f11 - (expandView.getLayoutParams().width / 2.0f));
        expandView.setClickable(true);
        expandView.setOnTouchListener(this.f15721a8);
        this.f15731s.addView(expandView);
        this.C.add(expandView);
    }

    public final void c2(final ExpandView expandView, boolean z10) {
        if (expandView == null) {
            return;
        }
        int i10 = 8;
        if (expandView.getKeyId() < 0 || !z10) {
            this.f15737w.setVisibility(8);
            return;
        }
        this.f15737w.setVisibility(0);
        View viewFindViewById = this.f15737w.findViewById(R.id.btn_mode);
        if (m9.t.b(this.f56484g) && expandView.a()) {
            i10 = 0;
        }
        viewFindViewById.setVisibility(i10);
        this.f15737w.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.n1
            @Override // java.lang.Runnable
            public final void run() {
                this.f15680a.R1(expandView);
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void d1(CFGPropertyMacro cFGPropertyMacro) {
        ExpandView expandView = new ExpandView(this.f56478a);
        expandView.l(cFGPropertyMacro, this.f56484g, false);
        expandView.setX((this.f15735v1 * cFGPropertyMacro.macro_keys.get(0).getX()) - (expandView.getLayoutParams().width / 2.0f));
        expandView.setY((this.C1 * cFGPropertyMacro.macro_keys.get(0).getY()) - (expandView.getLayoutParams().height / 2.0f));
        expandView.setClickable(true);
        expandView.setOnTouchListener(this.f15721a8);
        this.f15731s.addView(expandView);
        this.C.add(expandView);
    }

    public final void d2(boolean z10) {
        k1();
        Context context = this.f56478a;
        this.F7 = new z7.p(context, context.getString(R.string.floatview_save_as), this.f56478a.getString(R.string.floatview_hint_input_new_config_name), this.D.title, new e(z10));
    }

    public final void e1() {
        for (int i10 = 0; i10 < this.C.size(); i10++) {
            this.C.get(i10).setSelected(false);
        }
        Y1(false);
    }

    public final void e2() {
        Context context = this.f56478a;
        new z7.j(context, 2, "", context.getString(R.string.floatview_are_you_save_current_config_from_settting, this.D.title), this.f56478a.getString(R.string.floatview_save), this.f56478a.getString(R.string.floatview_discard_change), new d());
    }

    public final void f1(int i10, int i11, int i12) {
        for (ExpandView expandView : this.C) {
            if (expandView.b(i10, i11)) {
                expandView.setComboKeyMode(i12);
            }
        }
    }

    public final void f2(View view) {
        View view2 = this.W7;
        view2.setVisibility(view2 == view ? 0 : 8);
        View view3 = this.X7;
        view3.setVisibility(view3 == view ? 0 : 8);
        View view4 = this.Y7;
        view4.setVisibility(view4 != view ? 8 : 0);
    }

    @Override // y7.b
    public void g() {
        super.g();
        FrameLayout frameLayout = new FrameLayout(this.f56478a);
        this.f15731s = frameLayout;
        this.f56479b = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f15731s.setBackgroundResource(R.color.color_000000_a50);
        this.f15731s.setOnClickListener(this);
        this.f15731s.setLayoutParams(layoutParams);
        x7.f.f54912s = 0;
        u();
        u9.b.s(this.f56478a);
        v();
    }

    public final void g1() {
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < this.C.size(); i10++) {
            ExpandView expandView = this.C.get(i10);
            int keyId = expandView.getKeyId();
            if (keyId != 240 && keyId != 241 && keyId != 242 && keyId != 116) {
                if (m9.m.a(keyId)) {
                    keyId = expandView.getComboKeyFirst() * expandView.getComboKeySecond() * 500;
                }
                if (map.containsKey(Integer.valueOf(keyId))) {
                    int iIntValue = ((Integer) map.get(Integer.valueOf(keyId))).intValue() + 1;
                    expandView.setNumber(iIntValue);
                    if (iIntValue != 3) {
                        map.put(Integer.valueOf(keyId), Integer.valueOf(iIntValue));
                    } else if (this.K7.containsKey(Integer.valueOf(keyId))) {
                        this.K7.get(Integer.valueOf(keyId)).setVisibility(8);
                    } else if (this.f56484g.getDeviceType() == 68 && keyId == 84000) {
                        this.K7.get(256).setVisibility(8);
                    }
                } else {
                    expandView.setNumber(1);
                    map.put(Integer.valueOf(keyId), 1);
                }
            } else if (this.K7.containsKey(Integer.valueOf(keyId))) {
                this.K7.get(Integer.valueOf(keyId)).setVisibility(8);
            }
        }
    }

    public final void g2(ExpandView expandView) {
        if (expandView.getKeyId() < 0) {
            return;
        }
        if (expandView.getConfigType() == 1) {
            a2(expandView.getPropertyJs().m2clone());
            return;
        }
        if (expandView.getConfigType() == 2) {
            b2(expandView.getPropertyMacro());
            return;
        }
        CFGPropertyKey propertyKey = expandView.getPropertyKey();
        if (!this.f56484g.isGamepadKeyboard() || propertyKey.key_id != 116) {
            b2(propertyKey);
            return;
        }
        b8.e eVar = this.K2;
        if (eVar != null) {
            eVar.h();
        }
        this.K2 = new b8.e(this.f56478a, this.f15725e8, propertyKey, this.f56484g);
    }

    @Override // y7.b
    public void h() {
        super.h();
        d8.d dVar = this.f15736v2;
        if (dVar != null) {
            dVar.h();
        }
        k1();
        b8.d dVar2 = this.C2;
        if (dVar2 != null) {
            dVar2.h();
        }
        b8.e eVar = this.K2;
        if (eVar != null) {
            eVar.h();
        }
        z7.r0 r0Var = this.E7;
        if (r0Var != null) {
            r0Var.h();
        }
        a2 a2Var = this.G7;
        if (a2Var != null) {
            a2Var.h();
        }
        u9.b.u(this.f56478a);
        u9.b.g(this.f56478a);
    }

    public final void h1() {
        if (o5.m.k(DataConstant.SP_MAIN).n(DataConstant.SP_NAME_SUB_IS_FINISH_SETTINGCONFIG_GUIDE, 0) != 0) {
            return;
        }
        this.G7 = new a2(this.f56478a, false, this.f56484g.getDeviceMode(), this.f15735v1, this.C1, this.K1, new a2.b() { // from class: com.flydigi.float_view.ui.config.v1
            @Override // com.flydigi.float_view.ui.config.a2.b
            public final void a() {
                y1.F1();
            }
        });
    }

    @Override // y7.b
    public int i() {
        return 0;
    }

    public final void i1(int i10) {
        boolean z10;
        Iterator<ExpandView> it2 = this.C.iterator();
        while (true) {
            z10 = false;
            if (!it2.hasNext()) {
                z10 = true;
                break;
            }
            ExpandView next = it2.next();
            if ((i10 == 241 && (next.getKeyId() == 64 || next.getKeyId() == 65 || next.getKeyId() == 67 || next.getKeyId() == 66)) || ((i10 == 240 && (next.getKeyId() == 68 || next.getKeyId() == 69 || next.getKeyId() == 71 || next.getKeyId() == 70)) || (i10 == 242 && (next.getKeyId() == 72 || next.getKeyId() == 73 || next.getKeyId() == 75 || next.getKeyId() == 74)))) {
                break;
            }
        }
        if (z10) {
            for (ExpandView expandView : this.C) {
                if (expandView.getKeyId() == i10) {
                    m1(expandView);
                    return;
                }
            }
        }
    }

    public final void j1(int i10, int i11, int i12, ExpandView expandView) {
        for (int i13 = 0; i13 < this.C.size(); i13++) {
            ExpandView expandView2 = this.C.get(i13);
            boolean z10 = true;
            if (m9.m.a(i10) && m9.m.a(expandView2.getKeyId())) {
                if (expandView2.b(i11, i12)) {
                    expandView2.setSelected(true);
                    if (!expandView2.equals(expandView)) {
                        expandView2.setUIFocus(false);
                    }
                } else {
                    expandView2.setSelected(false);
                }
            } else if (expandView2.getKeyId() == i10) {
                expandView2.setSelected(true);
                if (!expandView2.equals(expandView)) {
                    expandView2.setUIFocus(false);
                }
            } else if (i10 == 67 || i10 == 64 || i10 == 65 || i10 == 66 || i10 == 241) {
                if (expandView2.getKeyId() != 67 && expandView2.getKeyId() != 64 && expandView2.getKeyId() != 65 && expandView2.getKeyId() != 66 && expandView2.getKeyId() != 241) {
                    z10 = false;
                }
                expandView2.setSelected(z10);
            } else if (i10 == 71 || i10 == 68 || i10 == 69 || i10 == 70 || i10 == 240) {
                if (expandView2.getKeyId() != 71 && expandView2.getKeyId() != 68 && expandView2.getKeyId() != 69 && expandView2.getKeyId() != 70 && expandView2.getKeyId() != 240) {
                    z10 = false;
                }
                expandView2.setSelected(z10);
            } else if (i10 == 75 || i10 == 72 || i10 == 73 || i10 == 74 || i10 == 242) {
                if (expandView2.getKeyId() != 75 && expandView2.getKeyId() != 72 && expandView2.getKeyId() != 73 && expandView2.getKeyId() != 74 && expandView2.getKeyId() != 242) {
                    z10 = false;
                }
                expandView2.setSelected(z10);
            } else {
                expandView2.setSelected(false);
            }
        }
    }

    public final void k1() {
        z7.p pVar = this.F7;
        if (pVar != null) {
            pVar.h();
            this.F7 = null;
        }
    }

    @Override // y7.b
    public void l() {
        super.l();
        d8.d dVar = this.f15736v2;
        if (dVar != null) {
            dVar.l();
        }
        b8.d dVar2 = this.C2;
        if (dVar2 != null) {
            dVar2.l();
        }
        b8.e eVar = this.K2;
        if (eVar != null) {
            eVar.l();
        }
        z7.r0 r0Var = this.E7;
        if (r0Var != null) {
            r0Var.l();
        }
        a2 a2Var = this.G7;
        if (a2Var != null) {
            a2Var.l();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void l1(int i10) {
        if (this.f15740z != null) {
            e1();
            final ExpandView expandView = new ExpandView(this.f56478a);
            expandView.setSelected(true);
            Object obj = this.f15740z;
            if (obj instanceof CFGPropertyKey) {
                CFGPropertyKey cFGPropertyKeyCopy = ((CFGPropertyKey) obj).copy();
                cFGPropertyKeyCopy.key_id = i10;
                cFGPropertyKeyCopy.key = com.flydigi.sdk.gamepad.extension.a.i(i10, this.f56484g.getDeviceMode());
                expandView.k(cFGPropertyKeyCopy, this.f56484g, false);
            } else if (obj instanceof CFGPropertyMacro) {
                CFGPropertyMacro cFGPropertyMacroCopy = ((CFGPropertyMacro) obj).copy();
                cFGPropertyMacroCopy.key_id = i10;
                cFGPropertyMacroCopy.key = com.flydigi.sdk.gamepad.extension.a.i(i10, this.f56484g.getDeviceMode());
                expandView.l(cFGPropertyMacroCopy, this.f56484g, false);
                x7.f.f54912s = 0;
                for (int i11 = 0; i11 < this.C.size(); i11++) {
                    if (this.C.get(i11).getConfigType() == 2) {
                        x7.f.f54912s += this.C.get(i11).getPropertyMacro().macro_keys.size();
                    }
                }
            }
            expandView.setX((this.f15735v1 / 2.0f) - expandView.getWidth());
            expandView.setY(((this.C1 / 6.0f) * 5.0f) - expandView.getHeight());
            j1(i10, -1, -1, expandView);
            expandView.setClickable(true);
            expandView.setOnTouchListener(this.f15721a8);
            this.f15731s.addView(expandView);
            this.C.add(expandView);
            g1();
            this.f15739y = 0;
            this.f15740z = null;
            expandView.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.o1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15684a.G1(expandView);
                }
            });
            this.f15727k1 = expandView;
            expandView.setSelected(true);
            c2(expandView, true);
        }
    }

    public final void m1(ExpandView expandView) {
        ExpandView expandView2;
        if (expandView == null) {
            return;
        }
        if (expandView.getPropertyMacro() != null) {
            x7.f.f54912s -= expandView.getPropertyMacro().macro_keys.size();
        }
        Y1(false);
        this.f15731s.removeView(expandView);
        this.C.remove(expandView);
        if (this.K7.containsKey(Integer.valueOf(expandView.getKeyId())) && (expandView2 = this.K7.get(Integer.valueOf(expandView.getKeyId()))) != null) {
            expandView2.setVisibility(0);
        }
        U1(expandView.getKeyId(), expandView.getComboKeyFirst(), expandView.getComboKeySecond());
        c2(expandView, false);
    }

    @Override // y7.b
    public void n() {
        this.f15731s.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.x1
            @Override // java.lang.Runnable
            public final void run() {
                this.f15715a.J1();
            }
        });
    }

    public final void n1(Iterator<ExpandView> it2, ExpandView expandView) {
        ExpandView expandView2;
        if (it2 == null) {
            return;
        }
        if (expandView.getPropertyMacro() != null) {
            x7.f.f54912s -= expandView.getPropertyMacro().macro_keys.size();
        }
        Y1(false);
        it2.remove();
        this.f15731s.removeView(expandView);
        if (this.K7.containsKey(Integer.valueOf(expandView.getKeyId())) && (expandView2 = this.K7.get(Integer.valueOf(expandView.getKeyId()))) != null) {
            expandView2.setVisibility(0);
        }
        U1(expandView.getKeyId(), expandView.getComboKeyFirst(), expandView.getComboKeySecond());
        c2(expandView, false);
    }

    public void o1() {
        u9.b.x(this.f56478a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (view == this.f15731s) {
            e1();
            Y1(false);
            if (this.f15737w.getVisibility() == 0) {
                c2(this.f15727k1, false);
                return;
            } else {
                W1(this.f15733u.getVisibility() == 8);
                return;
            }
        }
        View view2 = this.f15734v;
        if (view == view2) {
            this.f15738x = false;
            view2.setVisibility(8);
            if (this.f15727k1.getKeyId() == -1) {
                m1(this.f15727k1);
            }
            this.f15732t.setVisibility(0);
            return;
        }
        if (id2 == R.id.btn_apply) {
            q1();
            androidx.core.util.k<Integer, String> kVarA = n8.b.a(this.f56478a, this.D, this.f56484g);
            Integer num = kVarA.f4741a;
            if (num != null && num.intValue() != 0) {
                n8.b.m(this.f56478a, kVarA.f4742b);
                return;
            }
            if (this.K0 == this.D.hashCode()) {
                q(20);
                return;
            }
            if (com.blankj.utilcode.util.d1.g(this.D.title)) {
                d2(false);
            } else {
                s(10, this.f15726k0, this.D);
            }
            u9.h.k(this.f56478a, this.H7, "Float_View_Setting_Config_Save", "悬浮窗_调整配置_保存");
            return;
        }
        if (id2 == R.id.btn_cancel) {
            u9.h.k(this.f56478a, this.H7, "Float_View_Setting_Config_Cancel", "悬浮窗_调整配置_取消");
            if (2 == this.f15728p) {
                r(19, 4);
                return;
            }
            q1();
            if (this.K0 == this.D.hashCode()) {
                q(20);
                return;
            } else if (com.blankj.utilcode.util.n0.m(this.D.title)) {
                d2(true);
                return;
            } else {
                e2();
                return;
            }
        }
        if (id2 == R.id.btn_test) {
            q1();
            androidx.core.util.k<Integer, String> kVarA2 = n8.b.a(this.f56478a, this.D, this.f56484g);
            Integer num2 = kVarA2.f4741a;
            if (num2 != null && num2.intValue() != 0) {
                n8.b.m(this.f56478a, kVarA2.f4742b);
                return;
            }
            u9.h.k(this.f56478a, this.H7, "Float_View_Setting_Config_Test", "悬浮窗_游戏配置_按键测试");
            this.E7 = new z7.r0(this.f56478a, this.D, this.f15725e8, this.f15735v1, this.C1, this.f56484g);
            l();
            return;
        }
        if (id2 == R.id.btn_save_as) {
            q1();
            androidx.core.util.k<Integer, String> kVarA3 = n8.b.a(this.f56478a, this.D, this.f56484g);
            Integer num3 = kVarA3.f4741a;
            if (num3 != null && num3.intValue() != 0) {
                n8.b.m(this.f56478a, kVarA3.f4742b);
                return;
            } else {
                u9.h.k(this.f56478a, this.H7, "Float_View_Setting_Config_Save_As", "悬浮窗_调整配置_另存为");
                d2(false);
                return;
            }
        }
        if (this.M7 == view) {
            W1(this.f15733u.getVisibility() == 8);
            return;
        }
        if (id2 == R.id.btn_setting) {
            ExpandView expandView = this.f15727k1;
            if (expandView != null) {
                g2(expandView);
                return;
            }
            return;
        }
        if (id2 != R.id.btn_delete) {
            if (id2 == R.id.btn_mode) {
                new k1(this.f56478a, new Handler(new Handler.Callback() { // from class: com.flydigi.float_view.ui.config.l1
                    @Override // android.os.Handler.Callback
                    public final boolean handleMessage(Message message) {
                        return this.f15661a.O1(message);
                    }
                }), this.f15727k1.getConfigType() == 2 ? this.f15727k1.getPropertyMacro().comboKeyMode : this.f15727k1.getPropertyKey().comboKeyMode).y();
                return;
            }
            return;
        }
        m1(this.f15727k1);
        u9.h.k(this.f56478a, this.H7, "Float_View_Setting_Config_Delete_Key", "悬浮窗_调整配置_删除");
        int keyId = this.f15727k1.getKeyId();
        if (keyId == 64 || keyId == 65 || keyId == 67 || keyId == 66) {
            i1(241);
            return;
        }
        if (keyId == 68 || keyId == 69 || keyId == 71 || keyId == 70) {
            i1(240);
            return;
        }
        if (keyId == 241 && this.f15727k1.getPropertyJs().type == 2) {
            Iterator<ExpandView> it2 = this.C.iterator();
            while (it2.hasNext()) {
                ExpandView next = it2.next();
                if (next.getKeyId() == 64 || next.getKeyId() == 65 || next.getKeyId() == 67 || next.getKeyId() == 66) {
                    n1(it2, next);
                }
            }
            return;
        }
        if (keyId == 240 && this.f15727k1.getPropertyJs().type == 2) {
            Iterator<ExpandView> it3 = this.C.iterator();
            while (it3.hasNext()) {
                ExpandView next2 = it3.next();
                if (next2.getKeyId() == 68 || next2.getKeyId() == 69 || next2.getKeyId() == 71 || next2.getKeyId() == 70) {
                    n1(it3, next2);
                }
            }
            return;
        }
        if (keyId == 242 && this.f15727k1.getPropertyJs().type == 2) {
            Iterator<ExpandView> it4 = this.C.iterator();
            while (it4.hasNext()) {
                ExpandView next3 = it4.next();
                if (next3.getKeyId() == 72 || next3.getKeyId() == 73 || next3.getKeyId() == 75 || next3.getKeyId() == 74) {
                    n1(it4, next3);
                }
            }
        }
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(BluetoothDeviceOperateEvent bluetoothDeviceOperateEvent) {
        p1(bluetoothDeviceOperateEvent.value);
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }

    public void p1(byte[] bArr) {
        if (this.f15738x) {
            List<Integer> listV0 = m9.b.v0(bArr, this.f56484g);
            if (listV0.size() != 0) {
                this.f15738x = false;
                this.f15734v.setVisibility(8);
                int i10 = 0;
                for (int i11 = 0; i11 < this.C.size(); i11++) {
                    if (this.C.get(i11).getKeyId() == listV0.get(0).intValue()) {
                        i10++;
                    }
                }
                if (i10 >= 3) {
                    Context context = this.f56478a;
                    n8.b.m(context, String.format(context.getString(R.string.floatview_property_macro_key_max_child_per_key), 3));
                    if (this.f15739y == 2) {
                        com.flydigi.userBehavior.a.a().b(this.f56478a, "悬浮窗_调整配置_拖出按键");
                        this.f15732t.setVisibility(0);
                        e1();
                        this.f15731s.removeView(this.f15727k1);
                        this.C.remove(this.f15727k1);
                    }
                    this.f15739y = 0;
                    return;
                }
                int i12 = m9.t.d(this.f56484g) ? 60 : 40;
                if (this.C.size() >= i12) {
                    Context context2 = this.f56478a;
                    n8.b.m(context2, context2.getString(R.string.floatview_key_count_validate_basic, Integer.valueOf(i12)));
                    if (this.f15739y == 2) {
                        this.f15732t.setVisibility(0);
                        e1();
                        this.f15731s.removeView(this.f15727k1);
                        this.C.remove(this.f15727k1);
                    }
                    this.f15739y = 0;
                    return;
                }
                int i13 = this.f15739y;
                if (i13 == 1) {
                    l1(listV0.get(0).intValue());
                    return;
                }
                if (i13 == 2) {
                    this.f15727k1.k(new CFGPropertyKey(listV0.get(0).intValue()), this.f56484g, false);
                    c2(this.f15727k1, true);
                    g1();
                    j1(listV0.get(0).intValue(), -1, -1, this.f15727k1);
                    this.f15732t.setVisibility(0);
                    this.f15739y = 0;
                    this.f15738x = false;
                }
            }
        }
    }

    public final void q1() {
        this.D.keyList.clear();
        this.D.jsList.clear();
        this.D.marcoList.clear();
        for (int i10 = 0; i10 < this.C.size(); i10++) {
            if (this.C.get(i10).getConfigType() == 1) {
                CFGPropertyJS propertyJs = this.C.get(i10).getPropertyJs();
                propertyJs.f16345x = u9.b.k((this.C.get(i10).getX() + (this.C.get(i10).getWidth() / 2.0f)) / this.f15735v1);
                propertyJs.f16346y = u9.b.k((this.C.get(i10).getY() + (this.C.get(i10).getHeight() / 2.0f)) / this.C1);
                this.D.jsList.add(propertyJs);
            } else if (this.C.get(i10).getConfigType() == 2) {
                this.D.marcoList.add(this.C.get(i10).getPropertyMacro());
            } else {
                CFGPropertyKey propertyKey = this.C.get(i10).getPropertyKey();
                propertyKey.f16347x = u9.b.k((this.C.get(i10).getX() + (this.C.get(i10).getWidth() / 2.0f)) / this.f15735v1);
                propertyKey.f16348y = u9.b.k((this.C.get(i10).getY() + (this.C.get(i10).getHeight() / 2.0f)) / this.C1);
                this.D.keyList.add(propertyKey);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int r1(int r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
        L2:
            java.util.ArrayList<com.flydigi.float_view.widget.ExpandView> r2 = r4.C
            int r2 = r2.size()
            if (r0 >= r2) goto L30
            java.util.ArrayList<com.flydigi.float_view.widget.ExpandView> r2 = r4.C
            java.lang.Object r2 = r2.get(r0)
            com.flydigi.float_view.widget.ExpandView r2 = (com.flydigi.float_view.widget.ExpandView) r2
            boolean r3 = m9.m.a(r5)
            if (r3 == 0) goto L25
            boolean r3 = r2.a()
            if (r3 == 0) goto L25
            boolean r2 = r2.b(r6, r7)
            if (r2 == 0) goto L2d
            goto L2b
        L25:
            int r2 = r2.getKeyId()
            if (r2 != r5) goto L2d
        L2b:
            int r1 = r1 + 1
        L2d:
            int r0 = r0 + 1
            goto L2
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.float_view.ui.config.y1.r1(int, int, int):int");
    }

    public final void s1() {
        View viewInflate = View.inflate(this.f56478a, R.layout.floatview_layout_key_panel_g1, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        viewInflate.setLayoutParams(layoutParams);
        this.f15733u.addView(viewInflate);
        x1(R.id.view_key_leftstick, 240);
        x1(R.id.view_key_lt, 12);
        x1(R.id.view_key_l3, 14);
        x1(R.id.view_key_combo, 256);
    }

    public final void t1() {
        View viewInflate = View.inflate(this.f56478a, R.layout.floatview_layout_key_panel_half, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        viewInflate.setLayoutParams(layoutParams);
        this.f15733u.addView(viewInflate);
        x1(R.id.view_key_leftstick, 240);
        x1(R.id.view_key_a, 4);
        x1(R.id.view_key_b, 5);
        x1(R.id.view_key_lb, 10);
        x1(R.id.view_key_lt, 12);
        x1(R.id.view_key_l3, 14);
        x1(R.id.view_key_m1, 39);
        x1(R.id.view_key_select, 6);
        x1(R.id.view_key_lta, 21);
        x1(R.id.view_key_ltb, 22);
        x1(R.id.view_key_lba, 29);
        x1(R.id.view_key_lbb, 30);
        x1(R.id.view_key_combo, 256);
        if (m9.t.b(this.f56484g)) {
            ExpandView expandView = this.K7.get(256);
            if (expandView != null) {
                expandView.setVisibility(0);
            }
            ExpandView expandView2 = this.K7.get(21);
            if (expandView2 != null) {
                expandView2.setVisibility(8);
            }
            ExpandView expandView3 = this.K7.get(22);
            if (expandView3 != null) {
                expandView3.setVisibility(8);
            }
            ExpandView expandView4 = this.K7.get(29);
            if (expandView4 != null) {
                expandView4.setVisibility(8);
            }
            ExpandView expandView5 = this.K7.get(30);
            if (expandView5 != null) {
                expandView5.setVisibility(8);
            }
        } else {
            ExpandView expandView6 = this.K7.get(256);
            if (expandView6 != null) {
                expandView6.setVisibility(8);
            }
            ExpandView expandView7 = this.K7.get(21);
            if (expandView7 != null) {
                expandView7.setVisibility(0);
            }
            ExpandView expandView8 = this.K7.get(22);
            if (expandView8 != null) {
                expandView8.setVisibility(0);
            }
            ExpandView expandView9 = this.K7.get(29);
            if (expandView9 != null) {
                expandView9.setVisibility(0);
            }
            ExpandView expandView10 = this.K7.get(30);
            if (expandView10 != null) {
                expandView10.setVisibility(0);
            }
        }
        for (Integer num : this.K7.keySet()) {
            ExpandView expandView11 = this.K7.get(num);
            if (expandView11 != null && num.intValue() != 256 && !this.f56484g.containKey(num.intValue())) {
                expandView11.setAlpha(0.5f);
            }
        }
    }

    public final void u1() {
        if (this.f56484g.isGamepadWhole()) {
            z1();
        } else if (this.f56484g.isGamepadKeyboard()) {
            v1();
        } else if (this.f56484g.isGamepadHalf()) {
            if (this.f56484g.getDeviceType() == 68) {
                s1();
            } else {
                t1();
            }
        }
        View viewInflate = View.inflate(this.f56478a, R.layout.floatview_widget_key_listen, null);
        this.f15734v = viewInflate;
        ((TextView) viewInflate.findViewById(R.id.wait_click_text)).setText(n8.b.l(this.f56478a, this.f56484g.getDeviceMode()));
        this.f15734v.setOnClickListener(this);
        this.f15734v.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15695a.H1(view);
            }
        });
        this.f15734v.setVisibility(8);
        this.f15731s.addView(this.f15734v);
        FrameLayout frameLayout = this.f15731s;
        View view = this.f15734v;
        frameLayout.updateViewLayout(view, view.getLayoutParams());
    }

    public final void v1() {
        View viewInflate = View.inflate(this.f56478a, R.layout.floatview_layout_key_panel_keyboard, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        viewInflate.setLayoutParams(layoutParams);
        this.f15733u.addView(viewInflate);
        x1(R.id.view_key_wasd, 240);
        x1(R.id.view_key_mouse, 116);
        x1(R.id.view_key_mouse_left, 100);
        x1(R.id.view_key_mouse_right, 101);
        x1(R.id.view_key_mouse_middle, 102);
        x1(R.id.view_key_mouse_middle_up, 105);
        x1(R.id.view_key_mouse_middle_down, 106);
        x1(R.id.view_key_mouse_forward, 104);
        x1(R.id.view_key_mouse_backward, 103);
        x1(R.id.view_key_ctrl, 109);
        x1(R.id.view_key_shift, 108);
        x1(R.id.view_key_alt, 111);
        x1(R.id.view_key_win, 110);
        x1(R.id.view_key_place_holder, -1);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void w1() {
        this.f15732t = (FrameLayout) View.inflate(this.f56478a, R.layout.floatview_layout_setting_config_menu, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f56478a.getResources().getDimensionPixelSize(R.dimen.qb_px_20);
        this.f15732t.setLayoutParams(layoutParams);
        this.f15731s.addView(this.f15732t);
        this.f15730r = new TextView(this.f56478a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 8388691;
        Resources resources = this.f56478a.getResources();
        int i10 = R.dimen.qb_px_16;
        layoutParams2.bottomMargin = resources.getDimensionPixelSize(i10);
        layoutParams2.leftMargin = this.f56478a.getResources().getDimensionPixelSize(i10);
        this.f15730r.setLayoutParams(layoutParams2);
        this.f15730r.setBackgroundResource(R.color.color_000000_a90);
        TextView textView = this.f15730r;
        Context context = this.f56478a;
        int i11 = R.color.color_white;
        textView.setTextColor(h0.d.f(context, i11));
        this.f15730r.setTextSize(0, this.f56478a.getResources().getDimensionPixelSize(R.dimen.sp_10));
        this.f15731s.addView(this.f15730r);
        View viewFindViewById = this.f15732t.findViewById(R.id.button_menu_move_bar);
        viewFindViewById.setClickable(true);
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.flydigi.float_view.ui.config.u1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f15706a.I1(view, motionEvent);
            }
        });
        com.blankj.utilcode.util.o.r(this.f15731s.findViewById(R.id.btn_save_as), this);
        com.blankj.utilcode.util.o.r(this.f15731s.findViewById(R.id.btn_test), this);
        com.blankj.utilcode.util.o.r(this.f15731s.findViewById(R.id.btn_cancel), this);
        com.blankj.utilcode.util.o.r(this.f15731s.findViewById(R.id.btn_apply), this);
        ImageView imageView = (ImageView) this.f15731s.findViewById(R.id.iv_expand);
        this.M7 = imageView;
        com.blankj.utilcode.util.o.r(imageView, this);
        FrameLayout frameLayout = (FrameLayout) this.f15732t.findViewById(R.id.ll_panel_key);
        this.f15733u = frameLayout;
        com.blankj.utilcode.util.o.r(frameLayout, this);
        W1(true);
        int dimensionPixelSize = this.f56478a.getResources().getDimensionPixelSize(R.dimen.qb_px_1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        SuperLine superLine = new SuperLine(this.f56478a);
        this.A = superLine;
        superLine.setLineColor(h0.d.f(this.f56478a, i11));
        SuperLine superLine2 = this.A;
        Context context2 = this.f56478a;
        int i12 = R.color.transparent;
        superLine2.setLineDashGapColor(h0.d.f(context2, i12));
        SuperLine superLine3 = this.A;
        Resources resources2 = this.f56478a.getResources();
        int i13 = R.dimen.qb_px_4;
        superLine3.setLineDashGapWidth(resources2.getDimensionPixelSize(i13));
        this.A.setLineDashWidth(this.f56478a.getResources().getDimensionPixelSize(i13));
        this.A.setOrientation(2);
        this.A.setLayoutParams(layoutParams3);
        this.A.setVisibility(4);
        this.A.setLayerType(1, null);
        this.f15731s.addView(this.A);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(dimensionPixelSize, -1);
        SuperLine superLine4 = new SuperLine(this.f56478a);
        this.B = superLine4;
        superLine4.setLineColor(h0.d.f(this.f56478a, i11));
        this.B.setLineDashGapColor(h0.d.f(this.f56478a, i12));
        this.B.setLineDashGapWidth(this.f56478a.getResources().getDimensionPixelSize(i13));
        this.B.setLineDashWidth(this.f56478a.getResources().getDimensionPixelSize(i13));
        this.B.setOrientation(1);
        this.B.setLayoutParams(layoutParams4);
        this.B.setLayerType(1, null);
        this.B.setVisibility(4);
        this.f15731s.addView(this.B);
    }

    public final void x1(int i10, int i11) {
        ExpandView expandView = (ExpandView) this.f15733u.findViewById(i10);
        expandView.setTag(Integer.valueOf(i11));
        expandView.i(i11, this.f56484g, false);
        if ((i11 == 6 || i11 == 39) && (this.f56484g.getDeviceType() == 65 || this.f56484g.getDeviceType() == 66 || this.f56484g.getDeviceType() == 64)) {
            expandView.setVisibility(8);
        }
        this.K7.put(Integer.valueOf(i11), expandView);
    }

    @Override // y7.b
    public void y() {
        super.y();
        u9.b.s(this.f56478a);
    }

    public final void y1() {
        if (this.D == null) {
            this.D = new CFGEntity();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.D.keyList);
        for (int i10 = 0; i10 < copyOnWriteArrayList.size(); i10++) {
            CFGPropertyKey cFGPropertyKey = (CFGPropertyKey) copyOnWriteArrayList.get(i10);
            int i11 = cFGPropertyKey.key_id;
            if (i11 >= 0 && com.flydigi.sdk.gamepad.extension.a.b(this.f56484g, i11, cFGPropertyKey.comboKeyFirst, cFGPropertyKey.comboKeySecond)) {
                b1(cFGPropertyKey);
            }
        }
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.D.jsList);
        for (int i12 = 0; i12 < copyOnWriteArrayList2.size(); i12++) {
            CFGPropertyJS cFGPropertyJS = (CFGPropertyJS) copyOnWriteArrayList2.get(i12);
            if (com.flydigi.sdk.gamepad.extension.a.b(this.f56484g, cFGPropertyJS.key_id, -1, -1) && (cFGPropertyJS.key_id != 242 || (this.f56484g.getDeviceType() == 19 && (!this.f56484g.isFlashplayMode() || l9.c.b(m9.k.f40830p, this.f56484g.getFirmwareVersion()))))) {
                a1(cFGPropertyJS);
            }
        }
        CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList(this.D.marcoList);
        for (int i13 = 0; i13 < copyOnWriteArrayList3.size(); i13++) {
            CFGPropertyMacro cFGPropertyMacro = (CFGPropertyMacro) copyOnWriteArrayList3.get(i13);
            int i14 = cFGPropertyMacro.key_id;
            if (i14 >= 0 && com.flydigi.sdk.gamepad.extension.a.b(this.f56484g, i14, cFGPropertyMacro.comboKeyFirst, cFGPropertyMacro.comboKeySecond)) {
                x7.f.f54912s += cFGPropertyMacro.macro_keys.size();
                d1(cFGPropertyMacro);
            }
        }
        g1();
        this.f15731s.removeView(this.f15732t);
        this.f15731s.addView(this.f15732t);
        FrameLayout frameLayout = this.f15731s;
        if (frameLayout != null) {
            frameLayout.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.m1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15677a.K1();
                }
            });
        }
    }

    public final void z1() {
        View viewInflate = View.inflate(this.f56478a, R.layout.floatview_layout_key_panel_whole, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        viewInflate.setLayoutParams(layoutParams);
        this.f15733u.addView(viewInflate);
        A1();
        C1();
        B1();
        this.N7 = this.f15732t.findViewById(R.id.btn_key_basic);
        this.O7 = (TextView) this.f15732t.findViewById(R.id.tv_key_basic);
        this.P7 = this.f15732t.findViewById(R.id.indicator_key_basic);
        this.Q7 = this.f15732t.findViewById(R.id.btn_key_other);
        this.R7 = (TextView) this.f15732t.findViewById(R.id.tv_key_other);
        this.S7 = this.f15732t.findViewById(R.id.indicator_key_other);
        this.T7 = this.f15732t.findViewById(R.id.btn_key_combination);
        this.U7 = (TextView) this.f15732t.findViewById(R.id.tv_key_combination);
        this.V7 = this.f15732t.findViewById(R.id.indicator_key_combination);
        this.W7 = this.f15732t.findViewById(R.id.panel_key_basic);
        this.X7 = this.f15732t.findViewById(R.id.panel_key_other);
        this.Y7 = this.f15732t.findViewById(R.id.panel_key_combination);
        V1(this.N7);
        this.N7.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.t1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15703a.L1(view);
            }
        });
        this.Q7.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15699a.M1(view);
            }
        });
        this.T7.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15692a.N1(view);
            }
        });
        for (Integer num : this.K7.keySet()) {
            ExpandView expandView = this.K7.get(num);
            if (expandView != null && num.intValue() != 256 && !this.f56484g.containKey(num.intValue())) {
                expandView.setAlpha(0.5f);
            }
        }
        if (m9.t.b(this.f56484g)) {
            this.T7.setVisibility(8);
            ExpandView expandView2 = this.K7.get(256);
            if (expandView2 != null) {
                expandView2.setVisibility(0);
                return;
            }
            return;
        }
        this.T7.setVisibility(0);
        ExpandView expandView3 = this.K7.get(256);
        if (expandView3 != null) {
            expandView3.setVisibility(8);
        }
    }
}

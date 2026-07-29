package z7;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.data.event.FlyMouseEvent;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.ExpandView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import i9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public class r0 extends y7.b implements View.OnTouchListener, View.OnGenericMotionListener {
    public static final int D = 100;
    public final Runnable A;
    public long B;
    public int C;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f57885p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CFGEntity f57886q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Handler f57887r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SuperButton f57888s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f57889t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<Button> f57890u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f57891v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f57892w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<Integer, Button> f57893x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f57894y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f57895z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r0.this.f57895z.setVisibility(4);
        }
    }

    public r0(Context context, CFGEntity cFGEntity, Handler handler, int i10, int i11, GamepadInfo gamepadInfo) {
        super(context, (y7.n) null, gamepadInfo);
        this.f57890u = new ArrayList();
        this.f57893x = new HashMap();
        this.f57894y = com.blankj.utilcode.util.b1.b(8.0f);
        this.A = new a();
        this.B = 0L;
        this.C = 0;
        this.f57886q = cFGEntity;
        this.f57887r = handler;
        this.f57891v = i10;
        this.f57892w = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        this.f57887r.sendEmptyMessage(121);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(FlyMouseEvent flyMouseEvent) {
        this.f57895z.setVisibility(0);
        this.f57895z.setX(flyMouseEvent.f14355x);
        this.f57895z.setY(flyMouseEvent.f14356y);
    }

    public final Button E() {
        for (int i10 = 0; i10 < this.f57890u.size(); i10++) {
            Button button = this.f57890u.get(i10);
            if (button.getVisibility() == 8) {
                return button;
            }
        }
        return null;
    }

    public final void F() {
        for (int i10 = 0; i10 < this.f57886q.keyList.size(); i10++) {
            CFGPropertyKey cFGPropertyKey = this.f57886q.keyList.get(i10);
            int i11 = cFGPropertyKey.key_id;
            if (i11 != -1 && com.flydigi.sdk.gamepad.extension.a.b(this.f56484g, i11, cFGPropertyKey.comboKeyFirst, cFGPropertyKey.comboKeySecond)) {
                ExpandView expandView = new ExpandView(this.f56478a);
                expandView.k(cFGPropertyKey, this.f56484g, false);
                expandView.setX((this.f57891v * cFGPropertyKey.f16347x) - (expandView.getLayoutParams().width / 2.0f));
                expandView.setY((this.f57892w * cFGPropertyKey.f16348y) - (expandView.getLayoutParams().height / 2.0f));
                this.f57885p.addView(expandView);
            }
        }
        for (int i12 = 0; i12 < this.f57886q.jsList.size(); i12++) {
            CFGPropertyJS cFGPropertyJS = this.f57886q.jsList.get(i12);
            if ((this.f56484g.isSupportLunpan() || cFGPropertyJS.key_id != 242) && com.flydigi.sdk.gamepad.extension.a.b(this.f56484g, cFGPropertyJS.key_id, -1, -1)) {
                ExpandView expandView2 = new ExpandView(this.f56478a);
                expandView2.j(cFGPropertyJS, this.f56484g, false);
                expandView2.setX((this.f57891v * cFGPropertyJS.f16345x) - (expandView2.getLayoutParams().width / 2.0f));
                expandView2.setY((this.f57892w * cFGPropertyJS.f16346y) - (expandView2.getLayoutParams().width / 2.0f));
                this.f57885p.addView(expandView2);
            }
        }
        for (int i13 = 0; i13 < this.f57886q.marcoList.size(); i13++) {
            CFGPropertyMacro cFGPropertyMacro = this.f57886q.marcoList.get(i13);
            int i14 = cFGPropertyMacro.key_id;
            if (i14 != -1 && com.flydigi.sdk.gamepad.extension.a.b(this.f56484g, i14, cFGPropertyMacro.comboKeyFirst, cFGPropertyMacro.comboKeySecond)) {
                ExpandView expandView3 = new ExpandView(this.f56478a);
                expandView3.l(cFGPropertyMacro, this.f56484g, false);
                expandView3.setX((this.f57891v * cFGPropertyMacro.macro_keys.get(0).getX()) - (expandView3.getLayoutParams().width / 2.0f));
                expandView3.setY((this.f57892w * cFGPropertyMacro.macro_keys.get(0).getY()) - (expandView3.getLayoutParams().width / 2.0f));
                this.f57885p.addView(expandView3);
            }
        }
        this.f57885p.removeView(this.f57888s);
        this.f57885p.addView(this.f57888s);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_mapping_test;
    }

    @Override // y7.b
    public void n() {
        this.f57885p = (ViewGroup) this.f56479b.findViewById(R.id.rl_root);
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point1));
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point2));
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point3));
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point4));
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point5));
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point6));
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point7));
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point8));
        this.f57890u.add((Button) this.f56479b.findViewById(R.id.btn_touch_point9));
        this.f57885p.setOnTouchListener(this);
        this.f57885p.setOnGenericMotionListener(this);
        this.f57889t = (TextView) this.f56479b.findViewById(R.id.tv_notice);
        if (this.f56484g.isFlashplayMode()) {
            int deviceMode = this.f56484g.getDeviceMode();
            if (deviceMode == 0) {
                this.f57889t.setText(this.f56478a.getString(R.string.floatview_pressed_device_key_start_mapping_test_flashplay_gamepad_whole));
            } else if (deviceMode == 1) {
                this.f57889t.setText(this.f56478a.getString(R.string.floatview_pressed_device_key_start_mapping_test_flashplay_keyboard));
            } else if (deviceMode == 2) {
                this.f57889t.setText(this.f56478a.getString(R.string.floatview_pressed_device_key_start_mapping_test_flashplay_gamepad_half));
            }
        } else {
            int deviceMode2 = this.f56484g.getDeviceMode();
            if (deviceMode2 == 0) {
                this.f57889t.setText(this.f56478a.getString(R.string.floatview_pressed_device_key_start_mapping_test_tradition_gamepad_whole));
            } else if (deviceMode2 == 1) {
                this.f57889t.setText(this.f56478a.getString(R.string.floatview_pressed_device_key_start_mapping_test_tradition_keyboard));
            } else if (deviceMode2 == 2) {
                this.f57889t.setText(this.f56478a.getString(R.string.floatview_pressed_device_key_start_mapping_test_tradition_gamepad_half));
            }
        }
        SuperButton superButton = (SuperButton) this.f56479b.findViewById(R.id.iv_close);
        this.f57888s = superButton;
        superButton.setOnClickListener(new View.OnClickListener() { // from class: z7.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57881a.G(view);
            }
        });
        this.f57895z = (ImageView) this.f56479b.findViewById(R.id.iv_cursor);
        F();
        y();
        u9.b.u(this.f56478a);
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).h(this.f56478a, DataConstant.REMOTE_ACTION_CONFIG_TEST, DataConstant.REMOTE_ACTION_CONFIG, this.f57886q);
        v();
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(final FlyMouseEvent flyMouseEvent) {
        if (this.B == 0 || System.currentTimeMillis() - this.B > 17) {
            this.B = System.currentTimeMillis();
            if (flyMouseEvent.show) {
                this.f56483f.post(new Runnable() { // from class: z7.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f57883a.H(flyMouseEvent);
                    }
                });
            }
        }
        this.f56483f.removeCallbacks(this.A);
        this.f56483f.postDelayed(this.A, 100L);
    }

    @Override // android.view.View.OnGenericMotionListener
    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z7.r0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }
}

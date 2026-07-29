package com.flydigi.device_manager.cooperate.cjzc.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.cooperate.cjzc.bean.EntityCJZCAction;
import com.flydigi.device_manager.cooperate.cjzc.ui.Activity_CJZC_Listen_Special;
import com.flydigi.device_manager.d;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.tencent.connect.common.Constants;
import h9.f;
import java.util.ArrayList;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public class Activity_CJZC_Listen_Special extends d implements View.OnClickListener {
    public ImageView J7;
    public ImageView K7;
    public TextView L7;
    public TextView M7;
    public TextView N7;
    public TextView O7;
    public TextView P7;
    public TextView Q7;
    public ImageView R7;
    public View S7;
    public View T7;
    public View U7;
    public ImageView V7;
    public View W7;
    public View X7;
    public View Y7;
    public View Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public View f14421a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public View f14422b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public View f14423c8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public int f14425e8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public final ArrayList<View> f14424d8 = new ArrayList<>();

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public int f14426f8 = 0;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public EntityCJZCAction f14427g8 = null;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public final int f14428h8 = 2;

    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBar f14429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f14430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Button f14431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Button f14432d;

        public a(SeekBar seekBar, TextView textView, Button button, Button button2) {
            this.f14429a = seekBar;
            this.f14430b = textView;
            this.f14431c = button;
            this.f14432d = button2;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (this.f14429a.getId() == 2) {
                this.f14430b.setText((i10 + 10) + i6.a.f31863g);
            } else {
                this.f14430b.setText(String.valueOf(i10 + 1));
            }
            if (this.f14429a.getProgress() < this.f14429a.getMax()) {
                this.f14431c.setBackgroundResource(R.drawable.flydigi_btn_increase_blue);
            } else {
                this.f14431c.setBackgroundResource(R.drawable.flydigi_btn_increase_gray);
            }
            if (this.f14429a.getProgress() > 0) {
                this.f14432d.setBackgroundResource(R.drawable.flydigi_btn_decrease_blue);
            } else {
                this.f14432d.setBackgroundResource(R.drawable.flydigi_btn_decrease_gray);
            }
            if (((Boolean) this.f14429a.getTag()).booleanValue()) {
                int id2 = this.f14429a.getId();
                if (id2 == 0) {
                    ((z6.a) Activity_CJZC_Listen_Special.this.f14422b8.getTag()).e().setProgress(this.f14429a.getProgress());
                    ((z6.a) Activity_CJZC_Listen_Special.this.f14422b8.getTag()).f().setText(String.valueOf(i10 + 1));
                } else {
                    if (id2 != 1) {
                        return;
                    }
                    ((z6.a) Activity_CJZC_Listen_Special.this.f14421a8.getTag()).e().setProgress(this.f14429a.getProgress());
                    ((z6.a) Activity_CJZC_Listen_Special.this.f14421a8.getTag()).f().setText(String.valueOf(i10 + 1));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public class b extends f {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U0(byte[] bArr) {
            Activity_CJZC_Listen_Special.this.F4(bArr);
        }

        @Override // h9.f, h9.d
        public void A(@k final byte[] bArr) {
            super.A(bArr);
            Activity_CJZC_Listen_Special.this.c4().e(new Runnable() { // from class: a7.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f298a.U0(bArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J4(View view) {
        if (this.f14425e8 == 6) {
            return;
        }
        if (((Boolean) this.T7.getTag()).booleanValue()) {
            this.T7.setTag(Boolean.FALSE);
            this.T7.setBackgroundResource(R.drawable.cjzc_bg_listen_white);
            this.N7.setText("（点击下方按钮进行改键）");
        } else {
            this.f14426f8 = 1;
            this.T7.setTag(Boolean.TRUE);
            this.T7.setBackgroundResource(R.drawable.cjzc_bg_listen_blue);
            this.N7.setText("（按下您想要的键即可）");
            this.U7.setTag(Boolean.FALSE);
            this.U7.setBackgroundResource(R.drawable.cjzc_bg_listen_white);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K4(View view) {
        if (((Boolean) this.U7.getTag()).booleanValue()) {
            this.U7.setTag(Boolean.FALSE);
            this.U7.setBackgroundResource(R.drawable.cjzc_bg_listen_white);
            return;
        }
        this.f14426f8 = 2;
        this.U7.setTag(Boolean.TRUE);
        this.U7.setBackgroundResource(R.drawable.cjzc_bg_listen_blue);
        this.T7.setTag(Boolean.FALSE);
        this.T7.setBackgroundResource(R.drawable.cjzc_bg_listen_white);
    }

    public static /* synthetic */ void L4(SeekBar seekBar, View view) {
        if (seekBar.getProgress() > 0) {
            seekBar.setProgress(seekBar.getProgress() - 1);
        }
    }

    public static /* synthetic */ void M4(SeekBar seekBar, View view) {
        if (seekBar.getProgress() < seekBar.getMax()) {
            seekBar.setProgress(seekBar.getProgress() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N4(View view) {
        if (((Boolean) this.V7.getTag()).booleanValue()) {
            ImageView imageView = this.V7;
            Boolean bool = Boolean.FALSE;
            imageView.setTag(bool);
            this.V7.setBackgroundResource(R.drawable.flydigi_sync_no);
            ((z6.a) this.f14421a8.getTag()).j(bool);
            ((z6.a) this.f14422b8.getTag()).j(bool);
            View view2 = this.W7;
            Resources resources = getResources();
            int i10 = R.color.color_gray_99999F;
            view2.setBackgroundColor(resources.getColor(i10));
            this.X7.setBackgroundColor(getResources().getColor(i10));
            this.Y7.setBackgroundColor(getResources().getColor(i10));
            this.Z7.setBackgroundColor(getResources().getColor(i10));
            return;
        }
        ImageView imageView2 = this.V7;
        Boolean bool2 = Boolean.TRUE;
        imageView2.setTag(bool2);
        this.V7.setBackgroundResource(R.drawable.flydigi_sync_yes);
        ((z6.a) this.f14421a8.getTag()).j(bool2);
        ((z6.a) this.f14422b8.getTag()).j(bool2);
        ((z6.a) this.f14422b8.getTag()).e().setProgress(((z6.a) this.f14421a8.getTag()).e().getProgress());
        View view3 = this.W7;
        Resources resources2 = getResources();
        int i11 = R.color.colorPrimary;
        view3.setBackgroundColor(resources2.getColor(i11));
        this.X7.setBackgroundColor(getResources().getColor(i11));
        this.Y7.setBackgroundColor(getResources().getColor(i11));
        this.Z7.setBackgroundColor(getResources().getColor(i11));
    }

    public final void F4(byte[] bArr) {
        if (this.f14426f8 == 0 || !m9.b.M(bArr) || o4() == null) {
            return;
        }
        int i10 = bArr[4] & 255;
        int i11 = bArr[5] & 255;
        int i12 = bArr[8] & 255;
        int i13 = bArr[9] & 255;
        ArrayList arrayList = new ArrayList();
        if (!o4().isGamepadKeyboard()) {
            if ((i11 & 16) != 0) {
                arrayList.add(12);
            }
            if ((i11 & 4) != 0) {
                arrayList.add(10);
            }
            if ((i11 & 32) != 0) {
                arrayList.add(13);
            }
            if ((i11 & 8) != 0) {
                arrayList.add(11);
            }
            if ((i10 & 1) != 0) {
                arrayList.add(0);
            }
            if ((i10 & 8) != 0) {
                arrayList.add(3);
            }
            if ((i10 & 2) != 0) {
                arrayList.add(1);
            }
            if ((i10 & 4) != 0) {
                arrayList.add(2);
            }
            if ((i11 & 1) != 0) {
                arrayList.add(8);
            }
            if ((i10 & 128) != 0) {
                arrayList.add(7);
            }
            if ((i10 & 16) != 0) {
                arrayList.add(4);
            }
            if ((i10 & 32) != 0) {
                arrayList.add(5);
            }
            if ((i10 & 64) != 0) {
                arrayList.add(6);
            }
            if ((i11 & 2) != 0) {
                arrayList.add(9);
            }
            if ((i11 & 128) != 0) {
                arrayList.add(15);
            }
            if ((i11 & 64) != 0) {
                arrayList.add(14);
            }
            if ((i12 & 16) != 0) {
                arrayList.add(28);
            }
            if ((i12 & 8) != 0) {
                arrayList.add(27);
            }
            if ((i12 & 1) != 0) {
                arrayList.add(24);
            }
            if ((i13 & 1) != 0) {
                arrayList.add(16);
            }
            if ((i13 & 2) != 0) {
                arrayList.add(17);
            }
            if ((i13 & 4) != 0) {
                arrayList.add(18);
            }
            if ((i13 & 8) != 0) {
                arrayList.add(19);
            }
            if ((i13 & 16) != 0) {
                arrayList.add(20);
            }
            if ((i13 & 32) != 0) {
                arrayList.add(21);
            }
        } else if (o4().isGamepadKeyboard()) {
            if (i11 == 0 && i12 == 0 && i13 == Integer.parseInt("80", 16)) {
                return;
            }
            if (i11 != 0) {
                arrayList.add(Integer.valueOf(i11));
            }
            if (i12 == Integer.parseInt("01", 16) || i12 == Integer.parseInt(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, 16)) {
                arrayList.add(109);
            }
            if (i12 == Integer.parseInt("02", 16) || i12 == Integer.parseInt("20", 16)) {
                arrayList.add(108);
            }
            if (i12 == Integer.parseInt("04", 16) || i12 == Integer.parseInt("40", 16)) {
                arrayList.add(111);
            }
            if (i12 == Integer.parseInt("08", 16) || i12 == Integer.parseInt("80", 16)) {
                arrayList.add(110);
            }
            if (i13 == Integer.parseInt("81", 16)) {
                arrayList.add(100);
            }
            if (i13 == Integer.parseInt("82", 16)) {
                arrayList.add(101);
            }
            if (i13 == Integer.parseInt("84", 16)) {
                arrayList.add(102);
            }
            if (i13 == Integer.parseInt("90", 16)) {
                arrayList.add(104);
            }
            if (i13 == Integer.parseInt("88", 16)) {
                arrayList.add(103);
            }
            if (i13 == Integer.parseInt("a0", 16)) {
                arrayList.add(105);
            }
            if (i13 == Integer.parseInt("c0", 16)) {
                arrayList.add(106);
            }
        }
        if (arrayList.size() != 0) {
            if (this.f14426f8 == 1) {
                this.f14427g8.n(((Integer) arrayList.get(0)).intValue());
                this.f14426f8 = 0;
                if (!o4().isGamepadKeyboard()) {
                    this.J7.setImageResource(x6.a.g(((Integer) arrayList.get(0)).intValue()));
                } else if (o4().isGamepadKeyboard()) {
                    this.J7.setImageResource(x6.a.h(((Integer) arrayList.get(0)).intValue()));
                }
                this.T7.setTag(Boolean.FALSE);
                this.T7.setBackgroundResource(R.drawable.cjzc_bg_listen_white);
                this.N7.setText("（点击下方按钮进行改键）");
            }
            if (this.f14426f8 == 2) {
                this.f14427g8.o(((Integer) arrayList.get(0)).intValue());
                this.f14426f8 = 0;
                if (!o4().isGamepadKeyboard()) {
                    this.K7.setImageResource(x6.a.g(((Integer) arrayList.get(0)).intValue()));
                } else if (o4().isGamepadKeyboard()) {
                    this.K7.setImageResource(x6.a.h(((Integer) arrayList.get(0)).intValue()));
                }
                this.U7.setTag(Boolean.FALSE);
                this.U7.setBackgroundResource(R.drawable.cjzc_bg_listen_white);
            }
        }
    }

    public final void G4() {
        if (o4() == null) {
            return;
        }
        this.f14425e8 = this.f14427g8.b();
        if (!o4().isGamepadKeyboard()) {
            this.J7.setImageResource(x6.a.g(this.f14427g8.d()));
        } else if (o4().isGamepadKeyboard()) {
            this.J7.setImageResource(x6.a.h(this.f14427g8.d()));
        }
        int i10 = this.f14425e8;
        if (i10 == 5) {
            this.L7.setText("体感设置");
            this.M7.setText("体感按键");
            this.N7.setText("（点击下方按钮进行改键）");
            this.O7.setText("体感灵敏度");
            this.P7.setText("（推荐设置20，越大转速越快）");
            this.Q7.setText("（按住可切换体感灵敏度）");
            return;
        }
        if (i10 != 6) {
            return;
        }
        this.L7.setText("转向设置");
        if (!o4().isGamepadKeyboard()) {
            this.M7.setText("右摇杆");
            this.O7.setText("右摇杆灵敏度");
            this.Q7.setText("（按住可切换右摇杆灵敏度）");
        } else if (o4().isGamepadKeyboard()) {
            this.M7.setText("鼠标");
            this.O7.setText("鼠标灵敏度");
            this.Q7.setText("（按住可切换鼠标灵敏度）");
        }
        this.N7.setText("（当前按键不可修改）");
        this.P7.setText("（推荐设置20，越大转速越快）");
    }

    public final void H4() {
        if (o4() == null) {
            return;
        }
        if (!o4().isGamepadKeyboard()) {
            this.K7.setImageResource(x6.a.g(this.f14427g8.f()));
        } else if (o4().isGamepadKeyboard()) {
            this.K7.setImageResource(x6.a.h(this.f14427g8.f()));
        }
    }

    public final void I4() {
        this.L7 = (TextView) findViewById(R.id.title);
        this.M7 = (TextView) findViewById(R.id.key_title);
        this.N7 = (TextView) findViewById(R.id.key_notice);
        this.O7 = (TextView) findViewById(R.id.senty_title);
        this.P7 = (TextView) findViewById(R.id.senty_notice);
        this.Q7 = (TextView) findViewById(R.id.senior_senty_notice);
        this.J7 = (ImageView) findViewById(R.id.image_basic_key);
        this.K7 = (ImageView) findViewById(R.id.image_senior_key);
        ImageView imageView = (ImageView) findViewById(R.id.advanced_setting);
        this.R7 = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.R7;
        Boolean bool = Boolean.FALSE;
        imageView2.setTag(bool);
        this.S7 = findViewById(R.id.layout_advanced_setting);
        TextView textView = (TextView) findViewById(R.id.cancel);
        TextView textView2 = (TextView) findViewById(R.id.confirm);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        this.T7 = findViewById(R.id.layout_key_1);
        this.U7 = findViewById(R.id.layout_key_2);
        this.T7.setTag(bool);
        this.U7.setTag(bool);
        this.T7.setOnClickListener(new View.OnClickListener() { // from class: a7.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f297a.J4(view);
            }
        });
        this.U7.setOnClickListener(new View.OnClickListener() { // from class: a7.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f296a.K4(view);
            }
        });
        findViewById(R.id.layout_parent).setOnClickListener(this);
        this.f14421a8 = findViewById(R.id.layout_bar_1);
        this.f14422b8 = findViewById(R.id.layout_bar_2);
        this.f14423c8 = findViewById(R.id.layout_bar_3);
        View view = this.f14421a8;
        int i10 = R.id.name;
        ((TextView) view.findViewById(i10)).setText("左右");
        ((TextView) this.f14422b8.findViewById(i10)).setText("上下");
        ((TextView) this.f14423c8.findViewById(i10)).setText("");
        this.f14424d8.add(this.f14421a8);
        this.f14424d8.add(this.f14422b8);
        this.f14424d8.add(this.f14423c8);
        for (int i11 = 0; i11 < this.f14424d8.size(); i11++) {
            z6.a aVar = new z6.a();
            aVar.k((SeekBar) this.f14424d8.get(i11).findViewById(R.id.seekbar));
            aVar.g((Button) this.f14424d8.get(i11).findViewById(R.id.btn_minus));
            aVar.h((Button) this.f14424d8.get(i11).findViewById(R.id.btn_plus));
            aVar.l((TextView) this.f14424d8.get(i11).findViewById(R.id.value));
            aVar.i(i11);
            aVar.j(Boolean.FALSE);
            this.f14424d8.get(i11).setTag(aVar);
        }
        for (int i12 = 0; i12 < this.f14424d8.size(); i12++) {
            z6.a aVar2 = (z6.a) this.f14424d8.get(i12).getTag();
            final SeekBar seekBarE = aVar2.e();
            Button buttonA = aVar2.a();
            Button buttonB = aVar2.b();
            seekBarE.setOnSeekBarChangeListener(new a(seekBarE, aVar2.f(), buttonB, buttonA));
            buttonA.setOnClickListener(new View.OnClickListener() { // from class: a7.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Activity_CJZC_Listen_Special.L4(seekBarE, view2);
                }
            });
            buttonB.setOnClickListener(new View.OnClickListener() { // from class: a7.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Activity_CJZC_Listen_Special.M4(seekBarE, view2);
                }
            });
            int iC = aVar2.c();
            if (iC == 0) {
                seekBarE.setMax(99);
                seekBarE.setProgress(50);
            } else if (iC == 1) {
                seekBarE.setMax(99);
                seekBarE.setProgress(50);
            } else if (iC == 2) {
                seekBarE.setMax(190);
                seekBarE.setProgress(99);
            }
        }
        this.W7 = findViewById(R.id.view_line_1);
        this.X7 = findViewById(R.id.view_line_2);
        this.Y7 = findViewById(R.id.view_line_3);
        this.Z7 = findViewById(R.id.view_line_4);
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_locking_1);
        this.V7 = imageView3;
        imageView3.setTag(Boolean.FALSE);
        this.V7.setOnClickListener(new View.OnClickListener() { // from class: a7.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f295a.N4(view2);
            }
        });
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_cjzc_listen_special;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.layout_parent) {
            finish();
            return;
        }
        if (id2 == R.id.cancel) {
            finish();
            return;
        }
        if (id2 != R.id.confirm) {
            if (id2 == R.id.advanced_setting) {
                if (((Boolean) this.R7.getTag()).booleanValue()) {
                    this.R7.setTag(Boolean.FALSE);
                    this.R7.setBackgroundResource(R.drawable.flydigi_btn_switch_off);
                    this.S7.setVisibility(8);
                    return;
                } else {
                    this.R7.setTag(Boolean.TRUE);
                    this.R7.setBackgroundResource(R.drawable.flydigi_btn_switch_on);
                    this.S7.setVisibility(0);
                    return;
                }
            }
            return;
        }
        SeekBar seekBarE = ((z6.a) this.f14421a8.getTag()).e();
        SeekBar seekBarE2 = ((z6.a) this.f14422b8.getTag()).e();
        SeekBar seekBarE3 = ((z6.a) this.f14423c8.getTag()).e();
        this.f14427g8.q(seekBarE.getProgress() + 1);
        this.f14427g8.r(seekBarE2.getProgress() + 1);
        this.f14427g8.p((int) (((seekBarE3.getProgress() + 10) / 100.0f) * 63.0f));
        if (!((Boolean) this.R7.getTag()).booleanValue()) {
            this.f14427g8.o(-1);
        }
        Intent intent = new Intent();
        intent.putExtra("data", this.f14427g8);
        setResult(100, intent);
        finish();
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
        this.f14427g8 = (EntityCJZCAction) getIntent().getSerializableExtra("data");
        I4();
        SeekBar seekBarE = ((z6.a) this.f14421a8.getTag()).e();
        SeekBar seekBarE2 = ((z6.a) this.f14422b8.getTag()).e();
        SeekBar seekBarE3 = ((z6.a) this.f14423c8.getTag()).e();
        seekBarE.setProgress(this.f14427g8.i() - 1);
        seekBarE2.setProgress(this.f14427g8.k() - 1);
        if (this.f14427g8.i() == this.f14427g8.k()) {
            ImageView imageView = this.V7;
            Boolean bool = Boolean.TRUE;
            imageView.setTag(bool);
            this.V7.setBackgroundResource(R.drawable.flydigi_sync_yes);
            ((z6.a) this.f14421a8.getTag()).j(bool);
            ((z6.a) this.f14422b8.getTag()).j(bool);
            View view = this.W7;
            Resources resources = getResources();
            int i10 = R.color.colorPrimary;
            view.setBackgroundColor(resources.getColor(i10));
            this.X7.setBackgroundColor(getResources().getColor(i10));
            this.Y7.setBackgroundColor(getResources().getColor(i10));
            this.Z7.setBackgroundColor(getResources().getColor(i10));
        }
        if (this.f14427g8.f() == -1) {
            this.R7.setTag(Boolean.FALSE);
            this.R7.setBackgroundResource(R.drawable.flydigi_btn_switch_off);
            this.S7.setVisibility(8);
            seekBarE3.setProgress(90);
            return;
        }
        this.R7.setTag(Boolean.TRUE);
        this.R7.setBackgroundResource(R.drawable.flydigi_btn_switch_on);
        this.S7.setVisibility(0);
        seekBarE3.setProgress(((int) ((this.f14427g8.h() / 63.0f) * 100.0f)) - 10);
    }

    @Override // androidx.appcompat.app.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            finish();
        }
        if (i10 == 82) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.flydigi.device_manager.d
    @l
    public h9.d r4() {
        return new b();
    }

    @Override // com.flydigi.device_manager.d
    public void s4(@k GamepadInfo gamepadInfo) {
        super.s4(gamepadInfo);
        if (!gamepadInfo.isConnected()) {
            finish();
        } else {
            H4();
            G4();
        }
    }
}

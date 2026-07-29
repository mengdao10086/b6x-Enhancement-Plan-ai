package com.flydigi.device_manager.cooperate.cjzc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.base.common.o;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.cooperate.cjzc.bean.EntityCJZCAction;
import com.flydigi.device_manager.d;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h9.f;
import java.io.Serializable;
import java.util.ArrayList;
import m9.b;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public class Activity_CJZC_Listen extends d implements View.OnClickListener {
    public static final String P7 = "deviceName";
    public static final String Q7 = "deviceMode";
    public View J7;
    public ImageView K7;
    public TextView L7;
    public TextView M7;
    public Button N7;
    public EntityCJZCAction O7;

    public class a extends f {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U0(byte[] bArr) {
            Activity_CJZC_Listen.this.B4(bArr);
        }

        @Override // h9.f, h9.d
        public void A(@k final byte[] bArr) {
            super.A(bArr);
            Activity_CJZC_Listen.this.c4().e(new Runnable() { // from class: a7.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f291a.U0(bArr);
                }
            });
        }
    }

    public final void A4() {
        this.K7 = (ImageView) findViewById(R.id.image_key);
        this.L7 = (TextView) findViewById(R.id.action_name);
        View viewFindViewById = findViewById(R.id.layout_parent);
        this.J7 = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.M7 = (TextView) findViewById(R.id.key_notice);
        Button button = (Button) findViewById(R.id.clear_key);
        this.N7 = button;
        button.setOnClickListener(this);
    }

    public final void B4(byte[] bArr) {
        y4(bArr);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_cjzc_listen;
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
        } else if (id2 == R.id.clear_key) {
            Intent intent = new Intent();
            intent.putExtra(CommonNetImpl.POSITION, -1);
            setResult(100, intent);
            finish();
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A4();
        this.O7 = (EntityCJZCAction) getIntent().getSerializableExtra("data");
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
        return new a();
    }

    @Override // com.flydigi.device_manager.d
    public void s4(@k GamepadInfo gamepadInfo) {
        super.s4(gamepadInfo);
        if (gamepadInfo.isConnected()) {
            z4();
        }
    }

    public void y4(byte[] bArr) {
        if (!b.M(bArr) || o4() == null) {
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
                int deviceType = o4().getDeviceType();
                if (deviceType == 64 || deviceType == 65 || deviceType == 66) {
                    o.E("暂不支持该按键");
                    return;
                }
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
            Intent intent = new Intent();
            intent.putExtra(CommonNetImpl.POSITION, (Serializable) arrayList.get(0));
            setResult(100, intent);
            finish();
        }
    }

    public final void z4() {
        this.L7.setText(x6.a.c(this.O7.b()));
        if (this.O7.d() == -1) {
            this.N7.setEnabled(false);
            this.N7.setTextColor(getResources().getColor(R.color.colorTextTertiary));
        } else {
            this.N7.setEnabled(true);
            this.N7.setTextColor(getResources().getColor(R.color.base_color_assist_red));
        }
        if (!o4().isGamepadKeyboard()) {
            this.K7.setImageResource(x6.a.g(this.O7.d()));
        } else if (o4().isGamepadKeyboard()) {
            this.K7.setImageResource(x6.a.h(this.O7.d()));
        }
        if (this.O7.b() == 39) {
            this.M7.setVisibility(0);
            if (!o4().isGamepadKeyboard()) {
                this.M7.setText("游戏中按住“小眼睛”键移动右摇杆，可以查看视野");
            } else if (o4().isGamepadKeyboard()) {
                this.M7.setText("游戏中按住“小眼睛”键移动鼠标，可以查看视野");
            }
        }
    }
}

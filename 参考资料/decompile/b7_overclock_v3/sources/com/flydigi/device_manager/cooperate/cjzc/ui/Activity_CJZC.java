package com.flydigi.device_manager.cooperate.cjzc.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.n;
import com.flydigi.base.common.o;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.cooperate.cjzc.bean.EntityCJZCAction;
import com.flydigi.device_manager.cooperate.cjzc.bean.EntityCJZCConfig;
import com.flydigi.device_manager.d;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.iir_eq.ui.activity.LeScanActivity;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h9.f;
import i9.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import jt.l;
import o5.m;
import okio.w0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u9.g;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31960p)
public class Activity_CJZC extends d implements View.OnClickListener {

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static ArrayList<EntityCJZCConfig> f14395v8 = new ArrayList<>();

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static String f14396w8 = "official.cfg";
    public TextView J7;
    public GridView K7;
    public GridView L7;
    public GridView M7;
    public GridView N7;
    public y6.a S7;
    public y6.a T7;
    public y6.a U7;
    public y6.a V7;
    public int W7;
    public boolean Y7;

    @Autowired(name = "package_name")
    public String Z7;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public View f14399c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public TextView f14400d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public TextView f14401e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public ImageView f14402f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public CheckBox f14403g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public TextView f14404h8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public int f14407k8;
    public final ArrayList<EntityCJZCAction> O7 = new ArrayList<>();
    public final ArrayList<EntityCJZCAction> P7 = new ArrayList<>();
    public final ArrayList<EntityCJZCAction> Q7 = new ArrayList<>();
    public final ArrayList<EntityCJZCAction> R7 = new ArrayList<>();
    public final ArrayList<Byte> X7 = new ArrayList<>();

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public boolean f14397a8 = false;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public boolean f14398b8 = false;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public final String f14405i8 = "cjzc_reshow_key_setting";

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public final String f14406j8 = "cjzc_apply_notice_connect_game";

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public final Runnable f14408l8 = new Runnable() { // from class: a7.g
        @Override // java.lang.Runnable
        public final void run() {
            this.f281a.m5();
        }
    };

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public int f14409m8 = 0;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public boolean f14410n8 = false;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f14411o8 = false;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f14412p8 = false;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public int f14413q8 = 0;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public int f14414r8 = 0;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public int f14415s8 = 0;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public final StringBuffer f14416t8 = new StringBuffer();

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    public final Handler f14417u8 = new a();

    public class a extends Handler {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            if (Activity_CJZC.this.f14403g8.isChecked()) {
                m.k(DataConstant.SP_APP).G("cjzc_apply_notice_connect_game", false, true);
            }
            Activity_CJZC.this.f14399c8.setVisibility(8);
            Activity_CJZC.this.f14398b8 = false;
            v5.d.d(Activity_CJZC.this.getApplicationContext(), Activity_CJZC.this.Z7, false);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    Activity_CJZC.this.r5();
                    Activity_CJZC.this.a5();
                    o.E("应用成功");
                    if (!m.k(DataConstant.SP_APP).f("cjzc_apply_notice_connect_game", true)) {
                        Activity_CJZC.this.f14398b8 = false;
                        v5.d.d(Activity_CJZC.this.getApplicationContext(), Activity_CJZC.this.Z7, false);
                    } else {
                        Activity_CJZC.this.f14399c8.setVisibility(0);
                        Activity_CJZC.this.f14400d8.setText(Activity_CJZC.this.getString(R.string.cjzc_apply_notice_title));
                        Activity_CJZC.this.f14401e8.setText(Activity_CJZC.this.getString(R.string.cjzc_apply_notice_content));
                        Activity_CJZC.this.f14402f8.setVisibility(0);
                        Activity_CJZC.this.f14404h8.setText(Activity_CJZC.this.getString(R.string.cjzc_apply_notice_ok));
                        Activity_CJZC.this.f14403g8.setChecked(false);
                        Activity_CJZC.this.f14404h8.setOnClickListener(new View.OnClickListener() { // from class: a7.k
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.f286a.b(view);
                            }
                        });
                    }
                    break;
                case 101:
                    o.E("读取成功");
                    break;
                case 102:
                    o.E("导入成功");
                    break;
                case 103:
                    o.E("另存成功");
                    break;
            }
        }
    }

    public class b extends f {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U0(byte[] bArr) {
            Activity_CJZC.this.b5(bArr);
        }

        @Override // h9.f, h9.d
        public void A(@k final byte[] bArr) {
            super.A(bArr);
            Activity_CJZC.this.c4().e(new Runnable() { // from class: a7.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f287a.U0(bArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i5(AdapterView adapterView, View view, int i10, long j10) {
        if (X4()) {
            return;
        }
        this.W7 = i10;
        if (i10 == 0) {
            o.E("移动暂不支持设置");
            return;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            if (o4().isGamepadHalf()) {
                o.E("暂不支持右摇杆");
                return;
            } else {
                g5(i10);
                return;
            }
        }
        if (o4() == null || o4().isGamepadKeyboard() || o4().getDeviceType() == 17 || o4().getDeviceType() == 18 || o4().getDeviceType() == 19 || o4().getDeviceName().toLowerCase().contains("2t")) {
            g5(i10);
        } else {
            o.E("暂不支持体感");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j5(AdapterView adapterView, View view, int i10, long j10) {
        if (X4()) {
            return;
        }
        this.W7 = i10;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) Activity_CJZC_Listen.class);
        intent.putExtra("data", this.P7.get(i10));
        intent.putExtra(Activity_CJZC_Listen.Q7, o4().getDeviceMode());
        intent.putExtra("deviceName", o4().getDeviceName());
        startActivityForResult(intent, 101);
        y5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k5(AdapterView adapterView, View view, int i10, long j10) {
        if (X4()) {
            return;
        }
        this.W7 = i10;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) Activity_CJZC_Listen.class);
        intent.putExtra(Activity_CJZC_Listen.Q7, o4().getDeviceMode());
        intent.putExtra("deviceName", o4().getDeviceName());
        intent.putExtra("data", this.Q7.get(i10));
        startActivityForResult(intent, 102);
        y5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l5(AdapterView adapterView, View view, int i10, long j10) {
        if (X4()) {
            return;
        }
        this.W7 = i10;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) Activity_CJZC_Listen.class);
        intent.putExtra(Activity_CJZC_Listen.Q7, o4().getDeviceMode());
        intent.putExtra("deviceName", o4().getDeviceName());
        intent.putExtra("data", this.R7.get(i10));
        startActivityForResult(intent, 103);
        y5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m5() {
        if (o4() != null && o4().isConnected() && this.f14397a8) {
            if (o4().isFlashplayMode()) {
                ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(getApplicationContext(), DataConstant.REMOTE_ACTION_TMODE_ONLY_GATT_MODE);
            } else {
                ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(getApplicationContext(), DataConstant.DEVICE_UART_TEST);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n5() {
        f5(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o5(View view) {
        if (this.f14403g8.isChecked()) {
            m.k(DataConstant.SP_APP).G("cjzc_reshow_key_setting", false, true);
        }
        this.f14399c8.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p5(String str) {
        x(str, false);
    }

    public static void u5() {
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < f14395v8.size(); i10++) {
            ArrayList<EntityCJZCAction> arrayListC = f14395v8.get(i10).a().c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(LeScanActivity.R7, f14395v8.get(i10).d());
                jSONObject.put("name", f14395v8.get(i10).f());
                jSONObject.put(SocialConstants.PARAM_APP_DESC, f14395v8.get(i10).b());
                JSONArray jSONArray2 = new JSONArray();
                for (int i11 = 0; i11 < arrayListC.size(); i11++) {
                    EntityCJZCAction entityCJZCActionA = arrayListC.get(i11).a();
                    JSONObject jSONObject2 = new JSONObject();
                    int iB = entityCJZCActionA.b();
                    if (iB == 1 || iB == 5 || iB == 6) {
                        jSONObject2.put("actionid", entityCJZCActionA.b());
                        jSONObject2.put("keyid", entityCJZCActionA.d());
                        jSONObject2.put("senty_x", entityCJZCActionA.i());
                        jSONObject2.put("senty_y", entityCJZCActionA.k());
                        jSONObject2.put("senior_key1_id", entityCJZCActionA.f());
                        jSONObject2.put("senior_senty1_x", entityCJZCActionA.h());
                        jSONObject2.put("senior_senty1_y", entityCJZCActionA.h());
                        jSONObject2.put("senior_key2_id", -1);
                        jSONObject2.put("senior_senty2_x", -1);
                        jSONObject2.put("senior_senty2_y", -1);
                    } else {
                        jSONObject2.put("actionid", entityCJZCActionA.b());
                        jSONObject2.put("keyid", entityCJZCActionA.d());
                    }
                    jSONArray2.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray2);
                jSONArray.put(jSONObject);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(e6.a.f26664f, f14396w8));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            outputStreamWriter.write(jSONArray.toString());
            outputStreamWriter.flush();
            fileOutputStream.flush();
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public final void A5(String str) {
        ArrayList<EntityCJZCAction> arrayList = new ArrayList<>();
        int i10 = 0;
        for (int i11 = 0; i11 < this.O7.size(); i11++) {
            arrayList.add(this.O7.get(i11).a());
        }
        for (int i12 = 0; i12 < this.P7.size(); i12++) {
            arrayList.add(this.P7.get(i12).a());
        }
        for (int i13 = 0; i13 < this.Q7.size(); i13++) {
            arrayList.add(this.Q7.get(i13).a());
        }
        for (int i14 = 0; i14 < this.R7.size(); i14++) {
            arrayList.add(this.R7.get(i14).a());
        }
        EntityCJZCConfig entityCJZCConfig = new EntityCJZCConfig();
        if (o4().isGamepadKeyboard() && o4().isGamepadKeyboard()) {
            i10 = 1;
        }
        entityCJZCConfig.k(i10);
        entityCJZCConfig.l(str);
        entityCJZCConfig.h("刺激原生配置描述");
        entityCJZCConfig.i(arrayList);
        f14395v8.add(entityCJZCConfig);
        u5();
        r5();
    }

    public void F4(String str, String str2, String str3, String str4, int i10) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) Activity_Dialog_Vertical.class);
        intent.putExtra("title", str);
        intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
        intent.putExtra(CommonNetImpl.CANCEL, str3);
        intent.putExtra("confirm", str4);
        startActivityForResult(intent, i10);
        y5();
    }

    public final void G4(int i10, int i11) {
        byte[] bArr = new byte[20];
        bArr[0] = 49;
        bArr[1] = (byte) i11;
        for (int i12 = 0; i12 < 16; i12++) {
            bArr[i12 + 2] = -1;
        }
        if (n0.z(this.X7)) {
            for (int i13 = 0; i13 < 16; i13++) {
                bArr[i13 + 2] = this.X7.get((i10 * 112) + (i11 * 16) + i13).byteValue();
            }
        }
        int i14 = this.f14409m8;
        bArr[18] = (byte) i14;
        this.f14409m8 = i14 + 1;
        bArr[19] = 0;
        for (int i15 = 0; i15 < 19; i15++) {
            bArr[19] = (byte) (bArr[19] + bArr[i15]);
        }
        bArr[19] = (byte) (bArr[19] & 255);
        v5(bArr);
    }

    public final void H4(int i10) {
        int i11 = this.f14409m8;
        this.f14409m8 = i11 + 1;
        byte[] bArr = {l.f36949q, (byte) i10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte) i11, 0};
        for (int i12 = 0; i12 < 19; i12++) {
            bArr[19] = (byte) (bArr[19] + bArr[i12]);
        }
        bArr[19] = (byte) (bArr[19] & 255);
        v5(bArr);
    }

    public final void I4(int i10) {
        int i11 = o4().isGamepadHalf() ? 6 : 5;
        this.f14412p8 = false;
        int i12 = this.f14409m8;
        this.f14409m8 = i12 + 1;
        byte[] bArr = {(byte) i10, (byte) i11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte) i12, 0};
        for (int i13 = 0; i13 < 19; i13++) {
            bArr[19] = (byte) (bArr[19] + bArr[i13]);
        }
        bArr[19] = (byte) (bArr[19] & 255);
        v5(bArr);
    }

    public final void T4(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                EntityCJZCConfig entityCJZCConfig = new EntityCJZCConfig();
                entityCJZCConfig.k(jSONObject.getInt(LeScanActivity.R7));
                entityCJZCConfig.l(jSONObject.getString("name"));
                entityCJZCConfig.h(jSONObject.getString(SocialConstants.PARAM_APP_DESC));
                ArrayList<EntityCJZCAction> arrayList = new ArrayList<>();
                JSONArray jSONArray2 = new JSONArray(jSONObject.getString("data"));
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    EntityCJZCAction entityCJZCAction = new EntityCJZCAction();
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i11);
                    int i12 = jSONObject2.getInt("actionid");
                    if (i12 == 1 || i12 == 5 || i12 == 6) {
                        entityCJZCAction.l(jSONObject2.getInt("actionid"));
                        entityCJZCAction.m(x6.a.c(i12));
                        entityCJZCAction.n(jSONObject2.getInt("keyid"));
                        entityCJZCAction.q(jSONObject2.getInt("senty_x"));
                        entityCJZCAction.r(jSONObject2.getInt("senty_y"));
                        entityCJZCAction.o(jSONObject2.getInt("senior_key1_id"));
                        entityCJZCAction.p(jSONObject2.getInt("senior_senty1_x"));
                    } else {
                        entityCJZCAction.l(jSONObject2.getInt("actionid"));
                        entityCJZCAction.m(x6.a.c(i12));
                        entityCJZCAction.n(jSONObject2.getInt("keyid"));
                    }
                    arrayList.add(entityCJZCAction);
                }
                entityCJZCConfig.i(arrayList);
                f14395v8.add(entityCJZCConfig);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public final boolean U4() {
        try {
            ArrayList arrayList = new ArrayList();
            if (!o4().isGamepadKeyboard()) {
                arrayList.addAll(c5(0, this.X7));
            } else if (o4().isGamepadKeyboard()) {
                arrayList.addAll(c5(1, this.X7));
            }
            if (!arrayList.equals(d5())) {
                if (this.X7.size() != 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            n.d(e10, "", new Object[0]);
            return true;
        }
    }

    public final boolean V4() {
        if (o4() == null) {
            return true;
        }
        if (o4().getDeviceType() == 18 && !W4("5.5.0.0", o4().getFirmwareVersion())) {
            return true;
        }
        if (o4().getDeviceType() == 19 && !W4("6.0.1.3", o4().getFirmwareVersion())) {
            return true;
        }
        if (o4().getDeviceType() == 32 && !W4("4.9.4.1", o4().getFirmwareVersion())) {
            return true;
        }
        if (o4().getDeviceType() == 33 && !W4("5.5.0.0", o4().getFirmwareVersion())) {
            return true;
        }
        if (o4().getDeviceType() == 17 && !W4("5.2.0.1", o4().getFirmwareVersion())) {
            return true;
        }
        if (o4().getDeviceType() == 64 && !W4("1.0.1.2", o4().getFirmwareVersion())) {
            return true;
        }
        if (o4().getDeviceType() == 67 && !W4("1.0.1.2", o4().getFirmwareVersion())) {
            return true;
        }
        if (o4().getDeviceType() != 65 || W4("1.0.1.2", o4().getFirmwareVersion())) {
            return o4().getDeviceType() == 66 && !W4("1.0.1.2", o4().getFirmwareVersion());
        }
        return true;
    }

    public final boolean W4(String str, String str2) {
        int i10;
        int i11;
        try {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (strArrSplit2.length > strArrSplit.length) {
                return true;
            }
            if (strArrSplit2.length == strArrSplit.length) {
                for (int i12 = 0; i12 < strArrSplit2.length && (i11 = Integer.parseInt(strArrSplit2[i12])) <= (i10 = Integer.parseInt(strArrSplit[i12])); i12++) {
                    if (i11 < i10) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final boolean X4() {
        if (o4() == null || !o4().isConnected()) {
            F4("手柄未连接", "检测到手柄未连接，请连接手柄后再试", "取消", "连接手柄", 3);
            return true;
        }
        if (o4().getDeviceType() == 16) {
            o.E("暂不支持当前手柄");
            return true;
        }
        if (o4().isGamepadKeyboard() && o4().getUsb0Device() == 0 && o4().getUsb1Device() == 0) {
            o.E("请先连接键鼠");
            return true;
        }
        if (!V4()) {
            return false;
        }
        x5();
        return true;
    }

    public final void Y4() {
        this.X7.clear();
    }

    public final void Z4() {
        a5();
        this.f14414r8 = 0;
        this.f14415s8 = 0;
        this.f14409m8 = 0;
        this.f14410n8 = false;
        this.f14411o8 = false;
    }

    public final void a5() {
        b4().post(new Runnable() { // from class: a7.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f280a.E0();
            }
        });
    }

    public void b5(byte[] bArr) {
        if (bArr.length == 14) {
            return;
        }
        int i10 = 0;
        if (bArr.length != 20 || (bArr[0] & 255) == 187) {
            if (!this.f14412p8) {
                if (bArr.length != 4 || (bArr[0] & 255) != 170 || (bArr[1] & 255) != 204 || (bArr[2] & 255) != this.f14409m8 - 1) {
                    if (bArr.length == 4 && (bArr[0] & 255) == 170) {
                        if (((bArr[1] & 255) == 238 || (bArr[1] & 255) == 170) && (bArr[2] & 255) == this.f14409m8 - 1) {
                            Z4();
                            I4(50);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int i11 = this.f14414r8;
                if (i11 == 0) {
                    int i12 = this.f14415s8;
                    if (i12 < 7) {
                        G4(i11, i12);
                        this.f14415s8++;
                        return;
                    } else {
                        if (i12 == 7) {
                            H4(i11);
                            this.f14414r8++;
                            this.f14415s8 = 0;
                            return;
                        }
                        return;
                    }
                }
                if (i11 != 1) {
                    if (this.f14411o8) {
                        Z4();
                        this.f14417u8.sendEmptyMessage(100);
                        return;
                    } else {
                        I4(51);
                        this.f14411o8 = true;
                        return;
                    }
                }
                int i13 = this.f14415s8;
                if (i13 < 7) {
                    G4(i11, i13);
                    this.f14415s8++;
                    return;
                } else {
                    if (i13 == 7) {
                        H4(i11);
                        this.f14414r8++;
                        this.f14415s8 = 0;
                        return;
                    }
                    return;
                }
            }
            if (bArr.length == 20 && (bArr[0] & 255) == 187) {
                int i14 = bArr[1] & 255;
                int i15 = this.f14414r8;
                if (i14 == i15 + 48) {
                    int i16 = bArr[2] & 255;
                    int i17 = this.f14415s8;
                    if (i16 == i17) {
                        if (i15 == 0) {
                            if (i17 == 0 && ((bArr[3] & 255) != 18 || (bArr[4] & 255) != 52 || (bArr[5] & 255) != 86 || (bArr[6] & 255) != 120)) {
                                t5();
                                return;
                            }
                            if (i17 < 7) {
                                while (i10 < 16) {
                                    this.X7.add(Byte.valueOf(bArr[i10 + 3]));
                                    i10++;
                                }
                                int i18 = this.f14415s8 + 1;
                                this.f14415s8 = i18;
                                f5(this.f14414r8, i18);
                                return;
                            }
                            if (i17 == 7) {
                                int i19 = i15 + 1;
                                this.f14414r8 = i19;
                                this.f14415s8 = 0;
                                f5(i19, 0);
                                return;
                            }
                            return;
                        }
                        if (i15 == 1) {
                            if (i17 < 7) {
                                while (i10 < 16) {
                                    this.X7.add(Byte.valueOf(bArr[i10 + 3]));
                                    i10++;
                                }
                                int i20 = this.f14415s8 + 1;
                                this.f14415s8 = i20;
                                f5(this.f14414r8, i20);
                                return;
                            }
                            if (i17 == 7) {
                                int i21 = i15 + 1;
                                this.f14414r8 = i21;
                                this.f14415s8 = 0;
                                f5(i21, 0);
                                return;
                            }
                            return;
                        }
                        this.f14417u8.sendEmptyMessage(101);
                        t5();
                        s5();
                        ArrayList arrayList = new ArrayList();
                        if (!o4().isGamepadKeyboard()) {
                            arrayList.addAll(c5(0, this.X7));
                        } else if (o4().isGamepadKeyboard()) {
                            arrayList.addAll(c5(1, this.X7));
                        }
                        for (int i22 = 0; i22 < this.O7.size(); i22++) {
                            this.O7.get(i22).n(u9.b.b(((Byte) arrayList.get(this.O7.get(i22).b() + 4)).byteValue()));
                        }
                        for (int i23 = 0; i23 < this.P7.size(); i23++) {
                            this.P7.get(i23).n(u9.b.b(((Byte) arrayList.get(this.P7.get(i23).b() + 4)).byteValue()));
                        }
                        for (int i24 = 0; i24 < this.Q7.size(); i24++) {
                            this.Q7.get(i24).n(u9.b.b(((Byte) arrayList.get(this.Q7.get(i24).b() + 4)).byteValue()));
                        }
                        for (int i25 = 0; i25 < this.R7.size(); i25++) {
                            this.R7.get(i25).n(u9.b.b(((Byte) arrayList.get(this.R7.get(i25).b() + 4)).byteValue()));
                        }
                        if (this.O7.size() == 2) {
                            this.O7.get(0).n(240);
                            this.O7.get(1).n(116);
                            this.O7.get(1).q(u9.b.b(((Byte) arrayList.get(69)).byteValue()));
                            this.O7.get(1).r(u9.b.b(((Byte) arrayList.get(70)).byteValue()));
                            if (u9.b.b(((Byte) arrayList.get(72)).byteValue()) != 255) {
                                this.O7.get(1).o(u9.b.b(((Byte) arrayList.get(72)).byteValue()));
                                this.O7.get(1).p(u9.b.b(((Byte) arrayList.get(73)).byteValue()));
                            }
                        } else if (this.O7.size() == 3) {
                            this.O7.get(0).n(x6.a.d(1, o4()));
                            this.O7.get(2).n(x6.a.d(6, o4()));
                            this.O7.get(2).q(u9.b.b(((Byte) arrayList.get(69)).byteValue()));
                            this.O7.get(2).r(u9.b.b(((Byte) arrayList.get(70)).byteValue()));
                            if (u9.b.b(((Byte) arrayList.get(72)).byteValue()) != 255) {
                                this.O7.get(2).o(u9.b.b(((Byte) arrayList.get(72)).byteValue()));
                                this.O7.get(2).p(u9.b.b(((Byte) arrayList.get(73)).byteValue()));
                            }
                            this.O7.get(1).q(u9.b.b(((Byte) arrayList.get(81)).byteValue()));
                            this.O7.get(1).r(u9.b.b(((Byte) arrayList.get(82)).byteValue()));
                            if (u9.b.b(((Byte) arrayList.get(84)).byteValue()) != 255) {
                                this.O7.get(1).o(u9.b.b(((Byte) arrayList.get(84)).byteValue()));
                                this.O7.get(1).p(u9.b.b(((Byte) arrayList.get(85)).byteValue()));
                            }
                        }
                        this.S7.notifyDataSetChanged();
                        this.T7.notifyDataSetChanged();
                        this.U7.notifyDataSetChanged();
                        this.V7.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public final ArrayList<Byte> c5(int i10, ArrayList<Byte> arrayList) {
        if (arrayList.size() != 224) {
            arrayList.clear();
            arrayList.addAll(d5());
            arrayList.addAll(d5());
        }
        ArrayList<Byte> arrayList2 = new ArrayList<>();
        if (i10 == 0) {
            for (int i11 = 0; i11 < 112; i11++) {
                arrayList2.add(arrayList.get(i11));
            }
        } else if (i10 == 1) {
            for (int i12 = 112; i12 < 224; i12++) {
                arrayList2.add(arrayList.get(i12));
            }
        }
        return arrayList2;
    }

    public final ArrayList<Byte> d5() {
        ArrayList<Byte> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < 64; i10++) {
            map.put(Integer.valueOf(i10), (byte) -1);
        }
        for (int i11 = 0; i11 < this.O7.size(); i11++) {
            map.put(Integer.valueOf(this.O7.get(i11).b()), Byte.valueOf((byte) this.O7.get(i11).d()));
        }
        for (int i12 = 0; i12 < this.P7.size(); i12++) {
            map.put(Integer.valueOf(this.P7.get(i12).b()), Byte.valueOf((byte) this.P7.get(i12).d()));
        }
        for (int i13 = 0; i13 < this.Q7.size(); i13++) {
            map.put(Integer.valueOf(this.Q7.get(i13).b()), Byte.valueOf((byte) this.Q7.get(i13).d()));
        }
        for (int i14 = 0; i14 < this.R7.size(); i14++) {
            map.put(Integer.valueOf(this.R7.get(i14).b()), Byte.valueOf((byte) this.R7.get(i14).d()));
        }
        byte[] bArr = new byte[12];
        Arrays.fill(bArr, (byte) -1);
        if (!o4().isGamepadKeyboard()) {
            bArr[0] = (byte) this.O7.get(2).d();
            bArr[1] = (byte) this.O7.get(2).i();
            bArr[2] = (byte) this.O7.get(2).k();
            bArr[3] = -1;
            if (this.O7.get(2).f() != -1) {
                bArr[4] = (byte) this.O7.get(2).f();
                bArr[5] = (byte) this.O7.get(2).h();
                bArr[6] = (byte) this.O7.get(2).h();
            }
        }
        byte[] bArr2 = new byte[12];
        Arrays.fill(bArr2, (byte) -1);
        bArr2[0] = (byte) this.O7.get(1).d();
        bArr2[1] = (byte) this.O7.get(1).i();
        bArr2[2] = (byte) this.O7.get(1).k();
        bArr2[3] = -1;
        if (this.O7.get(1).f() != -1) {
            bArr2[4] = (byte) this.O7.get(1).f();
            bArr2[5] = (byte) this.O7.get(1).h();
            bArr2[6] = (byte) this.O7.get(1).h();
        }
        arrayList.add((byte) 18);
        arrayList.add((byte) 52);
        arrayList.add((byte) 86);
        arrayList.add(Byte.valueOf(tc.a.f51065w));
        for (int i15 = 0; i15 < map.size(); i15++) {
            arrayList.add((Byte) map.get(Integer.valueOf(i15)));
        }
        if (this.O7.size() == 2) {
            for (int i16 = 0; i16 < 12; i16++) {
                arrayList.add(Byte.valueOf(bArr2[i16]));
            }
            for (int i17 = 0; i17 < 12; i17++) {
                arrayList.add(Byte.valueOf(bArr[i17]));
            }
        }
        if (this.O7.size() == 3) {
            for (int i18 = 0; i18 < 12; i18++) {
                arrayList.add(Byte.valueOf(bArr[i18]));
            }
            for (int i19 = 0; i19 < 12; i19++) {
                arrayList.add(Byte.valueOf(bArr2[i19]));
            }
        }
        for (int i20 = 0; i20 < 20; i20++) {
            arrayList.add((byte) -1);
        }
        return arrayList;
    }

    public final void e5() {
        f14395v8.clear();
        File file = new File(e6.a.f26664f, f14396w8);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                char[] cArr = new char[fileInputStream.available()];
                inputStreamReader.read(cArr);
                inputStreamReader.close();
                fileInputStream.close();
                T4(new String(cArr));
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_cjzc_home;
    }

    public final void f5(int i10, int i11) {
        if (o4() == null || !o4().isConnected() || o4().getDeviceType() == 16) {
            return;
        }
        if ((o4().isGamepadKeyboard() && o4().getUsb0Device() == 0 && o4().getUsb1Device() == 0) || V4()) {
            return;
        }
        int i12 = o4().isGamepadHalf() ? 6 : 5;
        this.f14412p8 = true;
        if (i10 == 0 && i11 == 0) {
            if (this.Y7) {
                return;
            }
            this.Y7 = true;
            w5("读取中...");
            s5();
            this.f14415s8 = 0;
            Y4();
        }
        int i13 = this.f14413q8;
        this.f14413q8 = i13 + 1;
        byte[] bArr = {w0.f44229a, (byte) i10, (byte) i11, (byte) i12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte) i13, 0};
        for (int i14 = 0; i14 < 19; i14++) {
            bArr[19] = (byte) (bArr[19] + bArr[i14]);
        }
        bArr[19] = (byte) (bArr[19] & 255);
        v5(bArr);
    }

    public final void g5(int i10) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) Activity_CJZC_Listen_Special.class);
        intent.putExtra("data", this.O7.get(i10));
        startActivityForResult(intent, 110);
        y5();
    }

    public final void h5() {
        com.blankj.utilcode.util.o.r((TextView) findViewById(R.id.tv_recover), this);
        TextView textView = (TextView) findViewById(R.id.tv_import);
        TextView textView2 = (TextView) findViewById(R.id.tv_saveas);
        this.J7 = (TextView) findViewById(R.id.tv_apply);
        com.blankj.utilcode.util.o.r(textView, this);
        com.blankj.utilcode.util.o.r(textView2, this);
        com.blankj.utilcode.util.o.r(this.J7, this);
        this.K7 = (GridView) findViewById(R.id.gridview_0);
        this.L7 = (GridView) findViewById(R.id.gridview_1);
        this.M7 = (GridView) findViewById(R.id.gridview_2);
        this.N7 = (GridView) findViewById(R.id.gridview_3);
        View viewFindViewById = findViewById(R.id.layout_dialog);
        this.f14399c8 = viewFindViewById;
        com.blankj.utilcode.util.o.r(viewFindViewById, this);
        this.f14400d8 = (TextView) findViewById(R.id.tv_title);
        this.f14401e8 = (TextView) findViewById(R.id.tv_content);
        this.f14402f8 = (ImageView) findViewById(R.id.iv_image);
        this.f14403g8 = (CheckBox) findViewById(R.id.cb_reset);
        this.f14404h8 = (TextView) findViewById(R.id.tv_ok);
        this.K7.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: a7.e
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f279a.i5(adapterView, view, i10, j10);
            }
        });
        this.L7.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: a7.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f278a.j5(adapterView, view, i10, j10);
            }
        });
        this.M7.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: a7.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f277a.k5(adapterView, view, i10, j10);
            }
        });
        this.N7.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: a7.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f276a.l5(adapterView, view, i10, j10);
            }
        });
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        int intExtra;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 110) {
            if (i11 != 100 || intent == null) {
                return;
            }
            EntityCJZCAction entityCJZCAction = (EntityCJZCAction) intent.getSerializableExtra("data");
            this.O7.get(this.W7).n(entityCJZCAction.d());
            this.O7.get(this.W7).q(entityCJZCAction.i());
            this.O7.get(this.W7).r(entityCJZCAction.k());
            this.O7.get(this.W7).o(entityCJZCAction.f());
            this.O7.get(this.W7).p(entityCJZCAction.h());
            this.S7.a(this.W7);
        }
        switch (i10) {
            case 1:
                if (intent != null && intent.getIntExtra(CommonNetImpl.RESULT, -1) == 1) {
                    finish();
                    break;
                }
                break;
            case 2:
                if (intent != null && intent.getIntExtra(CommonNetImpl.RESULT, -1) == 1) {
                    s5();
                    o.E("已恢复到默认配置");
                    break;
                }
                break;
            case 3:
                if (intent != null && intent.getIntExtra(CommonNetImpl.RESULT, -1) == 1) {
                    finish();
                    h3.a.j().d(a.d.f31947c).navigation();
                    break;
                }
                break;
            case 4:
                if (intent != null) {
                    if (intent.getIntExtra(CommonNetImpl.RESULT, -1) != 1) {
                        s5();
                    } else {
                        s5();
                    }
                }
                break;
            case 5:
                if (intent != null && intent.getIntExtra(CommonNetImpl.RESULT, -1) == 1) {
                    finish();
                    h3.a.j().d(a.d.f31951g).withString("key_device_code", o4().getDeviceCode()).withBoolean(DataConstant.DEVICE_KEY_REMOVE_BOND_WHEN_UPGRADE_FIRMWARE, true).navigation();
                    break;
                }
                break;
            case 6:
                if (intent != null) {
                    intent.getIntExtra(CommonNetImpl.RESULT, -1);
                }
                break;
            default:
                switch (i10) {
                    case 101:
                        if (i11 == 100 && intent != null) {
                            this.P7.get(this.W7).n(intent.getIntExtra(CommonNetImpl.POSITION, -1));
                            this.T7.a(this.W7);
                            break;
                        }
                        break;
                    case 102:
                        if (i11 == 100 && intent != null) {
                            this.Q7.get(this.W7).n(intent.getIntExtra(CommonNetImpl.POSITION, -1));
                            this.U7.a(this.W7);
                            break;
                        }
                        break;
                    case 103:
                        if (i11 == 100 && intent != null) {
                            this.R7.get(this.W7).n(intent.getIntExtra(CommonNetImpl.POSITION, -1));
                            this.V7.a(this.W7);
                            break;
                        }
                        break;
                    default:
                        switch (i10) {
                            case 120:
                                this.f14398b8 = true;
                                if (intent != null && (intExtra = intent.getIntExtra(CommonNetImpl.POSITION, -1)) != -1) {
                                    q5(f14395v8.get(intExtra).a());
                                    r5();
                                    this.f14417u8.sendEmptyMessage(102);
                                    break;
                                }
                                break;
                            case 121:
                                this.f14398b8 = true;
                                if (intent != null) {
                                    int intExtra2 = intent.getIntExtra(CommonNetImpl.RESULT, -1);
                                    if (intExtra2 == 1 || intExtra2 == 2) {
                                        A5(intent.getStringExtra("content"));
                                        this.f14417u8.sendEmptyMessage(103);
                                    }
                                }
                                break;
                            case 122:
                                this.f14398b8 = true;
                                if (intent != null && intent.getIntExtra(CommonNetImpl.RESULT, -1) == 1) {
                                    startActivityForResult(new Intent(getApplicationContext(), (Class<?>) Activity_CJZC_Config_Manage.class), 120);
                                    break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (U4()) {
            F4("退出修改", "你的配置还没保存，确定要退出吗？", "取消", "退出", 1);
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.tv_import) {
            if (X4()) {
                return;
            }
            if (U4()) {
                F4("配置未保存", "你的配置还没保存，确定要导入吗？", "取消", "导入", 122);
                return;
            } else {
                startActivityForResult(new Intent(getApplicationContext(), (Class<?>) Activity_CJZC_Config_Manage.class), 120);
                return;
            }
        }
        if (id2 == R.id.tv_saveas) {
            if (X4()) {
                return;
            }
            Intent intent = new Intent(getApplicationContext(), (Class<?>) Activity_Dialog_CreateName.class);
            intent.putExtra("content", "");
            intent.putExtra(CommonNetImpl.CANCEL, "取消");
            intent.putExtra("confirm", "保存");
            startActivityForResult(intent, 121);
            y5();
            return;
        }
        if (id2 != R.id.tv_apply) {
            if (id2 != R.id.tv_recover || X4()) {
                return;
            }
            F4("恢复默认配置", "恢复默认配置后，就不能再回到当前自定义配置了，确定要恢复吗？", "取消", "恢复", 2);
            return;
        }
        if (X4()) {
            return;
        }
        g.a().c(this, "Module_CJZC_Start_Game", "刺激战场原生改键使用");
        w5("应用中...");
        z5();
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e4();
        h3.a.j().l(this);
        this.C1.setText("和平精英原生键位设置");
        h5();
        e5();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cjzc_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(H1(), DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
    }

    @Override // androidx.appcompat.app.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 82) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.flydigi.base.common.p, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_question) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.URL_OFFICIAL_CCONFIG_QUESTION).withString(DataConstant.WEB_TITLE, getString(R.string.device_help)).navigation();
            this.f14398b8 = true;
            return true;
        }
        if (itemId == 16908332) {
            if (U4()) {
                F4("退出修改", "你的配置还没保存，确定要退出吗？", "取消", "退出", 1);
            } else {
                finish();
            }
        }
        return true;
    }

    @Override // com.flydigi.base.common.c, android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (o4() != null && o4().isConnected() && !this.f14398b8 && m.k(DataConstant.SP_APP).f("cjzc_reshow_key_setting", true)) {
            this.f14399c8.setVisibility(0);
            this.f14400d8.setText(getString(R.string.cjzc_reshow_title));
            this.f14401e8.setText(getString(R.string.cjzc_reshow_content));
            this.f14402f8.setVisibility(8);
            this.f14404h8.setText(getString(R.string.cjzc_reshow_ok));
            this.f14403g8.setChecked(false);
            this.f14404h8.setOnClickListener(new View.OnClickListener() { // from class: a7.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f275a.o5(view);
                }
            });
        }
        this.f14417u8.postDelayed(this.f14408l8, 500L);
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f14397a8 = true;
        this.f14398b8 = false;
    }

    @Override // com.flydigi.device_manager.d, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f14397a8 = false;
    }

    public void q5(EntityCJZCConfig entityCJZCConfig) {
        int size = this.O7.size();
        int size2 = this.P7.size();
        int size3 = this.Q7.size();
        int size4 = this.R7.size();
        this.O7.clear();
        this.P7.clear();
        this.Q7.clear();
        this.R7.clear();
        if (o4() != null) {
            for (int i10 = 0; i10 < entityCJZCConfig.c().size(); i10++) {
                EntityCJZCAction entityCJZCAction = entityCJZCConfig.c().get(i10);
                entityCJZCAction.n(x6.a.a(entityCJZCAction.d(), o4()));
                entityCJZCAction.o(x6.a.a(entityCJZCAction.d(), o4()));
                if (i10 < size) {
                    this.O7.add(entityCJZCAction);
                }
                if (i10 > size - 1 && i10 < size + size2) {
                    this.P7.add(entityCJZCAction);
                }
                int i11 = size + size2;
                if (i10 > i11 - 1 && i10 < i11 + size3) {
                    this.Q7.add(entityCJZCAction);
                }
                int i12 = i11 + size3;
                if (i10 > i12 - 1 && i10 < i12 + size4) {
                    this.R7.add(entityCJZCAction);
                }
            }
        }
        this.S7.notifyDataSetChanged();
        this.T7.notifyDataSetChanged();
        this.U7.notifyDataSetChanged();
        this.V7.notifyDataSetChanged();
    }

    @Override // com.flydigi.device_manager.d
    @yt.l
    public h9.d r4() {
        return new b();
    }

    public final void r5() {
        if (!o4().isGamepadKeyboard()) {
            ArrayList arrayList = new ArrayList(c5(1, this.X7));
            this.X7.clear();
            this.X7.addAll(d5());
            this.X7.addAll(arrayList);
            return;
        }
        if (o4().isGamepadKeyboard()) {
            ArrayList arrayList2 = new ArrayList(c5(0, this.X7));
            this.X7.clear();
            this.X7.addAll(arrayList2);
            this.X7.addAll(d5());
        }
    }

    @Override // com.flydigi.device_manager.d
    public void s4(@k GamepadInfo gamepadInfo) {
        super.s4(gamepadInfo);
        if (!gamepadInfo.isConnected()) {
            o.E(getString(R.string.device_state_unconnected));
            finish();
        } else {
            this.Y7 = false;
            this.f14407k8 = gamepadInfo.getDeviceMode();
            b4().post(this.f14408l8);
            b4().postDelayed(new Runnable() { // from class: a7.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f283a.n5();
                }
            }, 250L);
        }
    }

    public final void s5() {
        if (o4() == null) {
            return;
        }
        this.O7.clear();
        this.P7.clear();
        this.Q7.clear();
        this.R7.clear();
        int[] iArr = {1, 0, 6};
        int[] iArr2 = {8, 39, 2, 7, 3, 9, 4, 17, 13, 16, 14, 19, 35, 10, 41, 36, 42, 37, 18, 38, 40, 15, 11};
        int[] iArr3 = {28, 31, 22, 23, 24, 25, 30, 29, 26, 27};
        int[] iArr4 = {33, 34, 20, 21, 12};
        int[] iArr5 = {1, 6};
        int[] iArr6 = {8, 39, 2, 7, 3, 9, 4, 17, 13, 16, 14, 19, 35, 10, 41, 36, 42, 37, 18, 38, 40, 15, 11};
        int[] iArr7 = {28, 31, 22, 23, 24, 25, 30, 29, 26, 27};
        int[] iArr8 = {33, 34, 20, 21, 12};
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (!o4().isGamepadKeyboard()) {
            for (int i10 = 0; i10 < 3; i10++) {
                arrayList.add(Integer.valueOf(iArr[i10]));
            }
            for (int i11 = 0; i11 < 23; i11++) {
                arrayList2.add(Integer.valueOf(iArr2[i11]));
            }
            for (int i12 = 0; i12 < 10; i12++) {
                arrayList3.add(Integer.valueOf(iArr3[i12]));
            }
            for (int i13 = 0; i13 < 5; i13++) {
                arrayList4.add(Integer.valueOf(iArr4[i13]));
            }
        } else if (o4().isGamepadKeyboard()) {
            for (int i14 = 0; i14 < 2; i14++) {
                arrayList.add(Integer.valueOf(iArr5[i14]));
            }
            for (int i15 = 0; i15 < 23; i15++) {
                arrayList2.add(Integer.valueOf(iArr6[i15]));
            }
            for (int i16 = 0; i16 < 10; i16++) {
                arrayList3.add(Integer.valueOf(iArr7[i16]));
            }
            for (int i17 = 0; i17 < 5; i17++) {
                arrayList4.add(Integer.valueOf(iArr8[i17]));
            }
        }
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            EntityCJZCAction entityCJZCAction = new EntityCJZCAction();
            entityCJZCAction.l(((Integer) arrayList.get(i18)).intValue());
            entityCJZCAction.m(x6.a.c(((Integer) arrayList.get(i18)).intValue()));
            if (!o4().isGamepadKeyboard()) {
                entityCJZCAction.n(x6.a.d(((Integer) arrayList.get(i18)).intValue(), o4()));
            } else if (o4().isGamepadKeyboard()) {
                entityCJZCAction.n(x6.a.f(((Integer) arrayList.get(i18)).intValue()));
            }
            entityCJZCAction.q(30);
            entityCJZCAction.r(15);
            entityCJZCAction.o(-1);
            entityCJZCAction.p(100);
            this.O7.add(entityCJZCAction);
        }
        this.O7.size();
        if (this.O7.size() == 3) {
            this.O7.get(1).q(25);
            this.O7.get(1).r(15);
        }
        y6.a aVar = new y6.a(getApplicationContext(), this.O7, this.K7, this.f14407k8);
        this.S7 = aVar;
        this.K7.setAdapter((ListAdapter) aVar);
        for (int i19 = 0; i19 < arrayList2.size(); i19++) {
            EntityCJZCAction entityCJZCAction2 = new EntityCJZCAction();
            entityCJZCAction2.l(((Integer) arrayList2.get(i19)).intValue());
            entityCJZCAction2.m(x6.a.c(((Integer) arrayList2.get(i19)).intValue()));
            if (!o4().isGamepadKeyboard()) {
                entityCJZCAction2.n(x6.a.d(((Integer) arrayList2.get(i19)).intValue(), o4()));
            } else if (o4().isGamepadKeyboard()) {
                entityCJZCAction2.n(x6.a.f(((Integer) arrayList2.get(i19)).intValue()));
            }
            this.P7.add(entityCJZCAction2);
        }
        y6.a aVar2 = new y6.a(getApplicationContext(), this.P7, this.L7, this.f14407k8);
        this.T7 = aVar2;
        this.L7.setAdapter((ListAdapter) aVar2);
        for (int i20 = 0; i20 < arrayList3.size(); i20++) {
            EntityCJZCAction entityCJZCAction3 = new EntityCJZCAction();
            entityCJZCAction3.l(((Integer) arrayList3.get(i20)).intValue());
            entityCJZCAction3.m(x6.a.c(((Integer) arrayList3.get(i20)).intValue()));
            if (!o4().isGamepadKeyboard()) {
                entityCJZCAction3.n(x6.a.d(((Integer) arrayList3.get(i20)).intValue(), o4()));
            } else if (o4().isGamepadKeyboard()) {
                entityCJZCAction3.n(x6.a.f(((Integer) arrayList3.get(i20)).intValue()));
            }
            this.Q7.add(entityCJZCAction3);
        }
        y6.a aVar3 = new y6.a(getApplicationContext(), this.Q7, this.M7, this.f14407k8);
        this.U7 = aVar3;
        this.M7.setAdapter((ListAdapter) aVar3);
        for (int i21 = 0; i21 < arrayList4.size(); i21++) {
            EntityCJZCAction entityCJZCAction4 = new EntityCJZCAction();
            entityCJZCAction4.l(((Integer) arrayList4.get(i21)).intValue());
            entityCJZCAction4.m(x6.a.c(((Integer) arrayList4.get(i21)).intValue()));
            if (!o4().isGamepadKeyboard()) {
                entityCJZCAction4.n(x6.a.d(((Integer) arrayList4.get(i21)).intValue(), o4()));
            } else if (o4().isGamepadKeyboard()) {
                entityCJZCAction4.n(x6.a.f(((Integer) arrayList4.get(i21)).intValue()));
            }
            this.R7.add(entityCJZCAction4);
        }
        y6.a aVar4 = new y6.a(getApplicationContext(), this.R7, this.N7, this.f14407k8);
        this.V7 = aVar4;
        this.N7.setAdapter((ListAdapter) aVar4);
    }

    public final void t5() {
        a5();
        this.f14412p8 = false;
        this.Y7 = false;
        this.f14414r8 = 0;
        this.f14415s8 = 0;
        this.f14413q8 = 0;
        this.f14416t8.setLength(0);
    }

    public final void v5(byte[] bArr) {
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).m(getApplicationContext(), DataConstant.REMOTE_ACTION_BY_BLUEBOOTH_SEND_BYTE_ARRAY, DataConstant.BYTE_ARRAY, bArr);
    }

    public final void w5(final String str) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        b4().post(new Runnable() { // from class: a7.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f284a.p5(str);
            }
        });
        b4().postDelayed(new Runnable() { // from class: a7.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f282a.a5();
            }
        }, 5000L);
    }

    public final void x5() {
        F4("升级固件", "当前固件不支持刺激战场键位修改，请升级到最新版固件再试哦", "取消", "升级固件", 5);
    }

    public final void y5() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public final void z5() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < 64; i10++) {
            map.put(Integer.valueOf(i10), (byte) -1);
        }
        for (int i11 = 0; i11 < this.O7.size(); i11++) {
            map.put(Integer.valueOf(this.O7.get(i11).b()), Byte.valueOf((byte) this.O7.get(i11).d()));
        }
        for (int i12 = 0; i12 < this.P7.size(); i12++) {
            map.put(Integer.valueOf(this.P7.get(i12).b()), Byte.valueOf((byte) this.P7.get(i12).d()));
        }
        for (int i13 = 0; i13 < this.Q7.size(); i13++) {
            map.put(Integer.valueOf(this.Q7.get(i13).b()), Byte.valueOf((byte) this.Q7.get(i13).d()));
        }
        for (int i14 = 0; i14 < this.R7.size(); i14++) {
            map.put(Integer.valueOf(this.R7.get(i14).b()), Byte.valueOf((byte) this.R7.get(i14).d()));
        }
        byte[] bArr = new byte[12];
        Arrays.fill(bArr, (byte) -1);
        if (!o4().isGamepadKeyboard()) {
            bArr[0] = (byte) this.O7.get(2).d();
            bArr[1] = (byte) this.O7.get(2).i();
            bArr[2] = (byte) this.O7.get(2).k();
            bArr[3] = -1;
            if (this.O7.get(2).f() != -1) {
                bArr[4] = (byte) this.O7.get(2).f();
                bArr[5] = (byte) this.O7.get(2).h();
                bArr[6] = (byte) this.O7.get(2).h();
            }
        }
        byte[] bArr2 = new byte[12];
        Arrays.fill(bArr2, (byte) -1);
        bArr2[0] = (byte) this.O7.get(1).d();
        bArr2[1] = (byte) this.O7.get(1).i();
        bArr2[2] = (byte) this.O7.get(1).k();
        bArr2[3] = -1;
        if (this.O7.get(1).f() != -1) {
            bArr2[4] = (byte) this.O7.get(1).f();
            bArr2[5] = (byte) this.O7.get(1).h();
            bArr2[6] = (byte) this.O7.get(1).h();
        }
        arrayList.add((byte) 18);
        arrayList.add((byte) 52);
        arrayList.add((byte) 86);
        arrayList.add(Byte.valueOf(tc.a.f51065w));
        for (int i15 = 0; i15 < map.size(); i15++) {
            arrayList.add((Byte) map.get(Integer.valueOf(i15)));
        }
        if (this.O7.size() == 2) {
            for (int i16 = 0; i16 < 12; i16++) {
                arrayList.add(Byte.valueOf(bArr2[i16]));
            }
            for (int i17 = 0; i17 < 12; i17++) {
                arrayList.add(Byte.valueOf(bArr[i17]));
            }
        }
        if (this.O7.size() == 3) {
            for (int i18 = 0; i18 < 12; i18++) {
                arrayList.add(Byte.valueOf(bArr[i18]));
            }
            for (int i19 = 0; i19 < 12; i19++) {
                arrayList.add(Byte.valueOf(bArr2[i19]));
            }
        }
        for (int i20 = 0; i20 < 20; i20++) {
            arrayList.add((byte) -1);
        }
        if (!o4().isGamepadKeyboard()) {
            ArrayList arrayList2 = new ArrayList(c5(1, this.X7));
            this.X7.clear();
            this.X7.addAll(arrayList);
            this.X7.addAll(arrayList2);
        } else if (o4().isGamepadKeyboard()) {
            ArrayList arrayList3 = new ArrayList(c5(0, this.X7));
            this.X7.clear();
            this.X7.addAll(arrayList3);
            this.X7.addAll(arrayList);
        }
        I4(50);
    }
}

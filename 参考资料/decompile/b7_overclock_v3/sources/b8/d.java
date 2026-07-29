package b8;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import b8.a;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.n;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.KeyPropertySubPkg;
import com.flydigi.data.bean.KeyPropertySubPkgConfig;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.PropertyLinearLayout;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import eu.davidea.flexibleadapter.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import tt.l;
import w7.c0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class d extends y7.b implements View.OnClickListener, a8.b, a.InterfaceC0095a {
    public static final int A = 2;
    public static final int B = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f9118z = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c0 f9119p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CFGPropertyJS f9120q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final eu.davidea.flexibleadapter.b<a8.c> f9121r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9122s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final androidx.collection.a<Integer, b8.a> f9123t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f9124u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<Integer> f9125v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f9126w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9127x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f9128y;

    public class a implements b.z {
        public a() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(View view, int i10) {
            if (i10 == -1) {
                return false;
            }
            int iB = ((a8.c) d.this.f9121r.g2(i10)).B();
            KeyPropertySubPkg keyPropertySubPkg = x7.f.f54910q.get(d.this.f9124u);
            if (keyPropertySubPkg == null) {
                keyPropertySubPkg = x7.f.f54910q.get(DataConstant.KEY_COMMON_PKGNAME);
            }
            if (keyPropertySubPkg != null) {
                n.a("flydigitestdata  该游戏属性控制规则存在:" + d.this.f9124u);
                for (String str : keyPropertySubPkg.config.keySet()) {
                    KeyPropertySubPkgConfig keyPropertySubPkgConfig = keyPropertySubPkg.config.get(str);
                    if (keyPropertySubPkgConfig.state.equals("1") || keyPropertySubPkgConfig.state.equals("2")) {
                        if (n8.b.j(iB).equals(str)) {
                            d.this.S(iB, keyPropertySubPkgConfig);
                            return false;
                        }
                    }
                }
            }
            d.this.f9122s = iB;
            d.this.f9121r.M(i10);
            d.this.L(iB);
            return true;
        }
    }

    public d(Context context, Handler handler, CFGPropertyJS cFGPropertyJS, GamepadInfo gamepadInfo, String str) {
        super(context, null, handler, gamepadInfo);
        this.f9121r = new eu.davidea.flexibleadapter.b<>(null, new a());
        this.f9122s = 0;
        this.f9123t = new androidx.collection.a<>();
        this.f9125v = new ArrayList();
        this.f9126w = false;
        this.f9127x = -1;
        this.f9128y = null;
        this.f9120q = cFGPropertyJS;
        this.f9124u = str;
        u9.b.x(this.f56478a);
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        this.f9126w = false;
        this.f9119p.f53999d.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        this.f9119p.f53998c.getRoot().setVisibility(8);
    }

    public final void I() {
        CFGPropertyJS cFGPropertyJSD = this.f9123t.get(Integer.valueOf(this.f9122s)).d();
        cFGPropertyJSD.key_id = this.f9120q.key_id;
        Message message = new Message();
        message.what = 102;
        message.obj = cFGPropertyJSD;
        this.f56482e.sendMessage(message);
    }

    public void J(byte[] bArr) {
        if (this.f9126w && m9.b.M(bArr)) {
            List<Integer> listV0 = m9.b.v0(bArr, this.f56484g);
            if (listV0.size() != 0) {
                int i10 = this.f9127x;
                if (i10 == 1) {
                    b8.a aVar = this.f9123t.get(1);
                    if (aVar instanceof c8.e) {
                        ((c8.e) aVar).o(listV0.get(0).intValue());
                    } else if (aVar instanceof c8.f) {
                        ((c8.f) aVar).q(listV0.get(0).intValue());
                    }
                } else if (i10 == 2) {
                    b8.a aVar2 = this.f9123t.get(11);
                    if (aVar2 instanceof c8.d) {
                        ((c8.d) aVar2).o(listV0.get(0).intValue());
                    }
                } else if (i10 == 3) {
                    b8.a aVar3 = this.f9123t.get(1);
                    if (aVar3 instanceof c8.e) {
                        ((c8.e) aVar3).p(listV0.get(0).intValue());
                    }
                }
                this.f9126w = false;
                this.f9119p.f53999d.getRoot().setVisibility(8);
            }
        }
    }

    public final List<a8.c> K(ArrayList<Integer> arrayList, int i10) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new a8.c(it2.next().intValue(), i10));
        }
        return arrayList2;
    }

    public final void L(int i10) {
        View view = this.f9128y;
        if (view != null) {
            view.setVisibility(8);
        }
        if (this.f9123t.get(Integer.valueOf(i10)) == null) {
            O(i10, this.f9120q, false);
        }
        if (this.f9123t.get(Integer.valueOf(i10)) != null) {
            PropertyLinearLayout propertyLinearLayoutE = this.f9123t.get(Integer.valueOf(i10)).e();
            this.f9128y = propertyLinearLayoutE;
            propertyLinearLayoutE.setVisibility(0);
        }
    }

    public final void N() {
        R();
        int iD = a8.d.d(this.f9120q, this.f56484g);
        int i10 = 0;
        for (int i11 = 0; i11 < this.f9121r.getItemCount(); i11++) {
            if (iD == ((a8.c) this.f9121r.g2(i11)).B()) {
                i10 = i11;
            }
        }
        O(iD, this.f9120q, true);
        this.f9121r.n();
        this.f9121r.m(i10);
        this.f9121r.notifyDataSetChanged();
        L(iD);
    }

    public final void O(int i10, CFGPropertyJS cFGPropertyJS, boolean z10) {
        b8.a aVarE = a8.d.e(i10, this.f56478a, this.f56484g, cFGPropertyJS);
        aVarE.j(this);
        if (z10) {
            aVarE.g(cFGPropertyJS);
        }
        PropertyLinearLayout propertyLinearLayoutE = aVarE.e();
        propertyLinearLayoutE.setId(i10);
        this.f9128y = propertyLinearLayoutE;
        this.f9122s = i10;
        this.f9119p.f53997b.addView(propertyLinearLayoutE);
        this.f9123t.put(Integer.valueOf(i10), aVarE);
    }

    public final void R() {
        for (int i10 = 0; i10 < this.f9123t.values().size(); i10++) {
            this.f9123t.o(i10).h();
            this.f9123t.o(i10).e().setVisibility(8);
        }
    }

    public final void S(int i10, KeyPropertySubPkgConfig keyPropertySubPkgConfig) {
        if (keyPropertySubPkgConfig.state.equals("1") && !this.f9125v.contains(Integer.valueOf(i10))) {
            this.f9125v.add(Integer.valueOf(i10));
        }
        b(keyPropertySubPkgConfig.title, keyPropertySubPkgConfig.text);
    }

    @Override // b8.a.InterfaceC0095a
    public void a(int i10) {
        this.f9126w = true;
        this.f9127x = i10;
        this.f9119p.f53999d.getRoot().setVisibility(0);
    }

    @Override // b8.a.InterfaceC0095a
    public void b(@k String str, @k String str2) {
        this.f9119p.f53998c.f54068d.setText(str);
        this.f9119p.f53998c.f54067c.setText(str2);
        this.f9119p.f53998c.getRoot().setVisibility(0);
        this.f9119p.f53998c.f54066b.setOnClickListener(new View.OnClickListener() { // from class: b8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9117a.Q(view);
            }
        });
    }

    @Override // a8.b
    public void e(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<ArrayList<Integer>> arrayList3) {
        this.f9121r.I4(K(arrayList, 2));
        if (arrayList.size() > 1) {
            this.f9119p.f54000e.setVisibility(0);
        } else {
            this.f9119p.f54000e.setVisibility(8);
        }
    }

    @Override // y7.b
    public void h() {
        super.h();
        u9.b.g(this.f56478a);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_property_joystick;
    }

    @Override // y7.b
    public void l() {
        super.l();
        u9.b.g(this.f56478a);
    }

    @Override // y7.b
    public void n() {
        c0 c0VarA = c0.a(this.f56479b);
        this.f9119p = c0VarA;
        c0VarA.f54004i.setText(n8.b.f(this.f56478a, this.f9120q.key_id, this.f56484g.getDeviceMode(), this.f56484g.getDeviceType()) + this.f56478a.getString(R.string.floatview_property_key_title));
        this.f9119p.f53999d.f54103d.setText(n8.b.l(this.f56478a, this.f56484g.getDeviceMode()));
        o.r(this.f9119p.f53999d.getRoot(), new View.OnClickListener() { // from class: b8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9116a.P(view);
            }
        });
        o.r(this.f9119p.f54002g, this);
        o.r(this.f9119p.f54003h, this);
        this.f9121r.J(1);
        this.f9119p.f54000e.setAdapter(this.f9121r);
        a8.d.f(this.f56484g, this.f9120q, this);
        N();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c0 c0Var = this.f9119p;
        if (view == c0Var.f54002g) {
            this.f56482e.sendEmptyMessage(111);
            h();
        } else if (view == c0Var.f54003h) {
            if (this.f9125v.contains(Integer.valueOf(this.f9122s))) {
                Context context = this.f56478a;
                n8.b.m(context, context.getString(R.string.floatview_current_property_already_forbid));
            } else {
                I();
                h();
            }
        }
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEvent(BluetoothDeviceOperateEvent bluetoothDeviceOperateEvent) {
        J(bluetoothDeviceOperateEvent.value);
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }

    @Override // y7.b
    public void y() {
        super.y();
        u9.b.x(this.f56478a);
    }
}

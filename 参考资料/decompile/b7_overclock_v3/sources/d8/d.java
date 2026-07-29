package d8;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import androidx.core.util.k;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.n;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.KeyPropertySubPkg;
import com.flydigi.data.bean.KeyPropertySubPkgConfig;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.float_view.R;
import com.flydigi.float_view.ui.config.b1;
import com.flydigi.float_view.ui.config.h2;
import com.flydigi.float_view.widget.PropertyLinearLayout;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import d8.a;
import e8.d;
import eu.davidea.flexibleadapter.b;
import h8.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m9.m;
import org.greenrobot.eventbus.ThreadMode;
import u9.h;
import w7.d0;
import z7.u0;

/* JADX INFO: loaded from: classes7.dex */
public class d extends y7.b implements View.OnClickListener, a8.b, a.InterfaceC0292a, d.b {
    public static final int E7 = 2;
    public static final int K2 = 1;
    public Object A;
    public CFGPropertyMacro B;
    public int C;
    public int C1;
    public final Handler C2;
    public int D;
    public int K0;
    public e8.d K1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f26086k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final List<Integer> f26087k1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d0 f26088p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f26089q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final eu.davidea.flexibleadapter.b<a8.c> f26090r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final eu.davidea.flexibleadapter.b<a8.c> f26091s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList<ArrayList<Integer>> f26092t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f26093u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final androidx.collection.a<Integer, d8.a> f26094v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f26095v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public View f26096v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h2 f26097w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b1 f26098x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f26099y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CFGEntity f26100z;

    public class a implements b.z {
        public a() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(View view, int i10) {
            if (i10 == -1) {
                return false;
            }
            d.this.f26088p.f54023e.setVisibility(0);
            d.this.f26090r.M(i10);
            ArrayList arrayList = (ArrayList) d.this.f26092t.get(i10);
            d.this.f26091s.I4(d.this.Y(arrayList, 2));
            d.this.f26091s.M(0);
            d.this.Z(((Integer) arrayList.get(0)).intValue());
            return true;
        }
    }

    public class b implements b.z {
        public b() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(View view, int i10) {
            if (i10 == -1) {
                return false;
            }
            int iB = ((a8.c) d.this.f26091s.g2(i10)).B();
            if (iB == 308 && d.this.f56484g.getDeviceType() == 67 && m.a(d.this.C)) {
                n8.b.m(d.this.f56478a, d.this.f56478a.getString(R.string.property_not_support_double_key));
                return false;
            }
            if (iB != 100) {
                KeyPropertySubPkg keyPropertySubPkg = x7.f.f54910q.get(d.this.f26099y);
                if (keyPropertySubPkg == null) {
                    keyPropertySubPkg = x7.f.f54910q.get(DataConstant.KEY_COMMON_PKGNAME);
                }
                if (keyPropertySubPkg != null) {
                    n.a("flydigitestdata 该游戏属性控制规则存在:" + d.this.f26099y);
                    for (String str : keyPropertySubPkg.config.keySet()) {
                        KeyPropertySubPkgConfig keyPropertySubPkgConfig = keyPropertySubPkg.config.get(str);
                        if (keyPropertySubPkgConfig.state.equals("1") || keyPropertySubPkgConfig.state.equals("2")) {
                            if (n8.b.j(iB).equals(str)) {
                                d.this.g0(iB, keyPropertySubPkgConfig);
                                return false;
                            }
                        }
                    }
                }
            }
            d.this.f26091s.M(i10);
            d.this.Z(iB);
            return true;
        }
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 3) {
                if (message.obj instanceof CFGPropertyMacro) {
                    Message message2 = new Message();
                    message2.what = 101;
                    message2.obj = message.obj;
                    d.this.f56482e.sendMessage(message2);
                    d.this.l();
                    return;
                }
                return;
            }
            if (i10 == 22) {
                d.this.V();
                d.this.y();
                return;
            }
            if (i10 != 23) {
                return;
            }
            d.this.V();
            d.this.f56482e.sendEmptyMessage(111);
            if (message.obj instanceof CFGPropertyMacro) {
                Message message3 = new Message();
                message3.obj = message.obj;
                message3.arg1 = message.arg1;
                message3.what = 101;
                d.this.f56482e.sendMessage(message3);
            }
        }
    }

    public d(Context context, Handler handler, Object obj, String str, GamepadInfo gamepadInfo, CFGEntity cFGEntity) {
        super(context, null, handler, gamepadInfo);
        this.f26089q = true;
        this.f26090r = new eu.davidea.flexibleadapter.b<>(null, new a());
        this.f26091s = new eu.davidea.flexibleadapter.b<>(null, new b());
        this.f26092t = new ArrayList<>();
        this.f26093u = 0;
        this.f26094v = new androidx.collection.a<>();
        this.f26097w = null;
        this.f26098x = null;
        this.B = null;
        this.C = -1;
        this.D = -1;
        this.f26086k0 = -1;
        this.K0 = 2;
        this.f26087k1 = new ArrayList();
        this.f26095v1 = false;
        this.C1 = -1;
        this.f26096v2 = null;
        this.C2 = new c(Looper.myLooper());
        this.f26099y = str;
        this.A = obj;
        this.f26100z = cFGEntity;
        u9.b.x(this.f56478a);
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        this.f26095v1 = false;
        this.f26088p.f54027i.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        this.f26088p.f54026h.getRoot().setVisibility(8);
    }

    public final void U() {
        b1 b1Var = this.f26098x;
        if (b1Var != null) {
            b1Var.h();
            this.f26098x = null;
        }
    }

    public final void V() {
        h2 h2Var = this.f26097w;
        if (h2Var != null) {
            h2Var.h();
            this.f26097w = null;
        }
    }

    public final void W(boolean z10) {
        CFGPropertyKey cFGPropertyKeyC;
        int i10 = this.f26093u;
        if (i10 == 600 || i10 == 601 || i10 == 602 || i10 == 603) {
            cFGPropertyKeyC = null;
        } else {
            if (this.f26094v.get(Integer.valueOf(i10)) == null) {
                return;
            }
            cFGPropertyKeyC = this.f26094v.get(Integer.valueOf(this.f26093u)).c();
            cFGPropertyKeyC.key_id = this.C;
            cFGPropertyKeyC.comboKeyFirst = this.D;
            cFGPropertyKeyC.comboKeySecond = this.f26086k0;
            cFGPropertyKeyC.show = this.f26089q ? 1 : 0;
        }
        Message message = new Message();
        CFGEntity cFGEntityCopy = this.f26100z.copy();
        if (!z10) {
            Object obj = this.A;
            if (obj instanceof CFGPropertyMacro) {
                Iterator<CFGPropertyMacro> it2 = cFGEntityCopy.marcoList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CFGPropertyMacro next = it2.next();
                    if (n0.b(next, this.A)) {
                        cFGEntityCopy.marcoList.remove(next);
                        break;
                    }
                }
            } else if (obj instanceof CFGPropertyKey) {
                Iterator<CFGPropertyKey> it3 = cFGEntityCopy.keyList.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    CFGPropertyKey next2 = it3.next();
                    if (n0.b(next2, this.A)) {
                        cFGEntityCopy.keyList.remove(next2);
                        break;
                    }
                }
            }
        }
        int i11 = this.f26093u;
        if (i11 == 600 || i11 == 601 || i11 == 602 || i11 == 603) {
            CFGPropertyMacro cFGPropertyMacroG = this.K1.g();
            this.B = cFGPropertyMacroG;
            if (cFGPropertyMacroG.macro_keys.size() == 0) {
                Context context = this.f56478a;
                n8.b.m(context, context.getString(R.string.floatview_property_key_macro_key_atleast_one));
                return;
            }
            switch (this.f26093u) {
                case 601:
                    CFGPropertyMacro cFGPropertyMacro = this.B;
                    cFGPropertyMacro.type = 0;
                    ArrayList<CFGSubPropertyMacro> arrayList = cFGPropertyMacro.macro_keys;
                    arrayList.get(arrayList.size() - 1).setNextVKey(0);
                    break;
                case 602:
                    CFGPropertyMacro cFGPropertyMacro2 = this.B;
                    cFGPropertyMacro2.type = 1;
                    ArrayList<CFGSubPropertyMacro> arrayList2 = cFGPropertyMacro2.macro_keys;
                    arrayList2.get(arrayList2.size() - 1).setNextVKey(0);
                    break;
                case 603:
                    CFGPropertyMacro cFGPropertyMacro3 = this.B;
                    cFGPropertyMacro3.type = 2;
                    ArrayList<CFGSubPropertyMacro> arrayList3 = cFGPropertyMacro3.macro_keys;
                    arrayList3.get(arrayList3.size() - 1).setNextVKey(1);
                    break;
            }
            CFGPropertyMacro cFGPropertyMacro4 = this.B;
            message.obj = cFGPropertyMacro4;
            cFGEntityCopy.marcoList.add(cFGPropertyMacro4);
        } else {
            message.obj = cFGPropertyKeyC;
            cFGEntityCopy.keyList.add(cFGPropertyKeyC);
        }
        k<Integer, String> kVarA = n8.b.a(this.f56478a, cFGEntityCopy, this.f56484g);
        Integer num = kVarA.f4741a;
        if (num == null || num.intValue() == 0) {
            if (z10) {
                message.arg1 = 1;
            } else {
                message.arg1 = 0;
            }
            message.what = 101;
            this.f56482e.sendMessage(message);
            l();
            return;
        }
        if (kVarA.f4741a.intValue() == -4 || kVarA.f4741a.intValue() == -3 || kVarA.f4741a.intValue() == -2) {
            new u0(this.f56478a, kVarA).y();
        } else {
            n8.b.m(this.f56478a, kVarA.f4742b);
        }
    }

    public void X(byte[] bArr) {
        if (this.f26095v1 && m9.b.M(bArr)) {
            List<Integer> listV0 = m9.b.v0(bArr, this.f56484g);
            if (listV0.size() != 0) {
                int i10 = this.C1;
                if (i10 == 2) {
                    if (listV0.get(0).intValue() == this.C) {
                        this.f26095v1 = false;
                        this.f26088p.f54027i.getRoot().setVisibility(8);
                        Context context = this.f56478a;
                        n8.b.m(context, context.getString(R.string.floatview_property_macro_key_cannot_set_as_cancel));
                        return;
                    }
                    e8.d dVar = this.K1;
                    if (dVar != null) {
                        dVar.l(listV0.get(0).intValue());
                    }
                } else if (i10 == 1) {
                    if (listV0.get(0).intValue() == this.C) {
                        this.f26095v1 = false;
                        this.f26088p.f54027i.getRoot().setVisibility(8);
                        Context context2 = this.f56478a;
                        n8.b.m(context2, context2.getString(R.string.floatview_double_click_key_conflict_with_wheel_relation));
                        return;
                    }
                    d8.a aVar = this.f26094v.get(309);
                    if (aVar instanceof l) {
                        ((l) aVar).p(listV0.get(0).intValue());
                    }
                }
                this.f26095v1 = false;
                this.f26088p.f54027i.getRoot().setVisibility(8);
            }
        }
    }

    public final List<a8.c> Y(ArrayList<Integer> arrayList, int i10) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new a8.c(it2.next().intValue(), i10));
        }
        return arrayList2;
    }

    public final void Z(int i10) {
        View view = this.f26096v2;
        if (view != null) {
            view.setVisibility(8);
        }
        if (i10 == 600 || i10 == 601 || i10 == 602 || i10 == 603) {
            if (this.K1 == null) {
                c0();
            }
            e8.d dVar = this.K1;
            if (dVar != null) {
                PropertyLinearLayout propertyLinearLayoutH = dVar.h();
                this.f26096v2 = propertyLinearLayoutH;
                propertyLinearLayoutH.setVisibility(0);
            }
        } else {
            if (this.f26094v.get(Integer.valueOf(i10)) == null) {
                b0(i10, null);
            }
            if (this.f26094v.get(Integer.valueOf(i10)) != null) {
                PropertyLinearLayout propertyLinearLayoutD = this.f26094v.get(Integer.valueOf(i10)).d();
                this.f26096v2 = propertyLinearLayoutD;
                propertyLinearLayoutD.setVisibility(0);
            }
        }
        this.f26093u = i10;
    }

    @Override // d8.a.InterfaceC0292a, e8.d.b
    public void a(int i10) {
        this.f26095v1 = true;
        this.C1 = i10;
        this.f26088p.f54027i.getRoot().setVisibility(0);
    }

    public void a0(Object obj, CFGEntity cFGEntity) {
        int size;
        int iH;
        this.A = obj;
        this.f26100z = cFGEntity;
        if (this.f26088p == null) {
            n();
            return;
        }
        f0();
        Object obj2 = this.A;
        int i10 = 0;
        if (obj2 instanceof CFGPropertyKey) {
            CFGPropertyKey cFGPropertyKey = (CFGPropertyKey) obj2;
            this.f26088p.f54022d.k(cFGPropertyKey, this.f56484g, false);
            this.C = cFGPropertyKey.key_id;
            this.D = cFGPropertyKey.comboKeyFirst;
            this.f26086k0 = cFGPropertyKey.comboKeySecond;
            this.K0 = cFGPropertyKey.comboKeyMode;
            this.B = null;
            this.f26089q = cFGPropertyKey.show != 1;
            this.f26088p.f54023e.performClick();
            iH = a8.d.h(cFGPropertyKey, this.f56484g);
            b0(iH, cFGPropertyKey);
            size = -1;
        } else {
            if (obj2 instanceof CFGPropertyMacro) {
                CFGPropertyMacro cFGPropertyMacro = (CFGPropertyMacro) obj2;
                this.B = cFGPropertyMacro;
                this.f26088p.f54022d.l(cFGPropertyMacro, this.f56484g, false);
                CFGPropertyMacro cFGPropertyMacro2 = this.B;
                this.C = cFGPropertyMacro2.key_id;
                this.D = cFGPropertyMacro2.comboKeyFirst;
                this.f26086k0 = cFGPropertyMacro2.comboKeySecond;
                this.K0 = cFGPropertyMacro2.comboKeyMode;
                size = this.f26092t.size() - 1;
                c0();
                int i11 = this.B.type;
                if (i11 == 0) {
                    iH = 601;
                } else if (i11 == 1) {
                    iH = 602;
                } else if (i11 == 2) {
                    iH = 603;
                }
            } else {
                size = -1;
            }
            iH = -1;
        }
        int i12 = -1;
        for (int i13 = 0; i13 < this.f26092t.size() && (size == -1 || i12 == -1); i13++) {
            int i14 = 0;
            while (true) {
                if (i14 >= this.f26092t.get(i13).size()) {
                    break;
                }
                if (iH == this.f26092t.get(i13).get(i14).intValue()) {
                    size = i13;
                    i12 = i14;
                    break;
                }
                i14++;
            }
        }
        if (size == -1 && i12 == -1) {
            iH = 100;
            i12 = 0;
        } else {
            i10 = size;
        }
        com.flydigi.userBehavior.a.a().b(this.f56478a, "悬浮窗_属性设置_" + com.flydigi.sdk.gamepad.extension.a.j(this.C, this.D, this.f26086k0, this.f56484g.getDeviceMode()) + "_" + this.f56478a.getString(n8.b.i(iH)));
        this.f26090r.n();
        this.f26090r.m(i10);
        this.f26090r.notifyDataSetChanged();
        this.f26091s.I4(Y(this.f26092t.get(i10), 2));
        this.f26091s.n();
        this.f26091s.m(i12);
        Z(iH);
    }

    @Override // d8.a.InterfaceC0292a
    public void b(@yt.k String str, @yt.k String str2) {
        this.f26088p.f54026h.f54068d.setText(str);
        this.f26088p.f54026h.f54067c.setText(str2);
        this.f26088p.f54026h.getRoot().setVisibility(0);
        this.f26088p.f54026h.f54066b.setOnClickListener(new View.OnClickListener() { // from class: d8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f26085a.e0(view);
            }
        });
    }

    public final void b0(int i10, CFGPropertyKey cFGPropertyKey) {
        d8.a aVarG = a8.d.g(i10, this.f56478a, this.f56484g);
        aVarG.i(this);
        if (cFGPropertyKey != null) {
            aVarG.f(cFGPropertyKey);
        }
        PropertyLinearLayout propertyLinearLayoutD = aVarG.d();
        propertyLinearLayoutD.setId(i10);
        this.f26096v2 = propertyLinearLayoutD;
        this.f26088p.f54021c.addView(propertyLinearLayoutD);
        this.f26094v.put(Integer.valueOf(i10), aVarG);
    }

    @Override // e8.d.b
    public void c() {
        int i10;
        if (this.f26087k1.contains(Integer.valueOf(this.f26093u))) {
            Context context = this.f56478a;
            n8.b.m(context, context.getString(R.string.floatview_current_property_already_forbid));
            return;
        }
        h.k(this.f56478a, this.f26099y, "FloatView_Setting_Config_Import_Macro", "悬浮窗_属性设置_导入宏");
        if (this.B == null) {
            this.B = new CFGPropertyMacro();
        }
        e8.d dVar = this.K1;
        if (dVar != null) {
            this.B = dVar.g();
        }
        CFGPropertyMacro cFGPropertyMacro = this.B;
        int i11 = this.C;
        cFGPropertyMacro.key_id = i11;
        int i12 = this.D;
        cFGPropertyMacro.comboKeyFirst = i12;
        int i13 = this.f26086k0;
        cFGPropertyMacro.comboKeySecond = i13;
        cFGPropertyMacro.comboKeyMode = this.K0;
        cFGPropertyMacro.key = com.flydigi.sdk.gamepad.extension.a.j(i11, i12, i13, this.f56484g.getDeviceMode());
        int i14 = 60;
        if (l9.c.b(m9.k.f40818d, this.f56484g.getFirmwareVersion())) {
            i10 = 60 - x7.f.f54912s;
        } else {
            i10 = 40 - x7.f.f54912s;
            i14 = 40;
        }
        if (i10 <= 0 && this.B.macro_keys.size() == 0) {
            Context context2 = this.f56478a;
            n8.b.m(context2, String.format(context2.getString(R.string.max__marco), Integer.valueOf(i14)));
        } else {
            h2 h2Var = this.f26097w;
            if (h2Var != null) {
                h2Var.h();
            }
            this.f26098x = new b1(this.f56478a, this.C2, this.B, this.f26099y, this.f56484g);
        }
    }

    public final void c0() {
        if (this.K1 == null) {
            e8.d dVar = new e8.d(this.f56478a, this.f56484g);
            this.K1 = dVar;
            dVar.k(this);
        }
        if (this.B == null) {
            CFGPropertyMacro cFGPropertyMacro = new CFGPropertyMacro();
            this.B = cFGPropertyMacro;
            int i10 = this.C;
            cFGPropertyMacro.key_id = i10;
            int i11 = this.D;
            cFGPropertyMacro.comboKeyFirst = i11;
            int i12 = this.f26086k0;
            cFGPropertyMacro.comboKeySecond = i12;
            cFGPropertyMacro.comboKeyMode = this.K0;
            cFGPropertyMacro.key = com.flydigi.sdk.gamepad.extension.a.j(i10, i11, i12, this.f56484g.getDeviceMode());
        }
        this.K1.i(this.B);
        PropertyLinearLayout propertyLinearLayoutH = this.K1.h();
        propertyLinearLayoutH.setId(600);
        if (this.f26088p.f54021c.indexOfChild(propertyLinearLayoutH) == -1) {
            this.f26088p.f54021c.addView(propertyLinearLayoutH);
        }
    }

    @Override // e8.d.b
    public void d(@yt.k CFGPropertyMacro cFGPropertyMacro) {
        int i10;
        if (this.f26087k1.contains(Integer.valueOf(this.f26093u))) {
            Context context = this.f56478a;
            n8.b.m(context, context.getString(R.string.floatview_current_property_already_forbid));
            return;
        }
        h.k(this.f56478a, this.f26099y, "FloatView_Setting_Config_Edit_Macro", "悬浮窗_属性设置_编辑宏");
        this.B = cFGPropertyMacro;
        int i11 = this.C;
        cFGPropertyMacro.key_id = i11;
        int i12 = this.D;
        cFGPropertyMacro.comboKeyFirst = i12;
        int i13 = this.f26086k0;
        cFGPropertyMacro.comboKeySecond = i13;
        cFGPropertyMacro.comboKeyMode = this.K0;
        cFGPropertyMacro.key = com.flydigi.sdk.gamepad.extension.a.j(i11, i12, i13, this.f56484g.getDeviceMode());
        int i14 = 60;
        if (l9.c.b(m9.k.f40818d, this.f56484g.getFirmwareVersion())) {
            i10 = 60 - x7.f.f54912s;
        } else {
            i10 = 40 - x7.f.f54912s;
            i14 = 40;
        }
        if (i10 <= 0 && this.B.macro_keys.size() == 0) {
            Context context2 = this.f56478a;
            n8.b.m(context2, String.format(context2.getString(R.string.max__marco), Integer.valueOf(i14)));
            return;
        }
        switch (this.f26093u) {
            case 601:
                this.B.type = 0;
                break;
            case 602:
                this.B.type = 1;
                break;
            case 603:
                this.B.type = 2;
                break;
        }
        h2 h2Var = this.f26097w;
        if (h2Var != null) {
            h2Var.h();
        }
        this.f26097w = new h2(this.f56478a, this.C2, this.B, this.f56484g, this.f26099y);
        l();
        this.f56482e.sendEmptyMessage(110);
    }

    @Override // a8.b
    public void e(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<ArrayList<Integer>> arrayList3) {
        this.f26092t.addAll(arrayList3);
        this.f26090r.I4(Y(arrayList, 1));
        this.f26091s.I4(Y(arrayList2, 2));
    }

    public final void f0() {
        e8.d dVar = this.K1;
        if (dVar != null) {
            dVar.j();
            this.K1.h().setVisibility(8);
        }
        for (int i10 = 0; i10 < this.f26094v.values().size(); i10++) {
            this.f26094v.o(i10).g();
            this.f26094v.o(i10).d().setVisibility(8);
        }
    }

    public final void g0(int i10, KeyPropertySubPkgConfig keyPropertySubPkgConfig) {
        if (keyPropertySubPkgConfig.state.equals("1") && !this.f26087k1.contains(Integer.valueOf(i10))) {
            this.f26087k1.add(Integer.valueOf(i10));
        }
        b(keyPropertySubPkgConfig.title, keyPropertySubPkgConfig.text);
    }

    @Override // y7.b
    public void h() {
        super.h();
        V();
        U();
        u9.b.g(this.f56478a);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_property_key;
    }

    @Override // y7.b
    public void l() {
        super.l();
        u9.b.g(this.f56478a);
    }

    @Override // y7.b
    public void n() {
        d0 d0VarA = d0.a(this.f56479b);
        this.f26088p = d0VarA;
        d0VarA.f54027i.f54103d.setText(n8.b.l(this.f56478a, this.f56484g.getDeviceMode()));
        o.r(this.f26088p.f54027i.getRoot(), new View.OnClickListener() { // from class: d8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f26084a.d0(view);
            }
        });
        o.r(this.f26088p.f54031m, this);
        o.r(this.f26088p.f54033o, this);
        o.r(this.f26088p.f54032n, this);
        o.r(this.f26088p.f54023e, this);
        this.f26090r.J(1);
        this.f26091s.J(1);
        this.f26088p.f54028j.setAdapter(this.f26090r);
        this.f26088p.f54029k.setAdapter(this.f26091s);
        a8.d.i(this.f56484g, this);
        a0(this.A, this.f26100z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d0 d0Var = this.f26088p;
        if (view == d0Var.f54031m) {
            l();
            this.f56482e.sendEmptyMessage(111);
            return;
        }
        if (view == d0Var.f54033o) {
            if (this.f26087k1.contains(Integer.valueOf(this.f26093u))) {
                Context context = this.f56478a;
                n8.b.m(context, context.getString(R.string.floatview_current_property_already_forbid));
                return;
            }
            com.flydigi.userBehavior.a.a().b(this.f56478a, "悬浮窗_属性设置_" + com.flydigi.sdk.gamepad.extension.a.j(this.C, this.D, this.f26086k0, this.f56484g.getDeviceMode()) + "_保存" + this.f56478a.getString(n8.b.i(this.f26093u)));
            try {
                W(false);
                return;
            } catch (Exception e10) {
                n.c(e10.getMessage(), new Object[0]);
                return;
            }
        }
        if (view == d0Var.f54023e) {
            if (this.f26089q) {
                this.f26089q = false;
                d0Var.f54024f.setImageResource(R.drawable.floatingsetting_notdisplay);
                this.f26088p.f54025g.setText(this.f56478a.getString(R.string.floatview_hide));
                return;
            } else {
                this.f26089q = true;
                d0Var.f54024f.setImageResource(R.drawable.floatingsetting_display);
                this.f26088p.f54025g.setText(this.f56478a.getString(R.string.floatview_show));
                return;
            }
        }
        if (view == d0Var.f54032n) {
            if (this.f26087k1.contains(Integer.valueOf(this.f26093u))) {
                Context context2 = this.f56478a;
                n8.b.m(context2, context2.getString(R.string.floatview_current_property_already_forbid));
            } else {
                try {
                    W(true);
                } catch (Exception unused) {
                }
            }
        }
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(BluetoothDeviceOperateEvent bluetoothDeviceOperateEvent) {
        X(bluetoothDeviceOperateEvent.value);
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

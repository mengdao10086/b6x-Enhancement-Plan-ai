package y7;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.WindowManager;
import com.blankj.utilcode.util.n0;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.GameStrategyBean;
import com.flydigi.data.bean.RecommendConfigBean;
import com.flydigi.data.event.FlyMouseEvent;
import com.flydigi.float_view.R;
import com.flydigi.float_view.ui.config.FloatViewConfigManager;
import com.flydigi.float_view.ui.config.f1;
import com.flydigi.float_view.ui.config.l2;
import com.flydigi.float_view.ui.config.y1;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateBean;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateItem;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateList;
import i9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z7.b0;
import z7.b1;
import z7.e;
import z7.h0;
import z7.i0;
import z7.o0;
import z7.r;
import z7.t;
import z7.v;
import z7.x0;
import z7.z0;

/* JADX INFO: loaded from: classes7.dex */
public class m implements ViewManager, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowManager f56508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f56509c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GamepadInfo f56511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f56512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<CFGEntity> f56513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<RecommendConfigBean.RecommendConfig> f56514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56515i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Integer, y7.b> f56510d = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f56516j = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 19) {
                m.this.l0(message.arg1);
                return;
            }
            int i11 = message.arg1;
            Object obj = message.obj;
            CFGEntity cFGEntity = obj instanceof CFGEntity ? (CFGEntity) obj : null;
            if (i10 != 8) {
                if (i10 == 17) {
                    m.this.y(0);
                    m.this.y(1);
                    Bundle bundle = new Bundle();
                    bundle.putInt(DataConstant.KEY_CONFIG_POSITION, i11);
                    bundle.putParcelable("key_config", cFGEntity);
                    m.this.w(4, bundle);
                    return;
                }
                if (i10 == 18) {
                    m.this.y(1);
                    m.this.v(2);
                    return;
                }
                if (i10 == 20) {
                    m.this.l0(4);
                    if (!o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false)) {
                        m.this.Q(0);
                    }
                    m.this.v(1);
                    return;
                }
                if (i10 == 21) {
                    m.this.v(1);
                    m.this.y(2);
                    return;
                }
                switch (i10) {
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        switch (i10) {
                            case 27:
                                m.this.y(0);
                                m.this.y(1);
                                m.this.v(14);
                                break;
                            case 28:
                                m.this.l0(14);
                                m.this.Q(0);
                                m.this.Q(1);
                                break;
                            case 29:
                                m.this.l0(14);
                                m.this.Q(0);
                                m.this.Q(1);
                                m.this.I(i10, message.obj);
                                break;
                            default:
                                m.this.H(i10, i11, cFGEntity);
                                break;
                        }
                        break;
                }
            }
            m.this.l0(4);
            m.this.y(1);
            m.this.Q(2);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("key_config", cFGEntity);
            m.this.w(0, bundle2);
            m.this.H(i10, i11, cFGEntity);
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            m.this.v(1);
            super.handleMessage(message);
        }
    }

    public m(Context context, Handler handler) {
        this.f56507a = context;
        this.f56509c = handler;
        this.f56508b = (WindowManager) context.getApplicationContext().getSystemService("window");
    }

    public static /* synthetic */ CFGVibrateBean A(CFGVibrateList cFGVibrateList) throws Exception {
        return cFGVibrateList.getConfigs().get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(Throwable th2) throws Exception {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new CFGVibrateItem());
        arrayList.add(new CFGVibrateItem());
        arrayList.add(new CFGVibrateItem());
        u(new CFGVibrateBean(0, this.f56507a.getString(R.string.str_lib_text_266), false, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        if (DataConstant.TEST_KEYMAPPING.equals(this.f56512f)) {
            return;
        }
        com.flydigi.base.common.n.a("flydigitestdata 隐藏所有悬浮窗 游戏包名：" + this.f56512f);
        Iterator<Map.Entry<Integer, y7.b>> it2 = this.f56510d.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<Integer, y7.b> next = it2.next();
            Integer key = next.getKey();
            y7.b value = next.getValue();
            if (value != null) {
                if (key.intValue() == 0 || key.intValue() == 1) {
                    value.l();
                } else {
                    View viewJ = value.j();
                    if (viewJ != null && this.f56508b != null && viewJ.isAttachedToWindow()) {
                        this.f56508b.removeView(viewJ);
                    }
                    value.h();
                    it2.remove();
                }
            }
        }
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(this.f56507a, DataConstant.REMOTE_ACTION_END_GAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        Iterator<Integer> it2 = this.f56510d.keySet().iterator();
        while (it2.hasNext()) {
            Integer next = it2.next();
            if (next.intValue() != 5) {
                y7.b bVar = this.f56510d.get(next);
                if (bVar != null) {
                    View viewJ = bVar.j();
                    if (viewJ != null && this.f56508b != null && viewJ.isAttachedToWindow()) {
                        this.f56508b.removeView(viewJ);
                    }
                    bVar.h();
                }
                it2.remove();
            }
        }
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(this.f56507a, DataConstant.REMOTE_ACTION_END_GAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(boolean z10) {
        if (z10) {
            if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_MAPPING_ICON_WHEN_FLYMOUSE_USING, Build.VERSION.SDK_INT >= 31)) {
                y(0);
                return;
            }
            return;
        }
        if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_MAPPING_ICON_WHEN_FLYMOUSE_USING, Build.VERSION.SDK_INT >= 31) && !o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false)) {
            if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_MAPPING_SHOW_MAPPING_ICON + this.f56512f, true)) {
                Q(0);
            }
        }
        l0(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        l0(12);
        Bundle bundle = new Bundle();
        bundle.putInt("action", 7);
        J(bundle);
    }

    public void F(int i10) {
        G(i10, -1);
    }

    public void G(int i10, int i11) {
        H(i10, i11, null);
    }

    public void H(int i10, int i11, Object obj) {
        if (this.f56509c != null) {
            Message message = new Message();
            message.what = i10;
            if (i11 > -1) {
                message.arg1 = i11;
            }
            message.obj = obj;
            this.f56509c.sendMessage(message);
        }
    }

    public void I(int i10, Object obj) {
        H(i10, -1, obj);
    }

    public void J(Bundle bundle) {
        int i10 = bundle.getInt("action");
        if (i10 == 1) {
            y7.b bVar = this.f56510d.get(0);
            if (bVar != null) {
                ((f1) bVar).I();
                return;
            }
            return;
        }
        if (i10 == 2) {
            if (!o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false)) {
                Q(0);
            }
            if (!n0.x(this.f56512f) || n0.b(this.f56512f, DataConstant.TEST_KEYMAPPING)) {
                return;
            }
            v(2);
            return;
        }
        if (i10 == 3) {
            l0(3);
            l0(4);
            y(0);
            y(1);
            y(2);
            w(4, bundle);
            return;
        }
        if (i10 != 7) {
            return;
        }
        y(2);
        v(1);
        HashMap map = new HashMap();
        map.put("action", "呼出菜单-手柄");
        u9.g.a().e(this.f56507a, "Float_View_Select_Menu_Function_Click", map);
    }

    public void K(String str, List<CFGEntity> list, List<RecommendConfigBean.RecommendConfig> list2, CFGEntity cFGEntity) {
        this.f56512f = str;
        this.f56513g = list;
        this.f56514h = list2;
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f56512f);
        bundle.putParcelable("key_config", cFGEntity);
        w(0, bundle);
        if (!n0.b(this.f56512f, DataConstant.TEST_KEYMAPPING)) {
            v(2);
        }
        l0(1);
        l0(3);
        l0(4);
    }

    public void L() {
        this.f56516j.postDelayed(new Runnable() { // from class: y7.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f56503a.D();
            }
        }, 100L);
    }

    public void M(boolean z10) {
        this.f56515i = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setCurrentLandScape:");
        sb2.append(this.f56515i ? "横屏" : "竖屏");
        sb2.append("，mCurrentPkgName：");
        sb2.append(this.f56512f);
        if (!this.f56515i || !DBManager.getInstance().isSupportGame(this.f56512f)) {
            y(1);
            y(0);
        } else {
            if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false)) {
                return;
            }
            Q(0);
        }
    }

    public void N(GamepadInfo gamepadInfo) {
        this.f56511e = gamepadInfo;
    }

    public void O(String str) {
        this.f56512f = str;
    }

    public void P(FlyMouseEvent flyMouseEvent) {
        if (!TextUtils.equals(this.f56512f, DataConstant.TEST_KEYMAPPING) && this.f56515i) {
            y7.b eVar = this.f56510d.get(3);
            if (eVar == null) {
                eVar = new z7.e(this.f56507a, this, new e.a() { // from class: y7.k
                    @Override // z7.e.a
                    public final void a(boolean z10) {
                        this.f56505a.E(z10);
                    }
                });
                this.f56510d.put(3, eVar);
            }
            ((z7.e) eVar).F(flyMouseEvent);
        }
    }

    public void Q(int i10) {
        y7.b bVar = this.f56510d.get(Integer.valueOf(i10));
        if (bVar != null) {
            bVar.y();
        }
    }

    public void R(int i10, List<CFGEntity> list) {
        y7.b bVar = this.f56510d.get(1);
        if (bVar != null) {
            ((FloatViewConfigManager) bVar).I1(i10, list);
        }
    }

    @Override // android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view.isAttachedToWindow()) {
            return;
        }
        this.f56508b.addView(view, layoutParams);
    }

    public boolean h() {
        y7.b bVar = this.f56510d.get(4);
        return bVar != null && bVar.k();
    }

    public boolean i(boolean z10) {
        y7.b bVar = this.f56510d.get(11);
        y7.b bVar2 = this.f56510d.get(4);
        y7.b bVar3 = this.f56510d.get(8);
        y7.b bVar4 = this.f56510d.get(3);
        boolean z11 = (bVar == null && bVar2 == null && bVar3 == null) ? false : true;
        return z10 ? z11 || bVar4 != null : z11;
    }

    public boolean j(int i10) {
        return this.f56510d.get(Integer.valueOf(i10)) != null;
    }

    public final void k() {
        if (this.f56515i) {
            y7.b bVar = this.f56510d.get(2);
            if (bVar != null) {
                bVar.y();
            } else {
                this.f56510d.put(2, new b0(this.f56507a, new b(Looper.getMainLooper()), this.f56512f));
            }
        }
    }

    public final void l(Bundle bundle) {
        l0(5);
        new z7.b(this.f56507a, this.f56516j, bundle.getString("device_name", ""), bundle.getBoolean(DataConstant.DEVICE_CONNECT_STATE));
    }

    @Override // y7.n
    public void l0(int i10) {
        y7.b bVar = this.f56510d.get(Integer.valueOf(i10));
        if (bVar != null) {
            View viewJ = bVar.j();
            if (viewJ != null && this.f56508b != null && viewJ.isAttachedToWindow()) {
                this.f56508b.removeView(viewJ);
            }
            bVar.h();
            this.f56510d.remove(Integer.valueOf(i10));
        }
    }

    public final void m() {
        this.f56510d.put(12, new h0(this.f56507a, this.f56511e, new h0.a() { // from class: y7.l
            @Override // z7.h0.a
            public final void a() {
                this.f56506a.z();
            }
        }, this));
    }

    public final void n(Bundle bundle) {
        y7.b bVar = this.f56510d.get(2);
        if (bVar != null && !bVar.k()) {
            com.flydigi.base.common.n.c("flydigitestdata createFloatViewGameStrategy 非悬浮球界面显示 跳过攻略显示", new Object[0]);
            return;
        }
        this.f56510d.put(8, new i0(this.f56507a, this.f56516j, bundle.getString("package_name"), bundle.getBoolean("value"), (GameStrategyBean) bundle.getSerializable("content"), this));
    }

    public final void o(Bundle bundle) {
        if (this.f56511e == null) {
            return;
        }
        final y7.b f1Var = this.f56510d.get(0);
        if (f1Var == null) {
            f1Var = new f1(this.f56507a, this);
            this.f56510d.put(0, f1Var);
        }
        f1Var.x(this.f56511e);
        ((f1) f1Var).H((CFGEntity) bundle.getParcelable("key_config"), this.f56512f);
        if (!this.f56515i || o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false)) {
            this.f56516j.postDelayed(new Runnable() { // from class: y7.g
                @Override // java.lang.Runnable
                public final void run() {
                    f1Var.l();
                }
            }, 40L);
        } else {
            this.f56516j.postDelayed(new Runnable() { // from class: y7.h
                @Override // java.lang.Runnable
                public final void run() {
                    f1Var.y();
                }
            }, 40L);
        }
    }

    public final void p() {
        if (this.f56511e == null || TextUtils.equals(this.f56512f, DataConstant.TEST_KEYMAPPING)) {
            return;
        }
        y7.b floatViewConfigManager = this.f56510d.get(1);
        if (floatViewConfigManager == null) {
            floatViewConfigManager = new FloatViewConfigManager(this.f56507a, this, this.f56516j, this.f56511e, this.f56512f, this.f56513g, this.f56514h);
            this.f56510d.put(1, floatViewConfigManager);
        } else {
            ((FloatViewConfigManager) floatViewConfigManager).H1(this.f56511e, this.f56512f, this.f56513g, this.f56514h);
        }
        try {
            if (this.f56515i) {
                floatViewConfigManager.y();
            } else {
                floatViewConfigManager.l();
            }
        } catch (Exception unused) {
        }
    }

    public final void q(Bundle bundle) {
        this.f56510d.put(4, new y1(this.f56507a, this, this.f56516j, this.f56512f, this.f56511e, this.f56513g, (CFGEntity) bundle.getParcelable("key_config"), bundle.getInt(DataConstant.KEY_CONFIG_POSITION, -1), bundle.getInt(DataConstant.KEY_EDIT_TYPE, 0)));
    }

    public final void r(Bundle bundle) {
        l0(6);
        new b1(this.f56507a, this.f56516j, bundle.getString("content"));
    }

    @Override // android.view.ViewManager
    public void removeView(View view) {
        this.f56508b.removeView(view);
    }

    public final void s(int i10, Bundle bundle) {
        boolean z10 = bundle.getBoolean("value");
        l0(i10);
        if (z10) {
            y7.b x0Var = null;
            switch (i10) {
                case 90:
                    x0Var = new x0(this.f56507a, this);
                    break;
                case 91:
                    x0Var = new r(this.f56507a, this);
                    break;
                case 92:
                    x0Var = new t(this.f56507a, this);
                    break;
                case 94:
                    x0Var = new z7.l(this.f56507a, this);
                    break;
                case 95:
                    x0Var = new z0(this.f56507a, this);
                    break;
                case 96:
                    x0Var = new v(this.f56507a, this);
                    break;
            }
            if (x0Var != null) {
                this.f56510d.put(Integer.valueOf(i10), x0Var);
            }
        }
    }

    public final void t() {
        o0 o0Var = new o0(this.f56507a);
        o0Var.y();
        this.f56510d.put(13, o0Var);
    }

    public final void u(CFGVibrateBean cFGVibrateBean) {
        l2 l2Var = new l2(this.f56507a, cFGVibrateBean, this.f56516j, this.f56511e);
        l2Var.y();
        this.f56510d.put(14, l2Var);
    }

    @Override // android.view.ViewManager
    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        this.f56508b.updateViewLayout(view, layoutParams);
    }

    public void v(int i10) {
        w(i10, null);
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public void w(int r2, android.os.Bundle r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L65
            r0 = 1
            if (r2 == r0) goto L61
            r0 = 2
            if (r2 == r0) goto L5d
            r0 = 4
            if (r2 == r0) goto L59
            r0 = 5
            if (r2 == r0) goto L55
            r0 = 6
            if (r2 == r0) goto L51
            r0 = 8
            if (r2 == r0) goto L4d
            switch(r2) {
                case 12: goto L49;
                case 13: goto L45;
                case 14: goto L23;
                default: goto L18;
            }
        L18:
            switch(r2) {
                case 90: goto L1f;
                case 91: goto L1f;
                case 92: goto L1f;
                default: goto L1b;
            }
        L1b:
            switch(r2) {
                case 94: goto L1f;
                case 95: goto L1f;
                case 96: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L68
        L1f:
            r1.s(r2, r3)
            goto L68
        L23:
            java.lang.String r2 = r1.f56512f
            xi.z r2 = e6.z.q0(r2)
            y7.f r3 = new dj.o() { // from class: y7.f
                static {
                    /*
                        y7.f r0 = new y7.f
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:y7.f) y7.f.a y7.f
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: y7.f.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: y7.f.<init>():void");
                }

                @Override // dj.o
                public final java.lang.Object apply(java.lang.Object r1) {
                    /*
                        r0 = this;
                        com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateList r1 = (com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateList) r1
                        com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateBean r1 = y7.m.a(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: y7.f.apply(java.lang.Object):java.lang.Object");
                }
            }
            xi.z r2 = r2.A3(r3)
            xi.f0 r3 = o5.l.d()
            xi.z r2 = r2.s0(r3)
            y7.d r3 = new y7.d
            r3.<init>()
            y7.e r0 = new y7.e
            r0.<init>()
            r2.F5(r3, r0)
            goto L68
        L45:
            r1.t()
            goto L68
        L49:
            r1.m()
            goto L68
        L4d:
            r1.n(r3)
            goto L68
        L51:
            r1.r(r3)
            goto L68
        L55:
            r1.l(r3)
            goto L68
        L59:
            r1.q(r3)
            goto L68
        L5d:
            r1.k()
            goto L68
        L61:
            r1.p()
            goto L68
        L65:
            r1.o(r3)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.m.w(int, android.os.Bundle):void");
    }

    public void x() {
        this.f56516j.postDelayed(new Runnable() { // from class: y7.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f56504a.C();
            }
        }, 100L);
    }

    public void y(int i10) {
        y7.b bVar = this.f56510d.get(Integer.valueOf(i10));
        if (bVar != null) {
            bVar.l();
        }
    }
}

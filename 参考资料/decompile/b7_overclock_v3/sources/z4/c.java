package z4;

import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.data.event.FlyMouseEvent;
import com.flydigi.float_view.ui.config.FloatViewConfigManager;
import com.flydigi.float_view.ui.config.h1;
import com.flydigi.float_view.ui.config.h2;
import com.flydigi.float_view.ui.config.l2;
import com.flydigi.float_view.ui.config.y1;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import vt.e;
import x7.f;
import z7.r0;

/* JADX INFO: loaded from: classes2.dex */
public class c implements vt.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, vt.c> f57731a = new HashMap();

    static {
        ThreadMode threadMode = ThreadMode.MAIN;
        b(new vt.b(l2.class, true, new e[]{new e("onEvent", BluetoothDeviceOperateEvent.class, threadMode)}));
        b(new vt.b(f.class, true, new e[]{new e("onEvent", BluetoothDeviceOperateEvent.class, threadMode), new e("onEvent", FlyMouseEvent.class, threadMode)}));
        b(new vt.b(FloatViewConfigManager.class, true, new e[]{new e("onEvent", BluetoothDeviceOperateEvent.class, threadMode)}));
        b(new vt.b(y1.class, true, new e[]{new e("onEvent", BluetoothDeviceOperateEvent.class, threadMode)}));
        b(new vt.b(h2.class, true, new e[]{new e("onEvent", BluetoothDeviceOperateEvent.class, threadMode)}));
        b(new vt.b(h1.class, true, new e[]{new e("onEvent", BluetoothDeviceOperateEvent.class, threadMode)}));
        b(new vt.b(b8.d.class, true, new e[]{new e("onEvent", BluetoothDeviceOperateEvent.class, threadMode)}));
        b(new vt.b(r0.class, true, new e[]{new e("onEvent", FlyMouseEvent.class, threadMode)}));
        b(new vt.b(d8.d.class, true, new e[]{new e("onEvent", BluetoothDeviceOperateEvent.class, threadMode)}));
    }

    public static void b(vt.c cVar) {
        f57731a.put(cVar.d(), cVar);
    }

    @Override // vt.d
    public vt.c a(Class<?> cls) {
        vt.c cVar = f57731a.get(cls);
        if (cVar != null) {
            return cVar;
        }
        return null;
    }
}

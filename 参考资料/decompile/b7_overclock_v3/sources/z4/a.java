package z4;

import com.flydigi.data.event.BadgeEvent;
import com.flydigi.data.event.ExitAppEvent;
import com.flydigi.data.event.FZAccountLoginChangeEvent;
import com.flydigi.qiji.FZApplication;
import com.flydigi.qiji.ui.account.AccountFragment;
import com.game.motionelf.activity.ActivityStart;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import vt.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements vt.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, vt.c> f57729a = new HashMap();

    static {
        b(new vt.b(ActivityStart.class, true, new e[]{new e("onEvent", FZAccountLoginChangeEvent.class)}));
        ThreadMode threadMode = ThreadMode.MAIN;
        b(new vt.b(FZApplication.class, true, new e[]{new e("onEvent", ExitAppEvent.class, threadMode)}));
        b(new vt.b(AccountFragment.class, true, new e[]{new e("onEvent", BadgeEvent.class, threadMode, 0, true), new e("onEvent", FZAccountLoginChangeEvent.class, threadMode)}));
    }

    public static void b(vt.c cVar) {
        f57729a.put(cVar.d(), cVar);
    }

    @Override // vt.d
    public vt.c a(Class<?> cls) {
        vt.c cVar = f57729a.get(cls);
        if (cVar != null) {
            return cVar;
        }
        return null;
    }
}

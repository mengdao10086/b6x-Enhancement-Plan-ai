package z4;

import com.flydigi.data.event.APKInstallEvent;
import com.flydigi.game.data.DownloadTaskEvent;
import com.flydigi.game.ui.game_detail.GameDetailFragment;
import com.flydigi.game.widget.DownloadGameItemView;
import com.flydigi.game.widget.GameItemView;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import vt.e;

/* JADX INFO: loaded from: classes2.dex */
public class d implements vt.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, vt.c> f57732a = new HashMap();

    static {
        ThreadMode threadMode = ThreadMode.MAIN;
        b(new vt.b(DownloadGameItemView.class, true, new e[]{new e("onEvent", APKInstallEvent.class, threadMode), new e("onEvent", DownloadTaskEvent.class, threadMode)}));
        b(new vt.b(GameDetailFragment.class, true, new e[]{new e("onEvent", DownloadTaskEvent.class, threadMode), new e("onEvent", APKInstallEvent.class, threadMode)}));
        b(new vt.b(GameItemView.class, true, new e[]{new e("onEvent", APKInstallEvent.class, threadMode, 0, true), new e("onEvent", DownloadTaskEvent.class, threadMode)}));
    }

    public static void b(vt.c cVar) {
        f57732a.put(cVar.d(), cVar);
    }

    @Override // vt.d
    public vt.c a(Class<?> cls) {
        vt.c cVar = f57732a.get(cls);
        if (cVar != null) {
            return cVar;
        }
        return null;
    }
}

package kotlinx.coroutines.android;

import a.fg2;
import a.fh2;
import a.hh2;
import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public /* bridge */ /* synthetic */ fg2 createDispatcher(List list) {
        return createDispatcher((List<? extends MainDispatcherFactory>) list);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public fh2 createDispatcher(List<? extends MainDispatcherFactory> list) {
        return new fh2(hh2.a(Looper.getMainLooper(), true), null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}

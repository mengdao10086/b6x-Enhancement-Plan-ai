package si;

import io.objectbox.BoxStore;
import io.objectbox.sync.SyncBuilder;
import io.objectbox.sync.SyncCredentials;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static SyncBuilder a(BoxStore boxStore, String str, SyncCredentials syncCredentials) {
        return new SyncBuilder(boxStore, str, syncCredentials);
    }

    public static boolean b() {
        return BoxStore.v2();
    }

    public static boolean c() {
        return BoxStore.w2();
    }

    public static vi.c d(BoxStore boxStore, String str, SyncCredentials syncCredentials) {
        return new vi.c(boxStore, str, syncCredentials);
    }
}

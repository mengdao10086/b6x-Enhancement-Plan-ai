package vi;

import io.objectbox.BoxStore;
import io.objectbox.sync.SyncCredentials;
import io.objectbox.sync.listener.SyncChangeListener;
import io.objectbox.sync.server.SyncServerImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@li.b
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BoxStore f53185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<SyncCredentials> f53187c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f53188d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public String f53189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SyncChangeListener f53190f;

    public c(BoxStore boxStore, String str, SyncCredentials syncCredentials) {
        f(boxStore, "BoxStore is required.");
        f(str, "Sync server URL is required.");
        f(syncCredentials, "Authenticator credentials are required.");
        if (!BoxStore.w2()) {
            throw new IllegalStateException("This library does not include ObjectBox Sync Server. Please visit https://objectbox.io/sync/ for options.");
        }
        this.f53185a = boxStore;
        this.f53186b = str;
        a(syncCredentials);
    }

    public c a(SyncCredentials syncCredentials) {
        f(syncCredentials, "Authenticator credentials must not be null.");
        this.f53187c.add(syncCredentials);
        return this;
    }

    public b b() {
        if (this.f53187c.isEmpty()) {
            throw new IllegalStateException("At least one authenticator is required.");
        }
        return new SyncServerImpl(this);
    }

    public b c() {
        b bVarB = b();
        bVarB.start();
        return bVarB;
    }

    public c d(String str) {
        this.f53189e = str;
        return this;
    }

    public c e(SyncChangeListener syncChangeListener) {
        this.f53190f = syncChangeListener;
        return this;
    }

    public final void f(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public c g(String str) {
        return h(str, SyncCredentials.b());
    }

    public c h(String str, SyncCredentials syncCredentials) {
        this.f53188d.add(new a(str, syncCredentials));
        return this;
    }
}

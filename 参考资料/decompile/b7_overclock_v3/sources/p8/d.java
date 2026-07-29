package p8;

import android.content.Context;
import com.flydigi.game.utils.FZGameDownloadHandler;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements k5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final d f46511a = new d();

    @Override // k5.a
    public void init(@k Context context) {
        f0.p(context, "context");
        FZGameDownloadHandler.getInstance().init(context);
        b.f().g(context);
    }
}

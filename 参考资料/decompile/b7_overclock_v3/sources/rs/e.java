package rs;

import com.uc.crashsdk.export.LogType;
import java.security.SecureRandom;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class e extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f49163c;

    public e(SecureRandom secureRandom, s sVar) {
        super(secureRandom, LogType.UNEXP_EXIT);
        this.f49163c = sVar;
    }

    public s c() {
        return this.f49163c;
    }
}

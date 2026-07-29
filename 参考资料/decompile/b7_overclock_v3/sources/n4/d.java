package n4;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.s;
import g.n0;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c4.g<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41845a = "GifEncoder";

    @Override // c4.g
    @n0
    public EncodeStrategy b(@n0 c4.e eVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // c4.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 s<c> sVar, @n0 File file, @n0 c4.e eVar) throws Throwable {
        try {
            v4.a.f(sVar.get().f(), file);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}

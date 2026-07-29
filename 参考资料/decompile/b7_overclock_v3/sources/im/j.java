package im;

import gm.c0;
import gm.f0;
import gm.n0;
import gm.n2;
import gm.w;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class j extends w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f32530c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f32531d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f32533b;

    public j(gm.h hVar) {
        w wVarX;
        if ((hVar instanceof f0) || (hVar instanceof k)) {
            this.f32532a = 0;
            wVarX = k.x(hVar);
        } else {
            if (!(hVar instanceof n0)) {
                throw new IllegalArgumentException("Unknown check object in integrity check.");
            }
            this.f32532a = 1;
            wVarX = m.y(((n0) hVar).U());
        }
        this.f32533b = wVarX;
    }

    public j(k kVar) {
        this((gm.h) kVar);
    }

    public j(m mVar) {
        this(new n2(0, mVar));
    }

    public static j x(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return new j(c0.D((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Unable to parse integrity check details.");
            }
        }
        if (obj != null) {
            return new j((gm.h) obj);
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        w wVar = this.f32533b;
        return wVar instanceof m ? new n2(0, wVar) : wVar.b();
    }

    public w y() {
        return this.f32533b;
    }

    public int z() {
        return this.f32532a;
    }
}

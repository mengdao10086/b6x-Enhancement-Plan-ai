package org.bouncycastle.crypto.util;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    public static org.bouncycastle.crypto.j a(SecureRandom secureRandom, int i10) {
        org.bouncycastle.crypto.j jVar = new org.bouncycastle.crypto.j();
        jVar.b(new y(secureRandom, i10));
        return jVar;
    }

    public static org.bouncycastle.crypto.j b(gm.y yVar, SecureRandom secureRandom) throws IllegalArgumentException {
        if (kn.d.f37625y.C(yVar)) {
            return a(secureRandom, 128);
        }
        if (kn.d.G.C(yVar)) {
            return a(secureRandom, 192);
        }
        if (kn.d.O.C(yVar)) {
            return a(secureRandom, 256);
        }
        if (kn.d.C.C(yVar)) {
            return a(secureRandom, 128);
        }
        if (kn.d.K.C(yVar)) {
            return a(secureRandom, 192);
        }
        if (kn.d.S.C(yVar)) {
            return a(secureRandom, 256);
        }
        if (kn.d.D.C(yVar)) {
            return a(secureRandom, 128);
        }
        if (kn.d.L.C(yVar)) {
            return a(secureRandom, 192);
        }
        if (kn.d.T.C(yVar)) {
            return a(secureRandom, 256);
        }
        if (s.Z3.C(yVar)) {
            fp.g gVar = new fp.g();
            gVar.b(new y(secureRandom, 192));
            return gVar;
        }
        if (mn.a.f41443a.C(yVar)) {
            return a(secureRandom, 128);
        }
        if (mn.a.f41444b.C(yVar)) {
            return a(secureRandom, 192);
        }
        if (mn.a.f41445c.C(yVar)) {
            return a(secureRandom, 256);
        }
        if (!gn.a.f29838a.C(yVar) && !a.f44725b.C(yVar)) {
            if (on.b.f44361e.C(yVar)) {
                fp.f fVar = new fp.f();
                fVar.b(new y(secureRandom, 64));
                return fVar;
            }
            if (!s.f46791b4.C(yVar) && !s.f46788a4.C(yVar)) {
                throw new IllegalArgumentException("cannot recognise cipher: " + yVar);
            }
            return a(secureRandom, 128);
        }
        return a(secureRandom, 128);
    }
}

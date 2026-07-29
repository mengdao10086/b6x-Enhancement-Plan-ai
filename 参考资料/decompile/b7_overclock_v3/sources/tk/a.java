package tk;

import hk.h;
import kotlin.jvm.internal.f0;
import kotlin.text.i;
import kotlin.text.j;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "RegexExtensionsJDK8Kt")
public final class a {
    @v0(version = "1.2")
    @l
    public static final kotlin.text.h a(@k i iVar, @k String name) {
        f0.p(iVar, "<this>");
        f0.p(name, "name");
        j jVar = iVar instanceof j ? (j) iVar : null;
        if (jVar != null) {
            return jVar.c(name);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}

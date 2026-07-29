package ze;

/* JADX INFO: loaded from: classes7.dex */
public final class j0 extends t {
    @Override // ze.t
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public i0 k(ve.k kVar) {
        String strSubstring;
        String strG;
        String str;
        boolean z10;
        String strC = t.c(kVar);
        if (!strC.startsWith("WIFI:") || (strG = t.g("S:", (strSubstring = strC.substring(5)), zc.f.f58382l, false)) == null || strG.isEmpty()) {
            return null;
        }
        String strG2 = t.g("P:", strSubstring, zc.f.f58382l, false);
        String strG3 = t.g("T:", strSubstring, zc.f.f58382l, false);
        if (strG3 == null) {
            strG3 = "nopass";
        }
        String str2 = strG3;
        String strG4 = t.g("PH2:", strSubstring, zc.f.f58382l, false);
        String strG5 = t.g("H:", strSubstring, zc.f.f58382l, false);
        if (strG5 == null) {
            str = strG4;
        } else {
            if (strG4 != null || "true".equalsIgnoreCase(strG5) || "false".equalsIgnoreCase(strG5)) {
                str = strG4;
                z10 = Boolean.parseBoolean(strG5);
                return new i0(str2, strG, strG2, z10, t.g("I:", strSubstring, zc.f.f58382l, false), t.g("A:", strSubstring, zc.f.f58382l, false), t.g("E:", strSubstring, zc.f.f58382l, false), str);
            }
            str = strG5;
        }
        z10 = false;
        return new i0(str2, strG, strG2, z10, t.g("I:", strSubstring, zc.f.f58382l, false), t.g("A:", strSubstring, zc.f.f58382l, false), t.g("E:", strSubstring, zc.f.f58382l, false), str);
    }
}

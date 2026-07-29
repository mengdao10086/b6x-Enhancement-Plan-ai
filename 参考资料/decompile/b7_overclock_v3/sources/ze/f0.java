package ze;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class f0 extends t {
    public static String q(CharSequence charSequence, String str) {
        List<String> listT = e0.t(charSequence, str, true, false);
        if (listT == null || listT.isEmpty()) {
            return null;
        }
        return listT.get(0);
    }

    public static String[] r(CharSequence charSequence, String str) {
        List<List<String>> listU = e0.u(charSequence, str, true, false);
        if (listU == null || listU.isEmpty()) {
            return null;
        }
        int size = listU.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = listU.get(i10).get(0);
        }
        return strArr;
    }

    public static String t(String str) {
        return str != null ? (str.startsWith(u0.c.f51788b) || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    @Override // ze.t
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public g k(ve.k kVar) {
        double d10;
        String strC = t.c(kVar);
        if (strC.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String strQ = q("SUMMARY", strC);
        String strQ2 = q("DTSTART", strC);
        if (strQ2 == null) {
            return null;
        }
        String strQ3 = q("DTEND", strC);
        String strQ4 = q("DURATION", strC);
        String strQ5 = q(w3.c.f53848d, strC);
        String strT = t(q("ORGANIZER", strC));
        String[] strArrR = r("ATTENDEE", strC);
        if (strArrR != null) {
            for (int i10 = 0; i10 < strArrR.length; i10++) {
                strArrR[i10] = t(strArrR[i10]);
            }
        }
        String strQ6 = q("DESCRIPTION", strC);
        String strQ7 = q("GEO", strC);
        double d11 = Double.NaN;
        if (strQ7 == null) {
            d10 = Double.NaN;
        } else {
            int iIndexOf = strQ7.indexOf(59);
            if (iIndexOf < 0) {
                return null;
            }
            try {
                d11 = Double.parseDouble(strQ7.substring(0, iIndexOf));
                d10 = Double.parseDouble(strQ7.substring(iIndexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new g(strQ, strQ2, strQ3, strQ4, strQ5, strT, strArrR, strQ6, d11, d10);
    }
}

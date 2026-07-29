package zp;

/* JADX INFO: loaded from: classes5.dex */
public class c implements a {
    @Override // zp.a
    public String a(String str) {
        int i10;
        String str2;
        StringBuffer stringBuffer = new StringBuffer(str);
        int i11 = 0;
        while (i11 < stringBuffer.length()) {
            char cCharAt = stringBuffer.charAt(i11);
            if (cCharAt == '\n') {
                i10 = i11 + 1;
                str2 = "\\n";
            } else if (cCharAt == '\r') {
                i10 = i11 + 1;
                str2 = "\\r";
            } else if (cCharAt == '\"') {
                i10 = i11 + 1;
                str2 = "\\\"";
            } else if (cCharAt == '\'') {
                i10 = i11 + 1;
                str2 = "\\'";
            } else if (cCharAt == '-') {
                i10 = i11 + 1;
                str2 = "\\-";
            } else if (cCharAt == '/') {
                i10 = i11 + 1;
                str2 = "\\/";
            } else if (cCharAt == ';') {
                i10 = i11 + 1;
                str2 = "\\;";
            } else if (cCharAt == '=') {
                i10 = i11 + 1;
                str2 = "\\=";
            } else if (cCharAt != '\\') {
                i11++;
            } else {
                i10 = i11 + 1;
                str2 = "\\\\";
            }
            stringBuffer.replace(i11, i10, str2);
            i11 = i10;
            i11++;
        }
        return stringBuffer.toString();
    }

    @Override // zp.a
    public String b(String str) {
        return a(str);
    }
}

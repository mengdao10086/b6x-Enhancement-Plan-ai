package lt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class e extends BufferedReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40452a = "-----BEGIN ";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f40453b = "-----END ";

    public e(Reader reader) {
        super(reader);
    }

    public final b a(String str) throws IOException {
        String line;
        String str2 = f40453b + str;
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (true) {
            line = readLine();
            if (line == null) {
                break;
            }
            int iIndexOf = line.indexOf(58);
            if (iIndexOf >= 0) {
                arrayList.add(new a(line.substring(0, iIndexOf), line.substring(iIndexOf + 1).trim()));
            } else {
                if (line.indexOf(str2) != -1) {
                    break;
                }
                stringBuffer.append(line.trim());
            }
        }
        if (line != null) {
            return new b(str, arrayList, jt.c.c(stringBuffer.toString()));
        }
        throw new IOException(str2 + " not found");
    }

    public b c() throws IOException {
        String line;
        String strSubstring;
        int iIndexOf;
        do {
            line = readLine();
            if (line == null) {
                break;
            }
        } while (!line.startsWith(f40452a));
        if (line == null || (iIndexOf = (strSubstring = line.substring(11)).indexOf(45)) <= 0 || !strSubstring.endsWith("-----") || strSubstring.length() - iIndexOf != 5) {
            return null;
        }
        return a(strSubstring.substring(0, iIndexOf));
    }
}

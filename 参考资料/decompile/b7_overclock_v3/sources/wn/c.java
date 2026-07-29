package wn;

import gm.c0;
import gm.s;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes5.dex */
public class c {
    public static void a(String[] strArr) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        s sVar = new s(fileInputStream);
        while (true) {
            c0 c0VarN = sVar.n();
            if (c0VarN == null) {
                fileInputStream.close();
                return;
            }
            System.out.println(a.c(c0VarN));
        }
    }
}

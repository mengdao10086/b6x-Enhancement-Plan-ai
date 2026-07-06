package a;

import android.content.Context;
import com.omarea.model.ProcessInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class om0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f7037a;

    public om0(Context context) {
        f92.d(context, "context");
        this.f7037a = new lm0();
    }

    public final ArrayList<ProcessInfo> a() {
        String string = new l30(km0.f6620a).toString();
        f92.c(string, "json{\n                \"m…\n            }.toString()");
        List listD0 = ec2.d0(e50.f677a.i1("top", string, 1000L), new String[]{"\n"}, false, 0, 6, null);
        ArrayList<ProcessInfo> arrayList = new ArrayList<>();
        Iterator it = listD0.iterator();
        while (it.hasNext()) {
            ProcessInfo processInfoD = d((String) it.next());
            if (processInfoD != null) {
                arrayList.add(processInfoD);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(int r23, a.b62<? super com.omarea.model.ProcessInfo> r24) {
        /*
            Method dump skipped, instruction units count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.om0.b(int, a.b62):java.lang.Object");
    }

    public final void c(int i) {
        e50.f677a.a0("kill -9 " + i, 3000L);
    }

    public final ProcessInfo d(String str) {
        List listD0 = ec2.d0(str, new String[]{"|"}, false, 0, 6, null);
        try {
            ProcessInfo processInfo = new ProcessInfo();
            processInfo.cpu = Float.parseFloat((String) listD0.get(0));
            processInfo.res = f((String) listD0.get(1));
            processInfo.shr = f((String) listD0.get(2));
            processInfo.swap = f((String) listD0.get(3));
            String str2 = (String) listD0.get(4);
            processInfo.name = str2;
            if (this.f7037a.contains(str2)) {
                return null;
            }
            processInfo.pid = Integer.parseInt((String) listD0.get(5));
            processInfo.user = (String) listD0.get(6);
            processInfo.state = (String) listD0.get(7);
            processInfo.command = (String) listD0.get(8);
            processInfo.cmdline = (String) listD0.get(9);
            return processInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void e(ProcessInfo processInfo) {
        f92.d(processInfo, "processInfo");
        String strSubstring = processInfo.name;
        f92.c(strSubstring, "name");
        if (ec2.C(strSubstring, ":", false, 2, null)) {
            strSubstring = strSubstring.substring(0, ec2.N(strSubstring, ":", 0, false, 6, null));
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        e50 e50Var = e50.f677a;
        q92 q92Var = q92.f7191a;
        String str = String.format("killall -9 %s;am force-stop %s;am kill %s", Arrays.copyOf(new Object[]{strSubstring, strSubstring, strSubstring}, 3));
        f92.c(str, "java.lang.String.format(format, *args)");
        e50Var.a0(str, 3000L);
        c(processInfo.pid);
    }

    public final long f(String str) {
        double d;
        double d2;
        double d3;
        if (str.length() == 0) {
            return 0L;
        }
        if (ec2.C(str, "K", false, 2, null)) {
            int iN = ec2.N(str, "K", 0, false, 6, null);
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str.substring(0, iN);
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            d3 = Double.parseDouble(strSubstring);
        } else {
            if (ec2.C(str, "M", false, 2, null)) {
                int iN2 = ec2.N(str, "M", 0, false, 6, null);
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring2 = str.substring(0, iN2);
                f92.c(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                d = Double.parseDouble(strSubstring2);
                d2 = 1024;
            } else {
                if (!ec2.C(str, "G", false, 2, null)) {
                    return Long.parseLong(str) / ((long) 1024);
                }
                int iN3 = ec2.N(str, "G", 0, false, 6, null);
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring3 = str.substring(0, iN3);
                f92.c(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                d = Double.parseDouble(strSubstring3);
                d2 = 1048576;
            }
            d3 = d * d2;
        }
        return (long) d3;
    }

    public final boolean g() {
        return true;
    }
}

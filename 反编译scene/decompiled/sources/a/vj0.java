package a;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vj0 {
    public final String a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(j));
        f92.c(str, "SimpleDateFormat(\"yyyy-MM-dd HH:mm\").format(time)");
        return str;
    }

    public final String b(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
        f92.c(str, "SimpleDateFormat(\"yyyy-M…d HH:mm:ss\").format(time)");
        return str;
    }

    public final String c(double d) {
        double d2 = 1440;
        String str = "";
        if (d >= d2) {
            int i = (int) ((d % d2) / ((double) 60));
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((int) (d / d2));
            sb.append("d");
            if (i > 0) {
                str = String.valueOf(i) + "h";
            }
            sb.append(str);
            return sb.toString();
        }
        double d3 = 60;
        if (d > d3) {
            int i2 = (int) (d % d3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append((int) (d / d3));
            sb2.append("h");
            if (i2 > 0) {
                str = String.valueOf(i2) + "m";
            }
            sb2.append(str);
            return sb2.toString();
        }
        if (d == 0.0d) {
            return "0";
        }
        double d4 = 1;
        if (d < d4) {
            return String.valueOf((int) (d * d3)) + "s";
        }
        int i3 = (int) ((d % d4) * d3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        sb3.append((int) d);
        sb3.append("m");
        if (i3 > 0) {
            str = String.valueOf(i3) + "s";
        }
        sb3.append(str);
        return sb3.toString();
    }

    public final String d(double d) {
        return String.valueOf(((double) ((int) (d / ((double) 6)))) / 10.0d) + "h";
    }
}

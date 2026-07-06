package a;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class il0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f6424a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f1380a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static HashMap<Integer, Double> f1381a;

    public il0() {
        f1380a = e();
    }

    public final long a(String[] strArr) {
        return Long.parseLong(strArr[4]) + Long.parseLong(strArr[5]);
    }

    public final long b(String[] strArr) {
        long j = 0;
        if (strArr.length == 11) {
            for (int i = 1; i < 8; i++) {
                j += Long.parseLong(strArr[i]);
            }
        }
        return j;
    }

    public final int c(String[] strArr) {
        if (strArr[0].equals("cpu")) {
            return -1;
        }
        return Integer.parseInt(strArr[0].substring(3));
    }

    public HashMap<Integer, Double> d() {
        String[] strArrSplit;
        Integer numValueOf;
        Double dValueOf;
        synchronized ("/proc/stat") {
            if (f1381a != null && System.currentTimeMillis() - f6424a.longValue() < 500) {
                return f1381a;
            }
            HashMap<Integer, Double> map = new HashMap<>();
            String strE = e();
            if (strE.equals("error") || !strE.startsWith("cpu")) {
                return map;
            }
            try {
                if (f1380a.isEmpty()) {
                    f1380a = strE;
                    Thread.sleep(100L);
                    return d();
                }
                String[] strArrSplit2 = strE.split("\n");
                String[] strArrSplit3 = f1380a.split("\n");
                for (String str : strArrSplit2) {
                    String[] strArrSplit4 = str.replaceAll(" {2}", " ").split(" ");
                    int length = strArrSplit3.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            strArrSplit = null;
                            break;
                        }
                        String str2 = strArrSplit3[i];
                        if (str2.startsWith(strArrSplit4[0] + " ")) {
                            strArrSplit = str2.replaceAll(" {2}", " ").split(" ");
                            break;
                        }
                        i++;
                    }
                    if (strArrSplit == null || strArrSplit.length == 0) {
                        numValueOf = Integer.valueOf(c(strArrSplit4));
                        dValueOf = Double.valueOf(0.0d);
                    } else {
                        long jB = b(strArrSplit4);
                        long jA = a(strArrSplit4);
                        long jB2 = b(strArrSplit);
                        long jA2 = a(strArrSplit);
                        long j = jB - jB2;
                        if (j == 0) {
                            numValueOf = Integer.valueOf(c(strArrSplit4));
                            dValueOf = Double.valueOf(0.0d);
                        } else {
                            long j2 = jA - jA2;
                            if (j2 < 1) {
                                numValueOf = Integer.valueOf(c(strArrSplit4));
                                dValueOf = Double.valueOf(100.0d);
                            } else {
                                numValueOf = Integer.valueOf(c(strArrSplit4));
                                dValueOf = Double.valueOf(((double) ((int) ((100.0d - ((j2 * 100.0d) / j)) * 1000.0d))) / 1000.0d);
                            }
                        }
                    }
                    map.put(numValueOf, dValueOf);
                }
                String str3 = f1380a;
                f1380a = "";
                f6424a = 0L;
                f1381a = null;
                Iterator<Double> it = map.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().doubleValue() > 0.0d) {
                        f1380a = strE;
                        f6424a = Long.valueOf(System.currentTimeMillis());
                        f1381a = map;
                        break;
                    }
                    Log.e("@Scene - prev", str3);
                    Log.e("@Scene - current", strE);
                }
                return map;
            } catch (Exception e) {
                f1380a = "";
                f6424a = 0L;
                f1381a = null;
                Log.e("@Scene", strE + "\n" + e.getMessage());
                return map;
            }
        }
    }

    public final String e() {
        String[] strArrSplit = x60.f7856a.d("/proc/stat").split("\n");
        StringBuilder sb = new StringBuilder();
        for (String str : strArrSplit) {
            if (str.startsWith("cpu")) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }
}

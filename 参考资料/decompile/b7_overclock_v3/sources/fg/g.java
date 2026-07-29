package fg;

import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class g {
    public static final String A = "-d102-11e1-9b23-00025b00a5a5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.collection.a<String, String> f28323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f28324b = "Alert Notification";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f28325c = "Battery";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f28326d = "Blood Pressure";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f28327e = "Current Time Service";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f28328f = "Cycling Power";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f28329g = "Cycling Speed and Cadence";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f28330h = "Device Information";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f28331i = "Environmental Sensing";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f28332j = "Generic Attribute";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f28333k = "Generic Access";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f28334l = "Glucose";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f28335m = "Health Thermometer";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f28336n = "Heart Rate";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f28337o = "Human Interface Device";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f28338p = "Immediate Alert";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f28339q = "Link Loss";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f28340r = "Location and Navigation";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f28341s = "Next DST Change Service";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f28342t = "Phone Alert Status Service";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f28343u = "Reference Time Update Service";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f28344v = "Running Speed and Cadence";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f28345w = "Scan Parameters";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f28346x = "Tx Power";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f28347y = "CSR GAIA";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f28348z = "-0000-1000-8000-00805f9b34fb";

    static {
        androidx.collection.a<String, String> aVar = new androidx.collection.a<>();
        f28323a = aVar;
        aVar.put("00001811-0000-1000-8000-00805f9b34fb", f28324b);
        aVar.put("0000180f-0000-1000-8000-00805f9b34fb", f28325c);
        aVar.put("00001810-0000-1000-8000-00805f9b34fb", f28326d);
        aVar.put("00001805-0000-1000-8000-00805f9b34fb", f28327e);
        aVar.put("00001818-0000-1000-8000-00805f9b34fb", f28328f);
        aVar.put("00001816-0000-1000-8000-00805f9b34fb", f28329g);
        aVar.put("0000180a-0000-1000-8000-00805f9b34fb", f28330h);
        aVar.put("0000181a-0000-1000-8000-00805f9b34fb", f28331i);
        aVar.put("00001800-0000-1000-8000-00805f9b34fb", f28333k);
        aVar.put("00001801-0000-1000-8000-00805f9b34fb", f28332j);
        aVar.put("00001808-0000-1000-8000-00805f9b34fb", f28334l);
        aVar.put("00001809-0000-1000-8000-00805f9b34fb", f28335m);
        aVar.put("0000180d-0000-1000-8000-00805f9b34fb", f28336n);
        aVar.put("00001812-0000-1000-8000-00805f9b34fb", f28337o);
        aVar.put("00001802-0000-1000-8000-00805f9b34fb", f28338p);
        aVar.put("00001803-0000-1000-8000-00805f9b34fb", f28339q);
        aVar.put("00001819-0000-1000-8000-00805f9b34fb", f28340r);
        aVar.put("00001807-0000-1000-8000-00805f9b34fb", f28341s);
        aVar.put("0000180e-0000-1000-8000-00805f9b34fb", f28342t);
        aVar.put("00001806-0000-1000-8000-00805f9b34fb", f28343u);
        aVar.put("00001814-0000-1000-8000-00805f9b34fb", f28344v);
        aVar.put("00001813-0000-1000-8000-00805f9b34fb", f28345w);
        aVar.put("00001804-0000-1000-8000-00805f9b34fb", f28346x);
        aVar.put("00001100-d102-11e1-9b23-00025b00a5a5", f28347y);
    }

    public static String a(String str) {
        String str2 = f28323a.get(str);
        return str2 == null ? "Unknown Service" : str2;
    }

    public static UUID b(String str) {
        if (!f28323a.containsValue(str)) {
            return null;
        }
        int i10 = 0;
        while (true) {
            androidx.collection.a<String, String> aVar = f28323a;
            if (i10 >= aVar.size()) {
                return null;
            }
            if (aVar.o(i10).equals(str)) {
                return UUID.fromString(aVar.k(i10));
            }
            i10++;
        }
    }

    public static boolean c(String str) {
        return f28323a.containsKey(str);
    }
}

package a3;

import fg.g;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f164a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f164a = map;
        map.put("00001811-0000-1000-8000-00805f9b34fb", "Alert Notification Service");
        map.put("0000180f-0000-1000-8000-00805f9b34fb", "Battery Service");
        map.put("00001810-0000-1000-8000-00805f9b34fb", g.f28326d);
        map.put("00001805-0000-1000-8000-00805f9b34fb", g.f28327e);
        map.put("00001818-0000-1000-8000-00805f9b34fb", g.f28328f);
        map.put("00001816-0000-1000-8000-00805f9b34fb", g.f28329g);
        map.put("0000180a-0000-1000-8000-00805f9b34fb", g.f28330h);
        map.put("00001800-0000-1000-8000-00805f9b34fb", g.f28333k);
        map.put("00001801-0000-1000-8000-00805f9b34fb", g.f28332j);
        map.put("00001808-0000-1000-8000-00805f9b34fb", g.f28334l);
        map.put("00001809-0000-1000-8000-00805f9b34fb", g.f28335m);
        map.put("0000180d-0000-1000-8000-00805f9b34fb", g.f28336n);
        map.put("00001812-0000-1000-8000-00805f9b34fb", g.f28337o);
        map.put("00001802-0000-1000-8000-00805f9b34fb", g.f28338p);
        map.put("00001803-0000-1000-8000-00805f9b34fb", g.f28339q);
        map.put("00001819-0000-1000-8000-00805f9b34fb", g.f28340r);
        map.put("00001807-0000-1000-8000-00805f9b34fb", g.f28341s);
        map.put("0000180e-0000-1000-8000-00805f9b34fb", g.f28342t);
        map.put("00001806-0000-1000-8000-00805f9b34fb", g.f28343u);
        map.put("00001814-0000-1000-8000-00805f9b34fb", g.f28344v);
        map.put("00001813-0000-1000-8000-00805f9b34fb", g.f28345w);
        map.put("00001804-0000-1000-8000-00805f9b34fb", g.f28346x);
    }

    public static String a(String str) {
        String str2 = f164a.get(str.toLowerCase());
        return str2 == null ? "Unknown Service" : str2;
    }
}

package a3;

import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f163b;

    static {
        HashMap<String, String> map = new HashMap<>();
        f163b = map;
        map.put("00002900-0000-1000-8000-00805f9b34fb", "Characteristic Extended Properties");
        map.put("00002901-0000-1000-8000-00805f9b34fb", "Characteristic User Description");
        map.put("00002902-0000-1000-8000-00805f9b34fb", "Client Characteristic Configuration");
        map.put("00002903-0000-1000-8000-00805f9b34fb", "Server Characteristic Configuration");
        map.put("00002904-0000-1000-8000-00805f9b34fb", "Characteristic Presentation Format");
        map.put("00002905-0000-1000-8000-00805f9b34fb", "Characteristic Aggregate Format");
        map.put("00002906-0000-1000-8000-00805f9b34fb", "Valid Range");
        map.put("00002907-0000-1000-8000-00805f9b34fb", "External Report Reference");
        map.put("00002908-0000-1000-8000-00805f9b34fb", "Report Reference");
        map.put("00002909-0000-1000-8000-00805f9b34fb", "Number of Digitals");
        map.put("0000290a-0000-1000-8000-00805f9b34fb", "Value Trigger Setting");
        map.put("0000290b-0000-1000-8000-00805f9b34fb", "Environmental Sensing Configuration");
        map.put("0000290c-0000-1000-8000-00805f9b34fb", "Environmental Sensing Measurement");
        map.put("0000290d-0000-1000-8000-00805f9b34fb", "Environmental Sensing Trigger Setting");
        map.put("0000290e-0000-1000-8000-00805f9b34fb", "Time Trigger Setting");
    }

    public static String a(UUID uuid) {
        HashMap<String, String> map = f163b;
        return !map.containsKey(uuid.toString().toLowerCase()) ? "Unknown Descriptor" : map.get(uuid.toString().toLowerCase());
    }
}

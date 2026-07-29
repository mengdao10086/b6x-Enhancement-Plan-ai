package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.blankj.utilcode.util.j1;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f11486a = 3000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<j1.b<l>> f11487b = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Timer f11488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static l f11489d;

    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    public static class a extends j1.f<Boolean> {
        public a(j1.b bVar) {
            super(bVar);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @g.y0("android.permission.INTERNET")
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean e() {
            return Boolean.valueOf(NetworkUtils.A());
        }
    }

    public static class b extends j1.f<Boolean> {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f11490p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j1.b bVar, String str) {
            super(bVar);
            this.f11490p = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @g.y0("android.permission.INTERNET")
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean e() {
            return Boolean.valueOf(NetworkUtils.H(this.f11490p));
        }
    }

    public static class c extends j1.f<Boolean> {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f11491p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j1.b bVar, String str) {
            super(bVar);
            this.f11491p = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @g.y0("android.permission.INTERNET")
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean e() {
            return Boolean.valueOf(NetworkUtils.D(this.f11491p));
        }
    }

    public static class d extends j1.f<Boolean> {
        public d(j1.b bVar) {
            super(bVar);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET"})
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean e() {
            return Boolean.valueOf(NetworkUtils.Q());
        }
    }

    public static class e extends j1.f<String> {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ boolean f11492p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(j1.b bVar, boolean z10) {
            super(bVar);
            this.f11492p = z10;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @g.y0("android.permission.INTERNET")
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public String e() {
            return NetworkUtils.n(this.f11492p);
        }
    }

    public static class f extends j1.f<String> {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f11493p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(j1.b bVar, String str) {
            super(bVar);
            this.f11493p = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @g.y0("android.permission.INTERNET")
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public String e() {
            return NetworkUtils.k(this.f11493p);
        }
    }

    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j1.b f11494a;

        public g(j1.b bVar) {
            this.f11494a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkUtils.f11487b.isEmpty()) {
                NetworkUtils.f11487b.add(this.f11494a);
                NetworkUtils.X();
            } else {
                this.f11494a.accept(NetworkUtils.f11489d);
                NetworkUtils.f11487b.add(this.f11494a);
            }
        }
    }

    public static class h extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = NetworkUtils.f11487b.iterator();
                while (it2.hasNext()) {
                    ((j1.b) it2.next()).accept(NetworkUtils.f11489d);
                }
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
        public void run() {
            NetworkUtils.Y();
            l lVarX = NetworkUtils.x();
            if (NetworkUtils.P(NetworkUtils.f11489d.f11505a, lVarX.f11505a)) {
                return;
            }
            l unused = NetworkUtils.f11489d = lVarX;
            l1.U0(new a());
        }
    }

    public static class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j1.b f11496a;

        public i(j1.b bVar) {
            this.f11496a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkUtils.f11487b.remove(this.f11496a);
            if (NetworkUtils.f11487b.isEmpty()) {
                NetworkUtils.Z();
            }
        }
    }

    public static final class j extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkType f11497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Set<k> f11498b = new HashSet();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f11499a;

            public a(k kVar) {
                this.f11499a = kVar;
            }

            @Override // java.lang.Runnable
            @g.y0(p4.f.f46367b)
            public void run() {
                int size = j.this.f11498b.size();
                j.this.f11498b.add(this.f11499a);
                if (size == 0 && j.this.f11498b.size() == 1) {
                    j.this.f11497a = NetworkUtils.t();
                    j1.a().registerReceiver(j.e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f11501a;

            public b(k kVar) {
                this.f11501a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = j.this.f11498b.size();
                j.this.f11498b.remove(this.f11501a);
                if (size == 1 && j.this.f11498b.size() == 0) {
                    j1.a().unregisterReceiver(j.e());
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            @g.y0(p4.f.f46367b)
            public void run() {
                NetworkType networkTypeT = NetworkUtils.t();
                if (j.this.f11497a == networkTypeT) {
                    return;
                }
                j.this.f11497a = networkTypeT;
                if (networkTypeT == NetworkType.NETWORK_NO) {
                    Iterator it2 = j.this.f11498b.iterator();
                    while (it2.hasNext()) {
                        ((k) it2.next()).a();
                    }
                } else {
                    Iterator it3 = j.this.f11498b.iterator();
                    while (it3.hasNext()) {
                        ((k) it3.next()).b(networkTypeT);
                    }
                }
            }
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final j f11504a = new j();
        }

        public static j e() {
            return d.f11504a;
        }

        public boolean f(k kVar) {
            if (kVar == null) {
                return false;
            }
            return this.f11498b.contains(kVar);
        }

        @g.y0(p4.f.f46367b)
        public void g(k kVar) {
            if (kVar == null) {
                return;
            }
            l1.U0(new a(kVar));
        }

        public void h(k kVar) {
            if (kVar == null) {
                return;
            }
            l1.U0(new b(kVar));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                l1.V0(new c(), 1000L);
            }
        }
    }

    public interface k {
        void a();

        void b(NetworkType networkType);
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ScanResult> f11505a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<ScanResult> f11506b = new ArrayList();

        public static List<ScanResult> b(List<ScanResult> list) {
            ScanResult scanResult;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (ScanResult scanResult2 : list) {
                if (!TextUtils.isEmpty(scanResult2.SSID) && ((scanResult = (ScanResult) linkedHashMap.get(scanResult2.SSID)) == null || scanResult.level < scanResult2.level)) {
                    linkedHashMap.put(scanResult2.SSID, scanResult2);
                }
            }
            return new ArrayList(linkedHashMap.values());
        }

        public List<ScanResult> c() {
            return this.f11505a;
        }

        public List<ScanResult> d() {
            return this.f11506b;
        }

        public void e(List<ScanResult> list) {
            this.f11505a = list;
            this.f11506b = b(list);
        }
    }

    public NetworkUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @g.y0("android.permission.INTERNET")
    public static boolean A() {
        return C() || H(null);
    }

    @g.y0("android.permission.INTERNET")
    public static j1.f<Boolean> B(@g.n0 j1.b<Boolean> bVar) {
        Objects.requireNonNull(bVar, "Argument 'consumer' of type Utils.Consumer<Boolean> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return l1.v(new a(bVar));
    }

    @g.y0("android.permission.INTERNET")
    public static boolean C() {
        return D("");
    }

    @g.y0("android.permission.INTERNET")
    public static boolean D(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "www.baidu.com";
        }
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @g.y0("android.permission.INTERNET")
    public static j1.f E(String str, @g.n0 j1.b<Boolean> bVar) {
        Objects.requireNonNull(bVar, "Argument 'consumer' of type Utils.Consumer<Boolean> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return l1.v(new c(bVar, str));
    }

    @g.y0("android.permission.INTERNET")
    public static void F(j1.b<Boolean> bVar) {
        E("", bVar);
    }

    @g.y0("android.permission.INTERNET")
    public static boolean G() {
        return H("");
    }

    @g.y0("android.permission.INTERNET")
    public static boolean H(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "223.5.5.5";
        }
        return a1.a(String.format("ping -c 1 %s", str), false).f11696a == 0;
    }

    @g.y0("android.permission.INTERNET")
    public static j1.f<Boolean> I(String str, @g.n0 j1.b<Boolean> bVar) {
        Objects.requireNonNull(bVar, "Argument 'consumer' of type Utils.Consumer<Boolean> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return l1.v(new b(bVar, str));
    }

    @g.y0("android.permission.INTERNET")
    public static void J(j1.b<Boolean> bVar) {
        I("", bVar);
    }

    @g.y0(p4.f.f46367b)
    public static boolean K() {
        NetworkInfo networkInfoI = i();
        return networkInfoI != null && networkInfoI.isConnected();
    }

    @g.y0(p4.f.f46367b)
    public static boolean L() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) j1.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    @g.y0(p4.f.f46367b)
    public static boolean M() {
        NetworkInfo networkInfoI = i();
        return networkInfoI != null && networkInfoI.isAvailable() && networkInfoI.getType() == 0;
    }

    public static boolean N(k kVar) {
        return j.e().f(kVar);
    }

    public static boolean O(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult != null && scanResult2 != null && l1.A(scanResult.BSSID, scanResult2.BSSID) && l1.A(scanResult.SSID, scanResult2.SSID) && l1.A(scanResult.capabilities, scanResult2.capabilities) && scanResult.level == scanResult2.level;
    }

    public static boolean P(List<ScanResult> list, List<ScanResult> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!O(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET"})
    public static boolean Q() {
        return w() && A();
    }

    @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET"})
    public static j1.f<Boolean> R(@g.n0 j1.b<Boolean> bVar) {
        Objects.requireNonNull(bVar, "Argument 'consumer' of type Utils.Consumer<Boolean> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return l1.v(new d(bVar));
    }

    @g.y0(p4.f.f46367b)
    public static boolean S() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) j1.a().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }

    public static void T() {
        j1.a().startActivity(new Intent("android.settings.WIRELESS_SETTINGS").setFlags(268435456));
    }

    @g.y0(p4.f.f46367b)
    public static void U(k kVar) {
        j.e().g(kVar);
    }

    public static void V(j1.b<l> bVar) {
        if (bVar == null) {
            return;
        }
        l1.U0(new i(bVar));
    }

    @g.y0("android.permission.CHANGE_WIFI_STATE")
    public static void W(boolean z10) {
        WifiManager wifiManager = (WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        if (wifiManager == null || z10 == wifiManager.isWifiEnabled()) {
            return;
        }
        wifiManager.setWifiEnabled(z10);
    }

    public static void X() {
        f11489d = new l();
        Timer timer = new Timer();
        f11488c = timer;
        timer.schedule(new h(), 0L, 3000L);
    }

    @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"})
    public static void Y() {
        if (w()) {
            ((WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).startScan();
        }
    }

    public static void Z() {
        Timer timer = f11488c;
        if (timer != null) {
            timer.cancel();
            f11488c = null;
        }
    }

    public static void a0(k kVar) {
        j.e().h(kVar);
    }

    @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
    public static void h(j1.b<l> bVar) {
        if (bVar == null) {
            return;
        }
        l1.U0(new g(bVar));
    }

    @g.y0(p4.f.f46367b)
    public static NetworkInfo i() {
        ConnectivityManager connectivityManager = (ConnectivityManager) j1.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static String j() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            new LinkedList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    List<InterfaceAddress> interfaceAddresses = networkInterfaceNextElement.getInterfaceAddresses();
                    int size = interfaceAddresses.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        InetAddress broadcast = interfaceAddresses.get(i10).getBroadcast();
                        if (broadcast != null) {
                            return broadcast.getHostAddress();
                        }
                    }
                }
            }
            return "";
        } catch (SocketException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @g.y0("android.permission.INTERNET")
    public static String k(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @g.y0("android.permission.INTERNET")
    public static j1.f<String> l(String str, @g.n0 j1.b<String> bVar) {
        Objects.requireNonNull(bVar, "Argument 'consumer' of type Utils.Consumer<String> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return l1.v(new f(bVar, str));
    }

    @g.y0("android.permission.ACCESS_WIFI_STATE")
    public static String m() {
        WifiManager wifiManager = (WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().gateway);
    }

    @g.y0("android.permission.INTERNET")
    public static String n(boolean z10) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            LinkedList<InetAddress> linkedList = new LinkedList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        linkedList.addFirst(inetAddresses.nextElement());
                    }
                }
            }
            for (InetAddress inetAddress : linkedList) {
                if (!inetAddress.isLoopbackAddress()) {
                    String hostAddress = inetAddress.getHostAddress();
                    boolean z11 = hostAddress.indexOf(58) < 0;
                    if (z10) {
                        if (z11) {
                            return hostAddress;
                        }
                    } else if (!z11) {
                        int iIndexOf = hostAddress.indexOf(37);
                        return iIndexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, iIndexOf).toUpperCase();
                    }
                }
            }
            return "";
        } catch (SocketException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static j1.f<String> o(boolean z10, @g.n0 j1.b<String> bVar) {
        Objects.requireNonNull(bVar, "Argument 'consumer' of type Utils.Consumer<String> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return l1.v(new e(bVar, z10));
    }

    @g.y0("android.permission.ACCESS_WIFI_STATE")
    public static String p() {
        WifiManager wifiManager = (WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().ipAddress);
    }

    public static boolean q() {
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) j1.a().getSystemService("phone");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (telephonyManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return telephonyManager.isDataEnabled();
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);
        if (declaredMethod != null) {
            return ((Boolean) declaredMethod.invoke(telephonyManager, new Object[0])).booleanValue();
        }
        return false;
    }

    @g.y0("android.permission.ACCESS_WIFI_STATE")
    public static String r() {
        WifiManager wifiManager = (WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().netmask);
    }

    public static String s() {
        TelephonyManager telephonyManager = (TelephonyManager) j1.a().getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getNetworkOperatorName();
    }

    @g.y0(p4.f.f46367b)
    public static NetworkType t() {
        if (L()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo networkInfoI = i();
        if (networkInfoI == null || !networkInfoI.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (networkInfoI.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (networkInfoI.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (networkInfoI.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case 19:
            default:
                String subtypeName = networkInfoI.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? NetworkType.NETWORK_3G : NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    @g.y0("android.permission.ACCESS_WIFI_STATE")
    public static String u() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) j1.a().getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String ssid = connectionInfo.getSSID();
        return TextUtils.isEmpty(ssid) ? "" : (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') ? ssid.substring(1, ssid.length() - 1) : ssid;
    }

    @g.y0("android.permission.ACCESS_WIFI_STATE")
    public static String v() {
        WifiManager wifiManager = (WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().serverAddress);
    }

    @g.y0("android.permission.ACCESS_WIFI_STATE")
    public static boolean w() {
        WifiManager wifiManager = (WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
    public static l x() {
        List<ScanResult> scanResults;
        l lVar = new l();
        if (w() && (scanResults = ((WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getScanResults()) != null) {
            lVar.e(scanResults);
        }
        return lVar;
    }

    @g.y0(p4.f.f46367b)
    public static boolean y() {
        NetworkInfo networkInfoI = i();
        return networkInfoI != null && networkInfoI.isAvailable() && networkInfoI.getSubtype() == 13;
    }

    @g.y0(p4.f.f46367b)
    public static boolean z() {
        NetworkInfo networkInfoI = i();
        return networkInfoI != null && networkInfoI.isAvailable() && networkInfoI.getSubtype() == 20;
    }
}

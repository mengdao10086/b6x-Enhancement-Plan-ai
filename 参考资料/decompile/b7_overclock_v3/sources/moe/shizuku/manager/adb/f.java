package moe.shizuku.manager.adb;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import androidx.lifecycle.j0;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.sequences.SequencesKt__SequencesKt;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nAdbMdns.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbMdns.kt\nmoe/shizuku/manager/adb/AdbMdns\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,130:1\n1229#2:131\n1229#2,2:132\n1230#2:134\n*S KotlinDebug\n*F\n+ 1 AdbMdns.kt\nmoe/shizuku/manager/adb/AdbMdns\n*L\n60#1:131\n63#1:132,2\n60#1:134\n*E\n"})
public final class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final a f41501h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public static final String f41502i = "_adb-tls-connect._tcp";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public static final String f41503j = "_adb-tls-pairing._tcp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final String f41504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final j0<Integer> f41505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public String f41508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final b f41509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final NsdManager f41510g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static final class b implements NsdManager.DiscoveryListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final f f41511a;

        public b(@k f adbMdns) {
            f0.p(adbMdns, "adbMdns");
            this.f41511a = adbMdns;
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onDiscoveryStarted(@k String str) {
            f0.p(str, "str");
            this.f41511a.g();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onDiscoveryStarted:");
            sb2.append(str);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onDiscoveryStopped(@k String str) {
            f0.p(str, "str");
            this.f41511a.h();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onDiscoveryStopped:");
            sb2.append(str);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onServiceFound(@k NsdServiceInfo nsdServiceInfo) {
            f0.p(nsdServiceInfo, "nsdServiceInfo");
            this.f41511a.i(nsdServiceInfo);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceFound:");
            sb2.append(nsdServiceInfo);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onServiceLost(@k NsdServiceInfo nsdServiceInfo) {
            f0.p(nsdServiceInfo, "nsdServiceInfo");
            this.f41511a.j(nsdServiceInfo);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceLost:");
            sb2.append(nsdServiceInfo);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onStartDiscoveryFailed(@k String str, int i10) {
            f0.p(str, "str");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onStartDiscoveryFailed ");
            sb2.append(str);
            sb2.append(" error code:");
            sb2.append(i10);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onStopDiscoveryFailed(@k String str, int i10) {
            f0.p(str, "str");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onStopDiscoveryFailed:");
            sb2.append(str);
            sb2.append(" error code:");
            sb2.append(i10);
        }
    }

    public static final class c implements NsdManager.ResolveListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final f f41512a;

        public c(@k f adbMdns) {
            f0.p(adbMdns, "adbMdns");
            this.f41512a = adbMdns;
        }

        @Override // android.net.nsd.NsdManager.ResolveListener
        public void onResolveFailed(@k NsdServiceInfo nsdServiceInfo, int i10) {
            f0.p(nsdServiceInfo, "nsdServiceInfo");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onResolveFailed ");
            sb2.append(nsdServiceInfo);
        }

        @Override // android.net.nsd.NsdManager.ResolveListener
        public void onServiceResolved(@k NsdServiceInfo nsdServiceInfo) throws SocketException {
            f0.p(nsdServiceInfo, "nsdServiceInfo");
            this.f41512a.k(nsdServiceInfo);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceResolved:");
            sb2.append(nsdServiceInfo);
        }
    }

    public f(@k Context context, @k String serviceType, @k j0<Integer> port) {
        f0.p(context, "context");
        f0.p(serviceType, "serviceType");
        f0.p(port, "port");
        this.f41504a = serviceType;
        this.f41505b = port;
        this.f41509f = new b(this);
        Object systemService = context.getSystemService((Class<Object>) NsdManager.class);
        f0.o(systemService, "context.getSystemService(NsdManager::class.java)");
        this.f41510g = (NsdManager) systemService;
    }

    public final boolean f(int i10) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            try {
                serverSocket.bind(new InetSocketAddress(InetAddress.getLoopbackAddress(), i10), 1);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isPortAvailable ");
                sb2.append(i10);
                sb2.append(" false");
                kotlin.io.b.a(serverSocket, null);
                return false;
            } finally {
            }
        } catch (IOException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("isPortAvailable ");
            sb3.append(i10);
            sb3.append(zc.f.f58383m);
            sb3.append(e10.getMessage());
            sb3.append(" true");
            return true;
        }
    }

    public final void g() {
        this.f41506c = true;
    }

    public final void h() {
        this.f41506c = false;
    }

    public final void i(NsdServiceInfo nsdServiceInfo) {
        this.f41510g.resolveService(nsdServiceInfo, new c(this));
    }

    public final void j(NsdServiceInfo nsdServiceInfo) {
        if (f0.g(nsdServiceInfo.getServiceName(), this.f41508e)) {
            this.f41505b.o(-1);
        }
    }

    public final void k(NsdServiceInfo nsdServiceInfo) throws SocketException {
        boolean z10;
        if (this.f41507d) {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            f0.o(networkInterfaces, "getNetworkInterfaces()");
            Iterator it2 = SequencesKt__SequencesKt.e(kotlin.collections.u.c0(networkInterfaces)).iterator();
            while (true) {
                z10 = true;
                boolean z11 = false;
                if (!it2.hasNext()) {
                    z10 = false;
                    break;
                }
                Enumeration<InetAddress> inetAddresses = ((NetworkInterface) it2.next()).getInetAddresses();
                f0.o(inetAddresses, "networkInterface.inetAddresses");
                Iterator it3 = SequencesKt__SequencesKt.e(kotlin.collections.u.c0(inetAddresses)).iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (f0.g(nsdServiceInfo.getHost().getHostAddress(), ((InetAddress) it3.next()).getHostAddress())) {
                        z11 = true;
                        break;
                    }
                }
                if (z11) {
                    break;
                }
            }
            if (z10 && f(nsdServiceInfo.getPort())) {
                this.f41508e = nsdServiceInfo.getServiceName();
                this.f41505b.o(Integer.valueOf(nsdServiceInfo.getPort()));
            }
        }
    }

    public final void l() {
        this.f41507d = true;
        if (this.f41506c) {
            return;
        }
        this.f41510g.discoverServices(this.f41504a, 1, this.f41509f);
    }

    public final void m() {
        this.f41507d = false;
        if (this.f41506c) {
            this.f41510g.stopServiceDiscovery(this.f41509f);
        }
    }
}

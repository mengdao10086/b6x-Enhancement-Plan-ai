package a;

import a.p80;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ei1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6008a;

    public ei1(Context context) {
        f92.d(context, "context");
        this.f6008a = context;
    }

    public final InputStream a(String str) {
        f92.d(str, "str");
        byte[] bytes = str.getBytes(bb2.f5692a);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    public final void b() {
        Context context;
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            String strI = y60.f7952a.i(i2 >= 30 ? "/data/misc/apexdata/com.android.wifi/WifiConfigStore.xml" : "/data/misc/wifi/WifiConfigStore.xml");
            if (strI.length() > 0) {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(a(strI)).getElementsByTagName("WifiConfiguration");
                StringBuilder sb = new StringBuilder();
                f92.c(elementsByTagName, "networkList");
                int length = elementsByTagName.getLength();
                for (int i3 = 0; i3 < length; i3++) {
                    Node nodeItem = elementsByTagName.item(i3);
                    f92.c(nodeItem, "networkList.item(i)");
                    NodeList childNodes = nodeItem.getChildNodes();
                    f92.c(childNodes, "wifi");
                    int length2 = childNodes.getLength();
                    for (int i4 = 0; i4 < length2; i4++) {
                        if (childNodes.item(i4).hasChildNodes()) {
                            Node nodeItem2 = childNodes.item(i4);
                            f92.c(nodeItem2, "wifi.item(j)");
                            Node namedItem = nodeItem2.getAttributes().getNamedItem("name");
                            if (namedItem != null) {
                                if (f92.a(namedItem.getNodeValue(), "SSID")) {
                                    context = this.f6008a;
                                    i = u61.dialog_addin_wlan_ssid;
                                } else if (f92.a(namedItem.getNodeValue(), "PreSharedKey")) {
                                    context = this.f6008a;
                                    i = u61.dialog_addin_wlan_pwd;
                                }
                                sb.append(context.getString(i));
                                Node nodeItem3 = childNodes.item(i4);
                                f92.c(nodeItem3, "wifi.item(j)");
                                sb.append(nodeItem3.getTextContent());
                                sb.append("\n");
                            }
                        }
                    }
                    sb.append("\n\n");
                }
                p80.a aVar = p80.f2403a;
                Context context2 = this.f6008a;
                String string = context2.getString(u61.dialog_addin_wlan_log);
                f92.c(string, "context.getString(R.string.dialog_addin_wlan_log)");
                String string2 = sb.toString();
                f92.c(string2, "stringBuild.toString()");
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                p80.a.B(aVar, context2, string, ec2.r0(string2).toString(), null, 8, null);
                return;
            }
        }
        c();
    }

    public final void c() {
        String strI = y60.f7952a.i("/data/misc/wifi/wpa_supplicant.conf");
        if (!(strI.length() > 0)) {
            Context context = this.f6008a;
            Toast.makeText(context, context.getString(u61.dialog_addin_wlan_none), 1).show();
            return;
        }
        List<String> listD0 = ec2.d0(strI, new String[]{"\n\n"}, false, 0, 6, null);
        StringBuilder sb = new StringBuilder();
        for (String str : listD0) {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            if (bc2.x(ec2.r0(str).toString(), "network=", false, 2, null)) {
                sb.append(str);
            }
        }
        String string = sb.toString();
        f92.c(string, "sb.toString()");
        String strG = new nb2("[\\s\\t]{0,}bssid=.*").g(new nb2("[\\s\\t]{0,}network=\\{").g(string, "\n"), "");
        String strG2 = new nb2("[\\s\\t]{0,}ssid=").g(strG, "\n" + this.f6008a.getString(u61.dialog_addin_wlan_ssid));
        String strT = bc2.t(bc2.t(new nb2("[\\s\\t]{0,}disabled=.*").g(new nb2("[\\s\\t]{0,}key_mgmt=.*").g(new nb2("[\\s\\t]{0,}priority=.*").g(new nb2("[\\s\\t]{0,}priority=.*").g(new nb2("[\\s\\t]{0,}psk=").g(strG2, "\n" + this.f6008a.getString(u61.dialog_addin_wlan_pwd)), ""), ""), ""), ""), "}", "", false, 4, null), "\"", "", false, 4, null);
        if (strT == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string2 = ec2.r0(strT).toString();
        xb2.f(sb);
        for (String str2 : ec2.d0(string2, new String[]{"\n"}, false, 0, 6, null)) {
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            if (bc2.x(ec2.r0(str2).toString(), "id_str=", false, 2, null)) {
                int iN = ec2.N(str2, "=", 0, false, 6, null);
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = str2.substring(iN);
                f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                try {
                    g30 g30Var = new g30(URLDecoder.decode(strSubstring, "UTF-8"));
                    if (g30Var.j("configKey")) {
                        sb.append("IDStr:");
                        sb.append(g30Var.i("configKey"));
                        sb.append("\n");
                    }
                } catch (Exception unused) {
                }
            } else {
                sb.append(str2);
                sb.append("\n");
            }
        }
        p80.a aVar = p80.f2403a;
        Context context2 = this.f6008a;
        String string3 = context2.getString(u61.dialog_addin_wlan_log);
        f92.c(string3, "context.getString(R.string.dialog_addin_wlan_log)");
        String string4 = sb.toString();
        f92.c(string4, "sb.toString()");
        p80.a.B(aVar, context2, string3, string4, null, 8, null);
    }
}

package a;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yi0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dy0 f7986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3718a;

    public yi0(Context context) {
        f92.d(context, "context");
        this.f3718a = context;
        this.f7986a = new dy0(this.f3718a);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final cy0 c(String str) {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            f92.c(uRLConnectionOpenConnection, "connection");
            uRLConnectionOpenConnection.setConnectTimeout(1000);
            uRLConnectionOpenConnection.setConnectTimeout(5000);
            uRLConnectionOpenConnection.connect();
            InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
            f92.c(inputStream, "connection.getInputStream()");
            List listD0 = ec2.d0(new String(j72.c(inputStream), bb2.f5692a), new String[]{"\n"}, false, 0, 6, null);
            cy0 cy0Var = new cy0();
            Iterator it = listD0.iterator();
            while (true) {
                if (it.hasNext()) {
                    String str2 = (String) it.next();
                    int iN = ec2.N(str2, "=", 0, false, 6, null);
                    if (iN > 0) {
                        if (str2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String strSubstring = str2.substring(0, iN);
                        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        int i = iN + 1;
                        if (str2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String strSubstring2 = str2.substring(i);
                        f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                        if (strSubstring2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        String string = ec2.r0(strSubstring2).toString();
                        switch (strSubstring.hashCode()) {
                            case -1854767153:
                                if (!strSubstring.equals("support")) {
                                    continue;
                                } else {
                                    cy0Var.setSupport(string);
                                }
                                break;
                            case -1724546052:
                                if (!strSubstring.equals("description")) {
                                    continue;
                                } else {
                                    cy0Var.setDescription(string);
                                }
                                break;
                            case -1406328437:
                                if (!strSubstring.equals("author")) {
                                    continue;
                                } else {
                                    cy0Var.setAuthor(string);
                                }
                                break;
                            case -1326167441:
                                if (!strSubstring.equals("donate")) {
                                    continue;
                                } else {
                                    cy0Var.setDonate(string);
                                }
                                break;
                            case -1321546630:
                                if (!strSubstring.equals("template")) {
                                    continue;
                                } else {
                                    cy0Var.setTemplate(string);
                                }
                                break;
                            case 3355:
                                if (!strSubstring.equals("id")) {
                                    continue;
                                } else {
                                    cy0Var.setId(string);
                                }
                                break;
                            case 3373707:
                                if (!strSubstring.equals("name")) {
                                    continue;
                                } else {
                                    cy0Var.setName(string);
                                }
                                break;
                            case 351608024:
                                if (!strSubstring.equals("version")) {
                                }
                                break;
                            case 688591589:
                                if (!strSubstring.equals("versionCode")) {
                                    continue;
                                } else {
                                    cy0Var.setVersionCode(string);
                                }
                                break;
                            case 688906115:
                                if (!strSubstring.equals("versionName")) {
                                }
                                break;
                            default:
                                continue;
                        }
                        cy0Var.setVersionName(string);
                    }
                } else if (cy0Var.getId().length() > 0) {
                    return cy0Var;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final Object d(b62<? super m42> b62Var) throws e30, IOException {
        URLConnection uRLConnectionOpenConnection = new URL("https://magisk-modules-repo.github.io/submission/modules.json").openConnection();
        uRLConnectionOpenConnection.connect();
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        f92.c(inputStream, "connection.getInputStream()");
        d30 d30VarF = new g30(new String(j72.c(inputStream), bb2.f5692a)).f("modules");
        int iG = d30VarF.g();
        this.f7986a.a();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iG; i++) {
            g30 g30VarD = d30VarF.d(i);
            by0 by0Var = new by0();
            String strI = g30VarD.i("id");
            f92.c(strI, "item.getString(\"id\")");
            by0Var.setId(strI);
            by0Var.setLastUpdate(g30VarD.h("last_update"));
            String strI2 = g30VarD.i("prop_url");
            f92.c(strI2, "item.getString(\"prop_url\")");
            by0Var.setPropUrl(strI2);
            String strI3 = g30VarD.i("zip_url");
            f92.c(strI3, "item.getString(\"zip_url\")");
            by0Var.setZipUrl(strI3);
            String strI4 = g30VarD.i("notes_url");
            f92.c(strI4, "item.getString(\"notes_url\")");
            by0Var.setNotesUrl(strI4);
            arrayList.add(by0Var);
        }
        Object objG = oc2.g(qe2.b(), new xi0(this, arrayList, null), b62Var);
        return objG == r62.c() ? objG : m42.f6769a;
    }

    public final ArrayList<cy0> e() {
        return this.f7986a.c();
    }
}

package yn;

import com.flydigi.sdk.bluetooth.l;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import gm.c2;
import gm.h;
import gm.i2;
import gm.o;
import gm.y;
import java.util.Hashtable;
import pn.s;
import zn.z1;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a {
    public static final y A;
    public static final y B;
    public static final y C;
    public static final y D;
    public static final y E;
    public static final y F;
    public static final y G;
    public static final y H;
    public static final y I;
    public static final y J;
    public static final y K;
    public static final y L;
    public static final y M;
    public static final y N;
    public static final Hashtable O;
    public static final Hashtable P;
    public static final xn.f Q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f57390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f57391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f57392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f57393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y f57394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y f57395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y f57396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y f57397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final y f57398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final y f57399l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final y f57400m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y f57401n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final y f57402o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final y f57403p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final y f57404q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final y f57405r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final y f57406s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final y f57407t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final y f57408u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final y f57409v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final y f57410w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final y f57411x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final y f57412y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final y f57413z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Hashtable f57415b = a.j(O);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Hashtable f57414a = a.j(P);

    static {
        y yVarO = new y("2.5.4.6").O();
        f57390c = yVarO;
        y yVarO2 = new y("2.5.4.10").O();
        f57391d = yVarO2;
        y yVarO3 = new y("2.5.4.11").O();
        f57392e = yVarO3;
        y yVarO4 = new y("2.5.4.12").O();
        f57393f = yVarO4;
        y yVarO5 = new y("2.5.4.3").O();
        f57394g = yVarO5;
        f57395h = new y("2.5.4.5").O();
        y yVarO6 = new y("2.5.4.9").O();
        f57396i = yVarO6;
        y yVarO7 = new y("2.5.4.5").O();
        f57397j = yVarO7;
        y yVarO8 = new y("2.5.4.7").O();
        f57398k = yVarO8;
        y yVarO9 = new y("2.5.4.8").O();
        f57399l = yVarO9;
        y yVarO10 = new y("2.5.4.4").O();
        f57400m = yVarO10;
        y yVarO11 = new y("2.5.4.42").O();
        f57401n = yVarO11;
        y yVarO12 = new y("2.5.4.43").O();
        f57402o = yVarO12;
        y yVarO13 = new y("2.5.4.44").O();
        f57403p = yVarO13;
        y yVarO14 = new y("2.5.4.45").O();
        f57404q = yVarO14;
        y yVarO15 = new y("2.5.4.13").O();
        f57405r = yVarO15;
        y yVarO16 = new y("2.5.4.15").O();
        f57406s = yVarO16;
        y yVarO17 = new y("2.5.4.17").O();
        f57407t = yVarO17;
        y yVarO18 = new y("2.5.4.46").O();
        f57408u = yVarO18;
        y yVarO19 = new y("2.5.4.65").O();
        f57409v = yVarO19;
        y yVarO20 = new y("2.5.4.72").O();
        f57410w = yVarO20;
        y yVarO21 = new y("1.3.6.1.5.5.7.9.1").O();
        f57411x = yVarO21;
        y yVarO22 = new y("1.3.6.1.5.5.7.9.2").O();
        f57412y = yVarO22;
        y yVarO23 = new y("1.3.6.1.5.5.7.9.3").O();
        f57413z = yVarO23;
        y yVarO24 = new y("1.3.6.1.5.5.7.9.4").O();
        A = yVarO24;
        y yVarO25 = new y("1.3.6.1.5.5.7.9.5").O();
        B = yVarO25;
        y yVarO26 = new y("1.3.36.8.3.14").O();
        C = yVarO26;
        y yVarO27 = new y("2.5.4.16").O();
        D = yVarO27;
        E = new y("2.5.4.54").O();
        y yVar = z1.f59118l7;
        F = yVar;
        y yVar2 = z1.f59119m7;
        G = yVar2;
        y yVar3 = z1.f59120n7;
        H = yVar3;
        y yVar4 = s.f46849v4;
        I = yVar4;
        y yVar5 = s.f46852w4;
        J = yVar5;
        y yVar6 = s.C4;
        K = yVar6;
        L = yVar4;
        y yVar7 = new y("0.9.2342.19200300.100.1.25");
        M = yVar7;
        y yVar8 = new y("0.9.2342.19200300.100.1.1");
        N = yVar8;
        Hashtable hashtable = new Hashtable();
        O = hashtable;
        Hashtable hashtable2 = new Hashtable();
        P = hashtable2;
        hashtable.put(yVarO, "C");
        hashtable.put(yVarO2, "O");
        hashtable.put(yVarO4, i1.a.f31577d5);
        hashtable.put(yVarO3, "OU");
        hashtable.put(yVarO5, "CN");
        hashtable.put(yVarO8, "L");
        hashtable.put(yVarO9, "ST");
        hashtable.put(yVarO7, "SERIALNUMBER");
        hashtable.put(yVar4, i1.a.S4);
        hashtable.put(yVar7, "DC");
        hashtable.put(yVar8, "UID");
        hashtable.put(yVarO6, "STREET");
        hashtable.put(yVarO10, "SURNAME");
        hashtable.put(yVarO11, "GIVENNAME");
        hashtable.put(yVarO12, "INITIALS");
        hashtable.put(yVarO13, "GENERATION");
        hashtable.put(yVarO15, "DESCRIPTION");
        hashtable.put(yVarO20, "ROLE");
        hashtable.put(yVar6, "unstructuredAddress");
        hashtable.put(yVar5, "unstructuredName");
        hashtable.put(yVarO14, "UniqueIdentifier");
        hashtable.put(yVarO18, "DN");
        hashtable.put(yVarO19, "Pseudonym");
        hashtable.put(yVarO27, "PostalAddress");
        hashtable.put(yVarO26, "NameAtBirth");
        hashtable.put(yVarO24, "CountryOfCitizenship");
        hashtable.put(yVarO25, "CountryOfResidence");
        hashtable.put(yVarO23, "Gender");
        hashtable.put(yVarO22, "PlaceOfBirth");
        hashtable.put(yVarO21, "DateOfBirth");
        hashtable.put(yVarO17, "PostalCode");
        hashtable.put(yVarO16, "BusinessCategory");
        hashtable.put(yVar, "TelephoneNumber");
        hashtable.put(yVar2, "Name");
        hashtable.put(yVar3, "organizationIdentifier");
        hashtable2.put("c", yVarO);
        hashtable2.put("o", yVarO2);
        hashtable2.put("t", yVarO4);
        hashtable2.put("ou", yVarO3);
        hashtable2.put("cn", yVarO5);
        hashtable2.put(l.f16298a, yVarO8);
        hashtable2.put("st", yVarO9);
        hashtable2.put("sn", yVarO10);
        hashtable2.put("serialnumber", yVarO7);
        hashtable2.put("street", yVarO6);
        hashtable2.put("emailaddress", yVar4);
        hashtable2.put(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, yVar7);
        hashtable2.put("e", yVar4);
        hashtable2.put("uid", yVar8);
        hashtable2.put("surname", yVarO10);
        hashtable2.put("givenname", yVarO11);
        hashtable2.put("initials", yVarO12);
        hashtable2.put("generation", yVarO13);
        hashtable2.put("description", yVarO15);
        hashtable2.put("role", yVarO20);
        hashtable2.put("unstructuredaddress", yVar6);
        hashtable2.put("unstructuredname", yVar5);
        hashtable2.put("uniqueidentifier", yVarO14);
        hashtable2.put("dn", yVarO18);
        hashtable2.put("pseudonym", yVarO19);
        hashtable2.put("postaladdress", yVarO27);
        hashtable2.put("nameatbirth", yVarO26);
        hashtable2.put("countryofcitizenship", yVarO24);
        hashtable2.put("countryofresidence", yVarO25);
        hashtable2.put(UMSSOHandler.GENDER, yVarO23);
        hashtable2.put("placeofbirth", yVarO22);
        hashtable2.put("dateofbirth", yVarO21);
        hashtable2.put("postalcode", yVarO17);
        hashtable2.put("businesscategory", yVarO16);
        hashtable2.put("telephonenumber", yVar);
        hashtable2.put("name", yVar2);
        hashtable2.put("organizationidentifier", yVar3);
        Q = new c();
    }

    @Override // xn.f
    public String b(y yVar) {
        return (String) O.get(yVar);
    }

    @Override // xn.f
    public xn.c[] d(String str) {
        return d.l(str, this);
    }

    @Override // xn.f
    public y e(String str) {
        return d.g(str, this.f57414a);
    }

    @Override // xn.f
    public String[] g(y yVar) {
        return d.i(yVar, this.f57414a);
    }

    @Override // xn.f
    public String h(xn.d dVar) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z10 = true;
        for (xn.c cVar : dVar.C()) {
            if (z10) {
                z10 = false;
            } else {
                stringBuffer.append(',');
            }
            d.a(stringBuffer, cVar, this.f57415b);
        }
        return stringBuffer.toString();
    }

    @Override // yn.a
    public h k(y yVar, String str) {
        return (yVar.C(I) || yVar.C(M)) ? new c2(str) : yVar.C(f57411x) ? new o(str) : (yVar.C(f57390c) || yVar.C(f57395h) || yVar.C(f57408u) || yVar.C(F)) ? new i2(str) : super.k(yVar, str);
    }
}

package zn;

import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import gm.j2;
import gm.l2;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class w1 extends gm.w {
    public static final gm.y A;
    public static final gm.y B;
    public static final gm.y C;
    public static final gm.y C1;
    public static final gm.y C2;
    public static final gm.y D;
    public static final gm.y E7;
    public static final gm.y F7;
    public static final gm.y G7;
    public static boolean H7;
    public static final Hashtable I7;
    public static final Hashtable J7;
    public static final gm.y K0;
    public static final gm.y K1;
    public static final gm.y K2;
    public static final Hashtable K7;
    public static final Hashtable L7;
    public static final Hashtable M7;
    public static final Hashtable N7;
    public static final Boolean O7;
    public static final Boolean P7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gm.y f59023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final gm.y f59024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final gm.y f59025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final gm.y f59026k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final gm.y f59027k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final gm.y f59028k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final gm.y f59029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final gm.y f59030m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final gm.y f59031n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final gm.y f59032o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final gm.y f59033p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final gm.y f59034q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final gm.y f59035r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final gm.y f59036s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final gm.y f59037t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final gm.y f59038u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final gm.y f59039v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final gm.y f59040v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final gm.y f59041v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final gm.y f59042w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final gm.y f59043x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final gm.y f59044y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final gm.y f59045z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x1 f59046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f59047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Vector f59048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Vector f59049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.f0 f59050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f59051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59052g;

    static {
        gm.y yVar = new gm.y("2.5.4.6");
        f59023h = yVar;
        gm.y yVar2 = new gm.y("2.5.4.10");
        f59024i = yVar2;
        gm.y yVar3 = new gm.y("2.5.4.11");
        f59025j = yVar3;
        gm.y yVar4 = new gm.y("2.5.4.12");
        f59026k = yVar4;
        gm.y yVar5 = new gm.y("2.5.4.3");
        f59029l = yVar5;
        gm.y yVar6 = new gm.y("2.5.4.5");
        f59030m = yVar6;
        gm.y yVar7 = new gm.y("2.5.4.9");
        f59031n = yVar7;
        f59032o = yVar6;
        gm.y yVar8 = new gm.y("2.5.4.7");
        f59033p = yVar8;
        gm.y yVar9 = new gm.y("2.5.4.8");
        f59034q = yVar9;
        gm.y yVar10 = new gm.y("2.5.4.4");
        f59035r = yVar10;
        gm.y yVar11 = new gm.y("2.5.4.42");
        f59036s = yVar11;
        gm.y yVar12 = new gm.y("2.5.4.43");
        f59037t = yVar12;
        gm.y yVar13 = new gm.y("2.5.4.44");
        f59038u = yVar13;
        gm.y yVar14 = new gm.y("2.5.4.45");
        f59039v = yVar14;
        gm.y yVar15 = new gm.y("2.5.4.15");
        f59042w = yVar15;
        gm.y yVar16 = new gm.y("2.5.4.17");
        f59043x = yVar16;
        gm.y yVar17 = new gm.y("2.5.4.46");
        f59044y = yVar17;
        gm.y yVar18 = new gm.y("2.5.4.65");
        f59045z = yVar18;
        gm.y yVar19 = new gm.y("1.3.6.1.5.5.7.9.1");
        A = yVar19;
        gm.y yVar20 = new gm.y("1.3.6.1.5.5.7.9.2");
        B = yVar20;
        gm.y yVar21 = new gm.y("1.3.6.1.5.5.7.9.3");
        C = yVar21;
        gm.y yVar22 = new gm.y("1.3.6.1.5.5.7.9.4");
        D = yVar22;
        gm.y yVar23 = new gm.y("1.3.6.1.5.5.7.9.5");
        f59027k0 = yVar23;
        gm.y yVar24 = new gm.y("1.3.36.8.3.14");
        K0 = yVar24;
        gm.y yVar25 = new gm.y("2.5.4.16");
        f59028k1 = yVar25;
        f59040v1 = new gm.y("2.5.4.54");
        gm.y yVar26 = z1.f59118l7;
        C1 = yVar26;
        gm.y yVar27 = z1.f59119m7;
        K1 = yVar27;
        gm.y yVar28 = pn.s.f46849v4;
        f59041v2 = yVar28;
        gm.y yVar29 = pn.s.f46852w4;
        C2 = yVar29;
        gm.y yVar30 = pn.s.C4;
        K2 = yVar30;
        E7 = yVar28;
        gm.y yVar31 = new gm.y("0.9.2342.19200300.100.1.25");
        F7 = yVar31;
        gm.y yVar32 = new gm.y("0.9.2342.19200300.100.1.1");
        G7 = yVar32;
        H7 = false;
        Hashtable hashtable = new Hashtable();
        I7 = hashtable;
        Hashtable hashtable2 = new Hashtable();
        J7 = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        K7 = hashtable3;
        Hashtable hashtable4 = new Hashtable();
        L7 = hashtable4;
        M7 = hashtable;
        N7 = hashtable4;
        O7 = new Boolean(true);
        P7 = new Boolean(false);
        hashtable.put(yVar, "C");
        hashtable.put(yVar2, "O");
        hashtable.put(yVar4, i1.a.f31577d5);
        hashtable.put(yVar3, "OU");
        hashtable.put(yVar5, "CN");
        hashtable.put(yVar8, "L");
        hashtable.put(yVar9, "ST");
        hashtable.put(yVar6, "SERIALNUMBER");
        hashtable.put(yVar28, i1.a.S4);
        hashtable.put(yVar31, "DC");
        hashtable.put(yVar32, "UID");
        hashtable.put(yVar7, "STREET");
        hashtable.put(yVar10, "SURNAME");
        hashtable.put(yVar11, "GIVENNAME");
        hashtable.put(yVar12, "INITIALS");
        hashtable.put(yVar13, "GENERATION");
        hashtable.put(yVar30, "unstructuredAddress");
        hashtable.put(yVar29, "unstructuredName");
        hashtable.put(yVar14, "UniqueIdentifier");
        hashtable.put(yVar17, "DN");
        hashtable.put(yVar18, "Pseudonym");
        hashtable.put(yVar25, "PostalAddress");
        hashtable.put(yVar24, "NameAtBirth");
        hashtable.put(yVar22, "CountryOfCitizenship");
        hashtable.put(yVar23, "CountryOfResidence");
        hashtable.put(yVar21, "Gender");
        hashtable.put(yVar20, "PlaceOfBirth");
        hashtable.put(yVar19, "DateOfBirth");
        hashtable.put(yVar16, "PostalCode");
        hashtable.put(yVar15, "BusinessCategory");
        hashtable.put(yVar26, "TelephoneNumber");
        hashtable.put(yVar27, "Name");
        hashtable2.put(yVar, "C");
        hashtable2.put(yVar2, "O");
        hashtable2.put(yVar3, "OU");
        hashtable2.put(yVar5, "CN");
        hashtable2.put(yVar8, "L");
        hashtable2.put(yVar9, "ST");
        hashtable2.put(yVar7, "STREET");
        hashtable2.put(yVar31, "DC");
        hashtable2.put(yVar32, "UID");
        hashtable3.put(yVar, "C");
        hashtable3.put(yVar2, "O");
        hashtable3.put(yVar3, "OU");
        hashtable3.put(yVar5, "CN");
        hashtable3.put(yVar8, "L");
        hashtable3.put(yVar9, "ST");
        hashtable3.put(yVar7, "STREET");
        hashtable4.put("c", yVar);
        hashtable4.put("o", yVar2);
        hashtable4.put("t", yVar4);
        hashtable4.put("ou", yVar3);
        hashtable4.put("cn", yVar5);
        hashtable4.put(com.flydigi.sdk.bluetooth.l.f16298a, yVar8);
        hashtable4.put("st", yVar9);
        hashtable4.put("sn", yVar6);
        hashtable4.put("serialnumber", yVar6);
        hashtable4.put("street", yVar7);
        hashtable4.put("emailaddress", yVar28);
        hashtable4.put(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, yVar31);
        hashtable4.put("e", yVar28);
        hashtable4.put("uid", yVar32);
        hashtable4.put("surname", yVar10);
        hashtable4.put("givenname", yVar11);
        hashtable4.put("initials", yVar12);
        hashtable4.put("generation", yVar13);
        hashtable4.put("unstructuredaddress", yVar30);
        hashtable4.put("unstructuredname", yVar29);
        hashtable4.put("uniqueidentifier", yVar14);
        hashtable4.put("dn", yVar17);
        hashtable4.put("pseudonym", yVar18);
        hashtable4.put("postaladdress", yVar25);
        hashtable4.put("nameofbirth", yVar24);
        hashtable4.put("countryofcitizenship", yVar22);
        hashtable4.put("countryofresidence", yVar23);
        hashtable4.put(UMSSOHandler.GENDER, yVar21);
        hashtable4.put("placeofbirth", yVar20);
        hashtable4.put("dateofbirth", yVar19);
        hashtable4.put("postalcode", yVar16);
        hashtable4.put("businesscategory", yVar15);
        hashtable4.put("telephonenumber", yVar26);
        hashtable4.put("name", yVar27);
    }

    public w1() {
        this.f59046a = null;
        this.f59047b = new Vector();
        this.f59048c = new Vector();
        this.f59049d = new Vector();
    }

    public w1(gm.f0 f0Var) {
        Vector vector;
        this.f59046a = null;
        this.f59047b = new Vector();
        this.f59048c = new Vector();
        this.f59049d = new Vector();
        this.f59050e = f0Var;
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            gm.h0 h0VarI = gm.h0.I(((gm.h) enumerationL.nextElement()).b());
            int i10 = 0;
            while (i10 < h0VarI.size()) {
                gm.f0 f0VarJ = gm.f0.J(h0VarI.J(i10).b());
                if (f0VarJ.size() != 2) {
                    throw new IllegalArgumentException("badly sized pair");
                }
                this.f59047b.addElement(gm.y.N(f0VarJ.K(0)));
                gm.h hVarK = f0VarJ.K(1);
                if (!(hVarK instanceof gm.k0) || (hVarK instanceof gm.s0)) {
                    try {
                        this.f59048c.addElement("#" + z(jt.h.h(hVarK.b().v(gm.j.f29713a))));
                    } catch (IOException unused) {
                        throw new IllegalArgumentException("cannot encode value");
                    }
                } else {
                    String strD = ((gm.k0) hVarK).d();
                    if (strD.length() <= 0 || strD.charAt(0) != '#') {
                        vector = this.f59048c;
                    } else {
                        vector = this.f59048c;
                        strD = "\\" + strD;
                    }
                    vector.addElement(strD);
                }
                this.f59049d.addElement(i10 != 0 ? O7 : P7);
                i10++;
            }
        }
    }

    public w1(String str) {
        this(H7, L7, str);
    }

    public w1(String str, x1 x1Var) {
        this(H7, L7, str, x1Var);
    }

    public w1(Hashtable hashtable) {
        this((Vector) null, hashtable);
    }

    public w1(Vector vector, Hashtable hashtable) {
        this(vector, hashtable, new s1());
    }

    public w1(Vector vector, Hashtable hashtable, x1 x1Var) {
        this.f59046a = null;
        this.f59047b = new Vector();
        this.f59048c = new Vector();
        this.f59049d = new Vector();
        this.f59046a = x1Var;
        if (vector != null) {
            for (int i10 = 0; i10 != vector.size(); i10++) {
                this.f59047b.addElement(vector.elementAt(i10));
                this.f59049d.addElement(P7);
            }
        } else {
            Enumeration enumerationKeys = hashtable.keys();
            while (enumerationKeys.hasMoreElements()) {
                this.f59047b.addElement(enumerationKeys.nextElement());
                this.f59049d.addElement(P7);
            }
        }
        for (int i11 = 0; i11 != this.f59047b.size(); i11++) {
            gm.y yVar = (gm.y) this.f59047b.elementAt(i11);
            if (hashtable.get(yVar) == null) {
                throw new IllegalArgumentException("No attribute for object id - " + yVar.L() + " - passed to distinguished name");
            }
            this.f59048c.addElement(hashtable.get(yVar));
        }
    }

    public w1(Vector vector, Vector vector2) {
        this(vector, vector2, new s1());
    }

    public w1(Vector vector, Vector vector2, x1 x1Var) {
        this.f59046a = null;
        this.f59047b = new Vector();
        this.f59048c = new Vector();
        this.f59049d = new Vector();
        this.f59046a = x1Var;
        if (vector.size() != vector2.size()) {
            throw new IllegalArgumentException("oids vector must be same length as values.");
        }
        for (int i10 = 0; i10 < vector.size(); i10++) {
            this.f59047b.addElement(vector.elementAt(i10));
            this.f59048c.addElement(vector2.elementAt(i10));
            this.f59049d.addElement(P7);
        }
    }

    public w1(boolean z10, String str) {
        this(z10, L7, str);
    }

    public w1(boolean z10, String str, x1 x1Var) {
        this(z10, L7, str, x1Var);
    }

    public w1(boolean z10, Hashtable hashtable, String str) {
        this(z10, hashtable, str, new s1());
    }

    public w1(boolean z10, Hashtable hashtable, String str, x1 x1Var) {
        this.f59046a = null;
        this.f59047b = new Vector();
        this.f59048c = new Vector();
        this.f59049d = new Vector();
        this.f59046a = x1Var;
        y1 y1Var = new y1(str);
        while (y1Var.a()) {
            String strB = y1Var.b();
            if (strB.indexOf(43) > 0) {
                y1 y1Var2 = new y1(strB, '+');
                String strB2 = y1Var2.b();
                Boolean bool = P7;
                while (true) {
                    x(hashtable, strB2, bool);
                    if (y1Var2.a()) {
                        strB2 = y1Var2.b();
                        bool = O7;
                    }
                }
            } else {
                x(hashtable, strB, P7);
            }
        }
        if (z10) {
            Vector vector = new Vector();
            Vector vector2 = new Vector();
            Vector vector3 = new Vector();
            int i10 = 1;
            for (int i11 = 0; i11 < this.f59047b.size(); i11++) {
                if (((Boolean) this.f59049d.elementAt(i11)).booleanValue()) {
                    vector.insertElementAt(this.f59047b.elementAt(i11), i10);
                    vector2.insertElementAt(this.f59048c.elementAt(i11), i10);
                    vector3.insertElementAt(this.f59049d.elementAt(i11), i10);
                    i10++;
                } else {
                    vector.insertElementAt(this.f59047b.elementAt(i11), 0);
                    vector2.insertElementAt(this.f59048c.elementAt(i11), 0);
                    vector3.insertElementAt(this.f59049d.elementAt(i11), 0);
                    i10 = 1;
                }
            }
            this.f59047b = vector;
            this.f59048c = vector2;
            this.f59049d = vector3;
        }
    }

    public static w1 F(gm.n0 n0Var, boolean z10) {
        return G(gm.f0.I(n0Var, z10));
    }

    public static w1 G(Object obj) {
        if (obj instanceof w1) {
            return (w1) obj;
        }
        if (obj instanceof xn.d) {
            return new w1(gm.f0.J(((xn.d) obj).b()));
        }
        if (obj != null) {
            return new w1(gm.f0.J(obj));
        }
        return null;
    }

    public final String A(String str) {
        String strK = Strings.k(str.trim());
        if (strK.length() <= 0 || strK.charAt(0) != '#') {
            return strK;
        }
        gm.h hVarC = C(strK);
        return hVarC instanceof gm.k0 ? Strings.k(((gm.k0) hVarC).d().trim()) : strK;
    }

    public final gm.y B(String str, Hashtable hashtable) {
        String strTrim = str.trim();
        if (Strings.o(strTrim).startsWith("OID.")) {
            return new gm.y(strTrim.substring(4));
        }
        if (strTrim.charAt(0) >= '0' && strTrim.charAt(0) <= '9') {
            return new gm.y(strTrim);
        }
        gm.y yVar = (gm.y) hashtable.get(Strings.k(strTrim));
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalArgumentException("Unknown object id - " + strTrim + " - passed to distinguished name");
    }

    public final gm.c0 C(String str) {
        try {
            return gm.c0.D(jt.h.e(str, 1, str.length() - 1));
        } catch (IOException e10) {
            throw new IllegalStateException("unknown encoding in name: " + e10);
        }
    }

    public boolean D(Object obj, boolean z10) {
        if (!z10) {
            return equals(obj);
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w1) && !(obj instanceof gm.f0)) {
            return false;
        }
        if (b().C(((gm.h) obj).b())) {
            return true;
        }
        try {
            w1 w1VarG = G(obj);
            int size = this.f59047b.size();
            if (size != w1VarG.f59047b.size()) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (!((gm.y) this.f59047b.elementAt(i10)).C((gm.y) w1VarG.f59047b.elementAt(i10)) || !E((String) this.f59048c.elementAt(i10), (String) w1VarG.f59048c.elementAt(i10))) {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final boolean E(String str, String str2) {
        String strA = A(str);
        String strA2 = A(str2);
        return strA.equals(strA2) || K(strA).equals(K(strA2));
    }

    public Vector H() {
        Vector vector = new Vector();
        for (int i10 = 0; i10 != this.f59047b.size(); i10++) {
            vector.addElement(this.f59047b.elementAt(i10));
        }
        return vector;
    }

    public Vector I() {
        Vector vector = new Vector();
        for (int i10 = 0; i10 != this.f59048c.size(); i10++) {
            vector.addElement(this.f59048c.elementAt(i10));
        }
        return vector;
    }

    public Vector J(gm.y yVar) {
        Vector vector = new Vector();
        for (int i10 = 0; i10 != this.f59048c.size(); i10++) {
            if (this.f59047b.elementAt(i10).equals(yVar)) {
                String strSubstring = (String) this.f59048c.elementAt(i10);
                if (strSubstring.length() > 2 && strSubstring.charAt(0) == '\\' && strSubstring.charAt(1) == '#') {
                    strSubstring = strSubstring.substring(1);
                }
                vector.addElement(strSubstring);
            }
        }
        return vector;
    }

    public final String K(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char cCharAt = str.charAt(0);
            stringBuffer.append(cCharAt);
            int i10 = 1;
            while (i10 < str.length()) {
                char cCharAt2 = str.charAt(i10);
                if (cCharAt != ' ' || cCharAt2 != ' ') {
                    stringBuffer.append(cCharAt2);
                }
                i10++;
                cCharAt = cCharAt2;
            }
        }
        return stringBuffer.toString();
    }

    public String L(boolean z10, Hashtable hashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        StringBuffer stringBuffer2 = null;
        for (int i10 = 0; i10 < this.f59047b.size(); i10++) {
            if (((Boolean) this.f59049d.elementAt(i10)).booleanValue()) {
                stringBuffer2.append('+');
                y(stringBuffer2, hashtable, (gm.y) this.f59047b.elementAt(i10), (String) this.f59048c.elementAt(i10));
            } else {
                stringBuffer2 = new StringBuffer();
                y(stringBuffer2, hashtable, (gm.y) this.f59047b.elementAt(i10), (String) this.f59048c.elementAt(i10));
                vector.addElement(stringBuffer2);
            }
        }
        boolean z11 = true;
        if (z10) {
            for (int size = vector.size() - 1; size >= 0; size--) {
                if (z11) {
                    z11 = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(size).toString());
            }
        } else {
            for (int i11 = 0; i11 < vector.size(); i11++) {
                if (z11) {
                    z11 = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(i11).toString());
            }
        }
        return stringBuffer.toString();
    }

    public final String M(String str) {
        int i10;
        if (str.length() == 0 || (str.indexOf(92) < 0 && str.indexOf(34) < 0)) {
            return str.trim();
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(str.length());
        if (charArray[0] == '\\' && charArray[1] == '#') {
            i10 = 2;
            stringBuffer.append("\\#");
        } else {
            i10 = 0;
        }
        boolean z10 = false;
        int length = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (i10 != charArray.length) {
            char c10 = charArray[i10];
            if (c10 != ' ') {
                z12 = true;
            }
            if (c10 == '\"') {
                if (!z10) {
                    z11 = !z11;
                }
                z10 = false;
                i10++;
            } else {
                if (c10 == '\\' && !z10 && !z11) {
                    length = stringBuffer.length();
                    z10 = true;
                } else if (c10 == ' ' && !z10 && !z12) {
                }
                i10++;
            }
            stringBuffer.append(c10);
            z10 = false;
            i10++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && length != stringBuffer.length() - 1) {
                stringBuffer.setLength(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        j2 j2Var;
        if (this.f59050e == null) {
            gm.i iVar = new gm.i();
            gm.i iVar2 = new gm.i();
            gm.y yVar = null;
            int i10 = 0;
            while (i10 != this.f59047b.size()) {
                gm.i iVar3 = new gm.i(2);
                gm.y yVar2 = (gm.y) this.f59047b.elementAt(i10);
                iVar3.a(yVar2);
                iVar3.a(this.f59046a.c(yVar2, (String) this.f59048c.elementAt(i10)));
                if (yVar == null || ((Boolean) this.f59049d.elementAt(i10)).booleanValue()) {
                    j2Var = new j2(iVar3);
                } else {
                    iVar.a(new l2(iVar2));
                    iVar2 = new gm.i();
                    j2Var = new j2(iVar3);
                }
                iVar2.a(j2Var);
                i10++;
                yVar = yVar2;
            }
            iVar.a(new l2(iVar2));
            this.f59050e = new j2(iVar);
        }
        return this.f59050e;
    }

    @Override // gm.w
    public boolean equals(Object obj) {
        int i10;
        int i11;
        boolean z10;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w1) && !(obj instanceof gm.f0)) {
            return false;
        }
        if (b().C(((gm.h) obj).b())) {
            return true;
        }
        try {
            w1 w1VarG = G(obj);
            int size = this.f59047b.size();
            if (size != w1VarG.f59047b.size()) {
                return false;
            }
            boolean[] zArr = new boolean[size];
            int i12 = -1;
            if (this.f59047b.elementAt(0).equals(w1VarG.f59047b.elementAt(0))) {
                i12 = size;
                i10 = 0;
                i11 = 1;
            } else {
                i10 = size - 1;
                i11 = -1;
            }
            while (i10 != i12) {
                gm.y yVar = (gm.y) this.f59047b.elementAt(i10);
                String str = (String) this.f59048c.elementAt(i10);
                int i13 = 0;
                while (true) {
                    if (i13 >= size) {
                        z10 = false;
                        break;
                    }
                    if (!zArr[i13] && yVar.C((gm.y) w1VarG.f59047b.elementAt(i13)) && E(str, (String) w1VarG.f59048c.elementAt(i13))) {
                        zArr[i13] = true;
                        z10 = true;
                        break;
                    }
                    i13++;
                }
                if (!z10) {
                    return false;
                }
                i10 += i11;
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // gm.w
    public int hashCode() {
        if (this.f59051f) {
            return this.f59052g;
        }
        this.f59051f = true;
        for (int i10 = 0; i10 != this.f59047b.size(); i10++) {
            String strK = K(A((String) this.f59048c.elementAt(i10)));
            int iHashCode = this.f59052g ^ this.f59047b.elementAt(i10).hashCode();
            this.f59052g = iHashCode;
            this.f59052g = strK.hashCode() ^ iHashCode;
        }
        return this.f59052g;
    }

    public String toString() {
        return L(H7, I7);
    }

    public final void x(Hashtable hashtable, String str, Boolean bool) {
        y1 y1Var = new y1(str, '=');
        String strB = y1Var.b();
        if (!y1Var.a()) {
            throw new IllegalArgumentException("badly formatted directory string");
        }
        String strB2 = y1Var.b();
        this.f59047b.addElement(B(strB, hashtable));
        this.f59048c.addElement(M(strB2));
        this.f59049d.addElement(bool);
    }

    public final void y(StringBuffer stringBuffer, Hashtable hashtable, gm.y yVar, String str) {
        String strL = (String) hashtable.get(yVar);
        if (strL == null) {
            strL = yVar.L();
        }
        stringBuffer.append(strL);
        stringBuffer.append('=');
        int length = stringBuffer.length();
        stringBuffer.append(str);
        int length2 = stringBuffer.length();
        if (str.length() >= 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
            length += 2;
        }
        while (length < length2 && stringBuffer.charAt(length) == ' ') {
            stringBuffer.insert(length, "\\");
            length += 2;
            length2++;
        }
        while (true) {
            length2--;
            if (length2 <= length || stringBuffer.charAt(length2) != ' ') {
                break;
            } else {
                stringBuffer.insert(length2, '\\');
            }
        }
        while (length <= length2) {
            char cCharAt = stringBuffer.charAt(length);
            if (cCharAt != '\"' && cCharAt != '\\' && cCharAt != '+' && cCharAt != ',') {
                switch (cCharAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        length++;
                        break;
                }
            }
            stringBuffer.insert(length, "\\");
            length += 2;
            length2++;
        }
    }

    public final String z(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 != length; i10++) {
            cArr[i10] = (char) (bArr[i10] & 255);
        }
        return new String(cArr);
    }
}

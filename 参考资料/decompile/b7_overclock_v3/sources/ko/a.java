package ko;

import com.blankj.utilcode.util.i0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.naming.Binding;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import jo.b;
import jo.d;
import jo.e;
import org.bouncycastle.cert.dane.DANEException;

/* JADX INFO: loaded from: classes5.dex */
public class a implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f37627c = "53";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f37628a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f37629b;

    /* JADX INFO: renamed from: ko.a$a, reason: collision with other inner class name */
    public class C0427a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Hashtable f37630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37631b;

        public C0427a(Hashtable hashtable, String str) {
            this.f37630a = hashtable;
            this.f37631b = str;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        @Override // jo.d
        public List a() throws DANEException {
            ArrayList arrayList = new ArrayList();
            try {
                InitialDirContext initialDirContext = new InitialDirContext(this.f37630a);
                if (this.f37631b.indexOf("_smimecert.") > 0) {
                    Attribute attribute = initialDirContext.getAttributes(this.f37631b, new String[]{a.f37627c}).get(a.f37627c);
                    if (attribute != null) {
                        a.this.c(arrayList, this.f37631b, attribute);
                    }
                } else {
                    NamingEnumeration namingEnumerationListBindings = initialDirContext.listBindings("_smimecert." + this.f37631b);
                    while (namingEnumerationListBindings.hasMore()) {
                        DirContext dirContext = (DirContext) ((Binding) namingEnumerationListBindings.next()).getObject();
                        Attribute attribute2 = initialDirContext.getAttributes(dirContext.getNameInNamespace().substring(1, dirContext.getNameInNamespace().length() - 1), new String[]{a.f37627c}).get(a.f37627c);
                        if (attribute2 != null) {
                            String nameInNamespace = dirContext.getNameInNamespace();
                            a.this.c(arrayList, nameInNamespace.substring(1, nameInNamespace.length() - 1), attribute2);
                        }
                    }
                }
                return arrayList;
            } catch (NamingException e10) {
                throw new DANEException("Exception dealing with DNS: " + e10.getMessage(), e10);
            }
        }
    }

    @Override // jo.e
    public d a(String str) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        hashtable.put("java.naming.authoritative", this.f37629b ? "true" : "false");
        if (this.f37628a.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it2 = this.f37628a.iterator();
            while (it2.hasNext()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(i0.f11861z);
                }
                stringBuffer.append("dns://" + it2.next());
            }
            hashtable.put("java.naming.provider.url", stringBuffer.toString());
        }
        return new C0427a(hashtable, str);
    }

    public final void c(List list, String str, Attribute attribute) throws DANEException, NamingException {
        for (int i10 = 0; i10 != attribute.size(); i10++) {
            byte[] bArr = (byte[]) attribute.get(i10);
            if (b.e(bArr)) {
                try {
                    list.add(new b(str, bArr));
                } catch (IOException e10) {
                    throw new DANEException("Exception parsing entry: " + e10.getMessage(), e10);
                }
            }
        }
    }

    public a d(boolean z10) {
        this.f37629b = z10;
        return this;
    }

    public a e(String str) {
        this.f37628a.add(str);
        return this;
    }
}

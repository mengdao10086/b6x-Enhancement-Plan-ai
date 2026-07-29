package org.bouncycastle.jce.provider;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class w implements PolicyNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f45514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f45516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PolicyNode f45517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f45518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f45519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f45520g;

    public w(List list, int i10, Set set, PolicyNode policyNode, Set set2, String str, boolean z10) {
        this.f45514a = list;
        this.f45515b = i10;
        this.f45516c = set;
        this.f45517d = policyNode;
        this.f45518e = set2;
        this.f45519f = str;
        this.f45520g = z10;
    }

    public void a(w wVar) {
        this.f45514a.add(wVar);
        wVar.g(this);
    }

    public w b() {
        HashSet hashSet = new HashSet();
        Iterator it2 = this.f45516c.iterator();
        while (it2.hasNext()) {
            hashSet.add(new String((String) it2.next()));
        }
        HashSet hashSet2 = new HashSet();
        Iterator it3 = this.f45518e.iterator();
        while (it3.hasNext()) {
            hashSet2.add(new String((String) it3.next()));
        }
        w wVar = new w(new ArrayList(), this.f45515b, hashSet, null, hashSet2, new String(this.f45519f), this.f45520g);
        Iterator it4 = this.f45514a.iterator();
        while (it4.hasNext()) {
            w wVarB = ((w) it4.next()).b();
            wVarB.g(wVar);
            wVar.a(wVarB);
        }
        return wVar;
    }

    public boolean c() {
        return !this.f45514a.isEmpty();
    }

    public Object clone() {
        return b();
    }

    public void d(w wVar) {
        this.f45514a.remove(wVar);
    }

    public void e(boolean z10) {
        this.f45520g = z10;
    }

    public void f(Set set) {
        this.f45516c = set;
    }

    public void g(w wVar) {
        this.f45517d = wVar;
    }

    @Override // java.security.cert.PolicyNode
    public Iterator getChildren() {
        return this.f45514a.iterator();
    }

    @Override // java.security.cert.PolicyNode
    public int getDepth() {
        return this.f45515b;
    }

    @Override // java.security.cert.PolicyNode
    public Set getExpectedPolicies() {
        return this.f45516c;
    }

    @Override // java.security.cert.PolicyNode
    public PolicyNode getParent() {
        return this.f45517d;
    }

    @Override // java.security.cert.PolicyNode
    public Set getPolicyQualifiers() {
        return this.f45518e;
    }

    @Override // java.security.cert.PolicyNode
    public String getValidPolicy() {
        return this.f45519f;
    }

    public String h(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(this.f45519f);
        stringBuffer.append(" {\n");
        for (int i10 = 0; i10 < this.f45514a.size(); i10++) {
            stringBuffer.append(((w) this.f45514a.get(i10)).h(str + wn.a.f54751a));
        }
        stringBuffer.append(str);
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    @Override // java.security.cert.PolicyNode
    public boolean isCritical() {
        return this.f45520g;
    }

    public String toString() {
        return h("");
    }
}

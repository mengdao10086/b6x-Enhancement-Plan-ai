package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;
import org.bouncycastle.pqc.crypto.xmss.d;
import org.bouncycastle.pqc.crypto.xmss.f;
import org.bouncycastle.pqc.crypto.xmss.g;

/* JADX INFO: loaded from: classes6.dex */
public final class BDS implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient h f45810a;
    private List<XMSSNode> authenticationPath;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f45811b;
    private int index;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f45812k;
    private Map<Integer, XMSSNode> keep;
    private Map<Integer, LinkedList<XMSSNode>> retain;
    private XMSSNode root;
    private Stack<XMSSNode> stack;
    private final List<BDSTreeHash> treeHashInstances;
    private final int treeHeight;
    private boolean used;

    public BDS(BDS bds) {
        this.f45810a = new h(bds.f45810a.e());
        this.treeHeight = bds.treeHeight;
        this.f45812k = bds.f45812k;
        this.root = bds.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(bds.authenticationPath);
        this.retain = new TreeMap();
        for (Integer num : bds.retain.keySet()) {
            this.retain.put(num, (LinkedList) bds.retain.get(num).clone());
        }
        Stack<XMSSNode> stack = new Stack<>();
        this.stack = stack;
        stack.addAll(bds.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> it2 = bds.treeHashInstances.iterator();
        while (it2.hasNext()) {
            this.treeHashInstances.add(it2.next().clone());
        }
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        this.f45811b = bds.f45811b;
        this.used = bds.used;
    }

    public BDS(BDS bds, int i10, gm.y yVar) {
        this.f45810a = new h(new j(yVar));
        this.treeHeight = bds.treeHeight;
        this.f45812k = bds.f45812k;
        this.root = bds.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(bds.authenticationPath);
        this.retain = new TreeMap();
        for (Integer num : bds.retain.keySet()) {
            this.retain.put(num, (LinkedList) bds.retain.get(num).clone());
        }
        Stack<XMSSNode> stack = new Stack<>();
        this.stack = stack;
        stack.addAll(bds.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> it2 = bds.treeHashInstances.iterator();
        while (it2.hasNext()) {
            this.treeHashInstances.add(it2.next().clone());
        }
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        this.f45811b = i10;
        this.used = bds.used;
        o();
    }

    public BDS(BDS bds, gm.y yVar) {
        this.f45810a = new h(new j(yVar));
        this.treeHeight = bds.treeHeight;
        this.f45812k = bds.f45812k;
        this.root = bds.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(bds.authenticationPath);
        this.retain = new TreeMap();
        for (Integer num : bds.retain.keySet()) {
            this.retain.put(num, (LinkedList) bds.retain.get(num).clone());
        }
        Stack<XMSSNode> stack = new Stack<>();
        this.stack = stack;
        stack.addAll(bds.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> it2 = bds.treeHashInstances.iterator();
        while (it2.hasNext()) {
            this.treeHashInstances.add(it2.next().clone());
        }
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        this.f45811b = bds.f45811b;
        this.used = bds.used;
        o();
    }

    public BDS(BDS bds, byte[] bArr, byte[] bArr2, g gVar) {
        this.f45810a = new h(bds.f45810a.e());
        this.treeHeight = bds.treeHeight;
        this.f45812k = bds.f45812k;
        this.root = bds.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(bds.authenticationPath);
        this.retain = new TreeMap();
        for (Integer num : bds.retain.keySet()) {
            this.retain.put(num, (LinkedList) bds.retain.get(num).clone());
        }
        Stack<XMSSNode> stack = new Stack<>();
        this.stack = stack;
        stack.addAll(bds.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> it2 = bds.treeHashInstances.iterator();
        while (it2.hasNext()) {
            this.treeHashInstances.add(it2.next().clone());
        }
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        this.f45811b = bds.f45811b;
        this.used = false;
        n(bArr, bArr2, gVar);
    }

    public BDS(d0 d0Var, int i10, int i11) {
        this(d0Var.i(), d0Var.b(), d0Var.c(), i11);
        this.f45811b = i10;
        this.index = i11;
        this.used = true;
    }

    public BDS(d0 d0Var, byte[] bArr, byte[] bArr2, g gVar) {
        this(d0Var.i(), d0Var.b(), d0Var.c(), (1 << d0Var.b()) - 1);
        k(bArr, bArr2, gVar);
    }

    public BDS(d0 d0Var, byte[] bArr, byte[] bArr2, g gVar, int i10) {
        this(d0Var.i(), d0Var.b(), d0Var.c(), (1 << d0Var.b()) - 1);
        k(bArr, bArr2, gVar);
        while (this.index < i10) {
            n(bArr, bArr2, gVar);
            this.used = false;
        }
    }

    public BDS(h hVar, int i10, int i11, int i12) {
        this.f45810a = hVar;
        this.treeHeight = i10;
        this.f45811b = i12;
        this.f45812k = i11;
        if (i11 <= i10 && i11 >= 2) {
            int i13 = i10 - i11;
            if (i13 % 2 == 0) {
                this.authenticationPath = new ArrayList();
                this.retain = new TreeMap();
                this.stack = new Stack<>();
                this.treeHashInstances = new ArrayList();
                for (int i14 = 0; i14 < i13; i14++) {
                    this.treeHashInstances.add(new BDSTreeHash(i14));
                }
                this.keep = new TreeMap();
                this.index = 0;
                this.used = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f45811b = objectInputStream.available() != 0 ? objectInputStream.readInt() : (1 << this.treeHeight) - 1;
        int i10 = this.f45811b;
        if (i10 > (1 << this.treeHeight) - 1 || this.index > i10 + 1 || objectInputStream.available() != 0) {
            throw new IOException("inconsistent BDS data detected");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f45811b);
    }

    public List<XMSSNode> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<XMSSNode> it2 = this.authenticationPath.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }

    public final BDSTreeHash b() {
        BDSTreeHash bDSTreeHash = null;
        for (BDSTreeHash bDSTreeHash2 : this.treeHashInstances) {
            if (!bDSTreeHash2.h() && bDSTreeHash2.i() && (bDSTreeHash == null || bDSTreeHash2.b() < bDSTreeHash.b() || (bDSTreeHash2.b() == bDSTreeHash.b() && bDSTreeHash2.c() < bDSTreeHash.c()))) {
                bDSTreeHash = bDSTreeHash2;
            }
        }
        return bDSTreeHash;
    }

    public int c() {
        return this.index;
    }

    public int d() {
        return this.f45811b;
    }

    public BDS f(byte[] bArr, byte[] bArr2, g gVar) {
        return new BDS(this, bArr, bArr2, gVar);
    }

    public XMSSNode h() {
        return this.root;
    }

    public int i() {
        return this.treeHeight;
    }

    public final void k(byte[] bArr, byte[] bArr2, g gVar) {
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        f fVar = (f) new f.b().h(gVar.b()).i(gVar.c()).e();
        d dVar = (d) new d.b().h(gVar.b()).i(gVar.c()).e();
        for (int i10 = 0; i10 < (1 << this.treeHeight); i10++) {
            gVar = (g) new g.b().h(gVar.b()).i(gVar.c()).p(i10).n(gVar.f()).o(gVar.g()).g(gVar.a()).e();
            h hVar = this.f45810a;
            hVar.l(hVar.k(bArr2, gVar), bArr);
            l lVarG = this.f45810a.g(gVar);
            fVar = (f) new f.b().h(fVar.b()).i(fVar.c()).n(i10).o(fVar.g()).p(fVar.h()).g(fVar.a()).e();
            XMSSNode xMSSNodeA = b0.a(this.f45810a, lVarG, fVar);
            dVar = (d) new d.b().h(dVar.b()).i(dVar.c()).n(i10).g(dVar.a()).e();
            while (!this.stack.isEmpty() && this.stack.peek().a() == xMSSNodeA.a()) {
                int iA = i10 / (1 << xMSSNodeA.a());
                if (iA == 1) {
                    this.authenticationPath.add(xMSSNodeA);
                }
                if (iA == 3 && xMSSNodeA.a() < this.treeHeight - this.f45812k) {
                    this.treeHashInstances.get(xMSSNodeA.a()).k(xMSSNodeA);
                }
                if (iA >= 3 && (iA & 1) == 1 && xMSSNodeA.a() >= this.treeHeight - this.f45812k && xMSSNodeA.a() <= this.treeHeight - 2) {
                    if (this.retain.get(Integer.valueOf(xMSSNodeA.a())) == null) {
                        LinkedList<XMSSNode> linkedList = new LinkedList<>();
                        linkedList.add(xMSSNodeA);
                        this.retain.put(Integer.valueOf(xMSSNodeA.a()), linkedList);
                    } else {
                        this.retain.get(Integer.valueOf(xMSSNodeA.a())).add(xMSSNodeA);
                    }
                }
                d dVar2 = (d) new d.b().h(dVar.b()).i(dVar.c()).m(dVar.g()).n((dVar.h() - 1) / 2).g(dVar.a()).e();
                XMSSNode xMSSNodeB = b0.b(this.f45810a, this.stack.pop(), xMSSNodeA, dVar2);
                XMSSNode xMSSNode = new XMSSNode(xMSSNodeB.a() + 1, xMSSNodeB.b());
                dVar = (d) new d.b().h(dVar2.b()).i(dVar2.c()).m(dVar2.g() + 1).n(dVar2.h()).g(dVar2.a()).e();
                xMSSNodeA = xMSSNode;
            }
            this.stack.push(xMSSNodeA);
        }
        this.root = this.stack.pop();
    }

    public boolean l() {
        return this.used;
    }

    public void m() {
        this.used = true;
    }

    public final void n(byte[] bArr, byte[] bArr2, g gVar) {
        List<XMSSNode> list;
        XMSSNode xMSSNodeRemoveFirst;
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        if (this.used) {
            throw new IllegalStateException("index already used");
        }
        int i10 = this.index;
        if (i10 > this.f45811b - 1) {
            throw new IllegalStateException("index out of bounds");
        }
        int iC = k0.c(i10, this.treeHeight);
        if (((this.index >> (iC + 1)) & 1) == 0 && iC < this.treeHeight - 1) {
            this.keep.put(Integer.valueOf(iC), this.authenticationPath.get(iC));
        }
        f fVar = (f) new f.b().h(gVar.b()).i(gVar.c()).e();
        d dVar = (d) new d.b().h(gVar.b()).i(gVar.c()).e();
        if (iC == 0) {
            gVar = (g) new g.b().h(gVar.b()).i(gVar.c()).p(this.index).n(gVar.f()).o(gVar.g()).g(gVar.a()).e();
            h hVar = this.f45810a;
            hVar.l(hVar.k(bArr2, gVar), bArr);
            this.authenticationPath.set(0, b0.a(this.f45810a, this.f45810a.g(gVar), (f) new f.b().h(fVar.b()).i(fVar.c()).n(this.index).o(fVar.g()).p(fVar.h()).g(fVar.a()).e()));
        } else {
            int i11 = iC - 1;
            d dVar2 = (d) new d.b().h(dVar.b()).i(dVar.c()).m(i11).n(this.index >> iC).g(dVar.a()).e();
            h hVar2 = this.f45810a;
            hVar2.l(hVar2.k(bArr2, gVar), bArr);
            XMSSNode xMSSNodeB = b0.b(this.f45810a, this.authenticationPath.get(i11), this.keep.get(Integer.valueOf(i11)), dVar2);
            this.authenticationPath.set(iC, new XMSSNode(xMSSNodeB.a() + 1, xMSSNodeB.b()));
            this.keep.remove(Integer.valueOf(i11));
            for (int i12 = 0; i12 < iC; i12++) {
                if (i12 < this.treeHeight - this.f45812k) {
                    list = this.authenticationPath;
                    xMSSNodeRemoveFirst = this.treeHashInstances.get(i12).d();
                } else {
                    list = this.authenticationPath;
                    xMSSNodeRemoveFirst = this.retain.get(Integer.valueOf(i12)).removeFirst();
                }
                list.set(i12, xMSSNodeRemoveFirst);
            }
            int iMin = Math.min(iC, this.treeHeight - this.f45812k);
            for (int i13 = 0; i13 < iMin; i13++) {
                int i14 = this.index + 1 + ((1 << i13) * 3);
                if (i14 < (1 << this.treeHeight)) {
                    this.treeHashInstances.get(i13).f(i14);
                }
            }
        }
        for (int i15 = 0; i15 < ((this.treeHeight - this.f45812k) >> 1); i15++) {
            BDSTreeHash bDSTreeHashB = b();
            if (bDSTreeHashB != null) {
                bDSTreeHashB.l(this.stack, this.f45810a, bArr, bArr2, gVar);
            }
        }
        this.index++;
    }

    public final void o() {
        if (this.authenticationPath == null) {
            throw new IllegalStateException("authenticationPath == null");
        }
        if (this.retain == null) {
            throw new IllegalStateException("retain == null");
        }
        if (this.stack == null) {
            throw new IllegalStateException("stack == null");
        }
        if (this.treeHashInstances == null) {
            throw new IllegalStateException("treeHashInstances == null");
        }
        if (this.keep == null) {
            throw new IllegalStateException("keep == null");
        }
        if (!k0.n(this.treeHeight, this.index)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    public BDS p(int i10, gm.y yVar) {
        return new BDS(this, i10, yVar);
    }

    public BDS q(gm.y yVar) {
        return new BDS(this, yVar);
    }
}

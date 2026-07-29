package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;
import org.bouncycastle.pqc.crypto.xmss.d;
import org.bouncycastle.pqc.crypto.xmss.f;
import org.bouncycastle.pqc.crypto.xmss.g;

/* JADX INFO: loaded from: classes6.dex */
class BDSTreeHash implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private int height;
    private final int initialHeight;
    private int nextIndex;
    private XMSSNode tailNode;
    private boolean initialized = false;
    private boolean finished = false;

    public BDSTreeHash(int i10) {
        this.initialHeight = i10;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BDSTreeHash clone() {
        BDSTreeHash bDSTreeHash = new BDSTreeHash(this.initialHeight);
        bDSTreeHash.tailNode = this.tailNode;
        bDSTreeHash.height = this.height;
        bDSTreeHash.nextIndex = this.nextIndex;
        bDSTreeHash.initialized = this.initialized;
        bDSTreeHash.finished = this.finished;
        return bDSTreeHash;
    }

    public int b() {
        if (!this.initialized || this.finished) {
            return Integer.MAX_VALUE;
        }
        return this.height;
    }

    public int c() {
        return this.nextIndex;
    }

    public XMSSNode d() {
        return this.tailNode;
    }

    public void f(int i10) {
        this.tailNode = null;
        this.height = this.initialHeight;
        this.nextIndex = i10;
        this.initialized = true;
        this.finished = false;
    }

    public boolean h() {
        return this.finished;
    }

    public boolean i() {
        return this.initialized;
    }

    public void k(XMSSNode xMSSNode) {
        this.tailNode = xMSSNode;
        int iA = xMSSNode.a();
        this.height = iA;
        if (iA == this.initialHeight) {
            this.finished = true;
        }
    }

    public void l(Stack<XMSSNode> stack, h hVar, byte[] bArr, byte[] bArr2, g gVar) {
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        if (this.finished || !this.initialized) {
            throw new IllegalStateException("finished or not initialized");
        }
        g gVar2 = (g) new g.b().h(gVar.b()).i(gVar.c()).p(this.nextIndex).n(gVar.f()).o(gVar.g()).g(gVar.a()).e();
        f fVar = (f) new f.b().h(gVar2.b()).i(gVar2.c()).n(this.nextIndex).e();
        d dVar = (d) new d.b().h(gVar2.b()).i(gVar2.c()).n(this.nextIndex).e();
        hVar.l(hVar.k(bArr2, gVar2), bArr);
        XMSSNode xMSSNodeA = b0.a(hVar, hVar.g(gVar2), fVar);
        while (!stack.isEmpty() && stack.peek().a() == xMSSNodeA.a() && stack.peek().a() != this.initialHeight) {
            d dVar2 = (d) new d.b().h(dVar.b()).i(dVar.c()).m(dVar.g()).n((dVar.h() - 1) / 2).g(dVar.a()).e();
            XMSSNode xMSSNodeB = b0.b(hVar, stack.pop(), xMSSNodeA, dVar2);
            XMSSNode xMSSNode = new XMSSNode(xMSSNodeB.a() + 1, xMSSNodeB.b());
            dVar = (d) new d.b().h(dVar2.b()).i(dVar2.c()).m(dVar2.g() + 1).n(dVar2.h()).g(dVar2.a()).e();
            xMSSNodeA = xMSSNode;
        }
        XMSSNode xMSSNode2 = this.tailNode;
        if (xMSSNode2 == null) {
            this.tailNode = xMSSNodeA;
        } else if (xMSSNode2.a() == xMSSNodeA.a()) {
            d dVar3 = (d) new d.b().h(dVar.b()).i(dVar.c()).m(dVar.g()).n((dVar.h() - 1) / 2).g(dVar.a()).e();
            xMSSNodeA = new XMSSNode(this.tailNode.a() + 1, b0.b(hVar, this.tailNode, xMSSNodeA, dVar3).b());
            this.tailNode = xMSSNodeA;
        } else {
            stack.push(xMSSNodeA);
        }
        if (this.tailNode.a() == this.initialHeight) {
            this.finished = true;
        } else {
            this.height = xMSSNodeA.a();
            this.nextIndex++;
        }
    }
}

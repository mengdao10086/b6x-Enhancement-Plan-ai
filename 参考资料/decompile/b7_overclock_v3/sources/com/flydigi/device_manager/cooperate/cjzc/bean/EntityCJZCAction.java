package com.flydigi.device_manager.cooperate.cjzc.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class EntityCJZCAction implements Serializable {
    private int actionId;
    private String actionName;
    private int keyId;
    private int senior_keyId = -1;
    private int senior_senty = -1;
    private int senty_x;
    private int senty_y;

    public EntityCJZCAction a() {
        EntityCJZCAction entityCJZCAction = new EntityCJZCAction();
        entityCJZCAction.l(this.actionId);
        entityCJZCAction.m(this.actionName);
        entityCJZCAction.n(this.keyId);
        entityCJZCAction.q(this.senty_x);
        entityCJZCAction.r(this.senty_y);
        entityCJZCAction.o(this.senior_keyId);
        entityCJZCAction.p(this.senior_senty);
        return entityCJZCAction;
    }

    public int b() {
        return this.actionId;
    }

    public String c() {
        return this.actionName;
    }

    public int d() {
        return this.keyId;
    }

    public int f() {
        return this.senior_keyId;
    }

    public int h() {
        return this.senior_senty;
    }

    public int i() {
        return this.senty_x;
    }

    public int k() {
        return this.senty_y;
    }

    public void l(int i10) {
        this.actionId = i10;
    }

    public void m(String str) {
        this.actionName = str;
    }

    public void n(int i10) {
        this.keyId = i10;
    }

    public void o(int i10) {
        this.senior_keyId = i10;
    }

    public void p(int i10) {
        this.senior_senty = i10;
    }

    public void q(int i10) {
        this.senty_x = i10;
    }

    public void r(int i10) {
        this.senty_y = i10;
    }
}

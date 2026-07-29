package io.objectbox;

import java.io.Serializable;
import li.c;
import ni.b;

/* JADX INFO: loaded from: classes5.dex */
@c
public interface EntityInfo<T> extends Serializable {
    Property<T>[] getAllProperties();

    b<T> getCursorFactory();

    String getDbName();

    Class<T> getEntityClass();

    int getEntityId();

    String getEntityName();

    ni.c<T> getIdGetter();

    Property<T> getIdProperty();
}

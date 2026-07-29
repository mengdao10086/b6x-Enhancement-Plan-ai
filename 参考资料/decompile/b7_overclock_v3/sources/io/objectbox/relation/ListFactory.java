package io.objectbox.relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import li.b;

/* JADX INFO: loaded from: classes5.dex */
@b
public interface ListFactory extends Serializable {

    public static class ArrayListFactory implements ListFactory {
        private static final long serialVersionUID = 8247662514375611729L;

        @Override // io.objectbox.relation.ListFactory
        public <T> List<T> h0() {
            return new ArrayList();
        }
    }

    public static class CopyOnWriteArrayListFactory implements ListFactory {
        private static final long serialVersionUID = 1888039726372206411L;

        @Override // io.objectbox.relation.ListFactory
        public <T> List<T> h0() {
            return new CopyOnWriteArrayList();
        }
    }

    <T> List<T> h0();
}

package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible
@Deprecated
public abstract class TreeTraverser<T> {

    public final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        private final Queue<T> queue;

        public BreadthFirstIterator(T t10) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.queue = arrayDeque;
            arrayDeque.add(t10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T tRemove = this.queue.remove();
            Iterables.addAll(this.queue, TreeTraverser.this.children(tRemove));
            return tRemove;
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.queue.element();
        }
    }

    public final class PostOrderIterator extends AbstractIterator<T> {
        private final ArrayDeque<PostOrderNode<T>> stack;

        public PostOrderIterator(T t10) {
            ArrayDeque<PostOrderNode<T>> arrayDeque = new ArrayDeque<>();
            this.stack = arrayDeque;
            arrayDeque.addLast(expand(t10));
        }

        private PostOrderNode<T> expand(T t10) {
            return new PostOrderNode<>(t10, TreeTraverser.this.children(t10).iterator());
        }

        @Override // com.google.common.collect.AbstractIterator
        public T computeNext() {
            while (!this.stack.isEmpty()) {
                PostOrderNode<T> last = this.stack.getLast();
                if (!last.childIterator.hasNext()) {
                    this.stack.removeLast();
                    return last.root;
                }
                this.stack.addLast(expand(last.childIterator.next()));
            }
            return endOfData();
        }
    }

    public static final class PostOrderNode<T> {
        public final Iterator<T> childIterator;
        public final T root;

        public PostOrderNode(T t10, Iterator<T> it2) {
            this.root = (T) Preconditions.checkNotNull(t10);
            this.childIterator = (Iterator) Preconditions.checkNotNull(it2);
        }
    }

    public final class PreOrderIterator extends UnmodifiableIterator<T> {
        private final Deque<Iterator<T>> stack;

        public PreOrderIterator(T t10) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.stack = arrayDeque;
            arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(t10)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.stack.getLast();
            T t10 = (T) Preconditions.checkNotNull(last.next());
            if (!last.hasNext()) {
                this.stack.removeLast();
            }
            Iterator<T> it2 = TreeTraverser.this.children(t10).iterator();
            if (it2.hasNext()) {
                this.stack.addLast(it2);
            }
            return t10;
        }
    }

    @Deprecated
    public static <T> TreeTraverser<T> using(final Function<T, ? extends Iterable<T>> function) {
        Preconditions.checkNotNull(function);
        return new TreeTraverser<T>() { // from class: com.google.common.collect.TreeTraverser.1
            @Override // com.google.common.collect.TreeTraverser
            public Iterable<T> children(T t10) {
                return (Iterable) function.apply(t10);
            }
        };
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(final T t10) {
        Preconditions.checkNotNull(t10);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.4
            @Override // java.lang.Iterable
            public UnmodifiableIterator<T> iterator() {
                return new BreadthFirstIterator(t10);
            }
        };
    }

    public abstract Iterable<T> children(T t10);

    public UnmodifiableIterator<T> postOrderIterator(T t10) {
        return new PostOrderIterator(t10);
    }

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(final T t10) {
        Preconditions.checkNotNull(t10);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Iterable
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.postOrderIterator(t10);
            }
        };
    }

    public UnmodifiableIterator<T> preOrderIterator(T t10) {
        return new PreOrderIterator(t10);
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(final T t10) {
        Preconditions.checkNotNull(t10);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Iterable
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.preOrderIterator(t10);
            }
        };
    }
}

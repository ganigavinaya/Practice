package practice;

import common.NestedInteger;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

	private List<Integer> flatList;
	private Iterator<Integer> flatListIterator;
	public NestedIterator(List<NestedInteger> nestedList) {
		flatList = new ArrayList<>();
		getList(nestedList.iterator());
		flatListIterator = flatList.iterator();
	}

	private void getList(Iterator<NestedInteger> iterator) {
		while(iterator.hasNext()) {
			NestedInteger nestedInteger = iterator.next();
			if (nestedInteger.isInteger()) {
				flatList.add(nestedInteger.getInteger());
			} else {
				getList(nestedInteger.getList().iterator());
			}
		}
	}

	@Override
	public Integer next() {
		return flatListIterator.next();
	}

	@Override
	public boolean hasNext() {
		return flatListIterator.hasNext();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
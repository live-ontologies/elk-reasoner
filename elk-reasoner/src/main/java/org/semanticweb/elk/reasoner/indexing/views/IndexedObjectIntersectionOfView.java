/*
 * #%L
 * ELK Reasoner
 * 
 * $Id$
 * $HeadURL$
 * %%
 * Copyright (C) 2011 Department of Computer Science, University of Oxford
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.semanticweb.elk.reasoner.indexing.views;

import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedObjectIntersectionOf;

/**
 * Implements a view for instances of {@link IndexedClassIndexedClass}
 * 
 * @author "Yevgeny Kazakov"
 * 
 * @param <T>
 *            the type of the wrapped indexed class expression
 */
public class IndexedObjectIntersectionOfView<T extends IndexedObjectIntersectionOf>
		extends IndexedClassExpressionView<T> {

	IndexedObjectIntersectionOfView(T representative) {
		super(representative);
	}

	@Override
	public int hashCode() {
		return combinedHashCode(IndexedObjectIntersectionOfView.class,
				this.representative.getFirstConjunct(),
				this.representative.getSecondConjunct());
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof IndexedObjectIntersectionOfView<?>) {
			IndexedObjectIntersectionOfView<?> otherView = (IndexedObjectIntersectionOfView<?>) other;
			return this.representative.getFirstConjunct().equals(
					otherView.representative.getFirstConjunct())
					&& this.representative.getSecondConjunct().equals(
							otherView.representative.getSecondConjunct());
		}
		return false;
	}

}

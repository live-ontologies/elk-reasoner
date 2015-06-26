/**
 * 
 */
package org.semanticweb.elk.reasoner.saturation.tracing.inferences;

/*
 * #%L
 * ELK Reasoner
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2013 Department of Computer Science, University of Oxford
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

import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedObjectSomeValuesFrom;
import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedPropertyChain;
import org.semanticweb.elk.reasoner.saturation.IndexedContextRoot;
import org.semanticweb.elk.reasoner.saturation.conclusions.implementation.AbstractConclusion;
import org.semanticweb.elk.reasoner.saturation.conclusions.implementation.DecomposedSubsumerImpl;
import org.semanticweb.elk.reasoner.saturation.conclusions.interfaces.ForwardLink;
import org.semanticweb.elk.reasoner.saturation.conclusions.interfaces.Subsumer;
import org.semanticweb.elk.reasoner.saturation.conclusions.visitors.ConclusionVisitor;
import org.semanticweb.elk.reasoner.saturation.tracing.inferences.visitors.ClassInferenceVisitor;

/**
 * A {@link ForwardLink} that is obtained by decomposing an
 * {@link IndexedObjectSomeValuesFrom}.
 * 
 * @author "Yevgeny Kazakov"
 * 
 */
public class DecomposedExistentialForwardLink extends AbstractConclusion
		implements ForwardLink, ClassInference {

	private final IndexedObjectSomeValuesFrom existential_;

	/**
	 * 
	 */
	public DecomposedExistentialForwardLink(IndexedContextRoot root,
			IndexedObjectSomeValuesFrom subsumer) {
		super(root);
		existential_ = subsumer;
	}

	@Override
	public IndexedPropertyChain getRelation() {
		return existential_.getProperty();
	}

	@Override
	public IndexedContextRoot getTarget() {
		return IndexedObjectSomeValuesFrom.Helper.getTarget(existential_);
	}

	public Subsumer<IndexedObjectSomeValuesFrom> getExistential() {
		return new DecomposedSubsumerImpl<IndexedObjectSomeValuesFrom>(
				getInferenceContextRoot(), existential_);
	}

	@Override
	public IndexedContextRoot getInferenceContextRoot() {
		return getRoot();
	}

	@Override
	public String toString() {
		return super.toString() + " (decomposition)";
	}

	@Override
	public <I, O> O accept(ConclusionVisitor<I, O> visitor, I input) {
		return visitor.visit(this, input);
	}

	@Override
	public <I, O> O acceptTraced(ClassInferenceVisitor<I, O> visitor,
			I parameter) {
		return visitor.visit(this, parameter);
	}

}

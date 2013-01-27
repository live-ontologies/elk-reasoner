/*
 * #%L
 * ELK Reasoner
 * 
 * $Id$
 * $HeadURL$
 * %%
 * Copyright (C) 2011 - 2012 Department of Computer Science, University of Oxford
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
package org.semanticweb.elk.reasoner.indexing.hierarchy;

import org.semanticweb.elk.owl.interfaces.ElkClass;
import org.semanticweb.elk.owl.interfaces.ElkNamedIndividual;
import org.semanticweb.elk.reasoner.indexing.OntologyIndex;
import org.semanticweb.elk.reasoner.saturation.context.Context;
import org.semanticweb.elk.reasoner.saturation.rules.ChainableRule;

/**
 * An index updater that saves the changes into the {@link DifferentialIndex}
 * object, instead of immediately applying them to {@link OntologyIndex}. The
 * changes can be committed afterwards to the main {@link OntologyIndex}.
 * 
 * @author "Yevgeny Kazakov"
 * @author Pavel Klinov
 * 
 */
public class IncrementalIndexUpdater implements IndexUpdater {

	private final DifferentialIndex differentialIndex_;

	public IncrementalIndexUpdater(DifferentialIndex indexChange_) {
		this.differentialIndex_ = indexChange_;
	}

	@Override
	public void addClass(ElkClass newClass) {
		differentialIndex_.addClass(newClass);
	}

	@Override
	public void removeClass(ElkClass oldClass) {
		differentialIndex_.removeClass(oldClass);
	}

	@Override
	public void addNamedIndividual(ElkNamedIndividual newIndividual) {
	}

	@Override
	public void removeNamedIndividual(ElkNamedIndividual newIndividual) {
		differentialIndex_.removeNamedIndividual(newIndividual);
	}

	@Override
	public void add(IndexedClassExpression target, ChainableRule<Context> rule) {
		differentialIndex_.registerAddedContextRule(target, rule);
	}

	@Override
	public void remove(IndexedClassExpression target,
			ChainableRule<Context> rule) {
		differentialIndex_.registerRemovedContextRule(target, rule);
	}

	@Override
	public void add(ChainableRule<Context> rule) {
		differentialIndex_.registerAddedContextInitRule(rule);
	}

	@Override
	public void remove(ChainableRule<Context> rule) {
		differentialIndex_.registerRemovedContextInitRule(rule);
	}

	@Override
	public void add(IndexedObject object) {
		differentialIndex_.addIndexedObject(object);
	}

	@Override
	public void remove(IndexedObject object) {
		differentialIndex_.removeIndexedObject(object);
	}

	@Override
	public void addReflexiveProperty(IndexedObjectProperty property) {
		differentialIndex_.addReflexiveProperty(property);
	}

	@Override
	public void removeReflexiveProperty(IndexedObjectProperty property) {
		differentialIndex_.removeReflexiveProperty(property);

	}
}
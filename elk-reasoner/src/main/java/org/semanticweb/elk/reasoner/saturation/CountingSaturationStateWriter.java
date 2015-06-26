package org.semanticweb.elk.reasoner.saturation;

/*
 * #%L
 * ELK Reasoner
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2014 Department of Computer Science, University of Oxford
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

import org.semanticweb.elk.reasoner.saturation.conclusions.interfaces.Conclusion;
import org.semanticweb.elk.reasoner.saturation.conclusions.visitors.ConclusionCounter;
import org.semanticweb.elk.reasoner.saturation.conclusions.visitors.ConclusionVisitor;
import org.semanticweb.elk.reasoner.saturation.conclusions.visitors.CountingConclusionVisitor;
import org.semanticweb.elk.reasoner.saturation.context.Context;
import org.semanticweb.elk.reasoner.saturation.rules.ConclusionProducer;

/**
 * A {@link SaturationStateWriter} that mirrors all operations of the provided
 * internal {@link SaturationStateWriter} and additionally counts the number of
 * produced {@link Conclusion}s using a provided {@link ConclusionCounter}
 * 
 * @see ConclusionProducer#produce(Context, Conclusion)
 * @see ConclusionProducer#produce(IndexedContextRoot, Conclusion)
 * 
 * @author "Yevgeny Kazakov"
 */
public class CountingSaturationStateWriter<C extends Context> extends
		SaturationStateWriterWrap<C> {

	private final ConclusionVisitor<Void, ?> countingVisitor_;

	public CountingSaturationStateWriter(SaturationStateWriter<C> writer,
			ConclusionCounter counter) {
		super(writer);
		this.countingVisitor_ = new CountingConclusionVisitor<Void>(counter);
	}

	@Override
	public void produce(Conclusion conclusion) {
		mainWriter.produce(conclusion);
		conclusion.accept(countingVisitor_, null);
	}

}

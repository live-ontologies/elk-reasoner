package org.semanticweb.elk.reasoner.query;

/*-
 * #%L
 * ELK Reasoner Core
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2020 Department of Computer Science, University of Oxford
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

import org.liveontologies.puli.Proof;
import org.liveontologies.puli.Proofs;
import org.semanticweb.elk.owl.interfaces.ElkAxiom;
import org.semanticweb.elk.reasoner.entailments.model.Entailment;
import org.semanticweb.elk.reasoner.entailments.model.EntailmentInference;

public class UnknownQueryResult implements VerifiableQueryResult {

	private final ElkAxiom query_;

	public UnknownQueryResult(ElkAxiom query) {
		this.query_ = query;
	}

	@Override
	public ElkAxiom getQuery() {
		return query_;
	}

	@Override
	public boolean entailmentProved() throws ElkQueryException {
		return false;
	}

	@Override
	public boolean entailmentDisproved() throws ElkQueryException {
		return true;
	}

	@Override
	public Proof<EntailmentInference> getEvidence(boolean atMostOne)
			throws ElkQueryException {
		return Proofs.emptyProof();
	}

	@Override
	public Entailment getEntailment() throws ElkQueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean unlock() {
		return true;
	}

}

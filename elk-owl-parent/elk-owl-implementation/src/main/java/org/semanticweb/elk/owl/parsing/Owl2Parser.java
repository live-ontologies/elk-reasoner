/*
 * #%L
 * ELK OWL Model Implementation
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
/**
 * 
 */
package org.semanticweb.elk.owl.parsing;

import org.semanticweb.elk.owl.iris.ElkPrefix;
import org.semanticweb.elk.owl.visitors.ElkOntologyProvider;

/**
 * The base interface for OWL 2 parsers
 * 
 * @author Pavel Klinov
 * @author "Yevgeny Kazakov"
 * 
 */
public interface Owl2Parser extends ElkOntologyProvider<Owl2ParseException> {

	public void declarePrefix(ElkPrefix elkPrefix);

}

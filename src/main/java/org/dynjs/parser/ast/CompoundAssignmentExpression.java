/**
 *  Copyright 2012 Douglas Campos, and individual contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.dynjs.parser.ast;

import org.antlr.runtime.tree.Tree;
import org.dynjs.parser.CodeVisitor;
import org.dynjs.runtime.ExecutionContext;

public class CompoundAssignmentExpression extends AbstractExpression {

    private final AbstractBinaryExpression rootExpr;

    public CompoundAssignmentExpression(Tree tree, AbstractBinaryExpression rootExpr) {
        super(tree);
        this.rootExpr = rootExpr;
    }
    
    public AbstractBinaryExpression getRootExpr() {
        return this.rootExpr;
    }

    public String toString() {
        return rootExpr.getLhs() + " " + rootExpr.getOp() + "=" + rootExpr.getRhs();
    }

    @Override
    public void accept(ExecutionContext context, CodeVisitor visitor, boolean strict) {
        visitor.visit( context, this, strict);
        
    }
}

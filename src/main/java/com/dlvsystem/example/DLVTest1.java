/*
 * Copyright (c) 2020, esteban
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.dlvsystem.example;

import it.unical.mat.wrapper.*;
import it.unical.mat.dlv.*;
import it.unical.mat.dlv.program.Conjunction;
import it.unical.mat.dlv.program.Literal;
import it.unical.mat.dlv.program.Program;
import it.unical.mat.dlv.program.Query;
import it.unical.mat.dlv.program.Rule;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author esteban
 */
public class DLVTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DLVInvocationException, IOException {
        /* I create a new instance of DLVInputProgram */
        DLVInputProgram inputProgram = new DLVInputProgramImpl();

        /* I can add some file to the DLVInputProgram */
        File file1 = new File("../resources/monkey.dl");
        File file2 = new File("../resources/monkey.plan");
        inputProgram.addFile(file1.toString());
        inputProgram.addFile(file2.toString());

        /* I can specify a part of DLV program using simple strings */
        //inputProgram.addText(" A STRING ");
        /* I can specify a part of DLV program using an entire Program or an Expression */
        Program program = new Program();
        
        //program.add(new Rule(" A STRING "));
        inputProgram.includeProgram(program);
        /* I can add directly an Expression that will be added into the default program stored in the DLVInvocation */
        //inputProgram.addExpression(new Rule(" A STRING "));

    /* I create a new instance of DLVInvocation using the DLVWrapper class specifying a path for DLV executable */
    DLVInvocation invocation=DLVWrapper.getInstance(). createInvocation("E:\\Downloads\\solvers\\dlv\\dlv.mingw.exe");
    
    Query planq = new Query(new Conjunction());
//invocation.setQuery(new Query( planq));
invocation.setQuery(planq);
/* The class DLVInvocation have a method to specify the execution options by simple strings */
invocation.addOption(" -FP -N=4");

invocation.run();

    }

}

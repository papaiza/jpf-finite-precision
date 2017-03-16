package listener;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.VMListener;

public class FinitePrecisionListener extends ListenerAdapter implements VMListener{
	public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute){
		if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.FADD")){
			System.out.println("Random!");
		}
	}
}

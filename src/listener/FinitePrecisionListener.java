package listener;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.VMListener;

public class FinitePrecisionListener extends ListenerAdapter implements VMListener{
	public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute){
		if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.FADD")){
			StackFrame frame = currentThread.getModifiableTopFrame();
			
			float v1 = frame.popFloat();
			float v2 = frame.popFloat();
			
			checkFloatRoundOff(v1, v2);
		}
	}

	private void checkFloatRoundOff(float v1, float v2) {
		float val1 = v1 * (float)Math.pow(10, 16);
		float val2 = v2 * (float)Math.pow(10, 16);
		
		float valTotal = val1 + val2;
		if(valTotal >= Float.MAX_VALUE){
			System.out.println("Would result in rounding error. Too precise.");
		}
		
		System.out.println(val1);
		
		System.out.println("Random!");
	}
}

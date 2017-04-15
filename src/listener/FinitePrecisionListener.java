package listener;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.VMListener;
import gov.nasa.jpf.vm.bytecode.ArrayElementInstruction;

public class FinitePrecisionListener extends ListenerAdapter implements VMListener{
	public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute){
		
		StackFrame frame = currentThread.getModifiableTopFrame();

		
		if (instructionToExecute instanceof ArrayElementInstruction)
		{
		}
		
		if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.FADD")){
			float v1 = frame.popFloat();
			float v2 = frame.popFloat();
			FloatOperations.handleFloatAdd(v1, v2);
		}
		
		else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.IADD")){
			int val1 = frame.pop();
			int val2 = frame.pop();
			IntegerOperations.handleIntAdd(val1, val2);
		}
		else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.ISUB")){
			int val1 = frame.pop();
			int val2 = frame.pop();
			IntegerOperations.handleIntSub(val1, val2);
		}
		else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.IMUL")){
			int val1 = frame.pop();
			int val2 = frame.pop();
			IntegerOperations.handleIntMult(val1, val2);
		}
		else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.IDIV")){
			int val1 = frame.pop();
			int val2 = frame.pop();
			IntegerOperations.handleIntDiv(val1, val2);
		}
		else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.LADD")){
			long val1 = frame.popLong();
			long val2 = frame.popLong();
			LongOperations.handleLongAdd(val1, val2);
		}
		else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.LSUB")){
			long val1 = frame.popLong();
			long val2 = frame.popLong();
			LongOperations.handleLongSub(val1, val2);
		}
		else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.LMUL")){
			long val1 = frame.popLong();
			long val2 = frame.popLong();
			LongOperations.handleLongMult(val1, val2);
		}
		else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.LDIV")){
			long val1 = frame.popLong();
			long val2 = frame.popLong();
			LongOperations.handleLongDiv(val1, val2);
		}
	}
}

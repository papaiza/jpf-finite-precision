package listener;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.VMListener;

public class FinitePrecisionListener extends ListenerAdapter implements VMListener{
	
	private boolean withinMain;
	
	public FinitePrecisionListener(){
		this.withinMain = false;
	}
	
	/**
     * Checks if the just entered method is the main method.
     *
     * @param vm JPF's virtual machine.
     * @param currentThread the thread currently executing.
     * @param enteredMethod the method just entered.
     */
    public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) 
    {
	if (enteredMethod.getBaseName().contains("main"))
	{
	    this.withinMain = true;
	}
    }
	
    /**
     * Checks if the instruction being executed is a bytecode math operation
     *
     * @param vm JPF's virtual machine.
     * @param currentThread the thread currently executing.
     * @param instructionToExecute the instruction being executed
     */
	@Override
	public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute){
		
		if(this.withinMain){
			if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.FADD")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				float v1 = frame.popFloat();
				float v2 = frame.popFloat();
				FloatOperations.handleFloatAdd(v1, v2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.FSUB")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				float v1 = frame.popFloat();
				float v2 = frame.popFloat();
				FloatOperations.handleFloatSub(v1, v2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.FMUL")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				float v1 = frame.popFloat();
				float v2 = frame.popFloat();
				FloatOperations.handleFloatMult(v1, v2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.FDIV")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				float v1 = frame.popFloat();
				float v2 = frame.popFloat();
				FloatOperations.handleFloatDiv(v1, v2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.DADD")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				double v1 = frame.popDouble();
				double v2 = frame.popDouble();
				DoubleOperations.handleDoubleAdd(v1, v2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.DSUB")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				double v1 = frame.popDouble();
				double v2 = frame.popDouble();
				DoubleOperations.handleDoubleSub(v1, v2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.DMUL")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				double v1 = frame.popDouble();
				double v2 = frame.popDouble();
				DoubleOperations.handleDoubleMult(v1, v2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.DDIV")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				double v1 = frame.popDouble();
				double v2 = frame.popDouble();
				DoubleOperations.handleDoubleDiv(v1, v2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.IADD")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				int val1 = frame.pop();
				int val2 = frame.pop();
				IntegerOperations.handleIntAdd(val1, val2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.ISUB")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				int val1 = frame.pop();
				int val2 = frame.pop();
				IntegerOperations.handleIntSub(val1, val2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.IMUL")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				int val1 = frame.pop();
				int val2 = frame.pop();
				IntegerOperations.handleIntMult(val1, val2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.IDIV")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				int val1 = frame.pop();
				int val2 = frame.pop();
				IntegerOperations.handleIntDiv(val1, val2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.LADD")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				long val1 = frame.popLong();
				long val2 = frame.popLong();
				LongOperations.handleLongAdd(val1, val2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.LSUB")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				long val1 = frame.popLong();
				long val2 = frame.popLong();
				LongOperations.handleLongSub(val1, val2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.LMUL")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				long val1 = frame.popLong();
				long val2 = frame.popLong();
				LongOperations.handleLongMult(val1, val2);
			}
			else if(instructionToExecute.getClass().getName().equals("gov.nasa.jpf.jvm.bytecode.LDIV")){
				StackFrame frame = currentThread.getModifiableTopFrame();
				long val1 = frame.popLong();
				long val2 = frame.popLong();
				LongOperations.handleLongDiv(val1, val2);
			}
		}

	}
}

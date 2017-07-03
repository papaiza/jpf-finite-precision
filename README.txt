The FinitePrecisionListener is a JPF listener that detects when round off error will occur. 
The motivation for the listener is to create something that will alert the user when a highly 
precise calculation could cause a round off error, which could potentially lead to further errors in different calculations. 
The listener has also been designed to catch overflow and underflow in integer and long operations. 

Initially, I proposed to complete these milestones:
	1)	Listener can detect when a mathematical operation is being computed
	2)	Listener can detect when division by a small number is being computed.
	3)	Listener can detect when multiplication with small numbers of high precision are computed.
	4)	Listener can detect when small numbers are next to large numbers in an array, 
		which are going to be put under a summation operation. (OPTIONAL)

From the final deliverable, I have been able to achieve milestones 1, 2 and 3. I have also added much more 
features which were not promised in the proposal. I have added the ability to check for underflow and overflow in 
integer and long operations(addition, subtraction, multiplication and division). I have also been able to detect 
for potential round off errors in float and double operations(addition, subtraction, multiplication and division). 
No work has been done on milestone 4.


## HOW TO RUN
1. Download the source folder.

2. Import the project into Eclipse, IntelliJ or any other Java Editor

3. Configure the build path of the project to include JUnit 4 and JPF. Both of these jar files can be found in the folder "jars" which comes with the source code. Installing JPF is required to use this listener, so make sure to have JPF installed and working on your computer.

4. There are four example programs in the folder src/main. Please compile each of these files by running each as a java application in your choice of editor. 

5. There are four .jpf files in the src folder coinciding to each example file in the src/main folder. The classpaths are pointing to the ./bin folder, but can be changed to the user's preference. 

6. To run the jpf files, simply type "jpf <name>.jpf" in your terminal or right click on the file and hit "Verify.." if 
using the eclipse JPF plugin. One can then see in the console that some of the cases in the example can cause a round off error. 

7. The test cases can be run by running the file src/tests/TestSuite.java as a JUnit test.

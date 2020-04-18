/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
/**
 * This is the standard Visitor interface for the visitor pattern.
 * 
 * @author Brahma Dathan
 *
 */
public interface ApplianceVisitor {
	/**
	 * This is the method for catching all Appliance objects that may be
	 * added in the future.
	 * 
	 * @param item
	 *            the item to be processed
	 */
	public void visit(Appliance item);

	/**
	 * This method processes WasherDryer objects
	 * 
	 * @param book
	 *            the WasherDryer to be processed
	 */
	public void visit(WasherDryer washerdryer);

	/**
	 * The method processes Furnace objects
	 * 
	 * @param furnace
	 *            the Furnace to be processed
	 */
	public void visit(Furance furnace);
}

/**
 * The method processes Refrigerator objects
 * 
 * @param Refrigerator
 *            the Refrigerator to be processed
 */
public void visit(Refrigerator refrigerator);
}

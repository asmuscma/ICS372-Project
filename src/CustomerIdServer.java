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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Customer ID
 * 
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public class CustomerIdServer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCounter;
	private static CustomerIdServer server;

	/**
	 * Singleton constructor 
	 */
	private CustomerIdServer() {
		idCounter = 1;
	}

	/**
	 * support singleton
	 * 
	 * @return singleton object
	 */
	public static CustomerIdServer instance() {
		if (server == null) {
			return (server = new CustomerIdServer());
		} else {
			return server;
		}
	}


	/**
	 * Getter for ID
	 * @return ID of customer
	 */
	public int getId() {
		return idCounter++;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("IdServer" + idCounter);
	}


	/**
	 * Server Object
	 * @param input
	 * 		inputstream for deserialization
	 */
	public static void retrieve(ObjectInputStream input) {
		try {
			server = (CustomerIdServer) input.readObject();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception cnfe) {
			cnfe.printStackTrace();
		}
	}

	/**
	 * Write
	 * @param output
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream output)
			throws IOException {
		try {
			output.defaultWriteObject();
			output.writeObject(server);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Reads
	 * @param input
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream input)
			throws IOException, ClassNotFoundException {
		try {
			input.defaultReadObject();
			if (server == null) {
				server = (CustomerIdServer) input.readObject();
			} else {
				input.readObject();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
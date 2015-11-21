package tundra.support.exception;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-11-20 18:21:38 EST
// -----( ON-HOST: 192.168.66.129

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import permafrost.tundra.lang.ValidationException;
// --- <<IS-END-IMPORTS>> ---

public final class validation

{
	// ---( internal utility methods )---

	final static validation _instance = new validation();

	static validation _newInstance() { return new validation(); }

	static validation _cast(Object o) { return (validation)o; }

	// ---( server methods )---




	public static final void raise (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(raise)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional $message
		IDataCursor cursor = pipeline.getCursor();
		
		try {
		    throw new ValidationException(IDataUtil.getString(cursor, "$message"));
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}
}


package tundra;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-06-06 15:54:11.990
// -----( ON-HOST: -

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import permafrost.tundra.data.IDataHelper;
import permafrost.tundra.data.IDataMap;
import permafrost.tundra.lang.BooleanHelper;
import permafrost.tundra.math.BigDecimalHelper;
import permafrost.tundra.time.DurationHelper;
// --- <<IS-END-IMPORTS>> ---

public final class duration

{
	// ---( internal utility methods )---

	final static duration _instance = new duration();

	static duration _newInstance() { return new duration(); }

	static duration _cast(Object o) { return (duration)o; }

	// ---( server methods )---




	public static final void add (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(add)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:optional $operands
		// [i] field:0:optional $pattern.input {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [i] field:0:optional $pattern.output {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [o] field:0:required $duration
		IDataCursor cursor = pipeline.getCursor();

		try {
		    IData operands = IDataUtil.getIData(cursor, "$operands");
		    String inPattern = IDataUtil.getString(cursor, "$pattern.input");
		    String outPattern = IDataUtil.getString(cursor, "$pattern.output");

		    // support $duration.x and $duration.y inputs for backwards-compatibility
		    if (operands == null) {
		        String dx = IDataUtil.getString(cursor, "$duration.x");
		        String dy = IDataUtil.getString(cursor, "$duration.y");

		        IDataMap map = new IDataMap();
		        if (dx != null) map.put("$duration.x", dx);
		        if (dy != null) map.put("$duration.y", dy);
		        operands = map;
		    }

		    String result = DurationHelper.emit(DurationHelper.add(DurationHelper.normalize(IDataHelper.getLeafValues(operands), inPattern)), outPattern);

		    if (result != null) IDataUtil.put(cursor, "$duration", result);
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}



	public static final void compare (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compare)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional $duration.x
		// [i] field:0:optional $duration.y
		// [i] field:0:optional $pattern {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [o] field:0:required $lesser?
		// [o] field:0:required $equal?
		// [o] field:0:required $greater?
		// [o] field:0:required $indeterminate?
		IDataCursor cursor = pipeline.getCursor();

		try {
		    String x = IDataUtil.getString(cursor, "$duration.x");
		    String y = IDataUtil.getString(cursor, "$duration.y");
		    String pattern = IDataUtil.getString(cursor, "$pattern");

		    int comparison = DurationHelper.compare(DurationHelper.parse(x, pattern), DurationHelper.parse(y, pattern));

		    boolean lesser        = comparison == javax.xml.datatype.DatatypeConstants.LESSER;
		    boolean equal         = comparison == javax.xml.datatype.DatatypeConstants.EQUAL;
		    boolean greater       = comparison == javax.xml.datatype.DatatypeConstants.GREATER;
		    boolean indeterminate = comparison == javax.xml.datatype.DatatypeConstants.INDETERMINATE;

		    IDataUtil.put(cursor, "$lesser?", BooleanHelper.emit(lesser));
		    IDataUtil.put(cursor, "$equal?", BooleanHelper.emit(equal));
		    IDataUtil.put(cursor, "$greater?", BooleanHelper.emit(greater));
		    IDataUtil.put(cursor, "$indeterminate?", BooleanHelper.emit(indeterminate));
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}



	public static final void format (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(format)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional $duration
		// [i] field:0:optional $pattern.input {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [i] field:0:optional $pattern.output {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;}
		// [i] field:0:optional $datetime
		// [i] field:0:optional $datetime.pattern {&quot;datetime&quot;,&quot;datetime.jdbc&quot;,&quot;date&quot;,&quot;date.jdbc&quot;,&quot;time&quot;,&quot;time.jdbc&quot;,&quot;milliseconds&quot;}
		// [o] field:0:optional $duration
		IDataCursor cursor = pipeline.getCursor();

		try {
		    String duration = IDataUtil.getString(cursor, "$duration");
		    String datetime = IDataUtil.getString(cursor, "$datetime");
		    String inPattern = IDataUtil.getString(cursor, "$pattern.input");
		    String outPattern = IDataUtil.getString(cursor, "$pattern.output");
		    String datetimePattern = IDataUtil.getString(cursor, "$datetime.pattern");

		    duration = DurationHelper.format(duration, inPattern, outPattern, datetime, datetimePattern);

		    if (duration != null) IDataUtil.put(cursor, "$duration", duration);
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}



	public static final void multiply (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(multiply)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional $duration
		// [i] field:0:optional $pattern.input {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [i] field:0:optional $pattern.output {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [i] field:0:optional $datetime
		// [i] field:0:optional $datetime.pattern {&quot;datetime&quot;,&quot;datetime.jdbc&quot;,&quot;date&quot;,&quot;date.jdbc&quot;,&quot;time&quot;,&quot;time.jdbc&quot;,&quot;milliseconds&quot;}
		// [i] field:0:optional $factor
		// [o] field:0:optional $duration
		IDataCursor cursor = pipeline.getCursor();

		try {
		    String duration = IDataUtil.getString(cursor, "$duration");
		    String inPattern = IDataUtil.getString(cursor, "$pattern.input");
		    String outPattern = IDataUtil.getString(cursor, "$pattern.output");
		    String datetime = IDataUtil.getString(cursor, "$datetime");
		    String datetimePattern = IDataUtil.getString(cursor, "$datetime.pattern");
		    String factor = IDataUtil.getString(cursor, "$factor");

		    duration = DurationHelper.emit(DurationHelper.multiply(DurationHelper.parse(duration, inPattern), BigDecimalHelper.parse(factor), datetime, datetimePattern));

		    if (duration != null) IDataUtil.put(cursor, "$duration", duration);
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}



	public static final void negate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(negate)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional $duration
		// [i] field:0:optional $pattern.input {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [i] field:0:optional $pattern.output {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [o] field:0:optional $duration
		IDataCursor cursor = pipeline.getCursor();

		try {
		    String duration = IDataUtil.getString(cursor, "$duration");
		    String inPattern = IDataUtil.getString(cursor, "$pattern.input");
		    String outPattern = IDataUtil.getString(cursor, "$pattern.output");

		    duration = DurationHelper.emit(DurationHelper.negate(DurationHelper.parse(duration, inPattern)), outPattern);

		    if (duration != null) IDataUtil.put(cursor, "$duration", duration);
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}



	public static final void subtract (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(subtract)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional $duration.x
		// [i] field:0:optional $duration.y
		// [i] field:0:optional $pattern.input {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [i] field:0:optional $pattern.output {&quot;xml&quot;,&quot;milliseconds&quot;,&quot;seconds&quot;,&quot;minutes&quot;,&quot;hours&quot;,&quot;days&quot;,&quot;weeks&quot;,&quot;months&quot;,&quot;years&quot;}
		// [o] field:0:optional $duration
		IDataCursor cursor = pipeline.getCursor();

		try {
		    String x = IDataUtil.getString(cursor, "$duration.x");
		    String y = IDataUtil.getString(cursor, "$duration.y");
		    String inPattern = IDataUtil.getString(cursor, "$pattern.input");
		    String outPattern = IDataUtil.getString(cursor, "$pattern.output");

		    String result = DurationHelper.emit(DurationHelper.subtract(DurationHelper.parse(x, inPattern), DurationHelper.parse(y, inPattern)), outPattern);

		    if (result != null) IDataUtil.put(cursor, "$duration", result);
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}
}


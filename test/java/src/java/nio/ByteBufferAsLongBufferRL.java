/*
 * @(#)ByteBufferAs-X-Buffer.java	1.13 01/12/03
 *
 * Copyright 2002 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio;


class ByteBufferAsLongBufferRL			// package-private
    extends ByteBufferAsLongBufferL
{








    ByteBufferAsLongBufferRL(ByteBuffer bb) {	// package-private












	super(bb);

    }

    ByteBufferAsLongBufferRL(ByteBuffer bb,
				     int mark, int pos, int lim, int cap,
				     int off)
    {





	super(bb, mark, pos, lim, cap, off);

    }

    public LongBuffer slice() {
	int pos = this.position();
	int lim = this.limit();
	assert (pos <= lim);
	int rem = (pos <= lim ? lim - pos : 0);
	int off = (pos << 3) + offset;
	return new ByteBufferAsLongBufferRL(bb, -1, 0, rem, rem, off);
    }

    public LongBuffer duplicate() {
	return new ByteBufferAsLongBufferRL(bb,
						    this.markValue(),
						    this.position(),
						    this.limit(),
						    this.capacity(),
						    offset);
    }

    public LongBuffer asReadOnlyBuffer() {








	return duplicate();

    }

















    public LongBuffer put(long x) {




	throw new ReadOnlyBufferException();

    }

    public LongBuffer put(int i, long x) {




	throw new ReadOnlyBufferException();

    }

    public LongBuffer compact() {
















	throw new ReadOnlyBufferException();

    }

    public boolean isDirect() {
	return bb.isDirect();
    }

    public boolean isReadOnly() {
	return true;
    }







































    public ByteOrder order() {




	return ByteOrder.LITTLE_ENDIAN;

    }

}